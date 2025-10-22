package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;
    @FindBy(xpath = "//*[@id='app']/div/div/form")
    WebElement loginFormContainer;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/form/input[2]")
    WebElement loginFormContainer2;


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Fluent interface
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        click(submitBtn);
        return this;
    }

    public void assertLoginFailed() {
        // Wait for the 'class' attribute of the loginFormContainer to contain "error".
        // This is the assertion for failed login.
        wait.until(ExpectedConditions.attributeContains(loginFormContainer, "class", "error"));
    }

    public void assertLoginFailed2() {
        // Wait for the 'class' attribute of the loginFormContainer to contain "error".
        // This is the assertion for failed login.
        wait.until(ExpectedConditions.attributeContains(loginFormContainer2, "class", "error"));
    }
}
