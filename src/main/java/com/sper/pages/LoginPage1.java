package com.sper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sper.helper.Utility;

public class LoginPage1 {
	
	WebDriver driver;

	public LoginPage1(WebDriver driver) 
	{
		this.driver = driver;
	}

	private By username=By.xpath("//input[@placeholder='Enter Email']");
	
	private By password=By.name("password1");

	private By loginButton=By.className("submit-btn");
	
	private By signupButton= By.xpath("//a[normalize-space()='New user? Signup']");
	
	public void clickOnSignup() {
		Utility.getElement(driver, signupButton).click();
	}
		

	public void loginToApplicationAsAdminUser(String user,String pass)
	{
		Utility.getElement(driver, username).sendKeys(user);
		Utility.getElement(driver, password).sendKeys(pass);
		Utility.getElement(driver, loginButton).click();
		
		
	}

}
