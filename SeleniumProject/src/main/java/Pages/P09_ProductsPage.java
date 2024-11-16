package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P09_ProductsPage {
    private final By featureItemLocator = By.className("features_items");
    private final By firstProductDetailsButtonLocator = By.xpath("//a [@href=\"/product_details/1\"]");

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
}
