import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String baseURL) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //precondition
        //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        //driver = new EdgeDriver();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        url = baseURL;
        navigatetoURL(url);
        actions = new Actions(getDriver());
        //fluentWait = new FluentWait<>(driver)
        //.withTimeout(Duration.ofSeconds(10))
        //.pollingEvery(Duration.ofSeconds)(2))
        //.ignoring(Exception.class);
    }

    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }

    public void navigatetoURL(String URL) {
        //driver.get(URL);
        getDriver().get(url);
    }

    //public void closeBrowser(){
    //driver.quit();
//}

    //public String getAddToPlaylistSuccessMsg() {
        //WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //return notification.getText();
    //}

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.0.97:4444/";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions=new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            //Grid Capable
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            //Cloud Execution
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }
        public WebDriver lambdaTest() throws MalformedURLException{
        String hubURL = "https://hub.lambdatest.com/wd/hub";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("dev");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "jenniferdejesus");
            ltOptions.put("accessKey", "LT_5X3jPaBgaQ9PaYwyQ4NQdHzv9wQ9vOh1MxX4prdaBdORnDD");
            ltOptions.put("project", "Untitled");
            ltOptions.put("name", this.getClass().getName());
            ltOptions.put("w3c", true);
            ltOptions.put("plugin", "java-testNG");
            browserOptions.setCapability("LT:Options", ltOptions);

            return new RemoteWebDriver(new URL(hubURL), browserOptions);
        }
    }