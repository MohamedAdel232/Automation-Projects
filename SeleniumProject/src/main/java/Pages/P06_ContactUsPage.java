package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ContactUsPage {
    private final By getInTouchTextLocator = By.xpath("//h2 [.=\"Get In Touch\"]");
    private final By nameFieldLocator = By.xpath("//input [@name=\"name\"]");
    private final By emailFieldLocator = By.xpath("//input [@name=\"email\"]");
    private final By subjectFieldLocator = By.xpath("//input [@name=\"subject\"]");
    private final By messageFieldLocator = By.id("message");
    private final By uploadFileLocator = By.xpath("//input [@type=\"file\"]");
    private final By submitButtonLocator = By.xpath("//input [@name=\"submit\"]");

    private final WebDriver driver;

    public P06_ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfGetInTouchText() {
        return Utility.checkVisibilityOfElement(driver, getInTouchTextLocator);
    }

    public P06_ContactUsPage fillOutInfo(String name, String email, String subject, String message) {
        Utility.sendDataToElement(driver, nameFieldLocator, name);
        Utility.sendDataToElement(driver, emailFieldLocator, email);
        Utility.sendDataToElement(driver, subjectFieldLocator, subject);
        Utility.sendDataToElement(driver, messageFieldLocator, message);
        return this;
    }

    public P06_ContactUsPage uploadFile(String filePath) {
        Utility.sendDataToElement(driver, uploadFileLocator, filePath);
        return this;
    }

    public P06_ContactUsPage clickOnSubmitButton() {
        Utility.clickOnElement(driver, submitButtonLocator);
        return this;
    }

    public P07_ConfirmContactUs acceptAlert() throws InterruptedException {
        driver.switchTo().alert().accept();
        return new P07_ConfirmContactUs(driver);
    }
}
