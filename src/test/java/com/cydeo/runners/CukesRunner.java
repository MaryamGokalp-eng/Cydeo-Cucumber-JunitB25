package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@wip",
        publish = false

)
public class CukesRunner {
}


//CukesRunner Class point at the StepDefinitions and features folder class
//My FailedTestRunner Pointed at StepDefinition folder & rerun.txt Target folder class

//parallel testing using the sameDriver and to set up limited number of thread
//Once you run your code "pretty", plugin-->print your scenario on your console
//->publish = true will enable functionality from cucumber to generate a public link for the report
//of our final execution of our code

