package com.sper.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sper.helper.Utility;

public class ExtendManager {
	
 static ExtentReports extent;
    
    public static ExtentReports getInstance() {
    	if (extent == null)
    	{
    		extent= createInstance();
    	
        return extent;
    }
    	else {
    		return extent;
    	}
    }
    
    public static ExtentReports createInstance() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./Reports/Automation_"+Utility.captureCurrentDateAndTime()+".html");
        
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Sprint1 Report");
        
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        return extent;
    }

}
