package Tests;

import Listeners.Listener;
import Pages.P00_LayoutPage;
import Pages.P01_HomePage;
import Utilities.LogsUtils;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.readFromPropertiesFile;

@Listeners(Listener.class)
public class TC01_HomeTest {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        String browser = System.getProperty("browser") != null ?
                System.getProperty("browser") :
                readFromPropertiesFile("environment", "browser");
        setupDriver(browser);
        LogsUtils.info("Browser " + browser + " is opened");
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
    }

    @Test
    @Description("Verify landing on the home page successfully")
    public void verifyLandingOnHomePageTC() {
        softAssert.assertTrue(new P00_LayoutPage(getDriver())
                .verifyLandingOnHomePage());
        LogsUtils.info("Landed on home page successfully");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify visibility of authentication section on the home page")
    public void verifyVisibilityOfAuthenticationSectionTC() {
        softAssert.assertTrue(new P00_LayoutPage(getDriver())
                .verifyVisibilityOfAuthenticationSection());
        LogsUtils.info("Authentication section is visible");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify visibility of search section on the home page")
    public void verifyVisibilityOfSearchSectionTC() {
        softAssert.assertTrue(new P00_LayoutPage(getDriver())
                .verifyVisibilityOfSearchSection());
        LogsUtils.info("Search section is visible");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify visibility of cart icon on the home page")
    public void verifyVisibilityOfCartIconTC() {
        softAssert.assertTrue(new P00_LayoutPage(getDriver())
                .verifyVisibilityOfCartIcon());
        LogsUtils.info("Search section is visible");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify visibility of footer section on the home page")
    public void verifyVisibilityOfFooterSectionTC() {
        softAssert.assertTrue(new P00_LayoutPage(getDriver())
                .verifyVisibilityOfFooterSection());
        LogsUtils.info("Footer section is visible");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify visibility of menu section on the home page")
    public void verifyVisibilityOfMenuSectionTC() {
        softAssert.assertTrue(new P01_HomePage(getDriver())
                .verifyVisibilityOfMenuSection());
        LogsUtils.info("Menu section is visible");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify visibility of ad section on the home page")
    public void verifyVisibilityOfAdSectionTC() {
        softAssert.assertTrue(new P01_HomePage(getDriver())
                .verifyVisibilityOfAdSection());
        LogsUtils.info("Ad section is visible");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify visibility of hot seller section on the home page")
    public void verifyVisibilityOfHotSellerSectionTC() {
        softAssert.assertTrue(new P01_HomePage(getDriver())
                .verifyVisibilityOfHotSellerSection());
        LogsUtils.info("Hot seller section is visible");
        softAssert.assertAll();
    }
    
    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
