package testPages;

import utilities.Driver;
import utilities.ExcelDataProvider;
import org.testng.annotations.*;
import pages.FilterPage;
import pages.Helper;

import java.io.IOException;

public class FilterTest extends Driver {

    FilterPage FP;

    @BeforeMethod
    public void checkTheAvailabilityOfFlightsTest() throws InterruptedException {
        Helper.setUpDriver();
        FP = new FilterPage();
        FP.iAmOnPageAndCheckTheUrlIsCorrectOrNot();
        FP.selectSourceAsDestinationAsAndTravelDate();
        FP.showAvailableFlights();
    }

    @Test(priority = 1)
    public void priceSortTest() throws InterruptedException {
        FP.user_is_shown_prices_before_applying_any_sort();
        FP.user_click_on_cheapest_flights_button();
        FP.show_prices_after_the_sort();
    }

    @Test(priority = 2)
    public void flightHoursTest() throws InterruptedException {
        FP.user_is_shown_list_of_flight_hours();
        FP.user_click_on_fastest_flights_button();
        FP.show_flight_duration_of_fastest_flights_in_sort_order();
    }

    @Test(priority = 3)
    public void flightStopTest() throws InterruptedException {
        FP.user_is_shown_the_list_of_flight_stops();
        FP.user_click_on_the_no_stops_filter_check_box();
        FP.show_the_list_of_stops_of_all_flights();
    }

    @AfterMethod
    public void teardown() {

        Helper.tearDown();
    }
}

















