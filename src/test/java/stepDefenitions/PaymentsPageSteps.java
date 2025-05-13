package stepDefenitions;

import context.TestContext;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.BasePage;
import pages.PaymentsPage;

public class PaymentsPageSteps {
    protected TestContext context;
    protected BasePage basePage;
    protected PaymentsPage paymentsPage;

    public PaymentsPageSteps(TestContext context) {
        this.context = context;
        basePage = new BasePage(context.driver);
        paymentsPage = new PaymentsPage(context.driver);
    }

    @And("I verify that quantity in quantity drop down list is {string}")
    public void iVerifyThatQuantityInQuantityDropDownListIs(String expectedQuantity) {
        Assert.assertTrue(paymentsPage.checkingQuantity().matches(expectedQuantity));
    }

    @And("I verify that the price is displayed for two items")
    public void iVerifyThatThePriceIsDisplayedForTwoItems() {
       String displayedPriceForTwoItems = paymentsPage.getPriceOfTwoItems();
        Assert.assertTrue(paymentsPage.calculatedPricedForTwoItems(context.price).matches(displayedPriceForTwoItems));
    }
}
