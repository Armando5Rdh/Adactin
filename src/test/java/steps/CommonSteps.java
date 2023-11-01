package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.Menu;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class CommonSteps {

    WebDriver driver;
    Menu menu;
    public CommonSteps(WebDriver driver) {
        this.driver = driver;
        menu = new Menu(driver);
        PageFactory.initElements(driver,this);
    }

    public void CompareText(String actual, String desired) {
        Assert.assertEquals(actual, desired);
    }

    public void VerifyWelcomeMessage(String message) {
        String actualMessage = menu.getCustomizedMessage().getAttribute("value");
        CompareText(actualMessage, message);
    }

    public void VerifyLinksAreWorking() throws IOException {
        String url;
        List<WebElement> links = menu.getLinks();
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

    public void WaitForElementToAppear(WebElement element, long time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void WaitForElementToDisappear(WebElement element, long time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void VerifyIfElementIsDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), element + " is not displayed");
    }
}
