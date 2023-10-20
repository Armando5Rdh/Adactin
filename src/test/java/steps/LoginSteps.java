package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginObjects;

public class LoginSteps extends CommonSteps {

    WebDriver driver;
    LoginObjects loginObjects;
    public LoginSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        loginObjects = new LoginObjects(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterUsername(String username) {
        loginObjects.getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        loginObjects.getPasswordField().sendKeys(password);
    }

    public void clickLoginButton() {
        loginObjects.getLoginButton().click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyEnterPasswordTxt(String message) {
        compareText(loginObjects.getMissingPasswordTxt().getText(),message);
    }

    public void verifyEnterUsername(String message) {
        compareText(loginObjects.getMissingUsernameTxt().getText(),message);
    }

}
