package com.qa.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	
	public static ExtentReports generateExtentReport()
	{
		String filePath=System.getProperty("user.dir")+"\\Reports\\index.html";
		reporter=new ExtentSparkReporter(filePath);
		reporter.config().setReportName("Zero Banking Automation Test Report");
		reporter.config().setDocumentTitle("Web Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Swetha");
		
		return extent;
		
	}
	

}
