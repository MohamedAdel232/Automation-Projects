package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P09_ProductsPage {
    private final By featureItemLocator = By.className("features_items");
    private final By firstProductDetailsButtonLocator = By.xpath("//a [@href=\"/product_details/1\"]");
    private final By searchFieldLocator = By.xpath("//input [@type=\"text\"]");
    private final By submitSearchButtonLocator = By.xpath("//button [@id=\"submit_search\"]");

    private final WebDriver driver;

    public P09_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkVisibilityOfFeatureItem() {
        return Utility.checkVisibilityOfElement(driver, featureItemLocator);
    }

    public P10_ProductOneDetails clickOnFirstProductDetailsButton() {
        Utility.clickOnElement(driver, firstProductDetailsButtonLocator);
        return new P10_ProductOneDetails(driver);
    }

    public P09_ProductsPage searchForProduct(String product) {
        Utility.sendDataToElement(driver, searchFieldLocator, product);
        return this;
    }

    public P11_SearchPage clickOnSubmitSearchButton() {
        Utility.clickOnElement(driver, submitSearchButtonLocator);
        return new P11_SearchPage(driver);
    }


}
