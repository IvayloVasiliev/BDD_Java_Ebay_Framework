package stepDefenitions;

import context.TestContext;
import io.cucumber.java.en.And;
import org.testng.Assert;
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
    @And("I verify that the first found item has title {string}")
    public void iVerifyThatTheFirstFoundItemHasTitle(String expectedItemName) {
        Assert.assertTrue(searchPage.firstFoundItem().contains(expectedItemName));
    }

    @And("I verify that the item could be shipped to {string}")
    public void iVerifyThatTheItemCouldBeShippedTo(String expectedCountry) {
        Assert.assertTrue(searchPage.isCountryVisible().matches(expectedCountry));
    }

    @And("I verify and store the price of the first item")
    public void iVerifyAndStoreThePriceOfTheFirstItem() {
        context.price = searchPage.getItemPrice();
    }

    @And("I click on the first item")
    public void IClickOnTheFirstItem() {
        searchPage.clickOnFirstItem();
    }
}
