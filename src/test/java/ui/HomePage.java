package ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;
    static String url = "https://thinking-tester-contact-list.herokuapp.com/";

    private final By inputEmail = By.id("email");
    private final By inputPassword = By.id("password");
    private final By submitButton = By.id("submit");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void goTo(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.get(url);
    }
    public void loginWithCredentials(String email, String password){
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public void titleEquals(String expected){
        String title = driver.getTitle();
        assertEquals(expected, title);
    }
}
