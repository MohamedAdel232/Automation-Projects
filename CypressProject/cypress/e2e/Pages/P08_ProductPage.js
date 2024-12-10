/// <reference types = "cypress" />

import P09_ProductDetailsPage from "./P09_ProductDetailsPage";

class ProductPage {
    productListLocator = '.features_items';
    viewFirstProductButtonLocator = '[href="/product_details/1"]';

    verifyVisibilityOfProductList() {
        cy.get(this.productListLocator).should('be.visible');
    }

    clickOnViewFirstProductButton() {
        cy.get(this.viewFirstProductButtonLocator).click();
        return P09_ProductDetailsPage;
    }
}

export default new ProductPage();