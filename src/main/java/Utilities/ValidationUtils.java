package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ValidationUtils {
    private ValidationUtils() {
    }

    public static void validateTrue(boolean condition, String msg) {
        Assert.assertTrue(condition, msg);
    }

    public static void validateNotTrue(boolean condition, String msg) {
        Assert.assertFalse(condition, msg);
    }

    public static void validateEqual(String actual, String expected, String msg) {
        Assert.assertEquals(actual, expected, msg);
    }

    public static void validateNotEqual(String actual, String expected, String msg) {
        Assert.assertNotEquals(actual, expected, msg);
    }

    public static void validatePageUrl(WebDriver driver, String expected, String msg) {
        Assert.assertEquals(BrowserUtils.getCurrentUrl(driver), expected, msg);
    }

    public static void validatePageTitle(WebDriver driver, String expected, String msg) {
        Assert.assertEquals(BrowserUtils.getPageTitle(driver), expected, msg);
    }
}
