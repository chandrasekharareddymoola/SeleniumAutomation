package com.eagle.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.eagle.pages.HomePage;
import com.eagle.pages.LoginPage;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.BasePage;

public class LoginTest extends BaseTest{    

	   	   
		LoginPage objLogin;
	    HomePage objHomePage; 
		
		@Test
		 public void VerifyLoginPage() throws InterruptedException{
		      try 
		      	{		    	   
			    	objLogin = new LoginPage();
				    objLogin.loginTo(); 				   
		    	}
		    	catch(Exception ex)
		    	{
		    		
		    		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		    		//String screenShotPath = GetScreenShot.capture(driver, "screenShotName");		
		    		
		    		try {
		    			ExtentTestManager.getTest().addScreenCaptureFromPath("screenShotName.png");			
		    		} catch (IOException e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}	
		    	}
		    }
}

