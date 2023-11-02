package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.SearchHotelSteps;
import utils.BaseTest;

import java.util.HashMap;

public class SearchHotelTest extends BaseTest {

    SearchHotelSteps searchHotelSteps;

    @BeforeMethod
    public void beforeTest()  {
        super.beforeTest();
        searchHotelSteps = new SearchHotelSteps(driver);
    }
    @Test (dataProvider = "userData")
    public void searchForHotel(HashMap<String,String> userData) {

        searchHotelSteps.SearchValidHotel(userData.get("location"),userData.get("hotel"),userData.get("roomType"),
                userData.get("roomNumber"), userData.get("checkInDate"),userData.get("checkOutDate"),
                userData.get("adultsNumber"), userData.get("childNumber"));
        searchHotelSteps.SelectFirstHotel();
        searchHotelSteps.ClickContinueBtn();
        searchHotelSteps.FillPersonalData(userData.get("firstName"),userData.get("lastName"),userData.get("address"),
                userData.get("cardNumber"),userData.get("cardType"),
                userData.get("cardExpirationMonth"),userData.get("cardExpirationYear"),userData.get("cardCvv"));
        searchHotelSteps.ClickBookNow();
        searchHotelSteps.VerifyOrderNoIsDisplayed();
    }

    @DataProvider(name = "userData")
    public Object[][] TestData() {

        HashMap<String, String> firstSearch = new HashMap<>();
        firstSearch.put("location","New York");
        firstSearch.put("hotel","Hotel Sunshine");
        firstSearch.put("roomType","Double");
        firstSearch.put("roomNumber","2");
        firstSearch.put("checkInDate","0");
        firstSearch.put("checkOutDate","4");
        firstSearch.put("adultsNumber","2");
        firstSearch.put("childNumber","3");
        firstSearch.put("firstName","TEst");
        firstSearch.put("lastName","Name");
        firstSearch.put("address","My location");
        firstSearch.put("cardNumber","1234567890987654");
        firstSearch.put("cardType","VISA");
        firstSearch.put("cardExpirationMonth","3");
        firstSearch.put("cardExpirationYear","2029");
        firstSearch.put("cardCvv","123");

        Object[][] data = { {firstSearch}};
        return data;
    }

}
