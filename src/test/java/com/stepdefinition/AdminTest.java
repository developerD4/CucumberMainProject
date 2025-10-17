package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utils.ReadConfig;
import com.utils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminTest {
	
	WebDriver driver = TestBase.getDriver();
	LoginPage lp;
	DashboardPage dp;
	
	public String username = ReadConfig.readPropertyFileData("userName", "config");
	public String password = ReadConfig.readPropertyFileData("password", "config");
    
	@Given("the user is on the dashboard")
	public void the_user_is_on_the_dashboard() {
	    // Write code here that turns the phrase above into concrete actions
		lp=new LoginPage(driver);
		lp.loginCre(username, password);
	   System.out.println("the user is on the dashboard");
	}

	@When("the user clicks on the Admin button")
	public void the_user_clicks_on_the_admin_button() {
	    // Write code here that turns the phrase above into concrete actions
	    dp=new DashboardPage(driver);
	    dp.admin();
	    System.out.println("the user clicks on the Admin button");
	}

	@Then("the user should be redirected to the Admin page")
	public void the_user_should_be_redirected_to_the_admin_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("the user should be redirected to the Admin page");
	}


}
