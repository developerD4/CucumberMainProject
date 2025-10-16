package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPage;
import com.utils.ReadConfig;
import com.utils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

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
		// Wait until dashboard element is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h6[text()='Dashboard']")  // Adjust this XPath as per your actual Dashboard header
			));
			Assert.assertTrue("User is on Dashboard", true);
		} catch (Exception e) {
			Assert.fail("Login failed or Dashboard not loaded: " + e.getMessage());
		}
	}
}
