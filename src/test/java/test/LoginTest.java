package test;

import org.testng.annotations.Test;
import steps.LoginSteps;
import utils.BaseTest;

import java.io.IOException;

public class LoginTest extends BaseTest {

//    String validUsername = "ArmandoRdh";
//    String validPassword = "Test123!";

    String invalidUsername = "user";
    String invalidPassword = "password";

    String missingPassword = "Enter Password";

    String missingUsername = "Enter Username";

    String wrongCredentialsMessage = "Invalid Login details or Your Password might have expired. " +
            "Click here to reset your password";

    @Test
    public void testLoginValidAccount() throws InterruptedException {
        String message = "Hello " + validUsername + "!";
        loginSteps.login(validUsername, validPassword);
        loginSteps.VerifyWelcomeMessage(message);
    }

    @Test
    public void testLoginOnlyUsername() {
        loginSteps = new LoginSteps(driver);
        loginSteps.enterUsername(validUsername);
        loginSteps.clickLoginButton();
        loginSteps.verifyEnterPasswordTxt(missingPassword);
    }

    @Test
    public void testLoginOnlyPassword() {
        loginSteps = new LoginSteps(driver);
        loginSteps.enterPassword(validPassword);
        loginSteps.clickLoginButton();
        loginSteps.verifyEnterUsername(missingUsername);
    }

    @Test
    public void testLoginInvalid() {
//        loginSteps = new LoginSteps(driver);
        loginSteps.enterUsername(invalidUsername);
        loginSteps.enterPassword(invalidPassword);
        loginSteps.clickLoginButton();
        loginSteps.verifyWrongCredentials(wrongCredentialsMessage);
    }

    @Test
    public void verifyLoginLinks() throws IOException {
        loginSteps = new LoginSteps(driver);
        loginSteps.VerifyLinksAreWorking();
    }
}
