package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P12_CartPage {
    private final By subscriptionTextLocator = By.xpath("//h2 [.=\"Subscription\"]");
    private final By subscribeEmail = By.id("susbscribe_email");
    private final By arrowButton = By.id("subscribe");
    private final By successSubscribeTextLocator = By.id("success-subscribe");

    private final WebDriver driver;

    public P12_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfSubscriptionText() {
        Utility.scrollToElement(driver, subscriptionTextLocator);
        return Utility.checkVisibilityOfElement(driver, subscriptionTextLocator);
    }

    public P12_CartPage enterSubscribeEmail(String email) {
        Utility.sendDataToElement(driver, subscribeEmail, email);
        return this;
    }

    public P12_CartPage clickOnArrowButton() {
        Utility.clickOnElement(driver, arrowButton);
        return this;
    }

    public boolean checkVisibilityOfSuccessSubscribe() {
        return Utility.checkVisibilityOfElement(driver, successSubscribeTextLocator);
    }
}
