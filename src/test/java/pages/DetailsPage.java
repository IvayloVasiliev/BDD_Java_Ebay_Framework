package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DetailsPage extends BasePage {
    protected static Logger log = LogManager.getLogger(DetailsPage.class);
    @FindBy(xpath = "//h1/span")
    public WebElement itemName;
    @FindBy(xpath = "//div[@class = 'x-price-primary']/span")
    public WebElement itemPrice;
    @FindBy(xpath = "(//span[text()='See details'])[2]")
    public WebElement seeDetailsLink;
    @FindBy(id = "shCountry")
    public WebElement countryDropdown;
    @FindBy(xpath = "//span[text()='Shipping, returns, and payments']/../../..//button")
    public WebElement closeButtonOnShippingTabPopUp;
    @FindBy(id = "qtyTextBox")
    public WebElement quantityInput;

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public String verifyNameContains() {
        switchToNewTab();
        wait.until(ExpectedConditions.visibilityOf(itemName));
        String itemNameAsString = itemName.getText();
        log.info("The name is: " + itemNameAsString);
        return itemNameAsString;
    }

    public String getPriceOfItem() {
        String priceAsString = itemPrice.getText();
        int index = priceAsString.indexOf('$');
        String priceAsNumbers = null;
        if (index != -1) {
            priceAsNumbers = priceAsString.substring(index + 1);
        }
        log.info("The price of the items is: " + priceAsNumbers);
        return priceAsNumbers;
    }

    public void clickOnSeeDetailsLink() {
        seeDetailsLink.click();
        log.info("See Details link is is open");
    }

    public String isDeliveryOptionSelected() {
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        Select select = new Select(countryDropdown);
        String selectedCountry = select.getFirstSelectedOption().getText();
        log.info(selectedCountry + " is selected from Dropdown menu");
        closeButtonOnShippingTabPopUp.click();
        return selectedCountry;
    }

    public void provideQuantity(String quantity) {
        wait.until(ExpectedConditions.visibilityOf(quantityInput));
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
        log.info("Quantity " + quantity + " is provided");
    }
}
