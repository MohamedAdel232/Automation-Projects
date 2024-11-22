package Pages;

import Utilities.Utility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class P01_HomePage {
    private final By selectCountryLocator = By.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By nameFieldLocator = By.id("com.androidsample.generalstore:id/nameField");
    private final By letsShopButtonLocator = By.id("com.androidsample.generalstore:id/btnLetsShop");

    private final AndroidDriver driver;

    public P01_HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public P01_HomePage clickOnSelectCountry() {
        Utility.clickOnElement(driver, selectCountryLocator);
        return new P01_HomePage(driver);
    }

    public P01_HomePage selectCountry() {
        Utility.scrollToElement(driver, "Egypt");
        return new P01_HomePage(driver);
    }

    public P01_HomePage enterName(String name) {
        Utility.sendDataToElement(driver, nameFieldLocator, name);
        return new P01_HomePage(driver);
    }

    public P02_ShopPage clickOnLetsShopButton() {
        Utility.clickOnElement(driver, letsShopButtonLocator);
        return new P02_ShopPage(driver);
    }
}
