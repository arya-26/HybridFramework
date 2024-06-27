package com.sper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sper.helper.Utility;

public class CourPage {
	
	WebDriver driver;
	public CourPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By addCourseBtn= By.xpath("//button[normalize-space()='Add New Course']");
	By chooseFileBtn= By.xpath("//input[@id='thumbnail']");
	By courseName= By.xpath("//input[@id='name']");
	By description= By.xpath("//textarea[@id='description']");
	By instructor= By.xpath("//input[@id='instructorNameId']");
	By instrName= By.xpath("//p[normalize-space()='Mukesh Otwani']");
	By category= By.xpath("//div[normalize-space()='Select Category']");
	By submit= By.xpath("//button[normalize-space()='Save']");
	By verifyCourse= By.xpath("//td[normalize-space()='Test course3']");
	
	public void addNewCourse(String filepath, String courseNames, String desc, String courseCatg) {
		Utility.getElement(driver, addCourseBtn).click();
		Utility.getElement(driver, chooseFileBtn).sendKeys(filepath);
		Utility.getElement(driver, courseName).sendKeys(courseNames);
		Utility.getElement(driver, description).sendKeys(desc);
		Utility.getElement(driver, instructor).sendKeys("m");
		Utility.getElement(driver, instrName).click();
		Utility.getElement(driver, category).click();
		Utility.getElement(driver, By.xpath("//button[normalize-space()='"+courseCatg+"']")).click();
		Utility.getElement(driver, submit).click();
	}
	
	public boolean verifyCoursePresence() {
		boolean status=Utility.getElement(driver, verifyCourse).isDisplayed();
		return status;
	}

}
