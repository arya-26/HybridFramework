package com.sper.listners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.sper.dataprovider.ConfigReader;
import com.sper.factory.BrowserFactory;
import com.sper.helper.Utility;

public class ReportListener implements ITestListener {
	
		ExtentReports extent=ExtendManager.getInstance();
		
		ExtentTest extentTest;
		
		ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
		
		public void onTestStart(ITestResult result) 
		{
			System.out.println("Starting Test");
			
			extentTest=extent.createTest(result.getMethod().getMethodName());
			
			test.set(extentTest);
		}

		public void onTestSuccess(ITestResult result) 
		
		{
			if(ConfigReader.getProperty("screenshotOnSuccess").equalsIgnoreCase("true"))
			{
				
					test.get().pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreenshotAsBase64(BrowserFactory.getDriver())).build() );
				
		}
			else
			{
				test.get().pass("Test Passed");
			}
		}

		public void onTestFailure(ITestResult result) 
					
		{
					/*WebDriver driver=BrowserFactory.getDriver();
					String screenshot=Utility.captureScreenshotAsBase64(driver);
					test.get().fail("Test Failed "+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
				*/
			if(ConfigReader.getProperty("screenshotOnFailure").equalsIgnoreCase("true"))
			{
				test.get().fail("Test Failed "+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreenshotAsBase64(BrowserFactory.getDriver())).build());
			}
				
			else
			{
				test.get().fail("Test Failed "+result.getThrowable().getMessage());
		}
}

		public void onTestSkipped(ITestResult result) {
			
			if(ConfigReader.getProperty("screenshotOnSkip").equalsIgnoreCase("pass")) {
			
				
					test.get().skip("Test Skipped ", MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreenshotAsBase64(BrowserFactory.getDriver())).build());
				
			}
			else {
				test.get().skip("Test Skipped ");
			}
		}
			

		public void onFinish(ITestContext context) 
		{
			extent.flush();
		}

}
