package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    private final By automationExerciseLogoLocator = By.xpath("//img [@src=\"/static/images/home/logo.png\"]");
    private final By loginButtonLocator = By.xpath("//a [@href= \"/login\"]");
    private final By loggedInAsTextLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    private final By deleteAccountButtonLocator = By.xpath("//a [@href=\"/delete_account\"]");
    private final By logoutButtonLocator = By.xpath("//a [@href=\"/logout\"]");
    private final By contactUsButtonLocator = By.xpath("//a [@href=\"/contact_us\"]");
    private final By testcasesButtonLocator = By.xpath("//a [@href=\"/test_cases\"]");
    private final By productsButtonLocator = By.xpath("//a [@href=\"/products\"]");
    private final By subscriptionTextLocator = By.xpath("//h2 [.=\"Subscription\"]");
    private final By subscribeEmail = By.id("susbscribe_email");
    private final By arrowButton = By.id("subscribe");
    private final By successSubscribeTextLocator = By.id("success-subscribe");

    private final WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfAutomationExerciseLogo() {
        return Utility.checkVisibilityOfElement(driver, automationExerciseLogoLocator);
    }

    public P02_LoginPage clickOnLoginButton() {
        Utility.clickOnElement(driver, loginButtonLocator);
        return new P02_LoginPage(driver);
    }

    public boolean verifyVisibilityOfLoggedInAsText() {
        return Utility.checkVisibilityOfElement(driver, loggedInAsTextLocator);
    }

    public P05_DeleteAccountPage clickOnDeleteAccountButton() {
        Utility.clickOnElement(driver, deleteAccountButtonLocator);
        return new P05_DeleteAccountPage(driver);
    }

    public P02_LoginPage clickOnLogoutButton() {
        Utility.clickOnElement(driver, logoutButtonLocator);
        return new P02_LoginPage(driver);
    }

    public P06_ContactUsPage clickOnContactUsButton() {
        Utility.clickOnElement(driver, contactUsButtonLocator);
        return new P06_ContactUsPage(driver);
    }

    public P08_TestcasesPage clickOnTestcasesButton() {
        Utility.clickOnElement(driver, testcasesButtonLocator);
        return new P08_TestcasesPage(driver);
    }

    public P09_ProductsPage clickOnProductsButton() {
        Utility.clickOnElement(driver, productsButtonLocator);
        return new P09_ProductsPage(driver);
    }

    public boolean verifyVisibilityOfSubscriptionText() {
        Utility.scrollToElement(driver, subscriptionTextLocator);
        return Utility.checkVisibilityOfElement(driver, subscriptionTextLocator);
    }

    public P01_HomePage enterSubscribeEmail(String email) {
        Utility.sendDataToElement(driver, subscribeEmail, email);
        return this;
    }

    public P01_HomePage clickOnArrowButton() {
        Utility.clickOnElement(driver, arrowButton);
        return this;
    }

    public boolean checkVisibilityOfSuccessSubscribe() {
        return Utility.checkVisibilityOfElement(driver, successSubscribeTextLocator);
    }
}
