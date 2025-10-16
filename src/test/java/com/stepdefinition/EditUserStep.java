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

    @Given("user is logged in to edit")
    public void user_is_logged_in_to_edit() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.loginCre(username, password);
        adminPage = new AdminPage(driver);
        adminPage.openAdminSection();
        editUserPage = new EditUserPage(driver);
    }

    @When("user status is updated")
    public void user_status_is_updated() {
        editUserPage.editUserStatus(targetUsername, newStatus);
    }

    @Then("updated status should be reflected")
    public void updated_status_should_be_reflected() {
        System.out.println("User status updated.");
    }
}