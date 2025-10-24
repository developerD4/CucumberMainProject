package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {
	static WebDriver driver;
	public String baseURL = ReadConfig.readPropertyFileData("baseUrl", "config");

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		System.out.println("Opening");
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	public static WebDriver getDriver() {
		return driver;
	}
}
