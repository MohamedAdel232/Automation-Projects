package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P10_ProductOneDetails {
    private final By productInformationLocator = By.className("product-information");

    private final WebDriver driver;

    public P10_ProductOneDetails(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkVisibilityOfProductInformation() {
        return Utility.checkVisibilityOfElement(driver, productInformationLocator);
    }
}
