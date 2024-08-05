package tests;

import models.ContactModel;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.*;
import ui.HomePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactsTest {
    WebDriver driver;
    ContactModel contact;
    Utils utils;
    WebSteps webSteps;
    ApiSteps apiSteps;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        webSteps = new WebSteps(driver);
        apiSteps = new ApiSteps();
        utils = new Utils();
        HomePage homePage = new HomePage(driver);
        homePage.goTo();
        homePage.titleEquals("Contact List App");
        homePage.loginWithCredentials("test2024@mail.com","test12345678");
    }

    @Test
    @Order(1)
    void createAndGetContact(){
        webSteps.checkIfEmptyTable();
        contact = utils.getFakerDataContact();
        webSteps.addContactWithFakerData(contact);
        webSteps.checkContactCreated(contact);
        apiSteps.getContact(contact);
    }

    @Test
    @Order(2)
    void editContact(){
        contact = utils.getFakerDataContact();
        webSteps.updateContact(contact);
        webSteps.updatedContactValidation(contact);
        apiSteps.getContact(contact);
    }

    @Test
    void deleteContact(){
        webSteps.deleteContact();
        webSteps.checkContactDeleted();
        apiSteps.emptyContactsList();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
