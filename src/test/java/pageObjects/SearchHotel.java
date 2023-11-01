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

    @FindBy(id = "datepick_out")
    WebElement checkOutInput;

    @FindBy(id = "adult_room")
    WebElement adultsNoDropdown;

    @FindBy(id = "child_room")
    WebElement childNoDropdown;

    @FindBy(id = "Submit")
    WebElement submitButton;

    @FindBy(id = "Reset")
    WebElement resetButton;

    @FindBy(id = "radiobutton_0")
    WebElement firstOption;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "first_name")
    WebElement firstNameInput;

    @FindBy(id = "last_name")
    WebElement lastNameInput;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "cc_num")
    WebElement cardNumberInput;

    @FindBy(id = "cc_type")
    WebElement cardTypeDropdown;

    @FindBy(id = "cc_exp_month")
    WebElement cardExpireMonthDropdown;

    @FindBy(id = "cc_exp_year")
    WebElement cardExpireYearDropdown;

    @FindBy (id = "cc_cvv")
    WebElement cardCvvInput;

    @FindBy(id = "book_now")
    WebElement bookNowBtn;

    @FindBy(id = "cancel")
    WebElement cancelBtn;

    @FindBy(id = "order_no")
    WebElement orderNoTxt;

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

    public WebElement getFirstOption() {
        return firstOption;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getAddressInput() {
        return addressInput;
    }

    public WebElement getCardNumberInput() {
        return cardNumberInput;
    }

    public WebElement getCardTypeDropdown() {
        return cardTypeDropdown;
    }

    public WebElement getCardExpireMonthDropdown() {
        return cardExpireMonthDropdown;
    }

    public WebElement getCardExpireYearDropdown() {
        return cardExpireYearDropdown;
    }

    public WebElement getCardCvvInput() {
        return cardCvvInput;
    }

    public WebElement getBookNowBtn() {
        return bookNowBtn;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }

    public WebElement getOrderNoTxt() {
        return orderNoTxt;
    }

}
