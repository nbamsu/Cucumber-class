package Pages.AutomationPracticePage;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPage {
    public AutomationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "search_query_top")
    public WebElement searchBar;
    @FindBy(name = "submit_search")
    public WebElement searchButton;
    @FindBy(xpath = "//h1//span[1]")
    public WebElement searchResult;
}
