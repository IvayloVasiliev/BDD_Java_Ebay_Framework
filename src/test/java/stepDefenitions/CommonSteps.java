package stepDefenitions;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.BasePage;
import pages.ResultPage;
import pages.SearchPage;

public class CommonSteps {
    protected TestContext context;
    protected BasePage basePage;
    protected SearchPage searchPage;
    protected ResultPage resultPage;

    public CommonSteps(TestContext context) {
        this.context = context;
        basePage = new BasePage(context.driver);
        searchPage = new SearchPage(context.driver);
        resultPage = new ResultPage(context.driver);
    }
    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String page) {
        basePage.navigateToPage(page);
    }

    @And("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        basePage.clickButton(buttonName);
    }

    @And("{string} page is open")
    public void pageIsOpen(String expectedPageName) {
        String actualPageName = basePage.isPageOpen();
        Assert.assertTrue(actualPageName.contains(expectedPageName));
    }

    @And("I select {string} from {string} dropdown")
    public void iSelectFromDropdown(String option, String dropdownName) {
        if(dropdownName.equals("Марка")){
            basePage.selectOptionFromDropdownByTextInput(option, dropdownName);
        } else {
            basePage.selectOptionFromDropdownWithLabel(option, dropdownName);
        }
    }

    @And("I check element {string} by clicking on it")
    public void iCheckElementByClickingOnIt(String elementName) {
        basePage.clickOnSpanElement(elementName);
    }

    @And("I log and print on the console all the Volkswagen Golfs with four wheel drive for sale on mobile.bg")
    public void iLogAndPrintOnTheConsoleAllTheVolkswagenGolfsWithFourWheelDriveForSaleOnMobileBg() {
        resultPage.countAndDisplayVwAds();
        resultPage.countVipAds();
    }
}
