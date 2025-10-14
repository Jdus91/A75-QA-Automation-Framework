package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllSongsPage extends BasePage {

    By firstSong = By.cssSelector("tr.song-item:first-child");
    By mediaPlayer = By.xpath("//*[@id=\"mainFooter\"]/div[1]");
    By playButton = By.xpath("//span[@data-testid='play-btn']");
    By isSongPlaying = By.xpath("//div[@data-testid='sound-bar-play']");

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void contextClickFirstSong() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        click(firstSong);
    }

    public void hoverMediaPlayer() {
        hover(mediaPlayer);
    }

    public void clickPlay() {
        click(playButton);
    }

    public boolean isSongPlaying() {
        WebElement soundBar = findElement(isSongPlaying);
        return soundBar.isDisplayed();
    }
}
