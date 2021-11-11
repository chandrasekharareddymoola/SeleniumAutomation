package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.eagle.ConfigUtils.ReadObject;
import com.eagle.pages.BasePage;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static WebDriver webdriver;
	protected static BasePage basePage;

	public WebDriver getDriver() {
		return webdriver;
	}

	@BeforeClass
	public static void launchApplication() throws IOException, InterruptedException, AWTException{
		if(webdriver==null) {		
			setChromeDriverProperty(); 
			webdriver=new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(webdriver,60);
			webdriver.manage().window().maximize();

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
		}
	}

	private static void setChromeDriverProperty(){
		System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe"); }

}
