package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P13_CheckoutPage {
    private final By addressDetailsTextLocator = By.xpath("(//h2 [@class=\"heading\"])[1]");
    private final By reviewOrderTextLocator = By.xpath("(//h2 [@class=\"heading\"])[2]");
    private final By commentFieldLocator = By.tagName("textarea");
    private final By placeOrderButtonLocator = By.xpath("//a [@href=\"/payment\"]");

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
}
