import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class Homework22 extends BaseTest{
    //String newPlaylistName = "Edited Jennys Playlist";

    @Test
    public void renamePlaylist(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("jennifer.de.jesus@testpro.io");
        loginPage.providePassword("FCVlLOni");
        loginPage.clickSubmit();
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());//test pass only if the input is true

        String playlistId = "Jennys Playlist";
        String newPlaylistName = "Edited Jennys Playlist";
        homepage.openPlaylist(playlistId);
        homepage.renamePlaylist(newPlaylistName);

        String updatedPlaylistMsg = "Updated playlist \"Edited Jennys Playlist.\"";
        Assert.assertEquals(homepage.getRenameMessage(), updatedPlaylistMsg);
    }
}

