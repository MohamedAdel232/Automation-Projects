package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08_TestcasesPage {
    private final WebDriver driver;

    private final By testcasesTextLocator = By.tagName("b");

    public P08_TestcasesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfTestcasesText() {
        return Utility.checkVisibilityOfElement(driver, testcasesTextLocator);
    }
}
