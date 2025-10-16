package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
		        "src/test/resources/login.feature",
		        "src/test/resources/admin.feature",
		        "src/test/resources/search.feature",
		        "src/test/resources/edit.feature",
		        "src/test/resources/delete.feature"  // run last
		    },
	glue = {"com.stepdefinition" , "com.utils"},
	plugin = {
					"pretty", "html:target/htmltestreport.html"
			}
)
public class CucumberRunner {
	

}
