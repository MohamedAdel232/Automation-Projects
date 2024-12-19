/// <reference types = "cypress"/> 

import HomePage from '../Pages/P01_HomePage';
import ProductPage from '../Pages/P08_ProductPage';
import DressPage from '../Pages/P10_DressPage';
import LoginPage from '../Pages/P02_LoginPage'
import RegisterPage from '../Pages/P03_RegisterPage'
import AccountCreatedPage from '../Pages/P04_AccountCreatedPage'
import DeleteAccountPage from '../Pages/P05_DeleteAccountPage'
import CartPage from '../Pages/P11_CartPage'

before("Before Testcase", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnLoginButton()
        .verifyVisibilityOfNewUserSignupText();

    cy.fixture("ValidRegisterData").then(ValidRegisterData => {
        LoginPage.enterRegisterData(ValidRegisterData.name, ValidRegisterData.email)
            .clickOnSignupButton()
            .verifyVisibilityOfEnterAccountInfoText();
    });

    cy.fixture("ValidRegisterData").then(ValidRegisterData => {
        RegisterPage.enterRegisterData(
            ValidRegisterData.gender,
            ValidRegisterData.password,
            ValidRegisterData.day,
            ValidRegisterData.month,
            ValidRegisterData.year,
            ValidRegisterData.firstName,
            ValidRegisterData.lastName,
            ValidRegisterData.company,
            ValidRegisterData.address1,
            ValidRegisterData.address2,
            ValidRegisterData.country,
            ValidRegisterData.state,
            ValidRegisterData.city,
            ValidRegisterData.zipCode,
            ValidRegisterData.mobileNumber,
        )
            .clickOnCreateAccountButton();
    });
    AccountCreatedPage.verifyVisibilityOfAccountCreatedText();

    AccountCreatedPage.clickOnContinueButton()
        .verifyVisibilityOfLoggedInText();

    HomePage.clickOnLogoutButton();
})

it("Search Products And Verify Card After Login", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfCategoryText();

    HomePage.clickOnProductsButton()
        .verifyVisibilityOfProductList();

    cy.fixture("SearchData").then(SearchData => {
        ProductPage.searchForItem(SearchData.item)
            .verifyVisibilityOfSearchedProductsText();
    });

    DressPage.verifyVisibilityOfSearchedProducts();

    DressPage.clickOnAddToCartButton()
        .clickOnContinueShoppingButton()
        .clickOnCartButton()
        .verifyVisibilityOfProduct();

    CartPage.clickOnLoginButton()
        .verifyVisibilityOfLoginToYourAccountText();

    cy.fixture("ValidLoginData").then(ValidLoginData => {
        LoginPage.enterLoginData(
            ValidLoginData.email,
            ValidLoginData.password)
            .clickOnLoginButton();

        HomePage.clickOnCartButton()
            .verifyVisibilityOfProduct();

        HomePage.clickOnDeleteAccount()
            .verifyVisibilityOfAccountDeletedText();

        DeleteAccountPage.clickOnContinueButton();
    });


});