package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = new ChromeDriver();
        driver.get("https://adactinhotelapp.com/HotelAppBuild2/index.php");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
