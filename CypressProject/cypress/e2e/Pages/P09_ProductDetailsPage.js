/// <reference types = "cypress" />

import CartPage from "../Pages/P11_CartPage";

class ProductDetailsPage {
    productInformationLocator = '.product-information';
    quantityFieldLocator = '#quantity';
    addToCartButtonLocator = '[type="button"]';
    continueShoppingButtonLocator = '.modal-footer > .btn';
    cartButtonLocator = 'li [href="/view_cart"]';
    writeYourReviewTextLocator = '[href ="#reviews"]';
    nameFieldLocator = '#name';
    emailFieldLocator = '#email';
    reviewFieldLocator = '[name= "review"]';
    submitButtonLocator = '#button-review';
    thanksMessageTextLocator = 'Thank you for your review.';

    verifyVisibilityOfProductInformation() {
        cy.get(this.productInformationLocator).should('be.visible');
    }

    changeProductQuantity() {
        cy.get(this.quantityFieldLocator).clear().type(4);
        return this;
    }

    clickOnAddToCartButton() {
        cy.get(this.addToCartButtonLocator).click();
        return this;
    }

    clickOnContinueShoppingButton() {
        cy.get(this.continueShoppingButtonLocator).click();
        return this;
    }

    clickOnCartButton() {
        cy.get(this.cartButtonLocator).click();
        return CartPage;
    }

    verifyVisibilityOfWriteYourReviewText() {
        cy.get(this.writeYourReviewTextLocator).should('be.visible');
    }

    writeReview(name, email, review) {
        cy.get(this.nameFieldLocator).type(name);
        cy.get(this.emailFieldLocator).type(email);
        cy.get(this.reviewFieldLocator).type(review);
        return this;
    }

    clickOnSubmitButton() {
        cy.get(this.submitButtonLocator).click();
        return this;
    }

    verifyVisibilityOfThanksMessage() {
        cy.contains(this.thanksMessageTextLocator).should('be.visible');
    }
}


export default new ProductDetailsPage();