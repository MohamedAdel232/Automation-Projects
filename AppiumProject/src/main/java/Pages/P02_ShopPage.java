package Pages;

import Utilities.Utility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class P02_ShopPage {
    private final By pageTitleLocator = By.id("com.androidsample.generalstore:id/toolbar_title");
    private final By addFirstProductToCartLocator = By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]");
    private final By cartIconLocator = By.id("com.androidsample.generalstore:id/appbar_btn_cart");

    private final AndroidDriver driver;

    public P02_ShopPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfPageTitle() {
        return Utility.verifyVisibilityOfElement(driver, pageTitleLocator);
    }

    public P02_ShopPage addFirstProductToCart() {
        Utility.clickOnElement(driver, addFirstProductToCartLocator);
        return this;
    }

    public P03_CartPage clickOnCartIcon() {
        Utility.clickOnElement(driver, cartIconLocator);
        return new P03_CartPage(driver);
    }
}
