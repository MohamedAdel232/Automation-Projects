package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Utilities.LogsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.readFromJsonFile;
import static Utilities.DataUtils.readFromPropertiesFile;

@Listeners(Listener.class)
public class TC05_RegisterWithExistingEmail {
    public static SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("URL: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void registerUserTC() throws IOException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver()).clickOnLoginButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P02_LoginPage(getDriver()).verifyVisibilityOfNewUserSignupText());

        new P02_LoginPage(getDriver())
                .enterName(readFromJsonFile("InvalidData", "name"))
                .enterEmail(readFromJsonFile("InvalidData", "email"))
                .clickOnSignupButton();
        LogsUtils.info("name: " + readFromJsonFile("InvalidData", "name"));
        LogsUtils.info("email: " + readFromJsonFile("InvalidData", "email"));
        softAssert.assertTrue(new P02_LoginPage(getDriver()).verifyVisibilityOfEmailAlreadyExistText());

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

}