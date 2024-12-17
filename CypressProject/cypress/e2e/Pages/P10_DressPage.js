/// <reference types = "cypress"/>

import JeansPage from './P15_JeansPage'

class DressPage {
    searchedProductsTextLocator = 'Searched Products';
    searchedProductsLocator = '.features_items';
    dressTitleTextLocator = 'h2.title';
    menCategoryButtonLocator = '[href="#Men"]';
    jeansCategoryButtonLocator = '[href="/category_products/6"]';

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
}

export default new DressPage();
