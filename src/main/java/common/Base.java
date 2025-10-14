package common;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Base {


    // static driver outside of methods allows for usage in multiple methods and other classes
    public static WebDriver driver;

    // WEBDRIVER METHODS

    // Reusable driver opening website in Chrome browser
    public void openChromeBrowser(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    // Closes browser Window
    public void closeBrowser() {
        driver.close();
    }

    // Close driver
    public void quitDriver() {
        driver.quit();
    }

    // ELEMENT INTERACTIONS

    // Moves mouse over to specified web element
    void moveMouseTo(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Initiates right click on element
    void mouseRightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    // Open link in a new Tab // removed .build()
    void openInNewTab(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL).click(element).keyUp(Keys.LEFT_CONTROL).perform();
    }

    // DROPDOWN

    // Select item from dropdown using Index
    void dropdownIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    // Select item from dropdown using Value
    void dropdownValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // Get text from the currently selected option
    String selectText(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    // WINDOW HANDLING

    // Switches Window based on desired title
    public void switchWindow(String title) {
        String parentWindowHandle = driver.getWindowHandle(); // get parent window handle
        Set<String> allWindowHandles = driver.getWindowHandles(); // get handles for all open windows

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) { // exclude the parent window
                driver.switchTo().window(windowHandle); // swap windows
                if (driver.getTitle().equals(title)) { // keep swapping till desired window reached
                    break;
                }
            }
        }
    }

    // Switches to Parent Window based on Index
    public void switchToParentWindow() {
        Set<String> allWindowHandles = driver.getWindowHandles(); // get handles for all open windows
        List<String> allWindowHandlesList = new ArrayList<>(allWindowHandles); // Convert Set to List
        String parentWindowHandle = allWindowHandlesList.get(0); // Store parent window handle

        driver.switchTo().window(parentWindowHandle); // Switch to parent window
    }

    // Close specific window based on title and swaps back to parent
    public void closeWindow(String title) {
        String parentWindowHandle = driver.getWindowHandle(); // get parent window handle
        Set<String> allWindowHandles = driver.getWindowHandles(); // get handles for all open windows

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) { // exclude the parent window
                driver.switchTo().window(windowHandle); // swap windows
                if (driver.getTitle().equals(title)) { // keep swapping till desired window reached
                    driver.close();
                }
            }
        }
        driver.switchTo().window(parentWindowHandle);
    }

    // ALERTS

    // Alert handling with explicit waits
    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void dismissAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    public void sendKeysToAlert(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    // FRAMES

    // Switch to frame based on locator
    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    // Switch back to parent window
    public void switchToParentFrame() {
        driver.switchTo().defaultContent();
    }

    //  WAITS

    // Explicitly waits for element to be visible
    public void waitExplicitlyForVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Explicitly waits for element to be clickable
    public void waitExplicitlyForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // UTILITIES

    public void takeScreenshot(String testName) {
        // placeholder
    }

}
