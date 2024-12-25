// @ts-check

import { test } from '@playwright/test';
import HomePage from '../Pages/P01_HomePage';

test("Testcase", async ({ page }) => {
    await page.goto('/');
    const homePage = new HomePage(page);
    await homePage.verifyVisibilityOfHomePageLogo();
});