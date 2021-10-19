package com.eagle.TestCases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.eagle.pages.InvestigationPage;
import com.eagle.pages.LoginPage;
import com.eagle.pages.SetPage;

public class SetTest extends BaseTest{

	LoginPage objLogin;
	SetPage objSetPage; 
   
    @Test
    public void test_Set_Correct() throws InterruptedException, AWTException{
	    objLogin = new LoginPage();
	    objLogin.loginTo();
	    
	    objSetPage = new SetPage();
//	    //objSetPage.createSet();	    
//	   // objSetPage.RemoveItemsfromSet();
//	   // objSetPage.CreateSetFromFile();
//	   // objSetPage.CreateSetFromSet();
	  
	    objSetPage.ExpandAddFromCatalog("Set Test Auto 1", "migraine");
	    objSetPage.close();
	    
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
} 
