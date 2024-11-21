package Pages;

import Utilities.Utility;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;

public class P01_StandardPage {
    private final By titleLocator = By.xpath("/Window/Window[2]/Text");

    private final WindowsDriver driver;

    public P01_StandardPage(WindowsDriver driver) {
        this.driver = driver;
    }

    public boolean verifyCalculatorIsOpened() {
        return Utility.checkVisibilityOfElement(driver, titleLocator);
    }
}
