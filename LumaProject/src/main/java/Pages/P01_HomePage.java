package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    private final By homePageLogoLocator = By.xpath("(//a //img)[1]");

    private final WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyLandingOnHomePage() {
        return Utility.checkVisibilityOfElement(driver, homePageLogoLocator);
    }
}
