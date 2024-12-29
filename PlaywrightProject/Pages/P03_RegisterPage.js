// @ts-check

import { expect } from "@playwright/test";
import AccountCreatedPage from "./P04_AccountCreatedPage";

export default class RegisterPage {
    /**
     * @param {import ("playwright-core").Page} page
     */
    constructor(page) {
        this.page = page;
        this.enterAccountInformationTextLocator = 'Enter Account Information';
        this.menGenderButtonLocator = '#id_gender1';
        this.womenGenderButtonLocator = '#id_gender2';
        this.passwordFieldLocator = '#password';
        this.dayFieldLocator = '#days';
        this.monthFieldLocator = '#months';
        this.yearFieldLocator = '#years';
        this.newsLetterButtonLocator = '#newsletter';
        this.optionButtonLocator = '#optin';
        this.firstNameFieldLocator = '#first_name';
        this.lastNameFieldLocator = '#last_name';
        this.companyFieldLocator = '#company';
        this.addressOneFieldLocator = '#address1';
        this.addressTwoFieldLocator = '#address2';
        this.countryFieldLocator = '#country';
        this.stateFieldLocator = '#state';
        this.cityFieldLocator = '#city';
        this.zipCodeFieldLocator = '#zipcode';
        this.mobileNumberFieldLocator = '#mobile_number';
        this.createAccountButtonLocator = '[data-qa="create-account"]';
    }


    async verifyVisibilityOfEnterAccountInformationText() {
        await expect(this.page.getByText(this.enterAccountInformationTextLocator)).toBeVisible();
    }

    async fillRegisterDetails(gender, password, day, month, year, firstName, lastName, company,
        address1, address2, country, state, city, zipCode, mobileNumber) {
        if (gender == "male") {
            await this.page.locator(this.menGenderButtonLocator).click();
        }
        else {
            await this.page.locator(this.womenGenderButtonLocator).click();
        }

        await this.page.locator(this.passwordFieldLocator).fill(password);

        await this.page.locator(this.dayFieldLocator).selectOption(day);
        await this.page.locator(this.monthFieldLocator).selectOption(month);
        await this.page.locator(this.yearFieldLocator).selectOption(year);

        await this.page.locator(this.newsLetterButtonLocator).click();
        await this.page.locator(this.optionButtonLocator).click();

        await this.page.locator(this.firstNameFieldLocator).fill(firstName);
        await this.page.locator(this.lastNameFieldLocator).fill(lastName);

        await this.page.locator(this.companyFieldLocator).fill(company);
        await this.page.locator(this.addressOneFieldLocator).fill(address1);
        await this.page.locator(this.addressTwoFieldLocator).fill(address2);
        await this.page.locator(this.countryFieldLocator).selectOption(country);
        await this.page.locator(this.stateFieldLocator).fill(state);
        await this.page.locator(this.cityFieldLocator).fill(city);
        await this.page.locator(this.zipCodeFieldLocator).fill(zipCode);
        await this.page.locator(this.mobileNumberFieldLocator).fill(mobileNumber);

        return this;
    }

    async clickOnCreateAccountButton() {
        await this.page.locator(this.createAccountButtonLocator).click();
        return new AccountCreatedPage(this.page);
    }
}