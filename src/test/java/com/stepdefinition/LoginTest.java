package com.stepdefinition;

import org.openqa.selenium.WebDriver;
import com.pages.LoginPage;
import com.utils.ReadConfig;
import com.utils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	
	WebDriver driver = TestBase.getDriver();
	LoginPage lp;
	
	public String username = ReadConfig.readPropertyFileData("userName", "config");
	public String password = ReadConfig.readPropertyFileData("password", "config");
    
	@Given("the user is on the OrangeHRM login page")
	public void the_user_is_on_the_orange_hrm_login_page() {
		System.out.println("Login Page");
	}	
	
	@When("the user enters a valid username and password")
	public void the_user_enters_a_valid_username_and_password() {
		lp = new LoginPage(driver);
		lp.loginCre(username, password);
	}
	@Then("the user should be redirected to the OrangeHRM dashboard")
	public void the_user_should_be_redirected_to_the_orange_hrm_dashboard() {
	    System.out.println("OrangeHRM dashboard");
	}
	
}
