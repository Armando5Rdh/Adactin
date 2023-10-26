package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.SearchHotelSteps;
import utils.BaseTest;

public class SearchHotelTest extends BaseTest {

    SearchHotelSteps searchHotelSteps;

    String location = "New York";
    String hotel = "Hotel Sunshine";
    String roomType = "Double";
    String roomNumber = "2";
    String checkInDate;
    String checkOutDate;
    String adultsNumber = "2";
    String childNumber = "3";


    @BeforeMethod
    public void beforeTest() {
        super.beforeTest();
        searchHotelSteps = new SearchHotelSteps(driver);
        checkInDate = searchHotelSteps.getSpecificDate(0);
        checkOutDate = searchHotelSteps.getSpecificDate(10);
        System.out.println(checkInDate);
        System.out.println(checkOutDate);
    }

    @Test
    public void searchHotel() {
        loginSteps.login();
        searchHotelSteps.SelectLocation(location);
        searchHotelSteps.SelectHotel(hotel);
        searchHotelSteps.SelectRoomType(roomType);
        searchHotelSteps.SelectRoomNumber(roomNumber);
        searchHotelSteps.SelectCheckIn(checkInDate);
        searchHotelSteps.SelectCheckOut(checkOutDate);
        searchHotelSteps.SelectAdultsNumber(adultsNumber);
        searchHotelSteps.SelectChildNumber(childNumber);
        searchHotelSteps.ClickSearch();
    }

}
