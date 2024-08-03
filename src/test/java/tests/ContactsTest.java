package tests;

import models.ContactModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.AddContactSteps;
import steps.DeleteContactSteps;
import steps.UpdateContactSteps;
import steps.Utils;
import ui.HomePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactsTest {
    static WebDriver driver;
    ContactModel contact;
    static Utils utils;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        utils = new Utils();
        HomePage homePage = new HomePage(driver);
        homePage.goTo();
        homePage.titleEquals("Contact List App");
        homePage.loginWithCredentials("test2024@mail.com","test12345678");
    }

    @Test
    @Order(1)
    void createAndGetContact(){
        AddContactSteps add = new AddContactSteps(driver);
        add.checkIfEmptyTable();
        contact = utils.getFakerDataContact();
        add.addContactWithFakerData(contact);
        add.checkContactCreated(contact);
    }

    @Test
    @Order(2)
    void editContact(){
        UpdateContactSteps update = new UpdateContactSteps(driver);
        contact = utils.getFakerDataContact();
        update.updateContact(contact);
        update.updatedContactValidation(contact);
    }

    @Test
    void deleteContact(){
        DeleteContactSteps delete = new DeleteContactSteps(driver);
        delete.contact();
        delete.checkEmptyTable();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
