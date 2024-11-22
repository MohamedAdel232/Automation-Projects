package Steps;

import Pages.*;
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

public class OverviewSteps {
    @Given("User is on overview page")
    public void userIsOnOverviewPage(DataTable dataTable) throws IOException {
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

        new P04_CheckoutPage(getDriver())
                .enterCheckoutInfo(dataTable.cell(0, 0),
                        dataTable.cell(0, 1),
                        dataTable.cell(0, 2));
        LogsUtils.info("Firstname: " + dataTable.cell(0, 0));
        LogsUtils.info("Lastname: " + dataTable.cell(0, 1));
        LogsUtils.info("Postal code: " + dataTable.cell(0, 2));

        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "OverviewPage")));

    }

    @When("User click on finish button")
    public void userClickOnFinishButton() {
        new P05_OverviewPage(getDriver())
                .clickOnFinishButton();
    }

    @Then("User is redirected to finish page")
    public void userIsRedirectedToFinishPage() throws IOException {
        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "FinishPage")));
    }
}
