package Factories;

import Utilities.LogsUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.testng.Assert.fail;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void setupDriver(String browser) {
        switch (browser) {
            case "Edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driverThreadLocal.set(new EdgeDriver(edgeOptions));
                break;

            case "Firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--guest");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driverThreadLocal.set(new FirefoxDriver(firefoxOptions));
                break;

            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--guest");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driverThreadLocal.set(new ChromeDriver(chromeOptions));
                break;
        }
        LogsUtils.info("Browser", browser, "started");
    }


    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        LogsUtils.info("Browser", "closed");
    }
}
