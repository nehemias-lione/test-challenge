package steps;


import models.ContactModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.ContactFormPage;
import ui.ContacListPage;
import ui.ContactDetailsPage;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddContactSteps {
    protected WebDriver driver;
    ContacListPage contacListPage;
    ContactFormPage addContactPage;
    ContactDetailsPage contactDetailsPage;

    public AddContactSteps(WebDriver driver) {
        this.driver = driver;
        contacListPage = new ContacListPage(driver);
    }

    public void addContactWithFakerData(ContactModel contactModel){
        contacListPage.clickOnAddContact();
        addContactPage = new ContactFormPage(driver);
        addContactPage.fillContactDataForm(contactModel);
        addContactPage.clickOnSubmitButton();
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
//        List<WebElement> elements = driver.findElements(contacListPage.getXpathRow());
        int count = contacListPage.getContactList().size();
        return count > 0;
    }

    public void checkIfEmptyTable(){
       while (isEmptyTable()){
           contacListPage.clickOnFirstContact();
           contactDetailsPage = new ContactDetailsPage(driver);
           contactDetailsPage.deleteContact();
       }
    }
}
