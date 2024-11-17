package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P09_ProductsPage;
import Pages.P10_ProductOneDetailsPage;
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
public class TC21_AddReviewOnProduct {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void addReviewOnProduct() throws IOException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver())
                .clickOnProductsButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P09_ProductsPage(getDriver()).checkVisibilityOfFeatureItem());

        new P09_ProductsPage(getDriver()).clickOnFirstProductDetailsButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P10_ProductOneDetailsPage(getDriver()).verifyVisibilityOfWriteYourReviewButton());

        new P10_ProductOneDetailsPage(getDriver())
                .writeReview(readFromJsonFile("Review", "name"),
                        readFromJsonFile("Review", "email"),
                        readFromJsonFile("Review", "review"));
        LogsUtils.info("Name: " + readFromJsonFile("Review", "name"));
        LogsUtils.info("Email: " + readFromJsonFile("Review", "email"));
        LogsUtils.info("Review: " + readFromJsonFile("Review", "review"));
        softAssert.assertTrue(new P10_ProductOneDetailsPage(getDriver()).verifyVisibilityOfReviewSubmitted());
        
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}