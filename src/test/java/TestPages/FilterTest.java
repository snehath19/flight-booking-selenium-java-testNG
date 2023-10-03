package TestPages;

import Utilities.Driver;
import Utilities.ExcelDataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Filterpage;
import pages.Helper;

import java.io.IOException;

public class FilterTest extends Driver {

    Filterpage FP;
    String FlightBookingDataProvider="/Users/praise_joseph/Documents/Sneha/Projects/FlightBookingSeleniumJavaTestng/src/main/resources/Book1.xlsx";
    @BeforeTest
    public void setup() {

        Helper.setUpDriver();
        FP = new Filterpage();
    }
    @AfterClass
    public void teardown() {

        Helper.tearDown();
    }
    @Test(priority = 1)
    public void CheckTheUrlIsCorrectOrNotTest() throws InterruptedException {

        FP.IAmOnPageAndCheckTheUrlIsCorrectOrNot();
    }
    @Test(priority = 2)
    public void selectSourceDestinationAndTravelDateTest() throws InterruptedException {
        FP.selectSourceAsDestinationAsAndTravelDate("LHR", "FRA");
    }
    @Test(priority = 3)
    public void showAvailableFlightsTest()
    {
        FP.showAvailableFlights();
    }

    @Test(priority = 4)
    public void user_is_shown_prices_before_applying_any_sortTest() throws InterruptedException {
        FP.user_is_shown_prices_before_applying_any_sort();
    }

    @Test(priority = 5)
    public void user_click_on_cheapest_flights_buttonTest()
    {
        FP.user_click_on_cheapest_flights_button();
    }

    @Test(priority = 6)
    public void show_prices_after_the_sortTest()
    {
        FP.show_prices_after_the_sort();
    }

    @Test(priority = 7)
    public void check_if_the_results_are_sorted_based_on_cheapest_priceTest() {
        FP.check_if_the_results_are_sorted_based_on_cheapest_price();
    }

   @Test(priority = 8)
    public void user_is_shown_list_of_flight_hoursTest() throws InterruptedException {
        FP.user_is_shown_list_of_flight_hours();
    }

    @Test(priority = 9)
    public void user_click_on_fastest_flights_buttonTest()
    {
        FP.user_click_on_fastest_flights_button();
    }

    @Test(priority = 10)
    public void show_flight_duration_of_fastest_flights_in_sort_orderTest()
    {
        FP.show_flight_duration_of_fastest_flights_in_sort_order();
    }

    @Test(priority = 11)
    public void user_is_shown_the_list_of_flight_stopsTest() throws InterruptedException {
        FP.user_is_shown_the_list_of_flight_stops();
    }

    @Test(priority = 12)
    public void user_click_on_the_no_stops_filter_check_boxTest() throws InterruptedException {

        FP.user_click_on_the_no_stops_filter_check_box();
    }

    @Test(priority = 13)
    public void show_the_list_of_stops_of_all_flightsTest()
    {
        FP.show_the_list_of_stops_of_all_flights();
    }

    @Test(priority = 14)
    public void check_if_only_direct_flights_are_shownTest() {
        FP.check_if_only_direct_flights_are_shown();
    }

    @Test(priority = 15)
    public void user_select_a_flightTest() throws InterruptedException {
        FP.user_select_a_flight();
    }

    @Test(priority = 16)
    public void check_if_the_user_is_on_the_flight_details_pageTest() throws InterruptedException {
        FP.check_if_the_user_is_on_the_flight_details_page();
    }

    @Test(priority = 17)
    public void display_number_of_passengers_before_count_is_increasedTest() throws InterruptedException {
        FP.display_number_of_passengers_before_count_is_increased();
    }

    @Test(priority = 18)
    public void user_clicks_on_add_another_adult_button_in_the_pageTest() throws InterruptedException {
        FP.user_clicks_on_add_another_adult_button_in_the_page();
    }

    @Test(priority = 19)
    public void show_the_updated_number_of_adultsTest()
    {
        FP.show_the_updated_number_of_adults();
    }

    @Test(priority = 20)
    public void check_if_the_number_of_passengers_got_increasedTest() {
        FP.check_if_the_number_of_passengers_got_increased();
    }

    @Test(priority = 21)
    public void check_the_number_of_seats_availableTest() throws InterruptedException
    {
        FP.check_the_number_of_seats_available();
    }

    @Test(priority = 22)
    public void check_if_seat_size_is_zero_then_display_no_seat_availableTest()
    {
        FP.check_if_seat_size_is_zero_then_display_no_seat_available();
    }

    @Test(priority = 23)
    public void check_if_adult_number_is_one_then_try_to_add_single_seatTest() throws InterruptedException
    {
        FP.check_if_adult_number_is_one_then_try_to_add_single_seat();
    }

    @Test(priority = 24)
    public void check_if_adult_number_is_two_then_try_to_add_two_seatsTest() throws InterruptedException
    {

        FP.check_if_adult_number_is_two_then_try_to_add_two_seats();
    }

    @Test(priority = 25)
    public void check_if_selected_seat_is_window_or_aisleTest() throws InterruptedException {
        FP.check_if_selected_seat_is_window_or_aisle();
    }

    @Test(priority = 26)
    public void userIsOnFlightDetailsPagesTest() throws InterruptedException {
        FP.userIsOnFlightDetailsPages();
    }
    @Test(priority = 27, dataProvider = "AdultDetails")
    public void userTriesToEnterTheAdultDetailsTest(String name, String surname) throws InterruptedException {

        FP.userTriesToEnterTheAdultDetails(name,surname);
    }
    @DataProvider(name="AdultDetails")
    public Object[][] getDataFromDataProviderAdultDetails() throws IOException
    {
        return ExcelDataProvider.getDataArray(FlightBookingDataProvider,"AdultDetails");
    }

    @Test(priority = 28)
    public void userIsOnFlightDetailsPageTest() throws InterruptedException {
        FP.userIsOnFlightDetailsPage();
    }
    @Test(priority = 29, dataProvider = "ContactDetails")
    public void userTriesToEnterTheContactDetailsTest(String email, String conformEmail,String phone,String address,String postcode,String city) throws InterruptedException {

        FP.userTriesToEnterTheContactDetails(email,conformEmail,phone,address,postcode,city);
    }
    @DataProvider(name="ContactDetails")
    public Object[][] getDataFromDataProviderContactDetails() throws IOException
    {
        return ExcelDataProvider.getDataArray(FlightBookingDataProvider,"ContactDetails");
    }
}

















