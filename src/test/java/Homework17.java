import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        //Test Steps
        //Navigate to the loging page
        navigatetoURL();
        //login
        provideEmail("jennifer.de.jesus@testpro.io");
        providePassword("FCVlLOni");
        clickSubmitBtn();
        Thread.sleep(2000);

        //Search for a song
        searchSong("Midnight in Mississippi");
        Thread.sleep(2000);

        //click 'view all' button to display the search results
        clickViewAllBtn();
        Thread.sleep(2000);

        //click the first song in the search results
        selectFirstSong();
        Thread.sleep(1000);

        //click 'ADD TO...' button
        clickAddToBtn();
        Thread.sleep(1000);

        //Choose the playlist to add it to
        choosePlaylist();
        Thread.sleep(2000);

        //Expected Result
        String ExpectedString = "Added 1 song into \"Jennys Playlist.\"";
        //Verify that a notification message appears and contains the text 'Added 1 song into [Actual Playlist Name]'

        Assert.assertEquals(getAddToPlaylistSuccessMsg(),ExpectedString);
    }
}
