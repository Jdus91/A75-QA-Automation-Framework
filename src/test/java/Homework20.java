import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AllSongsPage;
import pom.HomePage;
import pom.LoginPage;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //login
        loginPage.login();

        // user avatar validation
        if ((homePage.getUserAvatar()).isDisplayed()) {

            //Check if the playlist exists, then click on it.
            homePage.chooseExistingPlaylist();

            //Click the red "x PLAYLIST" button on the top right part of the page to delete it.
            homePage.selectDeleteBtn();

            //Expected Result
            String ExpectedString = "Deleted playlist \"Jennys second Playlist.\"";

            //Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
            Assert.assertEquals(getAddToPlaylistSuccessMsg(), ExpectedString);
        }
    }
}