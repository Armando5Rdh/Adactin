package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginSteps;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    LoginSteps loginSteps;

    @Test
    public void testLoginValidAccount() throws InterruptedException {
        loginSteps = new LoginSteps(driver);
        String username = "ArmandoRdh";
        String password = "Test123!";
        String message = "Hello " + username + "!";
        loginSteps.login(username, password);
        Thread.sleep(1500);
        loginSteps.verifyWelcomeMessage(message);
    }
}
