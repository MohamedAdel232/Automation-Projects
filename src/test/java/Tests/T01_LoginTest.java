package Tests;

import Factories.DriverFactory;
import Listeners.Listener;
import Pages.P01_LoginPage;
import Utilities.BrowserUtils;
import Utilities.SoftAssertionUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static Factories.DriverFactory.getDriver;
import static Utilities.DataUtils.readFromPropertiesFile;

@Listeners(Listener.class)
public class T01_LoginTest {
    @BeforeMethod
    public void beforeMethod() throws IOException {
        DriverFactory.setupDriver(readFromPropertiesFile("environment", "browser"));
        BrowserUtils.navigateToUrl(getDriver(), readFromPropertiesFile("environment", "LoginPage"));
    }

    @Test
    public void validLoginTC() throws IOException, InterruptedException {
        new P01_LoginPage(getDriver())
                .enterUsername("temp")
                .enterPassword("Temp1###")
                .clickOnLoginButton()
                .assertValidLogin();
    }

    @AfterMethod
    public void afterMethod() throws IOException {
        DriverFactory.quitDriver();
        SoftAssertionUtils.softAssertAll();
    }
}
