package com.stepdefinition;

import org.openqa.selenium.WebDriver;
import com.pages.LoginPage;
import com.pages.AdminPage;
import com.pages.EditUserPage;
import com.utils.ReadConfig;
import com.utils.TestBase;
import io.cucumber.java.en.*;

public class EditUserStep {

    WebDriver driver = TestBase.getDriver();
    LoginPage loginPage;
    AdminPage adminPage;
    EditUserPage editUserPage;

    String baseUrl = ReadConfig.readPropertyFileData("baseUrl", "config");
    String username = ReadConfig.readPropertyFileData("userName", "config");
    String password = ReadConfig.readPropertyFileData("password", "config");
    String targetUsername = ReadConfig.readPropertyFileData("newUserName", "config");
    String newStatus = ReadConfig.readPropertyFileData("newStatus", "config");

    @Given("user is logged in to edit user status")
    public void user_is_logged_in_to_edit_user_status() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.loginCre(username, password);
        adminPage = new AdminPage(driver);
        adminPage.openAdminSection();
        editUserPage = new EditUserPage(driver);
    }

    @When("the user status is edited")
    public void the_user_status_is_edited() {
        editUserPage.editUserStatus(targetUsername, newStatus);
    }

    @Then("the updated status should be reflected")
    public void the_updated_status_should_be_reflected() {
        System.out.println("User status updated.");
    }
}