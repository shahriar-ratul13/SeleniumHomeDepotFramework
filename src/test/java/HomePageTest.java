import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*; // static assert to avoid repeated typing

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.List;

public class HomePageTest extends Base {

    HomePage homePage;

    @BeforeMethod
    void initializeTest() {
        openChromeBrowser("https://www.homedepot.com");
        // Initialize the web elements from the class as objects
        homePage = PageFactory.initElements(driver, HomePage.class);
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
    void validateTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Home Depot";
        assertEquals(actualTitle, expectedTitle, "Error: Wrong title");
    }

    @Test (priority = 2)
    void validateSearch() {
        homePage.searchHomeDepot("Ladder");
        assertTrue(homePage.verifySearch());
    }

    @Test (priority = 3)
    void validateFooter() {
        String actualFooters = String.valueOf(homePage.storeFooterItems());
        assertEquals(actualFooters, homePage.expectedFooters);
    }

    @Test (priority = 4)
    void failValidationTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Da Home Depot";
        assertEquals(actualTitle, expectedTitle, "Error: Wrong title");
    }


//    @Test
//    void validateShopByDepartment() {
//        WebElement shopall = driver.findElement(By.xpath("//button[@aria-label='open drawer to view Shop All']//div[@class='sui-flex']//*[name()='svg']"));
//        waitExplicitlyForClickable(shopall);
//        shopall.click();
//        WebElement department = driver.findElement(By.xpath("//div[@data-testid=\"menu-item-id-55wMslXkSs72uOz4boTl75\"]/span/div[2]/span"));
//        waitExplicitlyForClickable(department);
//        department.click();
////        List<WebElement> departmentItems = driver.findElements(By.xpath("//div[@data-testid='content-menu-data']"));
//
////        for (WebElement e : departmentItems) {
////            System.out.println(e.getText());
////        }
//
//    }

}
