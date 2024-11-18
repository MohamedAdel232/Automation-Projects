package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_DeleteAccountPage {
    private final By accountDeletedTextLocator = By.xpath("//b [.=\"Account Deleted!\"]");
    private final By continueButtonLocator = By.xpath("//a [.=\"Continue\"]");
    
    private final WebDriver driver;

    public P05_DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfAccountDeletedText() {
        return Utility.checkVisibilityOfElement(driver, accountDeletedTextLocator);
    }

    public P01_HomePage clickOnContinueButton() {
        Utility.clickOnElement(driver, continueButtonLocator);
        return new P01_HomePage(driver);
    }
}
