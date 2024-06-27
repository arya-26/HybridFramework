package com.sper.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sper.base.BaseClass1;
import com.sper.dataprovider.CustomDataProvider;
import com.sper.pages.LoginPage1;
import com.sper.pages.SignupPage1;

public class Registration extends BaseClass1{
	
	@Test(dataProvider = "NewUserInfo", dataProviderClass = CustomDataProvider.class)
	public void signupPage(String uname, String emailadd, String pass, String interests, String gend, String stateValue, String hobbiesValue) {
		LoginPage1 login= new LoginPage1(driver);
		login.clickOnSignup();
		SignupPage1 signup= new SignupPage1(driver);
		signup.createNewUser(uname, emailadd,  pass,  interests,  gend,  stateValue, hobbiesValue);
		Assert.assertTrue(signup.verifyUserCreation(), "Verification failed");
			
		

	

}
}
