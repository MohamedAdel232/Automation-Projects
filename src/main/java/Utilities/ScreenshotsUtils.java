package Utilities;

import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotsUtils {
    private static final String ScreenshotsPath = "TestOutputs/Screenshots/";

    private ScreenshotsUtils() {
    }

    public static void takeScreenshot(WebDriver driver, String imageName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(ScreenshotsPath + imageName + "-" + Utility.getTimeStamp() + ".png");
        Files.copy(src.toPath(), destination.toPath());
    }

    public static void takeElementScreenshot(WebDriver driver, String imageName, By locator) throws IOException {
        WaitUtils.waitForElementToBeVisible(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        WebElement element = ElementUtils.findElement(driver, locator);
        File src = element.getScreenshotAs(OutputType.FILE);
        File destination = new File(ScreenshotsPath + imageName + ".png");
        Files.copy(src.toPath(), destination.toPath());
    }
}
