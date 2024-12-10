/// <reference types = "cypress" />

import P09_ProductDetailsPage from "./P09_ProductDetailsPage";
import DressPage from "../Pages/P10_DressPage";

class ProductPage {
    productListLocator = '.features_items';
    viewFirstProductButtonLocator = '[href="/product_details/1"]';
    searchFieldLocator = '[name = "search"]';
    submitSearchButtonLocator = '#submit_search';

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
}

export default new ProductPage();