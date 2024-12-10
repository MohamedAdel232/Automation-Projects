/// <reference types = "cypress" />

import P03_RegisterPage from "./P03_RegisterPage";

class LoginPage {
    newUserSignupTextLocator = 'New User Signup!';
    loginToYourAccountTextLocator = 'Login to your account';
    registerNameLocator = 'input[data-qa="signup-name"]';
    registerEmailLocator = 'input[data-qa="signup-email"]';
    signupButtonLocator = 'button[data-qa="signup-button"]';
    loginEmailFieldLocator = '[data-qa= "login-email"]';
    loginPasswordFieldLocator = '[data-qa= "login-password"]';
    loginButtonLocator = '[data-qa= "login-button"]';
    incorrectDataTextLocator = '.login-form > form > p';
    emailAlreadyRegisteredTextLocator = 'Email Address already exist!';

    verifyVisibilityOfNewUserSignupText() {
        cy.contains(this.newUserSignupTextLocator).should('be.visible');
    }

    enterRegisterData(name, email) {
        cy.get(this.registerNameLocator).type(name);
        cy.get(this.registerEmailLocator).type(email);
        return this;
    }

    clickOnSignupButton() {
        cy.get(this.signupButtonLocator).click();
        return P03_RegisterPage;
    }

    verifyVisibilityOfLoginToYourAccountText() {
        cy.contains(this.loginToYourAccountTextLocator).should('be.visible');
    }

    enterLoginData(email, password) {
        cy.get(this.loginEmailFieldLocator).type(email);
        cy.get(this.loginPasswordFieldLocator).type(password);
        return this;
    }

    clickOnLoginButton() {
        cy.get(this.loginButtonLocator).click();
    }

    verifyVisibilityOfIncorrectDataText() {
        cy.get(this.incorrectDataTextLocator).should('be.visible');
    }

    verifyVisibilityOfEmailAlreadyRegisteredText() {
        cy.contains(this.emailAlreadyRegisteredTextLocator).should('be.visible');
    }
}

export default new LoginPage();
