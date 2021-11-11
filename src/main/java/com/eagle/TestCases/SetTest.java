package com.eagle.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.LoginPage;
import com.eagle.pages.SetPage;

public class SetTest extends BaseTest{

	LoginPage objLogin;
	SetPage objSetPage; 
	
	

//	@BeforeClass
//	public void beforeClass() throws InterruptedException, IOException  {	
//		objSetPage = new SetPage();	
//		objLogin = new LoginPage();
//		objLogin.loginTo();
//	}
	
	public void main() throws InterruptedException, IOException  {	
		objSetPage = new SetPage();	
		objLogin = new LoginPage();
		objLogin.loginTo();
		objSetPage.RemoveItemsfromSet();
	}
	
//	@Test(priority = 0, description = "Create Set")
//	public void CreateSet_Test() throws InterruptedException, IOException {
//		try {
//			/* To initiate the creation of Set */		 
//			objSetPage.createSet("Create Set1","Disease","kera");	
//			onSuccessMeassage("Set is successfully created");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("createSetFail");
//			onFailreMeassage(ex.getMessage(),"createSetFail");
//		}
//	}
//	
//	@Test(priority = 1, description = "View Set")
//	public void ViewInvestigation_Test() throws InterruptedException, IOException  {
//		try {
//			 /* To view the Investigation */
//			objSetPage.viewSet("Set1");
//			onSuccessMeassage("Set is successfully opened");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("viewSetFail");
//			onFailreMeassage(ex.getMessage(),"viewSetFail");
//		}
//	}
//	
//	@Test(priority = 2, description = "Create Set From File")
//	public void CreateSetFromFile_Test() throws InterruptedException, IOException  {
//		try {
//			 /* To Create a Set From File */
//			objSetPage.CreateSetFromFile("Set From File 1","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
//			onSuccessMeassage("Set is successfully Created from File");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("createSetFromFileFail");
//			onFailreMeassage(ex.getMessage(),"createSetFromFileFail");
//		}
//	}
//	
//	@Test(priority = 3, description = "Create Set From Another Set")
//	public void CreateSetFromSet_Test() throws InterruptedException, IOException  {
//		try {
//			 /* To Create a Set From Another Set */
//			objSetPage.CreateSetFromSet("Base Set 1","Disease","Kera","Set From Set 1"); 
//			onSuccessMeassage("Set is successfully Created from Another Set");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("createSetFromSetFail");
//			onFailreMeassage(ex.getMessage(),"createSetFromSetFail");
//		}
//	}
//	
//	@Test(priority = 4, description = "Search A Text In Set Expand")
//	public void SearchInSetExpand_Test() throws InterruptedException, IOException  {
//		try {
//			 /* To Search a Text in Expanded Set */
//			objSetPage.searchInSetExpand("Search Set 1","Disease","Kera","le");
//			onSuccessMeassage("Search successful in Set Expand");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("SearchInSetExpandFail");
//			onFailreMeassage(ex.getMessage(),"SearchInSetExpandFail");
//		}
//	}
//	
//	@Test(priority = 6, description = "Set - Expand and add items from Catalog")
//	public void SetExpandAddFromCatalog_Test() throws InterruptedException, IOException  {
//		try {
//			/* Set - Expand and add items from Catalog */
//			objSetPage.ExpandAddFromCatalog("Set From Catalog 1","Disease","Kera","migraine");
//			objSetPage.saveChanges();
//			onSuccessMeassage("Items Added from Catalog into Set successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("SetExpandAddFromCatalogFail");
//			onFailreMeassage(ex.getMessage(),"SetExpandAddFromCatalogFail");
//		}
//	}
//	
//	@Test(priority = 7, description = "Set - Expand and add items from Set")
//	public void SetExpandAddFromSet_Test() throws InterruptedException, IOException  {
//		try {
//			/* Set - Expand and add items from Set */
//			objSetPage.ExpandAddFromSet("Base Set 2","Disease","dol","Set Add Set expand 1", "Kera");
//			objSetPage.saveChanges();
//			onSuccessMeassage("Items Added from Set into another Set successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("SetExpandAddFromSetFail");
//			onFailreMeassage(ex.getMessage(),"SetExpandAddFromSetFail");
//		}
//	}
//	
//	@Test(priority = 8, description = "Set - Expand and add items from File")
//	public void SetExpandAddFromFile_Test() throws InterruptedException, IOException  {
//		try {
//			/* Set - Expand and add items from File */
//			objSetPage.ExpandAddFromFile("ESFIle 1","Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
//			objSetPage.saveChanges();
//			onSuccessMeassage("Items Added from File into Set successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("SetExpandAddFromFileFail");
//			onFailreMeassage(ex.getMessage(),"SetExpandAddFromFileFail");
//		}
//	}
//	
//	@Test(priority = 9, description = "Delete Card in Set Expand")
//	public void DeleteCardInSetExpand_Test() throws InterruptedException, IOException  {
//		try {
//			/* Delete Set from Expanded Set */
//			objSetPage.DeleteCardInExpand("DeleteCard 1","Disease","kera");
//			onSuccessMeassage("Delete Card from Expanded Set");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("DeleteSetInExpandFail");
//			onFailreMeassage(ex.getMessage(),"DeleteSetInExpandFail");
//		}
//	}
	
	@Test(priority = 10, description = "Remove items from Set Expand")
	public void RemoveItemsfromSet_Test() throws InterruptedException, IOException  {
		try {
			/* Remove items in Expanded Set */
			objSetPage.RemoveItemsfromSet();
			onSuccessMeassage("Items removed successfully in Set Expand");
		}
		catch(Exception ex)
		{
			objSetPage.captureScreenshot("SetItemsRemoveFail");
			onFailreMeassage(ex.getMessage(),"SetItemsRemoveFail");
		}
	}

//	@Test(priority = 11, description = "Modify Grid Settings in Set Expand")
//	public void GridChangesInSet_Test() throws InterruptedException, IOException  {
//		try {
//			/* Modify Grid Settings in Set Expand */
//			objSetPage.GridChanges("GridSet", "Disease", "Kera", "10", "Definition", "Identifier");
//			onSuccessMeassage("Grid Settings are Modified Successfully in Set Expand");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("GridChangesInSetFail");
//			onFailreMeassage(ex.getMessage(),"GridChangesInSetFail");
//		}
//	}
//
//	@Test(priority = 12, description = "Create And Delete A Set")
//	public void CreateAndDeleteSet_Test() throws InterruptedException, IOException  {
//		try {
//			/* Create And Delete A Set */
//			objSetPage.createAndDeleteSet("Delete Set1","Disease","kera");
//			onSuccessMeassage("Created And Deleted A Set Successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("CreateAndDeleteSetFail");
//			onFailreMeassage(ex.getMessage(),"CreateAndDeleteSetFail");
//		}
//	}
//
//	@Test(priority = 13, description = "Create And Share A Set")
//	public void CreateAndShareSet_Test() throws InterruptedException, IOException  {
//		try {
//			/* Create And Share A Set */
//			objSetPage.createAndShareSet("Share Set1","Disease","kera","mugunth.raman@eaglegenomics.com");
//			onSuccessMeassage("Created And Shared A Set Successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("CreateAndShareSetFail");
//			onFailreMeassage(ex.getMessage(),"CreateAndShareSetFail");
//		}
//	}
//	
//	@Test(priority = 14, description = "Deleting A Set")
//	public void DeleteSet_Test() throws InterruptedException, IOException  {
//		try {
//			/* Delete An Existing Set */
//			objSetPage.DeleteSet("Set Test Auto 1");
//			onSuccessMeassage("Deleted A Set Successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("DeleteSetFail");
//			onFailreMeassage(ex.getMessage(),"DeleteSetFail");
//		}
//	}
//
//	@Test(priority = 15, description = "Sharing A Set")
//	public void ShareSet_Test() throws InterruptedException, IOException  {
//		try {
//			/* Sharing An Existing Set */
//			objSetPage.ShareSet("GridSet","mugunth.raman@eaglegenomics.com");
//			onSuccessMeassage("Shared A Set Successfully");
//		}
//		catch(Exception ex)
//		{
//			objSetPage.captureScreenshot("ShareSetFail");
//			onFailreMeassage(ex.getMessage(),"ShareSetFail");
//		}
//	}
	
	
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

