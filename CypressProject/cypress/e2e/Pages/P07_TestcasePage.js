/// <reference types = "cypress" />

class TestcasePage {
    testcasesTextLocator = 'b';

    verifyVisibilityOfTestcasesText() {
        cy.get(this.testcasesTextLocator).should('be.visible');
    }
}

export default new TestcasePage();