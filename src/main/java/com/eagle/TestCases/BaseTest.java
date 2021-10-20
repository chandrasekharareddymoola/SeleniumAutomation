package com.eagle.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.eagle.ConfigUtils.ReadObject;
import com.eagle.pages.LoginPage;
import com.eagle.pages.Page;

public class BaseTest {

	private static WebDriver webdriver;
	protected static Page basePage;
 
	@BeforeClass
	public static void launchApplication() throws IOException, InterruptedException, AWTException{
		setChromeDriverProperty();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("diable-extensions");
        option.setExperimentalOption("useAutomationExtension",false);
        option.addArguments("--start-maximized");   
        webdriver = new ChromeDriver();
		
	  // WebDriver webdriver=new ChromeDriver();
        
		 ReadObject object = new ReadObject();
	     Properties configObject = object.getObjectRepositoty();	     
	     String url = configObject.getProperty("EnvironmentURL");	
	     String email = configObject.getProperty("Username");	
	     String emailPass = configObject.getProperty("Password");	
	        
		webdriver.get(url);	
		basePage = new Page();
		basePage.setWebDriver(webdriver);	
		basePage.setUserName(email);
		basePage.setPassword(emailPass);
	}
 
		
	private static void setChromeDriverProperty(){
		System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
	}
}
