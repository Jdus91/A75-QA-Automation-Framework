import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RegistrationPage;

import java.net.URL;
import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation() {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Navigate to the page
        registrationPage.navigateToMainPage();

        //Click registration link
        registrationPage.clickRegistrationLink();

        //Expected Results
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(registrationPage.getCurrentUrl(), registrationUrl);
    }
}