package Utilities;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CookiesUtils {
    public static void setCookie(WebDriver driver, Set<Cookie> cookies) {
        LogsUtils.info("Setting cookie");
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public static void deleteAllCookies(WebDriver driver) {
        LogsUtils.info("Deleting all cookies");
        driver.manage().deleteAllCookies();
    }

    public static Set<Cookie> getCookies(WebDriver driver) {
        LogsUtils.info("Getting cookies");
        return driver.manage().getCookies();
    }
}
