import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String newPlaylistName = "Edited Jennys Playlist";

    @Test
    public void renamePlaylist(){

        //Test Steps

        //Navigate + login
        navigatetoURL(url);
        provideEmail("jennifer.de.jesus@testpro.io");
        providePassword("FCVlLOni");
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        clickSubmitBtn();

        //Locate Playlist and open playlist
        //WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Jennys Playlist')]")));
        doubleClickPlaylist();
        
        //entering new playlist name
        enterNewPlaylistName(newPlaylistName);

        //verify
        String updatedPlaylistMsg = "Updated playlist \"Edited Jennys Playlist.\"";
        Assert.assertEquals(getRenamePlayListSuccessMsg(), updatedPlaylistMsg);


    }


}
