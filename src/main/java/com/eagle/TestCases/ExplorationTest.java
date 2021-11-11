package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.ExplorationPage;
import com.eagle.pages.InvestigationPage;
import com.eagle.pages.LoginPage;
import com.eagle.pages.SetPage;

public class ExplorationTest extends BaseTest{

	LoginPage objLogin;
	ExplorationPage objExplorationPage; 

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException  {	
		objExplorationPage = new ExplorationPage();		
		objLogin = new LoginPage();
		objLogin.loginTo();
	}

	@Test(priority = 0, description = "Create Exploration From Search")
	public void CreateExplorationFromSearch_Test() throws InterruptedException, IOException {
		try {
			/* Creates an Exploration From Search */		 
			objExplorationPage.createExplorationFromSearch("ExSearch 1", "Disease", "de");
			onSuccessMeassage("Exploration is Created Successfully From Search");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromSearchFail");
			onFailreMeassage(ex.getMessage(),"createExplorationFromSearchFail");
		}
	}	

	@Test(priority = 1, description = "Create Exploration From Set Initally")
	public void CreateExplorationFromSetInitally_Test() throws InterruptedException, IOException {
		try {
			/* Creates an Exploration From Search - Initial */		 
			objExplorationPage.createExplorationInitallyFromSet("SetAdd 1", "Disease", "kera", "ExDirect From Set 1");
			onSuccessMeassage("Exploration is Created Successfully From Set Initally");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromSetInitalFail");
			onFailreMeassage(ex.getMessage(),"createExplorationFromSetInitalFail");
		}
	}

	@Test(priority = 2, description = "Create Exploration From Set After clicking From Search")
	public void CreateExplorationFromSet_Test() throws InterruptedException, IOException {
		try {
			/* Creates an Exploration From Set - After Search */		 
			objExplorationPage.CreateExplorationFromSet("SetAdd 2", "Disease", "kera", "ExFrom Set 2");
			onSuccessMeassage("Exploration is Created Successfully From Set");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromSetFail");
			onFailreMeassage(ex.getMessage(),"createExplorationFromSetFail");
		}
	}

	@Test(priority = 3, description = "Create Exploration From File After clicking From Search")
	public void CreateExplorationFromFile_Test() throws InterruptedException, IOException {
		try {
			/* Creates an Exploration From File - After Search */	 
			objExplorationPage.CreateExplorationFromFile("ExFileUpload", "Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
			onSuccessMeassage("Exploration is Created Successfully From File");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromFileFail");
			onFailreMeassage(ex.getMessage(),"createExplorationFromFileFail");
		}
	}

	@Test(priority = 4, description = "Search A Text In Exploration Expand")
	public void SearchInExplorationExpand_Test() throws InterruptedException, IOException  {
		try {
			/* To Search a Text in Expanded Exploration */
			objExplorationPage.searchInExplorationExpand("search Exploration", "Disease", "kera", "le");
			onSuccessMeassage("Search successful in Set Expand");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("SearchInSetExpandFail");
			onFailreMeassage(ex.getMessage(),"SearchInSetExpandFail");
		}
	}

	@Test(priority = 5, description = "Delete Card in Exploration Expand")
	public void DeleteCardInExplorationExpand_Test() throws InterruptedException, IOException  {
		try {
			/* Delete Set from Expanded Set */
			objExplorationPage.DeleteExploraionInExpand("DExploration2", "Disease", "kera");
			onSuccessMeassage("Delete Card from Expanded Exploration");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("DeleteExplorationInExpandFail");
			onFailreMeassage(ex.getMessage(),"DeleteExplorationInExpandFail");
		}
	}

	@Test(priority = 6, description = "Delete The first Card in Exploration")
	public void DeleteExplorationFirstCard_Test() throws InterruptedException, IOException  {
		try {
			/* Delete The first Card in Exploration */
			objExplorationPage.deleteExplorationInFirstCard("DExploration1Card", "Disease", "kera");
			onSuccessMeassage("Deleted The first Card in Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationFirstCardDeleteFail");
			onFailreMeassage(ex.getMessage(),"ExplorationFirstCardDeleteFail");
		}
	}

	@Test(priority = 7, description = "Delete The Second Card in Exploration")
	public void DeleteExplorationSecondCard_Test() throws InterruptedException, IOException  {
		try {
			/* Delete The Second Card in Exploration */
			objExplorationPage.deleteExplorationInLaterCard("DExploration2Card", "Disease", "kera","Gene");
			onSuccessMeassage("Deleted The first Card in Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationSecondCardDeleteFail");
			onFailreMeassage(ex.getMessage(),"ExplorationSecondCardDeleteFail");
		}
	}

	@Test(priority = 8, description = "Exploration - Expand and add items from Catalog")
	public void ExplorationExpandAddFromCatalog_Test() throws InterruptedException, IOException  {
		try {
			/* Set - Expand and add items from Catalog */
			objExplorationPage.ExpandAddFromCatalog("ExpAddFromCatalog", "Disease", "aber", "dengue");
			objExplorationPage.saveChanges();
			onSuccessMeassage("Items Added from Catalog into Exploration successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationExpandAddFromCatalogFail");
			onFailreMeassage(ex.getMessage(),"ExplorationExpandAddFromCatalogFail");
		}
	}

	@Test(priority = 9, description = "Exploration - Expand and add items from Set")
	public void ExplorationExpandAddFromSet_Test() throws InterruptedException, IOException  {
		try {
			/* Exploration - Expand and add items from Set */
			objExplorationPage.ExpandAddFromSet("ExpAddFromSet", "Disease", "aber", "SetAdd 1");
			objExplorationPage.saveChanges();
			onSuccessMeassage("Items Added from Set into Exploration successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationExpandAddFromSetFail");
			onFailreMeassage(ex.getMessage(),"ExplorationExpandAddFromSetFail");
		}
	}

	@Test(priority = 10, description = "Exploration - Expand and add items from File")
	public void ExplorationExpandAddFromFile_Test() throws InterruptedException, IOException  {
		try {
			/* Exploration - Expand and add items from File */
			objExplorationPage.ExpandAddFromFile("ExpAddfromFile 1","Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
			objExplorationPage.saveChanges();
			onSuccessMeassage("Items Added from File into Exploration successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationExpandAddFromFileFail");
			onFailreMeassage(ex.getMessage(),"ExplorationExpandAddFromFileFail");
		}
	}
		
	@Test(priority = 11, description = "Exploration - Create with one additional relation Card")
	public void ExplorationCreateARelationCard_Test() throws InterruptedException, IOException  {
		try {
			/* Exploration - Create with one additional relation Card */
			objExplorationPage.createRelationCardFirst("ExpRela 1", "Disease", "kera", "Gene");
			onSuccessMeassage("Exploration Created and added with a relation Card Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationAddARelationFail");
			onFailreMeassage(ex.getMessage(),"ExplorationAddARelationFail");
		}
	}
	
	@Test(priority = 12, description = "Exploration - Create with 2 additional relation Card")
	public void ExplorationCreateTwoRelationCard_Test() throws InterruptedException, IOException  {
		try {
			/* Exploration - Create with 2 additional relation Cards */
			objExplorationPage.createRelationCardMulti("ExpRela 2", "Disease", "kera", "Gene","Chemical Compound","5");
			onSuccessMeassage("Exploration Created and added with 2 relation Cards Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationAdd2RelationFail");
			onFailreMeassage(ex.getMessage(),"ExplorationAdd2RelationFail");
		}
	}
	
	@Test(priority = 13, description = "Create And Delete An Exploration")
	public void CreateAndDeleteExploration_Test() throws InterruptedException, IOException  {
		try {
			/* Create And Delete An Exploration */
			objExplorationPage.createAndDeleteExploration("Delete Exp1","Disease","kera");
			onSuccessMeassage("Created And Deleted An Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("CreateAndDeleteExplorationFail");
			onFailreMeassage(ex.getMessage(),"CreateAndDeleteExplorationFail");
		}
	}

	@Test(priority = 13, description = "Create And Share An Exploration")
	public void CreateAndShareExploration_Test() throws InterruptedException, IOException  {
		try {
			/* Create And Share An Exploration */
			objExplorationPage.createAndShareExploration("Share Exp1","Disease","kera","mugunth.raman@eaglegenomics.com");
			onSuccessMeassage("Created And Shared An Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("CreateAndShareExplorationFail");
			onFailreMeassage(ex.getMessage(),"CreateAndShareExplorationFail");
		}
	}
	
	@Test(priority = 14, description = "Delete An Exploration")
	public void DeleteExploration_Test() throws InterruptedException, IOException  {
		try {
			/* Delete An Exploration */
			objExplorationPage.DeleteExploration("ExpAddFromSet");
			onSuccessMeassage("Deleted An Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("DeleteExplorationFail");
			onFailreMeassage(ex.getMessage(),"DeleteExplorationFail");
		}
	}

	@Test(priority = 15, description = "Sharing An Exploration")
	public void ShareExploration_Test() throws InterruptedException, IOException  {
		try {
			/* Share An Exploration */
			objExplorationPage.ShareExploration("UntitledExploration-29 Oct 2021","mugunth.raman@eaglegenomics.com");
			onSuccessMeassage("Shared An Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ShareExplorationFail");
			onFailreMeassage(ex.getMessage(),"ShareExplorationFail");
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
		ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir") + "./Resources/ErrorScreenshots/"+screenShotName+".jpeg");		
	}


}	   

