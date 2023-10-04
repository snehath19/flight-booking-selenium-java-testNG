package elements;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HelperPageElements extends Driver {

    public HelperPageElements()
    {

        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "didomi-notice-disagree-button")
    public static WebElement cookieRejectBtn;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/label/div/div[1]/span")
    public static WebElement sourceTextbox;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div/input")
    public static WebElement sourceDataSelection;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/input")
    public static WebElement destinationTextbox;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/input")
    public static WebElement destinationDataSelection;
    @FindBy(css = "input[class='odf-input-m odf-text-lg odf-input odf-input-inline odf-clickable odf-text-ellipsis']")
    public static WebElement departureCalenderClick;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[3]/div/div[2]/div/div[1]/div/div[3]/div/div[2]/div[6]/div[4]")
    public static WebElement departureDateSelection;
    @FindBy(css = "button[class='odf-btn odf-btn-primary']")
    public static WebElement calenderDoneButton;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[3]/div[2]/button")
    public static WebElement searchFlight;
    @FindBy(css = "span[class='css-4ac0ja-BaseText-Text ek4n60o0']")
    public  static List<WebElement> emptyFlightElement;
    @FindBy(xpath = "//button[@class='e6ygnnq0 css-320tze-StyledBaseCallToAction-StyledButton e3hopz80'][1]")
    public  static WebElement flightSelection;
    @FindBy(xpath = "//*[@id=\"passengers_search_manager\"]/div[2]/div/div[1]/div/span/div/span[2]")
    public  static WebElement totalNoOfAdultsElement;
    @FindBy(xpath = "//*[@id=\"seatmap-selection-manager\"]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/span[2]")
    public static  WebElement selectedSeatElement;
    public  static String stopData;
    public static int adultNumber;

}
