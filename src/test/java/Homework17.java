import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() {

        //Test Steps
        //Navigate to the login page
        navigatetoURL(url);

        //login
        provideEmail("jennifer.de.jesus@testpro.io");
        providePassword("FCVlLOni");
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        clickSubmitBtn();

        //Search for a song
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        searchSong("Midnight in Mississippi");
        //searchSong("Midnight in Mississippi");

        //click 'view all' button to display the search results
        WebElement clickViewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
        clickViewAllBtn();

        //click the first song in the search results
        WebElement selectFirstSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='title' and text()='Midnight in Mississippi']")));
        selectFirstSong();

        //click 'ADD TO...' button
        WebElement clickAddToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='add-to-btn']")));
        clickAddToBtn();

        //Choose the playlist to add it to
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Jennys Playlist')]")));
        choosePlaylist();

        //Expected Result
        String ExpectedString = "Added 1 song into \"Jennys Playlist.\"";
        //Verify that a notification message appears and contains the text 'Added 1 song into [Actual Playlist Name]'

        Assert.assertEquals(getAddToPlaylistSuccessMsg(),ExpectedString);
    }
}
