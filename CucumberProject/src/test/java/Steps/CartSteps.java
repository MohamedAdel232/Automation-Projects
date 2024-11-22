package Steps;

import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_CartPage;
import Utilities.LogsUtils;
import Utilities.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static DriverFactory.DriverFactory.getDriver;
import static Utilities.DataUtils.readFromJsonFile;
import static Utilities.DataUtils.readFromPropertiesFile;

public class CartSteps {
    @Given("User is on the cart page")
    public void userOnCartPage() throws IOException {
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
        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "CartPage")));
    }

    @When("User click on checkout button")
    public void userClickOnCheckoutButton() {
        new P03_CartPage(getDriver())
                .clickOnCheckoutButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
    }

    @Then("User is redirected to checkout button")
    public void userIsRedirectedToCheckoutButton() throws IOException {
        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "CheckoutPage")));
    }
}
