package Factories;

import Utilities.DataUtils;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.options.WindowsOptions;

import java.io.IOException;
import java.net.URL;

public class DriverFactory {
    public static ThreadLocal<WindowsDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setupDriver() throws IOException {
        WindowsOptions windowsOptions = new WindowsOptions();
        windowsOptions.setApp(DataUtils.readFromPropertiesFile("environment", "app"));
        driverThreadLocal.set(new WindowsDriver(new URL("http://127.0.0.1:4723"), windowsOptions));
    }

    public static WindowsDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        getDriver().quit();
    }
}
