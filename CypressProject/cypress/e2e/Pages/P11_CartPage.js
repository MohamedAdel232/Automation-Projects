/// <reference types = "cypress"/>

import LoginPage from '../Pages/P02_LoginPage';
import CheckoutPage from '../Pages/P12_CheckoutPage';

class CartPage {
    footerLocator = '#footer';
    subscriptionTextLocator = 'Subscription';
    subscribeEmailFieldLocator = '#susbscribe_email';
    subscribeArrowButtonLocator = '#subscribe';
    successSubscribeTextLocator = '#success-subscribe';
    cartButtonLocator = '[href="/view_cart"]';
    productOneLocator = '#product-1';
    productTwoLocator = '#product-2';
    productQuantityTextLocator = 'button.disabled';
    shoppingCartTextLocator = '.breadcrumb';
    proceedToCheckoutButtonLocator = 'Proceed To Checkout';
    registerButtonLocator = '[href = "/login"] u';


    scrollToFooter() {
        cy.get(this.footerLocator).scrollIntoView();
        return this;
    }

    verifyVisibilityOfSubscriptionText() {
        cy.contains(this.subscriptionTextLocator).should('be.visible');
    }

    enterSubscribeEmail(email) {
        cy.get(this.subscribeEmailFieldLocator).type(email);
        return this;
    }

    clickOnSubscribeArrowButton() {
        cy.get(this.subscribeArrowButtonLocator).click();
    }

    verifyVisibilityOfSuccessSubscriptionText() {
        cy.get(this.successSubscribeTextLocator).should('be.visible');
    }

    clickOnCartButton() {
        cy.get(this.cartButtonLocator).click();
    }

    verifyVisibilityOfProducts() {
        cy.get(this.productOneLocator).should('be.visible');
        cy.get(this.productTwoLocator).should('be.visible');
    }

    verifyProductQuantityText() {
        cy.get(this.productQuantityTextLocator).invoke('text').then(text => {
            expect(text).to.eql('4');
        });
    }

    verifyVisibilityOfShoppingCartText() {
        cy.get(this.shoppingCartTextLocator).should('be.visible');
    }

    clickOnProceedToCheckoutButton() {
        cy.contains(this.proceedToCheckoutButtonLocator).click();
        return CheckoutPage;
    }

    clickOnRegisterButton() {
        cy.get(this.registerButtonLocator).click();
        return LoginPage;
    }
}

export default new CartPage();