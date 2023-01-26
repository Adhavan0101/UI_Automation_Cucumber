package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "classpath:/features",
glue = "com.step_definitions", 
dryRun = false, 
monochrome = true, 
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/Failed_Scenarios.txt",
		"junit:target/cucumber_reports/report.xml" })

public class TestRunner {

}