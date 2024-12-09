/// <reference types = "cypress"/>

import HomePage from '../Pages/P01_HomePage'
import LoginPage from '../Pages/P02_LoginPage'
import RegisterPage from '../Pages/P03_RegisterPage'
import AccountCreatedPage from '../Pages/P04_AccountCreatedPage'
import DeleteAccountPage from "../Pages/P05_DeleteAccountPage";

it("Register User", () => {
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

    HomePage.clickOnDeleteAccount()
        .verifyVisibilityOfAccountDeletedText();

    DeleteAccountPage.clickOnContinueButton();
})

