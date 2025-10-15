package pageObjects;

import common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class iFramePage extends Base {

    @FindBy (xpath = "//frame[@src=\"frame_1.html\"]")
    WebElement frame1;

    @FindBy (xpath = "//frame[@src=\"frame_2.html\"]")
    WebElement frame2;

    @FindBy (xpath = "//b[normalize-space()='Frame Test Page']")
    WebElement parentPageText;

    @FindBy (xpath = "//div[normalize-space()='Frame1']")
    WebElement frame1Text;

    @FindBy (xpath = "//div[normalize-space()='Frame2']")
    WebElement frame2Text;


    public String switchToFrame1() {
        switchToFrame(frame1);
        return frame1Text.getText();
    }

    public String switchToFrame2() {
        switchToFrame(frame2);
        return frame2Text.getText();
    }

    public String switchToFrameThenBackToParent() {
        switchToFrame(frame2);
        switchToParentFrame();
        return parentPageText.getText();
    }
}
