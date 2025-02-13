package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
    private ElementUtils() {
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public static void clickOnElement(WebDriver driver, By locator) {
        WaitUtils.waitForElementToBeClickable(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        findElement(driver, locator).click();
    }

    public static void sendDataToElement(WebDriver driver, By locator, String data) {
        WaitUtils.waitForElementToBeVisible(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(data);
    }

    public static String getDataToElement(WebDriver driver, By locator) {
        WaitUtils.waitForElementToBeVisible(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        return findElement(driver, locator).getText();
    }
}
