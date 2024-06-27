package com.sper.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sper.base.BaseClass1;
import com.sper.dataprovider.CustomDataProvider1;
import com.sper.pages.HomePage;
import com.sper.pages.LoginPage;

public class LogintoApp1 extends BaseClass1 {
	
	@Test(priority=1, dataProvider = "registration data", dataProviderClass = CustomDataProvider1.class)
	
	public void loginapp(String username, String password)
	{
		LoginPage login= new LoginPage(driver);
		HomePage home= login.loginToApplicationAsAdminUser(username, password);
		Assert.assertTrue(home.getWelcomeMessage().contains("Welcome"),"Welcome message didnot appear");
		

}
}
