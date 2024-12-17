/// <reference types = "cypress"/> 

import HomePage from '../Pages/P01_HomePage'
import LoginPage from '../Pages/P02_LoginPage'
import RegisterPage from '../Pages/P03_RegisterPage'
import AccountCreatedPage from '../Pages/P04_AccountCreatedPage'
import DeleteAccountPage from '../Pages/P05_DeleteAccountPage'
import CartPage from '../Pages/P11_CartPage'
import CheckoutPage from '../Pages/P12_CheckoutPage'
import PaymentPage from '../Pages/P13_PaymentPage'

before("Before Testcase", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnLoginButton()
        .verifyVisibilityOfNewUserSignupText();

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

    HomePage.clickOnLogoutButton();
})

it("Valid Login", () => {
    cy.visit('/');

    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnLoginButton()
        .verifyVisibilityOfLoginToYourAccountText();

    cy.fixture("ValidLoginData").then(ValidLoginData => {
        LoginPage.enterLoginData(
            ValidLoginData.email,
            ValidLoginData.password)
            .clickOnLoginButton();
    });

    HomePage.verifyVisibilityOfLoggedInText();

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

    HomePage.clickOnDeleteAccount()
        .verifyVisibilityOfAccountDeletedText();

    DeleteAccountPage.clickOnContinueButton();
})