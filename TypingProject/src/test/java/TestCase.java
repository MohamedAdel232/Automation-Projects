import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCase {
    @Test
    public void testCase(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://10fastfingers.com/typing-test/english");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//button [@id= \"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")));
        driver.findElement(By.xpath("//button [@id= \"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]"))
                .click();

        List list = driver.findElements(By.xpath("//span [@wordnr]"));
        for (int i = 1; i <= list.size(); i++){
            String text;
            By tempLocator = By.xpath("(//span [@wordnr])["+i+"]");
            text = driver.findElement(tempLocator).getText();
            driver.findElement(By.xpath("//input [@type=\"text\"]"))
                    .sendKeys(text  + " ");
        }
    }
}
