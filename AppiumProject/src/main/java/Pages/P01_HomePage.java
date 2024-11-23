package Pages;

import Utilities.Utility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class P01_HomePage {
    private final By pageTitleLocator = By.id("com.androidsample.generalstore:id/toolbar_title");
    private final By selectCountryLocator = By.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By nameFieldLocator = By.id("com.androidsample.generalstore:id/nameField");
    private final By maleGenderLocator = By.id("com.androidsample.generalstore:id/radioMale");
    private final By femaleGenderLocator = By.id("com.androidsample.generalstore:id/radioFemale");
    private final By letsShopButtonLocator = By.id("com.androidsample.generalstore:id/btnLetsShop");

    private final AndroidDriver driver;

    public P01_HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfPageTitle() {
        return Utility.verifyVisibilityOfElement(driver, pageTitleLocator);
    }

    public P01_HomePage clickOnSelectCountry() {
        Utility.clickOnElement(driver, selectCountryLocator);
        return new P01_HomePage(driver);
    }

    public P01_HomePage selectCountry(String country) {
        Utility.scrollToElement(driver, country);
        return new P01_HomePage(driver);
    }

    public P01_HomePage enterName(String name) {
        Utility.sendDataToElement(driver, nameFieldLocator, name);
        return new P01_HomePage(driver);
    }

    public P01_HomePage selectGender(String gender) {
        if (gender.equals("Male")) {
            Utility.clickOnElement(driver, maleGenderLocator);
        } else {
            Utility.clickOnElement(driver, femaleGenderLocator);
        }
        return new P01_HomePage(driver);
    }

    public P02_ShopPage clickOnLetsShopButton() {
        Utility.clickOnElement(driver, letsShopButtonLocator);
        return new P02_ShopPage(driver);
    }


}
