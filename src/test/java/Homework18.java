
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        //Test Steps
        //Navigate to the loging page
        navigatetoURL();

        //login
        provideEmail("jennifer.de.jesus@testpro.io");
        providePassword("FCVlLOni");
        clickSubmitBtn();
        Thread.sleep(2000);

        // Click «Play next song» (media player controls), then the Play button, to play a song.
        WebElement nextButton = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        nextButton.click();
        Thread.sleep(2000);

        WebElement playButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playButton.click();
        Thread.sleep(2000);

        //Validate that a song is playing by verifying if the sound bar, or the pause button is displayed.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span[data-testid='pause-btn']")

        ));

        Thread.sleep(2000);
        Assert.assertTrue(pauseButton.isDisplayed());
    }
}
