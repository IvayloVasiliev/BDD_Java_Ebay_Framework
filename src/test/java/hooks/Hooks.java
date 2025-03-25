package hooks;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    private TestContext context;

    private static Logger log = LogManager.getLogger(Hooks.class);

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setupDriver(Scenario scenario){
        driver = new DriverFactory().createDriverInstance("Chrome");
        context.driver = driver;
        log.info("Chrome browser instantiated!!!");
        log.info(scenario.getName() + "test scenario is executing!!!");
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            log.info("Scenario: " + scenario.getName() + " has failed and screenshots are taken!");
        }
        log.info("Driver is quiting...");
        driver.quit();
    }
}
