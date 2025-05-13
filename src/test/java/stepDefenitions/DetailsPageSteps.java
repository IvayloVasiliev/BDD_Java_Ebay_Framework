package stepDefenitions;

import context.TestContext;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.BasePage;
import pages.DetailsPage;

public class DetailsPageSteps {
    protected TestContext context;
    protected BasePage basePage;
    protected DetailsPage detailsPage;

    public DetailsPageSteps(TestContext context) {
        this.context = context;
        basePage = new BasePage(context.driver);
        detailsPage = new DetailsPage(context.driver);
    }

    @And("I verify that the name contains {string}")
    public void iVerifyThatTheNameContains(String expectedItemName) {
        Assert.assertTrue(detailsPage.verifyNameContains().contains(expectedItemName));
    }

    @And("I verify that the price is the same as on the first page")
    public void iVerifyThatThePriceIsTheSameAsOnTheFirstPage() {
        Assert.assertTrue(detailsPage.getPriceOfItem().matches(context.price));
    }

    @And("I click on See details link")
    public void iClickOnSeeDetailsLink() {
        detailsPage.clickOnSeeDetailsLink();
    }

    @And("I check that the item can be shipped to {string}")
    public void iCheckThatTheItemCanBeShippedTo(String expectedCountry) {
        Assert.assertTrue(detailsPage.isDeliveryOptionSelected().matches(expectedCountry));
    }

    @And("I provide {string} in quantity input")
    public void iProvideInQuantityInput(String quantity) {
        detailsPage.provideQuantity(quantity);
    }

    @And("I click on {string} element")
    public void iClickOnElement(String elementName) {
        basePage.clickOnSpanElement(elementName);
    }
}
