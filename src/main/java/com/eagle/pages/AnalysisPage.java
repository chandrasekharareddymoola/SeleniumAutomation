package com.eagle.pages;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;


public class AnalysisPage extends BasePage{

	//Web Elements in page

	@FindBy(xpath = "//*[@data-icon-name='LineChart']")
	public WebElement AnalysisIcon;

	@FindBy(xpath = "//h5[text()='ANALYSIS HUB']")
	public WebElement AnalysisHubName;

	@FindBy(xpath = "//div[@scraper-tag='newAnalysisButton']//span[text()='Analysis']")
	public WebElement AddAnalysisButton;

	@FindBy(xpath = "//*[@role='columnheader']")
	public WebElement columnHeaderFirstPage;

	@FindBy(xpath = "//label[text()='Create an Analysis']")
	public WebElement CreateAnAnalysisHeader;

	@FindBy(xpath = "//label[text()='Name']")
	public WebElement AnalysisNameCreate;

	@FindBy(xpath = "//label[text()='Description']")
	public WebElement AnalysisDescriptionCreate;

	@FindBy(xpath = "//label[text()='Select a Study']")
	public WebElement AnalysisSelectStudyCreate;

	@FindBy(xpath = "//label[text()='Name']//parent::div//*[@type='text']")
	public WebElement AnalysisNameText;

	@FindBy(xpath = "//label[text()='Description']//parent::div//following-sibling::div//*[@class='ms-TextField-wrapper']//child::textarea")
	public WebElement AnalysisDescriptionText;

	@FindBy(xpath = "//button[@type='button']//span[text()='Cancel']")
	public WebElement AnalysisCreateCancel;

	@FindBy(xpath = "//span[text()='Save']//ancestor::button")
	public WebElement saveButtonCheck;

	@FindBy(xpath = "//button[@type='button' and @data-is-focusable='false']//span[text()='Save']")
	public WebElement saveDisabledAnalysisCreate;

	@FindBy(xpath = "//button[@type='button' and @data-is-focusable='true']//span[text()='Save']")
	public WebElement saveEnabledAnalysisCreate;

	@FindBy(xpath = "//i[@data-icon-name='Cancel']")
	public WebElement AnalysisCreationCancel;

	@FindBy(xpath = "//div[@role='heading' and text()='Confirmation?']")
	public WebElement CancelConfirmationMessage;

	@FindBy(xpath = "//p[text()='Fields have been modified, Are you sure you want to exit?']")
	public WebElement WariningMessageforCancel;

	@FindBy(xpath = "//button[@type='button']//*[text()='Ok']")
	public WebElement OkButtonAnalysisCreate;

	@FindBy(xpath = "(//button[@type='button']//*[text()='Cancel'])")
	public WebElement CancelButtonAnalysisCreate;
	
	@FindBy(xpath = "(//button[@type='button']//*[text()='Cancel'])[2]")
	public WebElement CancelButtonInConfirmationBox;

	@FindBy(xpath = "//*[@role='listbox']")
	public WebElement listBox;

	@FindBy(xpath = "//*[@role='listbox']//*[@data-automationid='splitbuttonprimary']//span[text()='Galleon']")
	public WebElement studySelection;

	@FindBy(xpath = "//button[text()='Analysis created successfully']")
	public WebElement analysisCreatedMessage;
	
	@FindBy(xpath = "//button[text()='Analysis details updated']")
	public WebElement analysisupdateMessage;

	@FindBy(xpath = "//button//span[contains(text(),'Save')]")
	public WebElement saveButton;	

	@FindBy(xpath = "//div//label[contains(text(),'Copyright')]")
	public WebElement copyRightIdentifier;

	@FindBy(xpath = "//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']")
	public List<WebElement> AnaGridItems;

	@FindBy(xpath = "//div[@class='ms-List']//div[@role='row']")
	public List<WebElement> AnaGridRows; 

	@FindBy(xpath = "//button//span[contains(text(),'View')]")
	public WebElement ViewButton;
	
	@FindBy(xpath = "//button//span[contains(text(),'Edit')]")
	public WebElement EditButton;
	
	@FindBy(xpath = "//button//span[contains(text(),'Delete')]")
	public WebElement DeleteButton;

	@FindBy(xpath = "//*[@role='listbox' and @data-is-focusable='false']")
	public WebElement studyDisabledCheck;

	@FindBy(xpath = "//*[@data-icon-name='Cancel']")
	public WebElement dialogBoxClose;
	
	@FindBy(xpath = "//div[@role='heading' and text()='Delete Analysis?']")
	public WebElement DeleteConfirmationMessage;

	@FindBy(xpath = "//p[text()='All data associated with this Analysis will be removed.']")
	public WebElement WariningMessageforDelete;
	
	
	
	








	@FindBy(xpath = "//i[@data-icon-name='Add']")
	public WebElement addInvestigation;

	@FindBy(xpath = "//label[contains(text(),'Title')]/following::input")
	public WebElement title;

	@FindBy(xpath = "//label[contains(text(),'Title')]/following::textarea")
	public WebElement description;

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

	@FindBy(xpath = "//*[@class='ms-List' and @role='presentation']")
	public WebElement AnalysisList;



	@FindBy(xpath = "//*[text()='Resource shared successfully']")
	public WebElement ShareSuccess;	


	//Methods

	public AnalysisPage(){ 		 
		PageFactory.initElements(driver, this); 
	}

	//Click the Analysis icon 
	public void clickAnalysisIcon() throws InterruptedException, AWTException{    	
		BasePage.click(AnalysisIcon);
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element so that the left drawer closes    	
		action.moveToElement(copyRightIdentifier).perform();
	}

	//Click Add an Analysis
	public void ClickAddAnalysis() throws InterruptedException, AWTException{    	
		BasePage.click(AddAnalysisButton);		
	}

	//Set the Name of the Analysis
	public void SetNameForAnalysis(String AnalysisName) throws InterruptedException, AWTException {    	
		BasePage.click(AnalysisNameText);
		BasePage.enterText(AnalysisNameText, AnalysisName);
	}   

	//Set the Description of the Analysis
	public void SetDescForAnalysis(String AnalysisDescription) throws InterruptedException, AWTException {    	
		BasePage.click(AnalysisDescriptionText);
		BasePage.enterText(AnalysisDescriptionText, AnalysisDescription);
	}   

	//Select Study for Analysis
	public void SelectAStudy(String StudyName) throws InterruptedException, AWTException {  
		BasePage.click(listBox);
		WebElement SN = driver.findElement(By.xpath("//*[@role='listbox']//*[@data-automationid='splitbuttonprimary']//span[text()='"+StudyName+"']"));	
		BasePage.click(SN);
	}   
	
	//Click Save to create Analysis
	public void clickSave() throws InterruptedException, AWTException{
		BasePage.click(saveButton);
	}  

	//Click Cancel to cancel creation of Analysis
	public void clickCancel() throws InterruptedException, AWTException{
		BasePage.click(CancelButtonAnalysisCreate);
	}  


	//Create an Analysis
	public void createAnalysis(String AnalysisName, String AnalysisDescription, String StudyName) throws Exception{
		try {
			this.clickAnalysisIcon();
			this.ClickAddAnalysis(); 

			BasePage.verifyPage("Name", AnalysisNameCreate);
			ExtentTestManager.getTest().log(Status.PASS,"'Name' field is present");
			this.SetNameForAnalysis(AnalysisName);	
			ExtentTestManager.getTest().log(Status.PASS,"Analysis name is set to '"+AnalysisName+"'");

			BasePage.verifyPage("Description", AnalysisDescriptionCreate);
			ExtentTestManager.getTest().log(Status.PASS,"'Description' field is present");
			this.SetDescForAnalysis(AnalysisDescription);
			ExtentTestManager.getTest().log(Status.PASS,"Analysis Description is set to '"+AnalysisDescription+"'");

			BasePage.verifyPage("Select a Study", AnalysisSelectStudyCreate);
			ExtentTestManager.getTest().log(Status.PASS,"'Select a study' field is present");
			this.SelectAStudy(StudyName);
			ExtentTestManager.getTest().log(Status.PASS,"Study Name is set to '"+StudyName+"'");

			this.clickSave();   
			BasePage.waitforAnElement(analysisCreatedMessage);
			ExtentTestManager.getTest().log(Status.PASS,AnalysisName +  " - Analysis is created");
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Removes text in any particular field
	public void removeTextInField(WebElement field) throws Throwable{
		try {		
			BasePage.click(field);
			field.sendKeys(Keys.CONTROL + "a");		
			field.sendKeys(Keys.DELETE);
		}
		catch(Throwable ex) {
			throw ex;
		}
	}	

	//Check mandatory fields in Analysis
	public void checkMandatoryfieldsinAnalysis(String AnalysisName, String AnalysisDescription, String StudyName) throws Throwable{
		try {
			this.clickAnalysisIcon();
			this.ClickAddAnalysis(); 
			BasePage.verifyPage("Name", AnalysisNameCreate);
			this.SetNameForAnalysis(AnalysisName);								//Set Analysis Name
			BasePage.verifyPage("Description", AnalysisDescriptionCreate);
			this.SetDescForAnalysis(AnalysisDescription);						//Set Analysis Description
			BasePage.CompareAttributeText("data-is-focusable","false",saveButtonCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Save is not enabled since Study is not selected");

			this.removeTextInField(AnalysisNameText);							//Remove Analysis Name
			BasePage.verifyPage("Select a Study", AnalysisSelectStudyCreate);	
			this.SelectAStudy(StudyName);										//Set Analysis Study
			BasePage.CompareAttributeText("data-is-focusable","false",saveButtonCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Save is not enabled since Analysis Name is not present");

			this.SetNameForAnalysis(AnalysisName);								//Type in Analysis Name
			this.removeTextInField(AnalysisDescriptionText);					//Remove Analysis Description
			BasePage.CompareAttributeText("data-is-focusable","false",saveButtonCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Save is not enabled since Analysis Description is not present");

			this.SetDescForAnalysis(AnalysisDescription);						//Set Analysis Description

			this.clickSave();   
			BasePage.waitforAnElement(analysisCreatedMessage);

			ExtentTestManager.getTest().log(Status.PASS,AnalysisName +  " - Analysis is created after mandatory check");
		}
		catch(Exception ex) {
			throw ex;
		}
	}	


	//Open a particular item (Analysis) from list
	public void openItemFromList(String AnalysisName) throws Exception
	{
		try {	
			outerloop:
				do{ 
					BasePage.waitforAnElement(AnalysisList);
					for (WebElement element : AnaGridItems) {
						if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
						String textFromGrid = element.getText();	    				
						if(AnalysisName.equals(textFromGrid)) {		    					
							BasePage.click(element);	
							break outerloop;
						}		    				
					}
					BasePage.click(forward); 
				}
				while(forward.isEnabled());  
		}	    	
		catch(Exception ex) {
			throw ex;
		}
	}

	//Select the action button for a particular item (Analysis)
	public void selectItemFortheList(String AnalysisName)
	{
		try {	
			outerloop:
				do{ 
					BasePage.waitforAnElement(AnalysisList);
					for (WebElement element : AnaGridItems) { 
						if(element.isDisplayed() == false)  {scrollIntoView(element);}	    				
						String textFromGrid = element.getText();	    				
						if(textFromGrid.equals(AnalysisName)) {
							WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript(
									"return arguments[0].parentNode;", element);
							WebElement threeDot = parent.findElement(By.tagName("button"));	    					
							threeDot.click();
							break outerloop;
						}
					}
					BasePage.click(forward); 
				}    			
				while(forward.isEnabled());
		}	    	
		catch(Exception ex) {}
	}	
	
	//Click View button in action
	public void clickView() throws InterruptedException, AWTException{
		BasePage.click(ViewButton);
	}  

	//Click Edit button in action
	public void clickEdit() throws InterruptedException, AWTException{
		BasePage.click(EditButton);
	}  
	
	//Click Delete button in action
	public void clickDelete() throws InterruptedException, AWTException{
		BasePage.click(DeleteButton);
	}  

	//Edit Analysis In list
	public void EditAnalysis(String AnalysisName, String AnalysisDescription, String StudyName) throws Throwable{
		try {	
			this.clickEdit();
			
			this.removeTextInField(AnalysisNameText);
			this.SetNameForAnalysis(AnalysisName);	
			ExtentTestManager.getTest().log(Status.PASS,"Analysis name is updated to '"+AnalysisName+"'");

			this.removeTextInField(AnalysisDescriptionText);
			this.SetDescForAnalysis(AnalysisDescription);
			ExtentTestManager.getTest().log(Status.PASS,"Analysis Description is updated to '"+AnalysisDescription+"'");

			BasePage.waitforAnElement(studyDisabledCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Study Name disabled and the user is not able to select");
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	//Create and Edit Analysis From list
	public void AnalysisNameAndDescEditInList(String AnalysisNameinital, String AnalysisDescriptioninital, String StudyName,String AnalysisName, String AnalysisDescription) throws Throwable{
		try {
			createAnalysis(AnalysisNameinital,AnalysisDescriptioninital,StudyName);

			this.clickAnalysisIcon();
			this.selectItemFortheList(AnalysisNameinital);
			
			this.EditAnalysis(AnalysisName, AnalysisDescription, StudyName);
			this.clickCancel();
			BasePage.waitforAnElement(CancelConfirmationMessage);
			BasePage.waitforAnElement(WariningMessageforCancel);
			ExtentTestManager.getTest().log(Status.PASS,"Warning message is seen after cancel");
			BasePage.click(CancelButtonInConfirmationBox);
			
			BasePage.click(dialogBoxClose);
			BasePage.waitforAnElement(CancelConfirmationMessage);
			BasePage.waitforAnElement(WariningMessageforCancel);
			ExtentTestManager.getTest().log(Status.PASS,"Warning message is seen after dialog box");
			BasePage.click(CancelButtonInConfirmationBox);
			
			this.clickSave();
			BasePage.waitforAnElement(analysisupdateMessage);
			ExtentTestManager.getTest().log(Status.PASS, "'"+AnalysisName+"'" +  " - Analysis is updated");
		}
		catch(Exception ex) {
			throw ex;
		}
	}	
	
	//Delete a created Analysis
	public void DeleteAnalysis(String AnalysisName) throws Exception {
		this.clickAnalysisIcon();	 
		selectItemFortheList(AnalysisName);
		BasePage.click(DeleteButton);
		BasePage.waitforAnElement(DeleteConfirmationMessage);
		BasePage.waitforAnElement(WariningMessageforDelete);
		BasePage.click(DeleteButton);	
		ExtentTestManager.getTest().log(Status.PASS,AnalysisName +  " Analysis is deleted");
	}
		

	//Create and Delete Analysis From list
	public void CreateAndDeleteAnalysis(String AnalysisName, String AnalysisDescription, String StudyName) throws Throwable{
		try {
			createAnalysis(AnalysisName,AnalysisDescription,StudyName);

			this.clickAnalysisIcon();
			this.selectItemFortheList(AnalysisName);
			
			this.DeleteAnalysis(AnalysisName);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	















	//	//Append to the title of investigation
	//	public void modifyTitle(String textTitle) throws InterruptedException, AWTException{  
	//		BasePage.click(investigationTitle);
	//		BasePage.enterText(investigationTitle, textTitle);
	//	}
	//
	//	//Append to the Description of investigation
	//	public void modifyDescription(String textDesc) throws InterruptedException, AWTException{    
	//		BasePage.click(investigationDesc);
	//		BasePage.enterText(investigationDesc, textDesc);
	//	} 





















	//Open an investigation
	public void viewInvestigation(String inv) throws Throwable{		
		try {
			this.clickAnalysisIcon();	  
			this.openItemFromList(inv);	 
			ExtentTestManager.getTest().log(Status.PASS,inv +  " - Investigation is opened");
		}
		catch (Exception|AssertionError ex) {
			throw ex;
		}

	}

	//Create and link a set to an investigation
	public void linkSettoInvestigation(String invName, String setTobeLinked) throws Exception
	{
		try {  
			this.clickAnalysisIcon();
			this.openItemFromList(invName);	
			BasePage.click(tabSets);
			//			this.addAction();       //Need to remove
			BasePage.click(linkSet);
			BasePage.click(selectASet);
			this.openItemFromList(setTobeLinked);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			ExtentTestManager.getTest().log(Status.PASS,setTobeLinked +  " is linked to " + invName);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}  

	//Create and link an exploration to an investigation
	public void linkExplorationtoInvestigation(String invName, String explorationTobeLinked) throws Exception
	{
		this.clickAnalysisIcon();
		this.openItemFromList(invName);		    	
		BasePage.click(tabExplorations);
		//		this.addAction();     //Need to remove
		BasePage.click(linkExploration);
		BasePage.click(selectAnExploration);
		this.openItemFromList(explorationTobeLinked);	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ExtentTestManager.getTest().log(Status.PASS,explorationTobeLinked +  " is linked to " + invName);
	}

	//Create and link a comparison to an investigation
	public void linkComparisontoInvestigation(String invName, String comparisonTobeLinked) throws Exception
	{
		this.clickAnalysisIcon();
		this.openItemFromList(invName);	
		BasePage.click(tabComparisons);
		//		this.addAction();     //Need to remove
		BasePage.click(linkComparison);
		BasePage.click(selectAComparison);
		this.openItemFromList(comparisonTobeLinked);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.PASS,comparisonTobeLinked +  " is linked to " + invName);
	}	    

	//Delete a created investigation
	public void deleteInvestigation(String invToBeDeleted) throws Exception {
		this.clickAnalysisIcon();	 
		selectItemFortheList(invToBeDeleted);
		BasePage.click(deleteIcon);
		BasePage.click(deleteIcon);	
		ExtentTestManager.getTest().log(Status.PASS,invToBeDeleted +  " Investigation is deleted");
	}

	//Share an already created investigation
	public void shareInvestigation(String invToBeShared, String personToBeShared) throws Exception{
		try {
			this.clickAnalysisIcon();	 
			selectItemFortheList(invToBeShared);
			BasePage.click(shareIcon);
			BasePage.enterText(selectPersonToShare,personToBeShared);	
			BasePage.click(suggestedUsers);
			BasePage.click(share);	
			BasePage.waitforAnElement(ShareSuccess);
			ExtentTestManager.getTest().log(Status.PASS,invToBeShared +  " Investigation is shared");
		}
		catch (Exception e) {
			BasePage.click(dialogBoxClose);
			throw e;
		}
	}

	//Capture screenshot
	public String captureScreenshot(String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "./Resources/ErrorScreenshots/"+screenShotName+".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}     

		return dest;
	}
}
