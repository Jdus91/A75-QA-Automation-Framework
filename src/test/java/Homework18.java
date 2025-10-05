
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        //Test Steps
        //Navigate to the login page
        navigatetoURL(url);

        //login
        provideEmail("jennifer.de.jesus@testpro.io");
        providePassword("FCVlLOni");
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        clickSubmitBtn();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

    public void clickPlay() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextButton.click();
        playButton.click();
    }

    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return  soundBar.isDisplayed();
    }
}
