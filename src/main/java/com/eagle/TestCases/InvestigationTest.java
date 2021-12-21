package com.eagle.TestCases;
import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.ComparisonPage;
import com.eagle.pages.ExplorationPage;
import com.eagle.pages.InvestigationPage;
import com.eagle.pages.SetPage;

public class InvestigationTest extends BaseTest {
	
	InvestigationPage objInvestigationPage;	SetPage objSetPage;
	ExplorationPage objExplorationPage; ComparisonPage objComparisonPage;
	String investigationName, functionName, value; String[] invParameters;
	String entity = "Disease"; String searchText = "fever";String compSetName = "setName";

	@BeforeClass
	public void beforeClass() throws InterruptedException, AWTException  {	
			objInvestigationPage = new InvestigationPage();	
	}
	
	@Test(priority = 0, description = "Create Investigation")
	public void CreateInvestigation_Test() throws InterruptedException, IOException {
		
		try {
			/* To initiate the creation of Investigation */		
			functionName = new Object(){}.getClass().getEnclosingMethod().getName();				
			
			value = this.getConfiguration().get(functionName);
			invParameters = value.split(",");
			investigationName = invParameters[0].trim() + this.getDateTime();
			String invDescription = invParameters[1].trim();
			
			objInvestigationPage.createInvestigation(investigationName,invDescription);
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
			functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			value = this.getConfiguration().get(functionName);			
			investigationName = value.trim();
			
			objInvestigationPage.viewInvestigation(investigationName);
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
			functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			value = this.getConfiguration().get(functionName);
			invParameters =value.split(",");
			investigationName = invParameters[0].trim() + this.getDateTime();
			String newInvName = invParameters[1].trim() + this.getDateTime();
			String invDescription = invParameters[2].trim();
			
			objInvestigationPage.createInvestigation(investigationName,investigationName);
			objInvestigationPage.editInvestigation(investigationName,newInvName,invDescription);
			onSuccessMeassage("Investigation is successfully modified");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("editInvFail");
			onFailureMeassage(ex.getMessage(),"editInvFail");
		}
	}
	
	@Test(priority = 3, description = "Link Set With Investigation")
	public void LinkSetWithInvestigation_Test() throws Throwable  {
		try {                                              
			/* To Link set to an Investigation */		
			functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			value = this.getConfiguration().get(functionName);
			invParameters =value.split(",");
			investigationName = invParameters[0].trim() + this.getDateTime();
			String setTobeLinked = invParameters[1].trim()+ this.getDateTime();
			
			objInvestigationPage.createInvestigation(investigationName,investigationName);
			objSetPage = new SetPage();					
			objSetPage.createSet(setTobeLinked,entity,searchText);	
			objInvestigationPage.linkSettoInvestigation(investigationName ,setTobeLinked);
			onSuccessMeassage("Investigation is successfully linked with set");
		}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("linkSetInvFail");
			onFailureMeassage(ex.getMessage(),"linkSetInvFail");
		}
	}
	
	
	@Test(priority = 4, description = "Link Exploration With Investigation")
	public void LinkExplorationWithInvestigation_Test() throws Throwable  {                                                   
		try {
			/* To Link exploration to an Investigation */
			functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			value = this.getConfiguration().get(functionName);
			invParameters =value.split(",");				
			investigationName = invParameters[0].trim() + this.getDateTime();
			String expTobeLinked = invParameters[1].trim()+ this.getDateTime();
			   //ERROR //
			objInvestigationPage.createInvestigation(investigationName,investigationName);
			objExplorationPage = new ExplorationPage();				
			objExplorationPage.createExploration(expTobeLinked, entity, searchText);
			 objInvestigationPage.linkExplorationtoInvestigation(investigationName,expTobeLinked);
			  onSuccessMeassage("Investigation is successfully linked with Exploration");
			}
		catch(Exception ex)
		{
			objInvestigationPage.captureScreenshot("linkExpInvFail");
			onFailureMeassage(ex.getMessage(),"linkExpInvFail");
		}
	}
	
	@Test(priority = 5, description = "Link Comparison With Investigation")
	public void LinkComparisonWithInvestigation_Test() throws Throwable  {
		try {
		   /* To Link Comparison to an Investigation */
			functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			value = this.getConfiguration().get(functionName);
			invParameters =value.split(",");
			String invName = invParameters[0].trim();
			investigationName = invParameters[0].trim() + this.getDateTime();
			String compTobeLinked = invParameters[1].trim()+ this.getDateTime();
			
			objInvestigationPage.createInvestigation(investigationName,investigationName);
			objComparisonPage = new ComparisonPage();	
			objComparisonPage.createComparisonControl(compTobeLinked, compSetName, entity, searchText);
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
			functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			value = this.getConfiguration().get(functionName);
			invParameters =value.split(",");
			investigationName = invParameters[0].trim() + this.getDateTime();
			String toBeSharedWith = invParameters[1].trim();
			
			objInvestigationPage.createInvestigation(investigationName,investigationName);
			objInvestigationPage.shareInvestigation(investigationName,toBeSharedWith);
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
			functionName = new Object(){}.getClass().getEnclosingMethod().getName();		
			value = this.getConfiguration().get(functionName);			
			investigationName =value + this.getDateTime();
			
			objInvestigationPage.createInvestigation(investigationName,investigationName);
			objInvestigationPage.deleteInvestigation(investigationName);	
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
		ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir") + "./Resources/ErrorScreenshots/"+screenShotName+".png");		
	}
	
	
		 
}

