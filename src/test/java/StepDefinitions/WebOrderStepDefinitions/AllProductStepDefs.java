package StepDefinitions.WebOrderStepDefinitions;

import Pages.WebOrderPage.AllProductPage;
import Pages.WebOrderPage.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AllProductStepDefs {

    HomePage page=new HomePage();
    AllProductPage allProductPage=new AllProductPage();

    @Then("user click view all product button")
    public void user_click_view_all_product_button() {
        page.viewAllProduct.click();

    }

    @Then("the user validate product table")
    public void the_user_validate_product_table() {
       List<String> actualList=allProductPage.getProductList();
       List<String> expectedList=allProductPage.expectedData();
        Assert.assertTrue(actualList.containsAll(expectedList));
    }

}
