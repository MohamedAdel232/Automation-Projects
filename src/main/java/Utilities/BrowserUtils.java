package Utilities;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

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

    public static Set<String> getWindowHandles(WebDriver driver) {
        LogsUtils.info("Window Handles: " + driver.getWindowHandles());
        return driver.getWindowHandles();
    }

    public static void quitWindow(WebDriver driver) {
        LogsUtils.info("Closing Browser");
        driver.quit();
    }

    public static void refreshPage(WebDriver driver) {
        LogsUtils.info("Page refreshing");
        driver.navigate().refresh();
    }

    public static void maximizeWindow(WebDriver driver) {
        LogsUtils.info("Maximizing Window");
        driver.manage().window().maximize();
    }

    public static void switchToFrame(WebDriver driver, String id) {
        LogsUtils.info("Switching to Frame at index:", id);
        driver.switchTo().frame(id);
    }

    public static void navigateForward(WebDriver driver) {
        LogsUtils.info("Navigating forward");
        driver.navigate().forward();
    }

    public static void navigateBackward(WebDriver driver) {
        LogsUtils.info("Navigating backward");
        driver.navigate().back();
    }

    public static Set<Cookie> getAllCookies(WebDriver driver) {
        LogsUtils.info("Cookies: " + driver.manage().getCookies());
        return driver.manage().getCookies();
    }

    public static void deleteAllCookies(WebDriver driver) {
        LogsUtils.info("Deleting all cookies");
        driver.manage().deleteAllCookies();
    }

    public static void deleteCookie(WebDriver driver, String name) {
        LogsUtils.info("Deleting cookie: " + name);
        driver.manage().deleteCookieNamed(name);
    }

}
