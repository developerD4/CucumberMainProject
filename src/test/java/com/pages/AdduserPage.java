package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdduserPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public AdduserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@FindBy(xpath="//i[@class='oxd-icon bi-plus oxd-button-icon']")
	private WebElement addButton;
	
	@FindBy(xpath="//label[text()='User Role']/following::div[1]")
	private WebElement userRoledrop;
	
//	@FindBy(xpath="//div[@role='listbox']//div/span[text()='%s']")
//	private WebElement userRoleSelect;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement empName;
	
	@FindBy(xpath="//label[text()='Status']/following::div[1]")
	private WebElement statusDrop;
	
	@FindBy(xpath="//input[@autocomplete='off']")
	private WebElement userName;
	
	@FindBy(xpath = "(//input[@type='password'])[1]")
	private WebElement passwordInput;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;
	
	public void add() {
		addButton.click();
	}
	
	public void selectUserRole(String role) {
	    userRoledrop.click();
	    String optionXpath = String.format("//div[@role='listbox']//div/span[text()='%s']", role);
	    
	    WebElement option = driver.findElement(By.xpath(optionXpath)); 
	    option.click();
	}
	
	public void selectStatus(String statusValue) {
	    wait.until(ExpectedConditions.elementToBeClickable(statusDrop)).click();
	    String statusOptionXpath = String.format("//div[@role='listbox']//span[text()='%s']", statusValue);
	    WebElement statusOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(statusOptionXpath)));
	    statusOption.click();
	}
	public void fillEmpname(String empname) {
		empName.sendKeys(empname);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span"))).click();
	    
	}
	public void fillUsername(String username) {
		userName.sendKeys(username);
	}
	public void fillPassword(String password) {
		passwordInput.sendKeys(password);
		
	}
	
	public void fillConfirmPassword(String password) {
		
		confirmPassword.sendKeys(password);
	}
	
	public void addUser(String role) {
		
		selectUserRole(role);
	}
	public void save() {
		saveButton.click();
	}
	
	
}
