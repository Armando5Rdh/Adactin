package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Login;

public class LoginSteps extends CommonSteps {

    String validUsername = "ArmandoRdh";
    String validPassword = "Test123!";

    WebDriver driver;
    Login loginObject;
    public LoginSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        loginObject = new Login(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterUsername(String username) {
        loginObject.getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        loginObject.getPasswordField().sendKeys(password);
    }

    public void clickLoginButton() {
        loginObject.getLoginButton().click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void login() {
        enterUsername(validUsername);
        enterPassword(validPassword);
        clickLoginButton();
    }

    public void verifyEnterPasswordTxt(String message) {
        compareText(loginObject.getMissingPasswordTxt().getText(),message);
    }

    public void verifyEnterUsername(String message) {
        compareText(loginObject.getMissingUsernameTxt().getText(),message);
    }

    public void verifyWrongCredentials(String message) {
        compareText(loginObject.getInvalidCredentialsTxt().getText(),message);
    }

}
