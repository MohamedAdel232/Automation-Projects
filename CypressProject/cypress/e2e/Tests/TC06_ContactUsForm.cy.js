/// <reference types = "cypress" />

import HomePage from '../Pages/P01_HomePage'
import ContactUsPage from '../Pages/P06_ContactUsPage'

it("Contact Us Form", () => {
    cy.visit('/');

    HomePage.verifyVisibilityOfHomeLogo();

    HomePage.clickOnContactUsButton()
        .verifyVisibilityOfGetInTouchText();

    cy.fixture("FormData").then(FormData => {
        ContactUsPage.enterFormData(
            FormData.name,
            FormData.email,
            FormData.subject,
            FormData.message,
            FormData.file
        ).clickOnSubmitButton();
    });
    ContactUsPage.verifyVisibilityOfSuccessMessageText();

    ContactUsPage.clickOnHomePage()
        .verifyVisibilityOfHomeLogo();
});