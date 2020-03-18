package StepDefinitions.IceHRMStepDefs;

import Pages.IceHRMPage.LanguagePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LanguageStepDefs {
    LanguagePage page=new LanguagePage();
    @Given("the user click language button")
    public void the_user_click_language_button() {
       page.languageButton.click();
    }

    @Then("the user validate language info")
    public void the_user_validate_language_info(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> expectedPersonInfo = dataTable.asMap(String.class, String.class);
        Map<String, String> actualPersonalInfo = page.getQualificationInfo(page.shortNames, page.longNames);
        Set<String> keys = expectedPersonInfo.keySet();
        for (String key:keys){
            Assert.assertEquals(expectedPersonInfo.get(key),actualPersonalInfo.get(key));
        }
    }
    @Then("the user validate language info with header")
    public void the_user_validate_language_info_with_header(List<Map<String,String>> listOfLanguage) {
        for (Map<String,String> values:listOfLanguage){
            System.out.println(values);
            if (values.get("Name").equals("tt")){
                System.out.println(values.get("Description"));
                System.out.println(values.get("Name"));
            }
        }

    }
}
