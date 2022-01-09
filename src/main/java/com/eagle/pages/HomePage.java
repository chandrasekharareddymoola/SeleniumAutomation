package com.eagle.pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;

public class HomePage extends BasePage{

	//Web Elements in page

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

	@FindBy(xpath = "//h6")
	public WebElement profileNameactual;

	@FindBy(xpath = "//*[@role='button' and @aria-haspopup='listbox']/span/div/span")
	public WebElement filterCount;	

	@FindBy(xpath = "//*[@data-icon-name='CalculatorMultiply']/parent::li")
	public WebElement filterName;	

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

	@FindBy(xpath = "//i[@data-icon-name='LifeSaver']")
	public WebElement lifeSaverIcon;

	@FindBy(xpath = "//span[text()='Contact Help Desk']")
	public WebElement contactHelpDesk;

	@FindBy(xpath = "//span[text()='User Manual']")
	public WebElement userManual;

	@FindBy(xpath = "//span[text()='FAQ']")
	public WebElement FAQ;

	@FindBy(xpath = "//span[text()='Eagle Genomics Support']")
	public WebElement EaglegenomicsSupportText;

	@FindBy(xpath = "//h1[text()='Help Desk']")
	public WebElement HelpDesk;
	
	@FindBy(xpath = "//h1[text()='FAQ']")
	public WebElement FAQtext;

	@FindBy(xpath = "//div[@scraper-tag='UserManual']//iframe[contains(@class,'UserManual__userManualPDF')]")
	public WebElement userManualPDF;	
	

	//Methods

	public HomePage(){ 		 
		PageFactory.initElements(driver, this); 
	}


	//Open a particular item (Search) from list
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

	//Verify the visibility of logo
	public void verifyLogoVisibility() throws Exception
	{
		try {
			waitforAnElement(homeLogo);
			boolean logoPresent = homeLogo.isDisplayed();
			Assert.assertTrue(logoPresent);
			if (logoPresent){		            
				System.out.println("Logo is displayed.");
				ExtentTestManager.getTest().log(Status.PASS, "Logo is displayed");
			}
		}catch(Exception ex) {
			throw ex;	
		}    
	}

	//Verify the components in Dashboard
	public void verifyDashboardComponents() throws Exception
	{
		try {
			boolean btnExploration = explorationButton.isDisplayed();
			if(btnExploration==true) {
				ExtentTestManager.getTest().log(Status.PASS, "explorationButton is displayed");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "explorationButton is not displayed");
			}
			boolean btnComparison = comparisonButton.isDisplayed();
			if(btnComparison==true) {
				ExtentTestManager.getTest().log(Status.PASS, "comparisonButton is displayed");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "comparisonButton is not displayed");	
			}
			boolean btnSet = setButton.isDisplayed();
			if(btnSet==true) {
				ExtentTestManager.getTest().log(Status.PASS, "setButton is displayed");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "setButton is not displayed");	
			}
			boolean headerRecent = recentActivityHeader.isDisplayed();	
			if(headerRecent==true) {
				ExtentTestManager.getTest().log(Status.PASS, "recentActivityHeader is displayed");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "recentActivityHeader is not displayed");	
			}
			boolean containerRecent = recentActivityContainer.isDisplayed();
			if(containerRecent==true) {
				ExtentTestManager.getTest().log(Status.PASS, "recentActivityContainer is displayed");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "recentActivityContainer is not displayed");	
			}

		}catch(Exception ex) {
			throw ex;	
		}    
	} 

	//Verify the components in Dashboard
	public void verifyUserProfiles(String ProfileName) throws Exception
	{		
		try {
			BasePage.click(userControl);
			BasePage.click(profileSettings);
			//			ReadObject object = new ReadObject();											//remove these comments if user mail ID is displayed in Dashboard and comment the ones with Profile name
			//			Properties configObject = object.getObjectRepositoty();	 
			//			String expected = configObject.getProperty("Username");						
			String expected = ProfileName;
			String actual = profileNameactual.getText();
			BasePage.click(profileBack);
			assertEquals(actual, expected);
		}catch(Exception | AssertionError ex) {
			throw ex;	
		}    
	}

	//Verify the Copyrights and the text within it
	public void verifyCopyRights()
	{
		try {
			String copyRightsText = copyRights.getText();    	
			int year = Calendar.getInstance().get(Calendar.YEAR);
			String currentYear = String.valueOf(year);  
			Assert.assertEquals(copyRightsText, "Copyright © "+ currentYear +" Eagle Genomics. All rights reserved");
			Assert.assertTrue(privacy.isDisplayed());
			Assert.assertTrue(termOfUse.isDisplayed());
			ExtentTestManager.getTest().log(Status.PASS, "Copyright is verified");
		}
		catch(Exception | AssertionError ex) {
			throw ex;	
		} 
	}

	//Select a particular entity as filter for search
	public WebElement selectFilter(String entityName) {
		return BasePage.driver.findElement(By.xpath("//div[@title='"+ entityName +"']"));   		
	}	

	//Verify the Copyrights and the text within it
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
			assertEquals(filterCount.getText(), "2 selected");
			ExtentTestManager.getTest().log(Status.PASS, "2 filters are verified");
			assertEquals(filterName.getText(), "pax");
			ExtentTestManager.getTest().log(Status.PASS, "Search is verified");
			BasePage.click(saveSearch);
			BasePage.click(saveButton);  
			ExtentTestManager.getTest().log(Status.PASS, "Search is saved");
		}
		catch(Exception |AssertionError ex) 	{
			throw ex;
		}
	}

	//Open a saved search and verify if it is saved properly
	public void verifySavedSearches() throws Exception
	{
		try {
			BasePage.click(searchIcon);
			BasePage.click(viewSavedSearches);
			BasePage.waitforAnElement(savedSearchesLabel);
			BasePage.waitforAnElement(columnHeader);
			this.openItemFromList("pax");
			ExtentTestManager.getTest().log(Status.PASS, "Saved search is verified and opened");
			assertEquals(filterCount.getText(), "2 selected");
			ExtentTestManager.getTest().log(Status.PASS, "2 filters are present");
		}
		catch(Exception ex)    	{
			BasePage.click(savedSearchCancelButton);
			ExtentTestManager.getTest().log(Status.FAIL, "Some probelm with Saved Search");
			throw ex;
		}

	}    

	//Click and verify Contact Help Desk
	public void VerifyContactHelpDesk() throws Exception
	{
		try {
			BasePage.click(lifeSaverIcon);
			BasePage.click(contactHelpDesk);
			//Need to add steps to switch active window
			assertEquals(EaglegenomicsSupportText.getText(), "Eagle Genomics Support");  
			assertEquals(HelpDesk.getText(), "Help Desk");  
		}
		catch(Exception ex)    	{
			ExtentTestManager.getTest().log(Status.FAIL, "Contact Help Desk verification failed");
			throw ex;
		}
	}  

	//Click and verify user manual
	public void VerifyUserManual() throws Exception
	{
		try {
			BasePage.click(lifeSaverIcon);
			BasePage.click(contactHelpDesk);
			//Need to add steps to switch active window
			BasePage.waitforAnElement(userManualPDF);
		}
		catch(Exception ex)    	{
			ExtentTestManager.getTest().log(Status.FAIL, "User manual is not present");
			throw ex;
		}
	}  

	//Click and verify FAQ
	public void VerifyFAQ() throws Exception
	{
		try {
			BasePage.click(lifeSaverIcon);
			BasePage.click(FAQ);
			//Need to add steps to switch active window
			assertEquals(EaglegenomicsSupportText.getText(), "Eagle Genomics Support");  
			assertEquals(FAQtext.getText(), "FAQ");  
		}
		catch(Exception ex)    	{
			BasePage.click(savedSearchCancelButton);
			ExtentTestManager.getTest().log(Status.FAIL, "FAQ page is not displayed");
			throw ex;
		}
	}  

	//Logout of the system
	public void logout() throws Exception
	{
		try {
			BasePage.click(userControl);
			BasePage.click(logOut);

		}catch(Exception ex) {
			throw ex;	
		}    
	}  

	//Screenshot method
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
