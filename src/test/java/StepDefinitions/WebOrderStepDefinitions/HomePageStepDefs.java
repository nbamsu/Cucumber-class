package StepDefinitions.WebOrderStepDefinitions;

import Pages.WebOrderPage.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePageStepDefs {
    HomePage page = new HomePage();

    @Then("the user validate order menu list")
    public void the_user_validate_order_menu_list() {
        // Write code here that turns the phrase above into concrete actions
        List<String> expected = page.orderMenuData();// this is for API respone
        List<String> actual = new ArrayList<>();// this is coming from Website
        for (WebElement element : page.orderMenu) {//used this loop to get text from web element
            actual.add(element.getText());
        }
        for (int i = 0; i < actual.size(); i++) {//used this loop for assertion
            //Assert.assertEquals(expected.get(i), actual.get(i));
        }
        System.out.println("this is for menu");

    }
}
