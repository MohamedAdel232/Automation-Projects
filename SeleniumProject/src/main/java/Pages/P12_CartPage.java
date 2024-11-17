package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P12_CartPage {
    private final By subscriptionTextLocator = By.xpath("//h2 [.=\"Subscription\"]");
    private final By subscribeEmail = By.id("susbscribe_email");
    private final By arrowButton = By.id("subscribe");
    private final By successSubscribeTextLocator = By.id("success-subscribe");
    private final By productOneLocator = By.id("product-1");
    private final By productTwoLocator = By.id("product-2");
    private final By firstProductPriceLocator = By.xpath("(//td [@class = \"cart_price\"] //p)[1]");
    private final By secondProductPriceLocator = By.xpath("(//td [@class = \"cart_price\"] //p)[2]");
    private final By firstProductQuantityLocator = By.xpath("(//button [@class=\"disabled\"])[1]");
    private final By secondProductQuantityLocator = By.xpath("(//button [@class=\"disabled\"])[2]");
    private final By firstProductTotalPriceLocator = By.xpath("(//p [@class=\"cart_total_price\"])[1]");
    private final By secondProductTotalPriceLocator = By.xpath("(//p [@class=\"cart_total_price\"])[2]");

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

    public boolean verifyVisibilityOfProducts() {
        return Utility.checkVisibilityOfElement(driver, productOneLocator) &&
                Utility.checkVisibilityOfElement(driver, productTwoLocator);
    }

    public int getFirstProductPrice() {
        String priceText = Utility.getDataFromElement(driver, firstProductPriceLocator);
        String quantityText = Utility.getDataFromElement(driver, firstProductQuantityLocator);
        int price = Integer.parseInt(priceText.replace("Rs. ", ""));
        int quantity = Integer.parseInt(quantityText);
        return price * quantity;
    }

    public int getSecondProductPrice() {
        String priceText = Utility.getDataFromElement(driver, secondProductPriceLocator);
        String quantityText = Utility.getDataFromElement(driver, secondProductQuantityLocator);
        int price = Integer.parseInt(priceText.replace("Rs. ", ""));
        int quantity = Integer.parseInt(quantityText);
        return price * quantity;
    }

    public int getFirstProductTotalPrice() {
        String tempText = Utility.getDataFromElement(driver, firstProductTotalPriceLocator);
        return Integer.parseInt(tempText.replace("Rs. ", ""));
    }

    public int getSecondProductTotalPrice() {
        String tempText = Utility.getDataFromElement(driver, secondProductTotalPriceLocator);
        return Integer.parseInt(tempText.replace("Rs. ", ""));
    }

    public boolean verifyTotalPrice() {
        return ((getFirstProductPrice() == getFirstProductTotalPrice()) &&
                (getSecondProductPrice() == getSecondProductTotalPrice()));
    }

}