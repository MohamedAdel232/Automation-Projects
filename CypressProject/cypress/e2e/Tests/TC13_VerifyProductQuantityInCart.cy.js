/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage'
import ProductDetailsPage from '../Pages/P09_ProductDetailsPage';

it("Add Products In Cart", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnProductsButton()
        .clickOnViewFirstProductButton()
        .verifyVisibilityOfProductInformation();

    ProductDetailsPage.changeProductQuantity()
        .clickOnAddToCartButton()
        .clickOnContinueShoppingButton()
        .clickOnCartButton()
        .verifyProductQuantityText();
})