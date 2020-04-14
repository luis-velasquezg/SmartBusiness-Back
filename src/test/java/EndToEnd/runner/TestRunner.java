package EndToEnd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/EndToEnd/features/",
        glue = {"EndToEnd/seleniumgluecode"}
)


public class TestRunner {
}
