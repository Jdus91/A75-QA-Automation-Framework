import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("jennifer.de.jesus@testpro.io").providePassword("FCVlLOni").clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        homePage.chooseExistingPlaylist();

        homePage.selectDeleteBtn();

        String ExpectedString = "Deleted playlist \"Jennys second Playlist.\"";

        Assert.assertEquals(getAddToPlaylistSuccessMsg(), ExpectedString);
    }
}