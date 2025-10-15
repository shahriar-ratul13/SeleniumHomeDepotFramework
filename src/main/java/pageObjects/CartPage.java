package pageObjects;

import common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends Base {

    // WEB ELEMENTS / LOCATORS

    @FindBy (id = "spr-live-chat-frame")
    WebElement outerChatFrame;

    @FindBy (xpath = "//iframe[@title='Proactive Prompt']")
    WebElement orderHelpChat;

    @FindBy (xpath = "//button[@class='center-x-y flex-column-container center-x-y e2zpy031 css-d4pkr7 e1nedcse0']")
    WebElement closeChatXButton;

    @FindBy (css = "div[class='sui-pt-10 md:sui-pt-8 sui-leading-tight'] h2[class='sui-h2-bold sui-line-clamp-unset sui-font-normal sui-text-primary']")
    WebElement emptyCartMessage;

    @FindBy (xpath = "//button[normalize-space()='Create an Account']")
    WebElement createAccountButton;

    @FindBy (tagName = "a")
    List<WebElement> cartPageLinks;

    @FindBy (xpath = "//h2[normalize-space()='Top Savings for You']")
    WebElement topSavingsMessage;

    @FindBy (xpath = "//img[@aria-label='Home Depot on Facebook']")
    WebElement facebookLink;

    // ACTION METHODS

    public void switchToAndCloseChatFrame () {
        waitExplicitlyForVisible(orderHelpChat);
        switchToFrame(orderHelpChat);
        closeChatXButton.click();
    }

    public String checkEmptyCartMessage () {
        waitExplicitlyForVisible(emptyCartMessage);
        return emptyCartMessage.getText();
    }

    public boolean createAccountButtonStatus() {
        waitExplicitlyForClickable(createAccountButton);
        return createAccountButton.isDisplayed();
    }

    public int numberOfLinks() {
        waitExplicitlyForVisible(topSavingsMessage);
        return cartPageLinks.size();
    }

    public String clickFacebookLinkAndSwitchToIt() {
        waitExplicitlyForClickable(facebookLink);
        facebookLink.click();
        switchWindow("Facebook");

        return driver.getTitle();
    }
}
