package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P01_HomePage extends P00_LayoutPage {
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
        super(driver);
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

    public P02_CreateAccountPage clickOnCreateAnAccountButton() {
        Utility.clickOnElement(driver, createAnAccountButtonLocator);
        return new P02_CreateAccountPage(driver);
    }

    public P03_SignInPage clickOnSignInButton() {
        Utility.clickOnElement(driver, signInButtonLocator);
        return new P03_SignInPage(driver);
    }

    public P04_WhatsNewPage clickOnWhatsNewButton() {
        Utility.clickOnElement(driver, whatsNewButtonLocator);
        return new P04_WhatsNewPage(driver);
    }

    public P05_WomenPage clickOnWomenButton() {
        Utility.clickOnElement(driver, womenButtonLocator);
        return new P05_WomenPage(driver);
    }

    public P06_MenPage clickOnMenButton() {
        Utility.clickOnElement(driver, menButtonLocator);
        return new P06_MenPage(driver);
    }

    public P07_GearPage clickOnGearButton() {
        Utility.clickOnElement(driver, gearButtonLocator);
        return new P07_GearPage(driver);
    }

    public P08_TrainingPage clickOnTrainingButton() {
        Utility.clickOnElement(driver, trainingButtonLocator);
        return new P08_TrainingPage(driver);
    }

    public P09_SalePage clickOnSaleButton() {
        Utility.clickOnElement(driver, saleButtonLocator);
        return new P09_SalePage(driver);
    }
}
