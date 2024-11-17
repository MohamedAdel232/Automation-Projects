package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P09_ProductsPage;
import Pages.P11_SearchPage;
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
public class TC09_SearchProduct {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void searchProduct() throws FileNotFoundException, InterruptedException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P09_ProductsPage(getDriver()).checkVisibilityOfFeatureItem());

        new P09_ProductsPage(getDriver())
                .searchForProduct(readFromJsonFile("SearchData", "product"))
                .clickOnSubmitSearchButton();
        LogsUtils.info("Product: " + readFromJsonFile("SearchData", "product"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P11_SearchPage(getDriver()).verifyVisibilityOfSearchedProductText());
        softAssert.assertTrue(new P11_SearchPage(getDriver()).verifyVisibilityOfFeaturedItem());
        
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
