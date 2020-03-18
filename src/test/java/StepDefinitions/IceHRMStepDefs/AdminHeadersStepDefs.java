package StepDefinitions.IceHRMStepDefs;

import Pages.IceHRMPage.IcehrmHomePage;
import Utils.BrowserUtils;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdminHeadersStepDefs {
    IcehrmHomePage page = new IcehrmHomePage();
    WebDriver driver = Driver.getDriver();


    @When("the user click the admin button")
    public void the_user_click_the_admin_button() {
        //page.adminButton.click();
    }

    @Then("teh user should see following headers")
    public void teh_user_should_see_following_headers(io.cucumber.datatable.DataTable dataTable) {

        List<String> expectedHeaders = dataTable.asList();
        List<String> actualdHeaders = BrowserUtils.getText(page.adminHeaders);
        Assert.assertTrue(actualdHeaders.containsAll(expectedHeaders));

    }

    @When("the user click the personal information button")
    public void the_user_click_the_personal_information_button() {
        page.personalInfoButton.click();
    }

    @Then("the user should see following headers")
    public void the_user_should_see_following_headers(List<String> expectedHeaders) throws InterruptedException {
        Thread.sleep(2000);
        List<String> actualHeaders = BrowserUtils.getText(page.personalInfo);
        for (int i = 0; i < expectedHeaders.size(); i++) {
            Assert.assertTrue(expectedHeaders.get(i).equals( actualHeaders.get(i)));
        }

    }

    @When("the user gives the personal informations")
    public void the_user_gives_the_personal_informations(Map<String,String> personInfo) {
        Set<String> keys=personInfo.keySet();
        for (String key:keys){
            if (personInfo.get(key).equals("123456")){
                System.out.println(key);
            }
        }
    }



}
