package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

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
} 
