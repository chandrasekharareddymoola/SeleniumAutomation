package com.eagle.TestCases;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.HomePage;

public class HomeTest extends BaseTest{

	HomePage objHome;

	Date dt = new Date();
	DateFormat dtFrmt = new SimpleDateFormat("_HHmmss");
	String dtText = dtFrmt.format(dt);

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
			catch(Exception | AssertionError ex){
				objHome.captureScreenshot("homeLogoFail");
				onFailureMeassage(ex.getMessage(),"homeLogoFail","homeLogoFail");					
			}
		}
	
		@Test(priority = 1, description = "Check if dashBoard displays all the components")
		public void VerifyDashboard_Test() throws Throwable{
			try{
				objHome.verifyDashboardComponents();
				onSuccessMeassage("DashBoard displays all the components");
			}
			catch(Exception | AssertionError ex){
				objHome.captureScreenshot("dashboardFail");
				onFailureMeassage(ex.getMessage(),"dashboardFail","dashboardFail");					
			}
		}
	
		@Test(priority = 2, description = "Check for user information in profile")
		public void VerifyUserProfile() throws Throwable{
			try{
				String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	
				System.out.println(functionName);
				String value = this.getConfiguration().get(functionName);
				String[] HomParameters =value.split(",");
				String ProfileName = HomParameters[0].trim();
	
				objHome.verifyUserProfiles(ProfileName);
				onSuccessMeassage("User profile is successfully verified");
			}
			catch(Exception | AssertionError ex){
				objHome.captureScreenshot("profileFail");
				onFailureMeassage(ex.getMessage(),"profileFail","profileFail");					
			}
		}
	
		@Test(priority = 3, description = "Check for copyright and other links")
		public void VerifyCopyRights() throws Throwable{
			try{
				objHome.verifyCopyRights();
				onSuccessMeassage("CopyRight details are present");
			}
			catch(Exception | AssertionError ex){
				objHome.captureScreenshot("CopyRightsFail");
				onFailureMeassage(ex.getMessage(),"CopyRightsFail","CopyRightsFail");					
			}
		}
	
		@Test(priority = 4, description = "Search and Save the Global search")
		public void CreateGlobalSearch_Test() throws Throwable{
			try{
				objHome.createGlobalSearch();
				onSuccessMeassage("Search is successfully created and saved");
			}
			catch(Exception | AssertionError ex){
				objHome.captureScreenshot("SavesearchFail");
				onFailureMeassage(ex.getMessage(),"SavesearchFail","SavesearchFail");					
			}
		}
	
		@Test(priority = 5, description = "Verify Saved Searches")
		public void VerifySavedSearches_Test() throws Throwable{
			try{
				objHome.verifySavedSearches();
				onSuccessMeassage("Search is successfully created and saved");
			}
			catch(Exception | AssertionError ex){
				objHome.captureScreenshot("SavesearchFail");
				onFailureMeassage(ex.getMessage(),"SavesearchFail","SavesearchFail");					
			}
		}

	@Test(priority = 6, description = "Verify Contact help Desk")
	public void VerifyContactHelpDesk_Test() throws Throwable{
		try{
			objHome.VerifyContactHelpDesk();
			onSuccessMeassage("Contact Help Desk is verified");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("ContactHelpDeskFail");
			onFailureMeassage(ex.getMessage(),"ContactHelpDeskFail","ContactHelpDeskFail");					
		}
	}

	@Test(priority = 7, description = "Verify User Manual")
	public void VerifyUserManual_Test() throws Throwable{
		try{
			objHome.VerifyUserManual();
			onSuccessMeassage("User manual is verifiedd");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("UserManualFail");
			onFailureMeassage(ex.getMessage(),"UserManualFail","UserManualFail");					
		}
	}

	@Test(priority = 8, description = "Verify FAQ")
	public void VerifyFAQ_Test() throws Throwable{
		try{
			objHome.VerifyFAQ();
			onSuccessMeassage("FAQ is verified");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("FAQFail");
			onFailureMeassage(ex.getMessage(),"FAQFail","FAQFail");					
		}
	}

	public void onSuccessMeassage(String successMessage)
	{
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		ExtentTestManager.getTest().log(Status.PASS, successMessage);
	}

	
	public void onFailureMeassage(String ReasonForFail, String failureMessage,String screenShotName) throws IOException, InterruptedException
	{
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		ExtentTestManager.getTest().log(Status.FAIL, failureMessage+" : "+ReasonForFail);
		//		ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir") + "./Resources/ErrorScreenshots/"+screenShotName+".png");
		ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir")+"/Resources/ErrorScreenshots/"+screenShotName+".png");
	}

}
