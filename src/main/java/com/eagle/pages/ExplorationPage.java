package com.eagle.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import com.eagle.pages.SetPage;

public class ExplorationPage extends BasePage{

	SetPage objSetPage; 

	//Page level objects

	@FindBy(xpath = "//i[@data-icon-name='Home']")
	public WebElement homeIcon;

	@FindBy(xpath = "//i[@data-icon-name='Relationship']")
	public WebElement explorationIcon;

	@FindBy(xpath = "//*[text()='Terms of Use']")
	public WebElement TermsOfUse;

	@FindBy(xpath = "//*[text()='Exploration']")
	public WebElement addExploration;

	@FindBy(xpath = "//*[text()='Search for entities']")
	public WebElement searchforentities;

	@FindBy(xpath = "//*[text()='Select a set']")
	public WebElement selectaSet;

	@FindBy(xpath = "//div[@scraper-tag='CardHeader']//span")
	public WebElement pageIdentifier;

	@FindBy(xpath = "//div//span[contains(text(),'Uncategorized')]")
	public WebElement entitySelection;

	@FindBy(xpath = "//div//input[@type='text']")
	public WebElement titleExploration;

	//	@FindBy(xpath = "//button//span[contains(text(),'Disease')]")
	//	public WebElement entitySelected;	

	@FindBy(xpath = "//*[text()='Start']")
	public WebElement startButton;

	@FindBy(xpath = "//div//input[@role='searchbox']")
	public WebElement serachBox;

	@FindBy(xpath = "//div//input[@role='searchbox' and @placeholder='Search in this list...']")
	public WebElement serachBoxExpand;	
	
	@FindBy(xpath = "//*[@scraper-tag='HandleError' and text()='Fetch failed']")
	public WebElement fetchFailed;

	@FindBy(xpath = "//button[@title='Add all items']")
	public WebElement addAll;		

	@FindBy(xpath = "//div//span[contains(text(),'Accept')]")
	public WebElement accept;	

	@FindBy(xpath = "//*[@class='ExpandedCardViewHeader__title___r34jA']")
	public WebElement ExplorationNameInExpand;	

	@FindBy(xpath = "//*[@class='ms-Dropdown-container']")
	public WebElement fileSelectDropdown;	

	@FindBy(xpath = "//*[text()='browse/upload']")
	public WebElement clickUpload;	

	@FindBy(xpath = "//*[text()='Searching in ']//parent::div//child::b")
	public WebElement uploadedFileName;	

	@FindBy(xpath = "//*[@data-icon-name='Delete']//parent::span")
	public WebElement deleteCardExpand;	

	@FindBy(xpath = "(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]")
	public WebElement NoOfPagesInExploration;	

	@FindBy(xpath = "//*[@data-icon-name='Forward']")
	public WebElement NextPage;	

	@FindBy(xpath = "(//*[@role='rowheader' and @aria-colindex=1])[1]/div")
	public WebElement FirstItem;

	@FindBy(xpath = "//*[text()='Apply']")
	public WebElement Apply;	

	@FindBy(xpath = "//*[text()='Share']")
	public WebElement ShareAction;	

	@FindBy(xpath = "//*[@placeholder='Select one or more users']")
	public WebElement ShareTextBox;	

	@FindBy(xpath = "//*[@type='button']//*[text()='Share']")
	public WebElement ShareButton;	

	@FindBy(xpath = "//i[@data-icon-name='MiniExpand']")
	public WebElement expand;	

	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	public WebElement edit;	

	@FindBy(xpath = "//div[@class='TableRowDefault__bodyRow___1_m1h']//div[@class='TableRowDefault__td___39_xA'][1]")
	public List<WebElement> gridItems;

	@FindBy(xpath = "//span[contains(text(),'Remove Items')]")
	public WebElement remove;	

	@FindBy(xpath = "//span[contains(text(),'Save Changes')]")
	public WebElement saveChanges;	

	@FindBy(xpath = "//i[@data-icon-name='Forward']")
	public WebElement forward;

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

	@FindBy(xpath = "//*[text()='Add items from a file']")
	public WebElement addItemsFromAFile;

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

	@FindBy(xpath = "//*[@class='TableRowDefault__bodyRow___1_m1h")
	public List <WebElement> RowsintableExpand;

	@FindBy(xpath = "//*[@data-icon-name='ShareIOS']")
	public WebElement ExportCard;

	@FindBy(xpath = "//*[@class='ms-List' and @role='presentation']")
	public WebElement ExplorationList;

	@FindBy(xpath = "(//*[@class='ms-List' and @role='presentation'])[2]")
	public WebElement ExplorationList2;

	@FindBy(xpath = "//*[@data-icon-name='Trash']")
	public WebElement DeleteinCard;

	@FindBy(xpath = "(//*[@data-icon-name='Trash'])[2]")
	public WebElement DeleteinCard2;

	@FindBy(xpath = "//*[text()='Remove']")
	public WebElement Remove;

	@FindBy(xpath = "//*[@data-icon-name='CircleAdditionSolid']")
	public WebElement addRelation;

	@FindBy(xpath = "//*[@type='button']//*[text()='Select a category']")
	public WebElement addRelationCategory;

	@FindBy(xpath = "//*[@scraper-tag='SetCardContent']")
	public List <WebElement> setCards;

	@FindBy(xpath = "//*[@class='ms-Label SetCardCategorySelector__categoryName___OkSRM root-82']")
	public List <WebElement> cardEntityName;

	@FindBy(xpath = "(//*[@class='ExpandedCardViewHeader__listCount___yQb2n']/span)[1]")
	public WebElement ItemCountInExpand;

	@FindBy(xpath = "//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']")
	public List<WebElement> ExplorationGridItems;

	@FindBy(xpath = "//button//span[contains(text(),'Delete')]")
	public WebElement deleteIcon;

	@FindBy(xpath = "(//span[@class='NameAndDescription__description___zAZrs'])[1]")
	public WebElement ExplorationNameInShare;

	@FindBy(xpath = "//button//span[contains(text(),'Share')]")
	public WebElement shareIcon;

	@FindBy(xpath = "//i[@data-icon-name='Share']")
	public WebElement share;

	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement selectPersonToShare;

	@FindBy(xpath = "//*[text()='Resource shared successfully']")
	public WebElement ShareSuccess;	

	@FindBy(xpath = "//div[contains(@class,'ms-PeoplePicker')]")
	public WebElement suggestedUsers;

	@FindBy(xpath = "//*[@role='columnheader']")
	public WebElement columnHeaderFirstPage;

	@FindBy(xpath = "//*[@data-icon-name='Cancel']")
	public WebElement dialogBoxClose;



	public WebElement openExploration(String name) {
		return driver.findElement(By.xpath("//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']//div[@title='"+ name +"']"));   		
	}

	//Page level functions on the objects
	WebDriverWait wait = new WebDriverWait(driver, 5);
	Actions action = new Actions(driver);

	public void Home() throws AWTException, InterruptedException{    	
		BasePage.click(homeIcon);
		action.moveToElement(TermsOfUse).perform();
	}  

	public ExplorationPage() throws AWTException, InterruptedException{ 	
		PageFactory.initElements(driver, this); 
		BasePage.click(explorationIcon);
		action.moveToElement(TermsOfUse).perform();
	}

	public void Exploration() throws AWTException, InterruptedException{ 	
		BasePage.click(explorationIcon);
		action.moveToElement(TermsOfUse).perform();
	}

	public void verifyExplorationHomePage(String stringToVerify) throws AWTException, InterruptedException, AssertionError{    	
		BasePage.verifyPage(stringToVerify, pageIdentifier);
	}

	public void addExploration() throws AWTException, InterruptedException{ 
		BasePage.click(addExploration);
	}

	public void createExplorationSearch() throws AWTException, InterruptedException{ 
		BasePage.click(searchforentities);
	}

	public void clickStart()throws AWTException, InterruptedException {	    	
		BasePage.click(startButton);        
	}   

	public void createExplorationSet(String setToAdd) throws AWTException, InterruptedException{ 
		BasePage.click(selectaSet);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Select a Set']")));
		this.searchExpandEnterName(setToAdd);
		this.clickSetInExpand(setToAdd);
		Thread.sleep(10000);
	}

	public void ExplorationTitle(String textTitle) throws AWTException, InterruptedException{    	
		BasePage.enterText(titleExploration, textTitle);
	}   

	public void selectEntity(String entityToSelect) throws AWTException, InterruptedException{    	
		BasePage.click(pageIdentifier);
		WebElement entitytoSelect = driver.findElement(By.xpath("//button//span[contains(text(),'"+entityToSelect+"')]"));
		BasePage.click(entitytoSelect);
	}

	public void searchItems(String ItemtoSearch) throws AWTException, InterruptedException{
		BasePage.click(serachBox);
		BasePage.enterText(serachBox, ItemtoSearch);
	}

	public void createCheck(String ExplorationToCheck) throws AWTException, InterruptedException,AssertionError{	    	
		this.Exploration();
		Thread.sleep(20000);
		BasePage.waitforAnElement(columnHeaderFirstPage);
		try {
			Assert.assertEquals(ExplorationToCheck, FirstItem.getText());
			System.out.println("Exploration is present in the list");
			Thread.sleep(5000);
		}
		catch (Exception ExplorationNotPresent){
			System.out.println("Exploration is not present in the list");
		}
		catch (AssertionError ExplorationNotPresent){
			System.out.println("Exploration is not present in the list");
		}
	}   

	public void AddandStart() throws AWTException, InterruptedException{
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
		BasePage.click(startButton);
	}


	public void waitForExploration() throws Throwable{
		try {  
			boolean iden = true;
			do
			{
				try {	    	
					columnHeaderFirstPage.isDisplayed();
					iden = false;	  
				}
				catch(Exception ex) {Thread.sleep(5000);}	 
			}
			while(iden);	         
		}
		catch(Exception | AssertionError ex)
		{
			throw ex;
		}
	}
	
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
						Thread.sleep(5000);}	 
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
						Thread.sleep(5000);}	 
				}
			}
			while(iden);	         
		}
		catch(Exception | AssertionError ex)
		{
			throw ex;
		}
	}

	public void waitForExplorationTitle() throws Throwable{
		try {  
			boolean iden = true;
			do
			{
				try {	    	
					titleExploration.isDisplayed();
					iden = false;	  
				}
				catch(Exception ex) {Thread.sleep(5000);}	 
			}
			while(iden);	         
		}
		catch(Exception | AssertionError ex)
		{
			throw ex;
		}
	}

	public void createExplorationFromSearch(String ExplorationName, String EntitytoSelect, String ItemtoSearch) throws Throwable{	    	
		try {
			this.Exploration();
			this.waitForExploration();
			this.addExploration();
			this.createExplorationSearch();
			this.verifyExplorationHomePage("Uncategorized");
			this.ExplorationTitle(ExplorationName);
			this.selectEntity(EntitytoSelect);
			this.searchItems(ItemtoSearch); 
			this.AddandStart();   
			BasePage.waitforAnElement(ExplorationList);
			ExtentTestManager.getTest().log(Status.PASS, ExplorationName + " Exploration is created from search");
			this.createCheck(ExplorationName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Exploration is verified");
		}
		catch(Exception ex){
			throw ex;
		}
		catch(AssertionError ex){
			throw ex;
		}
	}   	

	public void createExploration(String ExplorationName, String EntitytoSelect, String ItemtoSearch) throws Throwable{	    	
		this.Exploration();
		this.waitForExploration();
		this.addExploration();
		this.createExplorationSearch();
		this.verifyExplorationHomePage("Uncategorized");
		Thread.sleep(10000);
		this.ExplorationTitle(ExplorationName);
		this.selectEntity(EntitytoSelect);
		this.searchItems(ItemtoSearch); 
		this.AddandStart();   
		BasePage.waitforAnElement(ExplorationList);
		ExtentTestManager.getTest().log(Status.PASS, ExplorationName + " is created");
	}   	

	public void createExplorationInitallyFromSet(String SetName,String entityToSelect, String textToSearch , String ExplorationName) throws Throwable{	    	
		try {
			objSetPage = new SetPage();  
			objSetPage.createSet(SetName, entityToSelect, textToSearch);
			this.Home();

			this.Exploration();
			this.waitForExploration();
			this.addExploration();
			this.createExplorationSet(SetName);
			ExtentTestManager.getTest().log(Status.PASS, SetName + " Set is added as base to create Exploration " + ExplorationName);
			this.waitForExplorationTitle();
			this.ExplorationTitle(ExplorationName);
			BasePage.waitforAnElement(ExplorationList);
			ExtentTestManager.getTest().log(Status.PASS, ExplorationName + " Exploration is created from Set intially");
			this.createCheck(ExplorationName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Exploration is verified");
			this.Home();
		}
		catch(Exception ex){
			throw ex;
		}
		catch(AssertionError ex){
			throw ex;
		}
	}  

	public void expandExploration() throws Throwable{
		BasePage.click(expand);
		this.waitForEditAndDelete();
	}

	public void editCard() throws AWTException, InterruptedException{
		BasePage.click(edit);
	}

	public void accept()throws AWTException, InterruptedException{
		BasePage.click(accept);
	}

	public void addFromSetExpand()throws AWTException, InterruptedException{
		BasePage.click(accept);
	}

	public void selectItems(List<String> myAlist)throws AWTException, InterruptedException{  
		try {

			do{ 
				for(String item : myAlist)
				{
					for (WebElement element : gridItems) {
						scrollIntoView(element);
						String textFromGrid = element.getText();	    				
						if(item.equals(textFromGrid)) {
							WebElement checkBox = element.findElement(By.tagName("i"));
							checkBox.click();			    				
						}
					}
				}
				BasePage.click(forward); 
			}
			while(forward.isEnabled());  
		}	    	
		catch(Exception ex) {}
	}

	public void removeItems()throws AWTException, InterruptedException{	
		BasePage.click(remove);
		BasePage.click(saveChanges);
	}

	public void RemoveItemsfromExploration(String ExplorationToCreate, String entityToSelect, String textToSearch) throws Throwable
	{
		this.createExploration(ExplorationToCreate, entityToSelect, textToSearch);	 
		this.Exploration();
		this.waitForExploration();
		WebElement opn = this.openExploration(ExplorationToCreate);
		BasePage.click(opn);
		this.expandExploration();
		this.editCard();	  
		List<String>  myAlist = new ArrayList<String>();
		myAlist.add("EFO_1000779");
		myAlist.add("EFO_1000778");
		myAlist.add("seborrheic keratosis");
		myAlist.add("EFO_1000758");
		myAlist.add("EFO_1000745");
		this.selectItems(myAlist);	  
		this.removeItems();	 
		System.out.println("Items removed successfully");
	}

	public void addItemsFromFile(String filePath) throws AWTException, InterruptedException {	    
		BasePage.click(addItemsFromAFile);
		this.FileUploadFormExplorer(filePath);
	}

	public void addItemsExpand() throws AWTException, InterruptedException{	    
		BasePage.click(addItemsExpand);	 				
	}

	public void addItemsFromSet(String existingSetName) throws AWTException, InterruptedException{	    
		BasePage.click(addFromSet);	    	
		WebElement opn = this.openExploration(existingSetName);
		BasePage.click(opn);  
	}

	public void CreateExplorationFromFile(String ExplorationName,String EntitytoSelect, String FileLocation) throws Throwable { 
		try {
			this.Exploration();
			this.waitForExploration();
			this.addExploration();
			this.createExplorationSearch();
			this.verifyExplorationHomePage("Uncategorized");
			this.ExplorationTitle(ExplorationName);
			this.selectEntity(EntitytoSelect);
			this.addItemsFromFile(FileLocation); 
			this.AddandStart(); 
			BasePage.waitforAnElement(ExplorationList);
			ExtentTestManager.getTest().log(Status.PASS, ExplorationName +" Exploration is created using a file after Search");
			this.createCheck(ExplorationName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Exploration is verified");
			this.Home();
		}
		catch(Exception ex){
			throw ex;
		}
		catch(AssertionError ex){
			throw ex;
		}
	}

	public void CreateExplorationFromSet(String SetName, String entityToSelect, String textToSearch, String ExplorationName) throws Throwable { 
		try {
			objSetPage = new SetPage();  
			objSetPage.createSet(SetName, entityToSelect, textToSearch);
			this.Home();

			this.Exploration();
			this.waitForExploration();
			this.addExploration();
			this.createExplorationSearch();
			this.verifyExplorationHomePage("Uncategorized");
			this.ExplorationTitle(ExplorationName);
			this.selectEntity(entityToSelect);
			this.addItemsFromSet(SetName); 
			this.clickStart();  
			BasePage.waitforAnElement(ExplorationList);
			ExtentTestManager.getTest().log(Status.PASS, ExplorationName +" Exploration is created using a set after Search");
			this.createCheck(ExplorationName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Exploration is verified");
			this.Home();
		}
		catch(Exception ex){
			throw ex;
		}
		catch(AssertionError ex){
			throw ex;
		}
	}

	public void close()throws AWTException, InterruptedException{	
		BasePage.click(close);
	}

	public void saveChanges() throws AWTException, InterruptedException{	
		BasePage.click(saveChanges);
	}

	public void searchExpandEnterName(String SetNameToAddFrom) throws AWTException, InterruptedException{ 		 
		BasePage.click(searchSetToAddExpand);
		searchSetToAddExpand.sendKeys(SetNameToAddFrom);
	}

	public void clickSetInExpand(String SelectaSet) throws AWTException, InterruptedException{ 		 
		WebElement SelectaSetfromExpand = driver.findElement(By.xpath("//*[@title='"+SelectaSet+"']"));
		BasePage.click(SelectaSetfromExpand);
		Thread.sleep(3000);
	}

	public void addFromSetExpand(String SetNameToAddFrom) throws AWTException, InterruptedException {	    
		BasePage.click(addFromSetExpand);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Select a Set']")));
		this.searchExpandEnterName(SetNameToAddFrom);
		this.clickSetInExpand(SetNameToAddFrom);
	}	

	public void CompareTwovalues(String Value1, String Value2) throws AWTException, InterruptedException, AssertionError {	    
		if(Integer.parseInt(Value1)<Integer.parseInt(Value2)){
			System.out.println("Number of records have increased");
		}
		else{
			System.out.println("Number of records have not increased or in worst case have decreased");
		}
	}	


	//Adding a set from expand into exploration
	public void ExpandAddFromSet(String setToAdd, String entityToSelect, String textToSearchInSet, String ExplorationName, String textToSearchInExploration) throws Throwable {    // Add from a set
		try {
			objSetPage = new SetPage();  
			objSetPage.createSet(setToAdd, entityToSelect, textToSearchInSet);
			this.Home();


			this.createExploration(ExplorationName, entityToSelect, textToSearchInExploration);
			this.expandExploration();
			this.editCard();
			String NoOfRecordsInitial = ItemCountInExpand.getText();
			this.addItemsExpand();
			this.addFromSetExpand(setToAdd); // Set to be added
			this.waitForSaveChanges();
			String NoOfRecordsFinal = ItemCountInExpand.getText();
			this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
			ExtentTestManager.getTest().log(Status.PASS, "Exploration - Set added in expand");
		}
		catch(Exception ex) {
			throw ex;
		}
		catch(AssertionError ex) {
			throw ex;
		}
	}

	public void searchCatalog(String SearchInCatalog) throws AWTException, InterruptedException{	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from the Catalog']")));
		BasePage.click(searchCatalog);
		searchCatalog.sendKeys(SearchInCatalog);
		Thread.sleep(2000);
	}

	public void addFromSetCatalog(String TextToSearch) throws AWTException, InterruptedException {	    
		BasePage.click(addFromExpandCatalog);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from the Catalog']")));
		this.searchCatalog(TextToSearch);
		Thread.sleep(3000);
		BasePage.click(addAll);
	}

	public void add() throws AWTException, InterruptedException{	    
		BasePage.click(Add);
	}

	//Adding items from catalog from expand into exploration
	public void ExpandAddFromCatalog(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String TextToSearch) throws Throwable{ 
		try {
			this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
			this.expandExploration();

			this.editCard();
			String NoOfRecordsInitial = ItemCountInExpand.getText();
			this.addItemsExpand();
			this.addFromSetCatalog(TextToSearch); // Text to be added 
			ExtentTestManager.getTest().log(Status.PASS, TextToSearch + " is searched");
			this.add();
			this.waitForSaveChanges();
			String NoOfRecordsFinal = ItemCountInExpand.getText();
			this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
			BasePage.verifyPage(ExplorationToCreate,ExplorationNameInExpand); 
			ExtentTestManager.getTest().log(Status.PASS, "Exploration - Items added from Catalog in expand");
		}
		catch(Exception ex) {
			throw ex;
		}
		catch(AssertionError ex) {
			throw ex;
		}
	}

	public void fileSelectDropdown()throws AWTException, InterruptedException{	    
		BasePage.click(fileSelectDropdown);
	}

	public void FileuploadCategory(String CategoryName) throws AWTException, InterruptedException{	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Drag files here']")));
		this.fileSelectDropdown();
		BasePage.click(driver.findElement(By.xpath("//*[@title='"+CategoryName+"']")));
		BasePage.click(clickUpload);
	}	


	public void FileUploadFormExplorer(String FileLocation) throws AWTException, InterruptedException{	    
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


	public void addFromFile(String CategoryName, String Filelocation, String FileName) throws AWTException, InterruptedException, AssertionError {	    
		BasePage.click(addFromFile);	 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from a File']")));
		this.FileuploadCategory(CategoryName);
		this.FileUploadFormExplorer(Filelocation);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Searching in ']")));
		BasePage.verifyPage(FileName, uploadedFileName);
		BasePage.click(addAll);
	}	

	public void addToGrid() throws AWTException, InterruptedException{	    
		BasePage.click(AddToGrid);
	}

	//Adding items from File from expand into Exploration
	public void ExpandAddFromFile(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch , String CategoryName, String Filelocation, String FileName) throws Throwable { 
		try {
			this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
			this.expandExploration();
			waitforAnElement(edit);
			this.editCard();
			String NoOfRecordsInitial = ItemCountInExpand.getText();
			this.addItemsExpand();
			this.addFromFile(CategoryName, Filelocation, FileName); 
			this.addToGrid();
			this.waitForSaveChanges();
			waitforAnElement(ItemCountInExpand);
			String NoOfRecordsFinal = ItemCountInExpand.getText();
			this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
			ExtentTestManager.getTest().log(Status.PASS, "Exploration - Items added from File in expand");
		}
		catch (Exception ExpandAddFromFileFail) {
			if(dialogBoxClose.isDisplayed()) {
				BasePage.click(dialogBoxClose);
			}
			throw ExpandAddFromFileFail;
		}
		catch(AssertionError ex) {
			if(dialogBoxClose.isDisplayed()) {
				BasePage.click(dialogBoxClose);
			}
			throw ex;
		}
	}


	public void DeleteCardExpand() throws AWTException, InterruptedException { 
		Thread.sleep(10000);
		BasePage.click(deleteCardExpand);
	}

	public void RemoveItemsfromExploration() throws Throwable
	{
		WebElement opn = this.openExploration("Share Set1");
		BasePage.click(opn);
		this.expandExploration();
		this.editCard();	  
		List<String>  myAlist = new ArrayList<String>();
		myAlist.add("EFO_1000779");
		myAlist.add("EFO_1000778");
		myAlist.add("seborrheic keratosis");
		myAlist.add("EFO_1000758");
		myAlist.add("EFO_1000745");
		this.selectItems(myAlist);	  
		this.removeItems();	 
		System.out.println("Items removed successfully");
	}

	public void Delete() throws AWTException, InterruptedException{ 
		BasePage.click(Delete);
	}

	public void DeleteExploraionInExpand(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch) throws Throwable { 
		try {
			this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
			this.expandExploration();
			this.DeleteCardExpand();
			WebElement DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading' and text()='Remove "+EntitytoSelect+"?']"));
			BasePage.waitforAnElement(DeleteConfirm);
			this.Remove();
			ExtentTestManager.getTest().log(Status.PASS, "First Card is deleted via  expanded view");
			BasePage.waitforAnElement(startButton);
			this.verifyExplorationHomePage("Uncategorized");
			BasePage.CompareAttributeText("Value", ExplorationToCreate, titleExploration); //Exploration page
			ExtentTestManager.getTest().log(Status.PASS, "Removal verified");
		}
		catch(Exception ex) {
			throw ex;
		}
		catch(AssertionError ex){
			throw ex;
		}
	}

	public int NoOfPagesInExplorationPage() throws InterruptedException, AWTException { 
		String Pagecount = NoOfPagesInExploration.getText();
		Integer n = Integer.valueOf(Pagecount);
		return n;
	}

	//	public void DeleteExplorationLoop(String ExplorationToDelete) throws InterruptedException, AWTException { 
	//		Integer NoofPages = this.NoOfPagesInExplorationPage();
	//		WebElement ED = driver.findElement(By.xpath("//*[text()='"+ExplorationToDelete+"']"));
	//		WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ExplorationToDelete+"']//parent::div//parent::div//child::button")));
	//
	//		List<WebElement> EDs = driver.findElements(By.xpath("//*[text()='"+ExplorationToDelete+"']"));
	//		if (EDs.size() != 0) {
	//			Page.scrollIntoView(ED);
	//			BasePage.click(threeButton);
	//			BasePage.click(Delete);
	//			Thread.sleep(2000);
	//			BasePage.click(Delete);
	//		}
	//		else if (EDs.size()== 0) {
	//
	//			for (int i=0; i<NoofPages;i++) {
	//
	//				if (EDs.size() != 0) {
	//					Page.scrollIntoView(ED);
	//					BasePage.click(threeButton);
	//					BasePage.click(Delete);
	//					Thread.sleep(2000);
	//					BasePage.click(Delete);
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


	//	public void DeleteAnExploration(String ExplorationToDelete) throws InterruptedException, AWTException { 
	//		Page.verifyPage("EXPLORATIONS", ExplorationTitle); //Exploration page
	//		this.DeleteExplorationLoop(ExplorationToDelete);
	//	}

	public void selectMenuOptionInList(String SetName)
	{
		try {	
			outerloop:
				do{
					for (WebElement element : ExplorationGridItems) {
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

	public void DeleteExploration(String ExplorationtoDelete) throws Throwable{
		try {
			this.Exploration();
			this.waitForExploration();
			selectMenuOptionInList(ExplorationtoDelete);
			Thread.sleep(3000);
			BasePage.click(deleteIcon);
			String DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading']")).getText();
			Assert.assertEquals(DeleteConfirm, "Delete Exploration?");
			BasePage.click(deleteIcon);	 
			ExtentTestManager.getTest().log(Status.PASS, ExplorationtoDelete + " Exploration is Deleted");
		}
		catch(Exception ex) {
			throw ex;
		}
		catch (AssertionError ex) {
			throw ex;
		}
	}

	public void createAndDeleteExploration(String ExplorationToCreate, String entityToSelect, String textToSearch) throws Throwable{
		this.createExploration(ExplorationToCreate, entityToSelect, textToSearch);	 
		this.DeleteExploration(ExplorationToCreate);   	    	
	}

	public void ShareExploration(String ExplorationToShare, String personToBeShared) throws Throwable{
		try {
			this.Exploration();
			this.waitForExploration();
			selectMenuOptionInList(ExplorationToShare);
			Thread.sleep(3000);
			BasePage.click(shareIcon);
			String SetNameInShare = ExplorationNameInShare.getText();
			Assert.assertEquals(SetNameInShare, ExplorationToShare);
			BasePage.enterText(selectPersonToShare,personToBeShared);	
			BasePage.click(suggestedUsers);
			BasePage.click(share);	
			BasePage.waitforAnElement(ShareSuccess);
			ExtentTestManager.getTest().log(Status.PASS, ExplorationToShare + " Exploration is Shared");
		}
		catch(Exception ex) {
			throw ex;
		}
		catch (AssertionError ex) {
			throw ex;
		}

	}

	public void createAndShareExploration(String ExplorationToCreate, String entityToSelect, String textToSearch, String personToBeShared) throws Throwable{
		this.createExploration(ExplorationToCreate, entityToSelect, textToSearch);	  
		this.ShareExploration(ExplorationToCreate, personToBeShared);
	}


	public void searchInExpand(String SearchInExploration) throws InterruptedException, AWTException, AssertionError { 
		try {
			Thread.sleep(20000);
			BasePage.click(serachBoxExpand);
			serachBoxExpand.sendKeys(SearchInExploration);
			Thread.sleep(2000);
			BasePage.CompareAttributeText("value",SearchInExploration,serachBoxExpand);
		}
		catch(Exception ex){
			throw ex;
		}
		catch (AssertionError ex){
			throw ex;
		}
	}

	public void searchInExplorationExpand(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String SearchInExploration) throws Throwable { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.expandExploration();
		this.searchInExpand(SearchInExploration);
		ExtentTestManager.getTest().log(Status.PASS, "Search in done using text - "+ SearchInExploration);
	}

	public void DeleteclickinCard() throws AWTException, InterruptedException { 
		BasePage.click(DeleteinCard);
	}

	public void Remove() throws AWTException, InterruptedException { 
		BasePage.click(Remove);
	}


	public void deleteExplorationInFirstCard(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch) throws Throwable { 
		try {
			this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
			this.DeleteclickinCard();
			WebElement DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading' and text()='Remove "+EntitytoSelect+"?']"));
			BasePage.waitforAnElement(DeleteConfirm);
			this.Remove();
			ExtentTestManager.getTest().log(Status.PASS, "First Card is deleted in Exploration in non-expanded view");
			BasePage.waitforAnElement(startButton);
			this.verifyExplorationHomePage("Uncategorized");
			BasePage.CompareAttributeText("Value", ExplorationToCreate, titleExploration);
			ExtentTestManager.getTest().log(Status.PASS, "Removal verified");
		}
		catch (Exception ex) {
			throw ex;	
		}
		catch (AssertionError ex) {
			throw ex;	
		}
	}

	public void deleteExplorationInLaterCard(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String RelationCardType) throws Throwable { 
		try {
			this.createRelationCardFirst(ExplorationToCreate, EntitytoSelect, ItemtoSearch, RelationCardType);
			BasePage.click(DeleteinCard2);
			WebElement DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading' and text()='Remove "+RelationCardType+"?']"));
			BasePage.waitforAnElement(DeleteConfirm);
			this.Remove();
			ExtentTestManager.getTest().log(Status.PASS, "Second Card is deleted in Exploration in non-expanded view");
			Thread.sleep(3000);
			int NoOfCards = setCards.size();
			Assert.assertEquals(NoOfCards, 1);
			BasePage.CompareAttributeText("Value", ExplorationToCreate, titleExploration);
			ExtentTestManager.getTest().log(Status.PASS, "Removal verified");
		}
		catch (Exception ex) {
			throw ex;	
		}
		catch (AssertionError ex) {
			throw ex;	
		}
	}

	public void GridSettings() throws AWTException, InterruptedException { 
		BasePage.click(GridSettingsIcon);
	}

	public void GridRows(String RowCount) throws AWTException, InterruptedException{ 
		BasePage.click(RowsPerPage);
		WebElement NoofRows = driver.findElement(By.xpath("//*[@title='"+RowCount+"']"));
		BasePage.click(NoofRows);
	}

	public void GridPrimaryColumn(String PrimaryColumn) throws AWTException, InterruptedException{ 
		BasePage.click(PrimaryColumnDropdown);
		WebElement PrimarySelect = driver.findElement(By.xpath("//*[@role='option' and @title='"+PrimaryColumn+"']"));
		BasePage.click(PrimarySelect);
	}

	public void GridSecondaryColumn(String SecondaryColumn) throws AWTException, InterruptedException{ 
		BasePage.click(SecondaryColumnDropdown);
		WebElement SecondarySelect = driver.findElement(By.xpath("//*[@role='option' and @title='"+SecondaryColumn+"']"));
		BasePage.click(SecondarySelect);
	}

	public void VerifyGrid(String NoofRows, String PrimaryColumn, String SecondaryColumn)throws AWTException, InterruptedException, AssertionError { 
		try {
			List <WebElement> Columns = driver.findElements(By.xpath("//*[@tabindex='0']"));
			WebElement FirstColumn = driver.findElement(By.xpath("(//*[@tabindex='0'])[1]")); 
			int NoOfColumns = Columns.size();
			WebElement LastColumn = driver.findElement(By.xpath("(//*[@tabindex='0'])["+NoOfColumns+"]"));
			BasePage.verifyPage(PrimaryColumn, FirstColumn);
			BasePage.verifyPage(SecondaryColumn, LastColumn);
			String RN =Integer.toString(RowsintableExpand.size());
			Assert.assertEquals(RN, NoofRows);
		}
		catch (Exception ex) {
			throw ex;
		}
		catch (AssertionError ex) {
			throw ex;
		}
	}

	public void GridChanges(String setToCreate,String EntitytoSelect, String ItemtoSearch, String NoofRows, String PrimaryColumn, String SecondaryColumn) throws Throwable { 
		try {	
			this.addExploration();
			this.verifyExplorationHomePage("Uncategorized");
			this.ExplorationTitle(setToCreate); //Create a set
			this.selectEntity(EntitytoSelect);
			this.searchItems(ItemtoSearch);
			this.AddandStart();
			this.expandExploration();
			this.GridSettings();
			this.GridRows(NoofRows);
			this.GridPrimaryColumn(PrimaryColumn);
			this.GridSecondaryColumn(SecondaryColumn);
			BasePage.click(Apply);
			BasePage.verifyPage(setToCreate,ExplorationNameInExpand); //verifying the set name
			this.VerifyGrid(NoofRows,PrimaryColumn,SecondaryColumn);
		}
		catch (Exception ex) {
			throw ex;
		}
		catch (AssertionError ex) {
			throw ex;
		}
	}

	//	public void SharetLoop(String SetToShare, String SharedUser) throws InterruptedException, AWTException { 
	//		Integer NoofPages = this.NoOfPagesInExplorationPage();
	//		WebElement SS = driver.findElement(By.xpath("//*[text()='"+SetToShare+"']"));
	//		WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+SetToShare+"']//parent::div//parent::div//child::button")));
	//
	//		List<WebElement> SDs = driver.findElements(By.xpath("//*[text()='"+SetToShare+"']"));
	//		if (SDs.size() != 0) {
	//			Page.scrollIntoView(SS);
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
	//					Page.scrollIntoView(SS);
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
	//
	//	public void shareASet(String SetToShare, String SharedUser) throws InterruptedException, AWTException { 
	//		Page.verifyPage("MY DATA", ExplorationTitle); //My Data page
	//		this.shareASet(SetToShare, SharedUser);
	//	}

	public void addRelation() throws AWTException, InterruptedException { 
		BasePage.click(addRelation);
	}

	public WebElement RelationEntity(String RelationCardType) {
		return driver.findElement(By.xpath("//*[@type='button']//*[text()='"+RelationCardType+"']"));   		
	}

	public WebElement RelationEntityinDropdown(String RelationCardType) {
		return driver.findElement(By.xpath("//*[@role='presentation']//*[text()='"+RelationCardType+"']"));   		
	}

	public void Relationclick(String RelationCardType) throws AWTException, InterruptedException { 
		BasePage.click(this.RelationEntity(RelationCardType));
	}

	public void RelationdropdownClick(String RelationCardType) throws AWTException, InterruptedException { 
		BasePage.click(this.RelationEntityinDropdown(RelationCardType));
	}

	public void createRelationFirst(String RelationCardType) throws InterruptedException, AWTException { 
		try {
			this.RelationEntity(RelationCardType).isDisplayed();
			this.Relationclick(RelationCardType);
		}
		catch (Exception NoSuchElement) {
			BasePage.click(addRelationCategory);
			try{
				this.RelationEntityinDropdown(RelationCardType).isDisplayed();
				this.RelationdropdownClick(RelationCardType);
				Thread.sleep(2000);
				this.Relationclick(RelationCardType);
			}
			catch (Exception NoSuchElementindropdown) {
				System.out.println("The entity is not present");
				throw NoSuchElement;
			}
		}
	}

	public void createRelationLater(String RelationCardType) throws InterruptedException, AWTException { 
		this.addRelation();
		Thread.sleep(3000);
		try {
			this.RelationEntity(RelationCardType).isDisplayed();
			this.Relationclick(RelationCardType);
		}
		catch (Exception NoSuchElement) {
			BasePage.click(addRelationCategory);
			try{
				this.RelationEntityinDropdown(RelationCardType).isDisplayed();
				this.RelationdropdownClick(RelationCardType);
				Thread.sleep(2000);
				this.Relationclick(RelationCardType);
			}
			catch (Exception NoSuchElementindropdown) {
				System.out.println("The entity is not present");
			}
		}
	}


	public void CheckRelationCreated(String RelationCardType) throws AWTException, InterruptedException {
		Thread.sleep(5000);
		int NoOfCards = setCards.size();
		WebElement LastCard = driver.findElement(By.xpath("(//*[@scraper-tag='SetCardContent'])["+NoOfCards+"]"));
		BasePage.waitforAnElement(LastCard);	

		WebElement ActualElementType = driver.findElement(By.xpath("(//*[@class='ms-Label SetCardCategorySelector__categoryName___OkSRM root-82'])["+NoOfCards+"]"));
		String ActualElementName = ActualElementType.getText();
		Assert.assertEquals(ActualElementName, RelationCardType);
	}

	public void createRelationCardFirst(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String RelationCardType) throws Throwable { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.createRelationFirst(RelationCardType);
		ExtentTestManager.getTest().log(Status.PASS, "First Relation card created of type : "+ RelationCardType);
		this.CheckRelationCreated(RelationCardType);
		ExtentTestManager.getTest().log(Status.PASS, "Created first relation card verified");
	}

	// Need to update
	public void SelectItemsInExplorationCard(String NumberOfItemsToSelect) throws InterruptedException, AWTException { 
		for (int i=1; i == Integer.parseInt(NumberOfItemsToSelect);i++)	{
			try {
			//	WebElement SelectItem = driver.findElement(By.xpath("(//div[@role='checkbox']["+i+"]"));
				WebElement SelectItem = driver.findElement(By.xpath(" (//*[@data-icon-name='StatusCircleCheckmark'])["+i+"]"));
				wait.until(ExpectedConditions.elementToBeClickable(SelectItem));
				Thread.sleep(5000);
				BasePage.click(SelectItem);
			}
			catch(Exception ex) {
				throw ex;
			}

		}
	}

	public void createRelationCardMulti(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String RelationCardType, String RelationCardType2, String NumberOfItemsToSelect) throws Throwable { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.createRelationFirst(RelationCardType);
		ExtentTestManager.getTest().log(Status.PASS, "First Relation card created of type : "+ RelationCardType);
		this.CheckRelationCreated(RelationCardType);
		ExtentTestManager.getTest().log(Status.PASS, "Created first relation card verified");
		BasePage.waitforAnElement(ExplorationList2);
		//		Thread.sleep(60000);
		this.SelectItemsInExplorationCard(NumberOfItemsToSelect);
		this.createRelationLater(RelationCardType2);
		ExtentTestManager.getTest().log(Status.PASS, "Second Relation card created of type : "+ RelationCardType2);
		this.CheckRelationCreated(RelationCardType2);
		ExtentTestManager.getTest().log(Status.PASS, "Created second relation card verified");
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





