package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target\\cucumber-html-report","json:target\\cucumber.json","junit:target\\cucumber.xml"},
        features = "src\\test\\resources",
        //C:\Users\Nurkulov\Downloads\Cucumber-Class\src\test\resources\IceHRM\DataTableMap.feature
        glue = "StepDefinitions",
        dryRun = true,
        monochrome = true,
        tags="@TC-15"
        //snippets=SnippetTyoe


)
public class cukesRunner {
//src\test\resources\com.cucumber.features\RunnerTest.feature

}
