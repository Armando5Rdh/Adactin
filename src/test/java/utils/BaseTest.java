package utils;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.Login;
import steps.LoginSteps;

import java.io.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
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

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException, ParseException {
        File file = new File("src/test/java//Data/ClientInfo.json");
//        Map<String, Object> employee = objectMapper.readValue(file, new TypeReference<>(){});

        Object o = new JSONParser().parse(new FileReader(file));

        List<HashMap<String, String>> data = (List<HashMap<String, String>>) o;

        return data;
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
