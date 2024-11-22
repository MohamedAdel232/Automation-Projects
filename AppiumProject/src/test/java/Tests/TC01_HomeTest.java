package Tests;

import Factories.DriverFactory;
import Factories.ServerFactory;
import Listeners.Listener;
import Pages.P01_HomePage;
import Utilities.DataUtils;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@Listeners(Listener.class)
public class TC01_HomeTest {
    @BeforeClass
    public void startServer() {
        ServerFactory.startServer();
    }

    @BeforeMethod
    public void setupDriver() throws IOException {
        DriverFactory.setupDriver();
    }

    @Test
    public void testCase() throws FileNotFoundException {
        new P01_HomePage(DriverFactory.getDriver())
                .clickOnSelectCountry()
                .selectCountry()
                .enterName(DataUtils.readFromJsonFile("TestData", "name"))
                .clickOnLetsShopButton();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterClass
    public void stopServer() {
        ServerFactory.stopServer();
    }
}
