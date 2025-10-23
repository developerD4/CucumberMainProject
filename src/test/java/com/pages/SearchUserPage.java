package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SearchUserPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[text()='User Role']/following::div[1]//div[contains(@class,'oxd-select-text')]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//label[text()='Status']/following::div[1]//div[contains(@class,'oxd-select-text')]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

   
    private By firstResultRow = By.xpath("//div[@class='oxd-table-body']//div[contains(@class, 'oxd-table-card')]");

    public SearchUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchUser(String username, String role, String status) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        usernameInput.clear();
        usernameInput.sendKeys(username);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        userRoleDropdown.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//span[text()='" + role + "']"))).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        statusDropdown.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//span[text()='" + status + "']"))).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        searchButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultRow));
    }
}