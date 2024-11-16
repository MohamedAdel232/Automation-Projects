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

}
