import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        //LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("jennifer.de.jesus@testpro.io").providePassword("FCVlLOni").clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        homePage.searchSong("Down in the Swamp");
        homePage.clickViewAll();
        homePage.selectSongByTitle("Down in the Swamp");
        homePage.clickAddToButton();
        homePage.choosePlaylist("Jennys Playlist");

        String expectedMessage = "Added 1 song into \"Jennys Playlist.\"";

        Assert.assertEquals(homePage.getAddToPlaylistSuccessMsg(), expectedMessage);
    }
}
