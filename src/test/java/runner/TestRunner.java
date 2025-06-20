package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//This file is for "connection" between steps and gherkin files. It allows us to run tests

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty", "html: target/cucumber-reports.html"},
        monochrome = true
)

public class TestRunner {

}
