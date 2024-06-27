package com.sper.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sper.dataprovider.ConfigReader1;

public class BrowserFactory1 {
	
	public static void closeAllSession(WebDriver driver) {
		driver.quit();
	}
	
	public static void closesession(WebDriver driver) {
		driver.close();
	}
	
	public static WebDriver StartBrowser(String appUrl) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(appUrl);
		return driver;
		}
		
		public static WebDriver StartBrowser(String browser,String appUrl) {
			WebDriver driver=null;
			
			
			if(browser.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions opt= new ChromeOptions();
				if(ConfigReader1.property("headless").equalsIgnoreCase("true")) {
					opt.addArguments("--headless=new");
				}
				driver= new ChromeDriver(opt);
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				 driver= new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Edge"))
			{
				 driver= new EdgeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader1.property("pageLoadTimeout"))));
			
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader1.property("scriptTimeout"))));
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader1.property("implicitlyWait"))));

			driver.get(appUrl);
			return driver;

}
}
