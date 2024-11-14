package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage {
    private final By newUserSignupTextLocator = By.xpath("(//h2)[3]");
    private final By nameFieldLocator = By.xpath("//input [@type=\"text\"]");
    private final By emailFieldLocator = By.xpath("//input [@data-qa=\"signup-email\"]");
    private final By signupButtonLocator = By.xpath("//button [@data-qa=\"signup-button\"]");

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
}
