import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AllSongsPage;
import pom.HomePage;
import pom.LoginPage;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() {
        //Test Steps
        //Navigate to the login page
        navigatetoURL(url);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        //login
        loginPage.login();

        // user avatar validation
        if ((homePage.getUserAvatar()).isDisplayed()) {

            //Check if the playlist exists, then click on it.
            WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Jennys second Playlist']")));
            chooseExistingPlaylist();

            //Click the red "x PLAYLIST" button on the top right part of the page to delete it.
            WebElement selectDeleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-delete-playlist')]")));
            selectDeleteBtn();

            //Expected Result
            String ExpectedString = "Deleted playlist \"Jennys second Playlist.\"";

            //Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
            Assert.assertEquals(getAddToPlaylistSuccessMsg(), ExpectedString);
        }
    }
}