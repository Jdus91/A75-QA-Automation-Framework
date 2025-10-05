import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {
        //Test Steps
        //Navigate to the login page
        navigatetoURL(url);

        //login
        provideEmail("jennifer.de.jesus@testpro.io");
        providePassword("FCVlLOni");
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        clickSubmitBtn();

        //Check if the playlist exists, then click on it.
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Jennys second Playlist']")));
        chooseExistingPlaylist();

        //Click the red "x PLAYLIST" button on the top right part of the page to delete it.
        WebElement selectDeleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-delete-playlist')]")));
        selectDeleteBtn();

        //Expected Result
        String ExpectedString = "Deleted playlist \"Jennys second Playlist.\"";

        //Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
        Assert.assertEquals(getAddToPlaylistSuccessMsg(),ExpectedString);
    }

}
