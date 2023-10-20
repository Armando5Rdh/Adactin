package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginSteps;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    String validUsername = "ArmandoRdh";
    String validPassword = "Test123!";

    String missingPassword = "Enter Password";

    String missingUsername = "Enter Username";
    LoginSteps loginSteps;

    @Test
    public void testLoginValidAccount() throws InterruptedException {
        loginSteps = new LoginSteps(driver);
        String message = "Hello " + validUsername + "!";
        loginSteps.login(validUsername, validPassword);
        Thread.sleep(1500);
        loginSteps.verifyWelcomeMessage(message);
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
}
