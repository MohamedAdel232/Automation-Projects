// @ts-check

import { expect } from '@playwright/test';
import LoginPage from './P02_LoginPage';
import DeleteAccountPage from './P05_DeleteAccountPage';

export default class HomePage {
    /**
     * @param {import("playwright-core").Page} page
     */
    constructor(page) {
        this.page = page;
        this.homePageLogoLocator = 'css=a[href = "/"] img';
        this.loginButtonLocator = '//a [@href="/login"]';
        this.loggedInAsTextLocator = 'a i.fa-user';
        this.deleteAccountButtonLocator = '[href="/delete_account"]';
    }

    async verifyVisibilityOfHomePageLogo() {
        await expect(this.page.locator(this.homePageLogoLocator)).toBeVisible();
    }

    async clickOnLoginButton() {
        await this.page.locator(this.loginButtonLocator).click();
        return new LoginPage(this.page);
    }

    async verifyVisibilityOfLoggedInAsText() {
        await expect(this.page.locator(this.loggedInAsTextLocator)).toBeVisible();
    }

    async clickOnDeleteAccountButton() {
        this.page.locator(this.deleteAccountButtonLocator).click();
        return new DeleteAccountPage(this.page);
    }
}

