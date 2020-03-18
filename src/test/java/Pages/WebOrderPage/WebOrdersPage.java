package Pages.WebOrderPage;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebOrdersPage {
    public WebOrdersPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Order']")
    public WebElement WebOrdersButton;

    @FindBy(xpath = "//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement chooseProduct;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement chooseQuantity;


    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$cardList']")
    public List<WebElement> cardName;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    public WebElement cardNumber;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    public WebElement expirationDate;

    @FindBy(xpath = "//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")
    public WebElement saveButton;
    @FindBy(xpath = "//a[.='View all products']")
    public WebElement viewAllOrders;


    public void selectCard(String cardName){
        switch(cardName){
            case "Visa":
                this.cardName.get(0);
                break;
            case"MasterCard":
                this.cardName.get(1);
                break;
            case"American Express":
                this.cardName.get(2);
                break;
        }
    }

}
