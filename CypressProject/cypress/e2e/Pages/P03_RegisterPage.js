/// <reference types = "cypress" />

class RegisterPage {
    enterAccountInfoTextLocator = 'Enter Account Information';
    maleCheckboxLocator = '#id_gender1';
    femaleCheckboxLocator = '#id_gender2';
    passwordFieldLocator = '[type="password"]';
    dayFieldLocator = 'select[data-qa = "days"]';
    monthFieldLocator = 'select[data-qa = "months"]';
    yearFieldLocator = 'select[data-qa = "years"]';
    newsLetterFieldLocator = '#newsletter';
    optinFieldLocator = '#optin';
    firstNameFieldLocator = '[data-qa="first_name"]';
    lastNameFieldLocator = '[data-qa="last_name"]';
    companyFieldLocator = '[data-qa="company"]';
    address1FieldLocator = '[data-qa="address"]';
    address2FieldLocator = '[data-qa="address2"]';
    countryFieldLocator = '[data-qa="country"]';
    stateFieldLocator = '[data-qa="state"]';
    cityFieldLocator = '[data-qa="city"]';
    zipCodeFieldLocator = '[data-qa="zipcode"]';
    mobileNumberFieldLocator = '[data-qa="mobile_number"]';
    createAccountButtonLocator = '[data-qa="create-account"]';


    verifyVisibilityOfEnterAccountInfoText() {
        cy.contains(this.enterAccountInfoTextLocator).should('be.visible');
    }

    enterRegisterData(gender, password, day, month, year, firstName, lastName, company, address1, address2,
        country, state, city, zipCode, mobileNumber) {
        if (gender == "male") {
            cy.get(this.maleCheckboxLocator).check();
        }
        else if (gender == "female") {
            cy.get(this.femaleCheckboxLocator).check();
        }

        cy.get(this.passwordFieldLocator).type(password);

        cy.get(this.dayFieldLocator).select(day);
        cy.get(this.monthFieldLocator).select(month);
        cy.get(this.yearFieldLocator).select(year);

        cy.get(this.newsLetterFieldLocator).check();
        cy.get(this.optinFieldLocator).check();

        cy.get(this.firstNameFieldLocator).type(firstName);
        cy.get(this.lastNameFieldLocator).type(lastName);

        cy.get(this.companyFieldLocator).type(company);
        cy.get(this.address1FieldLocator).type(address1);
        cy.get(this.address2FieldLocator).type(address2);

        cy.get(this.countryFieldLocator).select(country);

        cy.get(this.stateFieldLocator).type(state);
        cy.get(this.cityFieldLocator).type(city);
        cy.get(this.zipCodeFieldLocator).type(zipCode);
        cy.get(this.mobileNumberFieldLocator).type(mobileNumber);

        return this;
    }

    clickOnCreateAccountButton() {
        cy.get(this.createAccountButtonLocator).click();
    }
}



export default new RegisterPage();