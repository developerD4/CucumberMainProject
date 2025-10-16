package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.pages.DeleteUserPage;
import com.pages.LoginPage;
import com.utils.ReadConfig;
import com.utils.TestBase;

import io.cucumber.java.en.*;

public class DeleteUserStep {

    WebDriver driver = TestBase.getDriver();
    LoginPage loginPage;
    DeleteUserPage deleteUserPage;

    String baseUrl = ReadConfig.readPropertyFileData("baseUrl", "config");
    String loginUsername = ReadConfig.readPropertyFileData("userName", "config");
    String loginPassword = ReadConfig.readPropertyFileData("password", "config");
    String targetUsername = ReadConfig.readPropertyFileData("newUserName", "config");

    @Given("user is logged in to delete a user")
    public void user_is_logged_in_to_delete_a_user() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.loginCre(loginUsername, loginPassword);
        deleteUserPage = new DeleteUserPage(driver);
    }

    @When("the user is deleted")
    public void the_user_is_deleted() {
        deleteUserPage.deleteUser(targetUsername);
    }

    @Then("the user should no longer appear in the list")
    public void the_user_should_no_longer_appear_in_the_list() {
        System.out.println("User deletion attempted.");
        // Optional: Add verification logic here
    }
}
