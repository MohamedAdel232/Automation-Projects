package Tests;

import Factories.DriverFactory;
import Factories.ServerFactory;
import Listeners.Listener;
import Pages.P01_HomePage;
import Pages.P02_ShopPage;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static Factories.DriverFactory.getDriver;
import static Utilities.DataUtils.readFromJsonFile;

@Listeners(Listener.class)
public class TC01_HomeTest {
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
    public void verifyLandingOnHomePage() {
        Assert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfPageTitle());
    }

    @Test
    public void enterUserInfoTC() throws FileNotFoundException {
        new P01_HomePage(getDriver())
                .clickOnSelectCountry()
                .selectCountry(readFromJsonFile("TestData", "country"))
                .enterName(readFromJsonFile("TestData", "name"))
                .selectGender(readFromJsonFile("TestData", "gender"))
                .clickOnLetsShopButton();
        LogsUtils.info("Country: " + readFromJsonFile("TestData", "country"));
        LogsUtils.info("Name: " + readFromJsonFile("TestData", "name"));
        LogsUtils.info("Gender: " + readFromJsonFile("TestData", "gender"));
        Assert.assertTrue(new P02_ShopPage(getDriver()).verifyVisibilityOfPageTitle());
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
