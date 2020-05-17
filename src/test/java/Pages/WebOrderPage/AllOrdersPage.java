package Pages.WebOrderPage;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOrdersPage {
    public AllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2")
    public WebElement headerTitle;
    @FindBy(xpath = "//td[.='123456789012']/following-sibling::td[2]/input")
    public WebDriver editButton;
    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement allOrdersButton;


}
