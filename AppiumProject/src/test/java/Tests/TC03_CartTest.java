package Tests;

import Factories.DriverFactory;
import Factories.ServerFactory;
import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P02_ShopPage;
import Pages.P03_CartPage;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Set;

import static Factories.DriverFactory.getDriver;
import static Utilities.DataUtils.readFromJsonFile;
import static Utilities.DataUtils.readFromPropertiesFile;

@Listeners(Listener.class)
public class TC03_CartTest {
    @BeforeClass
    public void startServer() {
        ServerFactory.startServer();
        LogsUtils.info("Appium server started");
    }

    @BeforeMethod
    public void setupDriver() throws IOException {
        DriverFactory.setupDriver();
        LogsUtils.info("Application is opened");
    }

    @Test
    public void verifyLandingOnCart() {
        Assert.assertTrue(new P03_CartPage(getDriver()).verifyVisibilityOfPageTitle());
    }

    @Test
    public void readTermsOfConditionsTC() throws IOException, InterruptedException {
        new P01_HomePage(getDriver())
                .clickOnSelectCountry()
                .selectCountry(readFromJsonFile("TestData", "country"))
                .enterName(readFromJsonFile("TestData", "name"))
                .selectGender(readFromJsonFile("TestData", "gender"))
                .clickOnLetsShopButton();
        LogsUtils.info("Country: " + readFromJsonFile("TestData", "country"));
        LogsUtils.info("Name: " + readFromJsonFile("TestData", "name"));
        LogsUtils.info("Gender: " + readFromJsonFile("TestData", "gender"));

        new P02_ShopPage(getDriver())
                .addFirstProductToCart()
                .clickOnCartIcon();
        LogsUtils.info("First product added");

        new P03_CartPage(getDriver())
                .clickOnTermsOfConditionsButton();

        Assert.assertTrue(new P03_CartPage(getDriver()).checkVisibilityOfTermsOfConditionsText());
    }

    @Test
    public void completeBuyTC() throws IOException, InterruptedException {
        new P01_HomePage(getDriver())
                .clickOnSelectCountry()
                .selectCountry(readFromJsonFile("TestData", "country"))
                .enterName(readFromJsonFile("TestData", "name"))
                .selectGender(readFromJsonFile("TestData", "gender"))
                .clickOnLetsShopButton();
        LogsUtils.info("Country: " + readFromJsonFile("TestData", "country"));
        LogsUtils.info("Name: " + readFromJsonFile("TestData", "name"));
        LogsUtils.info("Gender: " + readFromJsonFile("TestData", "gender"));

        new P02_ShopPage(getDriver())
                .addFirstProductToCart()
                .clickOnCartIcon();
        LogsUtils.info("First product added");

        new P03_CartPage(getDriver())
                .clickOnCheckbox()
                .clickOnVisitWebsiteButton();

        Thread.sleep(1000);
        Set<String> context = getDriver().getContextHandles();
        for (String con : context) {
            if (!con.equals("NATIVE_APP")) {
                getDriver().context(con);
            }
        }

        getDriver().get(readFromPropertiesFile("environment", "URL"));
        LogsUtils.info("Actual URL:" + getDriver().getCurrentUrl());
        LogsUtils.info("Expected URL:" + readFromPropertiesFile("environment", "URL"));
        Assert.assertEquals(getDriver().getCurrentUrl(), readFromPropertiesFile("environment", "URL"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
        LogsUtils.info("Application is closed");
    }

    @AfterClass
    public void stopServer() {
        ServerFactory.stopServer();
        LogsUtils.info("Appium server stopped");
    }
}
