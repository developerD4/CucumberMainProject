package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.pages.AdduserPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.SearchPage;
import com.utils.ReadConfig;
import com.utils.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep {
	WebDriver driver = TestBase.getDriver();
	LoginPage lp;
	DashboardPage dp;
	AdduserPage ap;
	SearchPage sp;
	public String username = ReadConfig.readPropertyFileData("userName", "config");
	public String password = ReadConfig.readPropertyFileData("password", "config");
	
	@When("the user enters the Username, selects a User Role, enters the Employee Name, selects a Status, and clicks on the Search button")
	public void the_user_enters_the_username_selects_a_user_role_enters_the_employee_name_selects_a_status_and_clicks_on_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		sp=new SearchPage(driver);
		sp.searchEmp(username, "Virat  Kohli","Enabled", "ESS");
	    System.out.println("the user enters the Username, selects a User Role, enters the Employee Name, selects a Status, and clicks on the Search button");
	}

	@Then("the user remains on the Admin page and search results are displayed")
	public void the_user_remains_on_the_admin_page_and_search_results_are_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("the user remains on the Admin page and search results are displayed");
	}

}
