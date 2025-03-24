package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class BasePage {
    protected WebDriver driver;
    protected FluentWait wait;
    protected static Logger log = LogManager.getLogger(BasePage.class);

    private static final String basePage = "https://www.mobile.bg/";

    @FindBy(id = "cookiescript_accept")
    public WebElement cookiesAcceptButton;
    @FindBy(xpath = "//a[text()='Търсене']")
    public WebElement searchButton;
    @FindBy(css = "input[name='model_show']")
    public WebElement modelInputField;
    @FindBy(xpath = "//a[text()='ОК']")
    public WebElement OkDropdownButton;

    protected String dropdownListOptions = "//span[text()='%s']";
    protected String buttonElement = "//a[text()='%s']";
    protected String dropdownInput = "//title[text()='%s']/..//input";

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new FluentWait(driver).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String page) {
        driver.get(basePage);
        acceptCookies();
        log.info(page + " page is open");
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton));
        cookiesAcceptButton.click();
    }

    public void clickButton(String buttonName){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(buttonElement, buttonName))));
        WebElement button = driver.findElement(By.xpath(String.format(buttonElement, buttonName)));
        highlightElement(button);
        button.click();
        log.info(buttonName +" button is clicked!");
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'background: lightGreen; border: 3px solid red;');", element);
        jse.executeScript("arguments[0].value = '';", element);
    }

    public String isPageOpen() {
        return driver.getCurrentUrl();
    }

    public void selectOptionFromDropdownByTextInput(String option, String dropdownName) {
        WebElement dropdowwnInput = driver.findElement(By.xpath(String.format(dropdownInput, dropdownName)));
        dropdowwnInput.sendKeys(option);
        List<WebElement> list = driver.findElements(By.xpath(String.format(dropdownListOptions, option)));
        WebElement element = list.get(1);
        highlightElement(element);
        element.click();
    }

    public void selectOptionFromDropdownWithLabel(String option, String dropdownName) {
        wait.until(ExpectedConditions.visibilityOf(modelInputField));
        wait.until(ExpectedConditions.elementToBeClickable(modelInputField));
        modelInputField.click();
        List<WebElement> list = driver.findElements(By.xpath(String.format(dropdownListOptions, option)));
        WebElement element = list.get(0);
        highlightElement(element);
        scrollToElementAndClick(element);
        scrollToElementAndClick(OkDropdownButton);
    }

    public void scrollToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

    public void clickOnSpanElement(String elementName) {
        WebElement element = driver.findElement(By.xpath(String.format(dropdownListOptions, elementName)));
        highlightElement(element);
        scrollToElementAndClick(element);
    }
}
