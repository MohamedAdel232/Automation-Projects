package Tests;

import Factories.DriverFactory;
import Factories.ServerFactory;
import Listeners.Listener;
import Pages.P01_StandardPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static Factories.DriverFactory.getDriver;

@Listeners(Listener.class)
public class TC01_StandardTest {
    @BeforeClass
    public void setupServer() {
        ServerFactory.startServer();
    }

    @BeforeMethod
    public void setupDriver() throws IOException {
        DriverFactory.setupDriver();
    }

    @Test
    public void verifyCalculatorIsOpenedTC() {
        Assert.assertTrue(new P01_StandardPage(getDriver()).verifyCalculatorIsOpened());
    }

    @AfterMethod
    public void tearDownDriver() {
        DriverFactory.quitDriver();
    }

    @AfterClass
    public void tearDownServer() {
        ServerFactory.stopServer();
    }
}
