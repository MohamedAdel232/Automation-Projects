/// <reference types = "cypress" />

import P01_HomePage from "./P01_HomePage";

class AccountCreatedPage {
    accountCreatedTextLocator = 'b';
    continueButtonLocator = '[data-qa="continue-button"]'

    verifyVisibilityOfAccountCreatedText() {
        cy.get(this.accountCreatedTextLocator).should('be.visible');
    }

    clickOnContinueButton() {
        cy.get(this.continueButtonLocator).click();
        return P01_HomePage;
    }
}

export default new AccountCreatedPage();