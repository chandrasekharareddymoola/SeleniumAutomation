package com.eagle.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveToOffsetAction;
import org.openqa.selenium.interactions.touch.MoveAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = "//button[text()='Analysis description updated']")
	public WebElement analysisdescriptionupdateMessage;

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

	@FindBy(xpath = "//*[@class='ms-List' and @role='presentation']")
	public WebElement AnalysisList;

	@FindBy(xpath = "//button[@type='button']//*[text()='More']")
	public WebElement AnalysisDescMoreButton;

	@FindBy(xpath = "//div[@role='heading' and text()='Analysis description']")
	public WebElement AnalysisDescriptionDialogBoxHeader;

	@FindBy(xpath = "//textarea[contains(@id,'TextField')]")
	public WebElement AnalysisLongDescTextbox;

	@FindBy(xpath = "//span[contains(text(),'Done')]")
	public WebElement DoneButton;

	@FindBy(xpath = "//span[text()='Analysis description']//parent::div//input[@type='text']")
	public WebElement AnalysisDescriptionInPage;

	@FindBy(xpath = "//*[text()='Resource shared successfully']")
	public WebElement ShareSuccess;	

	@FindBy(xpath = "//i[@data-icon-name='Down']")
	public WebElement DownButtonInAnalysisHeader;	

	@FindBy(xpath = "//*[text()='Analysis description']")
	public WebElement AnalysisDescriptionTextInPage;	

	@FindBy(xpath = "//*[@data-icon-name='CircleAdditionSolid']")
	public WebElement clickCircle;

	@FindBy(xpath = "//*[text()='Visualise Data']")
	public WebElement visualizeData;

	@FindBy(xpath = "//div[contains(@class,'NumericalSummary')]//div//span[text()='SUMMARY']")
	public WebElement summaryText;

	@FindBy(xpath = "(//div[contains(@class,'NumericalSummary')]//li)//span[1]")
	public List<WebElement> summaryListHeaders;

	@FindBy(xpath = "(//div[contains(@class,'NumericalSummary')])//span[text()='RANGE']")
	public WebElement Rangetext;

	@FindBy(xpath = "(//div[contains(@class,'NumericalSummary')])//span[contains(text(),'Minimum value')]")
	public WebElement MinimumValueText;

	@FindBy(xpath = "(//div[contains(@class,'NumericalSummary')])//span[contains(text(),'Maximum value')]")
	public WebElement MaximumValueText;

	@FindBy(xpath = "//*[@id='edit_min']")
	public WebElement EditMin;

	@FindBy(xpath = "//*[@id='edit_max']")
	public WebElement EditMax;

	@FindBy(xpath = "//span[text()='Cancel']")
	public WebElement CancelButton;

	@FindBy(xpath = "//span[text()='Add to my selection']")
	public WebElement AddToMySelectionButton;

	@FindBy(xpath = "//i[@data-icon-name='ChevronLeft']")
	public WebElement BackButtonInCatagory;

	@FindBy(xpath = "//div[contains(@class,'CategoricalSummary')]//li//span[text()='ALL']")
	public WebElement CategoryAllButton;

	@FindBy(xpath = "(//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')])//span")
	public List <WebElement> CategoryList;

	@FindBy(xpath = "(//div[contains(@class,'AnalysisHeader')])[1]")
	public WebElement analysisPageHeader;

	@FindBy(xpath = "//i[@data-icon-name='Back']")
	public WebElement mySelectionScreenOpen;

	@FindBy(xpath = "//i[@data-icon-name='Forward']")
	public WebElement mySelectionScreenClose;

	@FindBy(xpath = "//span[contains(@class,'NodeTitle') and text()='GRAPH']//ancestor::div[contains(@class,'react-flow__node-regularNodeView')]")
	public WebElement graphCanvas;

	@FindBy(xpath = "//span[text()='GRAPH']//ancestor::div[contains(@class,'react-flow__node-regularNodeView')]//i[@data-icon-name='BackToWindow']")
	public WebElement graphCanvasCompactView;

	@FindBy(xpath = "//span[text()='GRAPH']//ancestor::div[contains(@class,'react-flow__node-regularNodeView')]//i[@data-icon-name='MiniExpand']")
	public WebElement graphCanvasExpandview;

	@FindBy(xpath = "//span[text()='GRAPH']//ancestor::div[contains(@class,'RegularNodeView__fullScreen')]//i[@data-icon-name='MiniContract']")
	public WebElement graphCanvasExpandtoRegularview;

	@FindBy(xpath = "//span[text()='GRAPH']//ancestor::div[contains(@class,'react-flow__node-regularNodeView')]")
	public WebElement graphCanvasRegularViewCheck;

	@FindBy(xpath = "//span[text()='GRAPH']//ancestor::div[contains(@class,'RegularNodeView__fullScreen') and @role='presentation']")
	public WebElement graphCanvasExpandViewCheck;

	@FindBy(xpath = "//span[@role='presentation' and text()='The Study']")
	public WebElement StudyNode;

	@FindBy(xpath = "//span[contains(@class,'RegularNodeView')]")
	public WebElement StudyNameInGrpahCanvas;

	@FindBy(xpath = "//span[contains(@class,'SceneInformationPanel__informationPanelHeading')]")
	public WebElement StudyNameInMySelection;

	@FindBy(xpath = "//*[text()='Nothing to show']")
	public WebElement notingToShowText;

	@FindBy(xpath = "//*[text()='An error occured. Please contact your administrator.']")
	public WebElement contactAdminErrorMainPage;

	@FindBy(xpath = "//div[@role='presentation' and contains(@class,'CompactEntityNode')]/child::div[1]/span[@role='presentation']")
	public List <WebElement> EntityListInGraph;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//input[@type='checkbox']")
	public List <WebElement> FeatureListInGraphcheckbox;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Categorical'] | //div[contains(@class,'FeaturesList')]//*[text()='ALL'] | //div[contains(@class,'FeaturesList')]//button[@class='Numeric']")
	public List <WebElement> FeatureListInGraph;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Categorical'] | //div[contains(@class,'FeaturesList')]//button[@class='Numeric']")
	public List <WebElement> FeatureListExceptAll;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Categorical']")
	public List <WebElement> CategoricalFeatures;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Numeric']")
	public List <WebElement> NumericalFeatures;

	@FindBy(xpath = "//i[@data-icon-name='BackToWindow' and @role='presentation']")
	public WebElement EntityClose;

	@FindBy(xpath = "//input[@type='checkbox']//following-sibling::button")
	public WebElement FeatureValues;










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

	//Select Study for Analysis - Based on Name
	public void SelectAStudy(String StudyName) throws InterruptedException, AWTException {  
		BasePage.click(listBox);
		WebElement SN = driver.findElement(By.xpath("//*[@role='listbox']//*[@data-automationid='splitbuttonprimary']//span[text()='"+StudyName+"']"));	
		BasePage.click(SN);
	}   

	//Select Study for Analysis - Based on index number
	public String SelectAStudy2(String StudyNameIndex) throws InterruptedException, AWTException {  
		BasePage.click(listBox);
		WebElement SN = driver.findElement(By.xpath("//*[text()='Select a Study']//following::div[@role='listbox']//button[@type='button' and @aria-posinset='"+StudyNameIndex+"']"));	
		BasePage.click(SN);
		WebElement StudyNameText = driver.findElement(By.xpath("//span[contains(@id,'Dropdown')]"));
		String StudyName = StudyNameText.getText();
		return StudyName;
	}   

	//Click Save to create Analysis
	public void clickSave() throws InterruptedException, AWTException{
		BasePage.click(saveButton);
	}  

	//Click Cancel to cancel creation of Analysis
	public void clickCancel() throws InterruptedException, AWTException{
		BasePage.click(CancelButtonAnalysisCreate);
	}  


	//Wait for Analysis page to be displayed after an action as there will be a load time
	public void waitForAnalysisHub() throws Throwable{

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {  
			Date dt = new Date();
			DateFormat dtFrmt = new SimpleDateFormat("_HHmmss");
			String dtText = dtFrmt.format(dt);
			Thread.sleep(3000);
			int i=0;
			outerloop:
				do
				{ 
					try {	    	
						columnHeaderFirstPage.isDisplayed();
						break outerloop;
					}
					catch(Exception ex) {
						try {
							if(notingToShowText.isDisplayed()) {
								String screenshotname = "notingToShowText"+dtText;
								this.captureScreenshot(screenshotname);
								ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir")+"/Resources/ErrorScreenshots/"+screenshotname+".png");
								break outerloop;
							}
						}
						catch (Exception ey) {
							try {
								if(contactAdminErrorMainPage.isDisplayed()) {
									String screenshotname = "notingToShowText"+dtText;
									this.captureScreenshot(screenshotname);
									ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir")+"/Resources/ErrorScreenshots/"+screenshotname+".png");
									break outerloop;
								}
							}
							catch(Exception ez) {
								Thread.sleep(3000);	 
								i++;
								if(i==20) {
									break outerloop;
								}
							}
						}
					}
				}
				while(i<=20);         
		}
		catch(Exception | AssertionError ex)
		{
			throw ex;
		}
	}


	//Create an Analysis
	public void createAnalysis(String AnalysisName, String AnalysisDescription, String StudyName) throws Throwable{
		try {
			this.clickAnalysisIcon(); 
			this.waitForAnalysisHub();
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

			screenShotForPass("Analysis is filled with details", "AnalysisFilledWithDetails");

			Thread.sleep(2000);

			this.clickSave();   
			BasePage.waitforAnElement(analysisCreatedMessage);
			BasePage.waitforAnElement(StudyNode);

			screenShotForPass(AnalysisName + " - Analysis is created", "AnalysisIsCreated");
			ExtentTestManager.getTest().log(Status.PASS,AnalysisName +  " - Analysis is created");
		}
		catch(Exception ex) {
			throw ex;
		}
	}	


	//Create an Analysis with no Study Input
	public String createAnalysis2(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			this.clickAnalysisIcon(); 
			this.waitForAnalysisHub();
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
			String StudyNameSelected = this.SelectAStudy2(StudyIndex);
			ExtentTestManager.getTest().log(Status.PASS,"Study Name is set to '"+StudyNameSelected+"'");

			screenShotForPass("Analysis is filled with details", "AnalysisFilledWithDetails");

			Thread.sleep(2000);

			this.clickSave();   
			BasePage.waitforAnElement(analysisCreatedMessage);
			BasePage.waitforAnElement(StudyNode);


			String StudyNameInGraph = StudyNameInGrpahCanvas.getText();
			assertEquals(StudyNameInGraph, StudyNameSelected);
			ExtentTestManager.getTest().log(Status.PASS,StudyNameSelected +  " - is correct in Graph canvas title");

			mySelectionScreenOpen.click();
			String StudyNameInSelection = StudyNameInMySelection.getText();
			assertEquals(StudyNameInSelection, StudyNameSelected);
			ExtentTestManager.getTest().log(Status.PASS,StudyNameSelected +  " - is correct in Graph My Selection");

			screenShotForPass(AnalysisName + " - Analysis is created", "AnalysisIsCreated");
			ExtentTestManager.getTest().log(Status.PASS,AnalysisName +  " - Analysis is created");

			return StudyNameSelected;
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

	//Zoom in browser
	public void ZoomIn(int times) throws Throwable{
		try {		
			Actions zoomIn = new Actions(driver);
			for(int i=0; i<times ; i++) {
				zoomIn.sendKeys(Keys.CONTROL, Keys.ADD).perform();
			}
		}
		catch(Throwable ex) {
			throw ex;
		}
	}	

	//Zoom out browser
	public void ZoomOut(int times) throws Throwable{
		try {		
			Actions zoomout = new Actions(driver);
			for(int i=0; i<times ; i++) {
				zoomout.sendKeys(Keys.CONTROL, Keys.SUBTRACT).perform();
			}
		}
		catch(Throwable ex) {
			throw ex;
		}
	}	

	//Check mandatory fields in Analysis
	public void checkMandatoryfieldsinAnalysis(String AnalysisName, String AnalysisDescription, String StudyName) throws Throwable{
		try {
			this.clickAnalysisIcon();
			this.waitForAnalysisHub();
			this.ClickAddAnalysis(); 
			BasePage.verifyPage("Name", AnalysisNameCreate);
			this.SetNameForAnalysis(AnalysisName);								//Set Analysis Name
			BasePage.verifyPage("Description", AnalysisDescriptionCreate);
			this.SetDescForAnalysis(AnalysisDescription);						//Set Analysis Description
			BasePage.CompareAttributeText("data-is-focusable","false",saveButtonCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Save is not enabled since Study is not selected");

			screenShotForPass("Analysis is not saved because Study is not selected","AnalysisCannotBeSaved");

			this.removeTextInField(AnalysisNameText);							//Remove Analysis Name
			BasePage.verifyPage("Select a Study", AnalysisSelectStudyCreate);	
			this.SelectAStudy(StudyName);										//Set Analysis Study
			BasePage.CompareAttributeText("data-is-focusable","false",saveButtonCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Save is not enabled since Analysis Name is not present");

			screenShotForPass("Analysis is not saved because Analysis Name is not present","AnalysisCannotBeSaved");

			this.SetNameForAnalysis(AnalysisName);								//Type in Analysis Name
			this.removeTextInField(AnalysisDescriptionText);					//Remove Analysis Description
			BasePage.CompareAttributeText("data-is-focusable","false",saveButtonCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Save is not enabled since Analysis Description is not present");

			screenShotForPass("Analysis is not saved because Analysis Description is not selected","AnalysisCannotBeSaved");

			this.SetDescForAnalysis(AnalysisDescription);						//Set Analysis Description

			this.clickSave();   
			BasePage.waitforAnElement(analysisCreatedMessage);

			ExtentTestManager.getTest().log(Status.PASS,AnalysisName +  " - Analysis is created after mandatory check");
		}
		catch(Exception ex) {
			throw ex;
		}
	}	


	//Check mandatory fields in Analysis --> Using Study Index and not Study Name
	public void checkMandatoryfieldsinAnalysis2(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			this.clickAnalysisIcon();
			this.waitForAnalysisHub();
			this.ClickAddAnalysis(); 
			BasePage.verifyPage("Name", AnalysisNameCreate);
			this.SetNameForAnalysis(AnalysisName);								//Set Analysis Name
			BasePage.verifyPage("Description", AnalysisDescriptionCreate);
			this.SetDescForAnalysis(AnalysisDescription);						//Set Analysis Description
			BasePage.CompareAttributeText("data-is-focusable","false",saveButtonCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Save is not enabled since Study is not selected");

			screenShotForPass("Analysis is not saved because Study is not selected","AnalysisCannotBeSaved");

			this.removeTextInField(AnalysisNameText);							//Remove Analysis Name
			BasePage.verifyPage("Select a Study", AnalysisSelectStudyCreate);	
			String StudyName = this.SelectAStudy2(StudyIndex);					//Set Analysis Study
			BasePage.CompareAttributeText("data-is-focusable","false",saveButtonCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Save is not enabled since Analysis Name is not present");

			screenShotForPass("Analysis is not saved because Analysis Name is not present","AnalysisCannotBeSaved");

			this.SetNameForAnalysis(AnalysisName);								//Type in Analysis Name
			this.removeTextInField(AnalysisDescriptionText);					//Remove Analysis Description
			BasePage.CompareAttributeText("data-is-focusable","false",saveButtonCheck);
			ExtentTestManager.getTest().log(Status.PASS,"Save is not enabled since Analysis Description is not present");

			screenShotForPass("Analysis is not saved because Analysis Description is not selected","AnalysisCannotBeSaved");

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
	public void EditAnalysis(String AnalysisName, String AnalysisDescription) throws Throwable{
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
			this.waitForAnalysisHub();
			this.selectItemFortheList(AnalysisNameinital);

			this.EditAnalysis(AnalysisName, AnalysisDescription);
			this.clickCancel();
			BasePage.waitforAnElement(CancelConfirmationMessage);
			BasePage.waitforAnElement(WariningMessageforCancel);
			ExtentTestManager.getTest().log(Status.PASS,"Warning message is seen after cancel");
			BasePage.click(CancelButtonInConfirmationBox);

			screenShotForPass("Analysis is not modified because changes are cancelled","AnalysisCannotBeSaved");

			BasePage.click(dialogBoxClose);
			BasePage.waitforAnElement(CancelConfirmationMessage);
			BasePage.waitforAnElement(WariningMessageforCancel);
			ExtentTestManager.getTest().log(Status.PASS,"Warning message is seen after dialog box");
			BasePage.click(CancelButtonInConfirmationBox);

			screenShotForPass("Analysis is not modified because changes are cancelled","AnalysisCannotBeSaved");

			this.clickSave();
			BasePage.waitforAnElement(analysisupdateMessage);
			this.waitForAnalysisHub();
			screenShotForPass("Analysis is modified by changing the details in list page","AnalysisupdatedFromList");

			ExtentTestManager.getTest().log(Status.PASS, "'"+AnalysisName+"'" +  " - Analysis is updated");
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Create and Edit Analysis From list --> Selecting Study Name with index
	public void AnalysisNameAndDescEditInList2(String AnalysisNameinital, String AnalysisDescriptioninital, String StudyIndex,String AnalysisName, String AnalysisDescription) throws Throwable{
		try {		
			createAnalysis2(AnalysisNameinital,AnalysisDescriptioninital,StudyIndex);

			this.clickAnalysisIcon();
			this.waitForAnalysisHub();
			this.selectItemFortheList(AnalysisNameinital);

			this.EditAnalysis(AnalysisName, AnalysisDescription);
			this.clickCancel();
			BasePage.waitforAnElement(CancelConfirmationMessage);
			BasePage.waitforAnElement(WariningMessageforCancel);
			ExtentTestManager.getTest().log(Status.PASS,"Warning message is seen after cancel");
			BasePage.click(CancelButtonInConfirmationBox);

			screenShotForPass("Analysis is not modified because changes are cancelled","AnalysisCannotBeSaved");

			BasePage.click(dialogBoxClose);
			BasePage.waitforAnElement(CancelConfirmationMessage);
			BasePage.waitforAnElement(WariningMessageforCancel);
			ExtentTestManager.getTest().log(Status.PASS,"Warning message is seen after dialog box");
			BasePage.click(CancelButtonInConfirmationBox);

			screenShotForPass("Analysis is not modified because changes are cancelled","AnalysisCannotBeSaved");

			this.clickSave();
			BasePage.waitforAnElement(analysisupdateMessage);
			this.waitForAnalysisHub();
			screenShotForPass("Analysis is modified by changing the details in list page","AnalysisupdatedFromList");

			ExtentTestManager.getTest().log(Status.PASS, "'"+AnalysisName+"'" +  " - Analysis is updated");
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Create and Edit Analysis From Page
	public void AnalysisNameAndDescEditInPage(String AnalysisNameinital, String AnalysisDescriptioninital, String StudyName,String AnalysisName, String AnalysisDescriptionSmall, String AnalysisDescription) throws Throwable{
		try {

			createAnalysis(AnalysisNameinital,AnalysisDescriptioninital,StudyName);

			this.clickAnalysisIcon();
			this.waitForAnalysisHub();
			this.selectItemFortheList(AnalysisNameinital);
			this.clickView();

			WebElement anlaysisHeader = driver.findElement(By.xpath("//*[@type='text' and @value='"+AnalysisNameinital+"']"));

			BasePage.waitforAnElement(anlaysisHeader);
			this.removeTextInField(anlaysisHeader);
			anlaysisHeader.sendKeys(AnalysisName);	

			Actions action = new Actions(driver);
			action.moveToElement(analysisPageHeader,200,0).click().build().perform();

			BasePage.waitforAnElement(analysisupdateMessage);

			Thread.sleep(5000);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis name is updated from " +AnalysisNameinital + " to " +AnalysisName);
			screenShotForPass("Analysis name is updated from page","AnalysisNameUpdated");

			BasePage.click(DownButtonInAnalysisHeader);

			BasePage.click(AnalysisDescMoreButton);
			BasePage.waitforAnElement(AnalysisDescriptionDialogBoxHeader);
			this.removeTextInField(AnalysisLongDescTextbox);
			AnalysisLongDescTextbox.sendKeys(AnalysisDescriptionSmall);
			BasePage.click(AnalysisCreationCancel);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis Description is updated from " +AnalysisDescriptioninital + " to " +AnalysisDescriptionSmall);
			screenShotForPass("Analysis Description is not updated becuase changes are cancelled","AnalysisDescriptionCancel");

			BasePage.click(AnalysisDescMoreButton);
			BasePage.waitforAnElement(AnalysisDescriptionDialogBoxHeader);
			this.removeTextInField(AnalysisLongDescTextbox);
			AnalysisLongDescTextbox.sendKeys(AnalysisDescriptionSmall);
			BasePage.click(DoneButton);
			BasePage.waitforAnElement(analysisdescriptionupdateMessage);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis Description is updated from " +AnalysisDescriptioninital + " to " +AnalysisDescriptionSmall);
			screenShotForPass("Analysis Description is updated","AnalysisDescriptionUpdated");

			Thread.sleep(5000);

			BasePage.click(AnalysisDescriptionInPage);
			this.removeTextInField(AnalysisDescriptionInPage);
			BasePage.click(AnalysisDescriptionInPage);
			AnalysisDescriptionInPage.sendKeys(AnalysisDescription);	
			BasePage.click(AnalysisDescriptionTextInPage);
			BasePage.waitforAnElement(analysisdescriptionupdateMessage);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis Description is updated from '" +AnalysisDescriptionSmall + "' to '" + AnalysisDescription+ "'");
			screenShotForPass("Analysis Description is updated","AnalysisDescriptionUpdated2");

			Thread.sleep(5000);

			ExtentTestManager.getTest().log(Status.PASS, "'"+AnalysisNameinital+"'" +  " - Analysis is updated to " + AnalysisName);
		}
		catch(Exception ex) {
			throw ex;
		}
	}


	//Create and Edit Analysis From Page
	public void AnalysisNameAndDescEditInPage2(String AnalysisNameinital, String AnalysisDescriptioninital, String StudyIndex,String AnalysisName, String AnalysisDescriptionSmall, String AnalysisDescription) throws Throwable{
		try {

			createAnalysis2(AnalysisNameinital,AnalysisDescriptioninital,StudyIndex);

			this.clickAnalysisIcon();
			this.waitForAnalysisHub();
			this.selectItemFortheList(AnalysisNameinital);
			this.clickView();

			WebElement anlaysisHeader = driver.findElement(By.xpath("//*[@type='text' and @value='"+AnalysisNameinital+"']"));

			BasePage.waitforAnElement(anlaysisHeader);
			this.removeTextInField(anlaysisHeader);
			anlaysisHeader.sendKeys(AnalysisName);	

			Actions action = new Actions(driver);
			action.moveToElement(analysisPageHeader,200,0).click().build().perform();

			BasePage.waitforAnElement(analysisupdateMessage);

			Thread.sleep(5000);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis name is updated from " +AnalysisNameinital + " to " +AnalysisName);
			screenShotForPass("Analysis name is updated from page","AnalysisNameUpdated");

			BasePage.click(DownButtonInAnalysisHeader);

			BasePage.click(AnalysisDescMoreButton);
			BasePage.waitforAnElement(AnalysisDescriptionDialogBoxHeader);
			this.removeTextInField(AnalysisLongDescTextbox);
			AnalysisLongDescTextbox.sendKeys(AnalysisDescriptionSmall);
			BasePage.click(AnalysisCreationCancel);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis Description is updated from '" +AnalysisDescriptioninital + "' to '" +AnalysisDescriptionSmall+ "'");
			screenShotForPass("Analysis Description is not updated becuase changes are cancelled","AnalysisDescriptionCancel");

			BasePage.click(AnalysisDescMoreButton);
			BasePage.waitforAnElement(AnalysisDescriptionDialogBoxHeader);
			this.removeTextInField(AnalysisLongDescTextbox);
			AnalysisLongDescTextbox.sendKeys(AnalysisDescriptionSmall);
			BasePage.click(DoneButton);
			BasePage.waitforAnElement(analysisdescriptionupdateMessage);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis Description is updated from " +AnalysisDescriptioninital + " to " +AnalysisDescriptionSmall);
			screenShotForPass("Analysis Description is updated","AnalysisDescriptionUpdated");

			Thread.sleep(5000);

			BasePage.click(AnalysisDescriptionInPage);
			this.removeTextInField(AnalysisDescriptionInPage);
			BasePage.click(AnalysisDescriptionInPage);
			AnalysisDescriptionInPage.sendKeys(AnalysisDescription);	
			BasePage.click(AnalysisDescriptionTextInPage);
			BasePage.waitforAnElement(analysisdescriptionupdateMessage);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis Description is updated from " +AnalysisDescriptionSmall + " to " + AnalysisDescription);
			screenShotForPass("Analysis Description is updated","AnalysisDescriptionUpdated2");

			Thread.sleep(5000);

			ExtentTestManager.getTest().log(Status.PASS, "'"+AnalysisNameinital+"'" +  " - Analysis is updated to " + AnalysisName);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	//Verify a Graph Canvas in an analysis
	public void VerifyGraphCanvasInAnalysis(String AnalysisName, String AnalysisDescription, String StudyName,String NoOfEntities,List <String> EntityNames) throws Throwable{
		try {
			createAnalysis(AnalysisName,AnalysisDescription,StudyName);

			this.clickAnalysisIcon();
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(graphCanvas);
			BasePage.waitforAnElement(StudyNode);
			ExtentTestManager.getTest().log(Status.PASS, "Prescence of Graph canvas is verified");
			screenShotForPass("Graph is Present", "GraphCanvasPresent");

			for(int i=0;i<Integer.parseInt(NoOfEntities); i++) {
				WebElement entityNode = driver.findElement(By.xpath("//span[@role='presentation' and text()='"+EntityNames.get(i)+	"']//ancestor::div[contains(@class,CompactEntityNode) and @role='presentation']"));
				String entityNodeText = driver.findElement(By.xpath("//span[@role='presentation' and text()='"+EntityNames.get(i)+	"']")).getText();
				BasePage.waitforAnElement(entityNode);
				assertEquals(entityNodeText, EntityNames.get(i));
			}
			ExtentTestManager.getTest().log(Status.PASS, "Prescence of all the entities in Graph canvas is verified - " + EntityNames);
			screenShotForPass("All entities are present", "AllEntitiesArePresent");
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}


	//Verify a Graph Canvas in an analysis --> using Study Index instead of Study Name
	public void VerifyGraphCanvasInAnalysis2(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.clickAnalysisIcon();
			this.waitForAnalysisHub();
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(graphCanvas);
			BasePage.waitforAnElement(StudyNode);
			ExtentTestManager.getTest().log(Status.PASS, "Prescence of Graph canvas is verified");
			screenShotForPass("Graph is Present", "GraphCanvasPresent");

			int NoOfEntities = EntityListInGraph.size();
			List <String> EntityNamesActual = new ArrayList<String>(); 
			for (WebElement element : EntityListInGraph) { 				
				String EN = element.getText();
				EntityNamesActual.add(EN);
			}		

			ExtentTestManager.getTest().log(Status.PASS, "Prescence of all the entities in Graph canvas is verified - " +NoOfEntities+" entities are present and are - "  + EntityNamesActual);
			screenShotForPass("All entities are present", "AllEntitiesArePresent");
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void GraphCanvasCompactView() throws Throwable{
		BasePage.click(graphCanvasCompactView);
	}

	public void GraphCanvasCompactToRegularView(String StudyName) throws Throwable{
		WebElement CompactToRegularView = driver.findElement(By.xpath("//span[text()='"+StudyName.toUpperCase()+"']//ancestor::div[contains(@class,'react-flow__node-regularNodeView')]//i[@data-icon-name='FullScreen']"));
		BasePage.click(CompactToRegularView);
	}

	public void GraphCanvasExpandedView() throws Throwable{
		BasePage.click(graphCanvasExpandview);
	}

	public void GraphCanvasExpandedToRegularView(String StudyName) throws Throwable{
		BasePage.click(graphCanvasExpandtoRegularview);
	}

	//Verify Resizing of Graph Canvas in an analysis
	public void VerifyResizingOfGraphAnalysis(String AnalysisName, String AnalysisDescription, String StudyName) throws Throwable{
		try {
			createAnalysis(AnalysisName,AnalysisDescription,StudyName);

			this.clickAnalysisIcon();
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(graphCanvas);
			ExtentTestManager.getTest().log(Status.PASS, "Prescence of Graph canvas is verified");

			this.GraphCanvasCompactView();
			WebElement CompactViewCheck = driver.findElement(By.xpath("//span[text()='"+StudyName.toUpperCase()+"']//ancestor::div[contains(@class,'CompactNodeView__compactNodeView')]"));
			BasePage.waitforAnElement(CompactViewCheck);
			ExtentTestManager.getTest().log(Status.PASS, "Compact view of Graph is verified");
			screenShotForPass("Compact view of Graph", "CompactViewOfGraph");

			this.GraphCanvasCompactToRegularView(StudyName);
			BasePage.waitforAnElement(StudyNode);
			BasePage.waitforAnElement(graphCanvasRegularViewCheck);
			ExtentTestManager.getTest().log(Status.PASS, "Compact view to Regular view of Graph is verified");
			screenShotForPass("Compact to Regular view of Graph", "CompacttoRegularViewOfGraph");

			this.GraphCanvasExpandedView();
			BasePage.waitforAnElement(StudyNode);
			BasePage.waitforAnElement(graphCanvasExpandViewCheck);
			ExtentTestManager.getTest().log(Status.PASS, "Expanded view of Graph is verified");
			screenShotForPass("Expand view of Graph", "ExapandViewOfGraph");

			this.GraphCanvasExpandedToRegularView(StudyName);
			BasePage.waitforAnElement(StudyNode);
			BasePage.waitforAnElement(graphCanvasRegularViewCheck);
			ExtentTestManager.getTest().log(Status.PASS, "Expanded view to Regular view of Graph is verified");
			screenShotForPass("Expand to Regular view of Graph", "ExpandtoRegularViewOfGraph");
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	//Verify Resizing of Graph Canvas in an analysis
	public void VerifyResizingOfGraphAnalysis2(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			String StudyName = createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.clickAnalysisIcon();
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(graphCanvas);
			ExtentTestManager.getTest().log(Status.PASS, "Prescence of Graph canvas is verified");

			this.GraphCanvasCompactView();
			WebElement CompactViewCheck = driver.findElement(By.xpath("//span[text()='"+StudyName.toUpperCase()+"']//ancestor::div[contains(@class,'CompactNodeView__compactNodeView')]"));
			BasePage.waitforAnElement(CompactViewCheck);
			ExtentTestManager.getTest().log(Status.PASS, "Compact view of Graph is verified");
			screenShotForPass("Compact view of Graph", "CompactViewOfGraph");

			this.GraphCanvasCompactToRegularView(StudyName);
			BasePage.waitforAnElement(StudyNode);
			BasePage.waitforAnElement(graphCanvasRegularViewCheck);
			ExtentTestManager.getTest().log(Status.PASS, "Compact view to Regular view of Graph is verified");
			screenShotForPass("Compact to Regular view of Graph", "CompacttoRegularViewOfGraph");

			this.GraphCanvasExpandedView();
			BasePage.waitforAnElement(StudyNode);
			BasePage.waitforAnElement(graphCanvasExpandViewCheck);
			ExtentTestManager.getTest().log(Status.PASS, "Expanded view of Graph is verified");
			screenShotForPass("Expand view of Graph", "ExapandViewOfGraph");

			this.GraphCanvasExpandedToRegularView(StudyName);
			BasePage.waitforAnElement(StudyNode);
			BasePage.waitforAnElement(graphCanvasRegularViewCheck);
			ExtentTestManager.getTest().log(Status.PASS, "Expanded view to Regular view of Graph is verified");
			screenShotForPass("Expand to Regular view of Graph", "ExpandtoRegularViewOfGraph");
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	//Verify a numerical feature in an analysis
	public void VerifyNumericalValueAnalysis(String AnalysisName, String AnalysisDescription, String StudyName,String EntityValue, String NumericalFeatureValue) throws Throwable{
		try {
			createAnalysis(AnalysisName,AnalysisDescription,StudyName);

			this.clickAnalysisIcon();
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			WebElement entityselect = driver.findElement(By.xpath("//*[text()='"+EntityValue+"']"));
			BasePage.click(entityselect);

			ExtentTestManager.getTest().log(Status.PASS, "'"+EntityValue+"'" +  " - Entity is selected");
			screenShotForPass("Entity is selected", "EntitySelection");

			BasePage.click(mySelectionScreenClose);

			WebElement featureSelect = driver.findElement(By.xpath("//*[text()='"+NumericalFeatureValue+"']//preceding-sibling::input"));
			BasePage.click(featureSelect);

			ExtentTestManager.getTest().log(Status.PASS, "'"+NumericalFeatureValue+"'" +  " - Numerical feature is selected");
			screenShotForPass("Feature is selected", "FeatureSelection");


			WebElement summaryListButton = driver.findElement(By.xpath("//*[text()='"+NumericalFeatureValue+"']//parent::li//i[@data-icon-name='ChevronRight']"));
			BasePage.click(summaryListButton);

			BasePage.waitforAnElement(summaryText);
			BasePage.scrollIntoView(summaryText);

			ExtentTestManager.getTest().log(Status.PASS, "Summary Statistics page is dispalyed");
			screenShotForPass("Summary Statistics is dispalyed", "SummaryStatistics");

			int sizeOfElements = summaryListHeaders.size();
			ArrayList<String> listOfNames = new ArrayList<String>();
			for (int i=1; i<=sizeOfElements;i++) 
			{
				WebElement Listname = driver.findElement(By.xpath("(//div[contains(@class,'NumericalSummary')]//li)["+i+"]//span[1]"));
				String name = Listname.getText();
				listOfNames.add(name);
			}

			ExtentTestManager.getTest().log(Status.PASS, "Summary Statistics contains the lables - "+ listOfNames);

			BasePage.waitforAnElement(Rangetext);
			assertEquals(Rangetext.getText(),"RANGE");
			BasePage.waitforAnElement(MinimumValueText);
			assertTrue(MinimumValueText.getText().contains("Minimum value"));
			BasePage.waitforAnElement(MaximumValueText);
			assertTrue(MaximumValueText.getText().contains("Maximum value"));
			BasePage.waitforAnElement(EditMin);
			BasePage.waitforAnElement(EditMax);
			BasePage.waitforAnElement(CancelButton);
			BasePage.waitforAnElement(AddToMySelectionButton);	
			BasePage.waitforAnElement(BackButtonInCatagory);

			BasePage.click(BackButtonInCatagory);

			WebElement featureminimizeclose = driver.findElement(By.xpath("//*[text()='"+NumericalFeatureValue+"']//preceding::button//i[@data-icon-name='BackToWindow']"));
			BasePage.click(featureminimizeclose);
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	//Verify a categorical feature in an analysis
	public void VerifyCategoricalValueAnalysis(String AnalysisName, String AnalysisDescription, String StudyName,String EntityValue, String CategoricalFeatureValue) throws Throwable{
		try {
			createAnalysis(AnalysisName,AnalysisDescription,StudyName);

			this.clickAnalysisIcon();
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			//			BasePage.click(clickCircle);
			//			BasePage.click(visualizeData);

			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("document.body.style.zoom = '0.8'");

			WebElement entityselect = driver.findElement(By.xpath("//*[text()='"+EntityValue+"']"));
			BasePage.click(entityselect);

			ExtentTestManager.getTest().log(Status.PASS, "'"+EntityValue+"'" +  " - Entity is selected");
			screenShotForPass("Entity is selected", "EntitySelection");

			//			this.ZoomOut(3);

			WebElement featureSelect = driver.findElement(By.xpath("//*[text()='"+CategoricalFeatureValue+"']//preceding-sibling::input"));
			BasePage.click(featureSelect);

			ExtentTestManager.getTest().log(Status.PASS, "'"+CategoricalFeatureValue+"'" +  " - Categorical feature is selected");
			screenShotForPass("Feature is selected", "FeatureSelection");

			WebElement CategoryListButton = driver.findElement(By.xpath("//*[text()='"+CategoricalFeatureValue+"']//parent::li//i[@data-icon-name='ChevronRight']"));
			BasePage.click(CategoryListButton);

			assertEquals(CategoryAllButton.getText(),"ALL");

			ExtentTestManager.getTest().log(Status.PASS, "Categorical values are dispalyed");
			screenShotForPass("Categorical values are dispalyed", "CategoricalValues");

			int sizeOfElements = CategoryList.size();
			ArrayList<String> listOfNames = new ArrayList<String>();
			for (int i=1; i<=sizeOfElements;i++) 
			{
				WebElement Listname = driver.findElement(By.xpath("(//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')]//span)["+i+"]"));
				String name = Listname.getText();
				listOfNames.add(name);
			}

			ExtentTestManager.getTest().log(Status.PASS, "Categorical values are - "+ listOfNames);

			BasePage.waitforAnElement(CancelButton);
			BasePage.waitforAnElement(AddToMySelectionButton);	
			BasePage.waitforAnElement(BackButtonInCatagory);

			BasePage.click(BackButtonInCatagory);

			WebElement featureminimizeclose = driver.findElement(By.xpath("//*[text()='"+CategoricalFeatureValue+"']//preceding::button//i[@data-icon-name='BackToWindow']"));
			BasePage.click(featureminimizeclose);
		}
		catch(Exception | AssertionError ex) {
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
			ExtentTestManager.getTest().log(Status.PASS, "'"+AnalysisName+"'" +  " - Analysis is selected from list");

			this.DeleteAnalysis(AnalysisName);
			ExtentTestManager.getTest().log(Status.PASS, "'"+AnalysisName+"'" +  " - Analysis is deleted");
			screenShotForPass("Analysis is deleted", "AnalysisDeleted");
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Create and Delete Analysis From list --> with Study Index
	public void CreateAndDeleteAnalysis2(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.clickAnalysisIcon();
			this.waitForAnalysisHub();
			this.selectItemFortheList(AnalysisName);
			ExtentTestManager.getTest().log(Status.PASS, "'"+AnalysisName+"'" +  " - Analysis is selected from list");

			this.DeleteAnalysis(AnalysisName);
			ExtentTestManager.getTest().log(Status.PASS, "'"+AnalysisName+"'" +  " - Analysis is deleted");
			screenShotForPass("Analysis is deleted", "AnalysisDeleted");
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Select an entity - using index
	public String SelectAnEntity2(int EntityIndex) throws Throwable{
		try {
			WebElement entityselect = driver.findElement(By.xpath("//*[text()='"+EntityListInGraph.get(EntityIndex).getText()+"']"));
			String entityName = EntityListInGraph.get(EntityIndex).getText();
			BasePage.click(entityselect);
			return entityName;
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Select a feature - using index
	public String SelectAFeature2(int EntityIndex) throws Throwable{
		try {
			String featureName = FeatureListInGraph.get(EntityIndex).getText();
			WebElement featureSelect = FeatureListInGraphcheckbox.get(EntityIndex);
			BasePage.click(featureSelect);
			return featureName;
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Click to see the category list of a categorical feature
	public void CategoricalListOfCategoryFeature(String FeatureName) throws Throwable{
		try {
			WebElement CategoryListButton = driver.findElement(By.xpath("//*[text()='"+FeatureName+"']//parent::li//i[@data-icon-name='ChevronRight']"));
			BasePage.click(CategoryListButton);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Click to see the numerical list of a categorical feature
	public void SummaryListOfNumericalFeature(String FeatureName) throws Throwable{
		try {
			WebElement summaryListButton = driver.findElement(By.xpath("//*[text()='"+FeatureName+"']//parent::li//i[@data-icon-name='ChevronRight']"));
			BasePage.click(summaryListButton);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Click to printout the category list of a categorical feature
	public int printCategoryList() throws Throwable{
		try {
			int sizeOfElements = CategoryList.size();
			ArrayList<String> listOfNames = new ArrayList<String>();
			for (int i=1; i<=sizeOfElements;i++) 
			{
				WebElement Listname = driver.findElement(By.xpath("(//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')]//span)["+i+"]"));
				String name = Listname.getText();
				listOfNames.add(name);
			}
			ExtentTestManager.getTest().log(Status.PASS, "Categorical values are - "+ listOfNames);

			return sizeOfElements;
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Click to printout the Numerical label list of a numerical feature
	public void printNumericalLabelList() throws Throwable{
		int sizeOfElements = summaryListHeaders.size();
		ArrayList<String> listOfNames = new ArrayList<String>();
		try {
			for (int i=1; i<=sizeOfElements;i++) 
			{
				WebElement Listname = driver.findElement(By.xpath("(//div[contains(@class,'NumericalSummary')]//li)["+i+"]//span[1]"));
				String name = Listname.getText();
				listOfNames.add(name);
			}
			ExtentTestManager.getTest().log(Status.PASS, "Summary Statistics contains the lables - "+ listOfNames);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	


	//Select an entity
	public void SelectAnEntity(String EntityName) throws Throwable{
		try {
			WebElement entityselect = driver.findElement(By.xpath("//*[text()='"+EntityName+"']"));
			BasePage.click(entityselect);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Select a feature
	public void SelectAFeature(String FeatureName) throws Throwable{
		try {
			WebElement featureSelect = driver.findElement(By.xpath("//*[text()='"+FeatureName+"']//preceding-sibling::input"));
			BasePage.click(featureSelect);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Click to see the category list of a categorical feature
	public void CategoricalListOfCategoryFeature(String FeatureName) throws Throwable{
		try {
			WebElement CategoryListButton = driver.findElement(By.xpath("//*[text()='"+FeatureName+"']//parent::li//i[@data-icon-name='ChevronRight']"));
			BasePage.click(CategoryListButton);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Click to see the numerical list of a categorical feature
	public void SummaryListOfNumericalFeature(String FeatureName) throws Throwable{
		try {
			WebElement summaryListButton = driver.findElement(By.xpath("//*[text()='"+FeatureName+"']//parent::li//i[@data-icon-name='ChevronRight']"));
			BasePage.click(summaryListButton);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Click to printout the category list of a categorical feature
	public int printCategoryList() throws Throwable{
		try {
			int sizeOfElements = CategoryList.size();
			ArrayList<String> listOfNames = new ArrayList<String>();
			for (int i=1; i<=sizeOfElements;i++) 
			{
				WebElement Listname = driver.findElement(By.xpath("(//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')]//span)["+i+"]"));
				String name = Listname.getText();
				listOfNames.add(name);
			}
			ExtentTestManager.getTest().log(Status.PASS, "Categorical values are - "+ listOfNames);

			return sizeOfElements;
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Click to printout the Numerical label list of a numerical feature
	public void printNumericalLabelList() throws Throwable{
		int sizeOfElements = summaryListHeaders.size();
		ArrayList<String> listOfNames = new ArrayList<String>();
		try {
			for (int i=1; i<=sizeOfElements;i++) 
			{
				WebElement Listname = driver.findElement(By.xpath("(//div[contains(@class,'NumericalSummary')]//li)["+i+"]//span[1]"));
				String name = Listname.getText();
				listOfNames.add(name);
			}
			ExtentTestManager.getTest().log(Status.PASS, "Summary Statistics contains the lables - "+ listOfNames);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Get a Random value out of the range
	public int RandomValueGenerator(int MinValue, int MaxValue) throws Throwable{
		try {
			int Random = (MinValue) + (int)(Math.random()*( MaxValue - MinValue + 1));
			return Random;
		}
		catch(Exception ex) {
			throw ex;
		}
	}	


	//Verify selection of Categorical And Numerical features
	public void SelectCategoricalAndNumericalFeatures(String AnalysisName, String AnalysisDescription, String StudyName,String NoOfEntityPairs, String Entity1, String Feature1, String Entity2, String Feature2) throws Throwable{
		try {

			//			String AnalysisName, String AnalysisDescription, String StudyName,String EntityValue, String CategoricalFeatureValue

			createAnalysis(AnalysisName,AnalysisDescription,StudyName);

			this.clickAnalysisIcon();
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			this.SelectAnEntity(Entity1);
			BasePage.click(mySelectionScreenClose);
			ExtentTestManager.getTest().log(Status.PASS, "'"+Entity1+"'" +  " - Entity is selected");
			screenShotForPass("Entity is selected", "EntitySelection");

			this.SelectAFeature(Feature1);
			ExtentTestManager.getTest().log(Status.PASS, "'"+Feature1+"'" +  " - Categorical feature is selected");
			screenShotForPass("Feature is selected", "FeatureSelection");

			this.CategoricalListOfCategoryFeature(Feature1);

			assertEquals(CategoryAllButton.getText(),"ALL");

			ExtentTestManager.getTest().log(Status.PASS, "Categorical values are dispalyed");
			screenShotForPass("Categorical values are dispalyed", "CategoricalValues");

			this.printCategoryList();

			int sizeCategory = this.printCategoryList();
			if (sizeCategory>2) {
				for (int i=1; i<=2;i++) 
				{
					WebElement Categories = driver.findElement(By.xpath("((//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')]//span)//parent::div//parent::div//input[@type='checkbox'])["+i+"]"));
					BasePage.click(Categories);
				}
			}
			else{
				WebElement Categories = driver.findElement(By.xpath("((//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')]//span)//parent::div//parent::div//input[@type='checkbox'])[1]"));
				BasePage.click(Categories);
			}

			BasePage.waitforAnElement(CancelButton);
			BasePage.waitforAnElement(AddToMySelectionButton);	

			BasePage.click(AddToMySelectionButton);

			Thread.sleep(5000);


			this.SelectAnEntity(Entity2);
			BasePage.click(mySelectionScreenClose);
			ExtentTestManager.getTest().log(Status.PASS, "'"+Entity2+"'" +  " - Entity is selected");
			screenShotForPass("Entity is selected", "EntitySelection");

			this.SelectAFeature(Feature2);
			ExtentTestManager.getTest().log(Status.PASS, "'"+Feature2+"'" +  " - Categorical feature is selected");
			screenShotForPass("Feature is selected", "FeatureSelection");

			this.SummaryListOfNumericalFeature(Feature2);

			BasePage.waitforAnElement(summaryText);

			ExtentTestManager.getTest().log(Status.PASS, "Summary Statistics page is dispalyed");
			screenShotForPass("Summary Statistics is dispalyed", "SummaryStatistics");

			this.printNumericalLabelList();

			double min = Double.valueOf(EditMin.getAttribute("value"));
			System.out.println(min);
			double max = Double.valueOf(EditMax.getAttribute("value"));
			System.out.println(max);

			double difference = max-min;
			System.out.println(difference);

			double new_min = (0.25*difference);
			System.out.println(new_min);
			double new_max = (0.75*difference);
			System.out.println(new_max);

			BasePage.click(EditMin);
			EditMin.sendKeys(String.valueOf(new_min));

			BasePage.click(EditMax);
			EditMin.sendKeys(String.valueOf(new_max));

			BasePage.waitforAnElement(Rangetext);
			assertEquals(Rangetext.getText(),"RANGE");
			BasePage.waitforAnElement(MinimumValueText);
			assertTrue(MinimumValueText.getText().contains("Minimum value"));
			BasePage.waitforAnElement(MaximumValueText);
			assertTrue(MaximumValueText.getText().contains("Maximum value"));
			BasePage.waitforAnElement(EditMin);
			BasePage.waitforAnElement(EditMax);
			BasePage.waitforAnElement(CancelButton);
			BasePage.waitforAnElement(AddToMySelectionButton);	
			BasePage.click(AddToMySelectionButton);
			BasePage.waitforAnElement(BackButtonInCatagory);

			BasePage.click(BackButtonInCatagory);

			WebElement featureminimizeclose2 = driver.findElement(By.xpath("//*[text()='"+Feature2+"']//preceding::button//i[@data-icon-name='BackToWindow']"));
			BasePage.click(featureminimizeclose2);
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	//Get the Entity names from the names
	public List<String> EntityNames() throws Throwable{
		try {
			int NoOfEntities = EntityListInGraph.size();
			List <String> EntityNames = new ArrayList<String>();
			for(int i=0; i<NoOfEntities;i++) {
				EntityNames.add(EntityListInGraph.get(i).getText());
			}
			return EntityNames;
		}
		catch(Exception ex) {
			throw ex;
		}
	}	

	//Get the Feature names from the entity names
	public void FeatureNames() throws Throwable{
		try {
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);
//			List <String> EN1Cat = new ArrayList<String>();
//			List <String> EN1Num = new ArrayList<String>();
			for(int EntiNo=1; EntiNo<=NoOfEntities;EntiNo++) 
			{
				System.out.println(NoOfEntities);
				String EntityName = EntityListInGraph.get(EntiNo).getText();
				System.out.println(EntityName);
				BasePage.click(EntityListInGraph.get(EntiNo));
				BasePage.click(mySelectionScreenClose);	
				Thread.sleep(2000);
				for (int FeaNo=0; FeaNo<FeatureListExceptAll.size();FeaNo++) {
					String FeatureName = FeatureListExceptAll.get(FeaNo).getText();
					System.out.println(FeatureName);
//					Thread.sleep(5000);
				}	
				BasePage.click(EntityClose);
				Thread.sleep(5000);
			}
			//			for(eavcWebElements:EntityListInGraph) 
			//			for(int i=1; i<NoOfEntities;i++) 
			//			{
			//				String EntityName = EntityListInGraph.get(i).getText();
			//				System.out.println(EntityName);
			//				BasePage.click(EntityListInGraph.get(i));
			//					
			//				Thread.sleep(2000);
			//								
			//				BasePage.click(mySelectionScreenClose);				
			//				try {
			//					for(i=0;i<CategoricalFeatures.size();i++) 
			//					{
			//						EN1Cat.add(CategoricalFeatures.get(i).getText());
			//						System.out.println(CategoricalFeatures.get(i).getText());
			//					}
			//				}
			//				catch(Exception NoCatValues){
			//					try
			//					{
			//						for(i=0;i<=NumericalFeatures.size();i++) 
			//						{
			//							EN1Num.add(NumericalFeatures.get(i).getText());
			//						}
			//					}
			//					catch(Exception NoValues) {
			//						BasePage.click(EntityClose);
			//						Thread.sleep(5000);
			//						throw NoValues;
			//					}
			//				}
			//			}
			//			BasePage.click(EntityClose);
			//			System.out.println(EN1Cat);
			//			System.out.println(EN1Num);
			//			Thread.sleep(5000);
		}
		catch(Exception ex) {
			throw ex;
		}
	}	


	//Verify selection of Categorical And Numerical features
	public void SelectFeatures(String AnalysisName, String AnalysisDescription, String StudyIndex,String NoOfEntityPairs) throws Throwable{
		try {
			String StudyName = createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.clickAnalysisIcon();
			this.waitForAnalysisHub();
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);

			List <String> EntityNames = this.EntityNames();
			System.out.println(EntityNames);
			this.FeatureNames();

		}
		catch(Exception | AssertionError ex) {
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

	public void screenShotForPass(String PassMessage,String screenShotName) throws IOException, InterruptedException
	{
		captureScreenshot(screenShotName);
		ExtentTestManager.getTest().log(Status.PASS, "Screenshot Captured : "+PassMessage);
		//		ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir") + "./Resources/ErrorScreenshots/"+screenShotName+".png");
		ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir")+"/Resources/ErrorScreenshots/"+screenShotName+".png");
	}


}
