package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/cydeo/step_definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {
}


// Failed test runner generated with my rerun.text in Target folder
//CukesRunner Class point at the StepDefinitions and features folder class
//My FailedTestRunner Pointed at StepDefinition folder & rerun.txt Target folder class
