package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class DeleteUserPage {

    private WebDriver driver;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement usernameInput;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDeleteButton;

    public DeleteUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Deletes the specified user by searching and clicking delete + confirm
    public void deleteUser(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            System.out.println("Attempting to delete user: " + username);

            // Enter username in search field
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            usernameInput.clear();
            usernameInput.sendKeys(username);

            // Click Search button
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();

            // Wait for results or 'No Records Found' message
            wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='row']")),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'No Records Found')]"))
            ));

            // Check if user is already absent
            List<WebElement> noRecords = driver.findElements(By.xpath("//*[contains(text(),'No Records Found')]"));
            if (!noRecords.isEmpty() && noRecords.get(0).isDisplayed()) {
                System.out.println("User not found in list — possibly already deleted.");
                return;
            }

            // Locate the user row based on username
            WebElement userCell = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@role='row']//div[contains(text(),'" + username + "')]")));

            WebElement userRow = userCell.findElement(By.xpath("./ancestor::div[@role='row']"));

            // Find and click the delete icon in the user row
            WebElement deleteIcon = userRow.findElement(By.xpath(".//i[contains(@class, 'bi-trash')]"));
            deleteIcon.click();
            System.out.println("Clicked delete icon for user.");

            // Confirm the deletion popup
            wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
            confirmDeleteButton.click();
            System.out.println("Confirmed delete.");

            // Wait until the user row disappears from the DOM
            wait.until(ExpectedConditions.stalenessOf(userRow));
            System.out.println("User row disappeared - deletion likely successful.");

        } catch (TimeoutException e) {
            System.out.println("Timeout while deleting user: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Could not find element while deleting user: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error during deletion: " + e.getMessage());
        }
    }

    // Checks if the user no longer appears in the list (means deleted)
    public boolean isUserDeleted(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Wait for username input and enter username
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            usernameInput.clear();
            usernameInput.sendKeys(username);

            // Click Search button
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();

            // Wait for either results or "No Records Found"
            wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='row']")),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'No Records Found')]"))
            ));

            // Check if "No Records Found" is displayed
            List<WebElement> noRecords = driver.findElements(By.xpath("//*[contains(text(),'No Records Found')]"));
            boolean isDeleted = !noRecords.isEmpty() && noRecords.get(0).isDisplayed();

            System.out.println("No Records Found visible? " + isDeleted);
            return isDeleted;

        } catch (TimeoutException e) {
            System.out.println("Timeout while verifying deletion: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error verifying deletion: " + e.getMessage());
            return false;
        }
    }
}
