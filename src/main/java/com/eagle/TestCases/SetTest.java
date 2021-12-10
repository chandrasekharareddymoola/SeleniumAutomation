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
import com.eagle.pages.SetPage;

public class SetTest extends BaseTest{

	//	LoginPage objLogin;
	SetPage objSetPage; 

	Date dt = new Date();
	DateFormat dtFrmt = new SimpleDateFormat("dd-MMM-yyyy-HH:mm:ss");
	String dtText = dtFrmt.format(dt);
	
	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException, AWTException  {	
		objSetPage = new SetPage();	
		//		objLogin = new LoginPage();
		//		objLogin.loginTo();
	}

	//	public void main() throws InterruptedException, IOException  {	
	//		objSetPage = new SetPage();	
	//		objLogin = new LoginPage();
	//		objLogin.loginTo();
	//		objSetPage.RemoveItemsfromSet("Remove Item Set","Disease","Kera");
	//	}

	@Test(priority = 0, description = "Create Set")
	public void CreateSet_Test() throws Throwable {
		try {
			
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			
			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] invParameters =value.split(",");
			String setName = invParameters[0].trim()+dtText;
			String entity = invParameters[1].trim();
			String searchText = invParameters[2].trim();
			
			/* To initiate the creation of Set */	
			objSetPage.createSet(setName,entity,searchText);	
//			objSetPage.createSet("Create Set1","Disease","kera");	
			onSuccessMeassage("Set is successfully created");
		}
		catch(Exception ex)
		{
			objSetPage.captureScreenshot("createSetFail");
			onFailureMeassage(ex.getMessage(),"createSetFail","createSetFail");
		}
		catch(AssertionError ex)
		{
			objSetPage.captureScreenshot("createSetFail");
			onFailureMeassage(ex.getMessage(),"createSetFail","createSetFail");
		}
	}

//	@Test(priority = 1, description = "View Set")
//	public void ViewSet_Test() throws InterruptedException, IOException  {
//		try {
//			/* To view the Investigation */
//			objSetPage.viewSet("Share Set1");
//			onSuccessMeassage("Set is successfully opened");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("viewSetFail");
//			onFailureMeassage(ex.getMessage(),"viewSetFail","viewSetFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("viewSetFail");
//			onFailureMeassage(ex.getMessage(),"viewSetFail","viewSetFail");
//		}
//	}
//
//	@Test(priority = 2, description = "Create Set From File")
//	public void CreateSetFromFile_Test() throws Throwable  {
//		try {
//			/* To Create a Set From File */
//			objSetPage.CreateSetFromFile("Set From File 1","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
//			onSuccessMeassage("Set is successfully Created from File");
//		}
//		catch(Exception ecf)
//		{
//			objSetPage.captureScreenshot("createSetFromFileFail");
//			onFailureMeassage(ecf.getMessage(),"createSetFromFileFail","createSetFromFileFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("createSetFromFileFail");
//			onFailureMeassage(ex.getMessage(),"createSetFromFileFail","createSetFromFileFail");
//		}
//	}
//
//	@Test(priority = 3, description = "Create Set From Another Set")
//	public void CreateSetFromSet_Test() throws Throwable  {
//		try {
//			/* To Create a Set From Another Set */
//			objSetPage.CreateSetFromSet("Base Set 1","Disease","Kera","Set From Set 1"); 
//			onSuccessMeassage("Set is successfully Created from Another Set");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("createSetFromSetFail");
//			onFailureMeassage(ex.getMessage(),"createSetFromSetFail","createSetFromSetFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("createSetFromSetFail");
//			onFailureMeassage(ex.getMessage(),"createSetFromSetFail","createSetFromSetFail");
//		}
//	}
//
//	@Test(priority = 4, description = "Search A Text In Set Expand")
//	public void SearchInSetExpand_Test() throws Throwable  {
//		try {
//			/* To Search a Text in Expanded Set */
//			objSetPage.searchInSetExpand("Search Set 1","Disease","Kera","le");
//			onSuccessMeassage("Search successful in Set Expand");
//		}
//		catch(Exception es)
//		{
//			objSetPage.captureScreenshot("SearchInSetExpandFail");
//			onFailureMeassage(es.getMessage(),"SearchInSetExpandFail","SearchInSetExpandFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("SearchInSetExpandFail");
//			onFailureMeassage(ex.getMessage(),"SearchInSetExpandFail","SearchInSetExpandFail");
//		}
//	}
//
//	@Test(priority = 5, description = "Set - Expand and add items from Catalog")
//	public void SetExpandAddFromCatalog_Test() throws Throwable  {
//		try {
//			/* Set - Expand and add items from Catalog */
//			objSetPage.ExpandAddFromCatalog("Set From Catalog 1","Disease","Kera","migraine");
//			objSetPage.saveChanges();
//			onSuccessMeassage("Items Added from Catalog into Set successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("SetExpandAddFromCatalogFail");
//			onFailureMeassage(ex.getMessage(),"SetExpandAddFromCatalogFail","SetExpandAddFromCatalogFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("SetExpandAddFromCatalogFail");
//			onFailureMeassage(ex.getMessage(),"SetExpandAddFromCatalogFail","SetExpandAddFromCatalogFail");
//		}
//	}
//
//	@Test(priority = 6, description = "Set - Expand and add items from Set")
//	public void SetExpandAddFromSet_Test() throws Throwable  {
//		try {
//			/* Set - Expand and add items from Set */
//			objSetPage.ExpandAddFromSet("Base Set 2","Disease","leukocytes","Set Add Set expand 1", "Kera");
//			objSetPage.saveChanges();
//			onSuccessMeassage("Items Added from Set into another Set successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("SetExpandAddFromSetFail");
//			onFailureMeassage(ex.getMessage(),"SetExpandAddFromSetFail","SetExpandAddFromSetFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("SetExpandAddFromSetFail");
//			onFailureMeassage(ex.getMessage(),"SetExpandAddFromSetFail","SetExpandAddFromSetFail");
//		}
//	}
//
//	@Test(priority = 7, description = "Set - Expand and add items from File")
//	public void SetExpandAddFromFile_Test() throws Throwable  {
//		try {
//			/* Set - Expand and add items from File */
//			objSetPage.ExpandAddFromFile("ESFile 1","Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
//			objSetPage.saveChanges();
//			onSuccessMeassage("Items Added from File into Set successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("SetExpandAddFromFileFail");
//			onFailureMeassage(ex.getMessage(),"SetExpandAddFromFileFail","SetExpandAddFromFileFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("SetExpandAddFromFileFail");
//			onFailureMeassage(ex.getMessage(),"SetExpandAddFromFileFail","SetExpandAddFromFileFail");
//		}
//	}
//
//	@Test(priority = 8, description = "Delete Card in Set Expand")
//	public void DeleteCardInSetExpand_Test() throws Throwable  {
//		try {
//			/* Delete Set from Expanded Set */
//			objSetPage.DeleteCardInExpand("DeleteCard 1","Disease","kera");
//			onSuccessMeassage("Delete Card from Expanded Set");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("DeleteSetInExpandFail");
//			onFailureMeassage(ex.getMessage(),"DeleteSetInExpandFail","DeleteSetInExpandFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("DeleteSetInExpandFail");
//			onFailureMeassage(ex.getMessage(),"DeleteSetInExpandFail","DeleteSetInExpandFail");
//		}
//	}
//
//	@Test(priority = 9, description = "Remove items from Set Expand")
//	public void RemoveItemsfromSet_Test() throws Throwable  {
//		try {
//			/* Remove items in Expanded Set */
//			objSetPage.RemoveItemsfromSet("Remove Item Set","Disease","sulf");
//			onSuccessMeassage("Items removed successfully in Set Expand");
//		}
//		catch(Exception | AssertionError ex)
//		{
//			objSetPage.captureScreenshot("SetItemsRemoveFail");
//			onFailureMeassage(ex.getMessage(),"SetItemsRemoveFail", "SetItemsRemoveFail");
//		}
//	}
//
//	@Test(priority = 10, description = "Modify Grid Settings in Set Expand")
//	public void GridChangesInSet_Test() throws Throwable  {
//		try {
//			/* Modify Grid Settings in Set Expand */
//			objSetPage.GridChanges("GridSet", "Disease", "Kera", "10", "Definition", "Identifier");
//			onSuccessMeassage("Grid Settings are Modified Successfully in Set Expand");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("GridChangesInSetFail");
//			onFailureMeassage(ex.getMessage(),"GridChangesInSetFail","GridChangesInSetFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("GridChangesInSetFail");
//			onFailureMeassage(ex.getMessage(),"GridChangesInSetFail","GridChangesInSetFail");
//		}
//	}
//
//	@Test(priority = 11, description = "Create And Delete A Set")
//	public void CreateAndDeleteSet_Test() throws Throwable  {
//		try {
//			/* Create And Delete A Set */
//			objSetPage.createAndDeleteSet("Delete Set1","Disease","kera");
//			onSuccessMeassage("Created And Deleted A Set Successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("CreateAndDeleteSetFail");
//			onFailureMeassage(ex.getMessage(),"CreateAndDeleteSetFail","CreateAndDeleteSetFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("CreateAndDeleteSetFail");
//			onFailureMeassage(ex.getMessage(),"CreateAndDeleteSetFail","CreateAndDeleteSetFail");
//		}
//	}
//
//	@Test(priority = 12, description = "Create And Share A Set")
//	public void CreateAndShareSet_Test() throws Throwable  {
//		try {
//			/* Create And Share A Set */
//			objSetPage.createAndShareSet("Share Set1","Disease","kera","mugunth.raman@eaglegenomics.com");
//			onSuccessMeassage("Created And Shared A Set Successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("CreateAndShareSetFail");
//			onFailureMeassage(ex.getMessage(),"CreateAndShareSetFail","CreateAndShareSetFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("CreateAndShareSetFail");
//			onFailureMeassage(ex.getMessage(),"CreateAndShareSetFail","CreateAndShareSetFail");
//		}
//	}
//
//	@Test(priority = 13, description = "Deleting A Set")
//	public void DeleteSet_Test() throws InterruptedException, IOException  {
//		try {
//			/* Delete An Existing Set */
//			objSetPage.DeleteSet("Create Set1");
//			onSuccessMeassage("Deleted A Set Successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("DeleteSetFail");
//			onFailureMeassage(ex.getMessage(),"DeleteSetFail","DeleteSetFail");
//		}
//		catch(AssertionError ex)
//		{
//			objSetPage.captureScreenshot("DeleteSetFail");
//			onFailureMeassage(ex.getMessage(),"DeleteSetFail","DeleteSetFail");
//		}
//	}
//
//	@Test(priority = 14, description = "Sharing A Set")
//	public void ShareSet_Test() throws Throwable  {
//		try {
//			/* Sharing An Existing Set */
//			objSetPage.ShareSet("GridSet","mugunth.raman@eaglegenomics.com");
//			onSuccessMeassage("Shared A Set Successfully");
//		}
//		catch(Exception | AssertionError ex)
//		{
//			objSetPage.captureScreenshot("ShareSetFail");
//			onFailureMeassage(ex.getMessage(),"ShareSetFail","ShareSetFail");
//		}
//	}
//
//	@Test(priority = 15, description = "Sorting a column in a Set")
//	public void SortColumnSet_Test() throws Throwable  {
//		try {
//			/* Sorting column in a set */
//			objSetPage.SortColumnInSet("SortSet", "Disease", "pero", "EFO Name");
//			onSuccessMeassage("Column in Set Sorted Successfully");
//		}
//		catch(Throwable ex)
//		{
//			objSetPage.captureScreenshot("SortColumnSetFail");
//			onFailureMeassage(ex.getMessage(),"SortColumnSetFail","SortColumnSetFail");
//		}
//	}
//	
//	
//	@Test(priority = 16, description = "Filtering a set with one filter")
//	public void FilterSet_Test() throws Throwable  {
//		try {
//			/* Filtering in a set */
//			objSetPage.FilterSet("Filter Set1","Disease","kera", "EFO Name","contains","vul");
//			onSuccessMeassage("Filtering done in Set Successfully for 1 filter");
//		}
//		catch(Throwable ex)
//		{
//			objSetPage.captureScreenshot("FilterSetFail");
//			onFailureMeassage(ex.getMessage(),"FilterSetFail","FilterSetFail");
//		}
//	}
//	
//	@Test(priority = 17, description = "Filtering a set with 2 filters")
//	public void FilterMultiSet_Test() throws Throwable  {
//		try {
//			/* Filtering in a set with multiple filter */
//			objSetPage.FilterSetMulti("Filter Set Multi 1","Disease","kera", "EFO Name","contains","vul", "EFO ID", "equals","EFO_1000778");
//			onSuccessMeassage("Filtering done in Set Successfully for multiple filters");
//		}
//		catch(Throwable ex)
//		{
//			objSetPage.captureScreenshot("FilterSetMulltiFail");
//			onFailureMeassage(ex.getMessage(),"FilterSetMulltiFail","FilterSetMulltiFail");
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

