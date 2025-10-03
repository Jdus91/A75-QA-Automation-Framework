import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");

WebDriver driver = new ChromeDriver(options);//creating an object called driver
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// TODO (for students): Review the configuration as part of HW15
String url = "https://qa.koel.app/";
driver.get(url);
Assert.assertEquals(driver.getCurrentUrl(), url);
driver.quit();
    }

    @Test
    public void loginValidEmailPassword() {

        provideEmail("jennifer.de.jesus@testpro.io");
        providePassword("FCVlLOni");
        clickSubmitBtn();
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());//test pass only if the input is true
    }
}
