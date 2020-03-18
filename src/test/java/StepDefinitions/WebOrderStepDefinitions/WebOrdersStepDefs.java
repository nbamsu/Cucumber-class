package StepDefinitions.WebOrderStepDefinitions;


import Pages.WebOrderPage.AllOrdersPage;
import Pages.WebOrderPage.EditOrderPage;
import Pages.WebOrderPage.WebOrdersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebOrdersStepDefs {

    WebOrdersPage page=new WebOrdersPage();
    EditOrderPage editOrderPage=new EditOrderPage();
    AllOrdersPage allOrdersPage=new AllOrdersPage();

    @When("The user click order button")
    public void the_user_click_order_button() {
      page.WebOrdersButton.click();
    }

    @When("The user select product {string}")
    public void the_user_select_product(String product) {
        Select select=new Select(page.chooseProduct);
        select.selectByVisibleText(product);
    }

    @When("The user give quantity {string}")
    public void the_user_give_quantity(String quantity) {
       page.chooseQuantity.sendKeys(quantity);
    }

    @When("user choose the card {string}")
    public void user_choose_the_card(String cardName) {
    page.selectCard(cardName);
    }

    @When("the user provide cardNumber {string}")
    public void the_user_provide_cardNumber(String CardNumber) {
    page.cardNumber.sendKeys(CardNumber);
    }

    @When("*user enter expiration date {string}")
    public void user_enter_expiration_date(String expiration) {
    page.expirationDate.sendKeys(expiration);
    }

    @When("user press process button")
    public void user_press_process_button() {
    page.saveButton.click();
    }
    @Then("user click view all orders button")
    public void user_click_view_all_orders_button() {
      allOrdersPage.allOrdersButton.click();
    }

    @When("the user validate update order info {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void the_user_validate_update_order_info(String product, String quantity, String customer, String street,
                                                  String city, String state, String zip,
                                                  String card, String cardNumber, String expiration) {
        List<WebElement> productInfo = editOrderPage.orderInfo;
        Assert.assertTrue(productInfo.get(1).getText().equals(customer));
        Assert.assertTrue(productInfo.get(2).getText().equals(product));
        Assert.assertTrue(productInfo.get(3).getText().equals(quantity));
        Assert.assertTrue(productInfo.get(5).getText().equals(street));
        Assert.assertTrue(productInfo.get(6).getText().equals(city));
        Assert.assertTrue(productInfo.get(7).getText().equals(state));
        Assert.assertTrue(productInfo.get(8).getText().equals(zip));
        Assert.assertTrue(productInfo.get(9).getText().equals(card));
        Assert.assertTrue(productInfo.get(10).getText().equals(cardNumber));
        Assert.assertTrue(productInfo.get(11).getText().equals(expiration));
    }
}
