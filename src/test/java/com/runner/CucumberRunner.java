package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "./src/test/resources",
	glue = {"com.stepdefinition", "com.utils"},
	plugin = {
					"pretty", "html:target/htmltestreport.html"
			}
)
public class CucumberRunner {
	

}
