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

import io.github.bonigarcia.wdm.WebDriverManager;

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

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); 
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
			}
	}

	public void closeBroswer()
	{
		webdriver.quit();
	}
		
}

