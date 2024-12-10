/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage'
import TestcasePage from '../Pages/P07_TestcasePage'

it("Verify Test Case Page", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnTestcaseButton()
        .verifyVisibilityOfTestcasesText();
})