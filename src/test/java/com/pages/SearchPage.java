package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//label[text()='Username']/../following-sibling::div//input")

	private WebElement userName;
	
	
	

	
	public void userfill(String ename) {
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(ename);

	}
// WebElement dropdown = driver.findElement(By.xpath("//div[.//label[text()='User Role']]//div[@class='oxd-select-text']"));
	


	// Select by visible text
	
	@FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
	private WebElement userRoleDropdown;

	public void selectUserRole(String role) {
	    wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();
	    String optionXpath = String.format("//div[@role='listbox']//span[text()='%s']", role);
	    WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
	    option.click();
	}

	
//	public void dropdownSelect() {
//		   wait.until(ExpectedConditions.visibilityOf(dropdown));
//			
//	        dropdown.selectByVisibleText("ESS");
//		    wait.until(ExpectedConditions.visibilityOf(dropselect)).click();
//	}
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement empName;
	
	public void employeeName(String ename) {
		empName.sendKeys(ename);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span"))).click();
		
	}
	
	@FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
	private WebElement statusDropdown;
	
	public void selectStatus(String statusValue) {
	    wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
	    String statusOptionXpath = String.format("//div[@role='listbox']//span[text()='%s']", statusValue);
	    WebElement statusOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(statusOptionXpath)));
	    statusOption.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement searchButton;

	public void clickSearch() {
	    searchButton.click();
	}

	
	public void searchEmp(String username, String ename, String statusValue, String role) {
		userfill(username);
		selectUserRole(role);
		employeeName(ename);
		selectStatus(statusValue);
		clickSearch();
	}
	public void waitForSearchPageToLoad() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//h5[normalize-space()='System Users']")
	    ));
	}
	
	
}
