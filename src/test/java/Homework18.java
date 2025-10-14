
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AllSongsPage;
import pom.HomePage;
import pom.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        //login
        loginPage.login();

        // user avatar validation
        if ((homePage.getUserAvatar()).isDisplayed()) {
            //All song
            homePage.chooseAllSongsList();

            allSongs.contextClickFirstSong();

            allSongs.hoverMediaPlayer();

            allSongs.clickPlay();

            // Verify song is playing
            Assert.assertTrue(allSongs.isSongPlaying());
        }


    }
}
