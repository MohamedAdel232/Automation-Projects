/// <reference types = "cypress"/> 

import HomePage from '../Pages/P01_HomePage';
import CartPage from '../Pages/P11_CartPage';
import LoginPage from '../Pages/P02_LoginPage';
import RegisterPage from '../Pages/P03_RegisterPage'
import AccountCreatedPage from '../Pages/P04_AccountCreatedPage'
import DeleteAccountPage from "../Pages/P05_DeleteAccountPage";
import CheckoutPage from '../Pages/P12_CheckoutPage';
import PaymentPage from '../Pages/P13_PaymentPage';
import PaymentDone from '../Pages/P14_PaymentDonePage';

it("Download Invoice After Purchase Order", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnLoginButton();
    cy.fixture("ValidRegisterData").then(ValidRegisterData => {
        LoginPage.enterRegisterData(ValidRegisterData.name, ValidRegisterData.email)
            .clickOnSignupButton()
            .verifyVisibilityOfEnterAccountInfoText();
    });

    cy.fixture("ValidRegisterData").then(ValidRegisterData => {
        RegisterPage.enterRegisterData(
            ValidRegisterData.gender,
            ValidRegisterData.password,
            ValidRegisterData.day,
            ValidRegisterData.month,
            ValidRegisterData.year,
            ValidRegisterData.firstName,
            ValidRegisterData.lastName,
            ValidRegisterData.company,
            ValidRegisterData.address1,
            ValidRegisterData.address2,
            ValidRegisterData.country,
            ValidRegisterData.state,
            ValidRegisterData.city,
            ValidRegisterData.zipCode,
            ValidRegisterData.mobileNumber,
        )
            .clickOnCreateAccountButton();
    });
    AccountCreatedPage.verifyVisibilityOfAccountCreatedText();

    AccountCreatedPage.clickOnContinueButton()
        .verifyVisibilityOfLoggedInText();

    HomePage.clickOnAddToCartButton1()
        .clickOnContinueShoppingButton()
        .clickOnCartButton()
        .verifyVisibilityOfShoppingCartText();

    CartPage.clickOnProceedToCheckoutButton()
        .verifyVisibilityOfAddressDetailsText();

    CheckoutPage.verifyVisibilityOfReviewYourOrderText();

    cy.fixture("CheckoutData").then(CheckoutData => {
        CheckoutPage.enterComment(CheckoutData.comment)
            .clickOnPlaceOrderButton();
    });

    cy.fixture("PaymentData").then(PaymentData => {
        PaymentPage.fillPaymentInfo(PaymentData.nameOnCard
            , PaymentData.cardNumber,
            PaymentData.cvc,
            PaymentData.month,
            PaymentData.year
        )
            .clickOnPayAndConfirmOrderButton()
            .verifyVisibilityOfOrderPlacedText();
    });
    PaymentDone.clickOnDownloadInvoice();

    HomePage.clickOnDeleteAccount()
        .verifyVisibilityOfAccountDeletedText();

    DeleteAccountPage.clickOnContinueButton();
})