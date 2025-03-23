package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {
    protected WebDriver driver;
    protected FluentWait wait;
    protected static Logger log = LogManager.getLogger(BasePage.class);

    private static final String basePage = "https://www.mobile.bg/";

    @FindBy(id = "user-name")
    public WebElement usernameField;
}
