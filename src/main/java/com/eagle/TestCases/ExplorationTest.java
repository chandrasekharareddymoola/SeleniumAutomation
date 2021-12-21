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
import com.eagle.pages.ExplorationPage;

public class ExplorationTest extends BaseTest{

	ExplorationPage objExplorationPage;
	
	Date dt = new Date();
	DateFormat dtFrmt = new SimpleDateFormat("_HHmmss");
	String dtText = dtFrmt.format(dt);

	@BeforeClass
	public void beforeClass() throws AWTException, InterruptedException  {	
		objExplorationPage = new ExplorationPage();		
	}

	@Test(priority = 0, description = "Create Exploration From Search")
	public void CreateExplorationFromSearch_Test() throws Throwable {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			
			/* Creates an Exploration From Search */		
			objExplorationPage.createExplorationFromSearch(ExpName, entity, searchText);
//			objExplorationPage.createExplorationFromSearch("ExSearch 1", "Disease", "kera");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String BaseSetName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchTextInSet = expParameters[2].trim();
			String ExpName = expParameters[3].trim()+dtText;

			
			/* Creates an Exploration From Search - Initial */		
			objExplorationPage.createExplorationInitallyFromSet(BaseSetName, entity, searchTextInSet, ExpName);
//			objExplorationPage.createExplorationInitallyFromSet("SetAdd 1", "Disease", "kera", "ExDirect From Set 1");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String BaseSetName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchTextInSet = expParameters[2].trim();
			String ExpName = expParameters[3].trim()+dtText;
			
			/* Creates an Exploration From Set - After Search */
			objExplorationPage.CreateExplorationFromSet(BaseSetName,entity,searchTextInSet, ExpName);
//			objExplorationPage.CreateExplorationFromSet("SetAdd 2", "Disease", "kera", "ExFrom Set 2");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String fileLocation = expParameters[2].trim();

			
			/* Creates an Exploration From File - After Search */
			objExplorationPage.CreateExplorationFromFile(ExpName, entity,fileLocation);
//			objExplorationPage.CreateExplorationFromFile("ExFileUpload", "Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String searchInExpand = expParameters[3].trim();

			
			/* To Search a Text in Expanded Exploration */
			objExplorationPage.searchInExplorationExpand(ExpName,entity,searchText,searchInExpand);
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			
			/* Delete Set from Expanded Set */
			objExplorationPage.DeleteExploraionInExpand(ExpName, entity, searchText);
//			objExplorationPage.DeleteExploraionInExpand("DExploration2", "Disease", "kera");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			
			/* Delete The first Card in Exploration */
			objExplorationPage.deleteExplorationInFirstCard(ExpName, entity, searchText);
//			objExplorationPage.deleteExplorationInFirstCard("DExploration1Card", "Disease", "kera");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String relationCardEntity = expParameters[3].trim();
			
			/* Delete The Second Card in Exploration */
			objExplorationPage.deleteExplorationInLaterCard(ExpName,entity,searchText,relationCardEntity);
//			objExplorationPage.deleteExplorationInLaterCard("DExploration2Card", "Disease", "kera","Gene");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String searchTextInCatalog = expParameters[3].trim();
			
			/* Set - Expand and add items from Catalog */
			objExplorationPage.ExpandAddFromCatalog(ExpName, entity, searchText,searchTextInCatalog);
//			objExplorationPage.ExpandAddFromCatalog("ExpAddFromCatalog", "Disease", "aber", "dengue");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String BasesetName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchTextInSet = expParameters[2].trim();
			String ExpName = expParameters[3].trim()+dtText;
			String searchTextInExp = expParameters[4].trim();

			
			/* Exploration - Expand and add items from Set */
			objExplorationPage.ExpandAddFromSet(BasesetName, entity,searchTextInSet, ExpName, searchTextInExp); 
//			objExplorationPage.ExpandAddFromSet("SetAdd 1", "Disease", "leukocytes", "ExpAddFromSet", "aber" ); 
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String fileUploadEntity = expParameters[3].trim();
			String fileLocation = expParameters[4].trim();
			String fileName = expParameters[5].trim();
			
			/* Exploration - Expand and add items from File */
			objExplorationPage.ExpandAddFromFile(ExpName,entity,searchText,fileUploadEntity, fileLocation,fileName);
//			objExplorationPage.ExpandAddFromFile("ExpAddfromFile 1","Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String RelationCardEntity = expParameters[3].trim();
			
			/* Exploration - Create with one additional relation Card */
			objExplorationPage.createRelationCardFirst(ExpName,entity,searchText,RelationCardEntity);
//			objExplorationPage.createRelationCardFirst("ExpRela 1", "Disease", "kera", "Gene");
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

	@Test(priority = 12, description = "Exploration - Create with 2 additional relation Card")
	public void ExplorationCreateTwoRelationCard_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String Relation1CardEntity = expParameters[3].trim();
			String Relation2CardEntity = expParameters[4].trim();
			String NoOfItemsToSelectInRelation1card = expParameters[5].trim();
			
			/* Exploration - Create with 2 additional relation Cards */
			objExplorationPage.createRelationCardMulti(ExpName, entity,searchText,Relation1CardEntity,Relation2CardEntity,NoOfItemsToSelectInRelation1card);
//			objExplorationPage.createRelationCardMulti("ExpRela 2", "Disease", "kera", "Gene","SNP","5");
			onSuccessMeassage("Exploration Created and added with 2 relation Cards Successfully");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationAdd2RelationFail");
			onFailureMeassage(ex.getMessage(),"ExplorationAdd2RelationFail","ExplorationAdd2RelationFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("ExplorationAdd2RelationFail");
			onFailureMeassage(ex.getMessage(),"ExplorationAdd2RelationFail","ExplorationAdd2RelationFail");
		}
	}

	@Test(priority = 13, description = "Create And Delete An Exploration")
	public void CreateAndDeleteExploration_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();

			/* Create And Delete An Exploration */
			objExplorationPage.createAndDeleteExploration(ExpName,entity,searchText);
//			objExplorationPage.createAndDeleteExploration("Delete Exp1","Disease","kera");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String mailIDtoShareto = expParameters[3].trim();
			
			/* Create And Share An Exploration */
			objExplorationPage.createAndShareExploration(ExpName,entity,searchText,mailIDtoShareto);
//			objExplorationPage.createAndShareExploration("Share Exp1","Disease","kera","mugunth.raman@eaglegenomics.com");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim();
			
			/* Delete An Exploration */
			objExplorationPage.DeleteExploration(ExpName);
//			objExplorationPage.DeleteExploration("ExpAddFromSet");
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
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim();
			String mailIDtoShareto = expParameters[1].trim();
			
			/* Share An Exploration */
			objExplorationPage.ShareExploration(ExpName,mailIDtoShareto);
//			objExplorationPage.ShareExploration("ExSearch 1","mugunth.raman@eaglegenomics.com");
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

	@Test(priority = 17, description = "Remove items from Exploration Expand")
	public void RemoveItemsfromExploration_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String removeItems1 = expParameters[3].trim();
			String removeItems2 = expParameters[4].trim();
			String removeItems3 = expParameters[5].trim();

			/* Remove items in Expanded Set */
			objExplorationPage.RemoveItemsfromExploration(ExpName,entity,searchText,removeItems1,removeItems2,removeItems3);
//			objExplorationPage.RemoveItemsfromExploration("Remove Item Exploration","RNA","asb","AL160411.1","AC060814.4","AL022100.1");
			onSuccessMeassage("Items removed successfully in Exploration Expand");
		}
		catch(Exception ex)
		{
			objExplorationPage.captureScreenshot("ExplorationItemsRemoveFail");
			onFailureMeassage(ex.getMessage(),"ExplorationItemsRemoveFail","ExplorationItemsRemoveFail");
		}
		catch(AssertionError ex)
		{
			objExplorationPage.captureScreenshot("ExplorationItemsRemoveFail");
			onFailureMeassage(ex.getMessage(),"ExplorationItemsRemoveFail","ExplorationItemsRemoveFail");
		}
	}

	@Test(priority = 18, description = "Sorting a column in an Exploration")
	public void SortColumnExploration_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String sortColumn = expParameters[3].trim();
			
			/* Sorting column in a Exploration */
			objExplorationPage.SortColumnInExploration(ExpName, entity, searchText,sortColumn);
//			objExplorationPage.SortColumnInExploration("SortExploration", "Disease", "Kera", "EFO Name");
			onSuccessMeassage("Column in Exploration Sorted Successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objExplorationPage.captureScreenshot("SortColumnExplorationFail");
			onFailureMeassage(ex.getMessage(),"SortColumnExplorationFail","SortColumnExplorationFail");
		}
	}

	@Test(priority = 19, description = "Filtering an Exploration with one filter")
	public void FilterExploration_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String filterAttribute = expParameters[3].trim();
			String filterType = expParameters[4].trim();
			String filterValue = expParameters[5].trim();
			
			/* Filtering in an Exploration */
			objExplorationPage.FilterExploration(ExpName,entity,searchText,filterAttribute,filterType,filterValue);
//			objExplorationPage.FilterExploration("Filter Exploration1","Disease","kera", "EFO Name","contains","vul");
			onSuccessMeassage("Filtering done in Exploration Successfully for 1 filter");
		}
		catch(Throwable ex)
		{
			objExplorationPage.captureScreenshot("FilterExplorationFail");
			onFailureMeassage(ex.getMessage(),"FilterExplorationFail","FilterExplorationFail");
		}
	}

	@Test(priority = 20, description = "Filtering an Exploration with 2 filters")
	public void FilterMultiExploration_Test() throws Throwable  {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] expParameters =value.split(",");
			String ExpName = expParameters[0].trim()+dtText;
			String entity = expParameters[1].trim();
			String searchText = expParameters[2].trim();
			String filterAttribute1 = expParameters[3].trim();
			String filterType1 = expParameters[4].trim();
			String filterValue1 = expParameters[5].trim();
			String filterAttribute2 = expParameters[6].trim();
			String filterType2 = expParameters[7].trim();
			String filterValue2 = expParameters[8].trim();
			
			/* Filtering in an Exploration with multiple filter */
			objExplorationPage.FilterExplorationMulti(ExpName,entity,searchText,filterAttribute1,filterType1,filterValue1, filterAttribute2,filterType2,filterValue2);
//			objExplorationPage.FilterExplorationMulti("Filter Exploration Multi 1","Disease","kera", "EFO Name","contains","vul", "EFO ID", "equals","EFO_1000778");
			onSuccessMeassage("Filtering done in Exploration Successfully for multiple filters");
		}
		catch(Throwable ex)
		{
			objExplorationPage.captureScreenshot("FilterExplorationMulltiFail");
			onFailureMeassage(ex.getMessage(),"FilterExplorationMulltiFail","FilterExplorationMulltiFail");
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
