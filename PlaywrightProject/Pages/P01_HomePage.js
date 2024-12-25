// @ts-check

import { expect } from '@playwright/test';

export default class HomePage {
    constructor(page) {
        this.page = page;
        this.homePageLogoLocator = "css=a[href = '/'] img";
    }

    async verifyVisibilityOfHomePageLogo() {
        await expect(this.page.locator(this.homePageLogoLocator)).toBeVisible();
    }
}

