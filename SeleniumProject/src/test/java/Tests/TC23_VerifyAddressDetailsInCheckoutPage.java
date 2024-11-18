package Tests;

import Listeners.Listener;
import Pages.*;
import Utilities.LogsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.readFromJsonFile;
import static Utilities.DataUtils.readFromPropertiesFile;

@Listeners(Listener.class)
public class TC23_VerifyAddressDetailsInCheckoutPage {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));
        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("url: " + readFromPropertiesFile("environment", "HomePage"));
    }

    @Test
    public void verifyAddressDetailsInCheckoutPage() throws IOException {
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver())
                .clickOnLoginButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P02_LoginPage(getDriver()).verifyVisibilityOfNewUserSignupText());

        new P02_LoginPage(getDriver())
                .enterName(readFromJsonFile("RegisterData", "name"))
                .enterEmail(readFromJsonFile("RegisterData", "email"))
                .clickOnSignupButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P03_SignupPage(getDriver()).verifyVisibilityOfEnterAccountInformationText());

        new P03_SignupPage(getDriver()).fillDetails(
                        readFromJsonFile("RegisterData", "gender"),
                        readFromJsonFile("RegisterData", "password"),
                        readFromJsonFile("RegisterData", "day"),
                        readFromJsonFile("RegisterData", "month"),
                        readFromJsonFile("RegisterData", "year"),
                        readFromJsonFile("RegisterData", "firstname"),
                        readFromJsonFile("RegisterData", "lastname"),
                        readFromJsonFile("RegisterData", "company"),
                        readFromJsonFile("RegisterData", "address1"),
                        readFromJsonFile("RegisterData", "address2"),
                        readFromJsonFile("RegisterData", "country"),
                        readFromJsonFile("RegisterData", "state"),
                        readFromJsonFile("RegisterData", "city"),
                        readFromJsonFile("RegisterData", "zipcode"),
                        readFromJsonFile("RegisterData", "mobileNumber")
                )
                .clickOnNewsletterCheckbox()
                .clickOnSpecialOfferCheckbox()
                .clickOnCreateAccountButton();

        LogsUtils.info("gender: " + readFromJsonFile("RegisterData", "gender"));
        LogsUtils.info("password: " + readFromJsonFile("RegisterData", "password"));
        LogsUtils.info("day: " + readFromJsonFile("RegisterData", "day"));
        LogsUtils.info("month: " + readFromJsonFile("RegisterData", "month"));
        LogsUtils.info("year: " + readFromJsonFile("RegisterData", "year"));
        LogsUtils.info("firstname: " + readFromJsonFile("RegisterData", "firstname"));
        LogsUtils.info("lastname: " + readFromJsonFile("RegisterData", "lastname"));
        LogsUtils.info("company: " + readFromJsonFile("RegisterData", "company"));
        LogsUtils.info("address1: " + readFromJsonFile("RegisterData", "address1"));
        LogsUtils.info("address2: " + readFromJsonFile("RegisterData", "address2"));
        LogsUtils.info("country: " + readFromJsonFile("RegisterData", "country"));
        LogsUtils.info("state: " + readFromJsonFile("RegisterData", "state"));
        LogsUtils.info("city: " + readFromJsonFile("RegisterData", "city"));
        LogsUtils.info("zipcode: " + readFromJsonFile("RegisterData", "zipcode"));
        LogsUtils.info("mobileNumber: " + readFromJsonFile("RegisterData", "mobileNumber"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P04_AccountCreatedPage(getDriver()).verifyVisibilityOfAccountCreatedText());

        new P04_AccountCreatedPage(getDriver()).clickOnContinueButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfLoggedInAsText());

        new P01_HomePage(getDriver())
                .addFirstProductToCart()
                .clickOnCartButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P12_CartPage(getDriver()).verifyProductsAreVisible());

        new P12_CartPage(getDriver())
                .clickOnProceedToCheckoutButtonWhileLoggedIn();
        LogsUtils.info("company: " + readFromJsonFile("RegisterData", "company"));
        LogsUtils.info("city: " + readFromJsonFile("RegisterData", "address1"));
        LogsUtils.info("address1: " + readFromJsonFile("RegisterData", "address2"));
        softAssert.assertTrue(new P13_CheckoutPage(getDriver()).verifyDeliveryAddress(
                readFromJsonFile("RegisterData", "company"),
                readFromJsonFile("RegisterData", "address1"),
                readFromJsonFile("RegisterData", "address2")));
        softAssert.assertTrue(new P13_CheckoutPage(getDriver()).verifyBillingAddress(
                readFromJsonFile("RegisterData", "company"),
                readFromJsonFile("RegisterData", "address1"),
                readFromJsonFile("RegisterData", "address2")));

        new P01_HomePage(getDriver()).clickOnDeleteAccountButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P05_DeleteAccountPage(getDriver()).verifyVisibilityOfAccountDeletedText());

        new P05_DeleteAccountPage(getDriver()).clickOnContinueButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}