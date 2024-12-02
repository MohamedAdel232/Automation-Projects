package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P01_HomePage {
    private final By whatsNewButtonLocator = By.xpath("//span [.=\"What's New\"]");
    private final By womenButtonLocator = By.xpath("//span [.=\"Women\"]");
    private final By menButtonLocator = By.xpath("//span [.=\"Men\"]");
    private final By gearButtonLocator = By.xpath("//span [.=\"Gear\"]");
    private final By trainingButtonLocator = By.xpath("//span [.=\"Training\"]");
    private final By saleButtonLocator = By.xpath("//span [.=\"Sale\"]");
    private final By yogaAdLocator = By.xpath("//a [contains(@class, \"home-main\")]");
    private final By pantsAdLocator = By.xpath("//a [contains(@class, \"home-pants\")]");
    private final By tShirtsAdLocator = By.xpath("//a [contains(@class, \"home-t-shirts\")]");
    private final By erinAdLocator = By.xpath("//a [contains(@class, \"home-erin\")]");
    private final By performanceAdLocator = By.xpath("//a [contains(@class, \"home-performance\")]");
    private final By ecoAdLocator = By.xpath("//a [contains(@class, \"home-eco\")]");
    private final By hotSellerHeaderLocator = By.tagName("h2");
    private final By hotSellerTextLocator = By.xpath("//p [@class]");
    private final By productsLocator = By.xpath("//li [@class = \"product-item\"]");

    private final WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfMenuSection() {
        return Utility.checkVisibilityOfElement(driver, whatsNewButtonLocator) &&
                Utility.checkVisibilityOfElement(driver, womenButtonLocator) &&
                Utility.checkVisibilityOfElement(driver, menButtonLocator) &&
                Utility.checkVisibilityOfElement(driver, gearButtonLocator) &&
                Utility.checkVisibilityOfElement(driver, trainingButtonLocator) &&
                Utility.checkVisibilityOfElement(driver, saleButtonLocator);
    }

    public boolean verifyVisibilityOfAdSection() {
        return Utility.checkVisibilityOfElement(driver, yogaAdLocator) &&
                Utility.checkVisibilityOfElement(driver, pantsAdLocator) &&
                Utility.checkVisibilityOfElement(driver, tShirtsAdLocator) &&
                Utility.checkVisibilityOfElement(driver, erinAdLocator) &&
                Utility.checkVisibilityOfElement(driver, performanceAdLocator) &&
                Utility.checkVisibilityOfElement(driver, ecoAdLocator);
    }

    private boolean verifyVisibilityOfHotSellerTitle() {
        return Utility.checkVisibilityOfElement(driver, hotSellerHeaderLocator) &&
                Utility.checkVisibilityOfElement(driver, hotSellerTextLocator);
    }

    private boolean verifyVisibilityOfHotSellerItems() {
        List<WebElement> elements = driver.findElements(productsLocator);
        for (int i = 1; i <= elements.size(); i++) {
            By tempLocator = By.xpath("(//li [@class = \"product-item\"])[" + i + "]");
            if (!Utility.checkVisibilityOfElement(driver, tempLocator)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyVisibilityOfHotSellerSection() {
        return verifyVisibilityOfHotSellerTitle() && verifyVisibilityOfHotSellerItems();
    }
}
