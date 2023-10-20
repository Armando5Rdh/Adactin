package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.Login;
import pageObjects.SearchHotel;

public class SearchHotelSteps extends CommonSteps {

    WebDriver driver;
    SearchHotel searchHotel;

    public SearchHotelSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        searchHotel = new SearchHotel(driver);
        PageFactory.initElements(driver,this);
    }

}
