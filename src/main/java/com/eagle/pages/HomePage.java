package com.eagle.pages;

import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "//i[@data-icon-name='Home']")
	public WebElement homeIcon;
	
	@FindBy(xpath = "//i[@data-icon-name='Search']")
	public WebElement searchIcon;
	
	@FindBy(xpath = "//button[contains(@class,'AppHeader__logoButton')]//img")
	public WebElement homeLogo;
	
	@FindBy(xpath = "//button//span[contains(text(),'Exploration')]")
	public WebElement explorationButton;
	
	@FindBy(xpath = "//button//span[contains(text(),'Comparison')]")
	public WebElement comparisonButton;
	
	@FindBy(xpath = "//button//span[contains(text(),'Set')]")
	public WebElement setButton;
	
	@FindBy(xpath = "//div[contains(@class,'RecentActivity__recentActivity')]//label[contains(text(),'MY RECENT ACTIVITY')]")
	public WebElement recentActivityHeader;	
	
	@FindBy(xpath = "//div[contains(@class,'RecentActivity__recentActivity')]//div[contains(@class,'Carousel__carouselContainer')]")
	public WebElement recentActivityContainer;	
	
	@FindBy(xpath = "//div[contains(@class,'UserControls__userControls')]//button")
	public WebElement userControl;
	
	@FindBy(xpath = "//div[contains(@class,'AppFooter__footer')]//label[1]")
	public WebElement copyRights;	
	
	@FindBy(xpath = "//div[contains(@class,'AppFooter__footer')]//a[contains(text(),'Privacy')]")
	public WebElement privacy;	
	
	@FindBy(xpath = "//div[contains(@class,'AppFooter__footer')]//a[contains(text(),'Terms of Use')]")
	public WebElement termOfUse;	
	
	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	public WebElement logOut;		
	
	@FindBy(xpath = "//span[contains(text(),'Profile & Settings')]")
	public WebElement profileSettings;	
	
	@FindBy(xpath = "//span[contains(text(),'Back')]")
	public WebElement profileBack;	
	
	@FindBy(xpath = "//input[@role='searchbox']")
	public WebElement searchBox;
	
	@FindBy(xpath = "//div[contains(@class,'ms-Dropdown-container')]")
	public WebElement searchFiter;	
	
	@FindBy(xpath = "//label[text()='Saved searches']")
	public WebElement savedSearchesLabel;	
	
	@FindBy(xpath = "//label[text()='Saved searches']//parent::div//*[@data-icon-name='Cancel']")
	public WebElement savedSearchCancelButton;	
	
	@FindBy(xpath = "//div[@role='columnheader']")
	public WebElement columnHeader;
	
		
	public WebElement selectFilter(String entityName) {
		return this.driver.findElement(By.xpath("//div[@title='"+ entityName +"']"));   		
	}	
	
	@FindBy(xpath = "//*[text()='Save Search']")
	public WebElement saveSearch;	
	
	@FindBy(xpath = "//*[text()='Save']")
	public WebElement saveButton;	
	
	@FindBy(xpath = "//button//span[text()='View saved searches']")
	public WebElement viewSavedSearches;
	
	@FindBy(xpath = "//i[@data-icon-name='Forward']")
	public WebElement forward;
	
	@FindBy(xpath = "//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']")
	public List<WebElement> searchGridItems;
	
	
	public HomePage(){ 		 
		 PageFactory.initElements(driver, this); 
	 }
    
    public String getHomePageDashboardUserName(){
    	return searchIcon.getText();
    }
    
    public void openItemFromList(String inv) throws Exception
	{
		try {	
			outloop:
			do{ 
				for (WebElement element : searchGridItems) {
					if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
					String textFromGrid = element.getText();	    				
					if(inv.equals(textFromGrid)) {		    					
						BasePage.click(element);
						break outloop;
					}		    				
				}
				try {
					Thread.sleep(3000);
					System.out.println("check before forward click");
					forward.click();
				}
				catch(Exception e){
					break outloop;
				}
			}
			while(forward.isEnabled());  
		}	    	
		catch(Exception ex) {throw ex;}
	}
    
    public void verifyLogoVisibility()
    {
    	try {
		    	boolean logoPresent = homeLogo.isDisplayed();
		    	Assert.assertTrue(logoPresent);
		    	if (logoPresent){		            
		            System.out.println("Logo is displayed.");
		        }
    	}catch(Exception ex) {
    		 throw ex;	
    	}    
    }
    
    public void verifyDashboardComponents()
    {
    	try {
		    	boolean btnExploration = explorationButton.isDisplayed();
		    	boolean btnComparison = comparisonButton.isDisplayed();
		    	boolean btnSet = setButton.isDisplayed();
		    	    	
		    	boolean headerRecent = recentActivityHeader.isDisplayed();		    
		    	boolean containerRecent = recentActivityContainer.isDisplayed();
		    	
    	}catch(Exception ex) {
    		 throw ex;	
    	}    
    } 
    
    public void verifyUserProfiles() throws Exception
    {
    	try {
    		BasePage.click(userControl);
 		   	BasePage.click(profileSettings);
 		    BasePage.click(profileBack);
		    	
    	}catch(Exception ex) {
    		 throw ex;	
    	}    
    }
    
    public void verifyCopyRights()
    {
    	try {
	    	String copyRightsText = copyRights.getText();    	
	    	int year = Calendar.getInstance().get(Calendar.YEAR);
	    	String currentYear = String.valueOf(year);  
	    	Assert.assertEquals(copyRightsText, "Copyright © "+ currentYear +" Eagle Genomics. All rights reserved");
	    	Assert.assertTrue(privacy.isDisplayed());
	    	Assert.assertTrue(termOfUse.isDisplayed());
    	}
    	catch(Exception ex) {
   		 throw ex;	
    	} 
    }
    
    public void createGlobalSearch() throws Exception
    {
    	try {
    		BasePage.click(searchIcon);
    		BasePage.click(searchFiter);
    		WebElement filtr = this.selectFilter("Cell Type");
    		WebElement filtr1 = this.selectFilter("Gene");
    		BasePage.click(filtr);
    		BasePage.click(filtr1);    		
    		BasePage.enterText(searchBox, "pax");
    		searchBox.sendKeys(Keys.ENTER);
    		BasePage.click(saveSearch);
    		BasePage.click(saveButton);    		
    	}
    	catch(Exception ex) 	{
    		throw ex;
    	}
    	
    }
    
    public void verifySavedSearches() throws Exception
    {
    	try {
    		BasePage.click(searchIcon);
    		BasePage.click(viewSavedSearches);
    		BasePage.waitforAnElement(savedSearchesLabel);
    		BasePage.waitforAnElement(columnHeader);
    		this.openItemFromList("pax");    		
    	}
    	catch(Exception ex)    	{
    		BasePage.click(savedSearchCancelButton);
    		throw ex;
    	}
    	
    }    
    
    
    public void logout() throws Exception
    {
    	try {
    		   BasePage.click(userControl);
    		   BasePage.click(logOut);
		    	
    	}catch(Exception ex) {
    		 throw ex;	
    	}    
    }  
    
    public String captureScreenshot(String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "./Resources/ErrorScreenshots/"+screenShotName+".png";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }     
                     
        return dest;
    }
	        
}
