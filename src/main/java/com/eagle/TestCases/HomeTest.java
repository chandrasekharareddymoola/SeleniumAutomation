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
			onFailreMeassage(ex.getMessage(),"homeLogoFail");					
		}
	}

	@Test(priority = 1, description = "Check if dashBoard displays all the components")
	public void VerifyDashboard_Test() throws InterruptedException, IOException{
		try{
			objHome.verifyDashboardComponents();
			onSuccessMeassage("DashBoard displays all the components");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("dashboardFail");
			onFailreMeassage(ex.getMessage(),"dashboardFail");					
		}
	}

	@Test(priority = 2, description = "Check for user information in profile")
	public void VerifyUserProfile() throws InterruptedException, IOException{
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
			onFailreMeassage(ex.getMessage(),"profileFail");					
		}
	}

	@Test(priority = 3, description = "Check for copyright and other links")
	public void VerifyCopyRights() throws InterruptedException, IOException{
		try{
			objHome.verifyCopyRights();
			onSuccessMeassage("CopyRight details are present");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("CopyRightsFail");
			onFailreMeassage(ex.getMessage(),"CopyRightsFail");					
		}
	}

	@Test(priority = 4, description = "Search and Save the Global search")
	public void CreateGlobalSearch_Test() throws InterruptedException, IOException{
		try{
			objHome.createGlobalSearch();
			onSuccessMeassage("Search is successfully created and saved");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("SavesearchFail");
			onFailreMeassage(ex.getMessage(),"SavesearchFail");					
		}
	}

	@Test(priority = 5, description = "Verify Saved Searches")
	public void VerifySavedSearches_Test() throws InterruptedException, IOException{
		try{
			objHome.verifySavedSearches();
			onSuccessMeassage("Search is successfully created and saved");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("SavesearchFail");
			onFailreMeassage(ex.getMessage(),"SavesearchFail");					
		}
	}
	
	@Test(priority = 6, description = "Verify Contact help Desk")
	public void VerifyContactHelpDesk_Test() throws InterruptedException, IOException{
		try{
			objHome.VerifyContactHelpDesk();
			onSuccessMeassage("Contact Help Desk is verified");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("ContactHelpDeskFail");
			onFailreMeassage(ex.getMessage(),"ContactHelpDeskFail");					
		}
	}
	
	@Test(priority = 7, description = "Verify User Manual")
	public void VerifyUserManual_Test() throws InterruptedException, IOException{
		try{
			objHome.VerifyUserManual();
			onSuccessMeassage("Contact Help Desk is verifiedd");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("ContactHelpDeskFail");
			onFailreMeassage(ex.getMessage(),"ContactHelpDeskFail");					
		}
	}
	
	@Test(priority = 8, description = "Verify FAQ")
	public void VerifyFAQ_Test() throws InterruptedException, IOException{
		try{
			objHome.VerifyFAQ();
			onSuccessMeassage("Contact Help Desk is verified");
		}
		catch(Exception | AssertionError ex){
			objHome.captureScreenshot("FAQFail");
			onFailreMeassage(ex.getMessage(),"FAQFail");					
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
