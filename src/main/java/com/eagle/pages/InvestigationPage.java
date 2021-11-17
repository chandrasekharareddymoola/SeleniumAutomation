package com.eagle.pages;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


public class InvestigationPage extends BasePage{

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

	public void clickInvestigationIcon() throws InterruptedException, AWTException{    	
		BasePage.click(investigationIcon);
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.	    	
		action.moveToElement(copyRightIdentifier).perform();

	}

	public void addInvestigation() throws InterruptedException, AWTException{    	
		BasePage.click(addInvestigation);
	}


	public void addAction() throws InterruptedException, AWTException{    	
		BasePage.click(addAction);
	}


	public void setTitle(String textTitle) throws InterruptedException, AWTException {    	
		BasePage.enterText(title, textTitle);
	}   

	public void setDescription(String textDesc) throws InterruptedException, AWTException{    	
		BasePage.enterText(description, textDesc);
	}  

	public void modifyTitle(String textTitle) throws InterruptedException, AWTException{  
		BasePage.click(investigationTitle);
		BasePage.enterText(investigationTitle, textTitle);
	}

	public void modifyDescription(String textDesc) throws InterruptedException, AWTException{    
		BasePage.click(investigationDesc);
		BasePage.enterText(investigationDesc, textDesc);
	} 

	public void clickSave() throws InterruptedException, AWTException{
		BasePage.click(saveInvestigation);
	}  


	public void openItemFromList(String inv)
	{
		try {	    		
			do{ 
				for (WebElement element : invGridItems) {
					if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
					String textFromGrid = element.getText();	    				
					if(inv.equals(textFromGrid)) {		    					
						BasePage.click(element);	
					}		    				
				}
				BasePage.click(forward); 
			}
			while(forward.isEnabled());  
		}	    	
		catch(Exception ex) {}
	}

	public void selectItemForDeletion(String inv)
	{
		try {	
			outerloop:
				do{ 
					for (WebElement element : invGridRows) { 
						if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
						String textFromGrid = element.getText();	    				
						if(textFromGrid.contains(inv)) {
							//WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript(
							//"return arguments[0].parentNode;", element);
							WebElement deleteOption = element.findElement(By.tagName("button"));	    					
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

	public void createInvestigation(String invTitle, String invDesc) throws Exception{
		try {
			this.clickInvestigationIcon();
			this.addInvestigation();
			this.setTitle(invTitle);
			this.setDescription(invDesc);
			this.clickSave();   
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	public void editInvestigation(String inv, String invTitle, String invDescription) throws InterruptedException, AWTException{
		this.clickInvestigationIcon();	  
		this.openItemFromList(inv);	    	
		modifyTitle(invTitle);	    	
		modifyDescription(invDescription);	    	
	}	

	public void viewInvestigation(String inv) throws InterruptedException, AWTException{
		this.clickInvestigationIcon();	  
		this.openItemFromList(inv);	    	
	}

	public void linkSettoInvestigation(String invName, String setTobeLinked) throws IOException
	{
		try {  
			this.clickInvestigationIcon();
			this.openItemFromList(invName);	
			BasePage.click(tabSets);
			this.addAction();
			BasePage.click(linkSet);
			BasePage.click(selectASet);
			this.openItemFromList(setTobeLinked);
		}
		catch(Exception ex)
		{

		}
	}  

	public void linkExplorationtoInvestigation(String invName, String explorationTobeLinked) throws InterruptedException, AWTException
	{
		this.clickInvestigationIcon();
		this.openItemFromList(invName);		    	
		BasePage.click(tabExplorations);
		this.addAction();
		BasePage.click(linkExploration);
		BasePage.click(selectAnExploration);
		this.openItemFromList(explorationTobeLinked);	
	}

	public void linkComparisontoInvestigation(String invName, String comparisonTobeLinked) throws InterruptedException, AWTException
	{
		this.clickInvestigationIcon();
		this.openItemFromList(invName);	
		BasePage.click(tabComparisons);
		this.addAction();
		BasePage.click(linkComparison);
		BasePage.click(selectAComparison);
		this.openItemFromList(comparisonTobeLinked);		    	
	}	    

	public void deleteInvestigation(String invToBeDeleted) throws Exception {
		this.clickInvestigationIcon();	 
		selectItemForDeletion(invToBeDeleted);
		BasePage.click(deleteIcon);
		BasePage.click(deleteIcon);	 
		//Add code to confirm deletion is happened or not	    	
	}


	public void shareInvestigation(String invToBeShared, String personToBeShared) throws Exception{
		this.clickInvestigationIcon();	 
		selectItemForDeletion(invToBeShared);
		BasePage.click(shareIcon);
		BasePage.enterText(selectPersonToShare,personToBeShared);	
		BasePage.click(suggestedUsers);
		BasePage.click(share);		    	
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
