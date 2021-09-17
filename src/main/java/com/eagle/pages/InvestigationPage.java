package com.eagle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
			
		 public InvestigationPage(){ 		 
			 PageFactory.initElements(driver, this); 
		 }

		public void clickInvestigationIcon(){    	
	    	Page.click(investigationIcon);
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

	    public void clickSave(){
	    	Page.click(saveInvestigation);
	    }  
	    
	    public void createInvestigation(){
	    	this.clickInvestigationIcon();
	    	this.addInvestigation();
	        this.setTitle("Inv 1");
	        this.setDescription("Inv desc 1");
	        this.clickSave();   
	    }	    
	
}
