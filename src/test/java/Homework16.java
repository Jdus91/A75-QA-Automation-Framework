import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation() {

        //Navigate to the page
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Test Steps
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='registration']")));
        registrationLink.click();

        //Expected Results
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

            driver.quit();

    }
}