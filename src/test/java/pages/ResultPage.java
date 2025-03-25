package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultPage extends BasePage {

    protected static Logger log = LogManager.getLogger(ResultPage.class);
    @FindBy(xpath = "//h1/ancestor::div")
    public WebElement numberOfAds;
    @FindBy(xpath = "//span[text()='Напред']")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@class='a saveSlink gray']")
    public WebElement foundPages;

    protected String vipAd = "//div[@class='item VIP ']";
    protected String topAd = "//div[@class='item TOP ']";
    protected String bestAd = "//div[@class='item BEST ']";

    public ResultPage(WebDriver driver) {super(driver);}

    public String countAndDisplayVwAds() {
        wait.until(ExpectedConditions.visibilityOf(numberOfAds));
        String numberText = numberOfAds.getText();
        String number = numberText.substring(14);
        log.info("The number of Volkswagen Golfs with four wheel drive on sale on mobile.bg is -" + number);
        System.out.println("The number of Volkswagen Golfs with four wheel drive on sale on mobile.bg is -" + number);
        return number;
    }
    public void countVipAds() {
        List<WebElement> vipAds = driver.findElements(By.xpath(vipAd));
        List<WebElement> topAds = driver.findElements(By.xpath(topAd));
        List<WebElement> bestAds = driver.findElements(By.xpath(bestAd));

        int pageNumbers = Integer.parseInt(foundPages.getText());
        for (int i = 0; i < pageNumbers; i++) {
            vipAds.addAll(driver.findElements(By.xpath(vipAd)));
            topAds.addAll(driver.findElements(By.xpath(topAd)));
            bestAds.addAll(driver.findElements(By.xpath(bestAd)));
            searchButton.click();
        }

        log.info("The number of VIP ads is - " + vipAds.size());
        log.info("The number of TOP ads is - " + topAds.size());
        log.info("The number of BEST ads is - " + bestAds.size());
        System.out.println("The number of VIP ads is - " + vipAds.size());
        System.out.println("The number of TOP ads is - " + topAds.size());
        System.out.println("The number of BEST ads is - " + bestAds.size());
    }
}
