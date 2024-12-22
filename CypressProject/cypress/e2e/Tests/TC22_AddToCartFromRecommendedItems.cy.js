/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage';

it("Add to Cart From Recommended Items", () => {
    cy.visit('/');
    HomePage.scrollToRecommendedItems()
        .verifyVisibilityOfRecommendedItems();

    HomePage.addRecommendedItemToCartButton()
        .clickOnContinueShoppingButton()
        .clickOnCartButton()
        .verifyVisibilityOfRecommendedProduct();
});