/// <reference types = "cypress"/> 

class PaymentDonePage {
    orderPlacedTextLocator = 'Order Placed!';

    verifyVisibilityOfOrderPlacedText() {
        cy.contains(this.orderPlacedTextLocator).should('be.visible');
    }
}

export default new PaymentDonePage();