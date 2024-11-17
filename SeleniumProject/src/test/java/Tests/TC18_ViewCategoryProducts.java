package Tests;

import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P16_DressSearchPage;
import Pages.P17_ShirtPage;
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
public class TC18_ViewCategoryProducts {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void placeOrderRegisterBeforeCheckout() throws IOException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfCategoryText());

        new P01_HomePage(getDriver())
                .clickOnWomenCategoryButton()
                .clickOnDressCategoryButton();
        softAssert.assertTrue(new P16_DressSearchPage(getDriver()).verifyVisibilityOfWomenDressProductText());

        new P16_DressSearchPage(getDriver())
                .clickOnMenCategoryButton()
                .clickOnShirtCategoryButton();

        softAssert.assertTrue(new P17_ShirtPage(getDriver()).verifyVisibilityOfMenShirtProductText());

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}