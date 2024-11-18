package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P18_PoloPage {
    private final By poloProductTextLocator = By.xpath("//h2 [@class]");
    private final By madameProductButtonLocator = By.xpath("//a [@href=\"/brand_products/Madame\"]");
    
    private final WebDriver driver;

    public P18_PoloPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfPoloProductText() {
        return Utility.checkVisibilityOfElement(driver, poloProductTextLocator);
    }

    public P19_MadameProductPage clickOnMadameBrandButton() {
        Utility.clickOnElement(driver, madameProductButtonLocator);
        return new P19_MadameProductPage(driver);
    }
}
