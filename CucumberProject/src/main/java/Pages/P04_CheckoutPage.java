package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckoutPage {
    private final By firstnameLocator = By.id("first-name");
    private final By lastnameLocator = By.id("last-name");
    private final By postalCodeLocator = By.id("postal-code");
    private final By continueButtonLocator = By.id("continue");

    private final WebDriver driver;

    public P04_CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public P05_OverviewPage enterCheckoutInfo(String firstname, String lastname, String postalCode) {
        Utility.sendDataFromElement(driver, firstnameLocator, firstname);
        Utility.sendDataFromElement(driver, lastnameLocator, lastname);
        Utility.sendDataFromElement(driver, postalCodeLocator, postalCode);
        Utility.clickOnElement(driver, continueButtonLocator);
        return new P05_OverviewPage(driver);
    }
}
