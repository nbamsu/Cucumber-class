package Pages.IceHRMPage;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IcehrmHomePage {
    public IcehrmHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//ul[@id='admin_Admin']//li")
    public List<WebElement> adminHeaders;
    @FindBy(xpath = "//i[@class='fa fa-cubes']")
    public WebElement adminButton;
    @FindBy(xpath = "//ul[@id='module_Personal_Information']//li")
    public List<WebElement> personalInfo;
    @FindBy(xpath = "//span[.='Personal Information']")
    public WebElement personalInfoButton;
}
