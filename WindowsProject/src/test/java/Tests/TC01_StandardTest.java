package Tests;

import Factories.DriverFactory;
import Factories.ServerFactory;
import Listeners.Listener;
import Pages.P01_StandardPage;
import Utilities.LogsUtils;
import Utilities.Utility;
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

    @Test
    public void verifyAdditionFunctionalityTC() {
        int numberOne = Utility.generateRandomNumber();
        int numberTwo = Utility.generateRandomNumber();
        int expectedResult = numberOne + numberTwo;
        new P01_StandardPage(getDriver())
                .enterNumber(numberOne)
                .clickOnAdditionButton()
                .enterNumber(numberTwo)
                .clickOnEqualButton();
        LogsUtils.info("Number one: " + numberOne);
        LogsUtils.info("Number two: " + numberTwo);
        LogsUtils.info("Expected result: " + expectedResult);
        LogsUtils.info("Actual result: " + new P01_StandardPage(getDriver()).getResult());

        Assert.assertTrue(new P01_StandardPage(getDriver()).verifyResult(expectedResult));
    }

    @Test
    public void verifySubtractionFunctionalityTC() {
        int numberOne = Utility.generateRandomNumber();
        int numberTwo = Utility.generateRandomNumber();
        int expectedResult = numberOne - numberTwo;
        new P01_StandardPage(getDriver())
                .enterNumber(numberOne)
                .clickOnSubtractionButton()
                .enterNumber(numberTwo)
                .clickOnEqualButton();
        LogsUtils.info("Number one: " + numberOne);
        LogsUtils.info("Number two: " + numberTwo);
        LogsUtils.info("Expected result: " + expectedResult);
        LogsUtils.info("Actual result: " + new P01_StandardPage(getDriver()).getResult());

        Assert.assertTrue(new P01_StandardPage(getDriver()).verifyResult(expectedResult));
    }

    @Test
    public void verifyMultiplicationFunctionalityTC() {
        int numberOne = Utility.generateRandomNumber();
        int numberTwo = Utility.generateRandomNumber();
        int expectedResult = numberOne * numberTwo;
        new P01_StandardPage(getDriver())
                .enterNumber(numberOne)
                .clickOnMultiplicationButton()
                .enterNumber(numberTwo)
                .clickOnEqualButton();
        LogsUtils.info("Number one: " + numberOne);
        LogsUtils.info("Number two: " + numberTwo);
        LogsUtils.info("Expected result: " + expectedResult);
        LogsUtils.info("Actual result: " + new P01_StandardPage(getDriver()).getResult());

        Assert.assertTrue(new P01_StandardPage(getDriver()).verifyResult(expectedResult));
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
