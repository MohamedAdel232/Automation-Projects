/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage'
import CartPage from '../Pages/P11_CartPage'


it("Search Product", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnCartButton()
        .scrollToFooter()
        .verifyVisibilityOfSubscriptionText();

    cy.fixture("ValidLoginData").then(ValidLoginData => {
        CartPage.enterSubscribeEmail(ValidLoginData.email)
            .clickOnSubscribeArrowButton();
    });
    CartPage.verifyVisibilityOfSuccessSubscriptionText();
})