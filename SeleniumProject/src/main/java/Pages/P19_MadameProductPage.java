package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P19_MadameProductPage {
    private final By madameProductTextLocator = By.xpath("//h2 [@class]");
    
    private final WebDriver driver;

    public P19_MadameProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfMadameProductText() {
        return Utility.checkVisibilityOfElement(driver, madameProductTextLocator);
    }
}
