package com.eagle.pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;

public class SetPage extends BasePage{

	//Page level objects

	@FindBy(xpath = "//i[@data-icon-name='Home']")
	public WebElement homeIcon;

	@FindBy(xpath = "//i[@data-icon-name='DocumentSet']")
	public WebElement setIcon;

	@FindBy(xpath = "//*[text()='Terms of Use']")
	public WebElement TermsOfUse;

	@FindBy(xpath = "(//*[@role='rowheader' and @aria-colindex=1])[1]/div")
	public WebElement FirstItem;

	@FindBy(xpath = "//div//span[contains(text(),'Set')]")
	public WebElement addSet;

	@FindBy(xpath = "//div[@scraper-tag='CardHeader']//span")
	public WebElement pageIdentifier;

	@FindBy(xpath = "//div//span[contains(text(),'Uncategorized')]")
	public WebElement entitySelection;

	@FindBy(xpath = "//div//input[@type='text']")
	public WebElement titleSet;

	@FindBy(xpath = "//button//span[contains(text(),'Disease')]")
	public WebElement entitySelected;	

	@FindBy(xpath = "//div//input[@role='searchbox']")
	public WebElement serachBox;

	@FindBy(xpath = "//div//input[@role='searchbox' and @placeholder='Search in this list...']")
	public WebElement serachBoxExpand;	

	@FindBy(xpath = "//button[@title='Add all items']")
	public WebElement addAll;	

	@FindBy(xpath = "//div//span[contains(text(),'Accept')]")
	public WebElement accept;	

	@FindBy(xpath = "//*[@class='ExpandedCardViewHeader__title___r34jA']")
	public WebElement setNameInExpand;	

	@FindBy(xpath = "//*[@class='ms-Dropdown-container']")
	public WebElement fileSelectDropdown;	

	@FindBy(xpath = "//*[text()='browse/upload']")
	public WebElement clickUpload;	

	@FindBy(xpath = "//*[text()='Searching in ']//parent::div//child::b")
	public WebElement uploadedFileName;	

	@FindBy(xpath = "//*[text()='Delete Card']")
	public WebElement deleteCardExpand;	

	@FindBy(xpath = "//*[@class='MyData__title___3ZcME']")
	public WebElement MyDataTitle;	

	@FindBy(xpath = "(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]")
	public WebElement NoOfPagesInSet;	

	@FindBy(xpath = "//*[@data-icon-name='Forward']")
	public WebElement NextPage;	

	@FindBy(xpath = "//*[text()='Apply']")
	public WebElement Apply;	

	@FindBy(xpath = "//*[text()='Share']")
	public WebElement ShareAction;	

	@FindBy(xpath = "//*[@placeholder='Select one or more users']")
	public WebElement ShareTextBox;	

	@FindBy(xpath = "//*[@type='button']//*[text()='Share']")
	public WebElement ShareButton;	

	@FindBy(xpath = "//*[text()='Resource shared successfully']")
	public WebElement ShareSuccess;	

	@FindBy(xpath = "//*[@data-icon-name='Edit']")
	public WebElement editCardIcon;	

	@FindBy(xpath = "//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']")
	public List<WebElement> SetGridItems;

	@FindBy(xpath = "//i[@data-icon-name='MiniExpand']")
	public WebElement expand;	

	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	public WebElement edit;	

	@FindBy(xpath = "//div[@class='TableRowDefault__bodyRow___1_m1h']//div[@class='TableRowDefault__td___39_xA'][1]")
	public List<WebElement> gridItems;

	@FindBy(xpath = "//span[contains(text(),'Remove Items')]")
	public WebElement remove;	

	@FindBy(xpath = "//*[text()='Save Changes']")
	public WebElement saveChanges;	

	@FindBy(xpath = "//i[@data-icon-name='Forward']")
	public WebElement forward;

	@FindBy(xpath = "//i[@data-icon-name='Back']")
	public WebElement backward;

	@FindBy(xpath = "//span[contains(text(),'Add items from a set')]")
	public WebElement addFromSet;	

	@FindBy(xpath = "//input[@type='file']")
	public WebElement fileUpload;	

	@FindBy(xpath = "//*[text()='Add Items']")
	public WebElement addItemsExpand;	

	@FindBy(xpath = "//*[text()='From a Set']")
	public WebElement addFromSetExpand;

	@FindBy(xpath = "//*[text()='From a file']")
	public WebElement addFromFile;

	@FindBy(xpath = "//*[text()='From the Catalog']")
	public WebElement addFromExpandCatalog;

	@FindBy(xpath = "//*[@placeholder='Search for a set']")
	public WebElement searchSetToAddExpand;

	@FindBy(xpath = "//*[text()='Close']")
	public WebElement close;

	@FindBy(xpath = "//*[@id='SetCardSearch-SearchBox']")
	public WebElement searchCatalog;

	@FindBy(xpath = "//*[text()='Cancel']")
	public WebElement cancel;

	@FindBy(xpath = "//*[text()='Add']")
	public WebElement Add;

	@FindBy(xpath = "//*[text()='Add To Grid']")
	public WebElement AddToGrid;

	@FindBy(xpath = "//*[text()='Delete']")
	public WebElement Delete;

	@FindBy(xpath = "//*[@data-icon-name='Settings']")
	public WebElement GridSettingsIcon;

	@FindBy(xpath = "//*[text()='Rows Per Page']//parent::div//following-sibling::div//div[@role='listbox']")
	public WebElement RowsPerPage;

	@FindBy(xpath = "//*[text()='Primary column']//parent::div//following-sibling::div//div[@role='listbox']")
	public WebElement PrimaryColumnDropdown;

	@FindBy(xpath = "//*[text()='Secondary column']//parent::div//following-sibling::div//div[@role='listbox']")
	public WebElement SecondaryColumnDropdown;

	@FindBy(xpath = "//*[@class='TableRowDefault__bodyRow___1_m1h']")
	public List <WebElement> RowsintableExpand;

	@FindBy(xpath = "(//*[@class='TableRowDefault__bodyRow___1_m1h'])[1]")
	public WebElement FirstRowintableExpand;

	@FindBy(xpath = "//button//span[contains(text(),'Delete')]")
	public WebElement deleteIcon;

	@FindBy(xpath = "//button//span[contains(text(),'Share')]")
	public WebElement shareIcon;

	@FindBy(xpath = "//*[@scraper-tag='HandleError' and text()='Fetch failed']")
	public WebElement fetchFailed;

	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement selectPersonToShare;

	@FindBy(xpath = "//div[contains(@class,'ms-PeoplePicker')]")
	public WebElement suggestedUsers;

	@FindBy(xpath = "//i[@data-icon-name='Share']")
	public WebElement share;

	@FindBy(xpath = "(//*[@class='ExpandedCardViewHeader__listCount___yQb2n']/span)[1]")
	public WebElement ItemCountInExpand;

	@FindBy(xpath = "(//span[@class='NameAndDescription__description___zAZrs'])[1]")
	public WebElement setNameInShare;

	@FindBy(xpath = "//*[@role='columnheader']")
	public WebElement columnHeaderFirstPage;

	@FindBy(xpath = "//*[@data-icon-name='Cancel']")
	public WebElement dialogBoxClose;

	@FindBy(xpath = "//*[@class='ms-List-cell']")
	public List <WebElement> ItemsInSet;

	@FindBy(xpath = "//*[@class='TableRowDefault__bodyRow___1_m1h']/child::div")
	public List <WebElement> EachElementInExpand;

	@FindBy(xpath = "//*[@class='CatalogSearchResults__itemName___1PfVJ']")
	public List <WebElement> ItemsInCatalog;

	@FindBy(xpath = "//*[@class='CatalogSearchResults__itemName___1PfVJ']")
	public List <WebElement> ItemsInFile;

	@FindBy(xpath = "//*[@data-automationid='DetailsList']")
	public WebElement FileDataList;

	@FindBy(xpath = "//*[@data-icon-name='Filter']")
	public WebElement FilterIconInExpand;

	@FindBy(xpath = "//*[text()='Edit filters']")
	public WebElement EditFilterText;

	@FindBy(xpath = "//*[@role='option' and text()='Select an attribute']")
	public WebElement SelectAnAttribute;

	@FindBy(xpath = "//*[@role='option' and text()='Select filter type']")
	public WebElement SelectFilterType;

	@FindBy(xpath = "(//*[@role='gridcell']//*[@type='text'])[1]")
	public WebElement valueForFilter;

	@FindBy(xpath = "(//*[@role='gridcell']//*[@type='text'])[2]")
	public WebElement valueForFilter2;

	@FindBy(xpath = "(//*[@data-icon-name='Add'])[1]")
	public WebElement AddFilter;

	@FindBy(xpath = "//*[text()='Done']")
	public WebElement DoneButton;

	@FindBy(xpath = "//*[text()='Nothing to show']")
	public WebElement notingToShowText;

	@FindBy(xpath = "//*[text()='An error occured. Please contact your administrator.']")
	public WebElement contactAdminErrorMainPage;



	//Page level functions on the objects
	WebDriverWait wait = new WebDriverWait(driver, 5);
	Actions action = new Actions(driver);

	public WebElement openSet(String name) {
		return this.driver.findElement(By.xpath("//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']//div[@title='"+ name +"']"));   		
	}

	public void Home() throws InterruptedException, AWTException{    	
		BasePage.click(homeIcon);
		action.moveToElement(TermsOfUse).perform();
	}   

	public SetPage() throws InterruptedException, AWTException{ 		 
		PageFactory.initElements(driver, this); 
		BasePage.click(setIcon);
		action.moveToElement(TermsOfUse).perform();
	}

	public void Set() throws InterruptedException, AWTException{ 	
		BasePage.click(setIcon);
		action.moveToElement(TermsOfUse).perform();
	}


	public void waitForSet() throws Throwable{	
		try {  
			boolean iden = true;
			Date dt = new Date();
			DateFormat dtFrmt = new SimpleDateFormat("_HHmmss");
			String dtText = dtFrmt.format(dt);
			outerloop:
				do
				{
					try {	    	
						columnHeaderFirstPage.isDisplayed();
						iden = false;	  
					}
					catch(Exception ex) {
						try {
							if(notingToShowText.isDisplayed()) {
								String screenshotname = "notingToShowText"+dtText;
								this.captureScreenshot(screenshotname);
								ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir")+"/Resources/ErrorScreenshots/"+screenshotname+".png");
								break outerloop;
							}
						}
						catch (Exception ey) {
							try {
								if(contactAdminErrorMainPage.isDisplayed()) {
									String screenshotname = "notingToShowText"+dtText;
									this.captureScreenshot(screenshotname);
									ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir")+"/Resources/ErrorScreenshots/"+screenshotname+".png");
									break outerloop;
								}
							}
							catch(Exception ez) {
								Thread.sleep(5000);	 
							}
						}
					}
				}
				while(iden);	         
		}
		catch(Exception | AssertionError ex)
		{
			throw ex;
		}
	}

	public void verifySetHomePage(String stringToVerify) throws InterruptedException, AWTException, AssertionError{    	
		BasePage.verifyPage(stringToVerify, pageIdentifier);
	}

	public void addSet() throws InterruptedException, AWTException{ 
		BasePage.click(addSet);
	}

	public void setTitle(String textTitle) throws InterruptedException, AWTException{    	
		BasePage.enterText(titleSet, textTitle);
	}   

	public void selectEntity(String entityToSelect) throws InterruptedException, AWTException{    	
		BasePage.click(pageIdentifier);
		WebElement entity = driver.findElement(By.xpath("//button//span[contains(text(),'"+entityToSelect+"')]"));
		BasePage.click(entity);
	}

	public void searchItems(String textToSearch) throws InterruptedException, AWTException{
		BasePage.click(serachBox);
		BasePage.enterText(serachBox, textToSearch);
	} 

	public void selectEntity() throws InterruptedException, AWTException{    	
		BasePage.click(pageIdentifier);
		BasePage.click(entitySelected);
	}

	public void searchItems() throws InterruptedException, AWTException{
		BasePage.click(serachBox);
		BasePage.enterText(serachBox, "x");
	}


	//	DD method
	//	public void AddandAccept(){
	//
	//		//wait.until(ExpectedConditions.elementToBeClickable(addAll));
	//		while(addAll.isDisplayed()){
	//			try
	//			{   Page.click(addAll);	 
	//			wait.until(ExpectedConditions.elementToBeClickable(addAll));
	//			}
	//			catch(Exception ex){Page.click(accept);}	    		
	//		}
	//
	//		Page.click(accept);
	//	}


	//My method
	//	public void AddandAccept() throws InterruptedException{
	//		//wait.until(ExpectedConditions.elementToBeClickable(addAll));
	//		{
	//			do
	//			{   
	//				Page.click(addAllEnabled);	
	//				try {
	//					wait.until(ExpectedConditions.elementToBeClickable(addAllEnabled));
	//				}
	//				catch(Exception c){
	//					Page.click(accept);
	//				}
	//
	//			}while(addAllEnabled.isDisplayed());
	//			Page.click(accept);
	//		}	
	//	}


	//}

	//	editCardIcon
	public void AddandAccept() throws InterruptedException, AWTException{
		//wait.until(ExpectedConditions.elementToBeClickable(addAll));
		while(addAll.isDisplayed()){
			try
			{   BasePage.click(addAll);	 
			wait.until(ExpectedConditions.elementToBeClickable(addAll));
			}
			catch(Exception ex){
				break;
			}	    		
		}
		BasePage.click(accept);
	}

	public void createCheck(String SetToCheck) throws Throwable{	    	
		this.Set();
		this.waitForSet();
		try {
			Assert.assertEquals(SetToCheck, FirstItem.getText());
			ExtentTestManager.getTest().log(Status.PASS, "Set is present in the list and verified");
			Thread.sleep(3000);
		}
		catch (Exception setNotPresent){
			System.out.println("Set is not present in the list");
		}
	}   	

	public void createSet(String SetName,String entityToSelect, String textToSearch) throws Throwable{	    	
		try {
			this.Set();
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(SetName);
			this.selectEntity(entityToSelect);
			this.searchItems(textToSearch); 
			Thread.sleep(2000);
			this.AddandAccept(); 	
			BasePage.waitforAnElement(editCardIcon);
			ExtentTestManager.getTest().log(Status.PASS, "Set "+ SetName +" is Created");
			this.createCheck(SetName);
			this.Home();
		}
		catch (AssertionError | Exception createSetFail){
			throw createSetFail;
		}
	}   	


	public List <String> createSetforAdd(String SetName,String entityToSelect, String textToSearch) throws Throwable{	    	
		try {
			this.Set();
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(SetName);
			this.selectEntity(entityToSelect);
			this.searchItems(textToSearch); 
			Thread.sleep(2000);
			this.AddandAccept(); 	
			List <String> setItems = this.getItemsWhileCreatingSet();
			BasePage.waitforAnElement(editCardIcon);
			ExtentTestManager.getTest().log(Status.PASS, "Set "+ SetName +" is Created");
			this.createCheck(SetName);
			this.Home();
			return setItems;
		}
		catch (AssertionError | Exception createSetFail){
			throw createSetFail;
		}
	} 

	public void viewSet(String SetName) throws InterruptedException, AWTException{
		this.Set(); 
		this.openItemFromList(SetName);	    
		ExtentTestManager.getTest().log(Status.PASS, "Set "+ SetName +" is opened");
	}

	public void expandSet() throws Throwable{
		BasePage.click(expand);
		this.waitForEditAndDelete();
	}

	public void editSet() throws InterruptedException, AWTException{
		BasePage.click(edit);
	}

	public void accept() throws InterruptedException, AWTException{
		BasePage.click(accept);
	}

	public void addFromSetExpand() throws InterruptedException, AWTException{
		BasePage.click(accept);
	}

	public void GridPrimaryColumnAlone(String PrimaryColumn) throws Throwable { 
		try {	
			this.GridSettings();
			this.GridPrimaryColumn(PrimaryColumn);
			BasePage.click(Apply);
		}
		catch (Exception ex) {
			throw ex;
		}
		catch (AssertionError ex) {
			throw ex;
		}
	}

	public void selectItems(List<String> myAlist) throws Throwable{  
		try {
			outloop:
				do{ 
					for(String item : myAlist)
					{
						for (WebElement element : gridItems) {
							if(element.isDisplayed()==false)
							{
								scrollIntoView(element);
							}
							String textFromGrid = element.getText();	    				
							if(item.equals(textFromGrid))
							{
								WebElement checkBox = element.findElement(By.tagName("i"));
								checkBox.click();	
								scrollIntoView(FirstRowintableExpand);
							}
						}
					}
					try {
						Thread.sleep(2000);
						forward.click();
						scrollIntoView(FirstRowintableExpand);
					}
					catch(Exception e){
						break outloop;
					}
				}
				while(forward.isEnabled());  
		}	    	
		catch(Exception ex) {
			throw ex;
		}
	}

	public void removeItems() throws InterruptedException, AWTException{	
		BasePage.click(remove);
		BasePage.click(saveChanges);
	}

	public void RemoveItemsfromSet(String SetToCreate, String entityToSelect, String textToSearch,String removeItem1 ,String removeItem2 , String removeItem3) throws Throwable
	{
		try {
			this.createSet(SetToCreate, entityToSelect, textToSearch);	 
			this.Set();
			WebElement opn = this.openSet(SetToCreate);
			BasePage.click(opn);
			this.expandSet();
			this.editSet();	  
			String NoOfRecordsInitial = ItemCountInExpand.getText();
			List<String>  myAlist = new ArrayList<String>();
			myAlist.add(removeItem1);
			myAlist.add(removeItem2);
			myAlist.add(removeItem3);
			this.selectItems(myAlist);	  
			this.removeItems();	 
			this.waitForEditAndDelete();
			ExtentTestManager.getTest().log(Status.PASS, "Set - Items removed successfully");
			waitforAnElement(ItemCountInExpand);
			String NoOfRecordsFinal = ItemCountInExpand.getText();
			this.DecreaseCompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
			int Difference = Integer.parseInt(NoOfRecordsInitial)-Integer.parseInt(NoOfRecordsFinal);
			assertEquals(Difference, myAlist.size());
			ExtentTestManager.getTest().log(Status.PASS, "Decrease in count is verified");
		}
		catch (Exception ex){
			System.out.println("Remove items failed");
			throw ex;
		}
	}

	public void addItemsFromFile(String filePath) {	    
		fileUpload.sendKeys(filePath);	
		ExtentTestManager.getTest().log(Status.PASS, "File uploaded successfully");
	}

	public void addItemsExpand() throws InterruptedException, AWTException  {	    
		BasePage.click(addItemsExpand);	 	
	}

	public void addItemsFromSet(String existingSetName) throws InterruptedException, AWTException{	    
		BasePage.click(addFromSet);	    	
		WebElement opn = this.openSet(existingSetName);
		BasePage.click(opn); 
		ExtentTestManager.getTest().log(Status.PASS, existingSetName + " Set is Added to this Set");
	}

	public void CreateSetFromFile(String setToCreate, String entityToSelect, String FileName) throws Throwable { 
		try {
			this.Set();
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(setToCreate);
			this.selectEntity(entityToSelect);
			this.addItemsFromFile(FileName); 
			this.AddandAccept();
			BasePage.waitforAnElement(editCardIcon);
			ExtentTestManager.getTest().log(Status.PASS, "Set Created from file located in :" + FileName );
			this.createCheck(setToCreate);
			this.Home();
		}
		catch (Exception ecf){
			throw ecf;
		}
		catch (AssertionError ecf){
			throw ecf;
		}
	}

	public void CreateSetFromSet(String existingSetName, String entityToSelect, String textToSearch, String setToCreate) throws Throwable { 
		try {
			this.createSet(existingSetName, entityToSelect, textToSearch);
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(setToCreate);
			this.selectEntity(entityToSelect);
			this.addItemsFromSet(existingSetName); 
			this.accept();
			BasePage.waitforAnElement(editCardIcon);
			ExtentTestManager.getTest().log(Status.PASS, "Set "+ setToCreate +" Created from Set " + existingSetName);
			this.createCheck(setToCreate);
			this.Home();
		}
		catch (Exception createSetFromSetfail) {
			throw createSetFromSetfail;
		}
		catch (AssertionError createSetFromSetfail){
			throw createSetFromSetfail;
		}
	}

	public void close() throws InterruptedException, AWTException{	
		BasePage.click(close);
	}

	public void saveChanges() throws InterruptedException, AWTException{
		BasePage.click(saveChanges);
		ExtentTestManager.getTest().log(Status.PASS, "Changes are Saved");
		this.Home();
	}

	public void searchExpandEnterName(String SetNameToAddFrom) throws InterruptedException, AWTException{ 		 
		BasePage.click(searchSetToAddExpand);
		searchSetToAddExpand.sendKeys(SetNameToAddFrom);
	}

	public void clickSetInExpand(String SelectaSet) throws InterruptedException, AWTException{ 		 
		WebElement SelectaSetfromExpand = driver.findElement(By.xpath("//*[@title='"+SelectaSet+"']"));
		BasePage.click(SelectaSetfromExpand);
		Thread.sleep(3000);
	}

	public void addFromSetExpand(String SetNameToAddFrom) throws InterruptedException, AWTException {	    
		BasePage.click(addFromSetExpand);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Select a Set']")));
		this.searchExpandEnterName(SetNameToAddFrom);
		this.clickSetInExpand(SetNameToAddFrom);
		ExtentTestManager.getTest().log(Status.PASS, SetNameToAddFrom + " is selected and added ");
	}	

	public void CompareTwovalues(String Value1, String Value2) throws InterruptedException, AWTException {	    
		if(Integer.parseInt(Value1)<Integer.parseInt(Value2)){
			System.out.println("Number of records have increased");
		}
		else{
			System.out.println("Number of records have not increased or in worst case have decreased");
		}
	}	

	public void DecreaseCompareTwovalues(String Value1, String Value2) throws InterruptedException, AWTException {	    
		if(Integer.parseInt(Value2)<Integer.parseInt(Value1)){
			System.out.println("Number of records have decrease");
		}
		else{
			System.out.println("Number of records have not decreased or in worst case have increased");
		}
	}	

	//Adding items from Set from expand into Set
	public void ExpandAddFromSet(String setToAdd, String entityToSelect,String textToSearchSet1, String setToCreate, String textToSearchSet2) throws Throwable {    // Add from a set
		try {
			List <String> setItems = this.createSetforAdd(setToAdd, entityToSelect, textToSearchSet1);
			this.Set();
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(setToCreate); //Create a set
			this.selectEntity(entityToSelect);
			this.searchItems(textToSearchSet2);
			this.AddandAccept();
			ExtentTestManager.getTest().log(Status.PASS, setToCreate + " is created ");
			this.expandSet();
			this.editSet();
			String NoOfRecordsInitial = ItemCountInExpand.getText();
			this.addItemsExpand();
			this.addFromSetExpand(setToAdd); //Set to be added
			this.waitForSaveChanges();
			waitforAnElement(ItemCountInExpand);
			String NoOfRecordsFinal = ItemCountInExpand.getText();
			this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
			this.verifyAfterAdd(setItems);
			BasePage.verifyPage(setToCreate,setNameInExpand); //verifying the set name
			ExtentTestManager.getTest().log(Status.PASS, "Set - Set added in expand");
		}
		catch (Exception | AssertionError ExpandAddFromSetFail) {
			throw ExpandAddFromSetFail;
		}
	}

	public void searchCatalog(String SearchInCatalog) throws InterruptedException, AWTException{	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from the Catalog']")));
		BasePage.click(searchCatalog);
		searchCatalog.sendKeys(SearchInCatalog);
		Thread.sleep(2000);
	}

	public List<String> addFromSetCatalog(String TextToSearch) throws InterruptedException, AWTException {	    
		BasePage.click(addFromExpandCatalog);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from the Catalog']")));
		this.searchCatalog(TextToSearch);
		Thread.sleep(2000);
		List <String> CatalogItems = this.getItemsWhileAddingFromCatalog();
		BasePage.click(addAll);
		ExtentTestManager.getTest().log(Status.PASS, "Added From Catalog");
		return CatalogItems;
	}

	public void add() throws InterruptedException, AWTException{	    
		BasePage.click(Add);
	}

	//Adding items from Catalog from expand into Set
	public void ExpandAddFromCatalog(String setToCreate, String entityToSelect, String textToSearch, String TextToSearch) throws Throwable  { 
		try {
			this.Set();
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(setToCreate); //Create a set
			this.selectEntity(entityToSelect);
			this.searchItems(textToSearch);
			this.AddandAccept();
			ExtentTestManager.getTest().log(Status.PASS, setToCreate + " is created ");
			this.expandSet();
			this.editSet();
			String NoOfRecordsInitial = ItemCountInExpand.getText();
			this.addItemsExpand();
			List<String> CatalogItems = this.addFromSetCatalog(TextToSearch); // Text to be added 
			System.out.println(CatalogItems);
			System.out.println(CatalogItems.size());
			ExtentTestManager.getTest().log(Status.PASS, TextToSearch + " is searched");
			this.add();
			this.waitForSaveChanges();
			waitforAnElement(ItemCountInExpand);
			String NoOfRecordsFinal = ItemCountInExpand.getText();
			this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
			this.verifyAfterAdd(CatalogItems);
			BasePage.verifyPage(setToCreate,setNameInExpand); //verifying the set name
			ExtentTestManager.getTest().log(Status.PASS, "Set - Added from catalog and count increase verified");
		}
		catch(AssertionError addfromCatalogFail) {
			throw addfromCatalogFail;
		}
		catch(Exception addfromCatalogFail) {
			throw addfromCatalogFail;
		}
	}


	public void fileSelectDropdown() throws InterruptedException, AWTException{	    
		BasePage.click(fileSelectDropdown);
	}


	public void FileuploadCategory(String CategoryName) throws InterruptedException, AWTException {	     
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Drag files here']")));
		this.fileSelectDropdown();
		BasePage.click(driver.findElement(By.xpath("//*[@title='"+CategoryName+"']")));
//		BasePage.click(clickUpload);
	}	


	public void FileUploadFormExplorer(String FileLocation) throws AWTException, InterruptedException {	    
		StringSelection ss = new StringSelection(FileLocation);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		//imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}	


	public List<String> addFromFile(String CategoryName, String Filelocation, String FileName) throws AWTException, InterruptedException, AssertionError {	    
		try {
			BasePage.click(addFromFile);	
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from a File']")));
			this.FileuploadCategory(CategoryName);
			addItemsFromFile(Filelocation);   // new item added
//			this.FileUploadFormExplorer(Filelocation);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Searching in ']")));
			BasePage.verifyPage(FileName, uploadedFileName);
			BasePage.waitforAnElement(FileDataList);
			List <String> FileItems = getItemsWhileAddingFromFile();
			BasePage.click(addAll);
			ExtentTestManager.getTest().log(Status.PASS, "Added from file");

			return FileItems;
		}
		catch (Exception addFromFileFail) {
			throw addFromFileFail;
		}
		catch (AssertionError addFromFileFail) {
			throw addFromFileFail;
		}
	}	

	public void addToGrid() throws InterruptedException, AWTException{	    
		BasePage.click(AddToGrid);
	}

	//Adding items from File from expand into Set
	public void ExpandAddFromFile(String setToCreate, String entityToSelect, String textToSearch, String CategoryName, String Filelocation, String FileName) throws Throwable { 
		try {
			this.Set();
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(setToCreate); //Create a set
			this.selectEntity(entityToSelect);
			this.searchItems(textToSearch);
			this.AddandAccept();
			ExtentTestManager.getTest().log(Status.PASS, setToCreate + " is created ");
			this.expandSet();
			this.editSet();
			String NoOfRecordsInitial = ItemCountInExpand.getText();
			this.addItemsExpand();
			Thread.sleep(2000);
			List <String> FileItems = this.addFromFile(CategoryName, Filelocation, FileName);  
			this.addToGrid();          
			this.waitForSaveChanges();
			waitforAnElement(ItemCountInExpand);
			String NoOfRecordsFinal = ItemCountInExpand.getText();
			this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);		
			this.verifyAfterAdd(FileItems);
			BasePage.verifyPage(setToCreate,setNameInExpand); //verifying the set name
			ExtentTestManager.getTest().log(Status.PASS, "Set - Added from file in expand");
		}
		catch (Exception ExpandAddFromFileFail) {
			if(dialogBoxClose.isDisplayed()) { 
				ExtentTestManager.getTest().log(Status.FAIL, "Add to Grid button is not displayed");
				BasePage.click(dialogBoxClose);
			}
			throw ExpandAddFromFileFail;
		}
		catch (AssertionError ExpandAddFromFileFail) {
			if(dialogBoxClose.isDisplayed()) {        
				BasePage.click(dialogBoxClose);
			}
			throw ExpandAddFromFileFail;
		}
	}


	public void DeleteCardExpand()throws InterruptedException, AWTException{ 
		BasePage.click(deleteCardExpand);
	}

	public void Delete() throws InterruptedException, AWTException { 
		BasePage.click(Delete);
	}

	public void DeleteCardInExpand(String setToCreate, String entityToSelect, String textToSearch) throws Throwable { 
		try {
			this.Set();
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(setToCreate); //Create a set
			this.selectEntity(entityToSelect);
			this.searchItems(textToSearch);
			this.AddandAccept();
			ExtentTestManager.getTest().log(Status.PASS, setToCreate + " is created");
			this.expandSet();
			this.DeleteCardExpand();
			String DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading']")).getText();
			Assert.assertEquals(DeleteConfirm, "Delete Set");
			this.Delete();
			BasePage.verifyPage("MY DATA", MyDataTitle); //My Data page
			ExtentTestManager.getTest().log(Status.PASS, setToCreate + " is deleted");
		}
		catch (Exception DeleteCardInExpandFail) {
			throw DeleteCardInExpandFail;
		}
		catch (AssertionError DeleteCardInExpandFail) {
			throw DeleteCardInExpandFail;
		}
	}

	public int NoOfPagesInSetPage() throws InterruptedException, AWTException { 
		String Pagecount = NoOfPagesInSet.getText();
		Integer n = Integer.valueOf(Pagecount);
		return n;
	}


	//	public void DeleteSetLoop(String SetToDelete) throws InterruptedException, AWTException { 
	//		Integer NoofPages = this.NoOfPagesInSetPage();
	//		WebElement SD = driver.findElement(By.xpath("//*[text()='"+SetToDelete+"']"));
	//		WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+SetToDelete+"']//parent::div//parent::div//child::button")));
	//
	//		List<WebElement> SDs = driver.findElements(By.xpath("//*[text()='"+SetToDelete+"']"));
	//		if (SDs.size() != 0) {
	//			Page.scrollIntoView(SD);
	//			Page.click(threeButton);
	//			Page.click(Delete);
	//			Thread.sleep(2000);
	//			Page.click(Delete);
	//		}
	//		else if (SDs.size()== 0) {
	//
	//			for (int i=0; i<NoofPages;i++) {
	//
	//				if (SDs.size() != 0) {
	//					Page.scrollIntoView(SD);
	//					Page.click(threeButton);
	//					Page.click(Delete);
	//					Thread.sleep(2000);
	//					Page.click(Delete);
	//					break;
	//				}
	//				else {
	//					Page.click(NextPage);
	//					Thread.sleep(2000);
	//				}
	//			}
	//		}
	//		else if (!NextPage.isEnabled()) {		
	//			System.out.print("The set to be deleted is not found");
	//		}
	//
	//		else {				
	//			System.out.print("The set to be deleted is not found");
	//		}
	//	}
	//
	//
	//	public void DeleteASet(String setToDelete) throws InterruptedException, AWTException { 
	//		Page.verifyPage("MY DATA", MyDataTitle); //My Data page
	//		this.DeleteSetLoop(setToDelete);
	//	}

	//	public void DeleteSetLoop(String SetToDelete) throws InterruptedException, AWTException { 
	//		try
	//		{
	//			do
	//			{
	//				Integer NoofPages = this.NoOfPagesInSetPage();
	//				WebElement SD = driver.findElement(By.xpath("//*[text()='"+SetToDelete+"']"));
	//				WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+SetToDelete+"']//parent::div//parent::div//child::button")));
	//
	//				List<WebElement> SDs = driver.findElements(By.xpath("//*[text()='"+SetToDelete+"']"));
	//				if (SDs.size() != 0) {
	//					BasePage.scrollIntoView(SD);
	//					BasePage.click(threeButton);
	//					BasePage.click(Delete);
	//					Thread.sleep(2000);
	//					BasePage.click(Delete);
	//				}
	//				else {
	//					BasePage.click(NextPage);
	//					Thread.sleep(2000);
	//
	//				}
	//				BasePage.click(forward); 
	//			}
	//			while(forward.isEnabled());  
	//		}	    	
	//		catch(Exception ex) {}
	//	}

	/*
	 * public void openItemFromList(String SetName) { try { do{ for (WebElement
	 * element : SetGridItems) { if(element.isDisplayed() == false)
	 * {scrollIntoView(element);} String textFromGrid = element.getText();
	 * if(SetName.equals(textFromGrid)) { BasePage.click(element); }
	 * 
	 * if (SDs.size() != 0) { BasePage.scrollIntoView(SD);
	 * BasePage.click(threeButton); BasePage.click(Delete); Thread.sleep(2000);
	 * BasePage.click(Delete); break; } else { BasePage.click(NextPage);
	 * Thread.sleep(2000); } BasePage.click(forward); } while(forward.isEnabled());
	 * } catch(Exception ex) {} }
	 */

	public void openItemFromList(String Item)
	{
		try {	    		
			do{ 
				for (WebElement element : SetGridItems) {
					if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
					String textFromGrid = element.getText();	    				
					if(Item.equals(textFromGrid)) {		    					
						BasePage.click(element);	
					}		    				
				}
				BasePage.click(forward); 
			}
			while(forward.isEnabled());  
		}	    	
		catch(Exception ex) {}
	}

	public void selectMenuOptionInList(String SetName)
	{
		try {	
			outerloop:
				do{
					for (WebElement element : SetGridItems) {
						if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
						String textFromGrid = element.getText();	    				
						if(textFromGrid.contains(SetName)) {
							WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript(
									"return arguments[0].parentNode;", element);
							WebElement deleteOption = parent.findElement(By.tagName("button"));	    					
							deleteOption.click();
							break outerloop;
						}
					}
					BasePage.click(forward);
				}    			
				while(forward.isEnabled());
		}	    	
		catch(Exception ex) {}
	}


	//	public void DeleteASet(String setToDelete) throws InterruptedException, AWTException { 
	//		BasePage.verifyPage("MY DATA", MyDataTitle); //My Data page
	//		this.DeleteSetLoop(setToDelete);
	//	}

	public void waitForEditAndDelete() throws Throwable{
		try {  
			boolean iden = true;
			outerloop:
				do
				{
					try {	    	
						edit.isDisplayed();
						iden = false;	  
					}
					catch(Exception ex) {
						try {
							if (fetchFailed.isDisplayed()) {
								break outerloop;
							}
						}
						catch (Exception et){
							Thread.sleep(3000);}	 
					}
				}
				while(iden);	         
		}
		catch(Exception | AssertionError ex)
		{
			throw ex;
		}
	}


	public void waitForSaveChanges() throws Throwable{
		try {  
			boolean iden = true;
			outerloop:
				do
				{
					try {	    	
						saveChanges.isDisplayed();
						iden = false;	  
					}
					catch(Exception ex) {
						try {
							if (fetchFailed.isDisplayed()) {
								break outerloop;
							}
						}
						catch (Exception et){
							Thread.sleep(3000);}	 
					}
				}
				while(iden);	         
		}
		catch(Exception | AssertionError ex)
		{
			throw ex;
		}
	}

	public void searchInExpand(String SearchInSet) throws InterruptedException, AWTException { 
		BasePage.click(serachBox);
		serachBox.sendKeys(SearchInSet);
		Thread.sleep(2000);
		BasePage.CompareAttributeText("value",SearchInSet,serachBoxExpand);
	}

	public void verifyAfterSearch(String SearchInSet) throws InterruptedException, AWTException { 
		try {
			int j =1 ;
			outloop:
				do {
					try {
						int NoOfRows = RowsintableExpand.size();
						for(int i=1 ; i<= NoOfRows ;i++) {
							WebElement tableRows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='TableRowDefault__bodyRow___1_m1h'])["+i+"]")));
							String valuesInRows = tableRows.getText().toLowerCase();
							String SearchInSetLowerCase = SearchInSet.toLowerCase();				
							boolean  comp = valuesInRows.contains(SearchInSetLowerCase);
							assertEquals(comp, true);
							ExtentTestManager.getTest().log(Status.PASS, i + " row is verified" + " in page " + j);
						}
					}
					catch (Exception e) {
						System.out.println("Error in Search verification");
						throw e;
					}
					try {
						Thread.sleep(3000);
						forward.click();
						j++;
						scrollIntoView(FirstRowintableExpand);
					}
					catch(Exception e){
						break outloop;
					}
				}
				while(forward.isEnabled()); 
		}
		catch(Exception r){
			System.out.println("Some problem with forward button");
			throw r;
		}
	}



	public List<String> getItemsWhileCreatingSet() throws InterruptedException, AWTException { 
		try {
			int NoOfItems = ItemsInSet.size();
			List <String> SetItems = new ArrayList<String>() ;
			for(int i=0 ; i< NoOfItems ;i++) 
			{
				WebElement SetItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ms-List-cell' and @data-list-index='"+i+"']//div[@class='SetMembers__cell___2OPak']")));
				String SetItemLCase = SetItem.getText().toLowerCase();
				SetItems.add(SetItemLCase);
			}
			return SetItems;
		}
		catch (Exception w) 
		{
			throw w;
		}
	}


	public List<String> getItemsWhileAddingFromCatalog() throws InterruptedException, AWTException { 
		try {
			int NoOfItems = ItemsInCatalog.size();
			List <String> CatalogItems = new ArrayList<String>() ;
			for(int i=1 ; i<= NoOfItems ;i++) 
			{
				WebElement CatalogItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='CatalogSearchResults__itemName___1PfVJ'])["+i+"]")));
				String CatalogItemLCase = CatalogItem.getText().toLowerCase();
				CatalogItems.add(CatalogItemLCase);
			}
			return CatalogItems;
		}
		catch (Exception w) 
		{
			throw w;
		}
	}

	public List<String> getItemsWhileAddingFromFile() throws InterruptedException, AWTException { 
		try {
			int NoOfItems = ItemsInFile.size();
			List <String> FileItems = new ArrayList<String>() ;
			for(int i=1 ; i<= NoOfItems ;i++) 
			{
				WebElement CatalogItem = driver.findElement(By.xpath("(//*[@class='CatalogSearchResults__itemName___1PfVJ'])["+i+"]"));
				BasePage.scrollIntoView(CatalogItem);
				String CatalogItemLCase = CatalogItem.getText().toLowerCase();
				System.out.println(CatalogItemLCase);
				FileItems.add(CatalogItemLCase);
			}
			return FileItems;
		}
		catch (Exception w) 
		{
			throw w;
		}
	}

	public void verifyAfterAdd(List<String> Items) throws InterruptedException, AWTException { 
		try {
			int k =1 ;
			int count = 0;
			outloop1:
				do {
					int NoOfRows = RowsintableExpand.size();
					int TotalElements = EachElementInExpand.size();
					int NoOfColumns =  TotalElements / NoOfRows;
					for(String item : Items) {
						try {
							outloop2:
								for(int i=1 ; i<= NoOfRows ;i++) 
								{
									for(int j=1 ; j<= NoOfColumns ;j++) 
									{
										WebElement tableRows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//*[@class='TableRowDefault__bodyRow___1_m1h'])["+i+"]/child::div)["+j+"]")));
										String valuesInRows = tableRows.getText().toLowerCase();
										String ItemsLowerCase = item.toLowerCase();		
										boolean  comp = valuesInRows.equals(ItemsLowerCase);
										if (comp == true) 
										{
											count++;
											ExtentTestManager.getTest().log(Status.PASS, "Value present in row: " + i + ", column:" + j + " of page " + k);
											break outloop2;
										}
									}
								}
						}
						catch (Exception e) {
							System.out.println("Error in Add verification");
							throw e;
						}
						catch (AssertionError f) {
							System.out.println("One/many of the values are not added");
							throw f;
						}
					}
					try {
						Thread.sleep(3000);
						forward.click();
						ExtentTestManager.getTest().log(Status.PASS, "Page " + k + " is checked");
						k++;
						scrollIntoView(FirstRowintableExpand);
					}
					catch(Exception e){
						assertEquals(count, Items.size());
						ExtentTestManager.getTest().log(Status.PASS, "All values added are verified");
						break outloop1;
					}
				}
				while(forward.isEnabled()); 
		}
		catch(Exception r){
			System.out.println("some problem with forward button");
			throw r;
		}
	}

	public void searchInSetExpand(String setToCreate, String entityToSelect, String textToSearch, String SearchInSet) throws Throwable { 
		try {
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(setToCreate); //Create a set
			this.selectEntity(entityToSelect);
			this.searchItems(textToSearch);
			this.AddandAccept();
			this.expandSet();
			this.searchInExpand(SearchInSet);
			ExtentTestManager.getTest().log(Status.PASS, "Search in done using text - "+ SearchInSet);
			this.verifyAfterSearch(SearchInSet);
			ExtentTestManager.getTest().log(Status.PASS, "Search is verified");
		}
		catch(Exception es) {
			throw es;
		}
	}

	public void GridSettings() throws InterruptedException, AWTException { 
		BasePage.click(GridSettingsIcon);
	}

	public void GridRows(String RowCount) throws InterruptedException, AWTException{ 
		BasePage.click(RowsPerPage);
		WebElement NoofRows = driver.findElement(By.xpath("//*[@title='"+RowCount+"']"));
		BasePage.click(NoofRows);
		ExtentTestManager.getTest().log(Status.PASS, "No. of rows have been set to " + RowCount);
	}

	public void GridPrimaryColumn(String PrimaryColumn) throws InterruptedException, AWTException { 
		BasePage.click(PrimaryColumnDropdown);
		WebElement PrimarySelect = driver.findElement(By.xpath("//*[@role='option' and @title='"+PrimaryColumn+"']"));
		BasePage.click(PrimarySelect);
		ExtentTestManager.getTest().log(Status.PASS, "Primary column is set to " + PrimaryColumn);
	}

	public void GridSecondaryColumn(String SecondaryColumn) throws InterruptedException, AWTException { 
		BasePage.click(SecondaryColumnDropdown);
		WebElement SecondarySelect = driver.findElement(By.xpath("//*[@role='option' and @title='"+SecondaryColumn+"']"));
		BasePage.click(SecondarySelect);
		ExtentTestManager.getTest().log(Status.PASS, "Secondary column is set to " + SecondaryColumn);
	}

	public void VerifyGrid(String NoofRows, String PrimaryColumn, String SecondaryColumn) throws InterruptedException, AWTException { 
		Thread.sleep(5000);
		List <WebElement> Columns = driver.findElements(By.xpath("//*[@tabindex='0']"));
		WebElement FirstColumn = driver.findElement(By.xpath("(//*[@tabindex='0'])[1]")); 
		int NoOfColumns = Columns.size();
		System.out.println(NoOfColumns);
		WebElement LastColumn = driver.findElement(By.xpath("(//*[@tabindex='0'])["+NoOfColumns+"]"));
		BasePage.verifyPage(PrimaryColumn, FirstColumn);
		BasePage.verifyPage(SecondaryColumn, LastColumn);
		String RN =Integer.toString(RowsintableExpand.size());
		Assert.assertEquals(RN, NoofRows);
	}

	public void GridChanges(String setToCreate, String entityToSelect, String textToSearch, String NoofRows, String PrimaryColumn, String SecondaryColumn) throws Throwable { 
		try {
			this.Set();
			this.addSet();
			this.verifySetHomePage("Uncategorized");
			this.setTitle(setToCreate); //Create a set
			this.selectEntity(entityToSelect);
			this.searchItems(textToSearch);
			this.AddandAccept();
			this.expandSet();
			this.GridSettings();
			this.GridRows(NoofRows);
			this.GridPrimaryColumn(PrimaryColumn);
			this.GridSecondaryColumn(SecondaryColumn);
			BasePage.click(Apply);
			this.waitForEditAndDelete();
			waitforAnElement(setNameInExpand);
			BasePage.verifyPage(setToCreate,setNameInExpand); //verifying the set name
			this.VerifyGrid(NoofRows,PrimaryColumn,SecondaryColumn);
			ExtentTestManager.getTest().log(Status.PASS, "Grid Changes in all - No.of Rows, Primary Column and Secondary Column are done and verified");
		}
		catch(Exception GridChangesFail){
			throw GridChangesFail;
		}
	}


	//	public void SharetLoop(String SetToShare, String SharedUser) throws InterruptedException, AWTException { 
	//		Integer NoofPages = this.NoOfPagesInSetPage();
	//		WebElement SS = driver.findElement(By.xpath("//*[text()='"+SetToShare+"']"));
	//		WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+SetToShare+"']//parent::div//parent::div//child::button")));
	//
	//		List<WebElement> SDs = driver.findElements(By.xpath("//*[text()='"+SetToShare+"']"));
	//		if (SDs.size() != 0) {
	//			Page.scrollIntoView(SS);
	//			Page.click(threeButton);
	//			Page.click(ShareAction);
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='heading' and text()='Share']")));
	//			Page.click(ShareTextBox);
	//			ShareTextBox.sendKeys(SharedUser);
	//			WebElement UserToShare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+SharedUser+"')]")));
	//			Page.click(UserToShare);
	//			Page.click(ShareButton);
	//		}
	//		else if (SDs.size()== 0) {
	//
	//			for (int i=0; i<NoofPages;i++) {
	//
	//				if (SDs.size() != 0) {
	//					Page.scrollIntoView(SS);
	//					Page.click(threeButton);
	//					Page.click(ShareAction);
	//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='heading' and text()='Share']")));
	//					Page.click(ShareTextBox);
	//					ShareTextBox.sendKeys(SharedUser);
	//					WebElement UserToShare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+SharedUser+"')]")));
	//					Page.click(UserToShare);
	//					Page.click(ShareButton);
	//					break;
	//				}
	//				else {
	//					Page.click(NextPage);
	//					Thread.sleep(2000);
	//				}
	//			}
	//		}
	//		else if (!NextPage.isEnabled()) {		
	//			System.out.print("The set to be deleted is not found");
	//		}
	//
	//		else {				
	//			System.out.print("The set to be deleted is not found");
	//		}
	//	}
	//
	//	public void shareASet(String SetToShare, String SharedUser) throws InterruptedException, AWTException { 
	//		Page.verifyPage("MY DATA", MyDataTitle); //My Data page
	//		this.shareASet(SetToShare, SharedUser);
	//		Boolean a = ShareSuccess.isDisplayed();
	//		if (a=true) {
	//			System.out.println("Set shared successfully");
	//		}
	//		else{
	//			System.out.println("Set shared failed");
	//		}
	//	}


	public void DeleteSet(String SettoDelete) throws InterruptedException, AWTException{
		try {
			this.Set();	
			waitforAnElement(columnHeaderFirstPage);
			selectMenuOptionInList(SettoDelete);
			Thread.sleep(3000);
			BasePage.click(deleteIcon);
			String DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading']")).getText();
			Assert.assertEquals(DeleteConfirm, "Delete Set?");
			BasePage.click(deleteIcon);	
		}
		catch (Exception|AssertionError DeleteSetFail){
			throw DeleteSetFail;
		}
	}


	public void createAndDeleteSet(String SetName, String entityToSelect, String textToSearch) throws Throwable{
		try {
			this.createSet(SetName, entityToSelect, textToSearch);	
			ExtentTestManager.getTest().log(Status.PASS, SetName + " is Created");
			this.DeleteSet(SetName); 
			ExtentTestManager.getTest().log(Status.PASS, SetName + " is Deleted");
		}
		catch (Exception createAndDeleteSetFail) {
			throw createAndDeleteSetFail;
		}
	}

	public void ShareSet(String SetToShare, String personToBeShared) throws Throwable{
		try {
			this.Set();
			this.waitForSet();
			selectMenuOptionInList(SetToShare);
			Thread.sleep(3000);
			BasePage.click(shareIcon);
			String SetNameInShare = setNameInShare.getText();
			Assert.assertEquals(SetNameInShare, SetToShare);
			BasePage.enterText(selectPersonToShare,personToBeShared);	
			BasePage.click(suggestedUsers);
			BasePage.click(share);	
			ExtentTestManager.getTest().log(Status.PASS, SetToShare + " is shared to user "+personToBeShared );
			BasePage.waitforAnElement(ShareSuccess);
		}
		catch (Exception| AssertionError ShareSetFail){
			BasePage.click(dialogBoxClose);
			throw ShareSetFail;
		}
	}

	public void createAndShareSet(String SetName, String entityToSelect, String textToSearch, String personToBeShared) throws Throwable{
		this.createSet(SetName, entityToSelect, textToSearch);	
		ExtentTestManager.getTest().log(Status.PASS, SetName + " is Created");
		this.ShareSet(SetName, personToBeShared);
		ExtentTestManager.getTest().log(Status.PASS, SetName + " is Shared");
	}

//	public void SharetLoop(String SetToShare, String SharedUser) throws InterruptedException, AWTException { 
//		Integer NoofPages = this.NoOfPagesInSetPage();
//		WebElement SS = driver.findElement(By.xpath("//*[text()='"+SetToShare+"']"));
//		WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+SetToShare+"']//parent::div//parent::div//child::button")));
//
//		List<WebElement> SDs = driver.findElements(By.xpath("//*[text()='"+SetToShare+"']"));
//		if (SDs.size() != 0) {
//			BasePage.scrollIntoView(SS);
//			BasePage.click(threeButton);
//			BasePage.click(ShareAction);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='heading' and text()='Share']")));
//			BasePage.click(ShareTextBox);
//			ShareTextBox.sendKeys(SharedUser);
//			WebElement UserToShare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+SharedUser+"')]")));
//			BasePage.click(UserToShare);
//			BasePage.click(ShareButton);
//		}
//		else if (SDs.size()== 0) {
//
//			for (int i=0; i<NoofPages;i++) {
//
//				if (SDs.size() != 0) {
//					BasePage.scrollIntoView(SS);
//					BasePage.click(threeButton);
//					BasePage.click(ShareAction);
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='heading' and text()='Share']")));
//					BasePage.click(ShareTextBox);
//					ShareTextBox.sendKeys(SharedUser);
//					WebElement UserToShare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+SharedUser+"')]")));
//					BasePage.click(UserToShare);
//					BasePage.click(ShareButton);
//					break;
//				}
//				else {
//					BasePage.click(NextPage);
//					Thread.sleep(2000);
//				}
//			}
//		}
//		else if (!NextPage.isEnabled()) {		
//			System.out.print("The set to be deleted is not found");
//		}
//
//		else {				
//			System.out.print("The set to be deleted is not found");
//		}
//	}

	public void verifySortAscending(String ColumnToBeSorted) throws Throwable{
		Integer NumOfPrecedingColumns = driver.findElements(By.xpath("//*[text()='"+ColumnToBeSorted+"']//parent::div//parent::div//preceding-sibling::div")).size();
		Integer CurrentColumn = NumOfPrecedingColumns + 1;
		Integer NoOfRows = RowsintableExpand.size();
		List<String>  OriginalList = new ArrayList<String>();
		List<String>  TempList = new ArrayList<String>();
		for(int i=1; i<=NoOfRows; i++) {
			WebElement text = driver.findElement(By.xpath("(((//div[@class='TableRowDefault__bodyRow___1_m1h'])["+i+"])//div)["+CurrentColumn+"]"));
			OriginalList.add(text.getText());
			TempList.add(text.getText());
		}
		Collections.sort(TempList);
		assertEquals(OriginalList, TempList);
		ExtentTestManager.getTest().log(Status.PASS,"Ascending sorting of "+ ColumnToBeSorted + " is verified");
	}

	public void verifySortDescending(String ColumnToBeSorted) throws Throwable{
		Integer NumOfPrecedingColumns = driver.findElements(By.xpath("//*[text()='"+ColumnToBeSorted+"']//parent::div//parent::div//preceding-sibling::div")).size();
		Integer CurrentColumn = NumOfPrecedingColumns + 1;
		Integer NoOfRows = RowsintableExpand.size();
		List<String>  OriginalList = new ArrayList<String>();
		List<String>  TempList = new ArrayList<String>();
		for(int i=1; i<=NoOfRows; i++) {
			WebElement text = driver.findElement(By.xpath("(((//div[@class='TableRowDefault__bodyRow___1_m1h'])["+i+"])//div)["+CurrentColumn+"]"));
			OriginalList.add(text.getText());
			TempList.add(text.getText());
		}
		Collections.sort(TempList,Collections.reverseOrder());
		assertEquals(OriginalList, TempList);
		ExtentTestManager.getTest().log(Status.PASS,"Descending sorting of "+ ColumnToBeSorted + " is verified");
	}

	public void SortColumnInSet(String SetName, String entityToSelect, String textToSearch, String ColumnToBeSorted) throws Throwable{
		try {
			this.createSet(SetName, entityToSelect, textToSearch);	
			this.Set();
			WebElement opn = this.openSet(SetName);
			BasePage.click(opn);
			ExtentTestManager.getTest().log(Status.PASS, SetName + " is Created");
			this.expandSet();
			WebElement SortColumnname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ColumnToBeSorted+"']")));
//			Thread.sleep(3000);
			WebElement NextColumnname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ColumnToBeSorted+"']//parent::div//parent::div/following-sibling::div")));
			scrollIntoView(NextColumnname);
			BasePage.click(SortColumnname);
			Thread.sleep(3000);
			ExtentTestManager.getTest().log(Status.PASS, ColumnToBeSorted + " is Sorted Ascending");
			this.verifySortAscending(ColumnToBeSorted);
			BasePage.click(SortColumnname);
			Thread.sleep(3000);
			ExtentTestManager.getTest().log(Status.PASS, ColumnToBeSorted + " is Sorted Descending");
			this.verifySortDescending(ColumnToBeSorted);
		}
		catch(Throwable ex){
			System.out.println("Some issue with sort");		
			throw ex;
		}
	}


	//	//		WebElement SortColumnname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+configObject.getProperty("SortColumn")+"']")));
	//	//		Thread.sleep(5000);
	//	//
	//	//		WebElement NextColumnname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+configObject.getProperty("SortColumn")+"']//parent::div//parent::div/following-sibling::div")));
	//	//		scrollIntoView(NextColumnname);
	//	//		Thread.sleep(5000);
	//	//
	//	//		customclick(SortColumnname);
	//	//		Thread.sleep(5000);

	public void shareASet(String SetToShare, String SharedUser) throws InterruptedException, AWTException { 
		BasePage.verifyPage("MY DATA", MyDataTitle); //My Data page
		this.shareASet(SetToShare, SharedUser);
		Boolean a = ShareSuccess.isDisplayed();
		if (a==true) {
			System.out.println("Set shared successfully");
		}
		else{
			System.out.println("Set shared failed");
		}
	}

	public void ApplyFilter(String Attribute, String FilterType, String textToFilter) throws Throwable { 
		try {
			BasePage.click(FilterIconInExpand);
			BasePage.waitforAnElement(EditFilterText);
			BasePage.click(SelectAnAttribute);
			WebElement AttributeToSelect = driver.findElement(By.xpath("//*[@type='button']//*[text()='"+Attribute+"']"));
			BasePage.click(AttributeToSelect);
			BasePage.click(SelectFilterType);
			WebElement FilterTypeToApply = null;
			if (FilterType.equalsIgnoreCase("Contains")) {
				FilterTypeToApply = driver.findElement(By.xpath("//*[@type='button']//*[text()='Contains']"));
			}
			if (FilterType.equalsIgnoreCase("Equals")) {
				FilterTypeToApply = driver.findElement(By.xpath("//*[@type='button']//*[text()='Equals']"));
			}
			BasePage.click(FilterTypeToApply);
			BasePage.click(valueForFilter);
			valueForFilter.sendKeys(textToFilter);
			BasePage.click(AddFilter);
			ExtentTestManager.getTest().log(Status.PASS, "Filter is applied with "+ Attribute+" --> "+ FilterType+"\""+textToFilter+"\"");
			BasePage.click(DoneButton);
		}
		catch(Exception Ex){
			ExtentTestManager.getTest().log(Status.FAIL, "Error in applying filter");
			throw Ex;
		}
	}

	public void ApplyMultipleFilter(String Attribute1, String FilterType1, String textToFilter1, String Attribute2, String FilterType2, String textToFilter2) throws Throwable { 
		BasePage.click(FilterIconInExpand);
		BasePage.waitforAnElement(EditFilterText);
		for (int i=1; i<=2; i++) {
			if(i==1){
				BasePage.click(SelectAnAttribute);
				WebElement AttributeToSelect = driver.findElement(By.xpath("//*[@type='button']//*[text()='"+Attribute1+"']"));
				BasePage.click(AttributeToSelect);
				BasePage.click(SelectFilterType);
				WebElement FilterTypeToApply = null;
				if (FilterType1.equalsIgnoreCase("Contains")) {
					FilterTypeToApply = driver.findElement(By.xpath("//*[@type='button']//*[text()='Contains']"));
				}
				if (FilterType1.equalsIgnoreCase("Equals")) {
					FilterTypeToApply = driver.findElement(By.xpath("//*[@type='button']//*[text()='Equals']"));
				}
				BasePage.click(FilterTypeToApply);
				BasePage.click(valueForFilter);
				valueForFilter.sendKeys(textToFilter1);
				BasePage.click(AddFilter);
				ExtentTestManager.getTest().log(Status.PASS, "Filter is applied with "+ Attribute1+" --> "+ FilterType1+"\""+textToFilter1+"\"");
			}
			if(i==2) {
				BasePage.click(SelectAnAttribute);
				WebElement AttributeToSelect = driver.findElement(By.xpath("//*[@type='button']//*[text()='"+Attribute2+"']"));
				BasePage.click(AttributeToSelect);
				BasePage.click(SelectFilterType);
				WebElement FilterTypeToApply = null;
				if (FilterType2.equalsIgnoreCase("Contains")) {
					FilterTypeToApply = driver.findElement(By.xpath("//*[@type='button']//*[text()='Contains']"));
				}
				if (FilterType2.equalsIgnoreCase("Equals")) {
					FilterTypeToApply = driver.findElement(By.xpath("//*[@type='button']//*[text()='Equals']"));
				}
				BasePage.click(FilterTypeToApply);
				BasePage.click(valueForFilter2);
				valueForFilter2.sendKeys(textToFilter2);
				ExtentTestManager.getTest().log(Status.PASS, "Filter is applied with "+ Attribute2+" --> "+ FilterType2+"\""+textToFilter2+"\"");
			}
		}
		BasePage.click(DoneButton);
	}

	public void moveToFirstPage(String textToFilter) throws InterruptedException, AWTException { 
		try {
			outloop:
				do {
					try {
						Thread.sleep(1000);
						backward.click();
						scrollIntoView(FirstRowintableExpand);
					}
					catch(Exception e){
						break outloop;
					}
				}
				while(backward.isEnabled());
		}
		catch(Exception e) {
			System.out.println("Some problem with backward click");
			throw e;
		}
	}

	public void verifyAfterFilter(String Attribute,String FilterType,String textToFilter) throws InterruptedException, AWTException { 
		try {
			Integer NumOfPrecedingColumns = driver.findElements(By.xpath("//*[text()='"+Attribute+"']//parent::div//parent::div//preceding-sibling::div")).size();
			Integer CurrentColumn = NumOfPrecedingColumns + 1;
			int j=1;
			outloop:
				do {
					try {
						int NoOfRows = RowsintableExpand.size();
						for(int i=1 ; i<= NoOfRows ;i++) {
							WebElement text = driver.findElement(By.xpath("(((//div[@class='TableRowDefault__bodyRow___1_m1h'])["+i+"])//div)["+CurrentColumn+"]"));
							String valuesInRows = text.getText().toLowerCase();
							String SearchInSetLowerCase = textToFilter.toLowerCase();
							boolean  comp = false;
							if (FilterType.equalsIgnoreCase("contains")) {
								comp = valuesInRows.contains(SearchInSetLowerCase);
							}
							if (FilterType.equalsIgnoreCase("euqals")) {
								comp = valuesInRows.equals(SearchInSetLowerCase);
							}
							assertEquals(comp, true);
							ExtentTestManager.getTest().log(Status.PASS,  " Row " +i+ " of " +Attribute+" is verified" + " in page " +j );
						}
					}
					catch (Exception e) {
						System.out.println("Error in filter verification");
						throw e;
					}
					catch (AssertionError f) {
						System.out.println("Error in filter functionality");
						throw f;
					}
					try {
						Thread.sleep(3000);
						forward.click();
						j++;
						scrollIntoView(FirstRowintableExpand);
					}
					catch(Exception e){
						break outloop;
					}
				}
				while(forward.isEnabled()); 
		}
		catch(Exception | AssertionError r){
			System.out.println("Some problem with forward button");
			throw r;
		}
	}

	public void verifyAfterFilterdual(String Attribute1, String Attribute2, String FilterType1, String FilterType2, String textToFilter1,String textToFilter2) throws InterruptedException, AWTException { 
		try {
			int j =1 ;
			List <String> filterList = new ArrayList<String>();
			filterList.add(FilterType1);
			filterList.add(FilterType2);
			List <String> attributeList = new ArrayList<String>();
			attributeList.add(Attribute1);
			attributeList.add(Attribute2);
			List <String> textToFilterList = new ArrayList<String>();
			textToFilterList.add(textToFilter1);
			textToFilterList.add(textToFilter2);
			int k = 0;
			String Attribute = null;
			String textToFilter = null;
			for(String filter: filterList){
				k++;
				if(k==1) {
					Attribute = Attribute1;
					textToFilter=textToFilter1;
				}
				if(k==2) {
					Attribute = Attribute2;
					textToFilter=textToFilter2;
				}
				Integer NumOfPrecedingColumns = driver.findElements(By.xpath("//*[text()='"+Attribute+"']//parent::div//parent::div//preceding-sibling::div")).size();
				Integer CurrentColumn = NumOfPrecedingColumns + 1;
				outloop:
					do {
						try {
							int NoOfRows = RowsintableExpand.size();
							for(int i=1 ; i<= NoOfRows ;i++) {
								WebElement text = driver.findElement(By.xpath("(((//div[@class='TableRowDefault__bodyRow___1_m1h'])["+i+"])//div)["+CurrentColumn+"]"));
								String valuesInRows = text.getText().toLowerCase();
								System.out.println(valuesInRows);
								String SearchInSetLowerCase = textToFilter.toLowerCase();
								System.out.println(SearchInSetLowerCase);
								boolean  comp = false;
								if (filter.equalsIgnoreCase("contains")) {
									comp = valuesInRows.contains(SearchInSetLowerCase);
									System.out.println("contains verified");
								}
								if (filter.equalsIgnoreCase("equals")) {
									comp = valuesInRows.equals(SearchInSetLowerCase);
									System.out.println("equals verified");
								}
								assertEquals(comp, true);
								System.out.println(comp);
								ExtentTestManager.getTest().log(Status.PASS,  " Row " +i+ " of " +Attribute+" is verified" + " in page " +j+ " for filter "+ k);
							}
						}
						catch (Exception e) {
							System.out.println("Error in filter verification");
							throw e;
						}
						catch (AssertionError f) {
							System.out.println("Error in filter functionality");
							throw f;
						}
						try {
							Thread.sleep(3000);
							forward.click();
							j++;
							scrollIntoView(FirstRowintableExpand);
						}
						catch(Exception e){
							do {
								try {
									Thread.sleep(3000);
									backward.click();
									j++;
									scrollIntoView(FirstRowintableExpand);
								}
								catch(Exception o) {
									break outloop;
								}

							}while(backward.isEnabled());
							break outloop;
						}
					}
					while(forward.isEnabled()); 
			}
		}
		catch(Exception r){
			System.out.println("Some problem with forward button");
			throw r;
		}
	}

	public void FilterSet(String SetName, String entityToSelect, String textToSearch, String Attribute, String FilterType, String textToFilter) throws Throwable { 
		this.createSet(SetName, entityToSelect, textToSearch);	
		this.Set();
		WebElement opn = this.openSet(SetName);
		BasePage.click(opn);
		ExtentTestManager.getTest().log(Status.PASS, SetName + " is Created");
		this.expandSet();
		this.ApplyFilter(Attribute, FilterType, textToFilter);
		this.verifyAfterFilter(Attribute, FilterType, textToFilter);
		ExtentTestManager.getTest().log(Status.PASS, "Applied filter is verified");
	}

	public void FilterSetMulti(String SetName, String entityToSelect, String textToSearch, String Attribute1, String FilterType1, String textToFilter1, String Attribute2, String FilterType2, String textToFilter2) throws Throwable { 
		this.createSet(SetName, entityToSelect, textToSearch);	
		this.Set();
		WebElement opn = this.openSet(SetName);
		BasePage.click(opn);
		ExtentTestManager.getTest().log(Status.PASS, SetName + " is Created");
		this.expandSet();
		this.ApplyMultipleFilter(Attribute1, FilterType1, textToFilter1, Attribute2, FilterType2, textToFilter2);
		this.verifyAfterFilterdual(Attribute1,Attribute2,FilterType1,FilterType2,textToFilter1,textToFilter2);
		ExtentTestManager.getTest().log(Status.PASS, "Applied filters are verified");
	}

	public void captureScreenshot(String screenShotName) throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String fileWithPath = "./Resources/ErrorScreenshots/"+screenShotName+".png";
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}

}


//List <WebElement> Columns = webdriver.findElements(By.xpath("//*[@tabindex='0']"));
//int NoOfColumns = Columns.size();
//System.out.println(NoOfColumns);        //getting the number of columns




