package Factories;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.URL;

public class DriverFactory {
    public static ThreadLocal<AndroidDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setupDriver() throws IOException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(System.getProperty("user.dir") + "/Application/App.apk");
        driverThreadLocal.set(new AndroidDriver(new URL("http://127.0.0.1:4723"), options));
    }

    public static AndroidDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        driverThreadLocal.remove();
    }
}
