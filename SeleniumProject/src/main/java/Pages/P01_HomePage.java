package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
    private final By subscribeEmailLocator = By.id("susbscribe_email");
    private final By arrowButtonLocator = By.id("subscribe");
    private final By successSubscribeTextLocator = By.id("success-subscribe");
    private final By cartButtonLocator = By.xpath("(//a [@href=\"/view_cart\"])[1]");
    private final By firstProductDetailsButtonLocator = By.xpath("//a [@href=\"/product_details/1\"]");
    private final By firstProductLocator = By.xpath("//img [@src=\"/get_product_picture/1\"]");
    private final By addFirstProductToCartLocator = By.xpath("//a [@data-product-id=\"1\"]");
    private final By continueShoppingButtonLocator = By.xpath("//button [.=\"Continue Shopping\"]");
    private final By categoryTextLocator = By.xpath("//h2 [.=\"Category\"]");
    private final By womenCategoryButtonLocator = By.xpath("//a [@href=\"#Women\"]");
    private final By dressCategoryButtonLocator = By.xpath("//a [@href=\"/category_products/1\"]");
    private final By recommendedItemsTextLocator = By.xpath("//h2 [.=\"recommended items\"]");
    private final By addRecommendedItemLocator = By.xpath("//div [@class=\"carousel-inner\"] //a [@data-product-id]");
    private final By arrowUpButtonLocator = By.xpath("//i [contains(@class,\"fa-angle-up\")]");
    private final By homeTextLocator = By.xpath("//h2 [.=\"Full-Fledged practice website for Automation Engineers\"]");

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
        Utility.sendDataToElement(driver, subscribeEmailLocator, email);
        return this;
    }

    public P01_HomePage clickOnArrowButton() {
        Utility.clickOnElement(driver, arrowButtonLocator);
        return this;
    }

    public boolean checkVisibilityOfSuccessSubscribe() {
        return Utility.checkVisibilityOfElement(driver, successSubscribeTextLocator);
    }

    public P12_CartPage clickOnCartButton() {
        Utility.clickOnElement(driver, cartButtonLocator);
        return new P12_CartPage(driver);
    }

    public P10_ProductOneDetailsPage clickOnFirstProductDetailsButton() {
        Utility.clickOnElement(driver, firstProductDetailsButtonLocator);
        return new P10_ProductOneDetailsPage(driver);
    }

    public P01_HomePage addFirstProductToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(Utility.findWebElement(driver, firstProductLocator));
        Utility.clickOnElement(driver, addFirstProductToCartLocator);
        Utility.clickOnElement(driver, continueShoppingButtonLocator);
        return this;
    }

    public boolean verifyVisibilityOfCategoryText() {
        return Utility.checkVisibilityOfElement(driver, categoryTextLocator);
    }

    public P01_HomePage clickOnWomenCategoryButton() {
        Utility.clickOnElement(driver, womenCategoryButtonLocator);
        return this;
    }

    public P16_DressSearchPage clickOnDressCategoryButton() {
        Utility.clickOnElement(driver, dressCategoryButtonLocator);
        return new P16_DressSearchPage(driver);
    }

    public boolean verifyVisibilityOfRecommendedItemTextLocator() {
        Utility.scrollToElement(driver, recommendedItemsTextLocator);
        return Utility.checkVisibilityOfElement(driver, recommendedItemsTextLocator);
    }

    public P01_HomePage addRecommendedProductToCart() {
        Utility.clickOnElement(driver, addRecommendedItemLocator);
        Utility.clickOnElement(driver, continueShoppingButtonLocator);
        return this;
    }

    public P01_HomePage clickOnArrowUpButton() {
        Utility.clickOnElement(driver, arrowUpButtonLocator);
        return this;
    }

    public boolean checkVisibilityOfHomeTextLocator() {
        return Utility.checkVisibilityOfElement(driver, homeTextLocator);
    }

    public boolean scrollAndCheckVisibilityOfHomeTextLocator() {
        Utility.clickOnElement(driver, homeTextLocator);
        return Utility.checkVisibilityOfElement(driver, homeTextLocator);
    }


}
