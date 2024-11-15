package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Utilities.LogsUtils;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.readFromPropertiesFile;

@Listeners(Listener.class)
public class TC03_InvalidLogin {
    public static SoftAssert softAssert = new SoftAssert();
    Faker faker = new Faker();
    String invalidEmail = faker.internet().emailAddress();
    String invalidPassword = faker.internet().password();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));

        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("URL: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void invalidLoginTC() throws IOException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver()).clickOnLoginButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P02_LoginPage(getDriver()).verifyVisibilityOfLoginToYourAccountText());

        new P02_LoginPage(getDriver())
                .enterLoginEmail(invalidEmail)
                .enterLoginPassword(invalidPassword)
                .clickOnLoginButton();
        LogsUtils.info("email: " + invalidEmail);
        LogsUtils.info("password: " + invalidPassword);
        softAssert.assertTrue(new P02_LoginPage(getDriver()).verifyVisibilityOfInvalidDataText());

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

}
