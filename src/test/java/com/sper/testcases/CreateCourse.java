package com.sper.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sper.base.BaseClass1;
import com.sper.dataprovider.CustomDataProvider;
import com.sper.pages.CoursePage;
import com.sper.pages.HomePage;
import com.sper.pages.LoginPage1;

public class CreateCourse extends BaseClass1 {
	@Test(priority = 1, dataProvider = "LoginCredentials", dataProviderClass =CustomDataProvider.class  )
	public void loginasAdmin(String user, String pass) {
		
		LoginPage1 login= new LoginPage1(driver);
		login.loginToApplicationAsAdminUser(user, pass);
	}
	@Test(priority = 2)
	public void	clickonManageCouse() {
		HomePage home= new HomePage(driver);
		home.clickOnManageCourses();
		
	}
	
	@Test(priority=3, dataProvider = "createCourse", dataProviderClass =CustomDataProvider.class )
	public void createCourse(String filePath, String courseName, String desc, String instructor, String price, String courseCatg ) {
		CoursePage course= new CoursePage(driver);
		course.addNewCourse(System.getProperty("user.dir")+filePath, courseName, desc, instructor, price, courseCatg);
		Assert.assertTrue(course.checkCoursePresence(), "course not added");
	}
	
	

}
