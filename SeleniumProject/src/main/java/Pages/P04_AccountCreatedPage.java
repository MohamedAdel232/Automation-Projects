package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_AccountCreatedPage {
    private final By accountCreatedTextLocator = By.xpath("//b [.=\"Account Created!\"]");
    private final By continueButtonLocator = By.xpath("//a [.=\"Continue\"]");

    private final WebDriver driver;

    public P04_AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfAccountCreatedText() {
        return Utility.checkVisibilityOfElement(driver, accountCreatedTextLocator);
    }

    public P01_HomePage clickOnContinueButton() {
        Utility.clickOnElement(driver, continueButtonLocator);
        return new P01_HomePage(driver);
    }
}
