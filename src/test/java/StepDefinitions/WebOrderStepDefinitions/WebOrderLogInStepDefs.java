package StepDefinitions.WebOrderStepDefinitions;

import Pages.WebOrderPage.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class WebOrderLogInStepDefs {
    WebDriver driver= Driver.getDriver();
    LoginPage page=new LoginPage();

    @Given("the user navigate to the web orders page")
    public void the_user_navigate_to_the_web_orders_page() {
        System.out.println("Navigate to web order page");
        // Write code here that turns the phrase above into concrete actions
        driver.get(ConfigReader.getProperty("url"));

    }

    @When("the user provide valid username")
    public void the_user_provide_valid_username() {
        System.out.println("The user sent Tester");
        // Write code here that turns the phrase above into concrete actions
        page.userName.sendKeys(ConfigReader.getProperty("userName"));


    }

    @When("the user provide valid password")
    public void the_user_provide_valid_password() {
        System.out.println("the user sent test");
        // Write code here that turns the phrase above into concrete actions
        page.password.sendKeys(ConfigReader.getProperty("password"));
        page.loginButton.click();

    }

    @Then("the user should see home page")
    public void the_user_should_see_home_page() {
        System.out.println("the user validate home page");
        // Write code here that turns the phrase above into concrete actions
        String expectedTitle="Web Orders";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("the user provider userName {string}")
    public void the_user_provider_userName_Test(String userName) {
     page.userName.sendKeys(userName);
    }

    @When("the user provided password {string}")
    public void the_user_provided_password(String password) {
        page.password.sendKeys(password);
        page.loginButton.click();
    }


    @Then("the user validate text {string}")
    public void the_user_validate_text(String expectedErrorMessage) {
       String actualMessage=page.errorMessage.getText();
       Assert.assertEquals(actualMessage,expectedErrorMessage);
    }
    @When("the user provider userName {int}")
    public void the_user_provider_userName(Integer userName) {
      page.userName.sendKeys(userName.toString());
    }

    @When("the user provided password {int}")
    public void the_user_provided_password(Integer password) {
        page.password.sendKeys(password.toString());
        page.loginButton.click();
    }
    @When("the user provide userName {string} and password {string}")
    public void the_user_provide_userName_and_password(String userName, String password) {
        page.userName.sendKeys(userName);
        page.password.sendKeys(password);
        page.loginButton.click();
    }



}
