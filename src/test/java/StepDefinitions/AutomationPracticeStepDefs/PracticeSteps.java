package StepDefinitions.AutomationPracticeStepDefs;

import Pages.AutomationPracticePage.AutomationPage;
import Utils.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PracticeSteps {

    AutomationPage page=new AutomationPage();
    WebDriver driver= Driver.getDriver();

    @Then("user navigate to automation practice page")
    public void user_navigate_to_automation_practice_page() {
       driver.get("http://automationpractice.com/index.php");
    }

    @Then("the user search with value {string}")
    public void the_user_search_with_value(String searchValue) {
        page.searchBar.sendKeys(searchValue);
        page.searchButton.click();
    }

    @Then("the user validate title of page {string}")
    public void the_user_validate_title_of_page(String expectedTitle) {
    String actual=driver.getTitle();
    Assert.assertEquals(expectedTitle,actual);
    }

    @Then("te user validate search value {string}")
    public void te_user_validate_search_value(String expectedResult) {
        String actualTitle=page.searchResult.getText().toLowerCase();
        Assert.assertEquals(expectedResult.toLowerCase(),actualTitle);
    }
    @Then("the user validate title of page")
    public void the_user_validate_title_of_page(Map<String,String> title) {
        String expectedTitle=title.get("Title");
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Then("the user search with doc types")
    public void the_user_search_with_doc_types(String docString) {
       page.searchBar.sendKeys(docString);
    }

}
