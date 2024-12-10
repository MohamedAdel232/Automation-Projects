/// <reference types = "cypress" /> 

import P01_HomePage from "./P01_HomePage";

class ContactUsPage {
    getInTouchTextLocator = 'div.contact-form > h2';
    nameFieldLocator = '[name = "name"]';
    emailFieldLocator = '[name = "email"]';
    subjectFieldLocator = '[name = "subject"]';
    messageFieldLocator = '[name = "message"]';
    uploadFileFieldLocator = '[type = "file"]';
    submitButtonLocator = '[data-qa = "submit-button"]';
    successMessageTextLocator = '.status';
    homePageButtonLocator = 'li [href = "/"]'

    verifyVisibilityOfGetInTouchText() {
        cy.get(this.getInTouchTextLocator).should('be.visible');
    }

    enterFormData(name, email, subject, message, file) {
        cy.get(this.nameFieldLocator).type(name);
        cy.get(this.emailFieldLocator).type(email);
        cy.get(this.subjectFieldLocator).type(subject);
        cy.get(this.messageFieldLocator).type(message);
        cy.get(this.uploadFileFieldLocator).selectFile(file);
        return this;
    }

    clickOnSubmitButton() {
        cy.get(this.submitButtonLocator).click();
        cy.on('window:alert', (alertText) => {
            expect(alertText).to.equal('Press OK to proceed!');
        });
    }

    verifyVisibilityOfSuccessMessageText() {
        cy.get(this.successMessageTextLocator).should('be.visible');
    }

    clickOnHomePage() {
        cy.get(this.homePageButtonLocator).click();
        return P01_HomePage;
    }
}

export default new ContactUsPage();