package com.eagle.TestCases;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.InvestigationPage;

public class InvestigationTest extends BaseTest {
	
	InvestigationPage objInvestigationPage;	

	@BeforeClass
	public void beforeClass()  {	
			objInvestigationPage = new InvestigationPage();		
	}
	
	@Test(priority = 0, description = "Create Investigation")
	public void CreateInvestigation_Test() throws InterruptedException, IOException {
		
		try {
			/* To initiate the creation of Investigation */		
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();				
			
			String value = this.getConfiguration().get(functionName);
			String[] invParameters =value.split(",");
			String invName = invParameters[0].trim() + this.getDateTime();
			String invDescription = invParameters[1].trim();
			
			objInvestigationPage.createInvestigation(invName,invDescription);
			onSuccessMeassage("Investigation is successfully created");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("createInvFail");
			onFailureMeassage(ex.getMessage(),"createInvFail");
			
		}
	}
	
	@Test(priority = 1, description = "View Investigation")
	public void ViewInvestigation_Test() throws InterruptedException, IOException  {
		try {
			 /* To view the Investigation */
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			String value = this.getConfiguration().get(functionName);			
			String invName = value.trim();
				
			 objInvestigationPage.viewInvestigation(invName);
			 onSuccessMeassage("Investigation is successfully opened");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("viewInvFail");
			onFailureMeassage(ex.getMessage(),"viewInvFail");
		}
	}
		 
	@Test(priority = 2, description = "Edit Investigation")
	public void EditInvestigation_Test() throws InterruptedException, IOException  {
		try {
			 /* To edit the Investigation */
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			String value = this.getConfiguration().get(functionName);
			String[] invParameters =value.split(",");
			String olvInvName = invParameters[0].trim();
			String newInvName = invParameters[1].trim() + this.getDateTime();
			String invDescription = invParameters[2].trim();
			
			 objInvestigationPage.editInvestigation(olvInvName,newInvName,invDescription);
			 onSuccessMeassage("Investigation is successfully modified");
		}
		catch(Exception ex)
		{
			String path = objInvestigationPage.captureScreenshot("editInvFail");
			onFailureMeassage(ex.getMessage(),"editInvFail");
		}
	}
	
	@Test(priority = 3, description = "Link Set With Investigation")
	public void LinkSetWithInvestigation_Test() throws InterruptedException, IOException  {
		try {                                              
			 /* To Link set to an Investigation */		
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			String value = this.getConfiguration().get(functionName);
			String[] invParameters =value.split(",");
			String invName = invParameters[0].trim();
			String setTobeLinked = invParameters[1].trim();
			
			  objInvestigationPage.linkSettoInvestigation(invName ,setTobeLinked);
			  onSuccessMeassage("Investigation is successfully linked with set");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("linkSetInvFail");
			onFailureMeassage(ex.getMessage(),"linkSetInvFail");
		}
	}
	
	
	@Test(priority = 0, description = "Link Exploration With Investigation")
	public void LinkExplorationWithInvestigation_Test() throws InterruptedException, IOException  {                                                   
		try {
			/* To Link exploration to an Investigation */
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			String value = this.getConfiguration().get(functionName);
			String[] invParameters =value.split(",");
			String invName = invParameters[0].trim();
			String expTobeLinked = invParameters[1].trim();
			   //ERROR //		  
			  objInvestigationPage.linkExplorationtoInvestigation(invName,expTobeLinked);
			  onSuccessMeassage("Investigation is successfully linked with Exploration");
			}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("linkExpInvFail");
			onFailureMeassage(ex.getMessage(),"linkExpInvFail");
		}
	}
	
	@Test(priority = 5, description = "Link Comparison With Investigation")
	public void LinkComparisonWithInvestigation_Test() throws InterruptedException, IOException  {
		try {
		   /* To Link Comparison to an Investigation */
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			String value = this.getConfiguration().get(functionName);
			String[] invParameters =value.split(",");
			String invName = invParameters[0].trim();
			String compTobeLinked = invParameters[1].trim();
			
		  objInvestigationPage.linkComparisontoInvestigation(invName,compTobeLinked);  
			 onSuccessMeassage("Investigation is successfully linked with Comparison");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("linkCompInvFail");
			onFailureMeassage(ex.getMessage(),"linkCompInvFail");
		}

	}
	

	@Test(priority = 6, description = "Share Investigation")
	public void ShareInvestigation_Test() throws InterruptedException, IOException  {
		try {
			/* To share the Investigation */
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			String value = this.getConfiguration().get(functionName);
			String[] invParameters =value.split(",");
			String invName = invParameters[0].trim();
			String toBeSharedWith = invParameters[1].trim();
			
			objInvestigationPage.shareInvestigation(invName,toBeSharedWith);
			 onSuccessMeassage("Investigation is successfully shared with user");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("shareInvFail");
			onFailureMeassage(ex.getMessage(),"shareInvFail");			
		}

	}	

	
	@Test(priority = 7, description = "Delete Investigation")
	public void DeleteInvestigation_Test() throws InterruptedException, IOException  {
		try 
	  	{
			/* To delete the Investigation */
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			String value = this.getConfiguration().get(functionName);			
			String invName =value.trim();
			
			objInvestigationPage.deleteInvestigation(invName);	
			onSuccessMeassage("Investigation is successfully deleted from the list");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("deleteInvFail");
			onFailureMeassage(ex.getMessage(),"deleteInvFail");			
		}
	}  
	
	
	public void onSuccessMeassage(String successMessage)
	{
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		ExtentTestManager.getTest().log(Status.PASS, successMessage);
	}
	
	public void onFailureMeassage(String failureMessage,String screenShotName) throws IOException
	{
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		ExtentTestManager.getTest().log(Status.FAIL, failureMessage);
		ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir") + "./Resources/ErrorScreenshots/"+screenShotName+".jpeg");		
	}
	
	
		 
}

