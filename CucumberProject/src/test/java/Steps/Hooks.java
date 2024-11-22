package Steps;

import DriverFactory.DriverFactory;
import Utilities.LogsUtils;
import Utilities.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import static Utilities.DataUtils.readFromPropertiesFile;

public class Hooks {
    @Before
    public void setupScenario(Scenario scenario) throws IOException {
        LogsUtils.info(scenario.getName() + " started");
        DriverFactory.setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        LogsUtils.info(scenario.getName() + " finished");
        if (scenario.isFailed()) {
            LogsUtils.info(scenario.getName() + " failed");
            Utility.takeScreenshot(DriverFactory.getDriver(), scenario.getName());
        } else {
            LogsUtils.info(scenario.getName() + " passed");
        }
        DriverFactory.quitDriver();
    }
}
