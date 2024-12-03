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

    @Test
    @Description("Verify functionality of create an account button on the home page")
    public void verifyFunctionalityOfCreateAnAccountButtonTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnCreateAnAccountButton();
        System.out.println(getDriver().getCurrentUrl());
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "CreateAccountPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "CreateAccountPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of sign in button on the home page")
    public void verifyFunctionalityOfSignInButtonTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnSignInButton();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "SignInPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "SignInPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of what's new button on the home page")
    public void verifyFunctionalityOfWhatsNewButtonTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnWhatsNewButton();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "WhatsNewPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "WhatsNewPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of women button on the home page")
    public void verifyFunctionalityOfWomenButtonTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnWomenButton();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "WomenPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "WomenPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of men button on the home page")
    public void verifyFunctionalityOfMenButtonTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnMenButton();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "MenPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "MenPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of gear button on the home page")
    public void verifyFunctionalityOfGearButtonTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnGearButton();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "GearPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "GearPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of training button on the home page")
    public void verifyFunctionalityOfTrainingButtonTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnTrainingButton();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "TrainingPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "TrainingPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of sale button on the home page")
    public void verifyFunctionalityOfSaleButtonTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnSaleButton();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "SalePage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "SalePage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of the yoga ad on the home page")
    public void verifyFunctionalityOfYogaAdTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnYogaAd();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "YogaAdPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "YogaAdPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of the pants ad on the home page")
    public void verifyFunctionalityOfPantsAdTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnPantsAd();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "PantsAdPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "PantsAdPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of the t-shirt ad on the home page")
    public void verifyFunctionalityOfTShirtAdTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnTShirtsAd();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "TShirtAdPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "TShirtAdPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of the erin ad on the home page")
    public void verifyFunctionalityOfErinAdTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnErinAd();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "ErinAdPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "ErinAdPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of the performance ad on the home page")
    public void verifyFunctionalityOfPerformanceAdTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnPerformanceAd();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "PerformanceAdPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "PerformanceAdPage"));

        softAssert.assertAll();
    }

    @Test
    @Description("Verify functionality of the eco ad on the home page")
    public void verifyFunctionalityOfEcoAdTC() throws IOException {
        new P01_HomePage(getDriver()).clickOnEcoAd();
        softAssert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "EcoAdPage"));
        LogsUtils.info("Actual Url: " + getDriver().getCurrentUrl());
        LogsUtils.info("Expected Url: " + readFromPropertiesFile("environment", "EcoAdPage"));

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
