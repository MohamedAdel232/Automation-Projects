package Steps;

import Pages.P01_LoginPage;
import Utilities.LogsUtils;
import Utilities.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.getDriver;
import static Utilities.DataUtils.readFromJsonFile;
import static Utilities.DataUtils.readFromPropertiesFile;

public class LoginSteps {
    @Given("User is on login page")
    public static void userIsOnLoginPage() throws IOException {
        getDriver().get(readFromPropertiesFile("environment", "LoginPage"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "LoginPage")));
    }

    @When("User enter a valid username and password")
    public static void userEnterValidUsernameAndPassword() throws FileNotFoundException {
        new P01_LoginPage(getDriver())
                .enterUsername(readFromJsonFile("ValidLoginData", "username"))
                .enterPassword(readFromJsonFile("ValidLoginData", "password"))
                .clickOnLoginButton();
        LogsUtils.info("Username: " + readFromJsonFile("ValidLoginData", "username"));
        LogsUtils.info("Password: " + readFromJsonFile("ValidLoginData", "password"));
    }

    @Then("User is redirected to home page")
    public static void userIsRedirectedToHomePage() throws IOException {
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "HomePage")));
    }

    @When("User enter an invalid {string} and {string}")
    public static void userEnterInvalidUsernameAndPassword(String username, String password) {
        new P01_LoginPage(getDriver())
                .enterUsername(username)
                .enterPassword(password)
                .clickOnLoginButton();
        LogsUtils.info("Username: " + username);
        LogsUtils.info("Password: " + password);
    }

    @Then("An error message appears that tells the user he entered invalid data")
    public static void errorMessageAppear() {
        Assert.assertTrue(new P01_LoginPage(getDriver()).checkVisibilityOfInvalidLoginDataText());
    }
}
