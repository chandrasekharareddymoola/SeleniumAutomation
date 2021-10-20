package com.eagle.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eagle.Base.TaskBar;

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
		public WebElement lnkExploration;
		
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
		
	    public void setTitle(String textTitle){    	
	    	Page.enterText(title, textTitle);
	    }   

	    public void setDescription(String textDesc){    	
	    	Page.enterText(description, textDesc);
	    }  
	    
	    public void modifyTitle(String textTitle){  
	    	Page.click(investigationTitle);
	    	Page.enterText(investigationTitle, textTitle);
	    }
	    
	    public void modifyDescription(String textDesc){    
	    	Page.click(investigationDesc);
	    	Page.enterText(investigationDesc, textDesc);
	    } 

	    public void clickSave(){
	    	Page.click(saveInvestigation);
	    }  
	    
	    public void openInvestigation(String inv)
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
	    
	    public void createInvestigation(String invTitle, String invDesc){
	    	this.clickInvestigationIcon();
	    	this.addInvestigation();
	        this.setTitle(invTitle);
	        this.setDescription(invDesc);
	        this.clickSave();   
	    }	
	    
	    public void editInvestigation(String inv, String invTitle, String invDescription){
	    	this.clickInvestigationIcon();	  
	    	this.openInvestigation(inv);	    	
	    	modifyTitle(invTitle);	    	
	    	modifyDescription(invDescription);	    	
	    }	
	    
	    public void viewInvestigation(String inv){
	    	this.clickInvestigationIcon();	  
	    	this.openInvestigation(inv);	    	
	    }
	    
	    
	    public void linkSettoInvestigation(String invName, String setTobeLinked)
	    {
	    	this.clickInvestigationIcon();
	    	this.openInvestigation(invName);	
	    	Page.click(tabSets);
	    	Page.click(linkSet);
	    	Page.click(selectASet);
	    	this.openInvestigation(setTobeLinked);	
	    }
	    
	    /* Link exploration to an Investigation */
	    objInvestigationPage.linkExplorationtoInvestigation();	
	    
	    /* Link Comparison to an Investigation */
	    objInvestigationPage.linkComparisontoInvestigation();	

	    public void linkExplorationtoInvestigation(String invName, String explorationTobeLinked)
	    {
	    	this.clickInvestigationIcon();
	    	this.openInvestigation(invName);	
	    }
	    
	    public void linkComparisontoInvestigation(String invName, String comparisonTobeLinked)
	    {
	    	this.clickInvestigationIcon();
	    	this.openInvestigation(invName);	
	    	
	    }
	    
	    
	    public void deleteInvestigation(String inv){
	    	this.clickInvestigationIcon();	  
	    	    	
	    }
	    
	    public void shareInvestigation(String inv){
	    	this.clickInvestigationIcon();	  
	    	
	    }
	    
	    
	  
		/*
		 * this.expandSet(); this.editSet(); List<String> myAlist = new
		 * ArrayList<String>(); myAlist.add("DIS28"); myAlist.add("DIS53");
		 * myAlist.add("DIS3"); myAlist.add("DIS2"); myAlist.add("DIS1");
		 * this.selectItems(myAlist); this.removeItems();
		 */
	
}
