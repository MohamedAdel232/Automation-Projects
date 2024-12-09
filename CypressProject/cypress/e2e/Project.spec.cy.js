/// <reference types = "cypress"/>

describe("Register suite", () => {
    it("Valid Register", () => {
        cy.visit('/');
        cy.get('#menuUserLink').click();
        cy.get('[translate="CREATE_NEW_ACCOUNT"]').click();
        cy.get('.sticky').should('have.text', 'CREATE ACCOUNT');
        cy.fixture('RegisterData').then(RegisterData => {
            cy.get('[name="usernameRegisterPage"]').type(RegisterData.username);
            cy.get('[name="emailRegisterPage"]').type(RegisterData.email);
            cy.get('[name="passwordRegisterPage"]').type(RegisterData.password);
            cy.get('[name="confirm_passwordRegisterPage"]').type(RegisterData.password, { force: true });
            cy.get('[name="first_nameRegisterPage"]').type(RegisterData.firstName);
            cy.get('[name="last_nameRegisterPage"]').type(RegisterData.lastName);
            cy.get('[name="phone_numberRegisterPage"]').type(RegisterData.phoneNumber);
            cy.get('[name="countryListboxRegisterPage"]').select(RegisterData.country);
            cy.get('[name="cityRegisterPage"]').type(RegisterData.city);
            cy.get('[name="addressRegisterPage"]').type(RegisterData.address);
            cy.get('[name="state_/_province_/_regionRegisterPage"]').type(RegisterData.state, { force: true });
            cy.get('[name="postal_codeRegisterPage"]').type(RegisterData.postalCode);
        })
        cy.get('[name="i_agree"]').check();
        cy.get('#register_btn').click();
        cy.fixture("Environment").then(environment => {
            cy.url().should("eql", environment.baseurl);
        })

    });

    it("Valid Login", () => {
        cy.visit('/');
        cy.get('#menuUser').click();
        cy.fixture('LoginData').then(LoginData => {
            cy.get('input[name="username"]').type(LoginData.username);
            cy.get('input[name="password"]').type(LoginData.password);
        });
        cy.get('#sign_in_btn').click();
        cy.fixture("Environment").then(environment => {
            cy.url().should("eql", environment.baseurl);
        })
    })

    it("Delete Account", () => {
        cy.visit('/');
        cy.get('#menuUser').click();
        cy.fixture('LoginData').then(LoginData => {
            cy.get('input[name="username"]').type(LoginData.username);
            cy.get('input[name="password"]').type(LoginData.password);
        });
        cy.get('#sign_in_btn').click();
        cy.get('#menuUser').click();
        cy.contains('My account').click({ force: true });
        cy.get('.deleteBtnText').click();
        cy.get('[data-ng-click="deleteAccountConfirmed()"]').click();
        cy.fixture("Environment").then(environment => {
            cy.url().should("eql", environment.baseurl);
        })
    })
})