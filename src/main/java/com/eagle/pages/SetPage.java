package com.eagle.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetPage extends Page{

		//Page level objects
	  
	 	@FindBy(xpath = "//i[@data-icon-name='DocumentSet']")
		public WebElement setIcon;
	 	
		@FindBy(xpath = "//div//span[contains(text(),'Set')]")
		public WebElement addSet;
		
		@FindBy(xpath = "//div[@scraper-tag='CardHeader']//span")
		public WebElement pageIdentifier;
		
		@FindBy(xpath = "//div//span[contains(text(),'Uncategorized')]")
		public WebElement entitySelection;
		
		@FindBy(xpath = "//div//input[@type='text']")
		public WebElement titleSet;
		
		@FindBy(xpath = "//button//span[contains(text(),'MASI Disease')]")
		public WebElement entitySelected;	
		
		@FindBy(xpath = "//div//input[@role='searchbox']")
		public WebElement serachBox;	
		
		@FindBy(xpath = "//button[@title='Add all items']")
		public WebElement addAll;		
		
		@FindBy(xpath = "//div//span[contains(text(),'Accept')]")
		public WebElement accept;		
		
		public WebElement openSet(String name) {
	        return this.driver.findElement(By.xpath("//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']//div[@title='"+ name +"']"));   		
	    }
		
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
		
		//Page level functions on the objects
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		 public SetPage(){ 		 
			 PageFactory.initElements(driver, this); 
			 Page.click(setIcon);
		 }
		 
	    public void verifySetHomePage(){    	
	    	Page.verifyPage(pageIdentifier);
	    }

		public void addSet(){ 
	    	Page.click(addSet);
	    }
		
	    public void setTitle(String textTitle){    	
	    	Page.enterText(titleSet, textTitle);
	    }   

	    public void selectEntity(){    	
	    	Page.click(pageIdentifier);
	        Page.click(entitySelected);
	    }

	    public void searchItems(){
	    	Page.click(serachBox);
	    	Page.enterText(serachBox, "x");
	    }
	    
	    public void AddandAccept(){
	    	
			//wait.until(ExpectedConditions.elementToBeClickable(addAll));
	    	while(addAll.isDisplayed()){
	    		try
	    		{   Page.click(addAll);	 
	    			wait.until(ExpectedConditions.elementToBeClickable(addAll));
	    		}
	    		catch(Exception ex){Page.click(accept);}	    		
	    	}
	    	
	    	Page.click(accept);
	    }
	    
	    public void createSet(){	    	
	    	this.addSet();
	        this.verifySetHomePage();
	        this.setTitle("SetName 1");
	        this.selectEntity();
	        this.searchItems(); 
	        this.AddandAccept(); 	        
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
	    }
	    
	    public void addItemsFromFile(String filePath) {	    
	          fileUpload.sendKeys(filePath);				
	    }
	    
	    public void addItemsFromSet(String existingSetName) {	    
	    	Page.click(addFromSet);	    	
	    	WebElement opn = this.openSet("MASI Set");
	    	Page.click(opn);  
	    }
	    
	    public void CreateSetFromFile() { 
	    	this.addSet();
	        this.verifySetHomePage();
	        this.setTitle("SetName 1");
	        this.selectEntity();
	        this.addItemsFromFile("C:\\Users\\DivyaDevanathan\\Downloads\\up_genes_symbol.txt"); 
	        this.AddandAccept(); 	  	
	    }
	    
	    public void CreateSetFromSet() { 
	    	this.addSet();
	        this.verifySetHomePage();
	        this.setTitle("SetName 1");
	        this.selectEntity();
	        this.addItemsFromSet("MASI Set"); 
	        this.accept(); 	  	
	    }
	
	
}
