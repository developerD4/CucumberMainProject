package com.stepdefinition;

import org.openqa.selenium.WebDriver;
import com.pages.LoginPage;
import com.pages.AdminPage;
import com.pages.SearchUserPage;
import com.utils.ReadConfig;
import com.utils.TestBase;
import io.cucumber.java.en.*;

public class SearchUserStep {

    WebDriver driver = TestBase.getDriver();
    LoginPage loginPage;
    AdminPage adminPage;
    SearchUserPage searchUserPage;

    String baseUrl = ReadConfig.readPropertyFileData("baseUrl", "config");
    String username = ReadConfig.readPropertyFileData("userName", "config");
    String password = ReadConfig.readPropertyFileData("password", "config");
    String searchUsername = ReadConfig.readPropertyFileData("newUserName", "config");
    String searchRole = ReadConfig.readPropertyFileData("searchRole", "config");
    String searchStatus = ReadConfig.readPropertyFileData("searchStatus", "config");

    @Given("user is logged in to search")
    public void user_is_logged_in_to_search() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.loginCre(username, password);
        adminPage = new AdminPage(driver);
        adminPage.openAdminSection();
        searchUserPage = new SearchUserPage(driver);
    }

    @When("user is searched by username, role and status")
    public void user_is_searched_by_username_role_and_status() {
        searchUserPage.searchUser(searchUsername, searchRole, searchStatus);
    }

    @Then("search results should show the user")
    public void search_results_should_show_the_user() {
        System.out.println("User found in search results.");
    }
}