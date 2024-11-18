package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P12_CartPage;
import Utilities.LogsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.readFromPropertiesFile;

@Listeners(Listener.class)
public class TC22_AddToCartFromRecommendedItems {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void addToCartFromRecommendedItems() throws IOException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfRecommendedItemTextLocator());

        new P01_HomePage(getDriver())
                .addRecommendedProductToCart()
                .clickOnCartButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

        softAssert.assertTrue(new P12_CartPage(getDriver()).verifyProductsAreVisible());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}