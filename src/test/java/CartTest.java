import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import static org.testng.Assert.*;

public class CartTest extends Base {

    CartPage cartPage;

    @BeforeMethod
    void initializeTest() {
        openChromeBrowser("https://www.homedepot.com/cart");
        // Initialize the web elements from the class as objects
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }

    @AfterMethod
    void exitBrowser() {
        closeBrowser();
    }

    @AfterTest
    void exitDriver() {
        quitDriver();
    }

    @Test (enabled = false)
    void closeChat() {
        cartPage.switchToAndCloseChatFrame();
    }

    @Test (priority = 1)
    void validateEmptyCartMessage() {
        String actualMessage = cartPage.checkEmptyCartMessage();
        String expectedMessage = "There’s Nothing in Here Yet";
        assertEquals(actualMessage, expectedMessage, "Error: the message is wrong");
    }

    @Test (priority = 2)
    void validateCreateAccountButton() {
        assertTrue(cartPage.createAccountButtonStatus());
    }

    @Test (priority = 3)
    void validateNumberOfLinks() {
        int actualLinkNumber = cartPage.numberOfLinks();
        int expectedLinkNumber = 164;
        assertEquals(actualLinkNumber, expectedLinkNumber, "Error: Total number of links did not match");
    }

    @Test (priority = 4)
    void validateFacebookLink() {
        String actualTitle = cartPage.clickFacebookLinkAndSwitchToIt();
        String expectedTitle = "The Home Depot | Fallon MT | Facebook";

        assertEquals(actualTitle, expectedTitle, "Error: Titles did not match");
    }

}
