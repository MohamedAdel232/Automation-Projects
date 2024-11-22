package Steps;

import Pages.*;
import Utilities.LogsUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;

import static DriverFactory.DriverFactory.getDriver;
import static Utilities.DataUtils.readFromJsonFile;
import static Utilities.DataUtils.readFromPropertiesFile;

public class FinishSteps {
    @Given("User is on finish page")
    public void userIsOnFinishPage(DataTable dataTable) throws IOException {
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

        new P05_OverviewPage(getDriver())
                .clickOnFinishButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
    }

    @Then("Thanks message is visible")
    public void thanksMessageIsVisible() {
        Assert.assertTrue(new P06_FinishPage(getDriver()).checkVisibilityOfThanksMessageText());
    }
}
