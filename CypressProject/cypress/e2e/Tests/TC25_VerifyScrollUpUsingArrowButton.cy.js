/// <reference types = "cypress"/> 

import HomePage from '../Pages/P01_HomePage';

it("Verify Scroll up Using Arrow Button", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.scrollToFooter()
        .verifyVisibilityOfSubscriptionText();

    HomePage.clickOnScrollArrowButton()
        .verifyVisibilityOfHomeLogo();
})