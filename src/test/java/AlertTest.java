import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AlertPage;
import pageObjects.CartPage;

import static org.testng.Assert.*;


public class AlertTest extends Base {

    AlertPage alertPage;

    @BeforeMethod
    void initializeTest() {
        openChromeBrowser("https://the-internet.herokuapp.com/javascript_alerts");
        // Initialize the web elements from the class as objects
        alertPage = PageFactory.initElements(driver, AlertPage.class);
    }

    @AfterMethod
    void exitBrowser() {
        closeBrowser();
    }

    @AfterTest
    void exitDriver() {
        quitDriver();
    }

    @Test (priority = 1)
    void validateAlert() {
        String expectedText = "I am a JS Alert";
        String actualText = alertPage.testStandardAlert();
        assertEquals(actualText, expectedText, "error: did not match");
        acceptAlert();
    }

    @Test (priority = 2)
    void validateConfirmationAlert() {
        String expectedText = "I am a JS Confirm";
        String actualText = alertPage.testConfirmationAlert();
        assertEquals(actualText, expectedText, "error: did not match");
        dismissAlert();
    }
}


