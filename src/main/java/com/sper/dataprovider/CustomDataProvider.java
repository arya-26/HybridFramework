package com.sper.dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	@DataProvider(name = "LoginCredentials")
	
	public static Object[][] getLoginCredentials(){
		System.out.println("******** LOG:INFO- Setting up test data ********");
		Object[][] arr=ExcelReader.getDataFromExcel("LoginCredentials");
		System.out.println("******** LOG:INFO- Test data setup completed ********");
		return arr;	
		
	}
	@DataProvider(name = "NewUserInfo")
	
	public static Object[][] getnewUsersInfo(){
		System.out.println("******** LOG:INFO- Setting up test data ********");
		Object[][] arr=ExcelReader.getDataFromExcel("NewUsers");
		System.out.println("******** LOG:INFO- Test data setup completed ********");
		return arr;

}
	
@DataProvider(name = "createCourse")
	
	public static Object[][] createNewCourse(){
		System.out.println("******** LOG:INFO- Setting up test data ********");
		Object[][] arr=ExcelReader.getDataFromExcel("CreateCourse");
		System.out.println("******** LOG:INFO- Test data setup completed ********");
		return arr;

}
}
