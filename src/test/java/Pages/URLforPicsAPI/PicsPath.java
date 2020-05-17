package Pages.URLforPicsAPI;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PicsPath {
    public PicsPath(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//img[@style='-webkit-user-select: none;margin: auto;']")
    public WebElement pic1;
}
