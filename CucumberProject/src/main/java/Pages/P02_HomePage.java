package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {
    private final By addToCartButtonLocator = By.xpath("(//button [.=\"Add to cart\"])[1]");
    private final By removeButtonLocator = By.xpath("//button [.=\"Remove\"]");
    private final By cartButtonLocator = By.className("shopping_cart_link");

    private final WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public P02_HomePage clickOnAddToCartButton() {
        Utility.clickOnElement(driver, addToCartButtonLocator);
        return new P02_HomePage(driver);
    }

    public boolean verifyVisibilityOfRemoveButton() {
        return Utility.verifyVisibilityOfElement(driver, removeButtonLocator);
    }

    public P03_CartPage clickOnCartButton() {
        Utility.clickOnElement(driver, cartButtonLocator);
        return new P03_CartPage(driver);
    }
}
