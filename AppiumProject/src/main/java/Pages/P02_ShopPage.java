package Pages;

import Utilities.Utility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class P02_ShopPage {
    private final By pageTitleLocator = By.id("com.androidsample.generalstore:id/toolbar_title");

    private final AndroidDriver driver;

    public P02_ShopPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfPageTitle() {
        return Utility.verifyVisibilityOfElement(driver, pageTitleLocator);
    }
}
