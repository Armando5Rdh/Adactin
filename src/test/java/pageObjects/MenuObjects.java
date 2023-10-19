package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuObjects {

    private WebDriver driver;

    public MenuObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//td[@class='welcome_menu'][1]")
    WebElement welcomeMessage;

    @FindBy(id = "username_show")
    WebElement customizedMessage;

    @FindBy(xpath = "//td[@class='welcome_menu'][2]//a[1]")
    WebElement searchPage;

    @FindBy(xpath = "//td[@class='welcome_menu'][2]//a[2]")
    WebElement bookedItineraryPage;

    @FindBy(xpath = "//td[@class='welcome_menu'][2]//a[3]")
    WebElement changePasswordPage;

    @FindBy(xpath = "//td[@class='welcome_menu'][2]//a[4]")
    WebElement logoutPage;


    public WebElement getWelcomeMessage() {
        return welcomeMessage;
    }

    public WebElement getSearchPage() {
        return searchPage;
    }

    public WebElement getCustomizedMessage() {
        return customizedMessage;
    }

    public WebElement getBookedItineraryPage() {
        return bookedItineraryPage;
    }

    public WebElement getChangePasswordPage() {
        return changePasswordPage;
    }

    public WebElement getLogoutPage() {
        return logoutPage;
    }



}
