package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P00_LayoutPage {
    public final By homePageLogoLocator = By.xpath("(//a //img)[1]");
    public final By signInButtonLocator = By.xpath("(//ul //li //a) [2]");
    public final By createAnAccountButtonLocator = By.xpath("(//ul //li //a) [3]");
    public final By searchFieldLocator = By.id("search");
    public final By cartIconLocator = By.xpath("//a [contains(@class, \"showcart\")]");
    public final By footerLocator = By.xpath("//div [contains(@class, \"footer\")]");

    private final WebDriver driver;

    public P00_LayoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyLandingOnHomePage() {
        driver.findElement(By.xpath("//span [.=\"What's New\"]"));
        return Utility.checkVisibilityOfElement(driver, homePageLogoLocator);
    }

    public boolean verifyVisibilityOfAuthenticationSection() {
        return Utility.checkVisibilityOfElement(driver, signInButtonLocator) &&
                Utility.checkVisibilityOfElement(driver, createAnAccountButtonLocator);
    }

    public boolean verifyVisibilityOfSearchSection() {
        return Utility.checkVisibilityOfElement(driver, searchFieldLocator);
    }

    public boolean verifyVisibilityOfCartIcon() {
        return Utility.checkVisibilityOfElement(driver, cartIconLocator);
    }

    public boolean verifyVisibilityOfFooterSection() {
        return Utility.checkVisibilityOfElement(driver, footerLocator);
    }
}
