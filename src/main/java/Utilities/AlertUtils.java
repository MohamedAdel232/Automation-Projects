package Utilities;

import org.openqa.selenium.WebDriver;

public class AlertUtils {
    public static void acceptAlert(WebDriver driver) {
        LogsUtils.info("Accepting alert");
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        LogsUtils.info("Dismissing alert");
        driver.switchTo().alert().dismiss();
    }

    public static String getAlertText(WebDriver driver) {
        LogsUtils.info("Getting alert text");
        return driver.switchTo().alert().getText();
    }

    public static void sendDataToAlert(WebDriver driver, String data) {
        LogsUtils.info("Sending", data, "to alert");
        driver.switchTo().alert().sendKeys(data);
    }
}
