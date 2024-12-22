/// <reference types = "cypress"/> 

import HomePage from '../Pages/P01_HomePage';

it("Verify Scroll up Without Arrow Button", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.scrollToFooter()
        .verifyVisibilityOfSubscriptionText();

    HomePage.scrollTOHomePageLogo()
        .verifyVisibilityOfHomeLogo();
})