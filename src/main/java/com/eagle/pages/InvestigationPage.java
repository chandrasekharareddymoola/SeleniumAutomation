package com.eagle.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InvestigationPage extends Page{

		//WebDriver driver;	
	  
	 	@FindBy(xpath = "//i[@data-icon-name='TestSuite']")
		public WebElement investigationIcon;
	 	
		@FindBy(xpath = "//i[@data-icon-name='Add']")
		public WebElement addInvestigation;
		
		@FindBy(xpath = "//label[contains(text(),'Title')]/following::input")
		public WebElement title;
		
		@FindBy(xpath = "//label[contains(text(),'Title')]/following::textarea")
		public WebElement description;
		
		@FindBy(xpath = "//button//span[contains(text(),'Save')]")
		public WebElement saveInvestigation;	
		
		@FindBy(xpath = "//div//label[contains(text(),'Copyright')]")
		public WebElement copyRightIdentifier;
		
		@FindBy(xpath = "//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']")
		public List<WebElement> invGridItems;
		
		@FindBy(xpath = "//div[@class='ms-List']//div[@role='row']")
		public List<WebElement> invGridRows;
		
		@FindBy(xpath = "//i[@data-icon-name='Forward']")
		public WebElement forward;
		
		@FindBy(xpath = "//div[contains(@class,'InvestigationHeader__resourceTitleContainer')]//input[@type='text']")
		public WebElement investigationTitle;
		
		@FindBy(xpath = "//div[contains(@class,'InvestigationHeader__viewMoreContainer')]//input[@type='text']")
		public WebElement investigationDesc;
		
		@FindBy(xpath = "//button[@name='Sets']")
		public WebElement tabSets;
		
		@FindBy(xpath = "//button[@name='Comparisons']")
		public WebElement tabComparisons;
		
		@FindBy(xpath = "//button[@name='Explorations']")
		public WebElement tabExplorations;
		
		@FindBy(xpath = "//button//span[contains(text(),'Action')]")
		public WebElement addAction;
		
		@FindBy(xpath = "//button//span[contains(text(),'Exploration')]")
		public WebElement linkExploration;
		
		@FindBy(xpath = "//button//span[contains(text(),'Comparison')]")
		public WebElement linkComparison;
		
		@FindBy(xpath = "//button//span[contains(text(),'Set')]")
		public WebElement linkSet;
		
		@FindBy(xpath = "//button//span[contains(text(),'View saved searches')]")
		public WebElement viewSavedSearches;
		
		@FindBy(xpath = "//button//div[contains(text(),'Select an exploration')]")
		public WebElement selectAnExploration;
			
		@FindBy(xpath = "//button//div[contains(text(),'Select a comparison')]")
		public WebElement selectAComparison;
		
		@FindBy(xpath = "//button//div[contains(text(),'Select a set')]")
		public WebElement selectASet;
		
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
		
			
		public InvestigationPage(){ 		 
			 PageFactory.initElements(driver, this); 
		 }

		public void clickInvestigationIcon(){    	
	    	Page.click(investigationIcon);
	    	Actions action = new Actions(driver);
	    	//Performing the mouse hover action on the target element.	    	
	    	action.moveToElement(copyRightIdentifier).perform();
	    	
	    }
		
		public void addInvestigation(){    	
	    	Page.click(addInvestigation);
	    }
		

		public void addAction(){    	
	    	Page.click(addAction);
	    }
		
	    public void setTitle(String textTitle) throws InterruptedException{    	
	    	Page.enterText(title, textTitle);
	    }   

	    public void setDescription(String textDesc) throws InterruptedException{    	
	    	Page.enterText(description, textDesc);
	    }  
	    
	    public void modifyTitle(String textTitle) throws InterruptedException{  
	    	Page.click(investigationTitle);
	    	Page.enterText(investigationTitle, textTitle);
	    }
	    
	    public void modifyDescription(String textDesc) throws InterruptedException{    
	    	Page.click(investigationDesc);
	    	Page.enterText(investigationDesc, textDesc);
	    } 

	    public void clickSave(){
	    	Page.click(saveInvestigation);
	    }  
	    

	    public void openItemFromList(String inv)
	    {
	    	try {	    		
	    		do{ 
	    			for (WebElement element : invGridItems) {
	    				if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
	    				String textFromGrid = element.getText();	    				
		    				if(inv.equals(textFromGrid)) {		    					
		    					Page.click(element);	
		    				}		    				
	    			}
	    			Page.click(forward); 
	    		}
	    		while(forward.isEnabled());  
	    	}	    	
	    	catch(Exception ex) {}
	    }
	    
	    public void selectItemForDeletion(String inv)
	    {
	    	try {	    		
	    		do{ 
    			for (WebElement element : invGridRows) { 
    				if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
    				String textFromGrid = element.getText();	    				
	    				if(textFromGrid.contains(inv)) {	
	    					WebElement deleteOption = element.findElement(By.xpath(".//button"));	    					
	    					deleteOption.click();
	    					break;
	    			}
    			}
	    			Page.click(forward); 
    			}    			
    			while(forward.isEnabled());
	    	}	    	
	    	catch(Exception ex) {}
	    }
	    
	    public void createInvestigation(String invTitle, String invDesc) throws InterruptedException{
	    	this.clickInvestigationIcon();
	    	this.addInvestigation();
	        this.setTitle(invTitle);
	        this.setDescription(invDesc);
	        this.clickSave();   
	    }	
	    
	    public void editInvestigation(String inv, String invTitle, String invDescription) throws InterruptedException{
	    	this.clickInvestigationIcon();	  
	    	this.openItemFromList(inv);	    	
	    	modifyTitle(invTitle);	    	
	    	modifyDescription(invDescription);	    	
	    }	
	    
	    public void viewInvestigation(String inv){
	    	this.clickInvestigationIcon();	  
	    	this.openItemFromList(inv);	    	
	    }
	    
	    public void linkSettoInvestigation(String invName, String setTobeLinked)
	    {
	    	this.clickInvestigationIcon();
	    	this.openItemFromList(invName);	
	    	Page.click(tabSets);
	    	this.addAction();
	    	Page.click(linkSet);
	    	Page.click(selectASet);
	    	this.openItemFromList(setTobeLinked);	
	    }  
	   
	    public void linkExplorationtoInvestigation(String invName, String explorationTobeLinked)
	    {
	    	this.clickInvestigationIcon();
	    	this.openItemFromList(invName);		    	
	    	Page.click(tabExplorations);
	    	this.addAction();
	    	Page.click(linkExploration);
	    	Page.click(selectAnExploration);
	    	this.openItemFromList(explorationTobeLinked);	
	    }
	    
	    public void linkComparisontoInvestigation(String invName, String comparisonTobeLinked)
	    {
	    	this.clickInvestigationIcon();
	    	this.openItemFromList(invName);	
	    	Page.click(tabComparisons);
	    	this.addAction();
	    	Page.click(linkComparison);
	    	Page.click(selectAComparison);
	    	this.openItemFromList(comparisonTobeLinked);		    	
	    }	    
	    
	    public void deleteInvestigation(String invToBeDeleted){
	    	this.clickInvestigationIcon();	 
	    	selectItemForDeletion(invToBeDeleted);
	    	Page.click(deleteIcon);
	    	Page.click(deleteIcon);	 
	    	//Add code to confirm deletion is happened or not	    	
	    }
	    
	    public void shareInvestigation(String invToBeShared, String personToBeShared) throws InterruptedException{
	    	this.clickInvestigationIcon();	 
	    	selectItemForDeletion(invToBeShared);
	    	Page.click(shareIcon);
	    	Page.enterText(selectPersonToShare,personToBeShared);	
	    	Page.click(suggestedUsers);
	    	Page.click(share);	
	    }
	    
}
