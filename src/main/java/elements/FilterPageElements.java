package elements;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class FilterPageElements extends Driver {


    public FilterPageElements()
    {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"sorting-tab-cheapest\"]/div")
    public WebElement cheapestButton;
    @FindBy(xpath = "//*[@id=\"sorting-tab-fastest\"]/div")
    public WebElement speedButton;
    @FindBy(css = "span[class='css-bgfepo-Label e15ynz7n0']")
    public WebElement stopCheckbox;

}