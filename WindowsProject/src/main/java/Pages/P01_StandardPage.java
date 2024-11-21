package Pages;

import Utilities.Utility;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;

public class P01_StandardPage {
    private final By titleLocator = By.xpath("/Window/Window[2]/Text");
    private final By additionButtonLocator = By.xpath("//Custom/Group/Group[4]/Button[4]");
    private final By subtractionButtonLocator = By.xpath("//Custom/Group/Group[4]/Button[3]");
    private final By multiplicationButtonLocator = By.xpath("//Custom/Group/Group[4]/Button[2]");
    private final By equalButtonLocator = By.xpath("//Custom/Group/Group[4]/Button[5]");
    private final By resultTextLocator = By.xpath("//Custom/Group/Text[2]");
    private final By clearButtonLocator = By.xpath("//Custom/Group/Group[2]/Button[3]");

    private final WindowsDriver driver;

    public P01_StandardPage(WindowsDriver driver) {
        this.driver = driver;
    }

    public boolean verifyCalculatorIsOpened() {
        return Utility.checkVisibilityOfElement(driver, titleLocator);
    }

    public P01_StandardPage enterNumber(int number) {
        int actualNumber = number + 1;
        By tempNumberLocator = By.xpath("//Custom/Group/Group[5]/Button[" + actualNumber + "]");
        Utility.clickOnElement(driver, tempNumberLocator);
        return new P01_StandardPage(driver);
    }

    public P01_StandardPage clickOnAdditionButton() {
        Utility.clickOnElement(driver, additionButtonLocator);
        return new P01_StandardPage(driver);
    }

    public P01_StandardPage clickOnSubtractionButton() {
        Utility.clickOnElement(driver, subtractionButtonLocator);
        return new P01_StandardPage(driver);
    }

    public P01_StandardPage clickOnMultiplicationButton() {
        Utility.clickOnElement(driver, multiplicationButtonLocator);
        return new P01_StandardPage(driver);
    }

    public P01_StandardPage clickOnEqualButton() {
        Utility.clickOnElement(driver, equalButtonLocator);
        return new P01_StandardPage(driver);
    }

    public P01_StandardPage clickOnClearButton() {
        Utility.clickOnElement(driver, clearButtonLocator);
        return new P01_StandardPage(driver);
    }

    public String getResult() {
        Utility.getDataFromElement(driver, resultTextLocator).replace("Display is ", "");
        return Utility.getDataFromElement(driver, resultTextLocator).replace("Display is ", "");
    }

    public boolean verifyResult(int result) {
        return String.valueOf(result).equals(getResult());
    }

    public boolean verifyClearButtonFunctionality() {
        return getResult().equals("0");
    }
}
