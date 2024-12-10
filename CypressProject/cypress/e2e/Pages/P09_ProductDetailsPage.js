/// <reference types = "cypress" />

class ProductDetailsPage {
    productInformationLocator = '.product-information';

    verifyVisibilityOfProductInformation() {
        cy.get(this.productInformationLocator).should('be.visible');
    }
}


export default new ProductDetailsPage();