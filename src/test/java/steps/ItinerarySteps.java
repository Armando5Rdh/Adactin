package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Login;

public class ItinerarySteps extends CommonSteps {

    WebDriver driver;
    Login loginObject;
    public ItinerarySteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        loginObject = new Login(driver);
        PageFactory.initElements(driver,this);
    }

}
