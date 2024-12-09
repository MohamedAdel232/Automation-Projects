/// <reference types= "cypress" />

class DeleteAccountPage {
    accountDeletedTextLocator = 'Account Deleted!';
    continueButtonLocator = '[data-qa="continue-button"]';

    verifyVisibilityOfAccountDeletedText() {
        cy.contains(this.accountDeletedTextLocator).should('be.visible');
    }

    clickOnContinueButton() {
        cy.get(this.continueButtonLocator).click();
    }
}

export default new DeleteAccountPage();