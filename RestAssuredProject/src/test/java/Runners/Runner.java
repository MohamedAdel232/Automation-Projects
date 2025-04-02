package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "Steps",
        plugin = {"pretty", "html:TestOutputs/Reports/cucumber-report.html"},
        monochrome = true,
        tags = "not @Skip"
)
public class Runner {
}
