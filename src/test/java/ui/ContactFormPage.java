package ui;

import models.ContactModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactFormPage {
    protected WebDriver driver;

    private final By firstNameInput = By.id("firstName");
    private final By lastNameInput = By.id("lastName");
    private final By birthdateInput = By.id("birthdate");
    private final By emailInput = By.id("email");
    private final By phoneInput = By.id("phone");
    private final By street1Input = By.id("street1");
    private final By street2Input = By.id("street2");
    private final By cityInput = By.id("city");
    private final By stateProvinceInput = By.id("stateProvince");
    private final By postalCodeInput = By.id("postalCode");
    private final By countryInput = By.id("country");
    private final By submitButton = By.id("submit");
    private final By cancelButton = By.id("cancel");

    public ContactFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillContactDataForm(ContactModel contact){
        driver.findElement(firstNameInput).sendKeys(contact.getFirstName());
        driver.findElement(lastNameInput).sendKeys(contact.getLastName());
        driver.findElement(birthdateInput).sendKeys(contact.getBirthDate());
        driver.findElement(emailInput).sendKeys(contact.getEmail());
        driver.findElement(phoneInput).sendKeys(contact.getPhone());
        driver.findElement(street1Input).sendKeys(contact.getAddress1());
        driver.findElement(street2Input).sendKeys(contact.getAddress2());
        driver.findElement(cityInput).sendKeys(contact.getCity());
        driver.findElement(stateProvinceInput).sendKeys(contact.getStateProvince());
        driver.findElement(postalCodeInput).sendKeys(contact.getPostalCode());
        driver.findElement(countryInput).sendKeys(contact.getCountry());
    }

    public void updateContactDataForm(ContactModel contact){
        clearElements();
        fillContactDataForm(contact);
    }

    private void clearElements() {
        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        for (WebElement input : inputs) {
            input.clear();
        }
    }


    public void clickOnSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public String getFirstName(){
        return driver.findElement(firstNameInput).getText();
    }

    public String getLastName(){
        return driver.findElement(lastNameInput).getText();
    }

    public String getPhone(){
        return driver.findElement(phoneInput).getText();
    }
}
