package StepDefinitions.WebOrderStepDefinitions;

import Pages.WebOrderPage.AllOrdersPage;
import Pages.WebOrderPage.AllProductPage;
import Pages.WebOrderPage.EditOrderPage;
import Utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebOrderEditeOrderStepDefs {

    EditOrderPage editOrderPage=new EditOrderPage();
    AllOrdersPage allOrdersPage=new AllOrdersPage();

    @Then("the user click edit button")
    public void the_user_click_edit_button() {
    editOrderPage.editButton.click();
        

    }

    @When("the user change customerName {string}")
    public void the_user_change_customerName(String customerName) {
        editOrderPage.customerName.clear();
        editOrderPage.customerName.sendKeys(customerName);

    }

    @When("the user change street {string}")
    public void the_user_change_street(String street) {
        editOrderPage.street.clear();
        editOrderPage.street.sendKeys(street);

    }

    @When("the user change city {string}")
    public void the_user_change_city(String city) {
        editOrderPage.city.clear();
        editOrderPage.city.sendKeys(city);

    }

    @When("the user change state  {string}")
    public void the_user_change_state(String state) {
        editOrderPage.state.clear();
        editOrderPage.state.sendKeys(state);

    }

    @When("the user change zip {string}")
    public void the_user_change_zip(String zip) {
    editOrderPage.zip.clear();
    editOrderPage.zip.sendKeys(zip);
    }

    @When("the user click update button")
    public void the_user_click_update_button() {
    editOrderPage.updateButton.click();
    }

    @Then("the user validate update order info")
    public void the_user_validate_update_order_info() {
        List<WebElement> orderInfo=editOrderPage.orderInfo;
        String actualNames=orderInfo.get(2).getText();
        String actualStreetName = orderInfo.get(5).getText();
        String actualCityName = orderInfo.get(6).getText();
        String actualState = orderInfo.get(7).getText();
        String actualZip = orderInfo.get(8).getText();


    }

}
