/// <reference types = "cypress"/> 

import HomePage from '../Pages/P01_HomePage'
import LoginPage from '../Pages/P02_LoginPage'

it("Valid Login", () => {
    cy.visit('/');

    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnLoginButton()
        .verifyVisibilityOfLoginToYourAccountText();

    cy.fixture("InvalidLoginData").then(InvalidLoginData => {
        LoginPage.enterLoginData(
            InvalidLoginData.email,
            InvalidLoginData.password)
            .clickOnLoginButton()
    });

    LoginPage.verifyVisibilityOfIncorrectDataText();

})