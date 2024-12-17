/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage';
import CartPage from '../Pages/P11_CartPage';


it("Remove Product From Cart", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnAddToCartButton1()
        .clickOnContinueShoppingButton()
        .clickOnCartButton()
        .verifyVisibilityOfShoppingCartText();

    CartPage.clickOnRemoveProductButton()
        .verifyVisibilityOfCartEmptyText();
});