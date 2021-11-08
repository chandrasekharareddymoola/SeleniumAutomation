package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.InvestigationPage;
import com.eagle.pages.LoginPage;
import com.eagle.pages.SetPage;

public class SetTest extends BaseTest{

	LoginPage objLogin;
	SetPage objSetPage; 

	@Test
	public void test_Set_Correct() throws InterruptedException, AWTException, IOException{
		objLogin = new LoginPage();
		objLogin.loginTo();
		objSetPage = new SetPage();

//				objSetPage.createSet("Create Set1","Disease","kera");	 

		//		objSetPage.CreateSetFromFile("Set From File 1","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
		//
		//		objSetPage.CreateSetFromSet("Base Set 1","Disease","Kera","Set From Set 1"); 
		//
		//				objSetPage.searchInSetExpand("Search Set 1","Disease","Kera","le");
		//
//				objSetPage.ExpandAddFromCatalog("Set From Catalog 1","Disease","Kera","migraine");
//				objSetPage.saveChanges();
//		//		
//				objSetPage.ExpandAddFromSet("Base Set 2","Disease","dol","Set Add Set expand 1", "Kera");
//				objSetPage.saveChanges();
//		//
//				objSetPage.ExpandAddFromFile("ESFIle 1","Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
//				objSetPage.saveChanges();


//		objSetPage.DeleteCardInExpand("DeleteCard 1","Disease","kera");

//	    objSetPage.GridChanges("GridSet", "Disease", "Kera", "10", "Definition", "Identifier");

//		objSetPage.createAndDeleteSet("Delete Set1","Disease","kera");
//		objSetPage.createAndShareSet("Share Set1","Disease","kera","mugunth.raman@eaglegenomics.com");

		objSetPage.DeleteSet("Set Test Auto 1");
		
//		objSetPage.ShareSet("GridSet","mugunth.raman@eaglegenomics.com");
		
		
		//	    objSetPage.RemoveItemsfromSet();

		//	    objSetPage.shareASet(null, null);

	}	   
   
   
    	@BeforeClass
    	public void beforeMethod() throws InterruptedException, IOException {
    		//Login to application
    		LoginPage objLogin;
    		objLogin = new LoginPage();
    		objLogin.loginTo();
    		objSetPage = new SetPage();		
    	}
	   
    	
    	@Test(priority = 0, description = "Create Investigation")
    	public void CreateSet_Test() throws InterruptedException {
    		
    		try {
    			/* To initiate the creation of Investigation */		 
    			//objSetPage.createSet();	  
    			ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    		}
    		catch(Exception ex)
    		{
    			
    		}
    	}
    	
    	@Test(priority = 1, description = "View Investigation")
    	public void ViewInvestigation_Test() throws InterruptedException {
    		try {
    			 /* To view the Investigation */
    			objSetPage.RemoveItemsfromSet();
    			 ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    		}
    		catch(Exception ex)
    		{
    			
    		}
    	}
    		
    	
//	    //  
//	   // 
//	   // objSetPage.CreateSetFromFile();
//	   // objSetPage.CreateSetFromSet();
	  
	   // objSetPage.ExpandAddFromCatalog("Set Test Auto 1", "migraine");
	   // objSetPage.close();
	    
//	    objSetPage.ExpandAddFromCatalog(null, null);
//	    objSetPage.accept();
//	    
//	    objSetPage.ExpandAddFromSet(null, null);
//	    objSetPage.close();
//	    
//	    objSetPage.ExpandAddFromSet(null, null);
//	    objSetPage.accept();
//
//	    objSetPage.GridChanges(null, null, null, null);
//	    
//	    objSetPage.shareASet(null, null);
	    
    	   
}

