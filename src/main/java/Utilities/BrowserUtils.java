package Utilities;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {
    private BrowserUtils() {
    }

    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public static String getWindowHandel(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public static void quitWindow(WebDriver driver) {
        driver.quit();
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
}
