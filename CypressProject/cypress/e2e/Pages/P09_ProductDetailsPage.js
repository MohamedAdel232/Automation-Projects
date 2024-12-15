/// <reference types = "cypress" />

import CartPage from "../Pages/P11_CartPage";

class ProductDetailsPage {
    productInformationLocator = '.product-information';
    quantityFieldLocator = '#quantity';
    addToCartButtonLocator = '[type="button"]';
    continueShoppingButtonLocator = '.modal-footer > .btn';
    cartButtonLocator = 'li [href="/view_cart"]';

    verifyVisibilityOfProductInformation() {
        cy.get(this.productInformationLocator).should('be.visible');
    }

    changeProductQuantity() {
        cy.get(this.quantityFieldLocator).clear().type(4);
        return this;
    }

    clickOnAddToCartButton() {
        cy.get(this.addToCartButtonLocator).click();
        return this;
    }

    clickOnContinueShoppingButton() {
        cy.get(this.continueShoppingButtonLocator).click();
        return this;
    }

    clickOnCartButton() {
        cy.get(this.cartButtonLocator).click();
        return CartPage;
    }
}


export default new ProductDetailsPage();