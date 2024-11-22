package Steps;

import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_CartPage;
import Pages.P04_CheckoutPage;
import Utilities.LogsUtils;
import Utilities.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static DriverFactory.DriverFactory.getDriver;
import static Utilities.DataUtils.readFromJsonFile;
import static Utilities.DataUtils.readFromPropertiesFile;

public class CheckoutSteps {
    @Given("User is on checkout page")
    public void userIsOnCheckoutPage() throws IOException {
        getDriver().get(readFromPropertiesFile("environment", "LoginPage"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

        new P01_LoginPage(getDriver())
                .enterUsername(readFromJsonFile("ValidLoginData", "username"))
                .enterPassword(readFromJsonFile("ValidLoginData", "password"))
                .clickOnLoginButton();
        LogsUtils.info("Username: " + readFromJsonFile("ValidLoginData", "username"));
        LogsUtils.info("Password: " + readFromJsonFile("ValidLoginData", "password"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

        new P02_HomePage(getDriver()).clickOnAddToCartButton();
        LogsUtils.info("First product is added");

        new P02_HomePage(getDriver())
                .clickOnCartButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

        new P03_CartPage(getDriver())
                .clickOnCheckoutButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "CheckoutPage")));
    }

    @When("User enter checkout info and click continue")
    public void userEnterCheckoutInfoAndClickContinue(DataTable dataTable) {
        new P04_CheckoutPage(getDriver())
                .enterCheckoutInfo(dataTable.cell(0, 0),
                        dataTable.cell(0, 1),
                        dataTable.cell(0, 2));
        LogsUtils.info("Firstname: " + dataTable.cell(0, 0));
        LogsUtils.info("Lastname: " + dataTable.cell(0, 1));
        LogsUtils.info("Postal code: " + dataTable.cell(0, 2));
    }

    @Then("User is redirected to overview page")
    public void userIsRedirectedToOverviewPage() throws IOException {
        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "OverviewPage")));
    }
}
