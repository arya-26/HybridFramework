package com.sper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.sper.helper.Utility;

public class SignupPage1 {
	WebDriver driver;
	
	public SignupPage1(WebDriver driver) {
		this.driver= driver;
		
	}
	
	By name= By.xpath("//input[@id='name']");
	By email= By.xpath("//input[@id='email']");
	By password= By.xpath("//input[@id='password']");
	By state= By.xpath("//select[@id='state']");
	By hobby= By.xpath("//select[@id='hobbies']");
	By signup= By.xpath("//button[normalize-space()='Sign up']");
	By successMsg= By.xpath("//div[text()='Signup successfully, Please login!']");
	
	
	public void createNewUser(String uname, String emailadd, String pass, String interests, String gend, String stateValue, String hobbiesValue) {
		Utility.getElement(driver, name).sendKeys(uname);
		Utility.getElement(driver, email).sendKeys(emailadd);
		Utility.getElement(driver, password).sendKeys(pass);
		Utility.getElement(driver, By.xpath("//label[text()='"+interests+"']//preceding::input[1]")).click();
		Utility.getElement(driver, By.xpath("//label[text()='"+gend+"']//preceding::input[1]")).click();
		Select states= new Select(Utility.getElement(driver, state));
		states.selectByVisibleText(stateValue);
		Select hobbies=new Select(Utility.getElement(driver, hobby));
		hobbies.selectByVisibleText(hobbiesValue);
		Utility.getElement(driver, signup).click();
		
		}
	
	public boolean verifyUserCreation() {
		boolean msg=Utility.getElement(driver, successMsg).isDisplayed();
		return msg;
	}

}
