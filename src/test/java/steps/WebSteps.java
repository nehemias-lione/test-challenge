package steps;

import lombok.SneakyThrows;
import models.ContactModel;
import org.openqa.selenium.WebDriver;
import ui.ContacListPage;
import ui.ContactDetailsPage;
import ui.ContactFormPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebSteps {
    protected WebDriver driver;
    ContacListPage contacListPage;
    ContactFormPage contactForm;

    public WebSteps(WebDriver driver) {
        this.driver = driver;
        this.contacListPage = new ContacListPage(driver);
        this.contactForm = new ContactFormPage(driver);
    }

    public void addContactWithFakerData(ContactModel contactModel){
        contacListPage.clickOnAddContact();
        contactForm = new ContactFormPage(driver);
        contactForm.fillContactDataForm(contactModel);
        contactForm.clickOnSubmitButton();
    }

    public void checkContactCreated(ContactModel contactModel){
        assertEquals(contacListPage.getTextNameColumn(), contactModel.getFirstName() + " " + contactModel.getLastName());
        assertEquals(contacListPage.getTextBirthdateColumn(), contactModel.getBirthDate());
        assertEquals(contacListPage.getTextEmailColumn(), contactModel.getEmail());
        assertEquals(contacListPage.getTextPhoneColumn(), contactModel.getPhone());
        assertEquals(contacListPage.getTextAddressColumn(), contactModel.getAddress1() + " " + contactModel.getAddress2());
        assertEquals(contacListPage.getTextCityProvinceColumn(), contactModel.getCity() + " " + contactModel.getStateProvince() + " " + contactModel.getPostalCode());
        assertEquals(contacListPage.getTextCountryColumn(), contactModel.getCountry());
    }

    private boolean isEmptyTable() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        int count = contacListPage.getContactList().size();
        return count > 0;
    }

    public void checkIfEmptyTable(){
        while (isEmptyTable()){
            contacListPage.clickOnFirstContact();
            ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
            contactDetailsPage.deleteContact();
        }
    }

    @SneakyThrows
    public void updateContact(ContactModel contact){
        ContacListPage contacListPage = new ContacListPage(driver);
        contacListPage.clickOnFirstContact();

        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.clickOnEditContact();
        Thread.sleep(2000);
        contactForm.updateContactDataForm(contact);
        contactForm.clickOnSubmitButton();
    }

    @SneakyThrows
    public void updatedContactValidation(ContactModel contactModel){
        Thread.sleep(2000);
        assertEquals(contactModel.getFirstName(), contactForm.getFirstName());
        assertEquals(contactModel.getLastName(), contactForm.getLastName());
        assertEquals(contactModel.getPhone(), contactForm.getPhone());
    }

    public void deleteContact(){
        contacListPage.clickOnFirstContact();
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.deleteContact();
    }

    public void checkContactDeleted(){
        assertTrue(contacListPage.getContactList().isEmpty());
    }
}
