package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private final WebDriver driver;
    private final By usernameFieldLocator = By.id("user-name");
    private final By passwordFieldLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By invalidLoginDataTextLocator = By.xpath("//h3 [@data-test=\"error\"]");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage enterUsername(String username) {
        Utility.sendDataFromElement(driver, usernameFieldLocator, username);
        return this;
    }

    public P01_LoginPage enterPassword(String password) {
        Utility.sendDataFromElement(driver, passwordFieldLocator, password);
        return this;
    }

    public P02_HomePage clickOnLoginButton() {
        Utility.clickOnElement(driver, loginButtonLocator);
        return new P02_HomePage(driver);
    }

    public boolean checkVisibilityOfInvalidLoginDataText() {
        return Utility.verifyVisibilityOfElement(driver, invalidLoginDataTextLocator);
    }
}
