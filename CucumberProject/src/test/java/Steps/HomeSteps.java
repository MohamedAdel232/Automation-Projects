package Steps;

import Pages.P01_LoginPage;
import Pages.P02_HomePage;
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

public class HomeSteps {
    @When("User click on add to cart button")
    public static void clickOnAddToCartButton() {
        new P02_HomePage(getDriver()).clickOnAddToCartButton();
        LogsUtils.info("First product is added");
    }

    @Given("User is on home page")
    public void userIsOnHomePage() throws IOException {
        getDriver().get(readFromPropertiesFile("environment", "LoginPage"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

        new P01_LoginPage(getDriver())
                .enterUsername(readFromJsonFile("ValidLoginData", "username"))
                .enterPassword(readFromJsonFile("ValidLoginData", "password"))
                .clickOnLoginButton();
        LogsUtils.info("Username: " + readFromJsonFile("ValidLoginData", "username"));
        LogsUtils.info("Password: " + readFromJsonFile("ValidLoginData", "password"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "HomePage")));
    }

    @Then("Product is added to cart")
    public void productIsAddedToCart() {
        Assert.assertTrue(new P02_HomePage(getDriver()).verifyVisibilityOfRemoveButton());
    }

    @When("User click on cart button")
    public void clickOnCartButton() {
        new P02_HomePage(getDriver())
                .clickOnCartButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
    }

    @Then("User is redirected to cart page")
    public void userRedirectedToCartPage() throws IOException {
        Assert.assertTrue(Utility.verifyNavigatingToUrl(getDriver(), readFromPropertiesFile("environment", "CartPage")));
    }
}
