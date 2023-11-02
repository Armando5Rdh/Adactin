package test;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.SearchHotelSteps;
import utils.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
    public Object[][] TestData() throws IOException, ParseException {

        List<HashMap<String, String>> data = getJsonDataToMap();
        Object[][] testData = new Object[data.size()][];

        for (int i = 0; i < data.size(); i++) {
            testData[i] = new Object[]{data.get(i)};
        }

        return testData;
    }

}
