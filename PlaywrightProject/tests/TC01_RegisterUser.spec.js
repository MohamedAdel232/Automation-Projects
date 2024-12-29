// @ts-check

import { test } from '@playwright/test';
import HomePage from '../Pages/P01_HomePage';
import LoginPage from '../Pages/P02_LoginPage';
import RegisterPage from '../Pages/P03_RegisterPage';
import AccountCreatedPage from '../Pages/P04_AccountCreatedPage';
import DeleteAccountPage from '../Pages/P05_DeleteAccountPage';

const fs = require('fs');

const RegisterData = JSON.parse(fs.readFileSync('D:\\SW Testing\\Automation Projects\\PlaywrightProject\\TestData\\RegisterData.json', 'utf-8'));

test("Register User", async ({ page }) => {
    await page.goto('/');
    const homePage = new HomePage(page);
    const loginPage = new LoginPage(page);
    const registerPage = new RegisterPage(page);
    const accountCreatedPage = new AccountCreatedPage(page);
    const deleteAccountPage = new DeleteAccountPage(page);

    await homePage.verifyVisibilityOfHomePageLogo();

    (await homePage.clickOnLoginButton()).verifyVisibilityOfNewUserSignUpText();

    (await loginPage.enterSignupData(RegisterData.name, RegisterData.email))
        .clickOnSignupButton();
    await registerPage.verifyVisibilityOfEnterAccountInformationText();

    (await registerPage.fillRegisterDetails(RegisterData.gender, RegisterData.password,
        RegisterData.day, RegisterData.month, RegisterData.year, RegisterData.firstName, RegisterData.lastName,
        RegisterData.company, RegisterData.address1, RegisterData.address2, RegisterData.country, RegisterData.state,
        RegisterData.city, RegisterData.zipCode, RegisterData.mobileNumber
    )).clickOnCreateAccountButton();
    await accountCreatedPage.verifyVisibilityOfAccountCreatedText();

    (await accountCreatedPage.clickOnContinueButton())
        .verifyVisibilityOfLoggedInAsText();

    (await homePage.clickOnDeleteAccountButton())
        .verifyVisibilityOfAccountDeletedText();

    await deleteAccountPage.clickOnContinueButton();
});