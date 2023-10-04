package pages;

import dev.failsafe.internal.util.Assert;
import elements.FilterPageElements;
import elements.SeatSelectorPageElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SeatSelectionPage extends SeatSelectorPageElements {

    public SeatSelectionPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void iAmOnPageAndCheckTheUrlIsCorrectOrNot() throws InterruptedException {

        Helper.iAmOnPageAndCheckTheUrlIsCorrectOrNot();
    }

    public void selectSourceAsDestinationAsAndTravelDate() throws InterruptedException
    {
        Helper.selectSourceAsDestinationAsAndTravelDate("LHR","FRA");
    }

    public void user_select_a_flight() throws InterruptedException
    {
        Helper.selectFlight();
    }

    public void check_if_the_user_is_on_the_flight_details_page() throws InterruptedException {

        Thread.sleep(15000);
        String detailsPageUrl=driver.getCurrentUrl();
        System.out.println(detailsPageUrl);

        if(detailsPageUrl.contains("https://www.opodo.co.uk/travel/secure/#details/"))
        {
            System.out.println("Correct url");
        }
        else {
            System.out.println("Incorrect url");
        }
    }

    public void display_number_of_passengers_before_count_is_increased() throws InterruptedException {
        Helper.selectFlight();
        Thread.sleep(13000);
        Helper.findNoOfAdults();
        Helper.scrollUpDown(200);
    }

    public void user_clicks_on_add_another_adult_button_in_the_page() throws InterruptedException {
        addAnotherAdultElement.click();
        Thread.sleep(15000);
        Helper.scrollUpDown(-150);
        Thread.sleep(10000);
    }

    public void show_the_updated_number_of_adults() {
        Helper.findNoOfAdults();
    }

    public void check_if_the_number_of_passengers_got_increased() {
        int s= Helper.adultNumber=  Helper.adultNumber+1;
        if(Helper.adultNumber==s)
        {
            System.out.println("Adult incremented");
        }
        else {
            System.out.println("Adult Not incremented");
        }
    }

    public void check_the_number_of_seats_available() throws InterruptedException
    {
        //seat selection
        Helper.selectFlight();
        Thread.sleep(13000);
        addAnotherAdultElement.click();
        Thread.sleep(23000);
        Helper.findNoOfAdults();
        Helper.scrollUpDown(2500);
        totalSeats=  availableSeat.size();
        System.out.println("Total Number of available seats :"+ totalSeats);
    }

    public void check_if_seat_size_is_zero_then_display_no_seat_available()
    {
        if(totalSeats==0)
        {
            System.out.println("No seat available");
        }
    }

    public void check_if_adult_number_is_one_then_try_to_add_single_seat() throws InterruptedException
    {
        if(Helper.adultNumber==1 && totalSeats >0)
        {
            System.out.println("Row number: " + singleSeatElement.getAttribute("data-row"));
            System.out.println("Column Number: " + singleSeatElement.getAttribute("data-column"));
            System.out.println("seat Type: " + singleSeatElement.getAttribute("data-texttype"));
            singleSeatElement.click();
            Thread.sleep(3000);
        }
    }

    public void check_if_adult_number_is_two_then_try_to_add_two_seats() throws InterruptedException
    {
        int j = 0;
        Thread.sleep(2000);
        if(Helper.adultNumber==2 && totalSeats >0) {

            for (WebElement Seat : availableSeat)
            {
                Thread.sleep(2000);
                System.out.println("Row number: " + Seat.getAttribute("data-row"));
                System.out.println("Column Number: " + Seat.getAttribute("data-column"));
                System.out.println("seat Type: " + Seat.getAttribute("data-texttype"));
                Thread.sleep(4000);
                Seat.click();
                j++;
                if (j == 2)
                {
                    break;
                }
            }
            Helper.typeOfSeat();
        }
    }

    public void check_if_selected_seat_is_window_or_aisle() throws InterruptedException {
        if(Helper.adultNumber==1 && totalSeats >0)
        {

            Helper.typeOfSeat();
        }
    }

    public void userIsOnFlightDetailsPages(int scrollValue) throws InterruptedException {
        Helper.selectFlight();
        Thread.sleep(10000);
        Helper.scrollUpDown(scrollValue);
    }

    public void userTriesToEnterTheAdultDetails(String names,String surnames) throws InterruptedException
    {
        name.sendKeys(names);
        surName.sendKeys(surnames);
        Thread.sleep(4000);
    }

    public void userTriesToEnterTheContactDetails(String emails, String conformEmails,String phones,String addresss,String postcodes,String citys) throws InterruptedException {

        email.sendKeys(emails);
        conformEmail.sendKeys(conformEmails);
        phone.sendKeys(phones);
        address.sendKeys(addresss);
        postcode.sendKeys(postcodes);
        city.sendKeys(citys);
        Thread.sleep(8000);
    }
}
