package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {
    protected static Logger log = LogManager.getLogger(SearchPage.class);
    @FindBy(xpath = "(//div[@class='s-item__title']/span)[3]")
    public WebElement itemName;
    @FindBy(xpath = "(//span[@class='s-item__price'])[3]")
    public WebElement price;
    @FindBy(xpath = "//div[@class='srp-controls__row-2']//span[@class='s-zipcode-entry__label']")
    public WebElement country;
    @FindBy(id = "gdpr-banner-accept")
    public WebElement cookiesAcceptButton;
    public SearchPage(WebDriver driver) {super(driver);}


    public String firstFoundItem() {
        wait.until(ExpectedConditions.visibilityOf(cookiesAcceptButton));
        cookiesAcceptButton.click();
        wait.until(ExpectedConditions.visibilityOf(itemName));
        String itemNameAsString = itemName.getText();
        log.info("The first found item is: " + itemNameAsString);
        return itemNameAsString;
    }

    public String isCountryVisible() {
        String countryToBeShipped = country.getText();
        log.info("The country to be shipped is: " + countryToBeShipped);
        return countryToBeShipped;
    }

    public String getItemPrice() {
        String priceAsString = price.getText();
        int index = priceAsString.indexOf('$');
        String priceAsNumbers = null;
        if (index != -1) {
            priceAsNumbers = priceAsString.substring(index + 1);
        }
        log.info("The price for item is: " + priceAsNumbers);
        return priceAsNumbers;
    }

    public void clickOnFirstItem() {
        itemName.click();
        log.info("First item is open");
    }
}
