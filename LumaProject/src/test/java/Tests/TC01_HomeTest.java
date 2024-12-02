package Tests;

import Pages.P01_HomePage;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.readFromPropertiesFile;

public class TC01_HomeTest {
    @BeforeMethod
    public void setup() throws IOException {
        String browser = System.getProperty("browser") != null ?
                System.getProperty("browser") :
                readFromPropertiesFile("environment", "browser");
        setupDriver(browser);
        LogsUtils.info("Browser " + browser + " is opened");
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
    }

    @Test
    public void verifyLandingOnHomePage() {
        Assert.assertTrue(new P01_HomePage(getDriver())
                .verifyLandingOnHomePage());
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
