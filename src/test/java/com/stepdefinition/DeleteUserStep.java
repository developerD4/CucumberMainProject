package com.stepdefinition;

import org.openqa.selenium.WebDriver;
import com.pages.LoginPage;
import com.pages.AdminPage;
import com.pages.DeleteUserPage;
import com.utils.ReadConfig;
import com.utils.TestBase;
import io.cucumber.java.en.*;

public class DeleteUserStep {

    WebDriver driver = TestBase.getDriver();
    LoginPage loginPage;
    AdminPage adminPage;
    DeleteUserPage deleteUserPage;

    String baseUrl = ReadConfig.readPropertyFileData("baseUrl", "config");
    String username = ReadConfig.readPropertyFileData("userName", "config");
    String password = ReadConfig.readPropertyFileData("password", "config");
    String targetUsername = ReadConfig.readPropertyFileData("newUserName", "config");

    @Given("user is logged in to delete")
    public void user_is_logged_in_to_delete() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.loginCre(username, password);
        adminPage = new AdminPage(driver);
        adminPage.openAdminSection();
        deleteUserPage = new DeleteUserPage(driver);
    }

    @When("user is deleted")
    public void user_is_deleted() {
        deleteUserPage.deleteUser(targetUsername);
    }

    @Then("user should be removed from the list")
    public void user_should_be_removed_from_the_list() {
        System.out.println("User deleted.");
    }
}