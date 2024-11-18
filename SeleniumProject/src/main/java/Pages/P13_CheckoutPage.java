package Pages;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P13_CheckoutPage {
    private final By addressDetailsTextLocator = By.xpath("(//h2 [@class=\"heading\"])[1]");
    private final By reviewOrderTextLocator = By.xpath("(//h2 [@class=\"heading\"])[2]");
    private final By commentFieldLocator = By.tagName("textarea");
    private final By placeOrderButtonLocator = By.xpath("//a [@href=\"/payment\"]");
    private final By deliveryAddressCompanyTextLocator = By.xpath("(//li [contains(@class,\"address_address1 \")])[1]");
    private final By deliveryAddressCityTextLocator = By.xpath("(//li [contains(@class,\"address_address1 \")])[2]");
    private final By deliveryAddress1TextLocator = By.xpath("(//li [contains(@class,\"address_address1 \")])[3]");
    private final By billingAddressCompanyTextLocator = By.xpath("(//li [contains(@class,\"address_address1 \")])[4]");
    private final By billingAddressCityTextLocator = By.xpath("(//li [contains(@class,\"address_address1 \")])[5]");
    private final By billingAddress1TextLocator = By.xpath("(//li [contains(@class,\"address_address1 \")])[6]");

    private final WebDriver driver;

    public P13_CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfOrderDetails() {
        return ((Utility.checkVisibilityOfElement(driver, addressDetailsTextLocator)) &&
                (Utility.checkVisibilityOfElement(driver, reviewOrderTextLocator)));
    }

    public P13_CheckoutPage enterComment(String comment) {
        Utility.sendDataToElement(driver, commentFieldLocator, comment);
        return this;
    }

    public P14_PlaceOrderPage clickOnPlaceOrderButton() {
        Utility.clickOnElement(driver, placeOrderButtonLocator);
        return new P14_PlaceOrderPage(driver);
    }

    public boolean verifyDeliveryAddress(String company, String city, String address) {
        LogsUtils.info("Company: " + Utility.getDataFromElement(driver, deliveryAddressCompanyTextLocator));
        LogsUtils.info("City: " + Utility.getDataFromElement(driver, deliveryAddressCityTextLocator));
        LogsUtils.info("Address: " + Utility.getDataFromElement(driver, deliveryAddress1TextLocator));
        return Utility.getDataFromElement(driver, deliveryAddressCompanyTextLocator).equals(company)
                && Utility.getDataFromElement(driver, deliveryAddressCityTextLocator).equals(city)
                && Utility.getDataFromElement(driver, deliveryAddress1TextLocator).equals(address);
    }

    public boolean verifyBillingAddress(String company, String city, String address) {
        LogsUtils.info("Company: " + Utility.getDataFromElement(driver, billingAddressCompanyTextLocator));
        LogsUtils.info("City: " + Utility.getDataFromElement(driver, billingAddressCityTextLocator));
        LogsUtils.info("Address: " + Utility.getDataFromElement(driver, billingAddress1TextLocator));
        return Utility.getDataFromElement(driver, billingAddressCompanyTextLocator).equals(company)
                && Utility.getDataFromElement(driver, billingAddressCityTextLocator).equals(city)
                && Utility.getDataFromElement(driver, billingAddress1TextLocator).equals(address);
    }
}
