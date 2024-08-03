package tests;

import models.ContactModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.AddContactSteps;
import steps.Utils;
import ui.HomePage;


public class CrudContactsTest {
    WebDriver driver;
    ContactModel contact;
    Utils utils;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.goTo();
        homePage.titleEquals("Contact List App");
        homePage.loginWithCredentials("test2024@mail.com","test12345678");
        homePage.titleEquals("My Contacts");
    }

    @Test
    void createAndGetContact(){
        AddContactSteps addContactSteps = new AddContactSteps(driver);
        addContactSteps.checkIfEmptyTable();
        contact = utils.getFakerDataContact();
        addContactSteps.addContactWithFakerData(contact);
        addContactSteps.checkContactCreated(contact);
    }

    @Test
    void editContact(){

    }

    @Test
    void deleteContact(){

    }

    @AfterEach
    public void teardown() {
        //driver.quit();
    }
}
