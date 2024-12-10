/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage'
import ProductsPage from '../Pages/P08_ProductPage'
import ProductDetailsPage from '../Pages/P09_ProductDetailsPage'

it("Verify Test Case Page", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnProductsButton();
    cy.fixture("Url").then(Url => {
        cy.url().should('eql', Url.ProductsPage);
    });
    ProductsPage.verifyVisibilityOfProductList();

    ProductsPage.clickOnViewFirstProductButton();
    cy.fixture("Url").then(Url => {
        cy.url().should('eql', Url.ProductDetailsPage);
    });
    ProductDetailsPage.verifyVisibilityOfProductInformation();

})