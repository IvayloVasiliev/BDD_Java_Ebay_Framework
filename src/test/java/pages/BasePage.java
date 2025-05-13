package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    protected FluentWait wait;
    protected static Logger log = LogManager.getLogger(BasePage.class);

    private static final String basePage = "https://ebay.com/";

    @FindBy(id = "user-agreement-banner-decline")
    public WebElement cookiesAcceptButton;
    @FindBy(id = "gh-ac")
    public WebElement searchBox;
    @FindBy(id = "gh-cat")
    public WebElement dropdown;

    protected String spanElementSearchByText = "//span[text()='%s']";
    protected String aElementSearchByText = "//a[text()='%s']";

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new FluentWait(driver).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2));
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(spanElementSearchByText, buttonName))));
        WebElement button = driver.findElement(By.xpath(String.format(spanElementSearchByText, buttonName)));
        highlightElement(button);
        button.click();
        log.info(buttonName +" button is clicked!");
    }

    public void clickOnTab(String tabName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(aElementSearchByText, tabName))));
        WebElement tabElement = driver.findElement(By.xpath(String.format(aElementSearchByText, tabName)));
        highlightElement(tabElement);
        tabElement.click();
        log.info(tabName +" tab is clicked!");
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'background: lightGreen; border: 3px solid red;');", element);
        jse.executeScript("arguments[0].value = '';", element);
    }

    public String isPageOpen() {
        return driver.getCurrentUrl();
    }

    public void scrollToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

    public void clickOnSpanElement(String elementName) {
        WebElement element = driver.findElement(By.xpath(String.format(spanElementSearchByText, elementName)));
        highlightElement(element);
        scrollToElementAndClick(element);
        log.info("I click on " + elementName + " element");
    }

    public void selectOptionFromDropdownByTextInput(String option) {
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
        log.info(option + " is selected from Dropdown menu");
    }

    public void provideTextToSerchBox(String text) {
        searchBox.sendKeys(text);
        log.info(text + " is entered in search box");
    }

    public void switchToNewTab() {
        String originalTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();

        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

}
