import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //login
        loginPage.login();

        // user avatar validation
        if ((homePage.getUserAvatar()).isDisplayed()) {

            // Search and add song to playlist
            homePage.searchSong("Midnight in Mississippi");
            homePage.clickViewAll();
            homePage.selectSongByTitle("Midnight in Mississippi");
            homePage.clickAddToButton();
            homePage.choosePlaylist("Jennys Playlist");

            // Verify success message
            String expectedMessage = "Added 1 song into \"Jennys Playlist.\"";
            Assert.assertEquals(homePage.getAddToPlaylistSuccessMsg(), expectedMessage);
        }
    }
}
