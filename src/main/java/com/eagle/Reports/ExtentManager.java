package com.eagle.Reports;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.eagle.ConfigUtils.ReadObject;

public class ExtentManager {

	private static String EnvName = null;
	
	static Date dt = new Date();
	static DateFormat dtFrmt = new SimpleDateFormat("dd-MMM-YY_HHmmss");
	static String dtText = dtFrmt.format(dt);

	private static ExtentReports extent;
	private static String reportFileName = "Test-Automaton-Report"+"("+EnvName+")"+dtText+".html";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilepath = "./Resources" +fileSeperator+ "TestReport";
	private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;

	@BeforeClass
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}
	
	@BeforeClass
	public void EnvName() throws IOException {
	ReadObject object = new ReadObject();
	Properties configObject = object.getObjectRepositoty();	     
	EnvName = configObject.getProperty("EnvironmentName");
	System.out.println(EnvName);
	}
	
	//Create an extent report instance
	public static ExtentReports createInstance() {
		String fileName = getReportPath(reportFilepath);

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);        
		htmlReporter.config().setChartVisibilityOnOpen(true);        
		htmlReporter.config().setTheme(Theme.DARK);     
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportFileName);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//Set environment details
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("AUT", "QA");

		return extent;
	}    


	//Create the report path
	private static String getReportPath (String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) 
			{
				System.out.println("Directory: " + path + " is created!" );
				return reportFileLocation;
			} 
			else 
			{
				System.out.println("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		} 
		else 
		{
			System.out.println("Directory already exists: " + path);
		}
		return reportFileLocation;
	}
}
