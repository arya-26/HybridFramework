package com.sper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sper.helper.Utility;



public class CoursePage {
	WebDriver driver;
	public CoursePage(WebDriver driver) {
		this.driver=driver;
	}
	
		
		By addCourseBtn= By.xpath("//button[normalize-space()='Add New Course']");
		By chooseFileBtn= By.xpath("//input[@id='thumbnail']");
		By courseName= By.xpath("//input[@id='name']");
		By description= By.xpath("//textarea[@id='description']");
		By instructor= By.xpath("//input[@id='instructorNameId']");
		By price= By.xpath("//input[@id='price']");
		By category= By.xpath("//div[normalize-space()='Select Category']");
		By submit= By.xpath("//button[normalize-space()='Save']");
		By coursePresence= By.xpath("//td[normalize-space()='test']");
		
	
	
	public void addNewCourse(String filePath, String course, String desc, String instructorName, String priceValue, String courseCatg) {
		Utility.getElement(driver, addCourseBtn).click();
		Utility.getElement(driver, chooseFileBtn).sendKeys(filePath);
		Utility.getElement(driver, courseName).sendKeys(course);
		Utility.getElement(driver, description).sendKeys(desc);
		Utility.getElement(driver, instructor).sendKeys(instructorName);
		Utility.getElement(driver, price).sendKeys(priceValue);
		//By courseCategory= By.xpath("//button[normalize-space()='"+courseCatg+"']");
		Utility.getElement(driver, By.xpath("//button[normalize-space()='"+courseCatg+"']")).click();
		Utility.getElement(driver, submit).click();
	}
	
	public boolean checkCoursePresence() {
		boolean status= Utility.getElement(driver, coursePresence).isDisplayed();
		return status;
	}

}
