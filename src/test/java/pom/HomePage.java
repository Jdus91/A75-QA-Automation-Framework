package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    public By playlistLocatorById() {
        return By.xpath("//a[contains(@href, '/playlist/105750')]");
    }

    public void openPlaylist(String playlistName) {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/playlist/105750')]")));
        doubleClick(playlistLocatorById());
    }

    public void renamePlaylist(String newName) {
        enterNewPlaylistName(newName);
    }

    public String getRenameMessage() {
        return getRenamePlayListSuccessMsg();
    }
}

