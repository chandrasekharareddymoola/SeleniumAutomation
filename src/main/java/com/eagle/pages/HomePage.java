package com.eagle.pages;

import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	
	public HomePage(){ 		 
		 PageFactory.initElements(driver, this); 
	 }
    
    public String getHomePageDashboardUserName(){
    	return searchIcon.getText();
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
    
    public void verifyUserProfiles()
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
    
    public void logout()
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
        String dest = "./Resources/ErrorScreenshots/"+screenShotName+".jpeg";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }     
                     
        return dest;
    }
	        
}
