/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage'

it("Add Products In Cart", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnProductsButton()
        .clickOnAddToCartButton1()
        .clickOnContinueShoppingButton()
        .clickOnAddToCartButton2()
        .clickOnContinueShoppingButton()
        .clickOnCartButton()
        .verifyVisibilityOfProducts();
})