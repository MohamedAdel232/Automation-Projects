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

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.readFromPropertiesFile;

@Listeners(Listener.class)
public class TC12_AddProductsInCart {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void addProductToCart() throws FileNotFoundException, InterruptedException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver()).clickOnProductsButton()
                .addFirstProductToCart()
                .addSecondProductToCart()
                .clickOnCartButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

        softAssert.assertTrue(new P12_CartPage(getDriver()).verifyVisibilityOfProducts());

        LogsUtils.info("First product price: " + new P12_CartPage(getDriver()).getFirstProductPrice());
        LogsUtils.info("Second product price: " + new P12_CartPage(getDriver()).getSecondProductPrice());
        LogsUtils.info("First product total price: " + new P12_CartPage(getDriver()).getFirstProductTotalPrice());
        LogsUtils.info("Second product total price: " + new P12_CartPage(getDriver()).getSecondProductTotalPrice());

        softAssert.assertTrue(new P12_CartPage(getDriver()).verifyTotalPrice());

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}