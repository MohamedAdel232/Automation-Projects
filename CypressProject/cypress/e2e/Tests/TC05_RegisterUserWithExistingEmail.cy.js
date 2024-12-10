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

    cy.fixture("InvalidRegisterData").then(InvalidRegisterData => {
        LoginPage.enterRegisterData(InvalidRegisterData.name, InvalidRegisterData.email)
            .clickOnSignupButton();
    });
    LoginPage.verifyVisibilityOfEmailAlreadyRegisteredText();
})

