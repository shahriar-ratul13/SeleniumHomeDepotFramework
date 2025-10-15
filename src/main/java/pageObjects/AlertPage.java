package pageObjects;

import common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends Base {

    @FindBy (xpath = "//button[text()='Click for JS Alert']")
    WebElement jsAlertButton;

    @FindBy (xpath = "//button[text()='Click for JS Confirm']")
    WebElement jsConfirmAlertButton;

    public String testStandardAlert() {
        jsAlertButton.click();
        return getAlertText();
    }

    public String testConfirmationAlert() {
        jsConfirmAlertButton.click();
        return getAlertText();
    }
}
