package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage {
    protected WebDriver driver;

    private final By deleteButton = By.id("delete");
    private final By editButton = By.id("edit-contact");
    private final By returnButton = By.id("return");

    public ContactDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteContact(){
        driver.findElement(deleteButton).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickOnEditContact(){
        driver.findElement(editButton).click();
    }
}
