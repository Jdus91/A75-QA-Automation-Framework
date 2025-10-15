import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("jennifer.de.jesus@testpro.io").providePassword("FCVlLOni").clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        String playlistId = "Jennys Playlist";
        String newPlaylistName = "Edited Jennys Playlist";

        homePage.openPlaylist(playlistId);
        homePage.renamePlaylist(newPlaylistName);

        String updatedPlaylistMsg = "Updated playlist \"Edited Jennys Playlist.\"";
        Assert.assertEquals(homePage.getRenameMessage(), updatedPlaylistMsg);
    }
}
