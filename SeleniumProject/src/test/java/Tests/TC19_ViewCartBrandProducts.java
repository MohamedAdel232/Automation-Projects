package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P09_ProductsPage;
import Pages.P18_PoloPage;
import Pages.P19_MadameProductPage;
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
public class TC19_ViewCartBrandProducts {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void viewCartBrandProducts() throws IOException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver()).clickOnProductsButton();
        softAssert.assertTrue(new P09_ProductsPage(getDriver()).verifyVisibilityOfBrandsText());

        new P09_ProductsPage(getDriver())
                .clickOnPoloBrandButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P18_PoloPage(getDriver()).verifyVisibilityOfPoloProductText());

        new P18_PoloPage(getDriver()).clickOnMadameBrandButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P19_MadameProductPage(getDriver()).verifyVisibilityOfMadameProductText());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
