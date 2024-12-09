/// <reference types = "cypress"/>

import P02_LoginPage from "./P02_LoginPage";
import P05_DeleteAccountPage from "./P05_DeleteAccountPage";

class HomePage {
    homeLogoLocator = 'a[href = "/"] img';
    loginButtonLocator = 'a[href = "/login"]';
    loggedInTextLocator = ':nth-child(10) > a';
    deleteAccountButtonLocator = '[href="/delete_account"]';

    verifyVisibilityOfHomeLogo() {
        cy.get(this.homeLogoLocator).should('be.visible');
    }

    clickOnLoginButton() {
        cy.get(this.loginButtonLocator).click();
        return P02_LoginPage;
    }

    verifyVisibilityOfLoggedInText() {
        cy.get(this.loggedInTextLocator).should('be.visible');
    }

    clickOnDeleteAccount() {
        cy.get(this.deleteAccountButtonLocator).click();
        return P05_DeleteAccountPage;
    }
}

export default new HomePage();