/// <reference types = "cypress"/>

import HomePage from '../Pages/P01_HomePage'
import LoginPage from '../Pages/P02_LoginPage'

it("Register User With Existing Email", () => {
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

