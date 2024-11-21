package Utilities;

import io.appium.java_client.windows.WindowsDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utility {
    public static String screenshotsPath = "test-outputs/Screenshots/";

    public static void clickOnElement(WindowsDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public static void sendDataToElement(WindowsDriver driver, By locator, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public static String getDataFromElement(WindowsDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public static String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-sa").format(new Date());
    }

    public static void takeScreenshot(WindowsDriver driver, String imageName) throws IOException {
        TakesScreenshot takesScreenshot = driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotsPath + imageName + "-" + getTimestamp() + ".png");
        FileUtils.copyFile(src, dest);
    }

    public static boolean checkVisibilityOfElement(WindowsDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).isDisplayed();
    }
}
