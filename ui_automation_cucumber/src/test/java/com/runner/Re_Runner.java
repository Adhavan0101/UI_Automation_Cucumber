package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "@target/Failed_Scenarios.txt",
glue = "com.step_definitions", 
dryRun = false, 
monochrome = true)

public class Re_Runner {

}
