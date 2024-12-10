/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage'
import ProductPage from '../Pages/P08_ProductPage'
import DressPage from '../Pages/P10_DressPage'

it("Search Product", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnProductsButton()
        .verifyVisibilityOfProductList();

    cy.fixture("SearchData").then(SearchData => {
        ProductPage.searchForItem(SearchData.item)
            .verifyVisibilityOfSearchedProductsText();
    });

    DressPage.verifyVisibilityOfSearchedProducts();
})