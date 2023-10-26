package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.Login;
import steps.LoginSteps;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    public LoginSteps loginSteps;
    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        loginSteps = new LoginSteps(driver);
        driver.get("https://adactinhotelapp.com/HotelAppBuild2/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
