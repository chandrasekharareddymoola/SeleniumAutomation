package com.eagle.pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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

public class ComparisonPage extends BasePage{

	SetPage objSetPage; 

	//Page level objects

	@FindBy(xpath = "//i[@data-icon-name='Home']")
	public WebElement homeIcon;

	@FindBy(xpath = "//i[@data-icon-name='BranchCompare']") 
	public WebElement ComparisonIcon;

	@FindBy(xpath = "//*[text()='Terms of Use']")
	public WebElement TermsOfUse;

	@FindBy(xpath = "//*[text()='Comparison']")
	public WebElement addComparison;

	@FindBy(xpath = "//*[text()='Run Comparison']/ancestor::button")
	public WebElement runComparison;

	@FindBy(xpath = "//*[@type='button' and @title='Close']")
	public WebElement closeRunComparison;

	@FindBy(xpath = "//*[text()='Search for entities']")
	public WebElement searchforentities;

	@FindBy(xpath = "//*[text()='Select a set']")
	public WebElement selectaSet;

	@FindBy(xpath = "//div[@scraper-tag='CardHeader']//span")
	public WebElement pageIdentifier;

	@FindBy(xpath = "//div[@class='EditableInputSet__setCardHeader___28Qqv SetCardHeader__header___295mH SetCardHeader__isExpanded___1qrzR']//label")
	public WebElement caseCardEntity;

	@FindBy(xpath = "//div//span[contains(text(),'Uncategorized')]")
	public WebElement entitySelection;

	@FindBy(xpath = "//div//input[@type='text']")
	public WebElement titleComparison;

	@FindBy(xpath = "//input[@placeholder='Choose a name for this set...']")
	public WebElement ChooseNameOfSet;

	@FindBy(xpath = "//*[text()='Start']")
	public WebElement startButton;

	@FindBy(xpath = "//div//input[@placeholder='Search for items to add' and @role='searchbox']")
	public WebElement serachBox;

	@FindBy(xpath = "//div//input[@role='searchbox' and @placeholder='Search in this list...']")
	public WebElement serachBoxExpand;	

	@FindBy(xpath = "//button[@title='Add all items']")
	public WebElement addAll;		

	@FindBy(xpath = "//div//span[contains(text(),'Accept')]")
	public WebElement accept;	

	@FindBy(xpath = "//*[@class='ExpandedCardViewHeader__title___r34jA']")
	public WebElement ComparisonNameInExpand;	

	@FindBy(xpath = "//*[@class='ms-Dropdown-container']")
	public WebElement fileSelectDropdown;	

	@FindBy(xpath = "//*[text()='browse/upload']")
	public WebElement clickUpload;	

	@FindBy(xpath = "//*[text()='Searching in ']//parent::div//child::b")
	public WebElement uploadedFileName;	

	@FindBy(xpath = "//*[@data-icon-name='Delete']//parent::span")
	public WebElement deleteCardExpand;	

	@FindBy(xpath = "(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]")
	public WebElement NoOfPagesInComparison;	

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

	@FindBy(xpath = "//*[@class='TableRowDefault__bodyRow___1_m1h']")
	public List <WebElement> RowsintableExpand;

	@FindBy(xpath = "//*[@data-icon-name='ShareIOS']")
	public WebElement ExportCard;

	@FindBy(xpath = "//*[@class='ms-List' and @role='presentation']")
	public WebElement ComparisonList;

	@FindBy(xpath = "(//*[@class='ms-List' and @role='presentation'])[2]")
	public WebElement ComparisonList2;

	@FindBy(xpath = "(//*[@class='ms-List' and @role='presentation'])[last()]")
	public WebElement LastComparisonList;

	@FindBy(xpath = "//*[@data-icon-name='Trash']")
	public WebElement DeleteinCard;

	@FindBy(xpath = "(//*[@data-icon-name='Trash'])[2]")
	public WebElement DeleteinCard2;

	@FindBy(xpath = "//*[text()='Remove']")
	public WebElement Remove;

	@FindBy(xpath = "//*[@data-icon-name='CircleAdditionSolid']/ancestor::button")
	public WebElement addCard;

	@FindBy(xpath = "//*[@type='button']//*[text()='Select a category']")
	public WebElement addRelationCategory;

	@FindBy(xpath = "//*[@scraper-tag='SetCardContent']")
	public List <WebElement> setCards;

	@FindBy(xpath = "//*[@class='ms-Label SetCardCategorySelector__categoryName___OkSRM root-82']")
	public List <WebElement> cardEntityName;

	@FindBy(xpath = "(//*[@class='ExpandedCardViewHeader__listCount___yQb2n']/span)[1]")
	public WebElement ItemCountInExpand;

	@FindBy(xpath = "//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']")
	public List<WebElement> ComparisonGridItems;

	@FindBy(xpath = "//button//span[contains(text(),'Delete')]")
	public WebElement deleteIcon;

	@FindBy(xpath = "(//span[@class='NameAndDescription__description___zAZrs'])[1]")
	public WebElement ComparisonNameInShare;

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

	@FindBy(xpath = "//div[text()='Comparison Results']")
	public WebElement comparisonsResultsHeader;

	@FindBy(xpath = "//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']")
	public List<WebElement> GridItems;

	@FindBy(xpath = "//span[text()='An error occured. Please contact your administrator.']")
	public WebElement ErrorInListLoad;

	@FindBy(xpath = "//*[@scraper-tag='HandleError' and text()='Fetch failed']")
	public WebElement fetchFailed;

	@FindBy(xpath = "(//*[@role='listbox'])[2]")
	public WebElement dropDown2;

	@FindBy(xpath = "(//*[@role='listbox'])[2]//span[@role='option']")
	public WebElement dropDown2text;

	@FindBy(xpath = "(//*[@role='listbox'])[3]")
	public WebElement dropDown3;

	@FindBy(xpath = "(//*[@role='listbox'])[3]//span[@role='option']")
	public WebElement dropDown3text;

	@FindBy(xpath = "//*[@type='button' and @title='CONTROL']")
	public WebElement controlButton;

	@FindBy(xpath = "//*[@type='button' and @title='CASE']")
	public WebElement caseButton;

	@FindBy(xpath = "(//*[@class='TableRowDefault__bodyRow___1_m1h'])[1]")
	public WebElement FirstRowintableExpand;

	public WebElement openComparison(String name) {
		return driver.findElement(By.xpath("//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']//div[@title='"+ name +"']"));   		
	}

	//Page level functions on the objects
	WebDriverWait wait = new WebDriverWait(driver, 5);
	Actions action = new Actions(driver);

	public void Home() throws AWTException, InterruptedException{    	
		BasePage.click(homeIcon);
		action.moveToElement(TermsOfUse).perform();
	}  

	public ComparisonPage() throws AWTException, InterruptedException{ 	
		PageFactory.initElements(driver, this); 
		BasePage.click(ComparisonIcon);
		action.moveToElement(TermsOfUse).perform();
	}

	public void Comparison() throws AWTException, InterruptedException{ 	
		BasePage.click(ComparisonIcon);
		action.moveToElement(TermsOfUse).perform();
	}

	public void verifyComparisonHomePage(String stringToVerify) throws AWTException, InterruptedException, AssertionError{    	
		BasePage.verifyPage(stringToVerify, pageIdentifier);
	}

	public void addComparison() throws AWTException, InterruptedException{ 
		BasePage.click(addComparison);
	}

	public void clickStart()throws AWTException, InterruptedException {	    	
		BasePage.click(startButton);        
	}   

	public void runComparison() throws AWTException, InterruptedException{ 
		BasePage.click(runComparison);
		ExtentTestManager.getTest().log(Status.PASS, "Run Comparison performed");

	}

	public void createComparisonSet(String setToAdd) throws AWTException, InterruptedException{ 
		BasePage.click(selectaSet);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Select a Set']")));
		this.searchExpandEnterName(setToAdd);
		this.clickSetInExpand(setToAdd);
		Thread.sleep(10000);
	}

	public void ComparisonTitle(String textTitle) throws AWTException, InterruptedException{    	
		BasePage.enterText(titleComparison, textTitle);
	}   

	public void NameforCard(String textTitle) throws AWTException, InterruptedException{    	
		BasePage.enterText(ChooseNameOfSet, textTitle);
	}   

	public void selectEntity(String entityToSelect) throws AWTException, InterruptedException{    	
		BasePage.click(pageIdentifier);
		WebElement entitytoSelect = driver.findElement(By.xpath("//button//span[contains(text(),'"+entityToSelect+"')]"));
		BasePage.click(entitytoSelect);
	}

	public void viewComparison(String ComparisonName) throws InterruptedException, AWTException{
		this.Comparison();	  
		this.openItemFromList(ComparisonName);	    
		ExtentTestManager.getTest().log(Status.PASS, ComparisonName +" is opened");
	}

	public void openItemFromList(String Item)
	{
		try {	    		
			do{ 
				for (WebElement element : GridItems) {
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

	public void searchItems(String ItemtoSearch) throws AWTException, InterruptedException{
		BasePage.click(serachBox);
		BasePage.enterText(serachBox, ItemtoSearch);
	}

	public void createCheck(String ComparisonToCheck) throws AWTException, InterruptedException,AssertionError{	    	
		this.Comparison();
		Thread.sleep(20000);
		BasePage.waitforAnElement(columnHeaderFirstPage);
		try {
			Assert.assertEquals(ComparisonToCheck, FirstItem.getText());
			ExtentTestManager.getTest().log(Status.PASS, ComparisonToCheck + " Comparison is present in the list");
			Thread.sleep(5000);
		}
		catch (Exception | AssertionError ComparisonNotPresent){
			throw ComparisonNotPresent;
		}
	}   

	public void AddandAccept() throws AWTException, InterruptedException{
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


	public void waitForComparison() throws Throwable{
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

	public void waitForComparisonTitle() throws Throwable{
		try {  
			boolean iden = true;
			do
			{
				try {	    	
					titleComparison.isDisplayed();
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

	public void waitForaddCard() throws Throwable{
		try {  
			boolean iden = true;
			do
			{
				try {	    	
					BasePage.CompareAttributeText("data-is-focusable", "true", addCard);
					iden = false;	  
				}
				catch(Exception | AssertionError ex) {Thread.sleep(5000);}	 
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
	
	public void createComparisonWithControl(String ComparisonName,String ControlSetName, String EntitytoSelect, String ItemtoSearch) throws Throwable{	    	
		try {
			this.Comparison();
			this.waitForComparison();
			this.addComparison();
			this.ComparisonTitle(ComparisonName);
			this.NameforCard(ControlSetName);
			Thread.sleep(3000);
			this.verifyComparisonHomePage("Uncategorized");
			this.selectEntity(EntitytoSelect);
			this.searchItems(ItemtoSearch); 
			this.AddandAccept();   
			BasePage.waitforAnElement(ComparisonList);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison is created with a control Set");
			this.createCheck(ComparisonName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Comparison is verified");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}   	


	public void createComparisonControl(String ComparisonName,String ControlSetName, String EntitytoSelect, String ItemtoSearch) throws Throwable{	    	
		try {
			this.Comparison();
			this.waitForComparison();
			this.addComparison();
			this.ComparisonTitle(ComparisonName);
			this.NameforCard(ControlSetName);
			Thread.sleep(3000);
			this.verifyComparisonHomePage("Uncategorized");
			this.selectEntity(EntitytoSelect);
			this.searchItems(ItemtoSearch); 
			Thread.sleep(3000);
			this.AddandAccept();   
			BasePage.waitforAnElement(ComparisonList);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison is created with a control Set");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}   

	public void createComparisonWithControlandCase(String ComparisonName,String ControlSetName, String CaseSetName, String EntitytoSelect, String ItemtoSearchControl, String ItemtoSearchCase) throws Throwable{	    	
		try {
			this.createComparisonControl(ComparisonName,ControlSetName, EntitytoSelect, ItemtoSearchControl);
			this.waitForaddCard();
			this.addCard();
			Thread.sleep(3000);
			this.NameforCard(CaseSetName);
			Thread.sleep(3000);
			BasePage.verifyPage(EntitytoSelect, caseCardEntity);	
			this.searchItems(ItemtoSearchCase); 
			this.AddandAccept();  
			BasePage.waitforAnElement(ComparisonList2);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison is created with control and case Set");
			this.createCheck(ComparisonName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Comparison is verified");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}   

	public void createComparisonControlandCase(String ComparisonName,String ControlSetName, String CaseSetName, String EntitytoSelect, String ItemtoSearchControl, String ItemtoSearchCase) throws Throwable{	    	
		try {
			this.createComparisonControl(ComparisonName,ControlSetName, EntitytoSelect, ItemtoSearchControl);
			this.waitForaddCard();
			this.addCard();
			Thread.sleep(3000);
			this.NameforCard(CaseSetName);
			Thread.sleep(3000);
			BasePage.verifyPage(EntitytoSelect, caseCardEntity);	
			this.searchItems(ItemtoSearchCase); 
			this.AddandAccept();  
			BasePage.waitforAnElement(ComparisonList2);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison is created with a control and case Set");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}   

	public void createComparisonWithcontrolandCaseRunComparison(String ComparisonName,String ControlSetName, String CaseSetName, String EntitytoSelect, String ItemtoSearchControl, String ItemtoSearchCase) throws Throwable{	    	
		try {
			this.createComparisonControlandCase(ComparisonName,ControlSetName,CaseSetName,EntitytoSelect,ItemtoSearchControl,ItemtoSearchCase);
			this.runComparison();
			waitforAnElement(comparisonsResultsHeader);
			Thread.sleep(5000);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison Results Page is displayed");
			BasePage.click(closeRunComparison);
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}  


	public void createComparisonWithControlandMultipleCase(String ComparisonName,String ControlSetName, String EntitytoSelect, String ItemtoSearchControl , Integer NumberOfCaseSets) throws Throwable{	    	
		try {
			this.createComparisonControl(ComparisonName,ControlSetName, EntitytoSelect, ItemtoSearchControl);
			for(int i=0; i<NumberOfCaseSets; i++) {
				this.waitForaddCard();
				this.addCard();
				Thread.sleep(3000);
				int j=i+1;
				this.NameforCard("Case Set "+ j);
				Thread.sleep(3000);
				BasePage.verifyPage(EntitytoSelect, caseCardEntity);
				String ItemtoSearchCase = generateRandomWord(3);
				this.searchItems(ItemtoSearchCase); 
				this.AddandAccept();  
				Thread.sleep(3000);
				BasePage.waitforAnElement(LastComparisonList);
				ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison added with " + i + " Case Set(s)" );
			}
			this.createCheck(ComparisonName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Comparison is verified");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	} 


	String generateRandomWord(int wordLength) {
		Random r = new Random(); // Intialize a Random Number Generator with SysTime as the seed
		StringBuilder sb = new StringBuilder(wordLength);
		for(int i = 0; i < wordLength; i++) { // For each letter in the word
			char tmp = (char) ('a' + r.nextInt('z' - 'a')); // Generate a letter between a and z
			sb.append(tmp); // Add it to the String
		}
		return sb.toString();
	}

	public void createComparisonControlandMultipleCase(String ComparisonName,String ControlSetName, String EntitytoSelect, String ItemtoSearchControl , Integer NumberOfCaseSets) throws Throwable{	    	
		try {
			this.createComparisonControl(ComparisonName,ControlSetName, EntitytoSelect, ItemtoSearchControl);
			for(int i=0; i<NumberOfCaseSets; i++) {
				this.waitForaddCard();
				this.addCard();
				Thread.sleep(3000);
				int j=i+1;
				this.NameforCard("Case Set "+ j);
				Thread.sleep(3000);
				BasePage.verifyPage(EntitytoSelect, caseCardEntity);
				String ItemtoSearchCase = generateRandomWord(3);
				this.searchItems(ItemtoSearchCase); 
				this.AddandAccept();  
				BasePage.waitforAnElement(LastComparisonList);
				ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison added with " + i + " Case Set(s)" );
			}
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	} 

	public void createComparisonWithControlandMultipleCaseRunComparison(String ComparisonName,String ControlSetName, String EntitytoSelect, String ItemtoSearchControl , Integer NumberOfCaseSets) throws Throwable{	    	
		try {
			this.createComparisonControlandMultipleCase(ComparisonName,ControlSetName,EntitytoSelect, ItemtoSearchControl, NumberOfCaseSets);
			this.runComparison();
			waitforAnElement(comparisonsResultsHeader);
			Thread.sleep(5000);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison Results Page is displayed");
			BasePage.click(closeRunComparison);
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	} 

	public void firstCardControlChangeAndVerify() throws Throwable{	    	
		try {
			BasePage.click(dropDown2);
			BasePage.click(caseButton);
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, "CONTROL Card is changed to Case");
			System.out.println(dropDown3text.getText());
			BasePage.verifyPage("CONTROL", dropDown3text);
			ExtentTestManager.getTest().log(Status.PASS, "CASE Card change to Control is verified");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}  

	public void secondCardControlChangeAndVerify() throws Throwable{	    	
		try {
			BasePage.click(dropDown3);
			BasePage.click(caseButton);
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, "CONTROL Card is changed to Case again");
			BasePage.verifyPage("CONTROL", dropDown2text);
			ExtentTestManager.getTest().log(Status.PASS, "CASE Card change to Control is verified again");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}  

	public void secondCardCaseChangeAndVerify() throws Throwable{	    	
		try {
			BasePage.click(dropDown3);
			BasePage.click(controlButton);
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, "CASE Card is changed to Control");
			BasePage.verifyPage("CASE", dropDown2text);
			ExtentTestManager.getTest().log(Status.PASS, "CONTROL Card change to Case is verified");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}  

	public void ChangeControlAndCase(String ComparisonName,String ControlSetName, String CaseSetName, String EntitytoSelect, String ItemtoSearchControl, String ItemtoSearchCase) throws Throwable{	    	
		try {
			this.createComparisonControlandCase(ComparisonName,ControlSetName,CaseSetName,EntitytoSelect,ItemtoSearchControl,ItemtoSearchCase);
			this.waitForaddCard();
			this.firstCardControlChangeAndVerify();
			Thread.sleep(3000);
			this.secondCardControlChangeAndVerify();
			Thread.sleep(3000);
			this.secondCardCaseChangeAndVerify();
			Thread.sleep(3000);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + "  - Control and case change is verified");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}  


	public void updateComparisonWithCaseCard(String ComparisonName,String EntitytoSelect,String CaseSetName,String ItemtoSearchCase) throws Throwable{	    	
		try {
			this.viewComparison(ComparisonName);
			this.waitForaddCard();
			this.addCard();
			Thread.sleep(3000);
			this.NameforCard(CaseSetName);
			Thread.sleep(3000);
			BasePage.verifyPage(EntitytoSelect, caseCardEntity);	
			this.searchItems(ItemtoSearchCase); 
			this.AddandAccept();  
			waitForaddCard();
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison Results Page is displayed");
			this.createCheck(ComparisonName);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison is present in the list and verified");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}  

	public void createComparisonControlCase(String ComparisonName,String ControlSetName, String CaseSetName, String EntitytoSelect, String ItemtoSearchControl, String ItemtoSearchCase) throws Throwable{	    	
		try {
			this.createComparisonControl(ComparisonName,ControlSetName, EntitytoSelect, ItemtoSearchControl);
			this.waitForaddCard();
			this.addCard();
			Thread.sleep(3000);
			this.NameforCard(CaseSetName);
			Thread.sleep(3000);
			BasePage.verifyPage(EntitytoSelect, caseCardEntity);	
			this.searchItems(ItemtoSearchCase); 
			this.AddandAccept();  
			BasePage.waitforAnElement(ComparisonList2);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " is upgraded with Case Set");
			this.createCheck(ComparisonName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Comparison is verified");
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}   

	public void createComparisonInitallyFromSet(String SetName,String entityToSelect, String textToSearch , String ComparisonName) throws Throwable{	    	
		try {
			objSetPage = new SetPage();  
			objSetPage.createSet(SetName, entityToSelect, textToSearch);
			this.Home();

			this.Comparison();
			this.waitForComparison();
			this.addComparison();
			this.createComparisonSet(SetName);
			ExtentTestManager.getTest().log(Status.PASS, SetName + " Set is added as base to create Comparison " + ComparisonName);
			this.waitForComparisonTitle();
			this.ComparisonTitle(ComparisonName);
			BasePage.waitforAnElement(ComparisonList);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " Comparison is created from Set intially");
			this.createCheck(ComparisonName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Comparison is verified");
			this.Home();
		}
		catch(Exception ex){
			throw ex;
		}
		catch(AssertionError ex){
			throw ex;
		}
	}  

	public void expandComparison() throws Throwable{
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
				Thread.sleep(3000);
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

	public void removeItems()throws AWTException, InterruptedException{	
		BasePage.click(remove);
		BasePage.click(saveChanges);
	}

	public void DecreaseCompareTwovalues(String Value1, String Value2) throws InterruptedException, AWTException {	    
		if(Integer.parseInt(Value2)<Integer.parseInt(Value1)){
			System.out.println("Number of records have decrease");
		}
		else{
			System.out.println("Number of records have not decreased or in worst case have increased");
		}
	}	

	public void RemoveItemsfromComparison(String ComparisonToCreate, String ControlSetName, String entityToSelect, String textToSearch) throws Throwable
	{
		this.createComparisonControl(ComparisonToCreate,ControlSetName, entityToSelect, textToSearch);	 
		this.Comparison();
		this.waitForComparison();
		WebElement opn = this.openComparison(ComparisonToCreate);
		BasePage.click(opn);
		this.expandComparison();
		this.GridPrimaryColumnAlone("End");
		Thread.sleep(5000);
		this.editCard();	
		String NoOfRecordsInitial = ItemCountInExpand.getText();
		List<String>  myAlist = new ArrayList<String>();
		myAlist.add("72112780");
		myAlist.add("20981360");
		myAlist.add("147670524");
		this.selectItems(myAlist);	  
		this.removeItems();	 
		this.waitForEditAndDelete();
		ExtentTestManager.getTest().log(Status.PASS, "Comparison - Items removed successfully");
		waitforAnElement(ItemCountInExpand);
		String NoOfRecordsFinal = ItemCountInExpand.getText();
		this.DecreaseCompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
		int Difference = Integer.parseInt(NoOfRecordsInitial)-Integer.parseInt(NoOfRecordsFinal);
		assertEquals(Difference, myAlist.size());
		ExtentTestManager.getTest().log(Status.PASS, "Decrease in count is verified");
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
		WebElement opn = this.openComparison(existingSetName);
		BasePage.click(opn);  
	}

	public void CreateComparisonFromFile(String ComparisonName, String CardName,String EntitytoSelect, String FileLocation) throws Throwable { 
		try {
			this.Comparison();
			this.waitForComparison();
			this.addComparison();
			this.ComparisonTitle(ComparisonName);
			Thread.sleep(3000);
			this.NameforCard(CardName);
			Thread.sleep(3000);		
			this.verifyComparisonHomePage("Uncategorized");	
			this.selectEntity(EntitytoSelect);
			this.addItemsFromFile(FileLocation); 
			this.AddandAccept(); 
			BasePage.waitforAnElement(ComparisonList);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName +" Comparison is created using a file");
			this.createCheck(ComparisonName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Comparison is verified");
			this.Home();
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}

	public void CreateComparisonFromSet(String SetName, String entityToSelect, String textToSearch, String ComparisonName, String CardName) throws Throwable { 
		try {
			objSetPage = new SetPage();  
			objSetPage.createSet(SetName, entityToSelect, textToSearch);
			this.Home();

			this.Comparison();
			this.waitForComparison();
			this.addComparison();
			this.ComparisonTitle(ComparisonName);
			Thread.sleep(3000);
			this.NameforCard(CardName);
			Thread.sleep(3000);		
			this.verifyComparisonHomePage("Uncategorized");
			this.selectEntity(entityToSelect);
			this.addItemsFromSet(SetName); 
			this.accept(); 
			ExtentTestManager.getTest().log(Status.PASS, SetName + " Set is added as base to create Comparison " + ComparisonName);	
			BasePage.waitforAnElement(ComparisonList);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName +" is created using a set");
			this.createCheck(ComparisonName);
			ExtentTestManager.getTest().log(Status.PASS, "Created Comparison is verified");
			this.Home();
		}
		catch(Exception | AssertionError ex){
			throw ex;
		}
	}

	public void close()throws AWTException, InterruptedException{	
		BasePage.click(close);
	}

	public void saveChanges() throws InterruptedException, AWTException{
		BasePage.scrollToTop();
		BasePage.click(saveChanges);
		ExtentTestManager.getTest().log(Status.PASS, "Changes are Saved");
		this.Home();
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


	//Adding a set from expand into Comparison
	public void ExpandAddFromSet(String setToAdd, String entityToSelect, String textToSearchInSet, String ComparisonName, String ControlSetName, String textToSearchInComparison) throws Throwable {    // Add from a set
		try {
			objSetPage = new SetPage();  
			List <String> setItems = objSetPage.createSetforAdd(setToAdd, entityToSelect, textToSearchInSet);
			this.Home();

			this.createComparisonControl(ComparisonName,ControlSetName, entityToSelect, textToSearchInComparison);	 
			this.expandComparison();
			this.editCard();
			String NoOfRecordsInitial = ItemCountInExpand.getText();
			this.addItemsExpand();
			this.addFromSetExpand(setToAdd); // Set to be added
			this.waitForSaveChanges();
			waitforAnElement(ItemCountInExpand);
			String NoOfRecordsFinal = ItemCountInExpand.getText();
			this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
			objSetPage.verifyAfterAdd(setItems);
			ExtentTestManager.getTest().log(Status.PASS, "Comparison - Set added in expand");
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

	//Adding items from catalog from expand into Comparison
	public void ExpandAddFromCatalog(String ComparisonToCreate, String ControlSetName ,String EntitytoSelect, String TexttoSearchinControl, String TextToSearchinCatalog) throws Throwable{ 
		try {
			this.createComparisonControl(ComparisonToCreate,ControlSetName, EntitytoSelect, TexttoSearchinControl);	 
			this.expandComparison();

			this.editCard();
			String NoOfRecordsInitial = ItemCountInExpand.getText();
			this.addItemsExpand();
			this.addFromSetCatalog(TextToSearchinCatalog); // Text to be added 
			ExtentTestManager.getTest().log(Status.PASS, TextToSearchinCatalog + " is searched");
			this.add();
			this.waitForSaveChanges();
			waitforAnElement(ItemCountInExpand);
			String NoOfRecordsFinal = ItemCountInExpand.getText();
			this.CompareTwovalues(NoOfRecordsInitial,NoOfRecordsFinal);
			BasePage.verifyPage(ControlSetName,ComparisonNameInExpand);
			ExtentTestManager.getTest().log(Status.PASS, "Comparison - Items added from Catalog in expand");
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void fileSelectDropdown()throws AWTException, InterruptedException{	    
		BasePage.click(fileSelectDropdown);
	}

	public void FileuploadCategory(String CategoryName) throws AWTException, InterruptedException{	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Drag files here']")));
		try {
			this.fileSelectDropdown();
			BasePage.click(driver.findElement(By.xpath("//*[@title='"+CategoryName+"']")));
			BasePage.click(clickUpload);
		}
		catch (Exception ex){
			BasePage.click(clickUpload);
		}
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

	//Adding items from File from expand into Comparison
	public void ExpandAddFromFile(String ComparisonToCreate, String ControlSetName, String EntitytoSelect,  String textToSearch , String CategoryName, String Filelocation, String FileName) throws Throwable { 
		try {
			this.createComparisonControl(ComparisonToCreate,ControlSetName, EntitytoSelect, textToSearch);	 
			this.expandComparison();
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
			ExtentTestManager.getTest().log(Status.PASS, "Comparison - Items added from File in expand");
		}
		catch (Exception ExpandAddFromFileFail) {
			if(dialogBoxClose.isDisplayed()) {
				BasePage.click(dialogBoxClose);
			}
			throw ExpandAddFromFileFail;
		}
	}


	public void DeleteCardExpand() throws AWTException, InterruptedException { 
		Thread.sleep(10000);
		BasePage.click(deleteCardExpand);
	}

	public void Delete() throws AWTException, InterruptedException{ 
		BasePage.click(Delete);
	}

	public void DeleteExploraionInExpand(String ComparisonToCreate, String ControlSetName, String EntitytoSelect, String textToSearch) throws Throwable { 
		try {
			this.createComparisonControl(ComparisonToCreate,ControlSetName, EntitytoSelect, textToSearch);	 
			this.expandComparison();
			this.DeleteCardExpand();
			String DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading']")).getText();
			Assert.assertEquals(DeleteConfirm, "Delete Set");
			this.Delete();
			ExtentTestManager.getTest().log(Status.PASS, "Control Card is deleted via expanded view");
			waitforAnElement(ChooseNameOfSet);
			this.verifyComparisonHomePage("Uncategorized");
			BasePage.CompareAttributeText("Value", ComparisonToCreate, titleComparison); //Comparison page
			ExtentTestManager.getTest().log(Status.PASS, "Removal verified");
		}
		catch(Exception ex) {
			throw ex;
		}
		catch(AssertionError ex){
			throw ex;
		}
	}

	public int NoOfPagesInComparisonPage() throws InterruptedException, AWTException { 
		String Pagecount = NoOfPagesInComparison.getText();
		Integer n = Integer.valueOf(Pagecount);
		return n;
	}

	public void selectMenuOptionInList(String SetName)
	{
		try {	
			outerloop:
				do{
					for (WebElement element : ComparisonGridItems) {
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

	public void DeleteComparison(String ComparisontoDelete) throws Throwable{
		try {
			this.Comparison();
			this.waitForComparison();
			selectMenuOptionInList(ComparisontoDelete);
			Thread.sleep(3000);
			BasePage.click(deleteIcon);
			String DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading']")).getText();
			Assert.assertEquals(DeleteConfirm, "Delete Comparison?");
			BasePage.click(deleteIcon);	 
			ExtentTestManager.getTest().log(Status.PASS, ComparisontoDelete + " Comparison is Deleted");
		}
		catch(Exception ex) {
			throw ex;
		}
		catch (AssertionError ex) {
			throw ex;
		}
	}

	public void createAndDeleteComparison(String ComparisonToCreate,String ControlSetName, String entityToSelect, String textToSearch) throws Throwable{
		this.createComparisonControl(ComparisonToCreate,ControlSetName, entityToSelect, textToSearch);	  
		this.DeleteComparison(ComparisonToCreate);   	    	
	}

	public void ShareComparison(String ComparisonToShare, String personToBeShared) throws Throwable{
		try {
			this.Comparison();
			this.waitForComparison();
			selectMenuOptionInList(ComparisonToShare);
			Thread.sleep(3000);
			BasePage.click(shareIcon);
			String SetNameInShare = ComparisonNameInShare.getText();
			Assert.assertEquals(SetNameInShare, ComparisonToShare);
			BasePage.enterText(selectPersonToShare,personToBeShared);	
			BasePage.click(suggestedUsers);
			BasePage.click(share);	
			BasePage.waitforAnElement(ShareSuccess);
			ExtentTestManager.getTest().log(Status.PASS, ComparisonToShare + " Comparison is Shared");
		}
		catch(Exception ex) {
			throw ex;
		}
		catch (AssertionError ex) {
			throw ex;
		}

	}

	public void createAndShareComparison(String ComparisonToCreate,String ControlSetName, String entityToSelect, String textToSearch, String personToBeShared) throws Throwable{
		this.createComparisonControl(ComparisonToCreate,ControlSetName, entityToSelect, textToSearch);	  
		this.ShareComparison(ComparisonToCreate, personToBeShared);
	}


	public void searchInExpand(String SearchInComparison) throws InterruptedException, AWTException, AssertionError { 
		try {
			Thread.sleep(20000);
			BasePage.click(serachBoxExpand);
			serachBoxExpand.sendKeys(SearchInComparison);
			Thread.sleep(2000);
			BasePage.CompareAttributeText("value",SearchInComparison,serachBoxExpand);
		}
		catch(Exception ex){
			throw ex;
		}
		catch (AssertionError ex){
			throw ex;
		}
	}
	
	public void verifyAfterSearch(String SearchInComparison) throws InterruptedException, AWTException { 
		try {
			int j =1 ;
			outloop:
			do {
				try {
					int NoOfRows = RowsintableExpand.size();
					for(int i=1 ; i< NoOfRows ;i++) {
						WebElement tableRows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='TableRowDefault__bodyRow___1_m1h'])["+i+"]")));
						String valuesInRows = tableRows.getText().toLowerCase();
						String SearchInSetLowerCase = SearchInComparison.toLowerCase();				
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

	public void searchInComparisonExpand(String ComparisonToCreate,String ControlSetName,String EntitytoSelect, String textToSearch, String SearchInComparison) throws Throwable { 
		this.createComparisonControl(ComparisonToCreate,ControlSetName, EntitytoSelect, textToSearch);	 
		this.expandComparison();
		this.searchInExpand(SearchInComparison);
		ExtentTestManager.getTest().log(Status.PASS, "Search in done using text - "+ SearchInComparison);
		this.verifyAfterSearch(SearchInComparison);
		ExtentTestManager.getTest().log(Status.PASS, "Search is verified");
	}

	public void DeleteclickinCard() throws AWTException, InterruptedException { 
		BasePage.click(DeleteinCard);
	}

	public void Remove() throws AWTException, InterruptedException { 
		BasePage.click(Remove);
	}


	public void deleteComparisonInFirstCard(String ComparisonToCreate, String ControlSetName, String EntitytoSelect, String textToSearch) throws Throwable { 
		try {
			this.createComparisonControl(ComparisonToCreate,ControlSetName, EntitytoSelect, textToSearch);	 
			this.DeleteclickinCard();
			WebElement DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading' and text()='Remove "+EntitytoSelect+"?']"));
			BasePage.waitforAnElement(DeleteConfirm);
			this.Remove();
			ExtentTestManager.getTest().log(Status.PASS, ControlSetName +" Card is deleted in Comparison in non-expanded view");
			waitforAnElement(ChooseNameOfSet);
			this.verifyComparisonHomePage("Uncategorized");
			BasePage.CompareAttributeText("Value", ComparisonToCreate, titleComparison);
			ExtentTestManager.getTest().log(Status.PASS, "Removal verified");
		}
		catch (Exception ex) {
			throw ex;	
		}
		catch (AssertionError ex) {
			throw ex;	
		}
	}

	public void deleteComparisonInLaterCard(String ComparisonToCreate,String ControlSetName, String CaseSetName, String EntitytoSelect, String ItemtoSearchControl, String ItemtoSearchCase) throws Throwable { 
		try {
			this.createComparisonControlandCase(ComparisonToCreate,ControlSetName, CaseSetName, EntitytoSelect, ItemtoSearchControl, ItemtoSearchCase);
			BasePage.click(DeleteinCard2);
			WebElement DeleteConfirm =  driver.findElement(By.xpath("//*[@role='heading' and text()='Remove "+EntitytoSelect+"?']"));
			BasePage.waitforAnElement(DeleteConfirm);
			this.Remove();
			ExtentTestManager.getTest().log(Status.PASS, "Second Card is deleted in Comparison in non-expanded view");
			Thread.sleep(3000);
			int NoOfCards = setCards.size();
			Assert.assertEquals(NoOfCards, 1);
			BasePage.CompareAttributeText("Value", ComparisonToCreate, titleComparison);
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
			this.addComparison();
			this.verifyComparisonHomePage("Uncategorized");
			this.ComparisonTitle(setToCreate); //Create a set
			this.selectEntity(EntitytoSelect);
			this.searchItems(ItemtoSearch);
			this.AddandAccept();
			this.expandComparison();
			this.GridSettings();
			this.GridRows(NoofRows);
			this.GridPrimaryColumn(PrimaryColumn);
			this.GridSecondaryColumn(SecondaryColumn);
			BasePage.click(Apply);
			BasePage.verifyPage(setToCreate,ComparisonNameInExpand); //verifying the set name
			this.VerifyGrid(NoofRows,PrimaryColumn,SecondaryColumn);
		}
		catch (Exception ex) {
			throw ex;
		}
		catch (AssertionError ex) {
			throw ex;
		}
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

	//	public void SharetLoop(String SetToShare, String SharedUser) throws InterruptedException, AWTException { 
	//		Integer NoofPages = this.NoOfPagesInComparisonPage();
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
	//		Page.verifyPage("MY DATA", ComparisonTitle); //My Data page
	//		this.shareASet(SetToShare, SharedUser);
	//	}

	public void addCard() throws AWTException, InterruptedException { 
		BasePage.click(addCard);
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



	// Need to update
	public void SelectItemsInComparisonCard(String NumberOfItemsToSelect) throws InterruptedException, AWTException { 
		for (int i=1; i == Integer.parseInt(NumberOfItemsToSelect);i++)	{
			try {
				WebElement SelectItem = driver.findElement(By.xpath("(//div[@role='checkbox']["+i+"]"));
				wait.until(ExpectedConditions.elementToBeClickable(SelectItem));
				Thread.sleep(5000);
				BasePage.click(SelectItem);
			}
			catch(Exception ex) {
				throw ex;
			}
		}
	}

	public void verifySortAscending(String ColumnToBeSorted) throws Throwable{
		Integer NumOfPrecedingColumns = driver.findElements(By.xpath("//*[text()='"+ColumnToBeSorted+"']//parent::div//parent::div//preceding-sibling::div")).size();
		Integer CurrentColumn = NumOfPrecedingColumns + 1;
		Integer NoOfRows = RowsintableExpand.size();
		List<String>  OriginalList = new ArrayList<String>();
		List<String>  TempList = new ArrayList<String>();
		for(int i=1; i<=NoOfRows; i++) {
			WebElement text = driver.findElement(By.xpath("(((//div[@class='TableRowDefault__bodyRow___1_m1h'])["+i+"])//div)["+CurrentColumn+"]"));
			waitforAnElement(text);
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


	public void SortColumnInComparison(String ComparisonName, String ControlSetName ,String entityToSelect, String textToSearch, String ColumnToBeSorted) throws Throwable{
		try {
			this.createComparisonControl(ComparisonName, ControlSetName, entityToSelect, textToSearch);	 
			ExtentTestManager.getTest().log(Status.PASS, ComparisonName + " is Created");
			this.expandComparison();
			WebElement SortColumnname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ColumnToBeSorted+"']")));
			Thread.sleep(3000);
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


	public void captureScreenshot(String screenShotName) throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String fileWithPath = "./Resources/ErrorScreenshots/"+screenShotName+".png";
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}


	public void rowrext() throws Throwable
	{
		this.createComparisonControl("A","A", "Disease", "dengue");	 
		this.expandComparison();
		this.searchInExpand("den");
		ExtentTestManager.getTest().log(Status.PASS, "Search in done using text - ");
		WebElement a = driver.findElement(By.xpath("//*[@class='TableRowDefault__bodyRow___1_m1h']"));
		String b = a.getText();
		System.out.println(b);
	}



}





