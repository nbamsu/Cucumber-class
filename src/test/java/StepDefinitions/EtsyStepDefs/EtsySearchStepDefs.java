package StepDefinitions.EtsyStepDefs;


import Pages.EtsyPage.EtsyPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EtsySearchStepDefs {
    WebDriver driver=Driver.getDriver();
    EtsyPage page=new EtsyPage();

    @Given("the user navigate to the Etsy")
    public void the_user_navigate_to_the_Etsy(){
        driver.get(ConfigReader.getProperty("etsyUrl"));

    }
    @When("the user search {string}")
    public void the_user_search(String searchValue) {
     page.searchBar.sendKeys(searchValue);
     page.searchButton.click();
    }

    @Then("the user validate {string}")
    public void the_user_validate(String expectedTitle) {
      String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }






}
