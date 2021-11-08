package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.eagle.pages.ExplorationPage;
import com.eagle.pages.InvestigationPage;
import com.eagle.pages.LoginPage;
import com.eagle.pages.SetPage;

public class ExplorationTest extends BaseTest{

	LoginPage objLogin;
	ExplorationPage objExplorationPage; 

	@Test
	public void test_Exploration_Correct() throws InterruptedException, AWTException, IOException{
		objLogin = new LoginPage();
		objLogin.loginTo();

		objExplorationPage = new ExplorationPage();  
//				objExplorationPage.createExplorationFromSearch("ExSearch 1", "Disease", "de");
		//
		//		objExplorationPage.createExplorationInitallyFromSet("SetAdd 1", "Disease", "kera", "ExDirect From Set 1");
		//
		//		objExplorationPage.CreateExplorationFromSet("SetAdd 2", "Disease", "kera", "ExFrom Set 2");
		//
		//		objExplorationPage.CreateExplorationFromFile("ExFileUpload", "Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
		//	
		//		objExplorationPage.searchInExplorationExpand("search Exploration", "Disease", "kera", "le");		
		//
		//		objExplorationPage.deleteExplorationInFirstCard("DExploration1Card", "Disease", "kera");

		//		objExplorationPage.DeleteExploraionInExpand("DExploration2", "Disease", "kera");
		//
		//		objExplorationPage.createRelationCardFirst("ExpRela 1", "Disease", "kera", "Gene");

		//		objExplorationPage.deleteExplorationInLaterCard("DExploration2Card", "Disease", "kera","Gene");

		//		objExplorationPage.ExpandAddFromSet("ExpAddFromSet", "Disease", "aber", "SetAdd 1");
		//		objExplorationPage.saveChanges();

		//		objExplorationPage.ExpandAddFromCatalog("ExpAddFromCatalog", "Disease", "aber", "dengue");
		//		objExplorationPage.saveChanges();

//		objExplorationPage.ExpandAddFromFile("ExpAddfromFile 1","Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
//		objExplorationPage.saveChanges();

//		objExplorationPage.createAndDeleteExploration("Delete Exp1","Disease","kera");
//		objExplorationPage.createAndShareExploration("Share Exp1","Disease","kera","mugunth.raman@eaglegenomics.com");

//		objExplorationPage.DeleteExploration("ExpAddFromSet");
//		objExplorationPage.ShareExploration("UntitledExploration-29 Oct 2021","mugunth.raman@eaglegenomics.com");
		
		

				objExplorationPage.createRelationCardMulti("ExpRela 1", "Disease", "kera", "Gene","Chemical Compound","5");
				

	}	   
} 
