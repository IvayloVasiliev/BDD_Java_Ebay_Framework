package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunnerTest {
    @CucumberOptions(
            features = {"src/test/resources/features"},
            glue = {"stepDefinitions"},
            //plugin = {"pretty", "html:target/cucumber-reports"},
            plugin = {"pretty", "html:test/output",  "json:target/cucumber-report/cucumber-sequential.json"},
            tags = ""
    )
    public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    }
}
