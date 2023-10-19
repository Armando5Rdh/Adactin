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


    public void login(String username, String password) {

        loginObjects.getUsernameField().sendKeys(username);
        loginObjects.getPasswordField().sendKeys(password);
        loginObjects.getLoginButton().click();
    }

}
