package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SoftAssertionUtils extends SoftAssert {
    public static SoftAssertionUtils softAssertionUtils = new SoftAssertionUtils();

    public static void softAssertAll() {
        try {
            softAssertionUtils.assertAll();
        } catch (Exception e) {
            LogsUtils.info("Assertion failed");
        }
    }

    public static void softValidateTrue(boolean condition, String msg) {
        softAssertionUtils.assertTrue(condition, msg);
    }

    public static void softValidateNotTrue(boolean condition, String msg) {
        softAssertionUtils.assertFalse(condition, msg);
    }

    public static void softValidateEqual(String actual, String expected, String msg) {
        softAssertionUtils.assertEquals(actual, expected, msg);
    }

    public static void softValidateNotEqual(String actual, String expected, String msg) {
        softAssertionUtils.assertNotEquals(actual, expected, msg);
    }

    public static void softValidatePageUrl(WebDriver driver, String expected, String msg) {
        softAssertionUtils.assertEquals(BrowserUtils.getCurrentUrl(driver), expected, msg);
    }

    public static void softValidatePageTitle(WebDriver driver, String expected, String msg) {
        softAssertionUtils.assertEquals(BrowserUtils.getPageTitle(driver), expected, msg);
    }
}
