package com.sper.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sper.base.BaseClass1;
import com.sper.dataprovider.CustomDataProvider;
import com.sper.pages.CourPage;
import com.sper.pages.Hom1;
import com.sper.pages.Log1;

public class CreCour extends BaseClass1 {
	@Test(dataProvider = "LoginCredentials", dataProviderClass =CustomDataProvider.class, priority = 1 )
	public void loginToapp(String uName, String pass) {
		Log1 login=new Log1(driver);
		login.loginAsAdmin(uName, pass);
		Hom1 hm= new Hom1(driver);
		hm.clickOnManageCourses();
	}
	
	@Test(dataProvider = "createCourse", dataProviderClass = CustomDataProvider.class, priority = 2)
		public void createCourse(String filepath, String courseNames, String desc, String courseCatg) {
		CourPage course= new CourPage(driver);
		course.addNewCourse(System.getProperty("user.dir")+filepath, courseNames, desc, courseCatg);
		Assert.assertTrue(course.verifyCoursePresence(), "Course not created");
	}

}
