package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P11_SearchPage {
    private final By searchedProductTextLocator = By.xpath("//h2 [contains(@class, \"text-center\")]");
    private final By featuredItemLocator = By.className("features_items");

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
}
