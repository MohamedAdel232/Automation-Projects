/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage';
import ProductPage from '../Pages/P08_ProductPage';
import ProductDetailsPage from '../Pages/P09_ProductDetailsPage'

it("Add Review On Product", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnProductsButton()
        .verifyVisibilityOfProductList();

    ProductPage.clickOnViewFirstProductButton()
        .verifyVisibilityOfWriteYourReviewText();

    cy.fixture("ReviewData").then(ReviewData => {
        ProductDetailsPage.writeReview(
            ReviewData.name,
            ReviewData.email,
            ReviewData.review,
        );
    });
    ProductDetailsPage.clickOnSubmitButton()
        .verifyVisibilityOfThanksMessage();
});