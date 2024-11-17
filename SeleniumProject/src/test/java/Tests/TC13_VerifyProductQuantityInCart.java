package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P10_ProductOneDetails;
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
public class TC13_VerifyProductQuantityInCart {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void verifyProductQuantity() throws IOException, InterruptedException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver()).clickOnFirstProductDetailsButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P10_ProductOneDetails(getDriver()).checkVisibilityOfProductInformation());

        new P10_ProductOneDetails(getDriver()).addQuantity(readFromPropertiesFile("ProductData", "quantity"))
                .clickOnAddToCartButton()
                .clickOnCartButton();
        LogsUtils.info("Quantity: " + readFromPropertiesFile("ProductData", "quantity"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P12_CartPage(getDriver()).verifyQuantityNumber(readFromPropertiesFile("ProductData", "quantity")));

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}