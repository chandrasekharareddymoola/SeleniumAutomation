package com.eagle.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.HomePage;

public class LogoutTest extends BaseTest{

	HomePage objHome;
	
	@BeforeClass
	public void beforeClass()  {	
		objHome = new HomePage();	
	}
	
	@Test(priority = 0, description = "Logout functionality verification")
	public void VerifyLogout_Test() throws Throwable{
      try{
    	  	objHome.logout();
		    onSuccessMeassage("Logout is successfully verified");
    	}
      	catch(Exception ex){
      		objHome.captureScreenshot("logoutFail");
			onFailreMeassage(ex.getMessage(),"logoutFail");					
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
	
	@AfterClass
	public void afterClass()  {	
		closeBroswer();
	}
}
