package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_FinishPage {
    private final By thanksMessageTextLocator = By.xpath("//h2 [@class=\"complete-header\"]");

    private final WebDriver driver;

    public P06_FinishPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkVisibilityOfThanksMessageText() {
        return Utility.verifyVisibilityOfElement(driver, thanksMessageTextLocator);
    }
}
