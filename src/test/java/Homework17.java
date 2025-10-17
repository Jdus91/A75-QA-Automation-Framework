import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        //LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("jennifer.de.jesus@testpro.io").providePassword("FCVlLOni").clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        homePage.searchSong("For the Poor");
        homePage.clickViewAll();
        homePage.selectSongByTitle("For the Poor");
        Thread.sleep(3000);
        homePage.clickAddToButton();
        Thread.sleep(1000);
        homePage.choosePlaylist("Jennys Playlist");
        Thread.sleep(1000);

        String expectedMessage = "Added 1 song into \"Jennys Playlist.\"";
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getAddToPlaylistSuccessMsg(), expectedMessage);
    }
}
