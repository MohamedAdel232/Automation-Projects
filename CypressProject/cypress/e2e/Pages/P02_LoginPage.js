/// <reference types = "cypress" />

import P03_RegisterPage from "./P03_RegisterPage";

class LoginPage {
    newUserSignupTextLocator = 'New User Signup!';
    registerNameLocator = 'input[data-qa="signup-name"]';
    registerEmailLocator = 'input[data-qa="signup-email"]';
    signupButtonLocator = 'button[data-qa="signup-button"]';

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
}

export default new LoginPage();
