import common.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.iFramePage;
import static org.testng.Assert.*;

public class iFrameTest extends Base {

    iFramePage iFrameP;

    @BeforeMethod
        // Open a new browser window for each test
    void initializeTest() {
        // Open the page for testing
        openChromeBrowser("https://ui.vision/demo/webtest/frames/");
        iFrameP = PageFactory.initElements(driver, iFramePage.class);
    }

    @AfterMethod
    void exitBrowser() {
        closeBrowser();
    }

    @AfterTest
    void exitDriver() {
        quitDriver();
    }

    @Test (priority = 3)
    void validateFrame1() {
        String actualText = iFrameP.switchToFrame1();
        String expectedText = "Frame1";
        assertEquals(actualText, expectedText, "Error: did not match");
    }

    @Test (priority = 2)
    void validateFrame2() {
        String actualText = iFrameP.switchToFrame2();
        String expectedText = "Frame2";
        assertEquals(actualText, expectedText, "Error: did not match");
    }

    @Test (priority = 3)
    void validateSwitchingToParent() {
        String actualText = iFrameP.switchToFrameThenBackToParent();
        String expectedText = "Frame Test Page";
        assertEquals(actualText, expectedText, "Error: did not match");
    }


}
