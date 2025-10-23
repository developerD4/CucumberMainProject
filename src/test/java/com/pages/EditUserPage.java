package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class EditUserPage {
    private WebDriver driver;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement usernameInput;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
    private WebElement editIcon;

    @FindBy(xpath = "//label[text()='Status']/following::div[1]//div[contains(@class,'oxd-select-text')]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    public EditUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void editUserStatus(String username, String newStatus) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Search for the user first
            wait.until(ExpectedConditions.visibilityOf(usernameInput)).clear();
            usernameInput.sendKeys(username);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

            // Wait for edit icon and click
            wait.until(ExpectedConditions.elementToBeClickable(editIcon)).click();

            // Change status
            wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//span[text()='" + newStatus + "']"))).click();

            // Save changes
            saveButton.click();

        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Edit operation failed: " + e.getMessage());
        }
    }
}