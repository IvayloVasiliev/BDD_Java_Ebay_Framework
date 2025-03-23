package hooks;

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
    protected WebDriver driver;
    private static Logger log = LogManager.getLogger(Hooks.class);

    private final static String chromeBrowser = "Chrome";

    @Before
    public void setupDriver(Scenario scenario){
        //String browserToUse = config().browser();
        driver = new DriverFactory().createDriverInstance("Chrome");
       // Driver.setupDriver(chromeBrowser);
        log.info("Chrome browser instantiated!!!");
    }

    @After
    public static void tearDown(Scenario scenario) {
      //  if(scenario.isFailed()) {
      //      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      //      scenario.attach(screenshot, "image/png", scenario.getName());
      //      log.info("Scenario: " + scenario.getName() + " has failed and screenshots are taken!");
      //  }
      //  log.info("Driver is quiting...");
      //  driver.quit();
    }
}
