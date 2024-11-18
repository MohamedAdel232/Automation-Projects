package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage {
    private final By newUserSignupTextLocator = By.xpath("(//h2)[3]");
    private final By nameFieldLocator = By.xpath("//input [@type=\"text\"]");
    private final By emailFieldLocator = By.xpath("//input [@data-qa=\"signup-email\"]");
    private final By signupButtonLocator = By.xpath("//button [@data-qa=\"signup-button\"]");
    private final By loginToYourAccountTextLocator = By.xpath("//h2 [1]");
    private final By loginEmailFieldLocator = By.xpath("//input [@data-qa=\"login-email\"]");
    private final By loginPasswordFieldLocator = By.xpath("//input [@data-qa=\"login-password\"]");
    private final By loginButtonLocator = By.xpath("//button [@data-qa=\"login-button\"]");
    private final By invalidDataTextLocator = By.xpath("//p [@style]");
    private final By emailAlreadyExistTextLocator = By.xpath("//p [.=\"Email Address already exist!\"]");

    private final WebDriver driver;


    public P02_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfNewUserSignupText() {
        return Utility.checkVisibilityOfElement(driver, newUserSignupTextLocator);
    }

    public P02_LoginPage enterName(String name) {
        Utility.sendDataToElement(driver, nameFieldLocator, name);
        return this;
    }

    public P02_LoginPage enterEmail(String email) {
        Utility.sendDataToElement(driver, emailFieldLocator, email);
        return this;
    }

    public P03_SignupPage clickOnSignupButton() {
        Utility.clickOnElement(driver, signupButtonLocator);
        return new P03_SignupPage(driver);
    }

    public boolean verifyVisibilityOfLoginToYourAccountText() {
        return Utility.checkVisibilityOfElement(driver, loginToYourAccountTextLocator);
    }

    public P02_LoginPage enterLoginEmail(String email) {
        Utility.sendDataToElement(driver, loginEmailFieldLocator, email);
        return this;
    }

    public P02_LoginPage enterLoginPassword(String password) {
        Utility.sendDataToElement(driver, loginPasswordFieldLocator, password);
        return this;
    }

    public P01_HomePage clickOnLoginButton() {
        Utility.clickOnElement(driver, loginButtonLocator);
        return new P01_HomePage(driver);
    }

    public boolean verifyVisibilityOfInvalidDataText() {
        return Utility.checkVisibilityOfElement(driver, invalidDataTextLocator);
    }

    public boolean verifyVisibilityOfEmailAlreadyExistText() {
        return Utility.checkVisibilityOfElement(driver, emailAlreadyExistTextLocator);
    }
}
