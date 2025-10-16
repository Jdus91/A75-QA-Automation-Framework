import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.RegistrationPage;


public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {

        //RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(getDriver()driver);

        registrationPage.navigateToMainPage();

        registrationPage.clickRegistrationLink();

        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(registrationPage.getCurrentUrl(), registrationUrl);
    }
}