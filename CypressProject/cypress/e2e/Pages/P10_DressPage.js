/// <reference types = "cypress"/>

import JeansPage from './P15_JeansPage'
import CartPage from './P11_CartPage'

class DressPage {
    searchedProductsTextLocator = 'Searched Products';
    searchedProductsLocator = '.features_items';
    dressTitleTextLocator = 'h2.title';
    menCategoryButtonLocator = '[href="#Men"]';
    jeansCategoryButtonLocator = '[href="/category_products/6"]';
    addToCartButtonLocator = '.overlay-content [data-product-id = "3"]';
    continueShoppingButtonLocator = '.modal-footer > .btn';
    cartButtonLocator = 'li [href="/view_cart"]';


    verifyVisibilityOfSearchedProductsText() {
        cy.contains(this.searchedProductsTextLocator).should('be.visible');
    }

    verifyVisibilityOfSearchedProducts() {
        cy.get(this.searchedProductsLocator).should('be.visible');
    }

    verifyVisibilityOfDressTitleText() {
        cy.get(this.dressTitleTextLocator).should('be.visible');
    }

    clickOnMenCategoryButton() {
        cy.get(this.menCategoryButtonLocator).click();
        return this;
    }

    clickOnJeansCategoryButton() {
        cy.get(this.jeansCategoryButtonLocator).click();
        return JeansPage;
    }

    clickOnAddToCartButton() {
        cy.get(this.addToCartButtonLocator).click({ force: true });
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

export default new DressPage();
