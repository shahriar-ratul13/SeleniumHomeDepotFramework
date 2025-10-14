package pageObjects;

import common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

// Store WebElements from homepage to be used in testing
public class HomePage extends Base {

    // Search Bar web element using xpath
    @FindBy (xpath = "//input[@id='typeahead-search-field-input']")
    WebElement searchBar;

    //Search button web element using css-selector
    @FindBy (css = "#typeahead-search-icon-button")
    WebElement searchButton;

    @FindBy (css = "h1[class='sui-h1-display sui-leading-none sui-uppercase sui-line-clamp-unset sui-font-normal sui-text-primary']")
    WebElement searchResult;

    @FindBy (css = "ul[class='sui-flex sui-flex-col sui-flex-wrap sui-list-none sui-justify-center']")
    List<WebElement> footerItems;

    @FindBy (xpath = "//button[@aria-label='open drawer to view Shop All']//div[@class='sui-flex']//*[name()='svg']")
    WebElement shopAllButton;

        // Likely need to use conditional to combine multiple values, otherwise keeps giving error
//    @FindBy (css = "div[id='menu-item-id-1BDh5E1pOmmWNMc7CHdLxj'] span[class='sui-h-12 sui-w-full sui-flex sui-items-center'] span")
//    WebElement shopByDepartmentMenu;

    @FindBy (xpath = "//div[@data-testid='content-menu-data']")
    List<WebElement> departmentMenuItems;


    // initiate search
    public void searchHomeDepot(String searchTerm) {
        waitExplicitlyForVisible(searchBar);
        searchBar.click();
        searchBar.sendKeys(searchTerm);
        waitExplicitlyForClickable(searchButton);
        searchButton.click();
    }

    // Check if search result is displayed
    public boolean verifySearch() {
        waitExplicitlyForVisible(searchResult);
        return searchResult.isDisplayed();
    }

    public ArrayList<String> storeFooterItems() {
        ArrayList<String> footers = new ArrayList<>();
        for (WebElement footer : footerItems) {
            footers.add(footer.getText());
        }
        return footers;
    }

    public String expectedFooters = "[Customer Service Center\n" +
            "Check Order Status\n" +
            "Pay Your Credit Card\n" +
            "Order Cancellation\n" +
            "Return Policy\n" +
            "Refund Policy\n" +
            "Shipping & Delivery\n" +
            "Product Recalls\n" +
            "My Preference Center\n" +
            "Privacy & Security Center, Specials & Offers\n" +
            "Military Discount Benefit\n" +
            "DIY Projects & Ideas\n" +
            "Truck & Tool Rental\n" +
            "Installation & Services\n" +
            "Moving Supplies & Rentals\n" +
            "Protection Plans\n" +
            "Rebate Center\n" +
            "Gift Cards\n" +
            "Catalog\n" +
            "Subscriptions, Careers\n" +
            "Corporate Information\n" +
            "Digital Newsroom\n" +
            "Home Depot Foundation\n" +
            "Investor Relations\n" +
            "Government Customers\n" +
            "Suppliers & Providers\n" +
            "Affiliate Program\n" +
            "Eco Actions\n" +
            "Corporate Responsibility\n" +
            "Home Depot Licensing Information]";

    // Get List of Department menu items
//    public void

}
