package MyTestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/resources/Features",
        glue = {"StepDefinitions", "Hook"},
        tags = "@GlobalTag",
        plugin = {"pretty"},
        monochrome = true,
        dryRun = false
)
public class TestRunner {


}
