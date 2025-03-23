package factory;

import factory.helpers.ChromeCreationHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver createDriverInstance(String browser) {

        Logger log = LogManager.getLogger(DriverFactory.class);
        ListOfBrowsers browserToUse = ListOfBrowsers.valueOf(browser.toUpperCase());

        switch (browserToUse){
            case CHROME:
                driver = new ChromeCreationHelper().createDriver();
                break;
            case HEADLESS:
                log.info("There is no Headless logic implemented");
                break;
            case EDGE:
                log.info("There is no Edge logic implemented");
                break;
            default:
                log.error("There is no such browser!");
        }
        driver.manage().window().maximize();

        return driver;
    }

    public enum ListOfBrowsers {
        CHROME, HEADLESS, EDGE
    }
}
