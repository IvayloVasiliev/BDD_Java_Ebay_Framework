package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PaymentsPage extends BasePage {

    protected static Logger log = LogManager.getLogger(PaymentsPage.class);

    @FindBy(xpath = "//select[@data-test-id='qty-dropdown']")
    public WebElement quantityDropdown;
    @FindBy(xpath = "//div[@class = 'price-details']//span/span/span")
    public WebElement price;

    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    public String checkingQuantity() {
        wait.until(ExpectedConditions.visibilityOf(quantityDropdown));
        Select select = new Select(quantityDropdown);
        String selectedQuantity = select.getFirstSelectedOption().getText();
        log.info(selectedQuantity + " is selected");
        return selectedQuantity;
    }

    public String getPriceOfTwoItems() {
        String priceAsString = price.getText();
        int index = priceAsString.indexOf('$');
        String priceAsNumber = null;
        if (index != -1) {
            priceAsNumber = priceAsString.substring(index + 1);
        }
        log.info("The price for two items is: " + priceAsNumber);
        return priceAsNumber;
    }

    public String calculatedPricedForTwoItems(String priceForItem) {
        Double priceForTwoItems = Double.parseDouble(priceForItem) * 2;
        log.info("The calculated price for two items is: " + priceForTwoItems);
        return priceForTwoItems.toString();
    }
}
