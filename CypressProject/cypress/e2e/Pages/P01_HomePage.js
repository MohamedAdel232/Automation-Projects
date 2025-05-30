/// <reference types = "cypress"/>

import P02_LoginPage from "./P02_LoginPage";
import P05_DeleteAccountPage from "./P05_DeleteAccountPage";
import P06_ContactUsPage from "./P06_ContactUsPage";
import P07_TestcasePae from "./P07_TestcasePage";
import P08_ProductPage from "./P08_ProductPage";
import P11_CartPage from "./P11_CartPage";
import DressPage from "../Pages/P10_DressPage";


class HomePage {
    homeLogoLocator = 'a[href = "/"] img';
    loginButtonLocator = 'a[href = "/login"]';
    loggedInTextLocator = ':nth-child(10) > a';
    deleteAccountButtonLocator = '[href="/delete_account"]';
    logoutButtonLocator = '[href="/logout"]';
    contactUsButtonLocator = '[href = "/contact_us"]';
    testCaseButtonLocator = 'li [href = "/test_cases"]';
    productsButtonLocator = '[href = "/products"]';
    footerLocator = '#footer';
    subscriptionTextLocator = 'Subscription';
    subscribeEmailFieldLocator = '#susbscribe_email';
    subscribeArrowButtonLocator = '#subscribe';
    successSubscribeTextLocator = '#success-subscribe';
    cartButtonLocator = 'li [href="/view_cart"]';
    addToCartButton1Locator = '.overlay-content [data-product-id = "1"]';
    continueShoppingButtonLocator = '.modal-footer > .btn';
    categoryTextLocator = 'div.left-sidebar > h2';
    womenCategoryButtonLocator = '[href = "#Women"]';
    dressCategoryButtonLocator = '[href = "/category_products/1"]';
    recommendedItemsLocator = '.recommended_items';
    addRecommendedItemToCartButtonLocator = '.recommended_items [data-product-id = "4"]';
    scrollArrowButtonLocator = '#scrollUp';

    verifyVisibilityOfHomeLogo() {
        cy.get(this.homeLogoLocator).should('be.visible');
    }

    clickOnLoginButton() {
        cy.get(this.loginButtonLocator).click();
        return P02_LoginPage;
    }

    verifyVisibilityOfLoggedInText() {
        cy.get(this.loggedInTextLocator).should('be.visible');
    }

    clickOnDeleteAccount() {
        cy.get(this.deleteAccountButtonLocator).click();
        return P05_DeleteAccountPage;
    }

    clickOnLogoutButton() {
        cy.get(this.logoutButtonLocator).click();
        return P02_LoginPage;
    }

    clickOnContactUsButton() {
        cy.get(this.contactUsButtonLocator).click();
        return P06_ContactUsPage;
    }

    clickOnTestcaseButton() {
        cy.get(this.testCaseButtonLocator).click();
        return P07_TestcasePae;
    }

    clickOnProductsButton() {
        cy.get(this.productsButtonLocator).click();
        return P08_ProductPage;
    }

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
        return P11_CartPage;
    }

    clickOnAddToCartButton1() {
        cy.get(this.addToCartButton1Locator).click({ force: true });
        return this;
    }

    clickOnContinueShoppingButton() {
        cy.get(this.continueShoppingButtonLocator).click();
        return this;
    }

    verifyVisibilityOfCategoryText() {
        cy.get(this.categoryTextLocator).should('be.visible');
    }

    clickOnWomenCategoryButton() {
        cy.get(this.womenCategoryButtonLocator).click();
        return this;
    }

    clickOnDressCategoryButton() {
        cy.get(this.dressCategoryButtonLocator).click();
        return DressPage;
    }

    scrollToRecommendedItems() {
        cy.get(this.recommendedItemsLocator).scrollIntoView();
        return this;
    }

    verifyVisibilityOfRecommendedItems() {
        cy.get(this.recommendedItemsLocator).should('be.visible');
    }

    addRecommendedItemToCartButton() {
        cy.get(this.addRecommendedItemToCartButtonLocator).click();
        return this;
    }

    clickOnScrollArrowButton() {
        cy.get(this.scrollArrowButtonLocator).click();
        return this;
    }

    scrollTOHomePageLogo() {
        cy.get(this.homeLogoLocator).scrollIntoView();
        return this;
    }


}
export default new HomePage();