package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginObjects;
import pageObjects.MenuObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

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

    public void verifyLinksAreWorking() throws IOException {
        String url;
        List<WebElement> links = menuObjects.getLinks();
        SoftAssert a = new SoftAssert();

        for (WebElement link : links) {

            if (link.getText().startsWith("http")) {
                url = link.getAttribute("href");
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                int responseCode = conn.getResponseCode();
                System.out.println(link.getText() + " is working");
                a.assertTrue(responseCode < 400, link.getText() + " is broken with code " + responseCode);
            }
        }

        a.assertAll();
    }




}
