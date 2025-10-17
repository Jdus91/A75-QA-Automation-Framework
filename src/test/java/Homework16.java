import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.RegistrationPage;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import  io.github.bonigarcia.wdm.config.WebDriverManagerException;



public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {

        //RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(getDriver());

        registrationPage.navigateToMainPage();

        registrationPage.clickRegistrationLink();

        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(registrationPage.getCurrentUrl(), registrationUrl);
    }
}