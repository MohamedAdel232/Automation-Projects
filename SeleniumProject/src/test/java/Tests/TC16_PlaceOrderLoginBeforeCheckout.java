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
public class TC16_PlaceOrderLoginBeforeCheckout {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));

        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("URL: " + readFromPropertiesFile("environment", "HomePage"));

        new P01_HomePage(getDriver()).clickOnLoginButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

        new P02_LoginPage(getDriver())
                .enterName(readFromJsonFile("RegisterData", "name"))
                .enterEmail(readFromJsonFile("RegisterData", "email"))
                .clickOnSignupButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());

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

        new P04_AccountCreatedPage(getDriver()).clickOnContinueButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        getDriver().quit();
    }

    @Test
    public void placeOrderRegisterBeforeCheckout() throws IOException {
        setupDriver(readFromPropertiesFile("environment", "browser"));
        LogsUtils.info("Browser: " + readFromPropertiesFile("environment", "browser"));

        getDriver().get(readFromPropertiesFile("environment", "HomePage"));
        LogsUtils.info("URL: " + readFromPropertiesFile("environment", "HomePage"));

        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfAutomationExerciseLogo());

        new P01_HomePage(getDriver()).clickOnLoginButton();
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P02_LoginPage(getDriver()).verifyVisibilityOfLoginToYourAccountText());

        new P02_LoginPage(getDriver())
                .enterLoginEmail(readFromJsonFile("RegisterData", "email"))
                .enterLoginPassword(readFromJsonFile("RegisterData", "password"))
                .clickOnLoginButton();
        LogsUtils.info("email: " + readFromJsonFile("RegisterData", "email"));
        LogsUtils.info("password: " + readFromJsonFile("RegisterData", "password"));
        LogsUtils.info("URL: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P01_HomePage(getDriver()).verifyVisibilityOfLoggedInAsText());
        
        new P01_HomePage(getDriver()).addFirstProductToCart().clickOnCartButton();
        LogsUtils.info("url: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P12_CartPage(getDriver()).verifyVisibilityOfProduct());

        new P12_CartPage(getDriver()).clickOnProceedToCheckoutButtonWhileLoggedIn();
        LogsUtils.info("url: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P13_CheckoutPage(getDriver()).verifyVisibilityOfOrderDetails());

        new P13_CheckoutPage(getDriver())
                .enterComment(readFromPropertiesFile("ProductData", "comment"))
                .clickOnPlaceOrderButton();
        LogsUtils.info("Comment: " + readFromPropertiesFile("ProductData", "comment"));
        LogsUtils.info("url: " + getDriver().getCurrentUrl());

        new P14_PlaceOrderPage(getDriver())
                .fillOutOrderInfo(
                        readFromJsonFile("PlaceOrderInfo", "nameOnCard"),
                        readFromJsonFile("PlaceOrderInfo", "cardNumber"),
                        readFromJsonFile("PlaceOrderInfo", "cvc"),
                        readFromJsonFile("PlaceOrderInfo", "expiryMonth"),
                        readFromJsonFile("PlaceOrderInfo", "expiryYear")
                ).clickOnPayAncConfirmButton();

        LogsUtils.info("Name on card: " + readFromJsonFile("PlaceOrderInfo", "nameOnCard"));
        LogsUtils.info("Card number: " + readFromJsonFile("PlaceOrderInfo", "cardNumber"));
        LogsUtils.info("CVC: " + readFromJsonFile("PlaceOrderInfo", "cvc"));
        LogsUtils.info("Expiry month: " + readFromJsonFile("PlaceOrderInfo", "expiryMonth"));
        LogsUtils.info("Expiry year: " + readFromJsonFile("PlaceOrderInfo", "expiryYear"));
        softAssert.assertTrue(new P15_OrderPlacedPage(getDriver()).verifyVisibilityOfOrderPlacedText());

        new P15_OrderPlacedPage(getDriver()).clickOnDeleteAccountButton();
        LogsUtils.info("url: " + getDriver().getCurrentUrl());
        softAssert.assertTrue(new P05_DeleteAccountPage(getDriver()).verifyVisibilityOfAccountDeletedText());

        new P05_DeleteAccountPage(getDriver()).clickOnContinueButton();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
