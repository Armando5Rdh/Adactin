package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Menu {

    private WebDriver driver;

    public Login(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "password_span")
    WebElement missingPasswordTxt;

    @FindBy(id = "username_span")
    WebElement missingUsernameTxt;

    @FindBy(className = "auth_error")
    WebElement invalidCredentialsTxt;

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getMissingUsernameTxt() {
        return missingUsernameTxt;
    }

    public WebElement getMissingPasswordTxt() {
        return missingPasswordTxt;
    }

    public WebElement getInvalidCredentialsTxt() {
        return invalidCredentialsTxt;
    }


}
