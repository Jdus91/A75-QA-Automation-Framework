package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BasePage {
    String newPlaylistName = "Edited Jennys Playlist";

    @Test
    public void renamePlaylist(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("jennifer.de.jesus@testpro.io");
        loginPage.providePassword("FCVlLOni");
        loginPage.clickSubmit();
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());//test pass only if the input is true
        
        //Locate Playlist and open playlist
        //WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/playlist/105750')")));
        doubleClickPlaylist();
        
        //entering new playlist name
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        enterNewPlaylistName("Edited Jennys Playlist");

        //verify
        String updatedPlaylistMsg = "Updated playlist \"Edited Jennys Playlist.\"";
        Assert.assertEquals(getRenamePlayListSuccessMsg(), updatedPlaylistMsg);


    }


}
