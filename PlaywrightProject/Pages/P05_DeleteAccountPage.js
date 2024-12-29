/// @ts-check

import { expect } from "@playwright/test";
import HomePage from "./P01_HomePage";

export default class DeleteAccountPage {
    /**
     * 
     * @param {import ("playwright-core").Page} page
     */
    constructor(page) {
        this.page = page;
        this.accountDeletedTextLocator = '[data-qa= "account-deleted"]';
        this.continueButtonLocator = '[data-qa="continue-button"]';
    }

    async verifyVisibilityOfAccountDeletedText() {
        await expect(this.page.locator(this.accountDeletedTextLocator)).toBeVisible();
    }

    async clickOnContinueButton() {
        await this.page.locator(this.continueButtonLocator).click();
        return new HomePage(this.page);
    }
}