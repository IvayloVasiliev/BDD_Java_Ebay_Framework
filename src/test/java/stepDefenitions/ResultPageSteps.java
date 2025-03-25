package stepDefenitions;

import context.TestContext;
import io.cucumber.java.en.And;
import pages.ResultPage;

public class ResultPageSteps {
    protected TestContext context;
    protected ResultPage resultPage;

    public ResultPageSteps(TestContext context) {
        this.context = context;
        resultPage = new ResultPage(context.driver);
    }

    @And("I log and print on the console all the Volkswagen Golfs with four wheel drive for sale on mobile.bg")
    public void iLogAndPrintOnTheConsoleAllTheVolkswagenGolfsWithFourWheelDriveForSaleOnMobileBg() {
        context.vwGolfAds = resultPage.countAndDisplayVwAds();
        resultPage.countVipAds();
    }
}
