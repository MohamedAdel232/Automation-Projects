package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class P09_ProductsPage {
    private final By featureItemLocator = By.className("features_items");
    private final By firstProductDetailsButtonLocator = By.xpath("//a [@href=\"/product_details/1\"]");
    private final By searchFieldLocator = By.xpath("//input [@type=\"text\"]");
    private final By submitSearchButtonLocator = By.xpath("//button [@id=\"submit_search\"]");
    private final By firstProductLocator = By.xpath("//img [@src=\"/get_product_picture/1\"]");
    private final By addFirstProductToCartLocator = By.xpath("//a [@data-product-id=\"1\"]");
    private final By continueShoppingButtonLocator = By.xpath("//button [.=\"Continue Shopping\"]");
    private final By secondProductLocator = By.xpath("//img [@src=\"/get_product_picture/2\"]");
    private final By addSecondProductToCartLocator = By.xpath("//a [@data-product-id=\"2\"]");
    private final By cartButtonLocator = By.xpath("(//a [@href=\"/view_cart\"])[1]");
    private final By brandsTextLocator = By.className("brands_products");
    private final By poloBrandButtonLocator = By.xpath("//a [@href=\"/brand_products/Polo\"]");

    private final WebDriver driver;

    public P09_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkVisibilityOfFeatureItem() {
        return Utility.checkVisibilityOfElement(driver, featureItemLocator);
    }

    public P10_ProductOneDetailsPage clickOnFirstProductDetailsButton() {
        Utility.clickOnElement(driver, firstProductDetailsButtonLocator);
        return new P10_ProductOneDetailsPage(driver);
    }

    public P09_ProductsPage searchForProduct(String product) {
        Utility.sendDataToElement(driver, searchFieldLocator, product);
        return this;
    }

    public P11_SearchPage clickOnSubmitSearchButton() {
        Utility.clickOnElement(driver, submitSearchButtonLocator);
        return new P11_SearchPage(driver);
    }

    public P09_ProductsPage addFirstProductToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(Utility.findWebElement(driver, firstProductLocator));
        Utility.clickOnElement(driver, addFirstProductToCartLocator);
        Utility.clickOnElement(driver, continueShoppingButtonLocator);
        return this;
    }

    public P09_ProductsPage addSecondProductToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(Utility.findWebElement(driver, secondProductLocator));
        Utility.clickOnElement(driver, addSecondProductToCartLocator);
        Utility.clickOnElement(driver, continueShoppingButtonLocator);
        return this;
    }

    public P12_CartPage clickOnCartButton() {
        Utility.clickOnElement(driver, cartButtonLocator);
        return new P12_CartPage(driver);
    }

    public boolean verifyVisibilityOfBrandsText() {
        return Utility.checkVisibilityOfElement(driver, brandsTextLocator);
    }

    public P18_PoloPage clickOnPoloBrandButton() {
        Utility.clickOnElement(driver, poloBrandButtonLocator);
        return new P18_PoloPage(driver);
    }
}
