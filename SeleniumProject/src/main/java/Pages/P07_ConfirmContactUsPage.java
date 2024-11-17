package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_ConfirmContactUsPage {
    private final WebDriver driver;

    private final By submittedSuccessfullyTextLocator = By.xpath("(// div [contains(@class, \"alert-success\")])[1]");
    private final By homePageButtonLocator = By.xpath("//a [contains(@class,\"btn-success\")]");

    public P07_ConfirmContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfSubmittedSuccessfullyText() {
        return Utility.checkVisibilityOfElement(driver, submittedSuccessfullyTextLocator);
    }

    public P01_HomePage clickOnHomeButton() {
        Utility.clickOnElement(driver, homePageButtonLocator);
        return new P01_HomePage(driver);
    }
}
