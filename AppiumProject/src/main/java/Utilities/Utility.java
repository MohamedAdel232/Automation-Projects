package Utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

public class Utility {
    public static String screenshotsPath = "test-outputs/Screenshots/";

    public static void clickOnElement(AndroidDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public static void sendDataToElement(AndroidDriver driver, By locator, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public static String getDataFromElement(AndroidDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public static String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-d-h-m-sa").format(new Date());
    }

    public static void takeScreenshot(AndroidDriver driver, String imageName) throws IOException {
        TakesScreenshot takesScreenshot = driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotsPath + imageName + "-" + getTimestamp() + ".png");
        FileUtils.copyFile(src, dest);
    }

    public static void scrollToElement(AndroidDriver driver, String elementText) {
        try {
            WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                            "new UiSelector().text(\"" + elementText + "\"))"
            ));
            element.click(); // Optional: click the element after scrolling
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + elementText);
        }
    }

}
