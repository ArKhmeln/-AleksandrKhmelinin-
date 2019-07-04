package hw6;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:hw6"},
        glue = {"classpath:hw6"},
        tags = {"@run1, @run2"}
)
public class RunAcceptanceIT extends AbstractTestNGCucumberTests {}
