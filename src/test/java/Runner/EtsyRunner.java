package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\com.cucumber.features.Etsy\\EtsyExampleTable.feature",
        glue = "StepDefinitions\\EtsyStepDefs",
        monochrome = true,
        dryRun = false
)

public class EtsyRunner {


}
