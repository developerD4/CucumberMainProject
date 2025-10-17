package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.pages.AdduserPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utils.ReadConfig;
import com.utils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddUser {
	WebDriver driver = TestBase.getDriver();
	LoginPage lp;
	DashboardPage dp;
	AdduserPage ap;
	
	public String username = ReadConfig.readPropertyFileData("userName", "config");
	public String password = ReadConfig.readPropertyFileData("password", "config");
	
@Given("the user is on the Admin page")
public void the_user_is_on_the_admin_page() {
    // Write code here that turns the phrase above into concrete actions
	lp=new LoginPage(driver);
	lp.loginCre(username, password);
	dp=new DashboardPage(driver);
    dp.admin();
    System.out.println("the user is on the Admin page");
}

@When("the user clicks on the add button")
public void the_user_clicks_on_the_button() {
    // Write code here that turns the phrase above into concrete actions
	ap = new AdduserPage(driver);
	ap.add();
    System.out.println("the user clicks on the add button");
}

@When("the user selects a user role")
public void the_user_selects_a_user_role() {
    // Write code here that turns the phrase above into concrete actions
	ap=new AdduserPage(driver);
	ap.selectUserRole("ESS");
	System.out.println("the user selects a user role");
    
}

@When("the user enters the employee name")
public void the_user_enters_the_employee_name() {
    // Write code here that turns the phrase above into concrete actions
	ap=new AdduserPage(driver);
	ap.fillEmpname("Virat  Kohli");
    System.out.println("the user enters the employee name");
}


@When("the user enters a username")
public void the_user_enters_a_username() {
    // Write code here that turns the phrase above into concrete actions
	ap=new AdduserPage(driver);
	ap.fillUsername("Sarooo");
   System.out.println("the user enters a username");
}

@When("the user selects a status")
public void the_user_selects_a_status() {
    // Write code here that turns the phrase above into concrete actions
	ap=new AdduserPage(driver);
	ap.selectStatus("Enabled");
    System.out.println("the user selects a status");
}

@When("the user enters a password")
public void the_user_enters_a_password() {
    // Write code here that turns the phrase above into concrete actions
	ap=new AdduserPage(driver);
	ap.fillPassword(password);
    System.out.println("the user enters a password");
}

@When("the user confirms the password")
public void the_user_confirms_the_password() {
    // Write code here that turns the phrase above into concrete actions
	ap=new AdduserPage(driver);
	ap.fillConfirmPassword(password);
    System.out.println("the user confirms the password");
    
}

@When("the user clicks on the save button")
public void the_user_clicks_on_the_save_button() {
    // Write code here that turns the phrase above into concrete actions
	ap=new AdduserPage(driver);
	ap.save();
   System.out.println("the user clicks on the save button");
}

@Then("the user should be redirected back to the Admin page")
public void the_user_should_be_redirected_back_to_the_admin_page() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("the user should be redirected back to the Admin page");
}
}
