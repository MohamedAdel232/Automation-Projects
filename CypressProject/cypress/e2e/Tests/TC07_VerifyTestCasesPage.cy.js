/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage'

it("Verify Test Case Page", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnTestcaseButton()
        .verifyVisibilityOfTestcasesText();
})