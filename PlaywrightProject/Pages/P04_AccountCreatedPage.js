/// @ts-check

import { expect } from "@playwright/test";
import HomePage from "./P01_HomePage";

export default class AccountCreatedPage {
    /**
     * 
     * @param {import ("playwright-core").Page} page 
     */
    constructor(page) {
        this.page = page;
        this.accountCreatedTextLocator = 'Account Created!';
        this.continueButtonLocator = '[data-qa="continue-button"]';
    }

    async verifyVisibilityOfAccountCreatedText() {
        await expect(this.page.getByText(this.accountCreatedTextLocator)).toBeVisible();
    }

    async clickOnContinueButton() {
        await this.page.locator(this.continueButtonLocator).click();
        return new HomePage(this.page);
    }


}