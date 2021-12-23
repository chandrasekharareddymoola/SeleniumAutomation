package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eagle.ConfigUtils.ReadExcelFile;
import com.eagle.ConfigUtils.ReadObject;
import com.eagle.pages.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static WebDriver webdriver;
	protected static BasePage basePage;
	private static String dtTime;
	private static LinkedHashMap<String, String> keywordValues = new LinkedHashMap<String, String>();

	public WebDriver getDriver() {
		return webdriver;
	}

	public String getDateTime() {
		return dtTime;
	}

	public LinkedHashMap<String, String> getConfiguration(){return keywordValues;}

	public static void getCurrentDate()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	{
		Date dt = new Date();
		DateFormat dtFrmt = new SimpleDateFormat("ddMMMyyyyHHmmss");
		dtTime = dtFrmt.format(dt);
	}


	@BeforeClass
	public static void launchApplication() throws IOException, InterruptedException, AWTException{
		if(webdriver==null) {		

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized"); 
			options.addArguments("enable-automation"); 
			options.addArguments("--no-sandbox"); 
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation"); 
			options.addArguments("--disable-gpu"); 
			webdriver = new ChromeDriver(options); 

			ReadObject object = new ReadObject();
			Properties configObject = object.getObjectRepositoty();	     
			String url = configObject.getProperty("EnvironmentURL");	
			String email = configObject.getProperty("Username");	
			String emailPass = configObject.getProperty("Password");	

			webdriver.get(url);	
			basePage = new BasePage();
			basePage.setWebDriver(webdriver);	
			basePage.setUserName(email);
			basePage.setPassword(emailPass);
			getCurrentDate();
			LoadConfigurationValues();
		}
	}

	@AfterSuite
	public static void closeApplication() throws IOException, InterruptedException, AWTException{
		webdriver.quit();
	}

	public static void LoadConfigurationValues() throws IOException                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	{
		ReadExcelFile rd = new ReadExcelFile();	
		Sheet guru99Sheet = rd.readExcel(System.getProperty("user.dir") + "//Resources//Configuration.xlsx","Config");
		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();

		for (int i = 1; i < rowCount + 1; i++) {

			Row row = guru99Sheet.getRow(i);              
			if (row.getCell(0) != null && row.getCell(0).toString().length() != 0) {

				String functionName =  row.getCell(1).toString();
				String inputValue =  row.getCell(4)!=null? row.getCell(4).toString():"";
				keywordValues.put(functionName,inputValue);
			}
		}
	}


	public void closeBroswer()
	{
		webdriver.quit();
	}

}

