package com.eagle.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.eagle.Base.ExtentTestManager;
import com.eagle.pages.HomePage;
import com.eagle.pages.LoginPage;

public class LoginTest extends BaseTest{	    
	   	   
		LoginPage objLogin;
	    HomePage objHomePage; 

    
	    @Test
	    public void VerifyLoginPage() throws InterruptedException{
	      try 
	      	{
	    	    ExtentTestManager.getTest().log(Status.INFO, "Login check started");
		    	objLogin = new LoginPage();
			    objLogin.loginTo(); 	
	    	}
	    	catch(Exception ex)
	    	{
	    		
	    	}
	    }

}
