package com.pages;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;

	
	@FindBy(name = "username")
	private WebElement usernameId;
	
	@FindBy(name="password")
	private WebElement passwordId;
	
	@FindBy(tagName="button")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void setName(String user) {
		usernameId.sendKeys(user);
	}
	public void setPassword(String passw) {
		passwordId.sendKeys(passw);
	}
	public void loginButton() {
		loginBtn.click();
	}

	public void loginCre(String username, String password) {
		setName(username);
		setPassword(password);
		loginButton();

	}
}








//WebElement usernameId = driver.findElement(By.name("username"));
//usernameId.sendKeys(username);
//WebElement passwordId = driver.findElement(By.name("password"));
//passwordId.sendKeys(password);
//driver.findElement(By.tagName("button")).click();
