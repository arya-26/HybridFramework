package com.sper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sper.helper.Utility;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	private By username=By.xpath("//input[@placeholder='Enter Email']");
	
	private By password=By.name("password1");

	private By loginButton=By.className("submit-btn");
	private By SignupLink= By.xpath("//a[normalize-space()='New user? Signup']");
	
	public void clickOnNewUserLink(){
		Utility.getElement(driver, SignupLink).click();
		
	}
		

	public HomePage loginToApplicationAsAdminUser(String user,String pass)
	{
		Utility.getElement(driver, username).sendKeys(user);
		Utility.getElement(driver, password).sendKeys(pass);
		Utility.getElement(driver, loginButton).click();
		HomePage home= new HomePage(driver);
		
		return home;
		
	}

}
