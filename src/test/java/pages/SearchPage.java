package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {
    protected static Logger log = LogManager.getLogger(SearchPage.class);
    @FindBy(xpath = "//input[@name='marka']")
    public WebElement dropdownInput;

    public SearchPage(WebDriver driver) {super(driver);}


    public void selectOptionFromDropdownByTextInput(String option) {
        wait.until(ExpectedConditions.visibilityOf(dropdownInput));
        dropdownInput.sendKeys(option);
        List<WebElement> list = driver.findElements(By.xpath(String.format(spanElementSearchByText, option)));
        WebElement element = list.get(1);
        highlightElement(element);
        element.click();
        log.info(option + " is selected from Dropdown menu");
    }

    public void selectOptionFromDropdownWithLabel(String option) {
        wait.until(ExpectedConditions.visibilityOf(modelInputField));
        wait.until(ExpectedConditions.elementToBeClickable(modelInputField));
        modelInputField.click();
        List<WebElement> list = driver.findElements(By.xpath(String.format(spanElementSearchByText, option)));
        WebElement element = list.get(0);
        highlightElement(element);
        scrollToElementAndClick(element);
        scrollToElementAndClick(OkDropdownButton);
        log.info(option + " is selected from Dropdown menu");
    }
}
