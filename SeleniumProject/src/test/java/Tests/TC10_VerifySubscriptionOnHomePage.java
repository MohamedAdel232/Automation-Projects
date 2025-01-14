package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Utilities.LogsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.readFromJsonFile;
import static Utilities.DataUtils.readFromPropertiesFile;

@Listeners(Listener.class)
public class TC10_VerifySubscriptionOnHomePage {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void verifySubscriptionOnHomePage() throws FileNotFoundException, InterruptedException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfSubscriptionText());
        new P01_HomePage(getDriver()).enterSubscribeEmail(readFromJsonFile("RegisterData", "email"))
                .clickOnArrowButton();
        LogsUtils.info("email: " + readFromJsonFile("RegisterData", "email"));

        softAssert.assertTrue(new P01_HomePage(getDriver()).checkVisibilityOfSuccessSubscribe());

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
