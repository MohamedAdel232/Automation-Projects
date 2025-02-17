package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
    private ElementUtils() {
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        LogsUtils.info("Finding Element:", locator.toString());
        return driver.findElement(locator);
    }

    public static void clickOnElement(WebDriver driver, By locator) {
        LogsUtils.info("Clicking on Element:", locator.toString());
        WaitUtils.waitForElementToBeClickable(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        findElement(driver, locator).click();
    }

    public static void sendDataToElement(WebDriver driver, By locator, String data) {
        LogsUtils.info("Sending", data, "to Element:", locator.toString());
        WaitUtils.waitForElementToBeVisible(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(data);
    }

    public static String getDataToElement(WebDriver driver, By locator) {
        LogsUtils.info("Getting Data from Element:", locator.toString());
        WaitUtils.waitForElementToBeVisible(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        return findElement(driver, locator).getText();
    }
}
