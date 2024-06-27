package com.sper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sper.helper.Utility;

public class Log1 {
	
	WebDriver driver;
	public Log1(WebDriver driver) {
	
		this.driver=driver;
	}
		
		By userName= By.xpath("//input[@placeholder='Enter Email']");
		By password= By.name("password1");
		By login= By.className("submit-btn");
		
	public void loginAsAdmin(String uName, String pass) {
		Utility.getElement(driver, userName).sendKeys(uName);
		Utility.getElement(driver, password).sendKeys(pass);
		Utility.getElement(driver, login).click();
	}

}
