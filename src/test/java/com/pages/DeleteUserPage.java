package com.pages;
 
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
 
import java.time.Duration;
 
public class DeleteUserPage {
    private WebDriver driver;
 
    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement usernameInput;
 
    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;
 
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    private WebElement deleteIcon;
 
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDeleteButton;
 
    public DeleteUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void deleteUser(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 
        try {
            // Wait for username input and search
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            usernameInput.clear();
            usernameInput.sendKeys(username);
 
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
 
            // Wait for delete icon and confirm deletion
            wait.until(ExpectedConditions.visibilityOf(deleteIcon));
            wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();
 
            wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
 
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Delete operation failed: " + e.getMessage());
        }
    }
}
 