package com.eagle.TestCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.InvestigationPage;
import com.eagle.pages.LoginPage;

public class InvestigationTest extends BaseTest {
	
	InvestigationPage objInvestigationPage;
	
	
	@BeforeClass
	public void beforeMethod() throws InterruptedException, IOException {
		//Login to application
		LoginPage objLogin;
		objLogin = new LoginPage();
		objLogin.loginTo();
		objInvestigationPage = new InvestigationPage();		
	}
	
	@Test(priority = 0, description = "Create Investigation")
	public void CreateInvestigation_Test() throws InterruptedException, IOException {
		
		try {
			/* To initiate the creation of Investigation */		 
			objInvestigationPage.createInvestigation("Investigation 1","Investigation 1");
			onSuccessMeassage("Investigation is successfully created");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("createInvFail");
			onFailreMeassage(ex.getMessage(),"createInvFail");
			
		}
	}
	
	@Test(priority = 1, description = "View Investigation")
	public void ViewInvestigation_Test() throws InterruptedException, IOException  {
		try {
			 /* To view the Investigation */
			 objInvestigationPage.viewInvestigation("Investigation 1");
			 onSuccessMeassage("Investigation is successfully opened");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("viewInvFail");
			onFailreMeassage(ex.getMessage(),"viewInvFail");
		}
	}
		
		 
	@Test(priority = 2, description = "Edit Investigation")
	public void EditInvestigation_Test() throws InterruptedException, IOException  {
		try {
			 /* To edit the Investigation */
			 objInvestigationPage.editInvestigation("Investigation 1","Modified title","modified description");
			 onSuccessMeassage("Investigation is successfully modified");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("editInvFail");
			onFailreMeassage(ex.getMessage(),"editInvFail");
		}
	}
	
	@Test(priority = 3, description = "Link Set With Investigation")
	public void LinkSetWithInvestigation_Test() throws InterruptedException, IOException  {
		try {
			 /* To Link set to an Investigation */
			  objInvestigationPage.linkSettoInvestigation("Modified title" ,"UntitledSet-20 Oct 2021");
			  onSuccessMeassage("Investigation is successfully linked with set");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("linkSetInvFail");
			onFailreMeassage(ex.getMessage(),"linkSetInvFail");
		}
	}
	
	
	@Test(priority = 4, description = "Link Exploration With Investigation")
	public void LinkExplorationWithInvestigation_Test() throws InterruptedException, IOException  {
		try {
			/* To Link exploration to an Investigation */
			   //ERROR //		  
			  //objInvestigationPage.linkExplorationtoInvestigation("Modified title","");
			  //onSuccessMeassage("Investigation is successfully linked with Exploration");
			}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("linkExpInvFail");
			onFailreMeassage(ex.getMessage(),"linkExpInvFail");
		}
	}
	
	@Test(priority = 5, description = "Link Comparison With Investigation")
	public void LinkComparisonWithInvestigation_Test() throws InterruptedException, IOException  {
		try {
		   /* To Link Comparison to an Investigation */
		  //objInvestigationPage.linkComparisontoInvestigation("Modified title","Unique");  
			 //onSuccessMeassage("Investigation is successfully linked with Comparison");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("linkExpInvFail");
			onFailreMeassage(ex.getMessage(),"linkExpInvFail");
		}

	}
	

	@Test(priority = 6, description = "Share Investigation")
	public void ShareInvestigation_Test() throws InterruptedException, IOException  {
		try {
			/* To share the Investigation */
			objInvestigationPage.shareInvestigation("Investigation 11", "divya.devanathan@eaglegenomics.com");
			 onSuccessMeassage("Investigation is successfully shared with user");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("shareInvFail");
			onFailreMeassage(ex.getMessage(),"shareInvFail");			
		}

	}	

	
	@Test(priority = 7, description = "Delete Investigation")
	public void DeleteInvestigation_Test() throws InterruptedException, IOException  {
		try 
	  	{
			/* To delete the Investigation */
			//objInvestigationPage.deleteInvestigation("Investigation By DevTeam");	
			objInvestigationPage.deleteInvestigation("uu");	
			onSuccessMeassage("Investigation is successfully deleted from the list");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("deleteInvFail");
			onFailreMeassage(ex.getMessage(),"deleteInvFail");			
		}
	}  
	
	
	public void onSuccessMeassage(String successMessage)
	{
		ExtentTestManager.getTest().log(Status.PASS, successMessage);
	}
	
	public void onFailreMeassage(String failureMessage,String screenShotName) throws IOException
	{
		ExtentTestManager.getTest().log(Status.FAIL, failureMessage);
		ExtentTestManager.getTest().addScreenCaptureFromPath("./Resources/ErrorScreenshots/" + screenShotName + ".png");		
	}
	
	
		 
}

