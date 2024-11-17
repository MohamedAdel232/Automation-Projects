package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P11_SearchPage {
    private final By searchedProductTextLocator = By.xpath("//h2 [contains(@class, \"text-center\")]");
    private final By featuredItemLocator = By.className("features_items");
    private final By allProductLocator = By.xpath("//div [contains(@class,\"productinfo text-center\")] //a [@data-product-id]");
    private final By cartButtonLocator = By.xpath("(//a [@href=\"/view_cart\"])[1]");
    private final By continueShoppingButtonLocator = By.xpath("//button [.=\"Continue Shopping\"]");
    
    private final WebDriver driver;

    public P11_SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfSearchedProductText() {
        return Utility.checkVisibilityOfElement(driver, searchedProductTextLocator);
    }

    public boolean verifyVisibilityOfFeaturedItem() {
        return Utility.checkVisibilityOfElement(driver, featuredItemLocator);
    }

    public P11_SearchPage addAllProducts() {
        List<WebElement> elementList = driver.findElements(allProductLocator);
        for (int i = 1; i <= elementList.size(); i++) {
            By tempLocator = By.xpath("(//div [contains(@class,\"productinfo text-center\")] //a [@data-product-id])[" + i + "]");
            Utility.clickOnElement(driver, tempLocator);
            Utility.clickOnElement(driver, continueShoppingButtonLocator);
        }
        return this;
    }

    public P12_CartPage clickOnCartButton() {
        Utility.clickOnElement(driver, cartButtonLocator);
        return new P12_CartPage(driver);
    }
}
