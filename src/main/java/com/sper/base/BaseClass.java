package com.sper.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sper.dataprovider.ConfigReader;
import com.sper.factory.BrowserFactory;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeClass
	
	public void setup() {
System.out.println("******** LOG:INFO- Running Setup ********");
		
		System.out.println("******** LOG:INFO- Application will be running on "+ ConfigReader.getProperty("browser")+" ********");
		
		driver=BrowserFactory.StartBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("appURL"));
		
	}
	@AfterClass
	public void teardown() {
		System.out.println("******** LOG:INFO- Running TearDown ********");
		BrowserFactory.closeAllSession(driver);
		
		
	}
}
