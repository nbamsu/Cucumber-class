package Pages.WebOrderPage;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EditOrderPage {
    public EditOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

        @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
        public WebElement customerName;
        @FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
        public WebElement street;
        @FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
        public WebElement city;
        @FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
        public WebElement state;
        @FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
        public WebElement zip;
        @FindBy(id="ctl00_MainContent_fmwOrder_UpdateButton")
        public WebElement updateButton;
        @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tbody//tr[2]//td")
        public List<WebElement> orderInfo;

}
