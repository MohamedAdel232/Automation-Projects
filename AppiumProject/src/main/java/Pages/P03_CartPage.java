package Pages;

import Utilities.Utility;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

public class P03_CartPage {
    private final By pageTitleLocator = By.id("com.androidsample.generalstore:id/toolbar_title");
    private final By checkBoxLocator = By.className("android.widget.CheckBox");
    private final By visitWebsiteButtonLocator = By.id("com.androidsample.generalstore:id/btnProceed");
    private final By termsOfConditionsButtonLocator = By.id("com.androidsample.generalstore:id/termsButton");
    private final By termsOfConditionsTextLocator = By.id("com.androidsample.generalstore:id/alertTitle");

    private final AndroidDriver driver;

    public P03_CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfPageTitle() {
        return Utility.verifyVisibilityOfElement(driver, pageTitleLocator);
    }

    public P03_CartPage clickOnCheckbox() {
        Utility.clickOnElement(driver, checkBoxLocator);
        return this;
    }

    public void clickOnVisitWebsiteButton() {
        Utility.clickOnElement(driver, visitWebsiteButtonLocator);
    }

    public P03_CartPage clickOnTermsOfConditionsButton() {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(termsOfConditionsButtonLocator)).getId(),
                "duration", 2000
        ));
        return this;
    }

    public boolean checkVisibilityOfTermsOfConditionsText() {
        return Utility.verifyVisibilityOfElement(driver, termsOfConditionsTextLocator);
    }
}
