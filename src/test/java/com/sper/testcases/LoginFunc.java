package com.sper.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sper.base.BaseClass1;
import com.sper.dataprovider.CustomDataProvider;
import com.sper.pages.Hom1;
import com.sper.pages.Log1;

public class LoginFunc extends BaseClass1{
	
	@Test(dataProvider = "LoginCredentials", dataProviderClass = CustomDataProvider.class)
	public void logintoApp(String uName, String pass) {
		
		Log1 login= new Log1(driver);
		login.loginAsAdmin(uName, pass);
		Hom1 hm= new Hom1(driver);
		Assert.assertTrue(hm.getWelcomeMsg().contains("Welcome"), "Welcome msg not displayed");
	}

}
