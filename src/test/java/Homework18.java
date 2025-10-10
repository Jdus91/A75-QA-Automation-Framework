
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

import java.time.Duration;

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        //Test Steps
        //Navigate to the login page
        navigatetoURL(url);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //login
        loginPage.provideEmail("jennifer.de.jesus@testpro.io");
        loginPage.providePassword("FCVlLOni");
        loginPage.clickSubmit();
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());//test pass only if the input is true

        //Play song
        homePage.clickPlay();

        // Verify song is playing
        Assert.assertTrue(homePage.isSongPlaying(), "The song did not start playing.");
    }
}
