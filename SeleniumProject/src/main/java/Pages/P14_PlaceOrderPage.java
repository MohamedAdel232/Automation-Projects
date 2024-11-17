package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P14_PlaceOrderPage {
    private final By nameOnCardFieldLocator = By.xpath("//input [@name=\"name_on_card\"]");
    private final By cardNumberFieldLocator = By.xpath("//input [@name=\"card_number\"]");
    private final By cvcFieldLocator = By.xpath("//input [@name=\"cvc\"]");
    private final By expiryMonthFieldLocator = By.xpath("//input [@name=\"expiry_month\"]");
    private final By expiryYearFieldLocator = By.xpath("//input [@name=\"expiry_year\"]");
    private final By payAndConfirmButtonLocator = By.id("submit");

    private final WebDriver driver;

    public P14_PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public P14_PlaceOrderPage fillOutOrderInfo(String nameOnCard, String cardNumber, String cvc,
                                               String expiryMonth, String expiryYear) {
        Utility.sendDataToElement(driver, nameOnCardFieldLocator, nameOnCard);
        Utility.sendDataToElement(driver, cardNumberFieldLocator, cardNumber);
        Utility.sendDataToElement(driver, cvcFieldLocator, cvc);
        Utility.sendDataToElement(driver, expiryMonthFieldLocator, expiryMonth);
        Utility.sendDataToElement(driver, expiryYearFieldLocator, expiryYear);
        return this;
    }

    public P15_OrderPlacedPage clickOnPayAncConfirmButton() {
        Utility.clickOnElement(driver, payAndConfirmButtonLocator);
        return new P15_OrderPlacedPage(driver);
    }
}
