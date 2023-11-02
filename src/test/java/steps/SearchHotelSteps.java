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

    LoginSteps loginSteps;

    String location = "New York";
    String hotel = "Hotel Sunshine";
    String roomType = "Double";
    String roomNumber = "2";
    String checkInDate = getSpecificDate(0);
    String checkOutDate = getSpecificDate(7);
    String adultsNumber = "2";
    String childNumber = "3";

    String firstName = "TEst";

    String lastName = "Name";

    String address = "My location";

    String cardNumber = "1234567890987654";

    String cardType = "VISA";

    String cardExpirationMonth = "3";

    String cardExpirationYear = "2029";

    String cardCvv = "123";

    public SearchHotelSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        searchHotel = new SearchHotel(driver);
        loginSteps = new LoginSteps(driver);
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

    public void SelectFirstHotel() {
        searchHotel.getFirstOption().click();
    }

    public void ClickContinueBtn() {
        searchHotel.getContinueBtn().click();
    }

    public void EnterFirstName(String name) {
        searchHotel.getFirstNameInput().sendKeys(name);
    }

    public void EnterLastName(String lastName) {
        searchHotel.getLastNameInput().sendKeys(lastName);
    }

    public void EnterAddress(String address) {
        searchHotel.getAddressInput().sendKeys(address);
    }

    public void EnterCardNumber(String cardNumber) {
        searchHotel.getCardNumberInput().sendKeys(cardNumber);
    }

    public void SelectCardType(String cardType) {
        Select type= new Select(searchHotel.getCardTypeDropdown());
        type.selectByValue(cardType);
    }

    public void SelectCardExpirationMonth(String expirationMonth) {
        Select type= new Select(searchHotel.getCardExpireMonthDropdown());
        type.selectByValue(expirationMonth);
    }

    public void SelectCardExpirationYear(String expirationYear) {
        Select type= new Select(searchHotel.getCardExpireYearDropdown());
        type.selectByValue(expirationYear);
    }

    public void EnterCvv(String cvv) {
        searchHotel.getCardCvvInput().sendKeys(cvv);
    }

    public void ClickBookNow() {
        searchHotel.getBookNowBtn().click();
    }

    public void ClickCancel() {
        searchHotel.getCancelBtn().click();
    }

    public String SetDate(int date) {
        return getSpecificDate(date);
    }

    public void VerifyOrderNoIsDisplayed() {
        WaitForElementToAppear(searchHotel.getOrderNoTxt(), 10000);
        VerifyIfElementIsDisplayed(searchHotel.getOrderNoTxt());
        System.out.println(searchHotel.getOrderNoTxt().getAttribute("value"));
    }
    public void SearchValidHotel() {
        loginSteps.login();
        SelectLocation(location);
        SelectHotel(hotel);
        SelectRoomType(roomType);
        SelectRoomNumber(roomNumber);
        SelectCheckIn(checkInDate);
        SelectCheckOut(checkOutDate);
        SelectAdultsNumber(adultsNumber);
        SelectChildNumber(childNumber);
        ClickSearch();
    }

    public void SearchValidHotel(String location, String hotel, String roomType, String roomNumber, String checkInDate,
                                 String checkOutDate, String adultsNumber,String childNumber) {
        loginSteps.login();
        String checkIn = getSpecificDate(Integer.parseInt(checkInDate));
        String checkOut = getSpecificDate(Integer.parseInt(checkOutDate));

        SelectLocation(location);
        SelectHotel(hotel);
        SelectRoomType(roomType);
        SelectRoomNumber(roomNumber);
        SelectCheckIn(checkIn);
        SelectCheckOut(checkOut);
        SelectAdultsNumber(adultsNumber);
        SelectChildNumber(childNumber);
        ClickSearch();
    }

    public void FillPersonalData() {
        EnterFirstName(firstName);
        EnterLastName(lastName);
        EnterAddress(address);
        EnterCardNumber(cardNumber);
        SelectCardType(cardType);
        SelectCardExpirationMonth(cardExpirationMonth);
        SelectCardExpirationYear(cardExpirationYear);
        EnterCvv(cardCvv);

    }

    public void FillPersonalData(String firstName, String lastName, String address, String cardNumber, String cardType,
                                 String cardExpirationMonth, String cardExpirationYear, String cardCvv) {
        EnterFirstName(firstName);
        EnterLastName(lastName);
        EnterAddress(address);
        EnterCardNumber(cardNumber);
        SelectCardType(cardType);
        SelectCardExpirationMonth(cardExpirationMonth);
        SelectCardExpirationYear(cardExpirationYear);
        EnterCvv(cardCvv);

    }


}
