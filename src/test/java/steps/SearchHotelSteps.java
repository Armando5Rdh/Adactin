package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.Login;
import pageObjects.SearchHotel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class SearchHotelSteps extends CommonSteps {

    WebDriver driver;
    SearchHotel searchHotel;

    public SearchHotelSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        searchHotel = new SearchHotel(driver);
        PageFactory.initElements(driver,this);
    }

    public String getSpecificDate(long futureDays) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now().plusDays(futureDays);
        return (dtf.format(now));
    }

    public void SelectLocation(String value) {
        Select location = new Select(searchHotel.getLocationDropdown());
        location.selectByValue(value);
    }

    public void SelectHotel(String value) {
        Select hotel = new Select(searchHotel.getHotelsDropdown());
        hotel.selectByValue(value);
    }

    public void SelectRoomType(String value) {
        Select roomType = new Select(searchHotel.getRoomTypeDropdown());
        roomType.selectByValue(value);
    }

    public void SelectRoomNumber(String value) {
        Select roomNumber = new Select(searchHotel.getRoomNoDropdown());
        roomNumber.selectByValue(value);
    }

    public void SelectCheckIn(String value) {
        searchHotel.getCheckInInput().clear();
        searchHotel.getCheckInInput().sendKeys(value);
    }

    public void SelectCheckOut(String value) {
        searchHotel.getCheckOutInput().clear();
        searchHotel.getCheckOutInput().sendKeys(value);
    }

    public void SelectAdultsNumber(String value) {
        Select adultsNumber = new Select(searchHotel.getAdultsNoDropdown());
        adultsNumber.selectByValue(value);
    }

    public void SelectChildNumber(String value) {
        Select childNumber = new Select(searchHotel.getChildNoDropdown());
        childNumber.selectByValue(value);
    }

    public void ClickSearch() {
        searchHotel.getSubmitButton().click();
    }

    public void ClickReset() {
        searchHotel.getResetButton().click();
    }

}
