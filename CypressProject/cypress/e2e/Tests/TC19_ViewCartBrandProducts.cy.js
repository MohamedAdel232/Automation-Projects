/// <reference types = "cypress"/> 

import HomePage from '../Pages/P01_HomePage';
import ProductPage from '../Pages/P08_ProductPage';
import PoloPage from '../Pages/P16_PoloPage';

it("View & Cart Brand product", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfCategoryText();

    HomePage.clickOnProductsButton()
        .verifyVisibilityOfBrandsProducts();

    ProductPage.clickOnPoloBrandButton()
        .verifyVisibilityOfPoloBrandTitleText();

    PoloPage.clickOnMadameBrandButton()
        .verifyVisibilityOfMadameBrandTitleText();

})