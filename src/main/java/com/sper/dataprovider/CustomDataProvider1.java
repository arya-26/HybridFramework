package com.sper.dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider1 {
	
	@DataProvider(name = "registration data")
	public static Object[][] getLoginCredentials() {
		System.out.println("******** LOG:INFO- Setting up test data ********");
		
		Object[][] arr=ExcelReader1.getData1FromExcel("LoginCredentials");
		return arr;
		
	}

}
