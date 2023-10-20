package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Login;

public class LoginSteps extends CommonSteps {

    WebDriver driver;
    Login login;
    public LoginSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        login = new Login(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterUsername(String username) {
        login.getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        login.getPasswordField().sendKeys(password);
    }

    public void clickLoginButton() {
        login.getLoginButton().click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyEnterPasswordTxt(String message) {
        compareText(login.getMissingPasswordTxt().getText(),message);
    }

    public void verifyEnterUsername(String message) {
        compareText(login.getMissingUsernameTxt().getText(),message);
    }

    public void verifyWrongCredentials(String message) {
        compareText(login.getInvalidCredentialsTxt().getText(),message);
    }

}
