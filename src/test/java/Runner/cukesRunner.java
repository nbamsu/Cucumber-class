package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\com.cucumber.features.webOrder\\WebOrderProductionInfo.feature",
        glue = "StepDefinitions",
        dryRun = true,
        monochrome = true


)
public class cukesRunner {
//src\test\resources\com.cucumber.features\RunnerTest.feature

}
