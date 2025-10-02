import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public String url;
    WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String baseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //precondition
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = baseURL;
        navigatetoURL(url);
        //fluentWait = new FluentWait<>(driver)
                //.withTimeout(Duration.ofSeconds(10))
                //.pollingEvery(Duration.ofSeconds)(2))
                //.ignoring(Exception.class);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigatetoURL(String URL) {
        driver.get(URL);
    }

    public void clickSubmitBtn() {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitBtn.click();
    }

    public void clickViewAllBtn() {
        WebElement clickViewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        clickViewAllBtn.click();
    }
    public void selectFirstSong() {
        WebElement selectFirstSong = driver.findElement(By.xpath("//td[@class='title' and text()='Midnight in Mississippi']"));
        selectFirstSong.click();
    }
    public void clickAddToBtn() {
        WebElement clickAddToBtn = driver.findElement(By.cssSelector("button[data-test='add-to-btn']"));
        clickAddToBtn.click();
    }
    public void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
    }

    public void choosePlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Jennys Playlist')]"));
        playlist.click();
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
    public void chooseExistingPlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//a[text()='Jennys second Playlist']"));
        playlist.click();
    }
    public void selectDeleteBtn() {
        WebElement selectDeleteBtn = driver.findElement(By.xpath("//button[contains(@class, 'btn-delete-playlist')]"));
        selectDeleteBtn.click();
    }
}
