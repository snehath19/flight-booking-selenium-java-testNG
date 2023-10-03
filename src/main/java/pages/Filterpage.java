package pages;

import Elements.FilterPageElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Filterpage extends FilterPageElements

{
    public Filterpage()
    {

        PageFactory.initElements(driver, this);
    }

    public void IAmOnPageAndCheckTheUrlIsCorrectOrNot() throws InterruptedException {

        String url="https://www.opodo.co.uk/";
        driver.manage().window().maximize();
        driver.get(url);

        String currentUrl = driver.getCurrentUrl();
        if (url.contains(currentUrl)) {
            System.out.println("Page landed correctly");
        } else {
            System.out.println("Incorrect landing");
        }
        Thread.sleep(3000);
        cookieRejectBtn.click();

    }

    public void selectSourceAsDestinationAsAndTravelDate(String source, String destination) throws InterruptedException
    {
        Thread.sleep(3000);
        sourceTextbox.click();
        Thread.sleep(2000);
        sourceDataSelection.sendKeys(source);
        sourceDataSelection.click();
        Thread.sleep(2000);
        destinationTextbox.click();
        Thread.sleep(2000);
        destinationDataSelection.sendKeys(destination);
        Thread.sleep(2000);
        destinationDataSelection.click();
        Thread.sleep(2000);
        departureCalenderClick.click();
        Thread.sleep(2000);
        departureDateSelection.click();
        calenderDoneButton.click();
        Thread.sleep(2000);
        searchFlight.click();
        Thread.sleep(18000);
    }

    public void showAvailableFlights()
    {
        Helper.fetchData("div[class='css-1um4vyc-BaseText-Body e8d0hso0']","Flight names",1000,-1000,"before","");
    }


    public void user_is_shown_prices_before_applying_any_sort() throws InterruptedException {
        //Price sort
        Helper.fetchData("span[class='money-integer css-1umyyay-BaseText-MoneyPart-DefaultPart e16uabde1']","Price before sorting",1500,-1500,"","");
        Thread.sleep(1000);
    }


    public void user_click_on_cheapest_flights_button() {
        cheapestButton.click();
    }


    public void show_prices_after_the_sort()
    {
        Helper.fetchData("span[class='money-integer css-1umyyay-BaseText-MoneyPart-DefaultPart e16uabde1']","Price after sorting",1500,-1500,"afterSelectingPriceSort","");
    }


    public void check_if_the_results_are_sorted_based_on_cheapest_price() {

    }


    public void user_is_shown_list_of_flight_hours() throws InterruptedException {
        //Time sort
        Helper.fetchData("span[class='css-1mbgvvh-BaseText-Text ek4n60o0']","Time before sorting",1500,-1500,"","");
        Thread.sleep(1000);
    }


    public void user_click_on_fastest_flights_button() {
        speedButton.click();
    }


    public void show_flight_duration_of_fastest_flights_in_sort_order() {
        Helper.fetchData("span[class='css-1mbgvvh-BaseText-Text ek4n60o0']","Time after sorting",1500,-1500,"","");
    }


    public void user_is_shown_the_list_of_flight_stops() throws InterruptedException {
        //Stop filter
        Helper.fetchData("span[class='css-1kh4dda-BaseText-Text ek4n60o0']","Stop before filtering",1500,-1500,"","");
        Thread.sleep(1000);
    }


    public void user_click_on_the_no_stops_filter_check_box() throws InterruptedException {

        Thread.sleep(2000);
        stopCheckbox.click();
        Helper.stopData=stopCheckbox.getText();
    }


    public void show_the_list_of_stops_of_all_flights()
    {
        Helper.fetchData("span[class='css-1kh4dda-BaseText-Text ek4n60o0']","Stop after filtering",1500,-1500,"afterSelectingStopFilter",Helper.stopData);
    }


    public void check_if_only_direct_flights_are_shown() {

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
       /* Helper.selectFlight();
        Thread.sleep(10000);*/
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
       /* Helper.selectFlight();
        Thread.sleep(13000);
        addAnotherAdultElement.click();*/
        //Thread.sleep(23000);
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

    public void userIsOnFlightDetailsPages() throws InterruptedException {
       /* Helper.selectFlight();
        Thread.sleep(10000);*/
        Helper.scrollUpDown(100);
    }

    public void userTriesToEnterTheAdultDetails(String names,String surnames) throws InterruptedException
    {
        name.sendKeys(names);
        surName.sendKeys(surnames);
        Thread.sleep(4000);
    }


    public void userIsOnFlightDetailsPage() throws InterruptedException {
//        Helper.selectFlight();
//        Thread.sleep(10000);
        Helper.scrollUpDown(500);
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
