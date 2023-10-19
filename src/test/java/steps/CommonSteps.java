package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.LoginObjects;
import pageObjects.MenuObjects;

public class CommonSteps {

    WebDriver driver;
    MenuObjects menuObjects;
    public CommonSteps(WebDriver driver) {
        this.driver = driver;
        menuObjects = new MenuObjects(driver);
        PageFactory.initElements(driver,this);
    }

    public void compareText(String actual, String desired) {
        Assert.assertEquals(actual, desired);
    }

    public void verifyWelcomeMessage(String message) {
        String actualMessage = menuObjects.getCustomizedMessage().getAttribute("value");
        compareText(actualMessage, message);
    }




}
