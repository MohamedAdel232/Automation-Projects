/// <reference types = "cypress"/>

class JeansPage {
    jeansTitleTextLocator = 'h2.title';

    verifyVisibilityOfJeansTitleText() {
        cy.get(this.jeansTitleTextLocator).should('be.visible');
    }
}
export default new JeansPage();
