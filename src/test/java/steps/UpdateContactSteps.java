package steps;

import lombok.SneakyThrows;
import models.ContactModel;
import org.openqa.selenium.WebDriver;
import ui.ContacListPage;
import ui.ContactDetailsPage;
import ui.ContactFormPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateContactSteps {
    protected WebDriver driver;
    ContactFormPage updatePage;

    public UpdateContactSteps(WebDriver driver) {
        this.driver = driver;
        updatePage = new ContactFormPage(driver);
    }

    @SneakyThrows
    public void updateContact(ContactModel contact){
        ContacListPage contacListPage = new ContacListPage(driver);
        contacListPage.clickOnFirstContact();

        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.clickOnEditContact();
        Thread.sleep(2000);
        updatePage.updateContactDataForm(contact);
        updatePage.clickOnSubmitButton();
    }

    @SneakyThrows
    public void updatedContactValidation(ContactModel contactModel){
        Thread.sleep(2000);
        assertEquals(contactModel.getFirstName(), updatePage.getFirstName());
        assertEquals(contactModel.getLastName(), updatePage.getLastName());
        assertEquals(contactModel.getPhone(), updatePage.getPhone());
    }

}
