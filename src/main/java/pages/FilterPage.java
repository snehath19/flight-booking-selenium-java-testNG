package pages;

import elements.FilterPageElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FilterPage extends FilterPageElements

{
    public FilterPage()
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
}
