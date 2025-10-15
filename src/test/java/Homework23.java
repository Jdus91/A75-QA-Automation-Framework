import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.RegistrationPage;

public class Homework23 extends BaseTest{
    @Test
    public void registrationNavigation() {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Navigate to the page
        registrationPage.navigateToMainPage();

        //Click registration link
        registrationPage.clickRegistrationLink();

        //Expected Results
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(registrationPage.getCurrentUrl(), registrationUrl);
    }
}
