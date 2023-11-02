package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Itinerary extends Menu{

    WebDriver driver;

    public Itinerary(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "check_all")
    WebElement checkAllCheckbox;

    @FindBy(xpath = "//input[@name='ids[]']")
    List<WebElement> checkBox;

    @FindBy(xpath = "//input[contains(@name,'order_id')]")
    List<WebElement> OrderIDs;

    @FindBy(xpath = "//input[contains(@name,'hotel_name_')]")
    List<WebElement> hotelsNames;

    @FindBy(xpath = "//input[contains(@name,'location')]")
    List<WebElement> hotelsLocations;

    @FindBy(xpath = "//input[contains(@name,'rooms')]")
    List<WebElement> roomsNo;

    @FindBy(xpath = "//input[contains(@name,'first_name')]")
    List<WebElement> firstName;

    @FindBy(xpath = "//input[contains(@name,'last_name')]")
    List<WebElement> lastName;

    @FindBy(xpath = "//input[contains(@name,'arr_date')]")
    List<WebElement> arrivalDate;

    @FindBy(xpath = "//input[contains(@name,'dep_date')]")
    List<WebElement> departureDate;

    @FindBy(xpath = "//input[contains(@name,'no_days')]")
    List<WebElement> noDays;
}
