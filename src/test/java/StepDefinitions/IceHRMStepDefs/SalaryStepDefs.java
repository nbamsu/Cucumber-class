package StepDefinitions.IceHRMStepDefs;

import Pages.IceHRMPage.IcehrmPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SalaryStepDefs {

    IcehrmPage page=new IcehrmPage();
    WebDriver driver= Driver.getDriver();

    @Given("the user navigate to icehrm website")
    public void the_user_navigate_to_icehrm_website() {
        driver.get(ConfigReader.getProperty("iceHRMUrl"));
    }

    @When("the user provide icehrm username {string}")
    public void the_user_provide_icehrm_username(String userName) {
    page.userName.sendKeys(userName);
    }

    @When("the user provide icehrm password {string}")
    public void the_user_provide_icehrm_password(String password) {
    page.password.sendKeys(password);
    }

    @Then("the user click sign in button")
    public void the_user_click_sign_in_button() {
    page.loginButton.click();
    }

    @Given("The user click the salary button")
    public void the_user_click_the_salary_button() {
    page.payrollButton.click();
    page.salaryButton.click();
    }

    @Given("The user click add new button")
    public void the_user_click_add_new_button() {
    page.addNewButton.click();
    }

    @Given("The user click code {string}")
    public void the_user_click_code(String code) {
    page.codeBox.sendKeys(code);
    }

    @Given("The user click name {string}")
    public void the_user_click_name(String name) {
    page.nameBox.sendKeys(name);
    }

    @Given("the user click the save button")
    public void the_user_click_the_save_button() {
    page.saveButton.click();
    }

    @Then("user validate {string} and {string} are saved")
    public void user_validate_and_are_saved(String code, String name) throws InterruptedException {

    page.findLastPage();
    String actualCode=page.lastCode.getText();
    String actualName=page.lastName.getText();
    Thread.sleep(1000);
        Assert.assertTrue(actualCode.equals(code));
        Assert.assertTrue(actualName.equals(name));
    }

}
