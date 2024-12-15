/// <reference types = "cypress"/> 

class CheckoutPage {
    addressDetailsTextLocator = 'Address Details';
    reviewYourOrderTextLocator = 'Review Your Order';
    commentFieldLocator = 'textarea';
    placeOrderButtonLocator = '[href="/payment"]';

    verifyVisibilityOfAddressDetailsText() {
        cy.contains(this.addressDetailsTextLocator).should('be.visible');
    }

    verifyVisibilityOfReviewYourOrderText() {
        cy.contains(this.reviewYourOrderTextLocator).should('be.visible');
    }

    enterComment(comment) {
        cy.get(this.commentFieldLocator).type(comment);
        return this;
    }

    clickOnPlaceOrderButton() {
        cy.get(this.placeOrderButtonLocator).click();
    }
}

export default new CheckoutPage();