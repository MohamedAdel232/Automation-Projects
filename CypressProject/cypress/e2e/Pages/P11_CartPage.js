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
    productThreeLocator = '#product-3';
    productFourLocator = '#product-4';
    productQuantityTextLocator = 'button.disabled';
    shoppingCartTextLocator = '.breadcrumb';
    proceedToCheckoutButtonLocator = 'Proceed To Checkout';
    registerButtonLocator = '[href = "/login"] u';
    removeProductButtonLocator = '.cart_quantity_delete';
    cartEmptyTextLocator = 'Cart is empty!';
    loginButtonLocator = 'li a[href = "/login"]';


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

    verifyVisibilityOfProduct() {
        cy.get(this.productThreeLocator).should('be.visible');
    }

    verifyVisibilityOfRecommendedProduct() {
        cy.get(this.productFourLocator).should('be.visible');
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

    clickOnLoginButton() {
        cy.get(this.loginButtonLocator).click();
        return LoginPage;
    }

    clickOnRemoveProductButton() {
        cy.get(this.removeProductButtonLocator).click();
        return this;
    }

    verifyVisibilityOfCartEmptyText() {
        cy.contains(this.cartEmptyTextLocator).should('be.visible');
    }
}

export default new CartPage();