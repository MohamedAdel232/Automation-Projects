/// <reference types = "cypress"/>

import P02_LoginPage from "./P02_LoginPage";
import P05_DeleteAccountPage from "./P05_DeleteAccountPage";
import P06_ContactUsPage from "./P06_ContactUsPage";
import P07_TestcasePae from "./P07_TestcasePage";
import P08_ProductPage from "./P08_ProductPage";

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
}

export default new HomePage();