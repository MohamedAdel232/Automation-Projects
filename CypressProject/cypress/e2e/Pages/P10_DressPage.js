/// <reference types = "cypress"/>

class DressPage {
    searchedProductsTextLocator = 'Searched Products';
    searchedProductsLocator = '.features_items';

    verifyVisibilityOfSearchedProductsText() {
        cy.contains(this.searchedProductsTextLocator).should('be.visible');
    }

    verifyVisibilityOfSearchedProducts() {
        cy.get(this.searchedProductsLocator).should('be.visible');
    }
}

export default new DressPage();
