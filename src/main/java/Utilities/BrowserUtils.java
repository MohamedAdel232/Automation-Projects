package Utilities;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {
    private BrowserUtils() {
    }

    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
        LogsUtils.info("Url:", url);
    }

    public static String getCurrentUrl(WebDriver driver) {
        LogsUtils.info("Current URL:", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public static String getPageTitle(WebDriver driver) {
        LogsUtils.info("Page Title:", driver.getTitle());
        return driver.getTitle();
    }

    public static String getPageSource(WebDriver driver) {
        LogsUtils.info("Page Source:", driver.getPageSource());
        return driver.getPageSource();
    }

    public static String getWindowHandel(WebDriver driver) {
        LogsUtils.info("Window Handle:", driver.getWindowHandle());
        return driver.getWindowHandle();
    }

    public static void quitWindow(WebDriver driver) {
        LogsUtils.info("Closing Browser");
        driver.quit();
    }

    public static void refreshPage(WebDriver driver) {
        LogsUtils.info("Page refreshing");
        driver.navigate().refresh();
    }
}
