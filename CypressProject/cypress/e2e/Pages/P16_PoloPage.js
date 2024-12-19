/// <reference types = "cypress" /> 

import MadamePage from '../Pages/P17_MadamePage';

class PoloPage {
    poloBrandTitleTextLocator = 'Brand - Polo Products';
    madameBrandButton = '[href = "/brand_products/Madame"]';

    verifyVisibilityOfPoloBrandTitleText() {
        cy.contains(this.poloBrandTitleTextLocator).should('be.visible');
    }

    clickOnMadameBrandButton() {
        cy.get(this.madameBrandButton).click();
        return MadamePage;
    }
}
export default new PoloPage();