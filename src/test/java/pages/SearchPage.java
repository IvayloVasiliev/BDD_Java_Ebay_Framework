package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.Console;

public class SearchPage extends BasePage {
    protected static Logger log = LogManager.getLogger(SearchPage.class);
    @FindBy(xpath = "//h1/ancestor::div")
    public WebElement numberOfAds;
    public SearchPage(WebDriver driver) {super(driver);}


}
