package Pages;

import Utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Utilities.DataUtils.readFromPropertiesFile;

public class P01_LoginPage {
    private final By usernameFieldLocator = By.cssSelector("[formcontrolname=\"userName\"]");
    private final By passwordFieldLocator = By.cssSelector("[formcontrolname=\"password\"]");
    private final By loginButtonLocator = By.id("btnlogin");

    private final WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage enterUsername(String username) {
        ElementUtils.sendDataToElement(driver, usernameFieldLocator, username);
        return this;
    }

    public P01_LoginPage enterPassword(String password) {
        ElementUtils.sendDataToElement(driver, passwordFieldLocator, password);
        return this;
    }

    public P01_LoginPage clickOnLoginButton() {
        ElementUtils.clickOnElement(driver, loginButtonLocator);
        return new P01_LoginPage(driver);
    }

    public void assertValidLogin() throws IOException {
        WaitUtils.waitForPageToLoad(driver, readFromPropertiesFile("environment", "HomePage"));

        SoftAssertionUtils.softValidateEqual(BrowserUtils.getCurrentUrl(driver),
                DataUtils.readFromPropertiesFile("environment", "HomePage"),
                "Login failed");
    }
}
