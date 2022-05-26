package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;

public class LoginPage extends MenuPage {
    // open the size involve.me
    @FindBy(css = ".other-link.login")
    WebElement OpenLoginUpBtn;
    @FindBy(css = "[autocomplete='username']")
    WebElement usernameField;
    @FindBy(css = "[name='password']")
    WebElement passwordField;
    @FindBy(css = ".btn-primary")
    WebElement loginBtn;
    @FindBy(css = ".alert-danger")
    WebElement errorMessage;
    @FindBy(css = "#nav-dropdown>div .flex")
    WebElement MyLogin;
    @FindBy(css = ".auth-panel")
    WebElement finalErrorMassage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void OpenLogin() {
        click(OpenLoginUpBtn);
    }

    @Step("login with error massage")
    public void LoginToErrorMassage(String username, String Password) {
        fillText(usernameField, username);
        fillText(passwordField, Password);
        sleep(1000);
        click(loginBtn);
        AllureAttachment.attachElementScreenshot(finalErrorMassage);
    }

    @Step("login with right user")
    public void LoginToTheSite(String username, String Password) {
        fillText(usernameField, username);
        fillText(passwordField, Password);
        sleep(1000);
        click(loginBtn);
        AllureAttachment.attachElementScreenshot(MyLogin);
    }

    @Step("Error message if one of the details in the user is incorrect")
    public String GetErrorMessage() {
        return getText(errorMessage);
    }

    @Step("open my user name")
    public String MyLogin() {
        return getText(MyLogin);

    }
}
