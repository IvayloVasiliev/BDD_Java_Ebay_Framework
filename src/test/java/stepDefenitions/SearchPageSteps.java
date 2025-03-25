package stepDefenitions;

import context.TestContext;
import io.cucumber.java.en.And;
import pages.BasePage;
import pages.SearchPage;

public class SearchPageSteps {

    protected TestContext context;
    protected BasePage basePage;
    protected SearchPage searchPage;

    public SearchPageSteps(TestContext context) {
        this.context = context;
        basePage = new BasePage(context.driver);
        searchPage = new SearchPage(context.driver);
    }

    @And("I select {string} from {string} dropdown")
    public void iSelectFromDropdown(String option, String dropdownName) {
        if(dropdownName.equals("Марка")){
            searchPage.selectOptionFromDropdownByTextInput(option);
        } else if (dropdownName.equals("Модел")) {
            searchPage.selectOptionFromDropdownWithLabel(option);
        }
    }

    @And("I mark element {string} by clicking on it")
    public void iMarkElementByClickingOnIt(String elementName) {
        basePage.clickOnSpanElement(elementName);
    }
}
