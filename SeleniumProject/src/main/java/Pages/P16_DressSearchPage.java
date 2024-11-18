package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P16_DressSearchPage {
    private final By womenDressProductTextLocator = By.xpath("//h2 [@class]");
    private final By menCategoryButtonLocator = By.xpath("//a [@href=\"#Men\"]");
    private final By shirtCategoryButtonLocator = By.xpath("//a [@href=\"/category_products/3\"]");

    private final WebDriver driver;

    public P16_DressSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfWomenDressProductText() {
        return Utility.checkVisibilityOfElement(driver, womenDressProductTextLocator);
    }

    public P16_DressSearchPage clickOnMenCategoryButton() {
        Utility.clickOnElement(driver, menCategoryButtonLocator);
        return this;
    }

    public P17_ShirtPage clickOnShirtCategoryButton() {
        Utility.clickOnElement(driver, shirtCategoryButtonLocator);
        return new P17_ShirtPage(driver);
    }
}
