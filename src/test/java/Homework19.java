import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        //Test Steps
        //Navigate to the login page
        navigatetoURL(url);

        //login
        provideEmail("jennifer.de.jesus@testpro.io");
        providePassword("FCVlLOni");
        clickSubmitBtn();
        Thread.sleep(2000);

        //Check if the playlist exists, then click on it.
        chooseExistingPlaylist();
        Thread.sleep(2000);

        //Click the red "x PLAYLIST" button on the top right part of the page to delete it.
        selectDeleteBtn();
        Thread.sleep(2000);

        //Expected Result
        String ExpectedString = "Deleted playlist \"Jennys second Playlist.\"";

        //Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
        Assert.assertEquals(getAddToPlaylistSuccessMsg(),ExpectedString);
        }

    }