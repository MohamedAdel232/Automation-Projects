package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P06_ContactUsPage;
import Pages.P07_ConfirmContactUsPage;
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
public class TC06_ContactUsForm {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void contactUsForm() throws FileNotFoundException, InterruptedException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver()).clickOnContactUsButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P06_ContactUsPage(getDriver()).verifyVisibilityOfGetInTouchText());

        new P06_ContactUsPage(getDriver())
                .fillOutInfo(readFromJsonFile("ContactUsForm", "name"),
                        readFromJsonFile("ContactUsForm", "email"),
                        readFromJsonFile("ContactUsForm", "subject"),
                        readFromJsonFile("ContactUsForm", "message"))
                .uploadFile("D:\\SW Testing\\Automation Projects\\SeleniumProject\\src\\test\\resources\\TestData\\file.txt")
                .clickOnSubmitButton()
                .acceptAlert();

        LogsUtils.info("name: " + readFromJsonFile("ContactUsForm", "name"));
        LogsUtils.info("email: " + readFromJsonFile("ContactUsForm", "email"));
        LogsUtils.info("subject: " + readFromJsonFile("ContactUsForm", "subject"));
        LogsUtils.info("message: " + readFromJsonFile("ContactUsForm", "message"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P07_ConfirmContactUsPage(getDriver()).verifyVisibilityOfSubmittedSuccessfullyText());

        new P07_ConfirmContactUsPage(getDriver()).clickOnHomeButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
