package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SeatSelectorPageElements extends Driver {
    public SeatSelectorPageElements()
    {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[class='prisma-btn prisma-btn-round prisma-btn-default odf-display-inline-block details_change_pax_button']")
    public WebElement addAnotherAdultElement;
    @FindBy(xpath = "//div[@class='aircraftmap_seat odf-icon od-aircraftmap-icon odf-text-xl  aircraftmap_default_seat od-aircraftmap-default-seat-primary']")
    public List<WebElement> availableSeat;
    @FindBy(xpath = "//div[@class='aircraftmap_seat odf-icon od-aircraftmap-icon odf-text-xl  aircraftmap_default_seat od-aircraftmap-default-seat-primary']")
    public WebElement singleSeatElement;

    @FindBy(xpath = "//*[@id=\"passengers0\"]/div[2]/div[2]/div/form/div[1]/div[5]/div[1]/div/div/div[2]/input")
    public WebElement name;
    @FindBy(xpath = "//*[@id=\"passengers0\"]/div[2]/div[2]/div/form/div[1]/div[5]/div[2]/div/div/div[2]/input")
    public WebElement surName;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/input")
    public WebElement email;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div/div[2]/input")
    public WebElement conformEmail;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/input")
    public WebElement phone;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[3]/div[1]/div/div/div[2]/input")
    public WebElement address;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[3]/div[2]/div/div/div[2]/input")
    public WebElement postcode;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[4]/div[1]/div/div/div[2]/input")
    public WebElement city;
    public int totalSeats;
}
