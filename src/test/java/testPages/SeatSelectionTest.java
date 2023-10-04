package testPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Helper;
import pages.SeatSelectionPage;
import utilities.Driver;
import utilities.ExcelDataProvider;

import java.io.IOException;

public class SeatSelectionTest extends Driver {

    SeatSelectionPage SP;
    String FlightBookingDataProvider = "/Users/praise_joseph/Documents/Sneha/Projects/FlightBookingSeleniumJavaTestng/src/main/resources/Book1.xlsx";

    @BeforeMethod
    public void checkTheAvailabilityOfFlightsTest() throws InterruptedException {
        Helper.setUpDriver();
        SP = new SeatSelectionPage();
        SP.iAmOnPageAndCheckTheUrlIsCorrectOrNot();
        SP.selectSourceAsDestinationAsAndTravelDate();
    }
    @Test(priority = 1)
    public void selectFlightTest() throws InterruptedException {
        SP.user_select_a_flight();
        SP.check_if_the_user_is_on_the_flight_details_page();

    }
    @Test(priority = 2)
    public void passengersCountIncrementTest() throws InterruptedException {

        SP.display_number_of_passengers_before_count_is_increased();
        SP.user_clicks_on_add_another_adult_button_in_the_page();
        SP.show_the_updated_number_of_adults();
        SP.check_if_the_number_of_passengers_got_increased();
    }

    @Test(priority = 3)
    public void checkTheTypeOfSeatBookedTest() throws InterruptedException
    {
        SP.check_the_number_of_seats_available();
        SP.check_if_seat_size_is_zero_then_display_no_seat_available();
        SP.check_if_adult_number_is_one_then_try_to_add_single_seat();
        SP.check_if_adult_number_is_two_then_try_to_add_two_seats();
        SP.check_if_selected_seat_is_window_or_aisle();
    }

    @Test(priority = 4, dataProvider = "AdultDetails")
    public void userTriesToEnterTheAdultDetailsTest(String name, String surname) throws InterruptedException {
        SP.userIsOnFlightDetailsPages(100);
        SP.userTriesToEnterTheAdultDetails(name,surname);
    }
    @DataProvider(name="AdultDetails")
    public Object[][] getDataFromDataProviderAdultDetails() throws IOException, IOException {
        return ExcelDataProvider.getDataArray(FlightBookingDataProvider,"AdultDetails");
    }

    @Test(priority = 5, dataProvider = "ContactDetails")
    public void userTriesToEnterTheContactDetailsTest(String email, String conformEmail,String phone,String address,String postcode,String city) throws InterruptedException {
        SP.userIsOnFlightDetailsPages(500);
        SP.userTriesToEnterTheContactDetails(email,conformEmail,phone,address,postcode,city);
    }
    @DataProvider(name="ContactDetails")
    public Object[][] getDataFromDataProviderContactDetails() throws IOException
    {
        return ExcelDataProvider.getDataArray(FlightBookingDataProvider,"ContactDetails");
    }

    @AfterMethod
    public void teardown() {

        Helper.tearDown();
    }

}
