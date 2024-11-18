package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class P15_OrderPlacedPage {
    private final By orderPlacedTextLocator = By.xpath("//b [.=\"Order Placed!\"]");
    private final By deleteAccountButtonLocator = By.xpath("//a [@href=\"/delete_account\"]");
    private final By downloadInvoiceButtonLocator = By.xpath("//a [.=\"Download Invoice\"]");

    private final WebDriver driver;

    public P15_OrderPlacedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfOrderPlacedText() {
        return Utility.checkVisibilityOfElement(driver, orderPlacedTextLocator);
    }

    public P05_DeleteAccountPage clickOnDeleteAccountButton() {
        Utility.clickOnElement(driver, deleteAccountButtonLocator);
        return new P05_DeleteAccountPage(driver);
    }

    public P15_OrderPlacedPage clickOnDownloadInvoiceButton() throws AWTException {
        Utility.clickOnElement(driver, downloadInvoiceButtonLocator);
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}
