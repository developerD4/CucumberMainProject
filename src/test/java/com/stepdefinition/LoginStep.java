package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.pages.LoginPage;
import com.utils.ReadConfig;
import com.utils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	
	WebDriver driver = TestBase.getDriver();
	LoginPage lp;

	String baseUrl = ReadConfig.readPropertyFileData("baseUrl", "config");
	String username = ReadConfig.readPropertyFileData("userName", "config");
	String password = ReadConfig.readPropertyFileData("password", "config");

	@Given("the user is on the OrangeHRM login page")
	public void the_user_is_on_the_orange_hrm_login_page() {
		driver.get(baseUrl);
		lp = new LoginPage(driver);
	}

	@When("the user enters a valid username and password")
	public void the_user_enters_a_valid_username_and_password() {
		lp.loginCre(username, password);
	}

	@Then("the user should be redirected to the OrangeHRM dashboard")
	public void the_user_should_be_redirected_to_the_orange_hrm_dashboard() {
	    String actualTitle = driver.getTitle();
	    Assert.assertTrue("Login failed or dashboard not loaded", actualTitle.contains("Dashboard"));
	
	}
}
