package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.ExplorationPage;

public class ExplorationTest extends BaseTest{

	ExplorationPage objExplorationPage; 

	@BeforeClass
	public void beforeClass() throws AWTException, InterruptedException  {	
		objExplorationPage = new ExplorationPage();		
	}

	@Test(priority = 0, description = "Create Exploration From Search")
	public void CreateExplorationFromSearch_Test() throws Throwable {
		try {
			/* Creates an Exploration From Search */		 
			objExplorationPage.createExplorationFromSearch("ExSearch 1", "Disease", "kera");
			onSuccessMeassage("Exploration is Created Successfully From Search");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromSearchFail");
			onFailureMeassage(ex.getMessage(),"createExplorationFromSearchFail","createExplorationFromSearchFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromSearchFail");
			onFailureMeassage(ex.getMessage(),"createExplorationFromSearchFail","createExplorationFromSearchFail");
		}
	}	

	@Test(priority = 1, description = "Create Exploration From Set Initally")
	public void CreateExplorationFromSetInitally_Test() throws Throwable {
		try {
			/* Creates an Exploration From Search - Initial */		 
			objExplorationPage.createExplorationInitallyFromSet("SetAdd 1", "Disease", "kera", "ExDirect From Set 1");
			onSuccessMeassage("Exploration is Created Successfully From Set Initally");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromSetInitalFail");
			onFailureMeassage(ex.getMessage(),"createExplorationFromSetInitalFail","createExplorationFromSetInitalFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromSetInitalFail");
			onFailureMeassage(ex.getMessage(),"createExplorationFromSetInitalFail","createExplorationFromSetInitalFail");
		}
	}

	@Test(priority = 2, description = "Create Exploration From Set After clicking From Search")
	public void CreateExplorationFromSet_Test() throws Throwable {
		try {
			/* Creates an Exploration From Set - After Search */		 
			objExplorationPage.CreateExplorationFromSet("SetAdd 2", "Disease", "kera", "ExFrom Set 2");
			onSuccessMeassage("Exploration is Created Successfully From Set");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromSetFail");
			onFailureMeassage(ex.getMessage(),"createExplorationFromSetFail","createExplorationFromSetFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromSetFail");
			onFailureMeassage(ex.getMessage(),"createExplorationFromSetFail","createExplorationFromSetFail");
		}
	}

	@Test(priority = 3, description = "Create Exploration From File After clicking From Search")
	public void CreateExplorationFromFile_Test() throws Throwable {
		try {
			/* Creates an Exploration From File - After Search */	 
			objExplorationPage.CreateExplorationFromFile("ExFileUpload", "Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
			onSuccessMeassage("Exploration is Created Successfully From File");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromFileFail");
			onFailureMeassage(ex.getMessage(),"createExplorationFromFileFail","createExplorationFromFileFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("createExplorationFromFileFail");
			onFailureMeassage(ex.getMessage(),"createExplorationFromFileFail","createExplorationFromFileFail");
		}
	}

	@Test(priority = 4, description = "Search A Text In Exploration Expand")
	public void SearchInExplorationExpand_Test() throws Throwable  {
		try {
			/* To Search a Text in Expanded Exploration */
			objExplorationPage.searchInExplorationExpand("search Exploration", "Disease", "kera", "le");
			onSuccessMeassage("Search successful in Set Expand");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("SearchInSetExpandFail");
			onFailureMeassage(ex.getMessage(),"SearchInSetExpandFail","SearchInSetExpandFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("SearchInSetExpandFail");
			onFailureMeassage(ex.getMessage(),"SearchInSetExpandFail","SearchInSetExpandFail");
		}
	}

	@Test(priority = 5, description = "Delete Card in Exploration Expand")
	public void DeleteCardInExplorationExpand_Test() throws Throwable  {
		try {
			/* Delete Set from Expanded Set */
			objExplorationPage.DeleteExploraionInExpand("DExploration2", "Disease", "kera");
			onSuccessMeassage("Delete Card from Expanded Exploration");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("DeleteExplorationInExpandFail");
			onFailureMeassage(ex.getMessage(),"DeleteExplorationInExpandFail","DeleteExplorationInExpandFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("DeleteExplorationInExpandFail");
			onFailureMeassage(ex.getMessage(),"DeleteExplorationInExpandFail","DeleteExplorationInExpandFail");
		}		
	}

	@Test(priority = 6, description = "Delete The first Card in Exploration")
	public void DeleteExplorationFirstCard_Test() throws Throwable  {
		try {
			/* Delete The first Card in Exploration */
			objExplorationPage.deleteExplorationInFirstCard("DExploration1Card", "Disease", "kera");
			onSuccessMeassage("Deleted The first Card in Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationFirstCardDeleteFail");
			onFailureMeassage(ex.getMessage(),"ExplorationFirstCardDeleteFail","ExplorationFirstCardDeleteFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("ExplorationFirstCardDeleteFail");
			onFailureMeassage(ex.getMessage(),"ExplorationFirstCardDeleteFail","ExplorationFirstCardDeleteFail");
		}
	}

	@Test(priority = 7, description = "Delete The Second Card in Exploration")
	public void DeleteExplorationSecondCard_Test() throws Throwable  {
		try {
			/* Delete The Second Card in Exploration */
			objExplorationPage.deleteExplorationInLaterCard("DExploration2Card", "Disease", "kera","Gene");
			onSuccessMeassage("Deleted The first Card in Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationSecondCardDeleteFail");
			onFailureMeassage(ex.getMessage(),"ExplorationSecondCardDeleteFail","ExplorationSecondCardDeleteFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("ExplorationSecondCardDeleteFail");
			onFailureMeassage(ex.getMessage(),"ExplorationSecondCardDeleteFail","ExplorationSecondCardDeleteFail");
		}
	}

	@Test(priority = 8, description = "Exploration - Expand and add items from Catalog")
	public void ExplorationExpandAddFromCatalog_Test() throws Throwable  {
		try {
			/* Set - Expand and add items from Catalog */
			objExplorationPage.ExpandAddFromCatalog("ExpAddFromCatalog", "Disease", "aber", "dengue");
			objExplorationPage.saveChanges();
			onSuccessMeassage("Items Added from Catalog into Exploration successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationExpandAddFromCatalogFail");
			onFailureMeassage(ex.getMessage(),"ExplorationExpandAddFromCatalogFail","ExplorationExpandAddFromCatalogFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("ExplorationExpandAddFromCatalogFail");
			onFailureMeassage(ex.getMessage(),"ExplorationExpandAddFromCatalogFail","ExplorationExpandAddFromCatalogFail");
		}

	}

	@Test(priority = 9, description = "Exploration - Expand and add items from Set")
	public void ExplorationExpandAddFromSet_Test() throws Throwable  {
		try {
			/* Exploration - Expand and add items from Set */
			objExplorationPage.ExpandAddFromSet("SetAdd 1", "Disease", "aber", "ExpAddFromSet", "dol" ); 
			objExplorationPage.saveChanges();
			onSuccessMeassage("Items Added from Set into Exploration successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationExpandAddFromSetFail");
			onFailureMeassage(ex.getMessage(),"ExplorationExpandAddFromSetFail","ExplorationExpandAddFromSetFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("ExplorationExpandAddFromSetFail");
			onFailureMeassage(ex.getMessage(),"ExplorationExpandAddFromSetFail","ExplorationExpandAddFromSetFail");
		}
	}

	@Test(priority = 10, description = "Exploration - Expand and add items from File")
	public void ExplorationExpandAddFromFile_Test() throws Throwable  {
		try {
			/* Exploration - Expand and add items from File */
			objExplorationPage.ExpandAddFromFile("ExpAddfromFile 1","Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
			objExplorationPage.saveChanges();
			onSuccessMeassage("Items Added from File into Exploration successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationExpandAddFromFileFail");
			onFailureMeassage(ex.getMessage(),"ExplorationExpandAddFromFileFail","ExplorationExpandAddFromFileFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("ExplorationExpandAddFromFileFail");
			onFailureMeassage(ex.getMessage(),"ExplorationExpandAddFromFileFail","ExplorationExpandAddFromFileFail");
		}
	}

	@Test(priority = 11, description = "Exploration - Create with one additional relation Card")
	public void ExplorationCreateARelationCard_Test() throws Throwable  {
		try {
			/* Exploration - Create with one additional relation Card */
			objExplorationPage.createRelationCardFirst("ExpRela 1", "Disease", "kera", "Gene");
			onSuccessMeassage("Exploration Created and added with a relation Card Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationAddARelationFail");
			onFailureMeassage(ex.getMessage(),"ExplorationAddARelationFail","ExplorationAddARelationFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("ExplorationAddARelationFail");
			onFailureMeassage(ex.getMessage(),"ExplorationAddARelationFail","ExplorationAddARelationFail");
		}
	}

	//	 	@Test(priority = 12, description = "Exploration - Create with 2 additional relation Card")
	//		public void ExplorationCreateTwoRelationCard_Test() throws Throwable  {
	//		try {
	//			/* Exploration - Create with 2 additional relation Cards */
	//			objExplorationPage.createRelationCardMulti("ExpRela 2", "Disease", "kera", "Gene","Chemical Compound","5");
	//			onSuccessMeassage("Exploration Created and added with 2 relation Cards Successfully");
	//		}
	//		catch(Exception ex)
	//		{
	//			objExplorationPage.captureScreenshot("ExplorationAdd2RelationFail");
	//			onFailureMeassage(ex.getMessage(),"ExplorationAdd2RelationFail","ExplorationAdd2RelationFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objExplorationPage.captureScreenshot("ExplorationAdd2RelationFail");
	//			onFailureMeassage(ex.getMessage(),"ExplorationAdd2RelationFail","ExplorationAdd2RelationFail");
	//		}
	//	}

	@Test(priority = 13, description = "Create And Delete An Exploration")
	public void CreateAndDeleteExploration_Test() throws Throwable  {
		try {
			/* Create And Delete An Exploration */
			objExplorationPage.createAndDeleteExploration("Delete Exp1","Disease","kera");
			onSuccessMeassage("Created And Deleted An Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("CreateAndDeleteExplorationFail");
			onFailureMeassage(ex.getMessage(),"CreateAndDeleteExplorationFail","CreateAndDeleteExplorationFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("CreateAndDeleteExplorationFail");
			onFailureMeassage(ex.getMessage(),"CreateAndDeleteExplorationFail","CreateAndDeleteExplorationFail");
		}
	}

	@Test(priority = 14, description = "Create And Share An Exploration")
	public void CreateAndShareExploration_Test() throws Throwable  {
		try {
			/* Create And Share An Exploration */
			objExplorationPage.createAndShareExploration("Share Exp1","Disease","kera","mugunth.raman@eaglegenomics.com");
			onSuccessMeassage("Created And Shared An Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("CreateAndShareExplorationFail");
			onFailureMeassage(ex.getMessage(),"CreateAndShareExplorationFail","CreateAndShareExplorationFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("CreateAndShareExplorationFail");
			onFailureMeassage(ex.getMessage(),"CreateAndShareExplorationFail","CreateAndShareExplorationFail");
		}
	}

	@Test(priority = 15, description = "Delete An Exploration")
	public void DeleteExploration_Test() throws Throwable  {
		try {
			/* Delete An Exploration */
			objExplorationPage.DeleteExploration("ExpAddFromSet");
			onSuccessMeassage("Deleted An Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("DeleteExplorationFail");
			onFailureMeassage(ex.getMessage(),"DeleteExplorationFail","DeleteExplorationFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("DeleteExplorationFail");
			onFailureMeassage(ex.getMessage(),"DeleteExplorationFail","DeleteExplorationFail");
		}
	}

	@Test(priority = 16, description = "Sharing An Exploration")
	public void ShareExploration_Test() throws Throwable  {
		try {
			/* Share An Exploration */
			objExplorationPage.ShareExploration("UntitledExploration-29 Oct 2021","mugunth.raman@eaglegenomics.com");
			onSuccessMeassage("Shared An Exploration Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ShareExplorationFail");
			onFailureMeassage(ex.getMessage(),"ShareExplorationFail","ShareExplorationFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("ShareExplorationFail");
			onFailureMeassage(ex.getMessage(),"ShareExplorationFail","ShareExplorationFail");
		}
	}

	//	@Test(priority = 17, description = "Remove items from Exploration Expand")
	//	public void RemoveItemsfromExploration_Test() throws InterruptedException, IOException  {
	//		try {
	//			/* Remove items in Expanded Set */
	//			objExplorationPage.RemoveItemsfromExploration("Remove Item Exploration","Disease","Kera");
	//			onSuccessMeassage("Items removed successfully in Exploration Expand");
	//		}
	//		catch(Exception ex)
	//		{
	//			objExplorationPage.captureScreenshot("ExplorationItemsRemoveFail");
	//			onFailureMeassage(ex.getMessage(),"ExplorationItemsRemoveFail","ExplorationItemsRemoveFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objExplorationPage.captureScreenshot("ExplorationItemsRemoveFail");
	//			onFailureMeassage(ex.getMessage(),"ExplorationItemsRemoveFail","ExplorationItemsRemoveFail");
	//		}
	//	}

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

