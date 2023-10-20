package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends Menu {

    private WebDriver driver;

    public SearchHotel(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "location")
    WebElement locationDropdown;

    @FindBy(id = "hotels")
    WebElement hotelsDropdown;

    @FindBy(id = "room_type")
    WebElement roomTypeDropdown;

    @FindBy(id = "room_nos")
    WebElement roomNoDropdown;

    @FindBy(id = "datepick_in")
    WebElement checkInInput;

    @FindBy(className = "datepick_out")
    WebElement checkOutInput;

    @FindBy(id = "adult_room")
    WebElement adultsNoDropdown;

    @FindBy(id = "child_room")
    WebElement childNoDropdown;

    @FindBy(id = "Submit")
    WebElement submitButton;

    @FindBy(id = "Reset")
    WebElement resetButton;



    public WebElement getLocationDropdown() {
        return locationDropdown;
    }

    public WebElement getHotelsDropdown() {
        return hotelsDropdown;
    }

    public WebElement getRoomTypeDropdown() {
        return roomTypeDropdown;
    }

    public WebElement getRoomNoDropdown() {
        return roomNoDropdown;
    }

    public WebElement getCheckInInput() {
        return checkInInput;
    }

    public WebElement getCheckOutInput() {
        return checkOutInput;
    }

    public WebElement getAdultsNoDropdown() {
        return adultsNoDropdown;
    }

    public WebElement getChildNoDropdown() {
        return childNoDropdown;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getResetButton() {
        return resetButton;
    }


}
