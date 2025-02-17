package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollUtils {
    private ScrollUtils() {
    }

    public static void scrollToElement(WebDriver driver, By locator) {
        LogsUtils.info("Scrolling to element", locator.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                ElementUtils.findElement(driver, locator));
    }

    public static void scrollIntoElementAction(WebDriver driver, By locator) {
        LogsUtils.info("Scrolling to element", locator.toString());
        Actions actions = new Actions(driver);
        actions.scrollToElement(ElementUtils.findElement(driver, locator));
    }
}
