/// <reference types = "cypress" /> 

class MadamePage {
    madameBrandTitleTextLocator = 'Brand - Madame Products';

    verifyVisibilityOfMadameBrandTitleText() {
        cy.contains(this.madameBrandTitleTextLocator).should('be.visible');
    }
}
export default new MadamePage();