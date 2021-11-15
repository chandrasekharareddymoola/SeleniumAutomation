package com.eagle.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.HomePage;

public class HomeTest extends BaseTest{
	
	HomePage objHome;
	
	@BeforeClass
	public void beforeClass()  {	
		objHome = new HomePage();	
	}
	
	@Test(priority = 0, description = "Check the visibility of Logo")
	public void VerifyLogoVisibility_Test() throws InterruptedException, IOException{
      try{
    	  	objHome.verifyLogoVisibility();	
		    onSuccessMeassage("Home logo is successfully verified");
    	}
      	catch(Exception ex){
      		objHome.captureScreenshot("homeLogoFail");
			onFailreMeassage(ex.getMessage(),"homeLogoFail");					
		}
    }
	
	@Test(priority = 1, description = "Check if dashBoard displays all the components")
	public void VerifyDashboard_Test() throws InterruptedException, IOException{
      try{
    	  	objHome.verifyDashboardComponents();
		    onSuccessMeassage("DashBoard displays all the components");
    	}
      	catch(Exception ex){
      		objHome.captureScreenshot("dashboardFail");
			onFailreMeassage(ex.getMessage(),"dashboardFail");					
		}
    }
	
	@Test(priority = 2, description = "Check for user information in profile")
	public void VerifyUserProfile() throws InterruptedException, IOException{
      try{
    	  	objHome.verifyUserProfiles();
		    onSuccessMeassage("User profile is successfully verified");
    	}
      	catch(Exception ex){
      		objHome.captureScreenshot("profileFail");
			onFailreMeassage(ex.getMessage(),"profileFail");					
		}
    }
	
	@Test(priority = 3, description = "Check for copyright and other links")
	public void VerifyCopyRights() throws InterruptedException, IOException{
      try{
    	  	objHome.verifyCopyRights();
		    onSuccessMeassage("CopyRight details are present");
    	}
      	catch(Exception ex){
      		objHome.captureScreenshot("CopyRightsFail");
			onFailreMeassage(ex.getMessage(),"CopyRightsFail");					
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
		ExtentTestManager.getTest().addScreenCaptureFromPath(screenShotName);		
	}

}
