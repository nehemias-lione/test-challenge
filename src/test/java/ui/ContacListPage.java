package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContacListPage {
    protected WebDriver driver;

    private final By addContactButton = By.id("add-contact");
    private final By logoutButton = By.id("logout");
    private final By contactTableRow = By.xpath("//*[@id=\"myTable\"]/tr");
    private final By nameColumTable = By.xpath("//*[@id=\"myTable\"]/tr/td[2]");
    private final By birthdateColumTable = By.xpath("//*[@id=\"myTable\"]/tr/td[3]");
    private final By emailColumTable = By.xpath("//*[@id=\"myTable\"]/tr/td[4]");
    private final By phoneColumTable = By.xpath("//*[@id=\"myTable\"]/tr/td[5]");
    private final By addressColumTable = By.xpath("//*[@id=\"myTable\"]/tr/td[6]");
    private final By cityColumTable = By.xpath("//*[@id=\"myTable\"]/tr/td[7]");
    private final By countryColumTable = By.xpath("//*[@id=\"myTable\"]/tr/td[8]");

    public ContacListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddContact(){
        driver.findElement(addContactButton).click();
    }

    public void clickOnFirstContact(){
        driver.findElement(contactTableRow).click();
    }

    public String getTextNameColumn(){
        return driver.findElement(nameColumTable).getText();
    }

    public String getTextBirthdateColumn(){
        return driver.findElement(birthdateColumTable).getText();
    }

    public String getTextEmailColumn(){
        return driver.findElement(emailColumTable).getText();
    }

    public String getTextPhoneColumn(){
        return driver.findElement(phoneColumTable).getText();
    }

    public String getTextAddressColumn(){
        return driver.findElement(addressColumTable).getText();
    }

    public String getTextCityProvinceColumn(){
        return driver.findElement(cityColumTable).getText();
    }

    public String getTextCountryColumn(){
        return driver.findElement(countryColumTable).getText();
    }

    public By getXpathRow(){
        return contactTableRow;
    }

    public List<WebElement> getContactList() {
        return driver.findElements(contactTableRow);
    }

}
