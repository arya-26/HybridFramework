package com.sper.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sper.dataprovider.ConfigReader1;
import com.sper.factory.BrowserFactory1;

public class BaseClass1 {
	public WebDriver driver;
	@BeforeClass
	
	public void setup() {
		System.out.println("Setting up browser");
		
		driver=BrowserFactory1.StartBrowser(ConfigReader1.property("browser"), ConfigReader1.property("appURL"));
		System.out.println("Browser is up and running");
	}

@AfterClass
	public void teardown() {
	System.out.println("Closing browser");
		BrowserFactory1.closeAllSession(driver);
	}
	

}
