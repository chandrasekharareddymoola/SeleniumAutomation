package com.eagle.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SetPage extends Page{

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

	@FindBy(xpath = "//button//span[contains(text(),'Delete')]")
	public WebElement deleteIcon;

	@FindBy(xpath = "//button//span[contains(text(),'Share')]")
	public WebElement shareIcon;

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
	
	
	
	//Page level functions on the objects
	WebDriverWait wait = new WebDriverWait(driver, 5);
	Actions action = new Actions(driver);

	public WebElement openSet(String name) {
		return this.driver.findElement(By.xpath("//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']//div[@title='"+ name +"']"));   		
	}

	public void Home(){    	
		Page.click(homeIcon);
		action.moveToElement(TermsOfUse).perform();
	}   

	public SetPage(){ 		 
		PageFactory.initElements(driver, this); 
		Page.click(setIcon);
		action.moveToElement(TermsOfUse).perform();
	}

	public void Set(){ 	
		Page.click(setIcon);
		action.moveToElement(TermsOfUse).perform();
	}

	public void verifySetHomePage(String stringToVerify){    	
		Page.verifyPage(stringToVerify, pageIdentifier);
	}

	public void addSet(){ 
		Page.click(addSet);
	}

	public void setTitle(String textTitle) throws InterruptedException{    	
		Page.enterText(titleSet, textTitle);
	}   

	public void selectEntity(String entityToSelect){    	
		Page.click(pageIdentifier);
		WebElement entity = driver.findElement(By.xpath("//button//span[contains(text(),'"+entityToSelect+"')]"));
		Page.click(entity);
	}

	public void searchItems(String textToSearch) throws InterruptedException{
		Page.click(serachBox);
		Page.enterText(serachBox, textToSearch);

	}

	//	editCardIcon
	public void AddandAccept(){
		//wait.until(ExpectedConditions.elementToBeClickable(addAll));
		while(addAll.isDisplayed()){
			try
			{   Page.click(addAll);	 
			wait.until(ExpectedConditions.elementToBeClickable(addAll));
			}
			catch(Exception ex){
				break;
			}	    		
		}
		Page.click(accept);
	}

	public void createCheck(String SetToCheck) throws InterruptedException{	    	
		this.Set();
		Page.waitforAnElement(columnHeaderFirstPage);
		try {
			Assert.assertEquals(SetToCheck, FirstItem.getText());
			System.out.println("Set is present in the list");
			Thread.sleep(5000);
		}
		catch (Exception setNotPresent){
			System.out.println("Set is not present in the list");
		}
	}   	

	public void createSet(String SetName,String entityToSelect, String textToSearch) throws InterruptedException{	    	
		this.Set();
		this.addSet();
		this.verifySetHomePage("Uncategorized");
		this.setTitle(SetName);
		this.selectEntity(entityToSelect);
		this.searchItems(textToSearch); 
		this.AddandAccept(); 	
		Page.waitforAnElement(editCardIcon);
		System.out.println("Set Created successfully");
		this.createCheck(SetName);
		this.Home();
	}   	  	    

	public void expandSet(){
		Page.click(expand);
	}

	public void editSet(){
		Page.click(edit);
	}

	public void accept(){
		Page.click(accept);
	}

	public void addFromSetExpand(){
		Page.click(accept);
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
				Page.click(forward); 
			}
			while(forward.isEnabled());  
		}	    	
		catch(Exception ex) {}
	}

	public void removeItems(){	
		Page.click(remove);
		Page.click(saveChanges);
	}

	public void RemoveItemsfromSet()
	{
		WebElement opn = this.openSet("MASI Set");
		Page.click(opn);
		this.expandSet();
		this.editSet();	  
		List<String>  myAlist = new ArrayList<String>();
		myAlist.add("DIS28");
		myAlist.add("DIS53");
		myAlist.add("DIS3");
		myAlist.add("DIS2");
		myAlist.add("DIS1");
		this.selectItems(myAlist);	  
		this.removeItems();	 
		System.out.println("Items removed successfully");
	}

	public void addItemsFromFile(String filePath) {	    
		fileUpload.sendKeys(filePath);				
	}

	public void addItemsExpand() {	    
		Page.click(addItemsExpand);	 				
	}

	public void addItemsFromSet(String existingSetName) {	    
		Page.click(addFromSet);	    	
		WebElement opn = this.openSet(existingSetName);
		Page.click(opn);  
	}

	public void CreateSetFromFile(String setToCreate, String entityToSelect, String FileName) throws InterruptedException { 
		this.Set();
		this.addSet();
		this.verifySetHomePage("Uncategorized");
		this.setTitle(setToCreate);
		this.selectEntity(entityToSelect);
		//this.addItemsFromFile("C:\\Users\\DivyaDevanathan\\Downloads\\up_genes_symbol.txt"); 
		this.addItemsFromFile(FileName); 
		this.AddandAccept();
		Page.waitforAnElement(editCardIcon);
		System.out.println("Set Created from file successfully");
		this.createCheck(setToCreate);
		this.Home();
	}

	public void CreateSetFromSet(String existingSetName, String entityToSelect, String textToSearch, String setToCreate) throws InterruptedException { 
		this.createSet(existingSetName, entityToSelect, textToSearch);
		this.addSet();
		this.verifySetHomePage("Uncategorized");
		this.setTitle(setToCreate);
		this.selectEntity(entityToSelect);
		this.addItemsFromSet(existingSetName); 
		this.accept();
		Page.waitforAnElement(editCardIcon);
		System.out.println("Set Created from Set successfully");
		this.createCheck(setToCreate);
		this.Home();
	}

	public void close(){	
		Page.click(close);
	}

	public void saveChanges(){	
		Page.click(saveChanges);
		this.Home();
	}

	public void searchExpandEnterName(String SetNameToAddFrom){ 		 
		Page.click(searchSetToAddExpand);
		searchSetToAddExpand.sendKeys(SetNameToAddFrom);
	}

	public void clickSetInExpand(String SelectaSet) throws InterruptedException{ 		 
		WebElement SelectaSetfromExpand = driver.findElement(By.xpath("//*[@title='"+SelectaSet+"']"));
		Page.click(SelectaSetfromExpand);
		Thread.sleep(3000);
	}

	public void addFromSetExpand(String SetNameToAddFrom) throws InterruptedException {	    
		Page.click(addFromSetExpand);
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

	//Adding items from Set from expand into Set
	public void ExpandAddFromSet(String setToAdd, String entityToSelect,String textToSearchSet1, String setToCreate, String textToSearchSet2) throws InterruptedException {    // Add from a set
		this.createSet(setToAdd, entityToSelect, textToSearchSet1);
		this.addSet();
		this.verifySetHomePage("Uncategorized");
		this.setTitle(setToCreate); //Create a set
		this.selectEntity(entityToSelect);
		this.searchItems(textToSearchSet2);
		this.AddandAccept();
		System.out.println("Set created successfully");
		this.expandSet();
		this.editSet();
		String NoOfRecordsInitial = ItemCountInExpand.getText();
		this.addItemsExpand();
		this.addFromSetExpand(setToAdd); // Set to be added
		Thread.sleep(5000);
		String NoOfRecordsFinal = ItemCountInExpand.getText();
		this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
		Page.verifyPage(setToCreate,setNameInExpand); //verifying the set name
		System.out.println("Set - Set added in expand successfully");

	}

	public void searchCatalog(String SearchInCatalog) throws InterruptedException{	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from the Catalog']")));
		Page.click(searchCatalog);
		searchCatalog.sendKeys(SearchInCatalog);
		Thread.sleep(2000);
	}

	public void addFromSetCatalog(String TextToSearch) throws InterruptedException {	    
		Page.click(addFromExpandCatalog);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from the Catalog']")));
		this.searchCatalog(TextToSearch);
		Thread.sleep(3000);
		Page.click(addAll);
	}

	public void add(){	    
		Page.click(Add);
	}

	//Adding items from Catalog from expand into Set
	public void ExpandAddFromCatalog(String setToCreate, String entityToSelect, String textToSearch, String TextToSearch) throws InterruptedException { 
		this.addSet();
		this.verifySetHomePage("Uncategorized");
		this.setTitle(setToCreate); //Create a set
		this.selectEntity(entityToSelect);
		this.searchItems(textToSearch);
		this.AddandAccept();
		System.out.println("Set created successfully");
		this.expandSet();
		this.editSet();
		String NoOfRecordsInitial = ItemCountInExpand.getText();
		this.addItemsExpand();
		this.addFromSetCatalog(TextToSearch); // Text to be added 
		this.add();
		Thread.sleep(5000);
		String NoOfRecordsFinal = ItemCountInExpand.getText();
		this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
		Page.verifyPage(setToCreate,setNameInExpand); //verifying the set name
		System.out.println("Set - Added from catalog in expand successfully");
	}

	public void fileSelectDropdown(){	    
		Page.click(fileSelectDropdown);
	}

	public void FileuploadCategory(String CategoryName) throws InterruptedException {	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Drag files here']")));
		this.fileSelectDropdown();
		Page.click(driver.findElement(By.xpath("//*[@title='"+CategoryName+"']")));
		Page.click(clickUpload);
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
		Page.click(addFromFile);	 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from a File']")));
		this.FileuploadCategory(CategoryName);
		this.FileUploadFormExplorer(Filelocation);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Searching in ']")));
		Page.verifyPage(FileName, uploadedFileName);
		Page.click(addAll);
	}	

	public void addToGrid(){	    
		Page.click(AddToGrid);
	}

	//Adding items from File from expand into Set
	public void ExpandAddFromFile(String setToCreate, String entityToSelect, String textToSearch, String CategoryName, String Filelocation, String FileName) throws InterruptedException, AWTException { 
		this.addSet();
		this.verifySetHomePage("Uncategorized");
		this.setTitle(setToCreate); //Create a set
		this.selectEntity(entityToSelect);
		this.searchItems(textToSearch);
		this.AddandAccept();
		System.out.println("Set created successfully");
		this.expandSet();
		this.editSet();
		this.addItemsExpand();
		this.addFromFile(CategoryName, Filelocation, FileName); 
		this.addToGrid();
		Page.verifyPage(setToCreate,setNameInExpand); //verifying the set name
		System.out.println("Set - Added from file in expand successfully");
	}


	public void DeleteCardExpand() { 
		Page.click(deleteCardExpand);
	}

	public void Delete() { 
		Page.click(Delete);
	}

	public void DeleteCardInExpand(String setToCreate, String entityToSelect, String textToSearch) throws InterruptedException, AWTException { 
		this.addSet();
		this.verifySetHomePage("Uncategorized");
		this.setTitle(setToCreate); //Create a set
		this.selectEntity(entityToSelect);
		this.searchItems(textToSearch);
		this.AddandAccept();
		this.expandSet();
		this.DeleteCardExpand();
		this.Delete();
		Page.verifyPage("MY DATA", MyDataTitle); //My Data page
		System.out.println("Card deleted from expand successfully");
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


	public void openItemFromList(String SetName)
	{
		try {	    		
			do{ 
				for (WebElement element : SetGridItems) {
					if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
					String textFromGrid = element.getText();	    				
					if(SetName.equals(textFromGrid)) {
						Page.click(element);	
					}		    				
				}
				Page.click(forward); 
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
    			Page.click(forward);
			}    			
			while(forward.isEnabled());
    	}	    	
    	catch(Exception ex) {}
    }

	public void searchInExpand(String SearchInSet) throws InterruptedException, AWTException { 
		Page.click(serachBoxExpand);
		serachBoxExpand.sendKeys(SearchInSet);
		Thread.sleep(2000);
		Page.CompareAttributeText("value",SearchInSet,serachBoxExpand);
	}

	public void searchInSetExpand(String setToCreate, String entityToSelect, String textToSearch, String SearchInSet) throws InterruptedException, AWTException { 
		this.addSet();
		this.verifySetHomePage("Uncategorized");
		this.setTitle(setToCreate); //Create a set
		this.selectEntity(entityToSelect);
		this.searchItems(textToSearch);
		this.AddandAccept();
		this.expandSet();
		this.searchInExpand(SearchInSet);
		System.out.println("Search in expand completed successfully");
	}

	public void GridSettings() { 
		Page.click(GridSettingsIcon);
	}

	public void GridRows(String RowCount) { 
		Page.click(RowsPerPage);
		WebElement NoofRows = driver.findElement(By.xpath("//*[@title='"+RowCount+"']"));
		Page.click(NoofRows);
	}

	public void GridPrimaryColumn(String PrimaryColumn) { 
		Page.click(PrimaryColumnDropdown);
		WebElement PrimarySelect = driver.findElement(By.xpath("//*[@role='option' and @title='"+PrimaryColumn+"']"));
		Page.click(PrimarySelect);
	}

	public void GridSecondaryColumn(String SecondaryColumn) { 
		Page.click(SecondaryColumnDropdown);
		WebElement SecondarySelect = driver.findElement(By.xpath("//*[@role='option' and @title='"+SecondaryColumn+"']"));
		Page.click(SecondarySelect);
	}

	public void VerifyGrid(String NoofRows, String PrimaryColumn, String SecondaryColumn) { 
		List <WebElement> Columns = driver.findElements(By.xpath("//*[@tabindex='0']"));
		WebElement FirstColumn = driver.findElement(By.xpath("(//*[@tabindex='0'])[1]")); 
		int NoOfColumns = Columns.size();
		System.out.println(NoOfColumns);
		WebElement LastColumn = driver.findElement(By.xpath("(//*[@tabindex='0'])["+NoOfColumns+"]"));
		Page.verifyPage(PrimaryColumn, FirstColumn);
		Page.verifyPage(SecondaryColumn, LastColumn);
		String RN =Integer.toString(RowsintableExpand.size());
		Assert.assertEquals(RN, NoofRows);
	}

	public void GridChanges(String setToCreate, String entityToSelect, String textToSearch, String NoofRows, String PrimaryColumn, String SecondaryColumn) throws InterruptedException { 
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
		Page.click(Apply);
		Thread.sleep(3000);
		Page.verifyPage(setToCreate,setNameInExpand); //verifying the set name
		this.VerifyGrid(NoofRows,PrimaryColumn,SecondaryColumn);
		System.out.println("Grid Changes done successfully");
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

	
	public void DeleteSet(String SettoDelete) throws InterruptedException{
		this.Set();
		Page.waitforAnElement(columnHeaderFirstPage);
		selectMenuOptionInList(SettoDelete);
		Thread.sleep(3000);
		Page.click(deleteIcon);
		String DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading']")).getText();
		Assert.assertEquals(DeleteConfirm, "Delete Set?");
		Page.click(deleteIcon);	    	    	
	}
	
	
	
	public void createAndDeleteSet(String SetName, String entityToSelect, String textToSearch) throws InterruptedException{
		this.createSet(SetName, entityToSelect, textToSearch);	 
		this.DeleteSet(SetName);   	    	
	}

	public void ShareSet(String SetToShare, String personToBeShared) throws InterruptedException{
		this.Set();
		Page.waitforAnElement(columnHeaderFirstPage);
		selectMenuOptionInList(SetToShare);
		Thread.sleep(3000);
		Page.click(shareIcon);
		String SetNameInShare = setNameInShare.getText();
		Assert.assertEquals(SetNameInShare, SetToShare);
		Page.enterText(selectPersonToShare,personToBeShared);	
		Page.click(suggestedUsers);
		Page.click(share);	
		Page.waitforAnElement(ShareSuccess);
	}
	
	public void createAndShareSet(String SetName, String entityToSelect, String textToSearch, String personToBeShared) throws InterruptedException{
		this.createSet(SetName, entityToSelect, textToSearch);	 
		this.ShareSet(SetName, personToBeShared);
	}


}


//List <WebElement> Columns = webdriver.findElements(By.xpath("//*[@tabindex='0']"));
//int NoOfColumns = Columns.size();
//System.out.println(NoOfColumns);        //getting the number of columns




