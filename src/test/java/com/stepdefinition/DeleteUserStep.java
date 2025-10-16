package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.DeleteUserPage;
import com.pages.LoginPage;
import com.utils.ReadConfig;
import com.utils.TestBase;

import io.cucumber.java.en.*;

public class DeleteUserStep {

    private WebDriver driver = TestBase.getDriver();
    private LoginPage loginPage;
    private DeleteUserPage deleteUserPage;

    // Load values from config
    private final String baseUrl = ReadConfig.readPropertyFileData("baseUrl", "config");
    private final String loginUsername = ReadConfig.readPropertyFileData("userName", "config");
    private final String loginPassword = ReadConfig.readPropertyFileData("password", "config");
    private final String targetUsername = ReadConfig.readPropertyFileData("newUserName", "config");

    @Given("user is logged in to delete a user")
    public void user_is_logged_in_to_delete_a_user() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.loginCre(loginUsername, loginPassword);
        deleteUserPage = new DeleteUserPage(driver);
    }

    @When("the user is deleted")
    public void the_user_is_deleted() {
        deleteUserPage.deleteUser(targetUsername); // ✅ Actual deletion happens here
    }

    @Then("the user should no longer appear in the list")
    public void the_user_should_no_longer_appear_in_the_list() {
        // Check if user is absent after deletion
        boolean isDeleted = deleteUserPage.isUserDeleted(targetUsername);
        System.out.println("User deletion status: " + isDeleted);

        // Assert user is deleted (i.e., not found in the list)
        Assert.assertTrue(" User still found in the list after deletion!", isDeleted);
    }

}
