// @ts-check

import { expect } from "@playwright/test";
import RegisterPage from "./P03_RegisterPage";

export default class LoginPage {
    /**
     * @param {import ("playwright-core").Page} page 
     */
    constructor(page) {
        this.page = page;
        this.newUserSignupTextLocator = 'New User Signup!';
        this.signupNameLocator = '[data-qa="signup-name"]';
        this.signupEmailLocator = '[data-qa="signup-email"]';
        this.signupButtonLocator = '[data-qa="signup-button"]';
    }

    async verifyVisibilityOfNewUserSignUpText() {
        await expect(this.page.getByText(this.newUserSignupTextLocator)).toBeVisible();
    }

    async enterSignupData(name, email) {
        await this.page.locator(this.signupNameLocator).fill(name);
        await this.page.locator(this.signupEmailLocator).fill(email);
        return this;
    }

    async clickOnSignupButton() {
        await this.page.locator(this.signupButtonLocator).click();
        return new RegisterPage(this.page);
    }

}