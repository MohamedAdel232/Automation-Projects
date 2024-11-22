package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage {
    private final By checkoutButtonLocator = By.id("checkout");

    private final WebDriver driver;

    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_CheckoutPage clickOnCheckoutButton() {
        Utility.clickOnElement(driver, checkoutButtonLocator);
        return new P04_CheckoutPage(driver);
    }
}
