package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.Login;
import steps.LoginSteps;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest  {

    protected WebDriver driver;

    public LoginSteps loginSteps;

    public String validUsername;

    public String validPassword;

    @BeforeMethod
    public void beforeTest()  {
        Properties properties = new Properties();
        String browser = "";
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Resources" +
                    "\\global.properties");
            properties.load(file);
            browser = properties.getProperty("browser");
        }
        catch (Exception e) {
            System.out.println("could not assign value to browser");
            e.printStackTrace();
        }
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        }

        validUsername = properties.getProperty("username");
        validPassword = properties.getProperty("password");

        loginSteps = new LoginSteps(driver);
        driver.get("https://adactinhotelapp.com/HotelAppBuild2/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void afterTest() {
        //driver.quit();
    }
}
