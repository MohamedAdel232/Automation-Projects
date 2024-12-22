/// <reference types = "cypress"/> 

import HomePage from '../Pages/P01_HomePage';
import CartPage from '../Pages/P11_CartPage';
import LoginPage from '../Pages/P02_LoginPage';
import RegisterPage from '../Pages/P03_RegisterPage'
import AccountCreatedPage from '../Pages/P04_AccountCreatedPage'
import DeleteAccountPage from "../Pages/P05_DeleteAccountPage";
import CheckoutPage from '../Pages/P12_CheckoutPage';
import PaymentPage from '../Pages/P13_PaymentPage';
import PaymentDone from '../Pages/P14_PaymentDonePage';

it("Verify Scroll up Using Arrow Button", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.scrollToFooter()
        .verifyVisibilityOfSubscriptionText();

    HomePage.clickOnScrollArrowButton()
        .verifyVisibilityOfHomeLogo();


})