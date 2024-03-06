package com.sper.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sper.base.BaseClass;
import com.sper.dataprovider.CustomDataProvider;
import com.sper.pages.LoginPage;
import com.sper.pages.SignupPage;

public class RegisterNewUser extends BaseClass {
	
	@Test(dataProvider = "NewUserInfo", dataProviderClass = CustomDataProvider.class )
	
	public void CreateNewUser(String uName, String email, String password, String interest, String gender, String state, String hobbies) {

	LoginPage login= new LoginPage(driver);
	login.clickOnNewUserLink();
	
	SignupPage signup= new SignupPage(driver);
	signup.createNewUser(uName,email,password,interest,gender, state,hobbies);
	Assert.assertTrue(signup.verifySignUp(),"User creation failed");
	
	}
}
