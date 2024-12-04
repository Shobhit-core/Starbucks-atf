package com.starbucks.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.picocontainer.PicoFactory;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login.features",
        glue = {"com.starbucks.steps"},
        tags = "@login",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true
)
public class ParallelRunner {
    private ParallelRunner() {
    }
}
