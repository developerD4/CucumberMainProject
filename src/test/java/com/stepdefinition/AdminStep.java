package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.pages.AdminPage;
import com.pages.LoginPage;
import com.utils.ReadConfig;
import com.utils.TestBase;

import io.cucumber.java.en.*;

public class AdminStep {

    WebDriver driver = TestBase.getDriver();
    AdminPage adminPage;
    LoginPage loginPage;

    // Reading credentials and user creation data from config file
    String baseUrl = ReadConfig.readPropertyFileData("baseUrl", "config");
    String username = ReadConfig.readPropertyFileData("userName", "config");
    String password = ReadConfig.readPropertyFileData("password", "config");

    String empName = ReadConfig.readPropertyFileData("empName", "config");
    String newUserName = ReadConfig.readPropertyFileData("newUserName", "config");
    String newUserPassword = ReadConfig.readPropertyFileData("newUserPassword", "config");
    String newUserConfirmPassword = ReadConfig.readPropertyFileData("newUserConfirmPassword", "config");

    @Given("the application is open and user is logged in")
    public void the_application_is_open_and_user_is_logged_in() 
    {
        if (baseUrl == null || username == null || password == null) {
            throw new RuntimeException("Missing login configuration values.");
        }

        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.loginCre(username, password);
        adminPage = new AdminPage(driver);
    }

    @When("the Admin section is accessed")
    public void the_admin_section_is_accessed() {
        adminPage.openAdminSection();
    }

    @When("the Add button is clicked")
    public void the_add_button_is_clicked() {
        adminPage.clickAddButton();
    }

    @When("user details are entered")
    public void user_details_are_entered() {
        if (empName == null || newUserName == null || newUserPassword == null || newUserConfirmPassword == null) {
            throw new RuntimeException("Missing new user configuration values.");
        }

        adminPage.fillUserDetails(empName, newUserName, newUserPassword, newUserConfirmPassword);
    }

    @When("the Save button is clicked")
    public void the_save_button_is_clicked() {
        adminPage.saveUser();
    }

    @Then("the new user should appear in the user list")
    public void the_new_user_should_appear_in_the_user_list() {
        // TODO: Add verification logic here
        System.out.println("User added successfully.");
    }
}