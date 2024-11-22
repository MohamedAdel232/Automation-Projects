package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_OverviewPage {
    private final By finishButtonLocator = By.id("finish");

    private final WebDriver driver;

    public P05_OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public P06_FinishPage clickOnFinishButton() {
        Utility.clickOnElement(driver, finishButtonLocator);
        return new P06_FinishPage(driver);
    }
}
