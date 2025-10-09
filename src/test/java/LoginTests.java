import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() {
        
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        
        loginPage.provideEmail("jennifer.de.jesus@testpro.io");
        loginPage.providePassword("FCVlLOni");
        loginPage.clickSubmit();
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());//test pass only if the input is true
    }
}
