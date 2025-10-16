package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SearchUserPage {
    private WebDriver driver;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[text()='User Role']/following::div[1]//div[contains(@class,'oxd-select-text')]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//label[text()='Status']/following::div[1]//div[contains(@class,'oxd-select-text')]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    public SearchUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchUser(String username, String role, String status) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        usernameInput.clear();
        usernameInput.sendKeys(username);

        userRoleDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@role='listbox']//span[text()='" + role + "']"))).click();

        statusDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@role='listbox']//span[text()='" + status + "']"))).click();

        searchButton.click();
    }
}
