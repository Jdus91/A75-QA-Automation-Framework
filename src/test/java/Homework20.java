import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {

        //LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("jennifer.de.jesus@testpro.io").providePassword("FCVlLOni").clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        homePage.chooseExistingPlaylist2();

        homePage.selectDeleteBtn();

        String ExpectedString = "Deleted playlist \"Jennys third Playlist.\"";

        Assert.assertEquals(homePage.getDeletePlaylistSuccessMsg(), ExpectedString);
    }
}