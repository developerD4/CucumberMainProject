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

    @Given("user is logged in to search for a user")
    public void user_is_logged_in_to_search_for_a_user() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.loginCre(username, password);

        adminPage = new AdminPage(driver);
        adminPage.openAdminSection(); // ✅ Ensure Admin tab is clicked

        searchUserPage = new SearchUserPage(driver);
    }

    @When("the user is searched")
    public void the_user_is_searched() {
        searchUserPage.searchUser(searchUsername, searchRole, searchStatus);
    }

    @Then("the user should be visible in the search results")
    public void the_user_should_be_visible_in_the_search_results() {
        System.out.println("Search completed. User should be visible.");
        // Optional: Add assertion logic here
    }
}