package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P10_ProductOneDetailsPage {
    private final By productInformationLocator = By.className("product-information");
    private final By productQuantityLocator = By.id("quantity");
    private final By addToCartButtonLocator = By.xpath("//button [@type=\"button\"]");
    private final By continueShoppingButtonLocator = By.xpath("//button [.=\"Continue Shopping\"]");
    private final By cartButtonLocator = By.xpath("(//a [@href=\"/view_cart\"])[1]");

    private final WebDriver driver;

    public P10_ProductOneDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkVisibilityOfProductInformation() {
        return Utility.checkVisibilityOfElement(driver, productInformationLocator);
    }

    public P10_ProductOneDetailsPage addQuantity(String quantity) {
        driver.findElement(productQuantityLocator).clear();
        Utility.sendDataToElement(driver, productQuantityLocator, quantity);
        return this;
    }

    public P10_ProductOneDetailsPage clickOnAddToCartButton() {
        Utility.clickOnElement(driver, addToCartButtonLocator);
        Utility.clickOnElement(driver, continueShoppingButtonLocator);
        return this;
    }

    public P12_CartPage clickOnCartButton() {
        Utility.clickOnElement(driver, cartButtonLocator);
        return new P12_CartPage(driver);
    }
}
