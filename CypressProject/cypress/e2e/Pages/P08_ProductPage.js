/// <reference types = "cypress" />

import P09_ProductDetailsPage from "./P09_ProductDetailsPage";
import DressPage from "../Pages/P10_DressPage";
import CartPage from "../Pages/P11_CartPage";

class ProductPage {
    productListLocator = '.features_items';
    viewFirstProductButtonLocator = '[href="/product_details/1"]';
    searchFieldLocator = '[name = "search"]';
    submitSearchButtonLocator = '#submit_search';
    addToCartButton1Locator = '.overlay-content [data-product-id = "1"]';
    addToCartButton2Locator = '.overlay-content [data-product-id = "2"]';
    continueShoppingButtonLocator = '.modal-footer > .btn';
    cartButtonLocator = 'li [href="/view_cart"]';

    verifyVisibilityOfProductList() {
        cy.get(this.productListLocator).should('be.visible');
    }

    clickOnViewFirstProductButton() {
        cy.get(this.viewFirstProductButtonLocator).click();
        return P09_ProductDetailsPage;
    }

    searchForItem(item) {
        cy.get(this.searchFieldLocator).type(item);
        cy.get(this.submitSearchButtonLocator).click();
        return DressPage;
    }

    clickOnAddToCartButton1() {
        cy.get(this.addToCartButton1Locator).click({ force: true });
        return this;
    }

    clickOnAddToCartButton2() {
        cy.get(this.addToCartButton2Locator).click({ force: true });
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

export default new ProductPage();