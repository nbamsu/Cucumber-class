package StepDefinitions.IceHRMStepDefs;

import Pages.IceHRMPage.QualificationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;
import java.util.Set;

public class QualificationStepDefs {

    QualificationPage page = new QualificationPage();

    @Given("the user click qualification step button")
    public void the_user_click_qualification_step_button() {
        page.qualificationButton.click();
    }

    @Then("the user click education tab")
    public void the_user_click_education_tab() {
        page.educationButton.click();
    }

    @Then("the user validate personal info displaed")
    public void the_user_validate_personal_info_displaed(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> expectedPersonInfo = dataTable.asMap(String.class, String.class);
        Map<String, String> actualPersonalInfo = page.getQualificationInfo(page.personalInfoNames, page.personalInfoValues);
        Set<String> keys = expectedPersonInfo.keySet();
       for (String key:keys){
           Assert.assertEquals(expectedPersonInfo.get(key),actualPersonalInfo.get(key));
       }

    }

}
