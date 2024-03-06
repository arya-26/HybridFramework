package com.sper.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sper.base.BaseClass;
import com.sper.dataprovider.CustomDataProvider;
import com.sper.pages.HomePage;
import com.sper.pages.LoginPage;

public class LogintoApp extends BaseClass{
	@Test(priority = 1, dataProvider = "LoginCredentials", dataProviderClass = CustomDataProvider.class)
	
	public void loginapp(String username, String password)
	{
		
		
		LoginPage login= new LoginPage(driver);
		HomePage home= login.loginToApplicationAsAdminUser(username, password);
		Assert.assertTrue(home.getWelcomeMessage().contains("Welcome"),"Welcome message didnot appear");
		
		
		
		
		
	}

}
