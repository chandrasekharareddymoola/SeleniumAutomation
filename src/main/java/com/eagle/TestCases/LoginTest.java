package com.eagle.TestCases;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.eagle.pages.LoginPage;
import com.eagle.Reports.ExtentTestManager;


public class LoginTest extends BaseTest{  
	   	 
		LoginPage objLogin;
	
		@BeforeClass
		public void beforeClass()  {	
			objLogin = new LoginPage();	
		}

		@Test(priority = 0, description = "Login with valid credentials")
		public void VerifyLoginPage_Test() throws Throwable{
	      try{
			    objLogin.loginTo(); 	
			    onSuccessMeassage("Login is successfully verified");
	    	}
	      	catch(Exception ex){
	      		objLogin.captureScreenshot("loginFail");
				onFailreMeassage(ex.getMessage(),"loginFail");								
			}
	    }
		
		public void onSuccessMeassage(String successMessage)
		{
			ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
			ExtentTestManager.getTest().log(Status.PASS, successMessage);
		}
		
		public void onFailreMeassage(String failureMessage,String screenShotName) throws IOException
		{
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
			ExtentTestManager.getTest().log(Status.FAIL, failureMessage);
			ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir") + "./Resources/ErrorScreenshots/"+screenShotName+".png");
		}
		
}


