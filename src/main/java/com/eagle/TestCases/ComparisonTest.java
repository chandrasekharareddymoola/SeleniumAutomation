package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.ComparisonPage;

public class ComparisonTest extends BaseTest{

	ComparisonPage objComparisonPage; 
	
	Date dt = new Date();
	DateFormat dtFrmt = new SimpleDateFormat("_HHmmss");
	String dtText = dtFrmt.format(dt);

	@BeforeClass
	public void beforeClass() throws AWTException, InterruptedException  {	
		objComparisonPage = new ComparisonPage();		
	}

	@Test(priority = 0, description = "Create Comparison with a control and Verify")
	public void CreateComparisonWithContol_Test() throws Throwable {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			
			/* Creates an Comparison with control and Verify */	
			objComparisonPage.createComparisonWithControl(ComName,ControlSetName,entity,searchTextInControl);
//			objComparisonPage.createComparisonWithControl("Comparison Control 1", "Control Set ","Disease", "kera");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String BaseSetName = ComParameters[0].trim()+dtText;
			String entity = ComParameters[1].trim();
			String searchTextInSet = ComParameters[2].trim();
			String ComName = ComParameters[3].trim()+dtText;
			String searchTextInControl = ComParameters[4].trim();
			
			/* Creates an Comparison Control Card From Set */	
			objComparisonPage.CreateComparisonFromSet(BaseSetName,entity,searchTextInSet,ComName,searchTextInControl);
//			objComparisonPage.CreateComparisonFromSet("SetAddC 1", "Disease", "kera", "ComFrom Set 1", "Control Card");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String fileLocation = ComParameters[3].trim();
			
			/* Creates an Comparison Control Card From File */	 
			objComparisonPage.CreateComparisonFromFile(ComName,ControlSetName,entity,fileLocation);
//			objComparisonPage.CreateComparisonFromFile("ComFileUpload", "Control Set", "Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String CaseSetName = ComParameters[2].trim();
			String entity = ComParameters[3].trim();
			String searchTextInControl = ComParameters[4].trim();
			String searchTextInCase = ComParameters[5].trim();

			/* Creates an Comparison with control and Case and Verify */	
			objComparisonPage.createComparisonWithControlandCase(ComName,ControlSetName,CaseSetName,entity, searchTextInControl,searchTextInCase);
//			objComparisonPage.createComparisonWithControlandCase("Comparison Control and Case 1", "Control Set", "Case Set","Disease", "kera","buy");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String CaseSetName = ComParameters[2].trim();
			String entity = ComParameters[3].trim();
			String searchInControl = ComParameters[4].trim();
			String searchInCase = ComParameters[5].trim();
			
			/* Creates an Comparison with Control & Case and Run Comparison */		 
			objComparisonPage.createComparisonWithcontrolandCaseRunComparison(ComName,ControlSetName,CaseSetName,entity,searchInControl,searchInCase);
//			objComparisonPage.createComparisonWithcontrolandCaseRunComparison("Comparison Control and Case 2", "Control Set", "Case Set","Disease", "kera","buy");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim();
			String entity = ComParameters[1].trim();
			String CaseSetName = ComParameters[2].trim();
			String searchTextInCase = ComParameters[3].trim();
			
			/* Updates an existing Comparison with a Case Card */	
			objComparisonPage.updateComparisonWithCaseCard(ComName,entity,CaseSetName,searchTextInCase);
//			objComparisonPage.updateComparisonWithCaseCard("Comparison Control and Case 1", "Disease", "Case Set2","soy");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			String searchTextInExpand = ComParameters[4].trim();
			
			/* To Search a Text in Expanded Comparison */
			objComparisonPage.searchInComparisonExpand(ComName, ControlSetName,entity,searchTextInControl,searchTextInExpand);
//			objComparisonPage.searchInComparisonExpand("search Comparison","Control Set" ,"Disease", "kera", "le");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			
			/* Delete Set from Expanded Set */
			objComparisonPage.DeleteExploraionInExpand(ComName, ControlSetName,entity,searchTextInControl);
//			objComparisonPage.DeleteExploraionInExpand("DComparison2", "Control Set","Disease", "kera");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			
			/* Delete The first Card (control) in Comparison */
			objComparisonPage.deleteComparisonInFirstCard(ComName,ControlSetName,entity,searchTextInControl);
//			objComparisonPage.deleteComparisonInFirstCard("DComparison1Card", "Control Set", "Disease", "kera");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String CaseSetName = ComParameters[2].trim();
			String entity = ComParameters[3].trim();
			String searchTextInControl = ComParameters[4].trim();
			String searchTextInCase = ComParameters[5].trim();
			
			/* Delete The Second Card (case) in Comparison */
			objComparisonPage.deleteComparisonInLaterCard(ComName,ControlSetName,CaseSetName,entity,searchTextInControl,searchTextInCase);
//			objComparisonPage.deleteComparisonInLaterCard("DComparison2Card", "Control Card","Case Card" ,"Disease", "kera","lor");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			String searchTextInCatalog = ComParameters[4].trim();
			
			/* Set - Expand and add items from Catalog */
			objComparisonPage.ExpandAddFromCatalog(ComName,ControlSetName,entity,searchTextInControl,searchTextInCatalog);
//			objComparisonPage.ExpandAddFromCatalog("ComAddFromCatalog", "Control Card", "Disease", "aber", "worm");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String BaseSetName = ComParameters[0].trim()+dtText;
			String entity = ComParameters[1].trim();
			String searchTextInSet = ComParameters[2].trim();
			String ComName = ComParameters[3].trim()+dtText;
			String ControlSetName = ComParameters[4].trim();
			String searchTextInControl = ComParameters[5].trim();
			
			/* Comparison - Expand and add items from Set */
			objComparisonPage.ExpandAddFromSet(BaseSetName,entity, searchTextInSet, ComName,ControlSetName,searchTextInControl); 
//			objComparisonPage.ExpandAddFromSet("SetAdd 1", "Disease", "aber", "ComAddFromSet",  "Control Card", "dol"); 
			objComparisonPage.saveChanges();
			onSuccessMeassage("Items Added from Set into Comparison successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ComparisonExpandAddFromSetFail");
			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromSetFail","ComparisonExpandAddFromSetFail");
		}
	}

	@Test(priority = 12, description = "Comparison - Expand and add items from File")
	public void ComparisonExpandAddFromFile_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			String fileUploadEntity = ComParameters[4].trim();
			String fileLocation = ComParameters[5].trim();
			String fileName = ComParameters[6].trim();
			
			/* Comparison - Expand and add items from File */
			objComparisonPage.ExpandAddFromFile(ComName,ControlSetName,entity,searchTextInControl,fileUploadEntity, fileLocation,fileName);
//			objComparisonPage.ExpandAddFromFile("ComAddfromFile 1","Control Card", "Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			String NoOfCaseCardstocreate = ComParameters[4].trim();
			
			/* Comparison - Create with multiple Cards */		
			objComparisonPage.createComparisonWithControlandMultipleCase(ComName, ControlSetName,entity, searchTextInControl, Integer.parseInt(NoOfCaseCardstocreate));
//			objComparisonPage.createComparisonWithControlandMultipleCase("CompRela 2", "Control Set",  "Disease", "kera", 2);
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			String NoOfCaseCardstocreate = ComParameters[4].trim();
			
			/* Comparison - Create with multiple Cards with Run Comparison */
			objComparisonPage.createComparisonWithControlandMultipleCaseRunComparison(ComName, ControlSetName,entity,searchTextInControl,Integer.parseInt(NoOfCaseCardstocreate));
//			objComparisonPage.createComparisonWithControlandMultipleCaseRunComparison("CompRela 3", "Control Set",  "Disease", "kera", 3);
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			
			/* Create And Delete An Comparison */ 
			objComparisonPage.createAndDeleteComparison(ComName,ControlSetName,entity,searchTextInControl);
//			objComparisonPage.createAndDeleteComparison("Delete Com1", "Control Set", "Disease","kera");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchTextInControl = ComParameters[3].trim();
			String mailIDtoShareto = ComParameters[4].trim();
			
			/* Create And Share An Comparison */ 
			objComparisonPage.createAndShareComparison(ComName, ControlSetName,entity,searchTextInControl,mailIDtoShareto);
//			objComparisonPage.createAndShareComparison("Share Com1", "Control Set","Disease","kera","mugunth.raman@eaglegenomics.com");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim();
			
			/* Delete A Comparison */
			objComparisonPage.DeleteComparison(ComName);
//			objComparisonPage.DeleteComparison("search Comparison");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim();
			String mailIDtoShareto = ComParameters[1].trim();
			
			/* Share A Comparison */
			objComparisonPage.ShareComparison(ComName,mailIDtoShareto);
//			objComparisonPage.ShareComparison("ComAddfromFile 1","mugunth.raman@eaglegenomics.com");
			onSuccessMeassage("Shared A Comparison Successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objComparisonPage.captureScreenshot("ShareComparisonFail");
			onFailureMeassage(ex.getMessage(),"ShareComparisonFail","ShareComparisonFail");
		}
	}

		@Test(priority = 19, description = "Remove items from Comparison Expand")
		public void RemoveItemsfromComparison_Test() throws Throwable  {
			try {
				
				String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
				
				System.out.println(functionName);
				String value = this.getConfiguration().get(functionName);
				String[] ComParameters =value.split(",");
				String ComName = ComParameters[0].trim()+dtText;
				String ControlSetName = ComParameters[1].trim();
				String entity = ComParameters[2].trim();
				String searchTextInControl = ComParameters[3].trim();
				String removeItem1 = ComParameters[4].trim();
				String removeItem2 = ComParameters[5].trim();
				String removeItem3 = ComParameters[6].trim();
				
				/* Remove items in Expanded Set */
				objComparisonPage.RemoveItemsfromComparison(ComName,ControlSetName ,entity,searchTextInControl,removeItem1,removeItem2,removeItem3);
//				objComparisonPage.RemoveItemsfromComparison("Remove Item Comparison","Control Set" ,"Gene","asph", "72112780","20981360","147670524");
				onSuccessMeassage("Items removed successfully in Comparison Expand");
			}
			catch(Exception ex)
			{
				objComparisonPage.captureScreenshot("ComparisonItemsRemoveFail");
				onFailureMeassage(ex.getMessage(),"ComparisonItemsRemoveFail","ComparisonItemsRemoveFail");
			}
			catch(AssertionError ex)
			{
				objComparisonPage.captureScreenshot("ComparisonItemsRemoveFail");
				onFailureMeassage(ex.getMessage(),"ComparisonItemsRemoveFail","ComparisonItemsRemoveFail");
			}
		}

	@Test(priority = 20, description = "Interchange Control and Case sets in the Comparison")
	public void ChangeControlAndCase_Test() throws Throwable {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String CaseSetName = ComParameters[2].trim();
			String entity = ComParameters[3].trim();
			String searchTextInControl = ComParameters[4].trim();
			String searchTextInCase = ComParameters[5].trim();
			
			/* Changes the Control and Case in Comparison */	
			objComparisonPage.ChangeControlAndCase(ComName, ControlSetName,CaseSetName ,entity,searchTextInControl,searchTextInCase);
//			objComparisonPage.ChangeControlAndCase("Control and Case Change", "Control Set ","Case Set" ,"Disease", "kera", "dol");
			onSuccessMeassage("Comparison is Created Successfully with Control Card");
		}
		catch(Throwable ex)
		{
			objComparisonPage.captureScreenshot("changeControlAndCaseFail");
			onFailureMeassage(ex.getMessage(),"changeControlAndCaseFail","changeControlAndCaseFail");
		}
	}
	
	@Test(priority = 21, description = "Sorting a column in a Comparison")
	public void SortColumnComparison_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchText = ComParameters[3].trim();
			String sortColumn = ComParameters[4].trim();
			
			/* Sorting column in a Exploration */
			objComparisonPage.SortColumnInComparison(ComName,ControlSetName ,entity,searchText,sortColumn);
//			objComparisonPage.SortColumnInComparison("SortComparison","ControlSet" , "Disease", "Kera", "EFO Name");
			onSuccessMeassage("Column in Comparison Sorted Successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objComparisonPage.captureScreenshot("SortColumnComparisonFail");
			onFailureMeassage(ex.getMessage(),"SortColumnComparisonFail","SortColumnComparisonFail");
		}
	}
	
	@Test(priority = 22, description = "Filtering a Comparison with one filter")
	public void FilterComparison_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchText = ComParameters[3].trim();
			String filterAttribute1 = ComParameters[4].trim();
			String filterType1 = ComParameters[5].trim();
			String filterValue1 = ComParameters[6].trim();
			
			/* Filtering in a Comparison */
			objComparisonPage.FilterComparison(ComName, ControlSetName, entity,searchText,filterAttribute1,filterType1,filterValue1);
//			objComparisonPage.FilterComparison("Filter Comparison1", "Control Set", "Disease","kera", "EFO Name","contains","vul");
			onSuccessMeassage("Filtering done in Exploration Successfully for 1 filter");
		}
		catch(Throwable ex)
		{
			objComparisonPage.captureScreenshot("FilterComaprisonFail");
			onFailureMeassage(ex.getMessage(),"FilterExplorationFail","FilterExplorationFail");
		}
	}
	
	@Test(priority = 23, description = "Filtering a Comparison with 2 filters")
	public void FilterMultiComparison_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] ComParameters =value.split(",");
			String ComName = ComParameters[0].trim()+dtText;
			String ControlSetName = ComParameters[1].trim();
			String entity = ComParameters[2].trim();
			String searchText = ComParameters[3].trim();
			String filterAttribute1 = ComParameters[4].trim();
			String filterType1 = ComParameters[5].trim();
			String filterValue1 = ComParameters[6].trim();
			String filterAttribute2 = ComParameters[7].trim();
			String filterType2 = ComParameters[8].trim();
			String filterValue2 = ComParameters[9].trim();
			
			/* Filtering in a Comparison with multiple filter */
			objComparisonPage.FilterComparisonMulti(ComName,ControlSetName,entity,searchText, filterAttribute1,filterType1,filterValue1,filterAttribute2,filterType2,filterValue2);
//			objComparisonPage.FilterComparisonMulti("Filter Comparison Multi 1","Control Set","Disease","kera", "EFO Name","contains","vul", "EFO ID", "equals","EFO_1000778");
			onSuccessMeassage("Filtering done in Exploration Successfully for multiple filters");
		}
		catch(Throwable ex)
		{
			objComparisonPage.captureScreenshot("FilterComparisonMulltiFail");
			onFailureMeassage(ex.getMessage(),"FilterComparisonMulltiFail","FilterComparisonMulltiFail");
		}
	}

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

