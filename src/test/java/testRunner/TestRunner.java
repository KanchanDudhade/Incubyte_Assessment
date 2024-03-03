package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\eclipse\\Incubyte_Assessment\\Compose_Gmail\\compose_email.feature",
                 glue = {"stepDefination"})
public class TestRunner {
}

