package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P17_ShirtPage {
    private final By menShirtProductTextLocator = By.xpath("//h2 [@class]");

    private final WebDriver driver;

    public P17_ShirtPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfMenShirtProductText() {
        return Utility.checkVisibilityOfElement(driver, menShirtProductTextLocator);
    }
}
