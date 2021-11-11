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

	@FindBy(xpath = "//*[@data-icon-name='Delete']//parent::span")
	public WebElement deleteCardExpand;	

	@FindBy(xpath = "//*[@class='ListExplorations__title___1KG1C']")
	public WebElement ExplorationTitle;	

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
	


	public WebElement openExploration(String name) {
		return driver.findElement(By.xpath("//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']//div[@title='"+ name +"']"));   		
	}

	//Page level functions on the objects
	WebDriverWait wait = new WebDriverWait(driver, 5);
	Actions action = new Actions(driver);

	public void Home(){    	
		BasePage.click(homeIcon);
		action.moveToElement(TermsOfUse).perform();
	}  

	public ExplorationPage(){ 	
		PageFactory.initElements(driver, this); 
		BasePage.click(explorationIcon);
		action.moveToElement(TermsOfUse).perform();
	}

	public void Exploration(){ 	
		BasePage.click(explorationIcon);
		action.moveToElement(TermsOfUse).perform();
	}

	public void verifyExplorationHomePage(String stringToVerify){    	
		BasePage.verifyPage(stringToVerify, pageIdentifier);
	}

	public void addExploration(){ 
		BasePage.click(addExploration);
	}

	public void createExplorationSearch(){ 
		BasePage.click(searchforentities);
	}

	public void clickStart() {	    	
		BasePage.click(startButton);        
	}   

	public void createExplorationSet(String setToAdd) throws InterruptedException{ 
		BasePage.click(selectaSet);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Select a Set']")));
		this.searchExpandEnterName(setToAdd);
		this.clickSetInExpand(setToAdd);
		Thread.sleep(10000);
	}

	public void ExplorationTitle(String textTitle) throws InterruptedException{    	
		BasePage.enterText(titleExploration, textTitle);
	}   

	public void selectEntity(String entityToSelect){    	
		BasePage.click(pageIdentifier);
		WebElement entitytoSelect = driver.findElement(By.xpath("//button//span[contains(text(),'"+entityToSelect+"')]"));
		BasePage.click(entitytoSelect);
	}

	public void searchItems(String ItemtoSearch) throws InterruptedException{
		BasePage.click(serachBox);
		BasePage.enterText(serachBox, ItemtoSearch);
	}

	public void createCheck(String ExplorationToCheck) throws InterruptedException{	    	
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
	}   

	public void AddandStart(){
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

	public void createExplorationFromSearch(String ExplorationName, String EntitytoSelect, String ItemtoSearch) throws InterruptedException{	    	
		this.Exploration();
		this.addExploration();
		this.createExplorationSearch();
		this.verifyExplorationHomePage("Uncategorized");
		this.ExplorationTitle(ExplorationName);
		this.selectEntity(EntitytoSelect);
		this.searchItems(ItemtoSearch); 
		this.AddandStart();   
		BasePage.waitforAnElement(ExplorationList);
		System.out.println("Exploration Created successfully from search");
		this.createCheck(ExplorationName);
	}   	

	public void createExploration(String ExplorationName, String EntitytoSelect, String ItemtoSearch) throws InterruptedException{	    	
		this.Exploration();
		this.addExploration();
		this.createExplorationSearch();
		this.verifyExplorationHomePage("Uncategorized");
		Thread.sleep(10000);
		this.ExplorationTitle(ExplorationName);
		this.selectEntity(EntitytoSelect);
		this.searchItems(ItemtoSearch); 
		this.AddandStart();   
		BasePage.waitforAnElement(ExplorationList);
		System.out.println("Exploration Created successfully");
	}   	

	public void createExplorationInitallyFromSet(String SetName,String entityToSelect, String textToSearch , String ExplorationName) throws InterruptedException{	    	
		objSetPage = new SetPage();  
		objSetPage.createSet(SetName, entityToSelect, textToSearch);
		this.Home();

		this.Exploration();
		this.addExploration();
		this.createExplorationSet(SetName);
		this.ExplorationTitle(ExplorationName);
		BasePage.waitforAnElement(ExplorationList);
		System.out.println("Exploration Created successfully Initially from Set");
		this.createCheck(ExplorationName);
		this.Home();
	}  

	public void expandExploration(){
		BasePage.click(expand);
	}

	public void editCard(){
		BasePage.click(edit);
	}

	public void accept(){
		BasePage.click(accept);
	}

	public void addFromSetExpand(){
		BasePage.click(accept);
	}

	public void selectItems(List<String> myAlist){  
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

	public void removeItems(){	
		BasePage.click(remove);
		BasePage.click(saveChanges);
	}

	public void RemoveItemsfromSet()
	{
		WebElement opn = this.openExploration("MASI Set");
		BasePage.click(opn);
		this.expandExploration();
		this.editCard();	  
		List<String>  myAlist = new ArrayList<String>();
		myAlist.add("DIS28");
		myAlist.add("DIS53");
		myAlist.add("DIS3");
		myAlist.add("DIS2");
		myAlist.add("DIS1");
		this.selectItems(myAlist);	  
		this.removeItems();	    	
	}

	public void addItemsFromFile(String filePath) throws AWTException, InterruptedException {	    
		BasePage.click(addItemsFromAFile);
		this.FileUploadFormExplorer(filePath);
	}

	public void addItemsExpand() {	    
		BasePage.click(addItemsExpand);	 				
	}

	public void addItemsFromSet(String existingSetName) {	    
		BasePage.click(addFromSet);	    	
		WebElement opn = this.openExploration(existingSetName);
		BasePage.click(opn);  
	}

	public void CreateExplorationFromFile(String ExplorationName,String EntitytoSelect, String FileLocation) throws InterruptedException, AWTException { 
		this.addExploration();
		this.createExplorationSearch();
		this.verifyExplorationHomePage("Uncategorized");
		this.ExplorationTitle(ExplorationName);
		this.selectEntity(EntitytoSelect);
		this.addItemsFromFile(FileLocation); 
		this.AddandStart(); 
		BasePage.waitforAnElement(ExplorationList);
		System.out.println("Exploration Created successfully from search and file within");
		this.createCheck(ExplorationName);
		this.Home();
	}

	public void CreateExplorationFromSet(String SetName, String entityToSelect, String textToSearch, String ExplorationName) throws InterruptedException { 
		objSetPage = new SetPage();  
		objSetPage.createSet(SetName, entityToSelect, textToSearch);
		this.Home();

		this.addExploration();
		this.createExplorationSearch();
		this.verifyExplorationHomePage("Uncategorized");
		this.ExplorationTitle(ExplorationName);
		this.selectEntity(entityToSelect);
		this.addItemsFromSet(SetName); 
		this.clickStart();  
		BasePage.waitforAnElement(ExplorationList);
		System.out.println("Exploration Created successfully from search and then from a set within");
		this.createCheck(ExplorationName);
		this.Home();
	}

	public void close(){	
		BasePage.click(close);
	}

	public void saveChanges(){	
		BasePage.click(saveChanges);
	}

	public void searchExpandEnterName(String SetNameToAddFrom){ 		 
		BasePage.click(searchSetToAddExpand);
		searchSetToAddExpand.sendKeys(SetNameToAddFrom);
	}

	public void clickSetInExpand(String SelectaSet) throws InterruptedException{ 		 
		WebElement SelectaSetfromExpand = driver.findElement(By.xpath("//*[@title='"+SelectaSet+"']"));
		BasePage.click(SelectaSetfromExpand);
		Thread.sleep(3000);
	}

	public void addFromSetExpand(String SetNameToAddFrom) throws InterruptedException {	    
		BasePage.click(addFromSetExpand);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Select a Set']")));
		this.searchExpandEnterName(SetNameToAddFrom);
		this.clickSetInExpand(SetNameToAddFrom);
	}	

	public void CompareTwovalues(String Value1, String Value2) throws InterruptedException {	    
		if(Integer.parseInt(Value1)<Integer.parseInt(Value2)){
			System.out.println("Number of records have increased");
		}
		else{
			System.out.println("Number of records have not increased or in worst case have decreased");
		}
	}	


	//Adding a set from expand into exploration
	public void ExpandAddFromSet(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String setToAdd) throws InterruptedException {    // Add from a set
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.expandExploration();
		this.editCard();
		String NoOfRecordsInitial = ItemCountInExpand.getText();
		this.addItemsExpand();
		this.addFromSetExpand(setToAdd); // Set to be added
		Thread.sleep(5000);
		String NoOfRecordsFinal = ItemCountInExpand.getText();
		this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
		System.out.println("Exploration - Set added in expand successfully");
	}

	public void searchCatalog(String SearchInCatalog) throws InterruptedException{	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from the Catalog']")));
		BasePage.click(searchCatalog);
		searchCatalog.sendKeys(SearchInCatalog);
		Thread.sleep(2000);
	}

	public void addFromSetCatalog(String TextToSearch) throws InterruptedException {	    
		BasePage.click(addFromExpandCatalog);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from the Catalog']")));
		this.searchCatalog(TextToSearch);
		Thread.sleep(3000);
		BasePage.click(addAll);
	}

	public void add(){	    
		BasePage.click(Add);
	}

	//Adding items from catalog from expand into exploration
	public void ExpandAddFromCatalog(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String TextToSearch) throws InterruptedException { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.expandExploration();
		this.editCard();
		String NoOfRecordsInitial = ItemCountInExpand.getText();
		this.addItemsExpand();
		this.addFromSetCatalog(TextToSearch); // Text to be added 
		this.add();
		Thread.sleep(5000);
		String NoOfRecordsFinal = ItemCountInExpand.getText();
		this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
		System.out.println("Exploration - Items added from Catalog in expand successfully");
	}

	public void fileSelectDropdown(){	    
		BasePage.click(fileSelectDropdown);
	}

	public void FileuploadCategory(String CategoryName) {	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Drag files here']")));
		this.fileSelectDropdown();
		BasePage.click(driver.findElement(By.xpath("//*[@title='"+CategoryName+"']")));
		BasePage.click(clickUpload);
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


	public void addFromFile(String CategoryName, String Filelocation, String FileName) throws AWTException, InterruptedException {	    
		BasePage.click(addFromFile);	 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from a File']")));
		this.FileuploadCategory(CategoryName);
		this.FileUploadFormExplorer(Filelocation);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Searching in ']")));
		BasePage.verifyPage(FileName, uploadedFileName);
		BasePage.click(addAll);
	}	

	public void addToGrid(){	    
		BasePage.click(AddToGrid);
	}

	//Adding items from File from expand into Exploration
	public void ExpandAddFromFile(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch , String CategoryName, String Filelocation, String FileName) throws InterruptedException, AWTException { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.expandExploration();
		Thread.sleep(30000);
		this.editCard();
		String NoOfRecordsInitial = ItemCountInExpand.getText();
		this.addItemsExpand();
		this.addFromFile(CategoryName, Filelocation, FileName); 
		this.addToGrid();
		Thread.sleep(5000);
		String NoOfRecordsFinal = ItemCountInExpand.getText();
		this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
		System.out.println("Exploration - Items added from File in expand successfully");
	}


	public void DeleteCardExpand() throws InterruptedException { 
		Thread.sleep(5000);
		BasePage.click(deleteCardExpand);
	}

	public void Delete() { 
		BasePage.click(Delete);
	}

		public void DeleteExploraionInExpand(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch) throws InterruptedException, AWTException { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.expandExploration();
		this.DeleteCardExpand();
		WebElement DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading' and text()='Remove "+EntitytoSelect+"?']"));
		BasePage.waitforAnElement(DeleteConfirm);
		this.Remove();
		BasePage.waitforAnElement(startButton);
		this.verifyExplorationHomePage("Uncategorized");
		BasePage.CompareAttributeText("Value", ExplorationToCreate, titleExploration); //Exploration page
		System.out.println("First Card deleted from  expanded view");
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
	
	public void DeleteExploration(String SettoDelete) throws InterruptedException{
		this.Exploration();
		Thread.sleep(10000);
		BasePage.waitforAnElement(columnHeaderFirstPage);
		selectMenuOptionInList(SettoDelete);
		Thread.sleep(3000);
		BasePage.click(deleteIcon);
		String DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading']")).getText();
		Assert.assertEquals(DeleteConfirm, "Delete Exploration?");
		BasePage.click(deleteIcon);	    	    	
	}
	
	public void createAndDeleteExploration(String ExplorationToCreate, String entityToSelect, String textToSearch) throws InterruptedException{
		this.createExploration(ExplorationToCreate, entityToSelect, textToSearch);	 
		this.DeleteExploration(ExplorationToCreate);   	    	
	}

	public void ShareExploration(String ExplorationToShare, String personToBeShared) throws InterruptedException{
		this.Exploration();
		Thread.sleep(10000);
		BasePage.waitforAnElement(columnHeaderFirstPage);
		selectMenuOptionInList(ExplorationToShare);
		Thread.sleep(3000);
		BasePage.click(shareIcon);
		String SetNameInShare = ExplorationNameInShare.getText();
		Assert.assertEquals(SetNameInShare, ExplorationToShare);
		BasePage.enterText(selectPersonToShare,personToBeShared);	
		BasePage.click(suggestedUsers);
		BasePage.click(share);	
		BasePage.waitforAnElement(ShareSuccess);
	}
	
	public void createAndShareExploration(String ExplorationToCreate, String entityToSelect, String textToSearch, String personToBeShared) throws InterruptedException{
		this.createExploration(ExplorationToCreate, entityToSelect, textToSearch);	  
		this.ShareExploration(ExplorationToCreate, personToBeShared);
	}


	public void searchInExpand(String SearchInExploration) throws InterruptedException, AWTException { 
		Thread.sleep(20000);
		BasePage.click(serachBoxExpand);
		serachBoxExpand.sendKeys(SearchInExploration);
		Thread.sleep(2000);
		BasePage.CompareAttributeText("value",SearchInExploration,serachBoxExpand);
	}

	public void searchInExplorationExpand(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String SearchInExploration) throws InterruptedException, AWTException { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.expandExploration();
		this.searchInExpand(SearchInExploration);
		System.out.println("Search performed");
	}

	public void DeleteclickinCard() { 
		BasePage.click(DeleteinCard);
	}

	public void Remove() { 
		BasePage.click(Remove);
	}


	public void deleteExplorationInFirstCard(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch) throws InterruptedException, AWTException { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.DeleteclickinCard();
		WebElement DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading' and text()='Remove "+EntitytoSelect+"?']"));
		BasePage.waitforAnElement(DeleteConfirm);
		this.Remove();
		BasePage.waitforAnElement(startButton);
		this.verifyExplorationHomePage("Uncategorized");
		BasePage.CompareAttributeText("Value", ExplorationToCreate, titleExploration);
		System.out.println("First card deleted");
	}

	public void deleteExplorationInLaterCard(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String RelationCardType) throws InterruptedException, AWTException { 
		this.createRelationCardFirst(ExplorationToCreate, EntitytoSelect, ItemtoSearch, RelationCardType);
		BasePage.click(DeleteinCard2);
		WebElement DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading' and text()='Remove "+RelationCardType+"?']"));
		BasePage.waitforAnElement(DeleteConfirm);
		this.Remove();
		Thread.sleep(3000);
		int NoOfCards = setCards.size();
		Assert.assertEquals(NoOfCards, 1);
		BasePage.CompareAttributeText("Value", ExplorationToCreate, titleExploration);
		System.out.println("Second card deleted");
	}

	public void GridSettings() { 
		BasePage.click(GridSettingsIcon);
	}

	public void GridRows(String RowCount) { 
		BasePage.click(RowsPerPage);
		WebElement NoofRows = driver.findElement(By.xpath("//*[@title='"+RowCount+"']"));
		BasePage.click(NoofRows);
	}

	public void GridPrimaryColumn(String PrimaryColumn) { 
		BasePage.click(PrimaryColumnDropdown);
		WebElement PrimarySelect = driver.findElement(By.xpath("//*[@role='option' and @title='"+PrimaryColumn+"']"));
		BasePage.click(PrimarySelect);
	}

	public void GridSecondaryColumn(String SecondaryColumn) { 
		BasePage.click(SecondaryColumnDropdown);
		WebElement SecondarySelect = driver.findElement(By.xpath("//*[@role='option' and @title='"+SecondaryColumn+"']"));
		BasePage.click(SecondarySelect);
	}

	public void VerifyGrid(String NoofRows, String PrimaryColumn, String SecondaryColumn) { 
		List <WebElement> Columns = driver.findElements(By.xpath("//*[@tabindex='0']"));
		WebElement FirstColumn = driver.findElement(By.xpath("(//*[@tabindex='0'])[1]")); 
		int NoOfColumns = Columns.size();
		WebElement LastColumn = driver.findElement(By.xpath("(//*[@tabindex='0'])["+NoOfColumns+"]"));
		BasePage.verifyPage(PrimaryColumn, FirstColumn);
		BasePage.verifyPage(SecondaryColumn, LastColumn);
		String RN =Integer.toString(RowsintableExpand.size());
		Assert.assertEquals(RN, NoofRows);
	}

	public void GridChanges(String setToCreate,String EntitytoSelect, String ItemtoSearch, String NoofRows, String PrimaryColumn, String SecondaryColumn) throws InterruptedException { 
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
		BasePage.verifyPage(setToCreate,setNameInExpand); //verifying the set name
		this.VerifyGrid(NoofRows,PrimaryColumn,SecondaryColumn);
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

	public void addRelation() { 
		BasePage.click(addRelation);
	}

	public WebElement RelationEntity(String RelationCardType) {
		return driver.findElement(By.xpath("//*[@type='button']//*[text()='"+RelationCardType+"']"));   		
	}

	public WebElement RelationEntityinDropdown(String RelationCardType) {
		return driver.findElement(By.xpath("//*[@role='presentation']//*[text()='"+RelationCardType+"']"));   		
	}

	public void Relationclick(String RelationCardType) { 
		BasePage.click(this.RelationEntity(RelationCardType));
	}

	public void RelationdropdownClick(String RelationCardType) { 
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


	public void CheckRelationCreated(String RelationCardType) throws InterruptedException {
		Thread.sleep(5000);
		int NoOfCards = setCards.size();
		WebElement LastCard = driver.findElement(By.xpath("(//*[@scraper-tag='SetCardContent'])["+NoOfCards+"]"));
		BasePage.waitforAnElement(LastCard);	

		WebElement ActualElementType = driver.findElement(By.xpath("(//*[@class='ms-Label SetCardCategorySelector__categoryName___OkSRM root-82'])["+NoOfCards+"]"));
		String ActualElementName = ActualElementType.getText();
		Assert.assertEquals(ActualElementName, RelationCardType);
	}

	public void createRelationCardFirst(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String RelationCardType) throws InterruptedException, AWTException { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.createRelationFirst(RelationCardType);
		this.CheckRelationCreated(RelationCardType);
	}

	// Need to update
	public void SelectItemsInExplorationCard(String NumberOfItemsToSelect) throws InterruptedException, AWTException { 
		for (int i=1; i == Integer.parseInt(NumberOfItemsToSelect);i++)	{
//			try
//			{
//				
//			}
//			catch(Exception e)
//			{
//				
//			}
			WebElement SelectItem = driver.findElement(By.xpath("(//div[@role='checkbox']["+i+"]"));
			wait.until(ExpectedConditions.elementToBeClickable(SelectItem));
			Thread.sleep(5000);
			BasePage.click(SelectItem);
		}
	}

	public void createRelationCardMulti(String ExplorationToCreate, String EntitytoSelect, String ItemtoSearch, String RelationCardType, String RelationCardType2, String NumberOfItemsToSelect) throws InterruptedException, AWTException { 
		this.createExploration(ExplorationToCreate, EntitytoSelect, ItemtoSearch);
		this.createRelationFirst(RelationCardType);
		this.CheckRelationCreated(RelationCardType);
		BasePage.waitforAnElement(ExplorationList2);
//		Thread.sleep(60000);
		this.SelectItemsInExplorationCard(NumberOfItemsToSelect);
		this.createRelationLater(RelationCardType2);
		this.CheckRelationCreated(RelationCardType2);
	}
	
    public String captureScreenshot(String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "./Resources/ErrorScreenshots/"+screenShotName+".jpeg";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }     
                     
        return dest;
    }


}


//List <WebElement> Columns = webdriver.findElements(By.xpath("//*[@tabindex='0']"));
//int NoOfColumns = Columns.size();
//System.out.println(NoOfColumns);        //getting the number of columns




