/// <reference types = "cypress"/> 

import HomePage from '../Pages/P01_HomePage';
import DressPage from '../Pages/P10_DressPage';
import JeansPage from '../Pages/P15_JeansPage';

it("View Category Products", () => {
    cy.visit('/');
    HomePage.verifyVisibilityOfCategoryText();

    HomePage.clickOnWomenCategoryButton()
        .clickOnDressCategoryButton()
        .verifyVisibilityOfDressTitleText();

    DressPage.clickOnMenCategoryButton()
        .clickOnJeansCategoryButton()
        .verifyVisibilityOfJeansTitleText();
})