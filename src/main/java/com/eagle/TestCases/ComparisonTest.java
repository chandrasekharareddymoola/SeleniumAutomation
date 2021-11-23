package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.ComparisonPage;

public class ComparisonTest extends BaseTest{

	ComparisonPage objComparisonPage; 

	@BeforeClass
	public void beforeClass() throws AWTException, InterruptedException  {	
		objComparisonPage = new ComparisonPage();		
	}

	@Test(priority = 0, description = "Create Comparison with a control and Verify")
	public void CreateComparisonWithContol_Test() throws Throwable {
		try {
			/* Creates an Comparison with control and Verify */		 
			objComparisonPage.createComparisonWithControl("Comparison Control 1", "Control Set ","Disease", "kera");
			onSuccessMeassage("Comparison is Created Successfully with Control Card");
		}
		catch(Throwable ex)
		{
			objComparisonPage.captureScreenshot("createComparisonWithControlFail");
			onFailureMeassage(ex.getMessage(),"createComparisonWithControlFail","createComparisonWithControlFail");
		}
	}	

	@Test(priority = 1, description = "Create Comparison From Set")
	public void CreateComparisonFromSet_Test() throws Throwable {
		try {
			/* Creates an Comparison Control Card From Set */		 
			objComparisonPage.CreateComparisonFromSet("SetAddC 1", "Disease", "kera", "ComFrom Set 1", "Control Card");
			onSuccessMeassage("Comparison is Created Successfully From Set");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("createComparisonFromSetFail");
			onFailureMeassage(ex.getMessage(),"createComparisonFromSetFail","createComparisonFromSetFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("createComparisonFromSetFail");
			onFailureMeassage(ex.getMessage(),"createComparisonFromSetFail","createComparisonFromSetFail");
		}
	}

	@Test(priority = 2, description = "Create Comparison From File")
	public void CreateComparisonFromFile_Test() throws Throwable {
		try {
			/* Creates an Comparison Control Card From File */	 
			objComparisonPage.CreateComparisonFromFile("ComFileUpload", "Control Set", "Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
			onSuccessMeassage("Comparison is Created Successfully From File");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("createComparisonFromFileFail");
			onFailureMeassage(ex.getMessage(),"createComparisonFromFileFail","createComparisonFromFileFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("createComparisonFromFileFail");
			onFailureMeassage(ex.getMessage(),"createComparisonFromFileFail","createComparisonFromFileFail");
		}
	}

	@Test(priority = 3, description = "Create Comparison with Control and Case and Verify")
	public void CreateComparisonWithContolandCase_Test() throws Throwable {
		try {
			/* Creates an Comparison with control and Case and Verify */	
			objComparisonPage.createComparisonWithControlandCase("Comparison Control and Case 1", "Control Set", "Case Set","Disease", "kera","buy");
			onSuccessMeassage("Comparison is Created Successfully with Control and Case Card");
		}
		catch(Throwable ex)
		{
			objComparisonPage.captureScreenshot("createComparisonWithControlandCaseSetFail");
			onFailureMeassage(ex.getMessage(),"createComparisonWithControlandCaseSetFail","createComparisonWithControlandCaseSetFail");
		}
	}	

	@Test(priority = 4, description = "Create Comparison with Control & Case and Run Comparison")
	public void createComparisonWithControlandCaseRunComparison_Test() throws Throwable {
		try {
			/* Creates an Comparison with Control & Case and Run Comparison */		 
			objComparisonPage.createComparisonWithcontrolandCaseRunComparison("Comparison Control and Case 2", "Control Set", "Case Set","Disease", "kera","buy");
			onSuccessMeassage("Comparison is Created Successfully with Control & Case Card - Comaparison Run is done");
		}
		catch(Throwable ex)
		{
			objComparisonPage.captureScreenshot("createComparisonWithControlandCase-RunFail");
			onFailureMeassage(ex.getMessage(),"createComparisonWithControlandCase-ComparisonRunFail","createComparisonWithControlandCase-ComparisonRunFail");
		}
	}	

	@Test(priority = 5, description = "Update an Existing Comparison with a case Card")
	public void updateComparisonWithCaseCard_Test() throws Throwable {
		try {
			/* Updates an existing Comparison with a Case Card */		 
			objComparisonPage.updateComparisonWithCaseCard("Comparison Control and Case 1", "Disease", "Case Set2","soy");
			onSuccessMeassage("Comparison is updated Successfully with a Case Card");
		}
		catch(Throwable ex)
		{
			objComparisonPage.captureScreenshot("updateComparisonWithCaseCardFail");
			onFailureMeassage(ex.getMessage(),"updateComparisonWithCaseCardFail","updateComparisonWithCaseCardFail");
		}
	}	

	@Test(priority = 6, description = "Search A Text In Comparison Expand")
	public void SearchInComparisonExpand_Test() throws Throwable  {
		try {
			/* To Search a Text in Expanded Comparison */
			objComparisonPage.searchInComparisonExpand("search Comparison","Control Set" ,"Disease", "kera", "le");
			onSuccessMeassage("Search successful in Set Expand");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("SearchInSetExpandFail");
			onFailureMeassage(ex.getMessage(),"SearchInSetExpandFail","SearchInSetExpandFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("SearchInSetExpandFail");
			onFailureMeassage(ex.getMessage(),"SearchInSetExpandFail","SearchInSetExpandFail");
		}
	}

	@Test(priority = 7, description = "Delete Card in Comparison Expand")
	public void DeleteCardInComparisonExpand_Test() throws Throwable  {
		try {
			/* Delete Set from Expanded Set */
			objComparisonPage.DeleteExploraionInExpand("DComparison2", "Control Set","Disease", "kera");
			onSuccessMeassage("Delete Card from Expanded Comparison");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("DeleteComparisonInExpandFail");
			onFailureMeassage(ex.getMessage(),"DeleteComparisonInExpandFail","DeleteComparisonInExpandFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("DeleteComparisonInExpandFail");
			onFailureMeassage(ex.getMessage(),"DeleteComparisonInExpandFail","DeleteComparisonInExpandFail");
		}		
	}

	@Test(priority = 8, description = "Delete The first Card in Comparison")
	public void DeleteComparisonFirstCard_Test() throws Throwable  {
		try {
			/* Delete The first Card (control) in Comparison */
			objComparisonPage.deleteComparisonInFirstCard("DComparison1Card", "Control Set", "Disease", "kera");
			onSuccessMeassage("Deleted The first Card in Comparison Successfully");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("ComparisonFirstCardDeleteFail");
			onFailureMeassage(ex.getMessage(),"ComparisonFirstCardDeleteFail","ComparisonFirstCardDeleteFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ComparisonFirstCardDeleteFail");
			onFailureMeassage(ex.getMessage(),"ComparisonFirstCardDeleteFail","ComparisonFirstCardDeleteFail");
		}
	}

	@Test(priority = 9, description = "Delete The Second Card in Comparison")
	public void DeleteComparisonSecondCard_Test() throws Throwable  {
		try {
			/* Delete The Second Card (case) in Comparison */
			objComparisonPage.deleteComparisonInLaterCard("DComparison2Card", "Control Card","Case Card" ,"Disease", "kera","lor");
			onSuccessMeassage("Deleted The first Card in Comparison Successfully");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("ComparisonSecondCardDeleteFail");
			onFailureMeassage(ex.getMessage(),"ComparisonSecondCardDeleteFail","ComparisonSecondCardDeleteFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ComparisonSecondCardDeleteFail");
			onFailureMeassage(ex.getMessage(),"ComparisonSecondCardDeleteFail","ComparisonSecondCardDeleteFail");
		}
	}

	@Test(priority = 10, description = "Comparison - Expand and add items from Catalog")
	public void ComparisonExpandAddFromCatalog_Test() throws Throwable  {
		try {
			/* Set - Expand and add items from Catalog */
			objComparisonPage.ExpandAddFromCatalog("ComAddFromCatalog", "Control Card", "Disease", "aber", "worm");
			objComparisonPage.saveChanges();
			onSuccessMeassage("Items Added from Catalog into Comparison successfully");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("ComparisonExpandAddFromCatalogFail");
			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromCatalogFail","ComparisonExpandAddFromCatalogFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ComparisonExpandAddFromCatalogFail");
			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromCatalogFail","ComparisonExpandAddFromCatalogFail");
		}

	}

	@Test(priority = 11, description = "Comparison - Expand and add items from Set")
	public void ComparisonExpandAddFromSet_Test() throws Throwable  {
		try {
			/* Comparison - Expand and add items from Set */
			objComparisonPage.ExpandAddFromSet("SetAdd 1", "Disease", "aber", "ComAddFromSet",  "Control Card", "dol" ); 
			objComparisonPage.saveChanges();
			onSuccessMeassage("Items Added from Set into Comparison successfully");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("ComparisonExpandAddFromSetFail");
			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromSetFail","ComparisonExpandAddFromSetFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ComparisonExpandAddFromSetFail");
			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromSetFail","ComparisonExpandAddFromSetFail");
		}
	}

	@Test(priority = 12, description = "Comparison - Expand and add items from File")
	public void ComparisonExpandAddFromFile_Test() throws Throwable  {
		try {
			/* Comparison - Expand and add items from File */
			objComparisonPage.ExpandAddFromFile("ComAddfromFile 1","Control Card", "Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
			objComparisonPage.saveChanges();
			onSuccessMeassage("Items Added from File into Comparison successfully");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("ComparisonExpandAddFromFileFail");
			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromFileFail","ComparisonExpandAddFromFileFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ComparisonExpandAddFromFileFail");
			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromFileFail","ComparisonExpandAddFromFileFail");
		}
	}

	@Test(priority = 13, description = "Comparison - Create with multiple Case Cards")
	public void ComparisonCreateMultipleCaseCards_Test() throws Throwable  {
		try {
			/* Comparison - Create with multiple Cards */		
			objComparisonPage.createComparisonWithControlandMultipleCase("CompRela 2", "Control Set",  "Disease", "kera", 2);
			onSuccessMeassage("Comparison Created and added with multiple Case Cards Successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ComparisonAdd2RelationFail");
			onFailureMeassage(ex.getMessage(),"ComparisonAdd2RelationFail","ComparisonAdd2RelationFail");
		}
	}

	@Test(priority = 14, description = "Comparison - Create with multiple Case Cards and Run Comparison")
	public void ComparisonCreateMultipleCaseCardsRunComparison_Test() throws Throwable  {
		try {
			/* Comparison - Create with multiple Cards with Run Comparison */
			objComparisonPage.createComparisonWithControlandMultipleCaseRunComparison("CompRela 3", "Control Set",  "Disease", "kera", 3);
			onSuccessMeassage("Comparison Created and added with multiple Case Cards Run comparison Successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ComparisonAdd2RelationFail");
			onFailureMeassage(ex.getMessage(),"ComparisonAdd2RelationFail","ComparisonAdd2RelationFail");
		}
	}

	@Test(priority = 15, description = "Create And Delete An Comparison")
	public void CreateAndDeleteComparison_Test() throws Throwable  {
		try {
			/* Create And Delete An Comparison */ 
			objComparisonPage.createAndDeleteComparison("Delete Com1", "Control Set", "Disease","kera");
			onSuccessMeassage("Created And Deleted An Comparison Successfully");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("CreateAndDeleteComparisonFail");
			onFailureMeassage(ex.getMessage(),"CreateAndDeleteComparisonFail","CreateAndDeleteComparisonFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("CreateAndDeleteComparisonFail");
			onFailureMeassage(ex.getMessage(),"CreateAndDeleteComparisonFail","CreateAndDeleteComparisonFail");
		}
	}

	@Test(priority = 16, description = "Create And Share An Comparison")
	public void CreateAndShareComparison_Test() throws Throwable  {
		try {
			/* Create And Share An Comparison */ 
			objComparisonPage.createAndShareComparison("Share Com1", "Control Set","Disease","kera","mugunth.raman@eaglegenomics.com");
			onSuccessMeassage("Created And Shared An Comparison Successfully");
		}
		catch(Exception ex)
		{
			objComparisonPage.captureScreenshot("CreateAndShareComparisonFail");
			onFailureMeassage(ex.getMessage(),"CreateAndShareComparisonFail","CreateAndShareComparisonFail");
		}
		catch(AssertionError ex)
		{
			objComparisonPage.captureScreenshot("CreateAndShareComparisonFail");
			onFailureMeassage(ex.getMessage(),"CreateAndShareComparisonFail","CreateAndShareComparisonFail");
		}
	}

	@Test(priority = 17, description = "Delete A Comparison")
	public void DeleteComparison_Test() throws Throwable  {
		try {
			/* Delete A Comparison */
			objComparisonPage.DeleteComparison("Comparison 10");
			onSuccessMeassage("Deleted A Comparison Successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objComparisonPage.captureScreenshot("DeleteComparisonFail");
			onFailureMeassage(ex.getMessage(),"DeleteComparisonFail","DeleteComparisonFail");
		}
	}

	@Test(priority = 18, description = "Sharing A Comparison")
	public void ShareComparison_Test() throws Throwable  {
		try {
			/* Share A Comparison */
			objComparisonPage.ShareComparison("Comparison 9","mugunth.raman@eaglegenomics.com");
			onSuccessMeassage("Shared A Comparison Successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ShareComparisonFail");
			onFailureMeassage(ex.getMessage(),"ShareComparisonFail","ShareComparisonFail");
		}
	}

	//	//	@Test(priority = 19, description = "Remove items from Comparison Expand")
	//	//	public void RemoveItemsfromComparison_Test() throws InterruptedException, IOException  {
	//	//		try {
	//	//			/* Remove items in Expanded Set */
	//	//			objComparisonPage.RemoveItemsfromComparison("Remove Item Comparison","Disease","Kera");
	//	//			onSuccessMeassage("Items removed successfully in Comparison Expand");
	//	//		}
	//	//		catch(Exception ex)
	//	//		{
	//	//			objComparisonPage.captureScreenshot("ComparisonItemsRemoveFail");
	//	//			onFailureMeassage(ex.getMessage(),"ComparisonItemsRemoveFail","ComparisonItemsRemoveFail");
	//	//		}
	//	//		catch(AssertionError ex)
	//	//		{
	//	//			objComparisonPage.captureScreenshot("ComparisonItemsRemoveFail");
	//	//			onFailureMeassage(ex.getMessage(),"ComparisonItemsRemoveFail","ComparisonItemsRemoveFail");
	//	//		}
	//	//	}

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

