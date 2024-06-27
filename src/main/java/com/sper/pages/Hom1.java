package com.sper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sper.helper.Utility;

public class Hom1 {
	
	WebDriver driver;
	public Hom1(WebDriver driver) {
		this.driver=driver;
	}
	
	By welcomeMsg=By.xpath("//h4[@class='welcomeMessage']");
	By manageButton= By.xpath("//span[normalize-space()='Manage']");
	By manageCourses= By.xpath("//a[normalize-space()='Manage Courses']");
	
	public String getWelcomeMsg() {
		String welMsg=Utility.getElement(driver, welcomeMsg).getText();
		return welMsg;
	}
	
	public void clickOnManageCourses() {
		Utility.getElement(driver, manageButton).click();
		Utility.getElement(driver, manageCourses).click();
	}
}
