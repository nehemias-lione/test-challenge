package steps;

import org.openqa.selenium.WebDriver;
import ui.ContacListPage;
import ui.ContactDetailsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteContactSteps {
    protected WebDriver driver;
    ContacListPage contacListPage;

    public DeleteContactSteps(WebDriver driver) {
        this.driver = driver;
        contacListPage = new ContacListPage(driver);
    }

    public void contact(){

        contacListPage.clickOnFirstContact();
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.deleteContact();
    }

    public void checkEmptyTable(){
        assertTrue(contacListPage.getContactList().isEmpty());
    }
}
