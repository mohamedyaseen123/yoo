package com.simplilearn.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = "pretty", features = "src/test/pizzahutproject1/senario1.feature", glue = {"com.simplilearn.pizzahut1"})

public class TestRunner {

}
