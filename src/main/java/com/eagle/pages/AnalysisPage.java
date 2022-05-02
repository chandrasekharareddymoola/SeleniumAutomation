package com.eagle.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.logging.log4j.core.pattern.EqualsIgnoreCaseReplacementConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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

	@FindBy(xpath = "//*[@data-icon-name='BarChart4' and @role='presentation']")
	public WebElement visualizeDataIcon;

	@FindBy(xpath = "//div[contains(@class,'NumericalSummary')]//div//span[text()='SUMMARY']")
	public WebElement summaryText;

	@FindBy(xpath = "(//div[contains(@class,'NumericalSummary')]//li)//span[1]")
	public List<WebElement> summaryListHeaders;

	@FindBy(xpath = "//div[contains(@class,'NumericalSummary')]//span[1]")
	public List<WebElement> summaryListHeadersInPlot;

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

	@FindBy(xpath = "(//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')])//span")
	public List <WebElement> ListInMeasurement;

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

	@FindBy(xpath = "//li/button")
	public List <WebElement> FeatureListExceptAllNew;

	//	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Categorical']")
	//	public List <WebElement> CategoricalFeatures;
	//
	//	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Categorical']//preceding-sibling::input")
	//	public List <WebElement> CategoricalFeaturesFromValue;
	//
	//	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Categorical']")
	//	public WebElement CategoricalFeature;
	//
	//	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Numeric']")
	//	public List <WebElement> NumericalFeatures;
	//
	//	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Numeric']//preceding-sibling::input")
	//	public List <WebElement> NumericalFeaturesFromValue;
	//
	//	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='Numeric']")
	//	public WebElement NumericalFeature;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='categorical']")
	public List <WebElement> CategoricalFeatures;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='categorical']//preceding-sibling::input")
	public List <WebElement> CategoricalFeaturesFromValue;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='categorical']")
	public WebElement CategoricalFeature;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='numeric']")
	public List <WebElement> NumericalFeatures;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='numeric']//preceding-sibling::input")
	public List <WebElement> NumericalFeaturesFromValue;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList')]//button[@class='numeric']")
	public WebElement NumericalFeature;

	@FindBy(xpath = "//div[contains(@class,'item_title')]")
	public List <WebElement> FeatureNamesInMySelection;

	@FindBy(xpath = "//input[@type='checkbox']//following-sibling::button[@type='button']")
	public List <WebElement> FeatureListInOrganism;

	@FindBy(xpath = "//i[@data-icon-name='BackToWindow' and @role='presentation']")
	public WebElement EntityClose;

	@FindBy(xpath = "//input[@type='checkbox']//following-sibling::button")
	public WebElement FeatureValues;

	@FindBy(xpath = "//span[text()='Get Data']")
	public WebElement GetDataButton;

	@FindBy(xpath = "//*[text()='Dataframe']")
	public WebElement Dataframe;

	@FindBy(xpath = "//div[@id='EmptyPlot']//div[@id='dragArea']")
	public WebElement EmptyPlotDragArea;

	@FindBy(xpath = "(//div[contains(@class,'RegularNodeView__stickyPlotTitle')])[last()]")
	public WebElement PlotHeader;

	@FindBy(xpath = "(//*[@class='xtitle'])[last()]")
	public WebElement XaxisLabel;

	@FindBy(xpath = "(//*[@class='x2title'])[last()]")
	public WebElement X2axisLabel;

	@FindBy(xpath = "(//*[@class='x3title'])[last()]")
	public WebElement X3axisLabel;

	@FindBy(xpath = "(//*[@class='ytitle'])[last()]")
	public WebElement YaxisLabel;

	@FindBy(xpath = "(//*[@class='y2title'])[last()]")
	public WebElement Y2axisLabel;

	@FindBy(xpath = "(//*[@class='y3title'])[last()]")
	public WebElement Y3axisLabel;

	@FindBy(xpath = "(//div[contains(@class,'PlotSelector')]//select)[last()]")
	public WebElement PlotDropDownSelect;

	@FindBy(xpath = "//*[text()='ALL']//preceding-sibling::input")
	public WebElement AllButton;

	@FindBy(xpath = "//span[text()='Apply']")
	public WebElement ApplyButton;

	@FindBy(xpath = "//div[contains(@class,'selected_filters')]//div[contains(@class,'selection_item')]/div[contains(@class,'item_title')]")
	public List <WebElement> ValuesInMySelection;

	@FindBy(xpath = "//div[contains(@class,'selected_filters')]//div[contains(@class,'selection_item')]/div[contains(@class,'item_title') and contains(@class,'Categorical')]//*[text()='Organism']//parent::div//input")
	public WebElement ValuesInMySelectionOrganism;

	@FindBy(xpath = "//div[contains(@class,'selected_filters')]//div[contains(@class,'selection_item')]/div[contains(@class,'item_title') and contains(@class,'Categorical')]//*[contains(text(),'Measurement')]//parent::div//input")
	public WebElement ValuesInMySelectionMeasurement;

	@FindBy(xpath = "//i[@data-icon-name='SortDown']")
	public WebElement dataframeMinimizeButton;

	@FindBy(xpath = "//table//th")
	public List <WebElement> ColumnHeadersOfDataFrame;

	@FindBy(xpath = "//div[@role='tablist']")
	public WebElement dataframeTabListViewHeader;

	@FindBy(xpath = "//i[@data-icon-name='BulletedList2']")
	public WebElement dataframeListViewButton;

	@FindBy(xpath = "//button[@role='tab' and @data-content ='All']")
	public WebElement dataframeAllFeaturestab;


	@FindBy(xpath = "//button[@role='tab' and @data-content ='Categorical Features']")
	public WebElement dataframeCategoricalFeaturestab;

	@FindBy(xpath = "//button[@role='tab' and @data-content ='Categorical Features' and @aria-selected='false']")
	public WebElement dataframeCategoricalFeaturestabUnselected;

	@FindBy(xpath = "//button[@role='tab' and @data-content ='Categorical Features' and @aria-selected='true']")
	public WebElement dataframeCategoricalFeaturestabSelected;

	@FindBy(xpath = "//button[@role='tab' and @data-content ='Numerical Features']")
	public WebElement dataframeNumericalFeaturestab;

	@FindBy(xpath = "//button[@role='tab' and @data-content ='Numerical Features' and @aria-selected='false']")
	public WebElement dataframeNumericalFeaturestabUnselected;

	@FindBy(xpath = "//button[@role='tab' and @data-content ='Numerical Features' and @aria-selected='true']")
	public WebElement dataframeNumericalFeaturestabSelected;

	@FindBy(xpath = "//span[@draggable='true']")
	public List <WebElement> valuesInDataframeInListview;

	@FindBy(xpath = "//div[contains(@class,'FeaturesList__featuresListHeader')]")
	public WebElement OpenedEntityHeaderInGraphExceptOrganism;

	@FindBy(xpath = "//div[contains(@class,'OrganismSummary__featuresListHeader')]")
	public WebElement OpenedEntityHeaderInGraphForOrganism;

	@FindBy(xpath = "//*[text()='Terms of Use']")
	public WebElement TermsOfUse;

	@FindBy(xpath = "//*[contains(@class,'NodeTitle') and text()='GRAPH']")
	public WebElement GraphHeader;



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


	Actions action = new Actions(driver);


	//Methods

	public AnalysisPage() throws InterruptedException, AWTException{ 		 
		PageFactory.initElements(driver, this); 
		driver.navigate().refresh();
		BasePage.click(AnalysisIcon);
		action.moveToElement(TermsOfUse).perform();
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
			Thread.sleep(2000);
			String StudyNameInSelection = StudyNameInMySelection.getText();
			assertEquals(StudyNameInSelection, StudyNameSelected);
			ExtentTestManager.getTest().log(Status.PASS,StudyNameSelected +  " - is correct in Graph My Selection");

			screenShotForPass(AnalysisName + " - Analysis is created", "AnalysisIsCreated");			

			this.clickAnalysisIcon();
			this.waitForAnalysisHub();
			String AnalysisNameInList = AnaGridItems.get(0).getText();
			assertEquals(AnalysisNameInList, AnalysisName);

			screenShotForPass(AnalysisName + " - Analysis is Verified in List Screenshot", "Analysis Verified in List");

			ExtentTestManager.getTest().log(Status.PASS,AnalysisName +  " - Analysis is Verified that it is present in List page");

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
			Thread.sleep(1000);
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

			this.selectItemFortheList(AnalysisNameinital);
			this.clickView();

			WebElement anlaysisHeader = driver.findElement(By.xpath("//*[@type='text' and @value='"+AnalysisNameinital+"']"));

			BasePage.waitforAnElement(anlaysisHeader);
			this.removeTextInField(anlaysisHeader);
			anlaysisHeader.sendKeys(AnalysisName);	

			//			Actions action = new Actions(driver);
			//			action.moveToElement(analysisPageHeader,200,0).click().build().perform();

			BasePage.click(GraphHeader);
			BasePage.waitforAnElement(analysisupdateMessage);

			Thread.sleep(2000);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis name is updated from " +AnalysisNameinital + " to " +AnalysisName);
			screenShotForPass("Analysis name is updated from page","AnalysisNameUpdated");

			BasePage.click(DownButtonInAnalysisHeader);

			Thread.sleep(2000);

			BasePage.click(AnalysisDescMoreButton);
			BasePage.waitforAnElement(AnalysisDescriptionDialogBoxHeader);
			this.removeTextInField(AnalysisLongDescTextbox);
			AnalysisLongDescTextbox.sendKeys(AnalysisDescriptionSmall);
			BasePage.click(AnalysisCreationCancel);

			ExtentTestManager.getTest().log(Status.PASS,"Analysis Description is updated from '" +AnalysisDescriptioninital + "' to '" +AnalysisDescriptionSmall+ "'");
			screenShotForPass("Analysis Description is not updated becuase changes are cancelled","AnalysisDescriptionCancel");

			Thread.sleep(2000);
			
			BasePage.click(AnalysisDescMoreButton);
			BasePage.waitforAnElement(AnalysisDescriptionDialogBoxHeader);
			this.removeTextInField(AnalysisLongDescTextbox);
			AnalysisLongDescTextbox.sendKeys(AnalysisDescriptionSmall);
			BasePage.click(DoneButton);
			Thread.sleep(1000);
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

	//	//Click to see the category list of a categorical feature
	//	public void CategoricalListOfCategoryFeature(String FeatureName) throws Throwable{
	//		try {
	//			WebElement CategoryListButton = driver.findElement(By.xpath("//*[text()='"+FeatureName+"']//parent::li//i[@data-icon-name='ChevronRight']"));
	//			BasePage.click(CategoryListButton);
	//		}
	//		catch(Exception ex) {
	//			throw ex;
	//		}
	//	}	

	//	//Click to see the numerical list of a categorical feature
	//	public void SummaryListOfNumericalFeature(String FeatureName) throws Throwable{
	//		try {
	//			WebElement summaryListButton = driver.findElement(By.xpath("//*[text()='"+FeatureName+"']//parent::li//i[@data-icon-name='ChevronRight']"));
	//			BasePage.click(summaryListButton);
	//		}
	//		catch(Exception ex) {
	//			throw ex;
	//		}
	//	}	
	//
	//	//Click to printout the category list of a categorical feature
	//	public int printCategoryList() throws Throwable{
	//		try {
	//			int sizeOfElements = CategoryList.size();
	//			ArrayList<String> listOfNames = new ArrayList<String>();
	//			for (int i=1; i<=sizeOfElements;i++) 
	//			{
	//				WebElement Listname = driver.findElement(By.xpath("(//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')]//span)["+i+"]"));
	//				String name = Listname.getText();
	//				listOfNames.add(name);
	//			}
	//			ExtentTestManager.getTest().log(Status.PASS, "Categorical values are - "+ listOfNames);
	//
	//			return sizeOfElements;
	//		}
	//		catch(Exception ex) {
	//			throw ex;
	//		}
	//	}	
	//
	//	//Click to printout the Numerical label list of a numerical feature
	//	public void printNumericalLabelList() throws Throwable{
	//		int sizeOfElements = summaryListHeaders.size();
	//		ArrayList<String> listOfNames = new ArrayList<String>();
	//		try {
	//			for (int i=1; i<=sizeOfElements;i++) 
	//			{
	//				WebElement Listname = driver.findElement(By.xpath("(//div[contains(@class,'NumericalSummary')]//li)["+i+"]//span[1]"));
	//				String name = Listname.getText();
	//				listOfNames.add(name);
	//			}
	//			ExtentTestManager.getTest().log(Status.PASS, "Summary Statistics contains the lables - "+ listOfNames);
	//		}
	//		catch(Exception ex) {
	//			throw ex;
	//		}
	//	}	

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
	public HashMap<String, List<String>> FeatureNames() throws Throwable{
		try {
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);
			HashMap<String, List<String>> EntFeaName = new HashMap<String, List<String>>();

			//			Robot robot = new Robot();

			//			for (WebElement EntNo : EntityListInGraph) 	
			for(int EntiNo=1; EntiNo<=NoOfEntities;EntiNo++) 
			{
				List <String> EN1CatName = new ArrayList<String>();
				List <String> EN1NumName = new ArrayList<String>();
				String EntityName = EntityListInGraph.get(EntiNo).getText();
				System.out.println(EntityName);
				BasePage.click(EntityListInGraph.get(EntiNo));

				BasePage.click(mySelectionScreenClose);	
				Thread.sleep(5000);

				//				String EntityName = EntNo.getText();
				//				System.out.println(EntityName);
				//				BasePage.click(EntNo);
				//				BasePage.click(mySelectionScreenClose);	
				//				Thread.sleep(5000);

				//				for (WebElement FeaNo : FeatureListExceptAll) {
				FeatureListExceptAllNew.stream().skip(1);

				for (WebElement FeaNo : FeatureListExceptAllNew) {	
					System.out.println(FeaNo.getText());
					//					System.out.println(FeaNo.getAttribute("class"));
					if(FeaNo.getAttribute("class").equals("Categorical")) {
						String CatFeateName = FeaNo.getText();
						EN1CatName.add(CatFeateName);
						System.out.println("Categorical Feature: " + CatFeateName);
					}
					else if (FeaNo.getAttribute("class").equals("Numeric")) {
						String NumFeatName = FeaNo.getText();
						EN1NumName.add(NumFeatName);
						System.out.println("Numerical Feature: " + NumFeatName);
					}
				}	
				EntFeaName.put(EntityName+"Cat", EN1CatName);
				EntFeaName.put(EntityName+"Nam", EN1NumName);

				System.out.println(EN1CatName);
				System.out.println(EN1NumName);

				BasePage.click(EntityClose);
				System.out.println("Entity features are :" + EntFeaName);

				//				EN1CatName.clear();
				//				EN1NumName.clear();

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

			return EntFeaName;
		}
		catch(Exception ex) {
			throw ex;
		}
	}	


	//Verify selection of Categorical And Numerical features
	public void GetEntityAndFeatureNames(String AnalysisName, String AnalysisDescription, String StudyIndex,String NoOfEntityPairs) throws Throwable{
		try {
			String StudyName = createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);

			List <String> EntityNames = this.EntityNames();
			System.out.println(EntityNames);

			HashMap<String, List<String>> EntName = this.FeatureNames();
			EntName.get("S");

		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void EntitySelect(String Entity) throws InterruptedException, AWTException {
		try {
			WebElement entityselect = driver.findElement(By.xpath("//*[text()='"+Entity+"']"));
			BasePage.click(entityselect);
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void FeatureSelect(String Feature) throws Throwable {
		try	{
			//			WebElement featureSelect = driver.findElement(By.xpath(("//input[@value='"+Feature+"']")));
			WebElement featureSelect = driver.findElement(By.xpath(("//*[text()='"+Feature+"']//preceding-sibling::input")));
			BasePage.click(featureSelect);
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void CloseThePanelinGraphFromCategoryList(String Category) throws Throwable {
		try	{
			WebElement EntityClose = driver.findElement(By.xpath("//*[text()='"+Category+"']//preceding::button//i[@data-icon-name='BackToWindow']"));
			BasePage.click(EntityClose);
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void WaitforValueInMySelectionFilter(String Category) throws Throwable {
		try	{
			WebElement ValueInFilter = driver.findElement(By.xpath("//*[contains(@class,'selected_filters')]//*[text()='"+Category+"']"));
			BasePage.click(ValueInFilter);
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void DragAndDropBlank(String FeatureName) throws Throwable {
		try	{
			WebElement fromElement = driver.findElement(By.xpath("(//span[@id='"+FeatureName+"'])[1]"));
			WebElement toElement = driver.findElement(By.xpath("(//*[@id='dragArea'])[2]"));

			dragAndDrop(fromElement,toElement);
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void DragAndDropBlankNew(WebElement FeatureName) throws Throwable {
		try	{
			WebElement fromElement = FeatureName;
			WebElement toElement = driver.findElement(By.xpath("(//*[@id='dragArea'])[2]"));

			dragAndDrop(fromElement,toElement);
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void DragAndDropValuePresent(String FeatureName) throws Throwable {
		try	{
			WebElement fromElement = driver.findElement(By.xpath("(//span[@id='"+FeatureName+"'])[1]"));
			WebElement toElement = driver.findElement(By.xpath("//*[@class='plot-container plotly']"));

			dragAndDrop(fromElement,toElement);
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void DragAndDropValuePresentNew(WebElement FeatureName) throws Throwable {
		try	{
			WebElement fromElement = FeatureName;
			WebElement toElement = driver.findElement(By.xpath("//*[@class='plot-container plotly']"));

			dragAndDrop(fromElement,toElement);
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void SelectPlotType(String PlotType) throws InterruptedException, AWTException {
		BasePage.click(PlotDropDownSelect);
		Thread.sleep(1000);
		WebElement plotType = driver.findElement(By.xpath("//div[contains(@class,'PlotSelector')]//select//option[text()='"+PlotType+"']"));
		BasePage.click(plotType);	
	}

	public int GetHeader(String HeadetText) throws Throwable {
		int h=0;
		try	{		
			String headerText = PlotHeader.getText();
			assertEquals(headerText, HeadetText);
			h++;
		}
		catch(Throwable ex) {
			ExtentTestManager.getTest().log(Status.FAIL, "There is some problem with the label -" + ex);
		}
		return h;
	}


	public int GetHeaderXandY(String HeadetText, String XAxisLabel, String YAxisLabel) throws Throwable {
		int h=0;
		int k=0;

		try	{
			String headerText = PlotHeader.getText();
			assertEquals(headerText, HeadetText);
			h++;

			String xaxisLabel = XaxisLabel.getText();
			assertEquals(xaxisLabel, XAxisLabel);
			h++;

			String yaxisLabel = YaxisLabel.getText();
			assertEquals(yaxisLabel, YAxisLabel);
			h++;

			if(h==3) {
				k=1;
			}
		}
		catch(Throwable ex) {
			ExtentTestManager.getTest().log(Status.FAIL, "There is some problem with the label -" + ex);
		}
		return k;
	}

	public int GetHeaderY(String HeadetText, String YAxisLabel) throws Throwable {
		int h=0;
		int k=0;

		try	{
			String headerText = PlotHeader.getText();
			assertEquals(headerText, HeadetText);
			h++;

			String yaxisLabel = YaxisLabel.getText();
			assertEquals(yaxisLabel, YAxisLabel);
			h++;

			if(h==2) {
				k=1;
			}
		}
		catch(Throwable ex) {
			ExtentTestManager.getTest().log(Status.FAIL, "There is some problem with the label -" + ex);
		}
		return k;
	}

	public int GetHeaderX3andY3(String HeadetText, String XAxisLabel,String X2AxisLabel,String X3AxisLabel,String YAxisLabel,String Y2AxisLabel,String Y3AxisLabel) throws Throwable {
		int h=0;
		int k=0;

		try	{
			String headerText = PlotHeader.getText();
			assertEquals(headerText, HeadetText);
			h++;

			String xaxisLabel = XaxisLabel.getText();
			assertEquals(xaxisLabel, XAxisLabel);
			h++;

			String x2axisLabel = X2axisLabel.getText();
			assertEquals(x2axisLabel, X2AxisLabel);
			h++;

			String x3axisLabel = X3axisLabel.getText();
			assertEquals(x3axisLabel, X3AxisLabel);
			h++;

			String yaxisLabel = YaxisLabel.getText();
			assertEquals(yaxisLabel, YAxisLabel);
			h++;

			String y2axisLabel = Y2axisLabel.getText();
			assertEquals(y2axisLabel, Y2AxisLabel);
			h++;

			String y3axisLabel = Y3axisLabel.getText();
			assertEquals(y3axisLabel, Y3AxisLabel);
			h++;

			if(h==7) {
				k=1;
			}
		}
		catch(Throwable ex) {
			ExtentTestManager.getTest().log(Status.FAIL, "There is some problem with the label -" + ex);
		}
		return k;
	}

	public void createPlot() throws Throwable {
		try	{
			BasePage.click(clickCircle);
			BasePage.waitforAnElement(visualizeData);
			//			BasePage.click(visualizeData);
			BasePage.click(visualizeDataIcon);


		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void SelectingValuesForPlotOld() throws Throwable {
		try	{
			int CatAct = 3;
			int NumAct = 3;
			int CatSize = 0;
			int NumSize = 0;

			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);
			HashMap<String, List<String>> EntFeaName = new HashMap<String, List<String>>();

			for(int EntiNo=1; EntiNo<NoOfEntities;EntiNo++) 
			{
				List <String> EN1CatName = new ArrayList<String>();
				List <String> EN1NumName = new ArrayList<String>();
				String EntityName = EntityListInGraph.get(EntiNo).getText();
				System.out.println(EntityName);
				System.out.println(EntiNo);
				BasePage.click(EntityListInGraph.get(EntiNo));

				BasePage.click(mySelectionScreenClose);	
				Thread.sleep(5000);

				switch (EntityName) {

				case "Measurement":
					Test:						
						for (WebElement FeaNo : FeatureListExceptAllNew) {	
							Thread.sleep(3000);
							String NumFeatName = FeaNo.getText();	
							Thread.sleep(3000);
							EN1NumName.add(NumFeatName);
							NumSize = EN1NumName.size();
							System.out.println("Numerical Feature: " + NumFeatName);
							System.out.println("Numerical Feature Size: " + NumSize);

							System.out.println("NumAct: " + NumAct);
							System.out.println("NumSize: " + NumSize);

							if(!(NumAct<=0) && NumSize>=3) {
								BasePage.click(FeaNo);
								//								WebElement AllButton = driver.findElement(By.xpath("//*[text()='ALL']//preceding-sibling::input"));
								BasePage.click(AllButton);

								//								WebElement AddtoMySelection = driver.findElement(By.xpath("//span[text()='Add to my selection']"));
								BasePage.click(AddToMySelectionButton);
								NumAct=NumAct-NumSize;
								break Test;
							}
							WebElement EntityClose = driver.findElement(By.xpath("//i[@data-icon-name='BackToWindow' and @role='presentation']"));	
							BasePage.click(EntityClose);
						}
					break;


				default:

					for (WebElement FeaNo : FeatureListExceptAllNew) {	
						if(FeaNo.getAttribute("class").equals("Categorical")) {
							String CatFeateName = FeaNo.getText();
							EN1CatName.add(CatFeateName);
							CatSize = EN1CatName.size();
							System.out.println("Categorical Feature: " + CatFeateName);
							System.out.println("Categorical Feature Size: " + CatSize);
						}
						else if (FeaNo.getAttribute("class").equals("Numeric")) {
							String NumFeatName = FeaNo.getText();
							EN1NumName.add(NumFeatName);
							NumSize = EN1NumName.size();
							System.out.println("Numerical Feature: " + NumFeatName);
							System.out.println("Numerical Feature Size: " + NumSize);
						}
					}	
					EntFeaName.put(EntityName+"Cat", EN1CatName);
					EntFeaName.put(EntityName+"Nam", EN1NumName);

					System.out.println(EN1CatName);
					System.out.println(EN1NumName);
					int AllClickCount = 0;


					if(!(CatAct<=0) && CatSize>=3) {
						//					BasePage.click(EntityListInGraph.get(EntiNo));
						WebElement AllButton = driver.findElement(By.xpath("//button[text()='ALL']//preceding-sibling::input"));
						BasePage.click(AllButton);
						AllClickCount++;
						CatAct = CatAct-CatSize;
						System.out.println(CatAct);
					}

					if(!(NumAct<=0) && NumSize>=3 && AllClickCount==0) {
						//					BasePage.click(EntityListInGraph.get(EntiNo));
						WebElement AllButton = driver.findElement(By.xpath("//button[text()='ALL']//preceding-sibling::input"));
						BasePage.click(AllButton);
						NumAct=NumAct-NumSize;
						System.out.println(NumAct);
					}

					WebElement EntityClose = driver.findElement(By.xpath("//i[@data-icon-name='BackToWindow' and @role='presentation']"));	
					BasePage.click(EntityClose);

					System.out.println("Entity features are :" + EntFeaName);

					Thread.sleep(5000);

					break;
				}
			}
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public List <List<String>> SelectingValuesForPlotNew() throws Throwable {
		try	{
			int TotalCatRequired = 3;
			int TotalNumRequired = 3;
			int NoOfCatFeaturesPresent = 0;
			int NoOfNumFeaturesPresent = 0;

			List <String> CategoryFeaturesWhole = new ArrayList<String>();
			List <String> NumericalFeaturesWhole = new ArrayList<String>();
			List <String> NumericalFeaturesSelectedWithoutMeasurement = new ArrayList<String>();
			List <String> NumericalFeaturesSelectedInMeasurement = new ArrayList<String>();
			List <String> CategoriesInOrganism = new ArrayList<String>();
			List <String> CategoriesWithoutOrganism = new ArrayList<String>();

			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);
			HashMap<String, List<String>> EntFeaName = new HashMap<String, List<String>>();

			for(int EntiNo=1; EntiNo<NoOfEntities;EntiNo++) 
			{
				List <String> EntCatName = new ArrayList<String>();
				List <String> EntNumName = new ArrayList<String>();
				String EntityName = EntityListInGraph.get(EntiNo).getText();
				System.out.println(EntityName);
				System.out.println(EntiNo);
				BasePage.click(EntityListInGraph.get(EntiNo));

				BasePage.click(mySelectionScreenClose);	
				Thread.sleep(5000);

				LoopMain:
					switch (EntityName) {

					case "Measurement":
						Test:{							
							for (int j=0; j<FeatureListExceptAllNew.size() ; j++) {	
								Thread.sleep(3000);
								String ComFeatName = FeatureListExceptAllNew.get(j).getText();	

								System.out.println("Cat total: "+ NoOfCatFeaturesPresent);
								System.out.println("Num total: "+ NoOfNumFeaturesPresent);

								System.out.println("Cat Actual: "+ TotalCatRequired);
								System.out.println("Num Actual: "+ TotalNumRequired);

								Thread.sleep(3000);
								System.out.println(ComFeatName);

								if(!(TotalNumRequired<=0)) {
									BasePage.click(FeatureListExceptAllNew.get(j));
									int NuminList = ListInMeasurement.size();
									System.out.println(NuminList);
									if(NuminList>=TotalNumRequired) {
										BasePage.click(AllButton);
										for(int l=0; l<NuminList; l++) {
											String  NumFeature = ListInMeasurement.get(l).getText();
											NumericalFeaturesWhole.add(NumFeature);
											NumericalFeaturesSelectedInMeasurement.add(NumFeature);
											System.out.println(NumFeature);
										}		
										BasePage.click(AddToMySelectionButton);
										TotalNumRequired=TotalNumRequired-NuminList;
										System.out.println(TotalNumRequired);
										if(TotalNumRequired<=0) {
											break Test;
										}
									}
									else {
										BasePage.click(BackButtonInCatagory);
									}
								}
							}
							BasePage.click(EntityClose);
						}
						break;


					case "Organism":
						Test2:
						{
							for (WebElement FeaNo : FeatureListInOrganism) {	
								if (!(FeaNo==FeatureListInOrganism.get(0))) {
									String CatFeateName = FeaNo.getText();
									EntCatName.add(CatFeateName);
									NoOfCatFeaturesPresent = EntCatName.size();
								}
								//								else if (FeaNo.getAttribute("class").equals("Numeric")) {
								//									String NumFeatName = FeaNo.getText();
								//									EntNumName.add(NumFeatName);
								//									NoOfNumFeaturesPresent = EntNumName.size();
								//								}
							}
							EntFeaName.put(EntityName+"_Cat", EntCatName);
							//							EntFeaName.put(EntityName+"_Num", EntNumName);

							System.out.println(TotalCatRequired);

							if(!(TotalCatRequired<=0)) {
								BasePage.click(AllButton);
								TotalCatRequired = TotalCatRequired-NoOfCatFeaturesPresent;
								TotalNumRequired=TotalNumRequired-NoOfNumFeaturesPresent;

								for(int k=1; k<NoOfCatFeaturesPresent; k++) {
									String  CatFeature = FeatureListInOrganism.get(k).getText();
									CategoryFeaturesWhole.add(CatFeature);
									CategoriesInOrganism.add(CatFeature);
									System.out.println(CatFeature);
								}					
							}

							BasePage.click(ApplyButton);

							System.out.println("Entity features are :" + EntFeaName);

							Thread.sleep(5000);

							if(TotalNumRequired<=0 && TotalCatRequired<=0) {
								//							break Test2;
								break LoopMain;
							}
						}
						break;

					default:
						Test3:
						{
							for (WebElement FeaNo : FeatureListExceptAllNew) {	
								if(FeaNo.getAttribute("class").equals("Categorical")) {
									String CatFeateName = FeaNo.getText();
									EntCatName.add(CatFeateName);
									NoOfCatFeaturesPresent = EntCatName.size();
								}
								else if (FeaNo.getAttribute("class").equals("Numeric")) {
									String NumFeatName = FeaNo.getText();
									EntNumName.add(NumFeatName);
									NoOfNumFeaturesPresent = EntNumName.size();
								}
							}	
							EntFeaName.put(EntityName+"_Cat", EntCatName);
							EntFeaName.put(EntityName+"_Num", EntNumName);

							int AllClickCount = 0;

							if(!(TotalCatRequired<=0)) {

								BasePage.click(AllButton);
								AllClickCount++;
								TotalCatRequired = TotalCatRequired-NoOfCatFeaturesPresent;
								TotalNumRequired=TotalNumRequired-NoOfNumFeaturesPresent;

								for(int k=0; k<NoOfCatFeaturesPresent; k++) {
									String  CatFeature = CategoricalFeaturesFromValue.get(k).getAttribute("Value");
									CategoryFeaturesWhole.add(CatFeature);
									CategoriesWithoutOrganism.add(CatFeature);
									System.out.println(CatFeature);
								}
								for(int l=0; l<NoOfNumFeaturesPresent; l++) {
									String  NumFeature = NumericalFeaturesFromValue.get(l).getAttribute("Value");
									NumericalFeaturesWhole.add(NumFeature);
									NumericalFeaturesSelectedWithoutMeasurement.add(NumFeature);
									System.out.println(NumFeature);
								}						
							}

							if(!(TotalNumRequired<=0) && AllClickCount==0) {
								BasePage.click(AllButton);
								TotalCatRequired = TotalCatRequired-NoOfCatFeaturesPresent;
								TotalNumRequired=TotalNumRequired-NoOfNumFeaturesPresent;

								for(int k=0; k<NoOfCatFeaturesPresent; k++) {
									String  CatFeature = CategoricalFeaturesFromValue.get(k).getAttribute("Value");
									CategoryFeaturesWhole.add(CatFeature);
									CategoriesWithoutOrganism.add(CatFeature);
									System.out.println(CatFeature);
								}
								for(int l=0; l<NoOfNumFeaturesPresent; l++) {
									String  NumFeature = NumericalFeaturesFromValue.get(l).getAttribute("Value");
									NumericalFeaturesWhole.add(NumFeature);
									NumericalFeaturesSelectedWithoutMeasurement.add(NumFeature);
									System.out.println(NumFeature);
								}	
							}
							BasePage.click(EntityClose);

							System.out.println("Entity features are :" + EntFeaName);

							Thread.sleep(5000);

							if(TotalNumRequired<=0 && TotalCatRequired<=0) {
								//							break Test3;
								System.out.println(CategoryFeaturesWhole);
								System.out.println(NumericalFeaturesWhole);
								break LoopMain;
							}
						}
						break;
					}	
			}
			System.out.println(CategoryFeaturesWhole);
			System.out.println(NumericalFeaturesWhole);
			System.out.println(NumericalFeaturesSelectedInMeasurement);
			System.out.println(NumericalFeaturesSelectedWithoutMeasurement);
			System.out.println(CategoriesInOrganism);
			System.out.println(CategoriesWithoutOrganism);

			List <List<String>> result = new ArrayList<List<String>>();
			result.add(CategoryFeaturesWhole);
			result.add(NumericalFeaturesWhole);
			result.add(NumericalFeaturesSelectedInMeasurement);
			result.add(NumericalFeaturesSelectedWithoutMeasurement);
			result.add(CategoriesInOrganism);
			result.add(CategoriesWithoutOrganism);
			return result;
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	//Selecting specified amount of Categorical and Numerical values
	public List <List<String>> SelectingValuesForPlotNewWithEntityNames(int NoOfCategoricalValuesRequired, int NoOfNumericalValuesRequired) throws Throwable {
		try	{

			BasePage.click(graphCanvasExpandview);
			ExtentTestManager.getTest().log(Status.PASS,"Graph Canvas is expanded");
			screenshotOnPass("graphCanvasExpandedView");

			int TotalCatRequired = NoOfCategoricalValuesRequired;
			int TotalNumRequired = NoOfNumericalValuesRequired;
			int NoOfCatFeaturesPresent = 0;   	//Number of Categorical features present in a particular feature
			int NoOfNumFeaturesPresent = 0;		//Number of Numerical features present in a particular feature

			System.out.println("Total Cat required = "+TotalCatRequired);

			//String lists to store the Categorical and numerical values
			List <String> CategoryFeaturesWhole = new ArrayList<String>();
			List <String> NumericalFeaturesWhole = new ArrayList<String>();
			List <String> NumericalFeaturesSelectedWithoutMeasurement = new ArrayList<String>();
			List <String> NumericalFeaturesSelectedInMeasurement = new ArrayList<String>();
			List <String> CategoriesInOrganism = new ArrayList<String>();
			List <String> CategoriesWithoutOrganism = new ArrayList<String>();

			//Getting the properties of entities for loop
			int NoOfEntities = EntityListInGraph.size();
			System.out.println("Number of Entities : "+NoOfEntities);
			HashMap<String, List<String>> EntFeaName = new HashMap<String, List<String>>();

			// Loop for selecting entities
			for(int EntiNo=1; EntiNo<NoOfEntities;EntiNo++) 
			{
				List <String> EntCatName = new ArrayList<String>();
				List <String> EntNumName = new ArrayList<String>();
				String EntityName = EntityListInGraph.get(EntiNo).getText();
				System.out.println(EntityName);
				System.out.println(EntiNo);
				System.out.println("Pass");
				BasePage.click(EntityListInGraph.get(EntiNo));

				ExtentTestManager.getTest().log(Status.PASS,EntityName +" - Entity is Selected");
				//				BasePage.click(mySelectionScreenClose);    //Not needed now as we are expanding and using the panel

				Thread.sleep(2000);

				LoopMain:
					switch (EntityName) {

					//Special Case for "Measurement" Entity
					case "Measurement":
						Test:{							
							for (int j=0; j<FeatureListExceptAllNew.size() ; j++) {	
								Thread.sleep(2000);
								String ComFeatName = FeatureListExceptAllNew.get(j).getText();	

								//Can be used as debugging steps
								System.out.println("Cat total: "+ NoOfCatFeaturesPresent);
								System.out.println("Num total: "+ NoOfNumFeaturesPresent);
								System.out.println("Cat Actual: "+ TotalCatRequired);
								System.out.println("Num Actual: "+ TotalNumRequired);

								System.out.println(ComFeatName);

								//Loop when Numerical values are required
								if(!(TotalNumRequired<=0)) {
									BasePage.click(FeatureListExceptAllNew.get(j));
									int NuminList = ListInMeasurement.size();
									System.out.println(NuminList);

									//Loop when the corresponding category contains >= numerical values required
									if(NuminList>=TotalNumRequired) {
										BasePage.click(AllButton);
										for(int l=0; l<NuminList; l++) {
											String  NumFeature = EntityName + " - " + ListInMeasurement.get(l).getText();
											NumericalFeaturesWhole.add(NumFeature);
											NumericalFeaturesSelectedInMeasurement.add(NumFeature);
											System.out.println(NumFeature);
										}		

										BasePage.click(AddToMySelectionButton);
										TotalNumRequired=TotalNumRequired-NuminList;
										System.out.println(TotalNumRequired);

										if(TotalNumRequired<=0) {
											break Test; //break loop if no more numerical values are required
										}
									}
									else {
										BasePage.click(BackButtonInCatagory);
									}
								}
							}
							BasePage.click(EntityClose);
						}
						break;

						//Special Case for "Organism" Entity
					case "Organism":
						Test2:
						{
							//For each of the categorical feature note the values
							for (WebElement FeaNo : FeatureListInOrganism) {	
								if (!(FeaNo==FeatureListInOrganism.get(0))) {
									String CatFeateName = FeaNo.getText();
									EntCatName.add(CatFeateName);
									NoOfCatFeaturesPresent = EntCatName.size();
								}

								//Currently Organism doesn't have any numerical features and are not distinctively segregated into categorical or numerical
								//								else if (FeaNo.getAttribute("class").equals("Numeric")) {
								//									String NumFeatName = FeaNo.getText();
								//									EntNumName.add(NumFeatName);
								//									NoOfNumFeaturesPresent = EntNumName.size();
								//								}
							}
							EntFeaName.put(EntityName+"_Cat", EntCatName);
							//							EntFeaName.put(EntityName+"_Num", EntNumName);  //Since currently numerical feature is

							System.out.println(TotalCatRequired);

							//Loop when the corresponding category contains >= categorical values required
							if(!(TotalCatRequired<=0)) {
								BasePage.click(AllButton);
								TotalCatRequired = TotalCatRequired-NoOfCatFeaturesPresent;
								TotalNumRequired=TotalNumRequired-NoOfNumFeaturesPresent;

								//Store the values of all the categorical values
								for(int k=1; k<NoOfCatFeaturesPresent; k++) {
									String  CatFeature = EntityName + " - " + FeatureListInOrganism.get(k).getText();
									CategoryFeaturesWhole.add(CatFeature);
									CategoriesInOrganism.add(CatFeature);
									System.out.println(CatFeature);
								}
								BasePage.click(ApplyButton);
							}

							//Move the panel to make ApplyButton Visible
							//							while(!(ApplyButton.isDisplayed())) {
							//								Point point = OpenedEntityHeaderInGraphForOrganism.getLocation();
							//								int xcord = point.getX();
							//								int ycord = point.getY();
							//								System.out.println("X axis and Y axis are: " + xcord + " and "+ ycord );
							//								MyDragAndDropOffset(OpenedEntityHeaderInGraphForOrganism,0,-50);
							//							}
							//							MyDragAndDropOffset(OpenedEntityHeaderInGraphForOrganism,0,-50);

							try {
								EntityClose.click();
							}

							catch(Exception et) {
								System.out.println("Entity features are :" + EntFeaName);
								Thread.sleep(2000);

								//If both required numerical and categorical values are selected break loop
								if(TotalNumRequired<=0 && TotalCatRequired<=0) {
									//							break Test2;
									break LoopMain;
								}
							}
						}
						break;

						//Cases for other than "Organism" and "Measurement"
					default:
						Test3:
						{
							//For each of the categorical feature note the values
							for (WebElement FeaNo : FeatureListExceptAllNew) {	
								if(FeaNo.getAttribute("class").equalsIgnoreCase("Categorical")) {
									String CatFeateName = FeaNo.getText();
									EntCatName.add(CatFeateName);
									NoOfCatFeaturesPresent = EntCatName.size();
								}

								//For each of the Numerical feature note the values
								else if (FeaNo.getAttribute("class").equalsIgnoreCase("Numeric")) {
									String NumFeatName = FeaNo.getText();
									EntNumName.add(NumFeatName);
									NoOfNumFeaturesPresent = EntNumName.size();
								}
							}	
							EntFeaName.put(EntityName+"_Cat", EntCatName);
							EntFeaName.put(EntityName+"_Num", EntNumName);

							int AllClickCount = 0;

							//Loop when the corresponding category contains >= categorical values required
							if(!(TotalCatRequired<=0)) {

								BasePage.click(AllButton);
								AllClickCount++;
								TotalCatRequired = TotalCatRequired-NoOfCatFeaturesPresent;
								TotalNumRequired=TotalNumRequired-NoOfNumFeaturesPresent;

								//Select and store the values of all the categorical values
								for(int k=0; k<NoOfCatFeaturesPresent; k++) {
									System.out.println(EntityName);
									String  CatFeature = EntityName + " - " + CategoricalFeaturesFromValue.get(k).getAttribute("Value");
									CategoryFeaturesWhole.add(CatFeature);
									CategoriesWithoutOrganism.add(CatFeature);
									System.out.println(CatFeature);
								}

								//Select and store the values of all the numerical values
								for(int l=0; l<NoOfNumFeaturesPresent; l++) {
									System.out.println(EntityName);
									String  NumFeature = EntityName + " - " + NumericalFeaturesFromValue.get(l).getAttribute("Value");
									NumericalFeaturesWhole.add(NumFeature);
									NumericalFeaturesSelectedWithoutMeasurement.add(NumFeature);
									System.out.println(NumFeature);
								}		
							}

							//Loop if the total number of numerical values is not achieved yet and all is not selected
							if(!(TotalNumRequired<=0) && AllClickCount==0) {
								BasePage.click(AllButton);
								TotalCatRequired = TotalCatRequired-NoOfCatFeaturesPresent;
								TotalNumRequired=TotalNumRequired-NoOfNumFeaturesPresent;

								//Select and store the values of all the categorical values
								for(int k=0; k<NoOfCatFeaturesPresent; k++) {
									System.out.println(EntityName);
									String  CatFeature =  EntityName + " - " + CategoricalFeaturesFromValue.get(k).getAttribute("Value");
									CategoryFeaturesWhole.add(CatFeature);
									CategoriesWithoutOrganism.add(CatFeature);
									System.out.println(CatFeature);
								}

								//Select and store the values of all the numerical values
								for(int l=0; l<NoOfNumFeaturesPresent; l++) {
									System.out.println(EntityName);
									String  NumFeature =  EntityName + " - " + NumericalFeaturesFromValue.get(l).getAttribute("Value");
									NumericalFeaturesWhole.add(NumFeature);
									NumericalFeaturesSelectedWithoutMeasurement.add(NumFeature);
									System.out.println(NumFeature);
								}

							}
							BasePage.click(EntityClose);

							System.out.println("Entity features are :" + EntFeaName);

							Thread.sleep(2000);

							//break loop if all the categories and numerical values are selected
							if(TotalNumRequired<=0 && TotalCatRequired<=0) {
								System.out.println(CategoryFeaturesWhole);
								System.out.println(NumericalFeaturesWhole);
								break LoopMain;
							}
						}
						break;
					}	
			}

			BasePage.click(graphCanvasExpandtoRegularview);
			BasePage.click(mySelectionScreenClose);	

			ExtentTestManager.getTest().log(Status.PASS,"Graph panel reverted to Normal view and My selection screen is closed");

			System.out.println(CategoryFeaturesWhole);
			System.out.println(NumericalFeaturesWhole);
			System.out.println(NumericalFeaturesSelectedInMeasurement);
			System.out.println(NumericalFeaturesSelectedWithoutMeasurement);
			System.out.println(CategoriesInOrganism);
			System.out.println(CategoriesWithoutOrganism);

			List <List<String>> result = new ArrayList<List<String>>();
			result.add(CategoryFeaturesWhole);
			result.add(NumericalFeaturesWhole);
			result.add(NumericalFeaturesSelectedInMeasurement);
			result.add(NumericalFeaturesSelectedWithoutMeasurement);
			result.add(CategoriesInOrganism);
			result.add(CategoriesWithoutOrganism);

			ExtentTestManager.getTest().log(Status.PASS,"The values selected are - \nCategorical Values: "+CategoryFeaturesWhole+"\nNumerical Values: "+NumericalFeaturesWhole);

			return result;
		}
		catch(Throwable ex) {
			throw ex;
		}
	}

	public void EntitiesAndFeatureSelectionVerificationInGraph(String AnalysisName, String AnalysisDescription, String StudyIndex, String NoOfCategoricalValuesRequired, String NoOfNumericalValuesRequired) throws Throwable{
		try {
			//creating analysis
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);   //Verifying study node

			List<List<String>> Features = new ArrayList<List<String>>();
			Features = SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			List<String> CatValuesTotal = new ArrayList<>();     				//Total categorical values
			List<String> NumValuesTotal = new ArrayList<>();					//Total numerical values
			List<String> NumValuesInMeasurement = new ArrayList<>();			//categorical values in Measurement
			List<String> NumValuesWithoutMeasurement = new ArrayList<>();		//categorical values except Measurement
			List<String> CategoriesInOrganism = new ArrayList<>();				//categorical values in Organism
			List<String> CategoriesWithoutOrganism = new ArrayList<>();			//categorical values except Organism
			List<String> FeaturesTotal = new ArrayList<>();						//Total Features

			//Values obtained from features
			CatValuesTotal = Features.get(0);
			NumValuesTotal = Features.get(1);
			NumValuesInMeasurement = Features.get(2);
			NumValuesWithoutMeasurement = Features.get(3);
			CategoriesInOrganism = Features.get(4);
			CategoriesWithoutOrganism = Features.get(5);

			//Debugging steps to get the values stored in the array list 
			//			System.out.println("Categorical Values selected in Total: " + CatValuesTotal);
			//			System.out.println("Numerical Values selected in Total: " + NumValuesTotal);
			//			System.out.println("Numerical Values selected In Measurement: " + NumValuesInMeasurement);
			//			System.out.println("Numerical Values selected Without Measurement: " + NumValuesWithoutMeasurement);
			//			System.out.println("Categorical Values selected In Organism : " + CategoriesInOrganism);
			//			System.out.println("Categorical Values selected In Organism : " + CategoriesWithoutOrganism);

			//get the total count of the values
			int count = CatValuesTotal.size()+NumValuesTotal.size();

			System.out.println("Features selected in Total: " + FeaturesTotal);
			System.out.println("Total count of features : "+ count);

			MySelectionVerificationNew(FeaturesTotal);

			BasePage.click(GetDataButton); //Click get button
			BasePage.click(mySelectionScreenClose); //Close my selection button
			BasePage.waitforAnElement(dataframeMinimizeButton);

			DataFrameVerification(FeaturesTotal);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	public void AllEightTypesOfPlotCreation(String AnalysisName, String AnalysisDescription, String StudyIndex, String NoOfCategoricalValuesRequired, String NoOfNumericalValuesRequired) throws Throwable{
		try {
			//creating analysis
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);   //Verifying study node

			List<List<String>> Features = new ArrayList<List<String>>();
			Features = SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			List<String> CatValuesTotal = new ArrayList<>();     				//Total categorical values
			List<String> NumValuesTotal = new ArrayList<>();					//Total numerical values
			List<String> NumValuesInMeasurement = new ArrayList<>();			//categorical values in Measurement
			List<String> NumValuesWithoutMeasurement = new ArrayList<>();		//categorical values except Measurement
			List<String> CategoriesInOrganism = new ArrayList<>();				//categorical values in Organism
			List<String> CategoriesWithoutOrganism = new ArrayList<>();			//categorical values except Organism
			List<String> FeaturesTotal = new ArrayList<>();						//Total Features

			//Values obtained from features
			CatValuesTotal = Features.get(0);
			NumValuesTotal = Features.get(1);
			NumValuesInMeasurement = Features.get(2);
			NumValuesWithoutMeasurement = Features.get(3);
			CategoriesInOrganism = Features.get(4);
			CategoriesWithoutOrganism = Features.get(5);

			//Debugging steps to get the values stored in the array list 
			//			System.out.println("Categorical Values selected in Total: " + CatValuesTotal);
			//			System.out.println("Numerical Values selected in Total: " + NumValuesTotal);
			//			System.out.println("Numerical Values selected In Measurement: " + NumValuesInMeasurement);
			//			System.out.println("Numerical Values selected Without Measurement: " + NumValuesWithoutMeasurement);
			//			System.out.println("Categorical Values selected In Organism : " + CategoriesInOrganism);
			//			System.out.println("Categorical Values selected In Organism : " + CategoriesWithoutOrganism);

			//get the total count of the values
			int count = CatValuesTotal.size()+NumValuesTotal.size();

			System.out.println("Features selected in Total: " + FeaturesTotal);
			System.out.println("Total count of features : "+ count);

			MySelectionVerificationNew(FeaturesTotal);

			BasePage.click(GetDataButton); //Click get button
			BasePage.click(mySelectionScreenClose); //Close my selection button
			BasePage.waitforAnElement(dataframeMinimizeButton);

			DataFrameVerification(FeaturesTotal);

			PlotWithOneNumericalFeatureNew(AnalysisName);
			PlotWithOneCategoricalFeatureNew(AnalysisName);
			PlotWithOneCategoricalandOneNumericalFeatureNew(AnalysisName);

		}
		catch(Exception ex) {
			throw ex;
		}
	}


	public void MySelectionVerification(List<String> CategoricalValues, List<String> NumericalValues, List<String> NumericalValuesInMeasurement,List<String> NumericalValuesWithoutMeasurement, List<String> CategoriesInOrganism,List<String> CategoriesWithoutOrganism) throws Throwable{
		try {
			//		List<WebElement> ValuesInMySelection = driver.findElements(By.xpath("//div[contains(@class,'selected_filters')]//div[contains(@class,'selection_item')]/div[contains(@class,'Categorical') and contains(@class,'item_title')]"));	
			//			ForLoop:
			for(WebElement Value : ValuesInMySelection) {
				String Type = Value.getAttribute("Class");

				if(Type.contains("Categorical")) {
					//s
					OrganismLoop:
						if(Value.getText().contains("ORGANISM")){

							String StringOrganism = ValuesInMySelectionOrganism.getAttribute("value");

							for(String ItemInOrganism : CategoriesInOrganism) {
								try {
									assertEquals(StringOrganism.contains(ItemInOrganism), true);
								}
								catch(Exception ValueNotPresent) {
									ExtentTestManager.getTest().log(Status.FAIL, "'"+ItemInOrganism+"'" +  " - Feature is not present in My Selection");
									break OrganismLoop;
								}
							}

						}

					MeasurementLoop:
						if(Value.getText().contains("MEASUREMENT")){

							String StringMeasurement = ValuesInMySelectionMeasurement.getAttribute("value");

							for(String ItemInMeasurement : NumericalValuesInMeasurement) {
								try {
									assertEquals(StringMeasurement.contains(ItemInMeasurement), true);
								}
								catch(Exception ValueNotPresent) {
									ExtentTestManager.getTest().log(Status.FAIL, "'"+ItemInMeasurement+"'" +  " - Feature is not present in My Selection");
									break MeasurementLoop;
								}
							}

						}

						else{
							String FeatureName = Value.getText();
							List <String> MissingCatFeatures = new ArrayList<>();
							System.out.println(FeatureName);
							int totalMatchCat = 0;
							for(String Category : CategoriesWithoutOrganism) {

								System.out.println(Category);
								String CategoryCapital = Category.toUpperCase();
								System.out.println(CategoryCapital);
								if (FeatureName.contains(CategoryCapital)) {
									totalMatchCat++;
								}
								else {
									MissingCatFeatures.add(Category);
								}
							}
							System.out.println("Change");
							try {
								assertEquals(CategoriesWithoutOrganism.size(),totalMatchCat);
							}
							catch(Throwable ex){
								ExtentTestManager.getTest().log(Status.FAIL, "'"+MissingCatFeatures+"'" +  " - Feature(s) is/are not present in My Selection");
							}
						}
				}

				if(Type.contains("Numerical")) {
					String FeatureName = Value.getText();
					List <String> MissingNumFeatures = new ArrayList<>();
					int totalMatchNum = 0;
					for(String Numeric : NumericalValuesWithoutMeasurement) {
						if (FeatureName.contains(Numeric)) {
							totalMatchNum++;
						}
						else {
							MissingNumFeatures.add(Numeric);
						}
					}
					try {
						assertEquals(CategoriesWithoutOrganism.size(),totalMatchNum);
					}
					catch(Throwable ex){
						ExtentTestManager.getTest().log(Status.FAIL, "'"+MissingNumFeatures+"'" +  " - Feature(s) is/are not present in My Selection");
					}
				}
			}
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	public void MySelectionVerificationNew(List<String> FeaturesTotal) throws Throwable{
		try {	
			BasePage.click(mySelectionScreenOpen);
			screenShotForPass("My Selection panel is opened", "mySelectionScreenOpen");

			int k=0;

			//For each of the feature present in my selection
			for(String Feature : FeaturesTotal) {
				System.out.println(Feature+ " - This is the name in the saved");

				innerloop:
					for(WebElement NameInMySelection: FeatureNamesInMySelection) {
						System.out.println(k);
						String Name = NameInMySelection.getText();
						System.out.println(Name+ " - This is the name in My Selection");

						ExtentTestManager.getTest().log(Status.PASS, Name + " - is present in My Selection");

						//Loop for Organism feature
						if(Name.matches("ORGANISM")) {
							try {
								assertEquals(Feature.contains("Organism"),true);
								WebElement NameInSelec = driver.findElement(By.xpath("//div[contains(@class,'item_title')]//*[contains(text(),'Organism')]//parent::div//input"));
								String values = NameInSelec.getAttribute("value");
								System.out.println(values);

								String second = splitAStringAtHyphenandReturnSecond(Feature);
								assertEquals(values.contains(second), true);
								k++;

								ExtentTestManager.getTest().log(Status.PASS, second + " - is verified in My Selection for Organism");

								System.out.println("checked Right");
								break innerloop;
							}
							catch(AssertionError ex) {
								String second = splitAStringAtHyphenandReturnSecond(Feature);
								ExtentTestManager.getTest().log(Status.FAIL, second + " - is not present in My Selection for Organism");
								continue;
							}
						}

						//Loop for Measurement feature
						else if(Name.contains("MEASUREMENT")) {
							try {	
								assertEquals(Feature.contains("Measurement"),true);
								WebElement NameInSelec = driver.findElement(By.xpath("//div[contains(@class,'item_title')]//*[contains(text(),'Measurement')]//parent::div//input"));
								String values = NameInSelec.getAttribute("value");
								System.out.println(values);

								String second = splitAStringAtHyphenandReturnSecond(Feature);
								assertEquals(values.contains(second), true);
								k++;

								ExtentTestManager.getTest().log(Status.PASS, second + " - is verified in My Selection for Measurement");

								System.out.println("checked Right");
								break innerloop;
							}
							catch(AssertionError ex) {
								String second = splitAStringAtHyphenandReturnSecond(Feature);
								ExtentTestManager.getTest().log(Status.FAIL, second + " - is not present in My Selection for Measurement");
								continue;
							}
						}

						else {
							try {
								String NameLowerCase = Name.toLowerCase();
								String FeatureLowerCase = Feature.toLowerCase();
								System.out.println(NameLowerCase);
								System.out.println(FeatureLowerCase);
								assertEquals(NameLowerCase, FeatureLowerCase);
								k++;

								ExtentTestManager.getTest().log(Status.PASS, Feature + " - is verified in My Selection");

								System.out.println("Checked right");
								break innerloop;
							}
							catch(AssertionError ex) {
								ExtentTestManager.getTest().log(Status.FAIL, Feature + " - is verified in My Selection");
								continue;
							}
						}
					}
				System.out.println(k);
			}
			System.out.println("Total count checked - " + k);
			assertEquals(FeaturesTotal.size(), k);
		}
		catch(Exception ex) {
			throw ex;
		}
		catch(AssertionError ex) {
			ExtentTestManager.getTest().log(Status.FAIL, "Some of the selected values are not matching with My Selection");	
		}
	}

	public String splitAStringAtHyphenandReturnFirst(String Word) throws Throwable{
		try {			
			String[] parts = Word.split("-");
			String first = parts[0].trim();
			String second = parts[1].trim();
			System.out.println(first);
			System.out.println(second);
			return first;
		}
		catch(Exception et) {
			throw et;
		}
	}

	public String splitAStringAtHyphenandReturnSecond(String Word) throws Throwable{
		try {			
			String[] parts = Word.split("-");
			String first = parts[0].trim();
			String second = parts[1].trim();
			System.out.println(first);
			System.out.println(second);
			return second;
		}
		catch(Exception et) {
			throw et;
		}
	}

	public void DataFrameVerification(List<String> FeaturesTotal) throws Throwable{
		try {			
			BasePage.waitforAnElement(ColumnHeadersOfDataFrame.get(0));
			screenShotForPass("Dataframe is created","dataFrameScreenshot");

			int k=0;
			for(String Feature : FeaturesTotal) {
				System.out.println(Feature+ " - This is the name in the saved");
				innerloop:
					for(WebElement ColumnHeader : ColumnHeadersOfDataFrame ) {
						System.out.println(k);
						String nameInColumn = ColumnHeader.getAttribute("id");
						System.out.println(nameInColumn + " - The name displayed in the column header");

						if(nameInColumn.equalsIgnoreCase("indexProperty")) {
							continue;
						}

						else {
							try {
								String first = splitAStringAtHyphenandReturnFirst(Feature);
								String second = splitAStringAtHyphenandReturnSecond(Feature);

								if(first.equalsIgnoreCase("Organism")) {
									assertEquals("common_name",nameInColumn);
									k++;
									System.out.println("Common Name checked");
									ExtentTestManager.getTest().log(Status.PASS, second + " - is present in Dataframe as \"Common_name\"");
									break innerloop;
								}

								else {
									assertEquals(second,nameInColumn);
									k++;
									ExtentTestManager.getTest().log(Status.PASS, second + " - is present in Dataframe");
									System.out.println("Normal Name checked");
									break innerloop;
								}

							}
							catch(Throwable ex) {
								continue;
							}
						}
					}
			}
			assertEquals(k, FeaturesTotal.size());
			System.out.println("The count matches with the one verified");
		}
		catch(Exception ex) {
			throw ex;
		}
		catch(AssertionError ex) {
			ExtentTestManager.getTest().log(Status.FAIL, "Some selected values are not present in Dataframe");
			System.out.println("Values did not match");
			throw ex;
		}
	}

	public String delimiterAndTitleCaseConversion(String featureName) {
		char[] delimiters = {' ','_'};
		String featureNameWithoutUnderscore = featureName.replace("_", " ");
		String featureNameDelimited = WordUtils.capitalizeFully(featureNameWithoutUnderscore, delimiters);
		return featureNameDelimited;
	}

	public void PlotWithOneNumericalFeature(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);

			//need to find a way to keep the entity name and feature name dynamic
			EntitySelect("Subject_B");
			BasePage.click(mySelectionScreenClose);
			Thread.sleep(5000);

			FeatureSelect("age");

			CloseThePanelinGraphFromCategoryList("age");
			BasePage.click(mySelectionScreenOpen);

			//			WaitforValueInMySelectionFilter("AGE");  //dynamic value

			BasePage.click(GetDataButton);
			BasePage.click(mySelectionScreenClose);

			createPlot();

			DragAndDropBlank("age");   //dynamic value
			BasePage.click(Dataframe);					

			SelectPlotType("Histogram");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Histogram plot", "HistogramPlot");
			GetHeaderXandY("Histogram of Age","Age","Frequency");  //dynamic value

			SelectPlotType("Boxplot");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Boxplot plot", "Boxplot");
			GetHeaderY("Boxplot of Age","Frequency");   //why X is not available  //dynamic value

			SelectPlotType("KDE");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - KDE plot", "KDEPlot");
			GetHeaderXandY("KDE of Age","Age","Frequency");  //dynamic value

			SelectPlotType("Violin");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Violin plot", "ViolinPlot");
			GetHeaderY("Violin of Age","Frequency");  //dynamic value
		}

		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithOneNumericalFeatureAloneWithoutVerification(String AnalysisName, String AnalysisDescription, String StudyIndex,String NoOfCategoricalValuesRequired ,String NoOfNumericalValuesRequired) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);

			SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			


			try {
				mySelectionScreenClose.isDisplayed();
			}

			catch(Exception ex){
				System.out.println("My Selection Screen is open");	
			}

			finally {
				BasePage.click(mySelectionScreenOpen);
				BasePage.click(GetDataButton); //Click get button
				BasePage.click(mySelectionScreenClose); //Close my selection button

				BasePage.click(dataframeListViewButton);
				BasePage.click(dataframeNumericalFeaturestab);

				int TotalNumberOfEntries = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntries);

				int RandomNumber = RandomValueGenerator(0,(TotalNumberOfEntries-1));
				System.out.println(RandomNumber);
				WebElement NumericalFeatureselected = valuesInDataframeInListview.get(RandomNumber);

				String NameOfFeature = valuesInDataframeInListview.get(RandomNumber).getAttribute("id");
				System.out.println(NameOfFeature);

				ExtentTestManager.getTest().log(Status.PASS,NameOfFeature + " is selected from the dataframe");

				BasePage.click(Dataframe);

				createPlot();

				BasePage.click(Dataframe);

				String NameofFeatureCleansed = delimiterAndTitleCaseConversion(NameOfFeature);
				System.out.println(NameofFeatureCleansed);

				DragAndDropBlankNew(NumericalFeatureselected);  
				BasePage.click(Dataframe);					

				Thread.sleep(2000);

				int total_match_expected = 4;

				SelectPlotType("Histogram");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Histogram plot", "HistogramPlot");
				int h = GetHeaderXandY("Histogram of "+NameofFeatureCleansed,NameofFeatureCleansed,"Frequency");  
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Histogram are verified");
				SummaryStatisticsVerificationInPlot();

				SelectPlotType("Boxplot");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Boxplot plot", "Boxplot");
				int b = GetHeaderY("Boxplot of "+NameofFeatureCleansed,"Frequency");   
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Boxplot are verified");
				SummaryStatisticsVerificationInPlot();

				SelectPlotType("KDE");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - KDE plot", "KDEPlot");
				int k = GetHeaderXandY("KDE of "+NameofFeatureCleansed,NameofFeatureCleansed,"Frequency");
				ExtentTestManager.getTest().log(Status.PASS, "Labels in KDE are verified");
				SummaryStatisticsVerificationInPlot();

				SelectPlotType("Violin");
				Thread.sleep(3000);
				screenShotForPass(AnalysisName + " - Violin plot", "ViolinPlot");
				int v = GetHeaderY("Violin of "+NameofFeatureCleansed,"Frequency"); 
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Violin are verified");
				SummaryStatisticsVerificationInPlot();

				assertEquals(h+b+k+v, total_match_expected);
			}
		}

		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}





	public void SummaryStatisticsVerificationInPlot() throws Throwable {
		try {
			int sizeOfElements = summaryListHeadersInPlot.size();
			ArrayList<String> listOfNames = new ArrayList<String>();
			for (int i=1; i<=sizeOfElements;i++) 
			{
				WebElement Listname = driver.findElement(By.xpath("(//div[contains(@class,'NumericalSummary')]//span[1])["+i+"]"));
				String name = Listname.getText();
				listOfNames.add(name);
			}

			ArrayList<String> listOfNamesExpected = new ArrayList<String>();
			listOfNamesExpected.addAll(Arrays.asList("Count", "Mean", "Standard deviation", "Variance", "25th percentile","75th percentile","Interquartile range","Median","Mode","Skewness","Kurtosis","Minimum","Maximum")); 
			assertEquals(listOfNames, listOfNamesExpected);

			ExtentTestManager.getTest().log(Status.PASS, "Summary Statistics contains the lables - "+ listOfNames);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	public void PlotWithOneNumericalFeatureNew(String AnalysisName) throws Throwable{
		try {
			BasePage.click(dataframeListViewButton);

			BasePage.click(dataframeNumericalFeaturestab);

			int TotalNumberOfEntries = valuesInDataframeInListview.size();
			System.out.println(TotalNumberOfEntries);

			int RandomNumber = RandomValueGenerator(0,(TotalNumberOfEntries-1));

			System.out.println(RandomNumber);

			WebElement NumericalFeatureselected = valuesInDataframeInListview.get(RandomNumber);

			String NameOfFeature = valuesInDataframeInListview.get(RandomNumber).getAttribute("id");
			System.out.println(NameOfFeature);

			System.out.println("Test");

			BasePage.click(Dataframe);

			createPlot();

			BasePage.click(Dataframe);

			String NameofFeatureCleansed = delimiterAndTitleCaseConversion(NameOfFeature);
			System.out.println(NameofFeatureCleansed);

			DragAndDropBlankNew(NumericalFeatureselected);  
			BasePage.click(Dataframe);					

			SelectPlotType("Histogram");
			Thread.sleep(2000);
			screenShotForPass(AnalysisName + " - Histogram plot", "HistogramPlot");
			GetHeaderXandY("Histogram of "+NameofFeatureCleansed,NameofFeatureCleansed,"Frequency");  

			SelectPlotType("Boxplot");
			Thread.sleep(2000);
			screenShotForPass(AnalysisName + " - Boxplot plot", "Boxplot");
			GetHeaderY("Boxplot of "+NameofFeatureCleansed,"Frequency");   //why X is not available  //dynamic value

			SelectPlotType("KDE");
			Thread.sleep(2000);
			screenShotForPass(AnalysisName + " - KDE plot", "KDEPlot");
			GetHeaderXandY("KDE of "+NameofFeatureCleansed,NameofFeatureCleansed,"Frequency");  //dynamic value

			SelectPlotType("Violin");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Violin plot", "ViolinPlot");
			GetHeaderY("Violin of "+NameofFeatureCleansed,"Frequency");  //dynamic value
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}


	public void PlotWithOneCategoricalFeature(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);


			//Need to find a way to have this as dynamic value
			EntitySelect("Subject_B");
			BasePage.click(mySelectionScreenClose);
			Thread.sleep(5000);
			FeatureSelect("fizpatrick_skin_type");
			CloseThePanelinGraphFromCategoryList("fizpatrick_skin_type");
			BasePage.click(mySelectionScreenOpen);

			//			WaitforValueInMySelectionFilter("FIZPATRICK_SKIN_TYPEfizpatrick_skin_type"); //dynamic value

			BasePage.click(GetDataButton);
			BasePage.click(mySelectionScreenClose);

			createPlot();

			DragAndDropBlank("fizpatrick_skin_type");  //dynamic value
			BasePage.click(Dataframe);			

			SelectPlotType("Bar Chart");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Bar Chart", "Bar Chart Plot");
			GetHeaderXandY("Bar Chart of Fizpatrick Skin Type","Fizpatrick Skin Type","Frequency");  //dynamic value

			SelectPlotType("Treemap");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Treemap", "Treemap");
			GetHeader("Treemap of Fizpatrick Skin Type");   //why X is not available  //dynamic value

			SelectPlotType("Pareto");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Pareto", "Pareto");
			GetHeaderXandY("Pareto of Fizpatrick Skin Type","Fizpatrick Skin Type","Frequency");  //dynamic value
		}

		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithOneCategoricalFeatureAloneWithoutVerification(String AnalysisName, String AnalysisDescription, String StudyIndex,String NoOfCategoricalValuesRequired ,String NoOfNumericalValuesRequired) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);

			SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			

			try {
				mySelectionScreenClose.isDisplayed();
			}

			catch(Exception ex){
				System.out.println("My Selection Screen is open");	
			}

			finally {
				BasePage.click(mySelectionScreenOpen);
				BasePage.click(GetDataButton); //Click get button
				BasePage.click(mySelectionScreenClose); //Close my selection button

				BasePage.click(dataframeListViewButton);
				BasePage.click(dataframeCategoricalFeaturestab);

				int TotalNumberOfEntries = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntries);

				int RandomNumber = RandomValueGenerator(0,(TotalNumberOfEntries-1));
				System.out.println(RandomNumber);
				WebElement CategoricalFeatureSelected = valuesInDataframeInListview.get(RandomNumber);
				String NameOfFeature = valuesInDataframeInListview.get(RandomNumber).getAttribute("id");
				System.out.println(NameOfFeature);

				BasePage.click(Dataframe);

				createPlot();

				BasePage.click(Dataframe);

				String NameofFeatureCleansed = delimiterAndTitleCaseConversion(NameOfFeature);
				System.out.println(NameofFeatureCleansed);

				DragAndDropBlankNew(CategoricalFeatureSelected);  
				BasePage.click(Dataframe);					

				Thread.sleep(2000);

				int total_match_expected = 3;

				SelectPlotType("Bar Chart");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Bar Chart", "Bar Chart Plot");
				int b = GetHeaderXandY("Bar Chart of "+NameofFeatureCleansed,NameofFeatureCleansed,"Frequency"); 
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Bar Chart are verified");

				SelectPlotType("Treemap");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Treemap", "Treemap");
				int t = GetHeader("Treemap of "+NameofFeatureCleansed);  
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Treemap are verified");

				SelectPlotType("Pareto");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Pareto", "Pareto");
				int p = GetHeaderXandY("Pareto of "+NameofFeatureCleansed,NameofFeatureCleansed,"Frequency");
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Pareto are verified");

				assertEquals(b+t+p, total_match_expected);
			}
		}

		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}


	public void PlotWithOneCategoricalFeatureNew(String AnalysisName) throws Throwable{
		try {

			BasePage.click(Dataframe);

			BasePage.click(dataframeListViewButton);

			BasePage.click(dataframeCategoricalFeaturestab);

			int TotalNumberOfEntries = valuesInDataframeInListview.size();
			System.out.println(TotalNumberOfEntries);

			int RandomNumber = RandomValueGenerator(0,(TotalNumberOfEntries-1));

			System.out.println(RandomNumber);

			WebElement CategoricalFeatureSelected = valuesInDataframeInListview.get(RandomNumber);

			String NameOfFeature = valuesInDataframeInListview.get(RandomNumber).getAttribute("id");
			System.out.println(NameOfFeature);

			System.out.println("Test");

			BasePage.click(Dataframe);

			createPlot();

			BasePage.click(Dataframe);

			String NameofFeatureCleansed = delimiterAndTitleCaseConversion(NameOfFeature);
			System.out.println(NameofFeatureCleansed);

			DragAndDropBlankNew(CategoricalFeatureSelected);  
			BasePage.click(Dataframe);	

			Thread.sleep(2000);

			SelectPlotType("Bar Chart");
			Thread.sleep(2000);
			screenShotForPass(AnalysisName + " - Bar Chart", "Bar Chart Plot");
			GetHeaderXandY("Bar Chart of "+NameofFeatureCleansed,NameofFeatureCleansed,"Frequency"); 

			SelectPlotType("Treemap");
			Thread.sleep(2000);
			screenShotForPass(AnalysisName + " - Treemap", "Treemap");
			GetHeader("Treemap of "+NameofFeatureCleansed);  

			SelectPlotType("Pareto");
			Thread.sleep(2000);
			screenShotForPass(AnalysisName + " - Pareto", "Pareto");
			GetHeaderXandY("Pareto of "+NameofFeatureCleansed,NameofFeatureCleansed,"Frequency");
		}

		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithOneCategoricalandOneNumericalFeature(String AnalysisName, String AnalysisDescription, String StudyIndex,String NoOfCategoricalValuesRequired ,String NoOfNumericalValuesRequired) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);


			//Need to find a way to have this as dynamic value
			EntitySelect("Subject_B");
			BasePage.click(mySelectionScreenClose);
			Thread.sleep(5000);
			FeatureSelect("age");
			FeatureSelect("fizpatrick_skin_type");
			CloseThePanelinGraphFromCategoryList("fizpatrick_skin_type");
			BasePage.click(mySelectionScreenOpen);

			//			WaitforValueInMySelectionFilter("FIZPATRICK_SKIN_TYPEfizpatrick_skin_type"); //dynamic value

			BasePage.click(GetDataButton);
			BasePage.click(mySelectionScreenClose);

			createPlot();

			DragAndDropBlank("fizpatrick_skin_type");  //dynamic value
			DragAndDropValuePresent("age");

			BasePage.click(Dataframe);			

			SelectPlotType("Overlayed Histogram");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Overlayed Histogram", "Overlayed Histogram");
			GetHeaderXandY("Overlayed Histogram of Fizpatrick Skin Type, Age","Age","Frequency");  //dynamic value

			SelectPlotType("Side by side Box Plots");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Side by side Box Plots", "Side by side Box Plots");
			GetHeaderXandY("Side By Side Box Plots of Fizpatrick Skin Type, Age","Fizpatrick Skin Type", "Age");  //dynamic value

			SelectPlotType("Overlayed KDE");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Overlayed KDE", "Overlayed KDE");
			GetHeaderXandY("Overlayed KDE of Fizpatrick Skin Type, Age","Age","Density");  //dynamic value

			SelectPlotType("Side by side Violin");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Side by side Violin", "Side by side Violin");
			GetHeaderXandY("Side By Side Violin of Fizpatrick Skin Type, Age","Fizpatrick Skin Type","Age");  //dynamic value
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithOneCategoricalandOneNumericalFeatureNew(String AnalysisName) throws Throwable{
		try {
			BasePage.click(Dataframe);

			BasePage.click(dataframeListViewButton);

			//Selecting a random categorical value from List View

			BasePage.click(dataframeCategoricalFeaturestab);

			int TotalNumberOfEntriesCat = valuesInDataframeInListview.size();
			System.out.println(TotalNumberOfEntriesCat);

			int RandomNumberCat = RandomValueGenerator(0,(TotalNumberOfEntriesCat-1));

			System.out.println(RandomNumberCat);

			WebElement CategoricalFeatureSelected = valuesInDataframeInListview.get(RandomNumberCat);

			String NameOfFeatureCat = valuesInDataframeInListview.get(RandomNumberCat).getAttribute("id");
			System.out.println(NameOfFeatureCat);

			//Selecting a random numerical value from List View

			BasePage.click(dataframeNumericalFeaturestab);

			int TotalNumberOfEntriesNum = valuesInDataframeInListview.size();
			System.out.println(TotalNumberOfEntriesNum);

			int RandomNumberNum = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));

			System.out.println(RandomNumberCat);

			WebElement NumericalFeatureSelected = valuesInDataframeInListview.get(RandomNumberNum);

			String NameOfFeatureNum = valuesInDataframeInListview.get(RandomNumberNum).getAttribute("id");
			System.out.println(NameOfFeatureNum);

			System.out.println("Test");

			BasePage.click(Dataframe);

			createPlot();

			BasePage.click(dataframeAllFeaturestab);

			DragAndDropBlankNew(CategoricalFeatureSelected); 
			DragAndDropValuePresentNew(NumericalFeatureSelected);

			BasePage.click(Dataframe);			


			String NameofCatFeatureCleansed = delimiterAndTitleCaseConversion(NameOfFeatureCat);
			System.out.println(NameofCatFeatureCleansed);

			String NameofNumFeatureCleansed = delimiterAndTitleCaseConversion(NameOfFeatureNum);
			System.out.println(NameofNumFeatureCleansed);


			SelectPlotType("Overlayed Histogram");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Overlayed Histogram", "Overlayed Histogram");
			GetHeaderXandY("Overlayed Histogram of "+NameofCatFeatureCleansed+", "+NameofNumFeatureCleansed,NameofNumFeatureCleansed,"Frequency"); 

			SelectPlotType("Side by side Box Plots");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Side by side Box Plots", "Side by side Box Plots");
			GetHeaderXandY("Side By Side Box Plots of "+NameofCatFeatureCleansed+", "+NameofNumFeatureCleansed,NameofCatFeatureCleansed, NameofNumFeatureCleansed);  

			SelectPlotType("Overlayed KDE");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Overlayed KDE", "Overlayed KDE");
			GetHeaderXandY("Overlayed KDE of "+NameofCatFeatureCleansed+", "+NameofNumFeatureCleansed,NameofNumFeatureCleansed,"Density"); 

			SelectPlotType("Side by side Violin");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Side by side Violin", "Side by side Violin");
			GetHeaderXandY("Side By Side Violin of "+NameofCatFeatureCleansed+", "+NameofNumFeatureCleansed,NameofCatFeatureCleansed,NameofNumFeatureCleansed); 
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithOneCategoricalandOneNumericalFeatureAloneWithoutVerification(String AnalysisName, String AnalysisDescription, String StudyIndex,String NoOfCategoricalValuesRequired ,String NoOfNumericalValuesRequired) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);

			SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			

			try {
				mySelectionScreenClose.isDisplayed();
			}

			catch(Exception ex){
				System.out.println("My Selection Screen is open");	
			}

			finally {
				BasePage.click(mySelectionScreenOpen);
				BasePage.click(GetDataButton); //Click get button
				BasePage.click(mySelectionScreenClose); //Close my selection button

				BasePage.click(dataframeListViewButton);

				BasePage.click(dataframeCategoricalFeaturestab);
				int TotalNumberOfEntriesCat = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntriesCat);

				int RandomNumberCat = RandomValueGenerator(0,(TotalNumberOfEntriesCat-1));
				System.out.println(RandomNumberCat);
				WebElement CategoricalFeatureSelected = valuesInDataframeInListview.get(RandomNumberCat);
				String NameOfFeatureCat = valuesInDataframeInListview.get(RandomNumberCat).getAttribute("id");
				System.out.println(NameOfFeatureCat);

				//Selecting a random numerical value from List View

				BasePage.click(dataframeNumericalFeaturestab);
				int TotalNumberOfEntriesNum = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntriesNum);

				int RandomNumberNum = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				System.out.println(RandomNumberCat);
				WebElement NumericalFeatureSelected = valuesInDataframeInListview.get(RandomNumberNum);
				String NameOfFeatureNum = valuesInDataframeInListview.get(RandomNumberNum).getAttribute("id");
				System.out.println(NameOfFeatureNum);

				BasePage.click(Dataframe);

				createPlot();

				BasePage.click(Dataframe);

				BasePage.click(dataframeAllFeaturestab);

				WebElement CategoricalFeatureSelectedFromAll = driver.findElement(By.xpath("//span[@id='"+NameOfFeatureCat+"']"));
				WebElement NumericalFeatureSelectedFromAll = driver.findElement(By.xpath("//span[@id='"+NameOfFeatureNum+"']"));

				DragAndDropBlankNew(CategoricalFeatureSelectedFromAll); 
				DragAndDropValuePresentNew(NumericalFeatureSelectedFromAll);

				BasePage.click(Dataframe);			

				String NameofCatFeatureCleansed = delimiterAndTitleCaseConversion(NameOfFeatureCat);
				System.out.println(NameofCatFeatureCleansed);

				String NameofNumFeatureCleansed = delimiterAndTitleCaseConversion(NameOfFeatureNum);
				System.out.println(NameofNumFeatureCleansed);

				Thread.sleep(2000);

				int total_match_expected = 4;

				SelectPlotType("Overlayed Histogram");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Overlayed Histogram", "Overlayed Histogram");
				int oh = GetHeaderXandY("Overlayed Histogram of "+NameofCatFeatureCleansed+", "+NameofNumFeatureCleansed,NameofNumFeatureCleansed,"Frequency"); 
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Overlayed Histogram are verified");

				SelectPlotType("Side by side Box Plots");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Side by side Box Plots", "Side by side Box Plots");
				int sb = GetHeaderXandY("Side By Side Box Plots of "+NameofCatFeatureCleansed+", "+NameofNumFeatureCleansed,NameofCatFeatureCleansed, NameofNumFeatureCleansed);  
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Side By side Box plots are verified");

				SelectPlotType("Overlayed KDE");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Overlayed KDE", "Overlayed KDE");
				int ok = GetHeaderXandY("Overlayed KDE of "+NameofCatFeatureCleansed+", "+NameofNumFeatureCleansed,NameofNumFeatureCleansed,"Density"); 
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Overlayed KDE are verified");

				SelectPlotType("Side by side Violin");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Side by side Violin", "Side by side Violin");
				int sv = GetHeaderXandY("Side By Side Violin of "+NameofCatFeatureCleansed+", "+NameofNumFeatureCleansed,NameofCatFeatureCleansed,NameofNumFeatureCleansed); 
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Side by side Violin are verified");

				assertEquals(oh+sb+ok+sv, total_match_expected);
			}
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}


	public void PlotWithTwoNumericalFeaturesAloneWithoutVerification(String AnalysisName, String AnalysisDescription, String StudyIndex,String NoOfCategoricalValuesRequired ,String NoOfNumericalValuesRequired)throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);

			SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			

			try {
				mySelectionScreenClose.isDisplayed();
			}

			catch(Exception ex){
				System.out.println("My Selection Screen is open");	
			}

			finally {
				BasePage.click(mySelectionScreenOpen);
				BasePage.click(GetDataButton); //Click get button
				BasePage.click(mySelectionScreenClose); //Close my selection button

				BasePage.click(dataframeListViewButton);

				BasePage.click(dataframeNumericalFeaturestab);
				int TotalNumberOfEntriesNum = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntriesNum);

				//1st numerical value selection
				int RandomNumberNum1 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				System.out.println(RandomNumberNum1);

				WebElement NumericalFeatureSelected1 = valuesInDataframeInListview.get(RandomNumberNum1);
				String NameOfFeatureNum1 = valuesInDataframeInListview.get(RandomNumberNum1).getAttribute("id");
				System.out.println(NameOfFeatureNum1);


				int RandomNumberNum2;
				do {
					RandomNumberNum2 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				}
				while(RandomNumberNum2==RandomNumberNum1);
				System.out.println(RandomNumberNum2);

				//2nd numerical value selection
				WebElement NumericalFeatureSelected2 = valuesInDataframeInListview.get(RandomNumberNum2);
				String NameOfFeatureNum2 = valuesInDataframeInListview.get(RandomNumberNum2).getAttribute("id");
				System.out.println(NameOfFeatureNum2);

				BasePage.click(Dataframe);

				createPlot();

				BasePage.click(Dataframe);

				DragAndDropBlankNew(NumericalFeatureSelected1); 
				DragAndDropValuePresentNew(NumericalFeatureSelected2);

				BasePage.click(Dataframe);			

				String NameofNumFeatureCleansed1 = delimiterAndTitleCaseConversion(NameOfFeatureNum1);
				System.out.println(NameofNumFeatureCleansed1);

				String NameofNumFeatureCleansed2 = delimiterAndTitleCaseConversion(NameOfFeatureNum2);
				System.out.println(NameofNumFeatureCleansed2);

				Thread.sleep(2000);

				int total_match_expected = 1;

				SelectPlotType("Scatter plot");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Scatter Plot", "Scatter Plot");
				int s = GetHeaderXandY("Scatter Plot of "+NameofNumFeatureCleansed1+", "+NameofNumFeatureCleansed2,NameofNumFeatureCleansed1,NameofNumFeatureCleansed2); 
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Scatter Plot are verified");

				assertEquals(s, total_match_expected);
			}
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithTwoNumericalFeatures(String AnalysisName, String AnalysisDescription, String StudyIndex, String NoOfCategoricalValuesRequired, String NoOfNumericalValuesRequired) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);

			//Need to find a way to have this as dynamic value
			EntitySelect("Subject_B");
			BasePage.click(mySelectionScreenClose);
			Thread.sleep(5000);
			FeatureSelect("age");
			FeatureSelect("subject_number");
			CloseThePanelinGraphFromCategoryList("fizpatrick_skin_type");
			BasePage.click(mySelectionScreenOpen);

			//			WaitforValueInMySelectionFilter("FIZPATRICK_SKIN_TYPEfizpatrick_skin_type"); //dynamic value

			BasePage.click(GetDataButton);
			BasePage.click(mySelectionScreenClose);

			createPlot();

			DragAndDropBlank("age");  //dynamic value
			DragAndDropValuePresent("subject_number");

			BasePage.click(Dataframe);			

			SelectPlotType("Scatter plot");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Scatter Plot", "Scatter Plot");
			GetHeaderXandY("Scatter Plot of Age, Subject Number","Age","Subject Number");  //dynamic value
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithTwoCategoricalFeatures(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);

			//Need to find a way to have this as dynamic value
			EntitySelect("Subject_B");
			BasePage.click(mySelectionScreenClose);
			Thread.sleep(5000);
			FeatureSelect("fizpatrick_skin_type");
			FeatureSelect("smoker_in_house");
			CloseThePanelinGraphFromCategoryList("fizpatrick_skin_type");
			BasePage.click(mySelectionScreenOpen);

			//			WaitforValueInMySelectionFilter("FIZPATRICK_SKIN_TYPEfizpatrick_skin_type"); //dynamic value

			BasePage.click(GetDataButton);
			BasePage.click(mySelectionScreenClose);

			createPlot();

			DragAndDropBlank("smoker_in_house");  //dynamic value
			DragAndDropValuePresent("fizpatrick_skin_type");

			BasePage.click(Dataframe);			

			SelectPlotType("Treemap");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Treemap", "Treemap");
			GetHeader("Treemap of Smoker In House, Fizpatrick Skin Type");  //dynamic value

			SelectPlotType("Contingency table");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Contingency Table", "Contingency Table");
			GetHeader("Contingency Table of Smoker In House, Fizpatrick Skin Type");  //dynamic value

			SelectPlotType("Stacked Bar chart");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Stacked Bar chart", "Stacked Bar chart");
			GetHeaderXandY("Stacked Bar Chart of Smoker In House, Fizpatrick Skin Type","Smoker In House","Frequency");  //dynamic value

		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithTwoCategoricalFeaturesAloneWithoutVerification(String AnalysisName, String AnalysisDescription, String StudyIndex, String NoOfCategoricalValuesRequired, String NoOfNumericalValuesRequired) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);

			SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			

			try {
				mySelectionScreenClose.isDisplayed();
			}

			catch(Exception ex){
				System.out.println("My Selection Screen is open");	
			}

			finally {
				BasePage.click(mySelectionScreenOpen);
				BasePage.click(GetDataButton); //Click get button
				BasePage.click(mySelectionScreenClose); //Close my selection button

				BasePage.click(dataframeListViewButton);

				BasePage.click(dataframeCategoricalFeaturestab);
				int TotalNumberOfEntriesCat = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntriesCat);

				//1st Categorical value selection
				int RandomNumberCat1 = RandomValueGenerator(0,(TotalNumberOfEntriesCat-1));
				System.out.println(RandomNumberCat1);

				WebElement CategoricalFeatureSelected1 = valuesInDataframeInListview.get(RandomNumberCat1);
				String NameOfFeatureCat1 = valuesInDataframeInListview.get(RandomNumberCat1).getAttribute("id");
				System.out.println(NameOfFeatureCat1);


				int RandomNumberCat2;
				do {
					RandomNumberCat2 = RandomValueGenerator(0,(TotalNumberOfEntriesCat-1));
				}
				while(RandomNumberCat2==RandomNumberCat1);
				System.out.println(RandomNumberCat2);

				//2nd Categorical value selection
				WebElement CategoricalFeatureSelected2 = valuesInDataframeInListview.get(RandomNumberCat2);
				String NameOfFeatureCat2 = valuesInDataframeInListview.get(RandomNumberCat2).getAttribute("id");
				System.out.println(NameOfFeatureCat2);

				BasePage.click(Dataframe);

				createPlot();

				BasePage.click(Dataframe);	

				DragAndDropBlankNew(CategoricalFeatureSelected1); 
				DragAndDropValuePresentNew(CategoricalFeatureSelected2);

				BasePage.click(Dataframe);			

				String NameofCatFeatureCleansed1 = delimiterAndTitleCaseConversion(NameOfFeatureCat1);
				System.out.println(NameofCatFeatureCleansed1);

				String NameofCatFeatureCleansed2 = delimiterAndTitleCaseConversion(NameOfFeatureCat2);
				System.out.println(NameofCatFeatureCleansed2);			

				Thread.sleep(2000);

				int total_match_count = 3;

				SelectPlotType("Treemap");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Treemap", "Treemap");
				int t = GetHeader("Treemap of "+NameofCatFeatureCleansed1+", "+NameofCatFeatureCleansed2); 
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Treemap are verified");

				SelectPlotType("Contingency table");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Contingency Table", "Contingency Table");
				int c = GetHeader("Contingency Table of "+NameofCatFeatureCleansed1+", "+NameofCatFeatureCleansed2);  
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Contigency table are verified");

				SelectPlotType("Stacked Bar chart");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Stacked Bar chart", "Stacked Bar chart");
				int s = GetHeaderXandY("Stacked Bar Chart of "+NameofCatFeatureCleansed1+", "+NameofCatFeatureCleansed2,NameofCatFeatureCleansed1,"Frequency"); 
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Stacked Bar Chart are verified");

				assertEquals(t+c+s, total_match_count);
			}
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithTwoNumericalandOneCategoricalFeatures(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);

			//Need to find a way to have this as dynamic value
			EntitySelect("Subject_B");
			BasePage.click(mySelectionScreenClose);
			Thread.sleep(5000);
			FeatureSelect("age");
			FeatureSelect("subject_number");
			FeatureSelect("fizpatrick_skin_type");
			CloseThePanelinGraphFromCategoryList("fizpatrick_skin_type");
			BasePage.click(mySelectionScreenOpen);

			//			WaitforValueInMySelectionFilter("FIZPATRICK_SKIN_TYPEfizpatrick_skin_type"); //dynamic value

			BasePage.click(GetDataButton);
			BasePage.click(mySelectionScreenClose);

			createPlot();

			DragAndDropBlank("age");  //dynamic value
			DragAndDropValuePresent("subject_number");
			DragAndDropValuePresent("fizpatrick_skin_type");

			BasePage.click(Dataframe);			

			SelectPlotType("Coloured scatter plot");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Coloured scatter plot", "Coloured scatter plot");
			GetHeaderXandY("Coloured Scatter Plot of Age, Subject Number, Fizpatrick Skin Type","Age","Subject Number");  //dynamic value
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithTwoNumericalandOneCategoricalFeaturesAloneWithoutVerification(String AnalysisName, String AnalysisDescription, String StudyIndex, String NoOfCategoricalValuesRequired, String NoOfNumericalValuesRequired) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);

			SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			

			try {
				mySelectionScreenClose.isDisplayed();
			}

			catch(Exception ex){
				System.out.println("My Selection Screen is open");	
			}

			finally {
				BasePage.click(mySelectionScreenOpen);
				BasePage.click(GetDataButton); //Click get button
				BasePage.click(mySelectionScreenClose); //Close my selection button

				BasePage.click(dataframeListViewButton);

				BasePage.click(dataframeNumericalFeaturestab);
				int TotalNumberOfEntriesNum = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntriesNum);

				//1st numerical value selection
				int RandomNumberNum1 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				System.out.println(RandomNumberNum1);

				WebElement NumericalFeatureSelected1 = valuesInDataframeInListview.get(RandomNumberNum1);
				String NameOfFeatureNum1 = valuesInDataframeInListview.get(RandomNumberNum1).getAttribute("id");
				System.out.println(NameOfFeatureNum1);

				int RandomNumberNum2;
				do {
					RandomNumberNum2 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				}
				while(RandomNumberNum2==RandomNumberNum1);
				System.out.println(RandomNumberNum2);

				//2nd numerical value selection
				WebElement NumericalFeatureSelected2 = valuesInDataframeInListview.get(RandomNumberNum2);
				String NameOfFeatureNum2 = valuesInDataframeInListview.get(RandomNumberNum2).getAttribute("id");
				System.out.println(NameOfFeatureNum2);

				//Categorical value selection
				BasePage.click(dataframeCategoricalFeaturestab);

				int TotalNumberOfEntriesCat = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntriesCat);

				int RandomNumberCat = RandomValueGenerator(0,(TotalNumberOfEntriesCat-1));
				System.out.println(RandomNumberCat);

				WebElement CategoricalFeatureSelected = valuesInDataframeInListview.get(RandomNumberCat);
				String NameOfFeatureCat = valuesInDataframeInListview.get(RandomNumberCat).getAttribute("id");
				System.out.println(NameOfFeatureCat);

				BasePage.click(Dataframe);

				createPlot();

				BasePage.click(Dataframe);

				Thread.sleep(2000);

				int total_match_count = 1;

				String NameofNumFeatureCleansed1 = delimiterAndTitleCaseConversion(NameOfFeatureNum1);
				System.out.println(NameofNumFeatureCleansed1);

				String NameofNumFeatureCleansed2 = delimiterAndTitleCaseConversion(NameOfFeatureNum2);
				System.out.println(NameofNumFeatureCleansed2);	

				String NameofCatFeatureCleansed1 = delimiterAndTitleCaseConversion(NameOfFeatureCat);
				System.out.println(NameofCatFeatureCleansed1);	

				BasePage.click(dataframeAllFeaturestab);

				WebElement CategoricalFeatureSelectedFromAll = driver.findElement(By.xpath("//span[@id='"+NameOfFeatureCat+"']"));
				WebElement NumericalFeatureSelectedFromAll1 = driver.findElement(By.xpath("//span[@id='"+NameOfFeatureNum1+"']"));
				WebElement NumericalFeatureSelectedFromAll2 = driver.findElement(By.xpath("//span[@id='"+NameOfFeatureNum2+"']"));

				DragAndDropBlankNew(NumericalFeatureSelectedFromAll1);
				DragAndDropValuePresentNew(NumericalFeatureSelectedFromAll2);
				DragAndDropValuePresentNew(CategoricalFeatureSelectedFromAll);

				BasePage.click(Dataframe);			

				SelectPlotType("Coloured scatter plot");
				Thread.sleep(3000);
				screenShotForPass(AnalysisName + " - Coloured scatter plot", "Coloured scatter plot");
				int c = GetHeaderXandY("Coloured Scatter Plot of "+NameofNumFeatureCleansed1+", "+NameofNumFeatureCleansed2+", "+NameofCatFeatureCleansed1, NameofNumFeatureCleansed1, NameofNumFeatureCleansed2);  
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Coloured scatter plot are verified");

				assertEquals(c, total_match_count);
			}
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithThreeNumericalFeatures(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);

			//Need to find a way to have this as dynamic value
			EntitySelect("Subject_B");
			BasePage.click(mySelectionScreenClose);
			Thread.sleep(5000);
			FeatureSelect("age");
			FeatureSelect("subject_number");
			FeatureSelect("height");
			CloseThePanelinGraphFromCategoryList("height");
			BasePage.click(mySelectionScreenOpen);

			//			WaitforValueInMySelectionFilter("FIZPATRICK_SKIN_TYPEfizpatrick_skin_type"); //dynamic value

			BasePage.click(GetDataButton);
			BasePage.click(mySelectionScreenClose);

			createPlot();

			DragAndDropBlank("age");  //dynamic value
			DragAndDropValuePresent("subject_number");
			DragAndDropValuePresent("height");

			BasePage.click(Dataframe);			

			SelectPlotType("Scatter Plot Matrix");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Scatter Plot Matrix", "Scatter Plot Matrix");
			GetHeaderX3andY3("Scatter Plot Matrix of Age, Subject Number, Height","age","subject_number","height","age","subject_number","height");  //dynamic value
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithThreeNumericalFeaturesAloneWithoutVerification(String AnalysisName, String AnalysisDescription, String StudyIndex, String NoOfCategoricalValuesRequired, String NoOfNumericalValuesRequired) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);

			SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			

			try {
				mySelectionScreenClose.isDisplayed();
			}

			catch(Exception ex){
				System.out.println("My Selection Screen is open");	
			}

			finally {
				BasePage.click(mySelectionScreenOpen);
				BasePage.click(GetDataButton); //Click get button
				BasePage.click(mySelectionScreenClose); //Close my selection button

				BasePage.click(dataframeListViewButton);

				BasePage.click(dataframeNumericalFeaturestab);
				int TotalNumberOfEntriesNum = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntriesNum);

				//1st numerical value selection
				int RandomNumberNum1 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				System.out.println(RandomNumberNum1);

				WebElement NumericalFeatureSelected1 = valuesInDataframeInListview.get(RandomNumberNum1);
				String NameOfFeatureNum1 = valuesInDataframeInListview.get(RandomNumberNum1).getAttribute("id");
				System.out.println(NameOfFeatureNum1);


				int RandomNumberNum2;
				do {
					RandomNumberNum2 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				}
				while(RandomNumberNum2==RandomNumberNum1);
				System.out.println(RandomNumberNum2);

				//2nd numerical value selection
				WebElement NumericalFeatureSelected2 = valuesInDataframeInListview.get(RandomNumberNum2);
				String NameOfFeatureNum2 = valuesInDataframeInListview.get(RandomNumberNum2).getAttribute("id");
				System.out.println(NameOfFeatureNum2);

				int RandomNumberNum3;
				do {
					RandomNumberNum3 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				}
				while(RandomNumberNum3==RandomNumberNum1 || RandomNumberNum3==RandomNumberNum2);
				System.out.println(RandomNumberNum3);

				//3rd numerical value selection
				WebElement NumericalFeatureSelected3 = valuesInDataframeInListview.get(RandomNumberNum3);
				String NameOfFeatureNum3 = valuesInDataframeInListview.get(RandomNumberNum3).getAttribute("id");
				System.out.println(NameOfFeatureNum3);

				BasePage.click(Dataframe);

				createPlot();

				BasePage.click(Dataframe);

				DragAndDropBlankNew(NumericalFeatureSelected1); 
				DragAndDropValuePresentNew(NumericalFeatureSelected2);
				DragAndDropValuePresentNew(NumericalFeatureSelected3);

				BasePage.click(Dataframe);			

				String NameofNumFeatureCleansed1 = delimiterAndTitleCaseConversion(NameOfFeatureNum1);
				System.out.println(NameofNumFeatureCleansed1);

				String NameofNumFeatureCleansed2 = delimiterAndTitleCaseConversion(NameOfFeatureNum2);
				System.out.println(NameofNumFeatureCleansed2);

				String NameofNumFeatureCleansed3 = delimiterAndTitleCaseConversion(NameOfFeatureNum3);
				System.out.println(NameofNumFeatureCleansed3);

				Thread.sleep(2000);		

				int total_match_count = 1;

				SelectPlotType("Scatter Plot Matrix");
				Thread.sleep(3000);
				screenShotForPass(AnalysisName + " - Scatter Plot Matrix", "Scatter Plot Matrix");
				int s = GetHeaderX3andY3("Scatter Plot Matrix of "+NameofNumFeatureCleansed1+", "+NameofNumFeatureCleansed2+", "+NameofNumFeatureCleansed3,NameofNumFeatureCleansed1,NameofNumFeatureCleansed2,NameofNumFeatureCleansed3,NameofNumFeatureCleansed1,NameofNumFeatureCleansed2,NameofNumFeatureCleansed3);  
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Scatter Plot Matrix are verified");

				assertEquals(s, total_match_count);
			}
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithThreeNumericalandOneCategoricalFeatures(String AnalysisName, String AnalysisDescription, String StudyIndex) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);

			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);
			int NoOfEntities = EntityListInGraph.size();
			System.out.println(NoOfEntities);

			//Need to find a way to have this as dynamic value
			EntitySelect("Subject_B");
			BasePage.click(mySelectionScreenClose);
			Thread.sleep(5000);
			FeatureSelect("age");
			FeatureSelect("subject_number");
			FeatureSelect("height");
			FeatureSelect("fizpatrick_skin_type");
			CloseThePanelinGraphFromCategoryList("fizpatrick_skin_type");
			BasePage.click(mySelectionScreenOpen);

			//			WaitforValueInMySelectionFilter("FIZPATRICK_SKIN_TYPEfizpatrick_skin_type"); //dynamic value

			BasePage.click(GetDataButton);
			BasePage.click(mySelectionScreenClose);

			createPlot();

			DragAndDropBlank("age");  //dynamic value
			DragAndDropValuePresent("subject_number");
			DragAndDropValuePresent("height");
			DragAndDropValuePresent("fizpatrick_skin_type");

			BasePage.click(Dataframe);			

			SelectPlotType("Coloured Marginal plot");
			Thread.sleep(3000);
			screenShotForPass(AnalysisName + " - Coloured Marginal plot", "Coloured Marginal plot");
			GetHeaderX3andY3("Coloured Marginal Plot of Age, Subject Number, Height, Fizpatrick Skin Type","Height","Subject Number","Age","Height","Subject Number","Age");  //dynamic value and it is different from scatter plot 
		}
		catch(Exception | AssertionError ex) {
			throw ex;
		}
	}

	public void PlotWithThreeNumericalandOneCategoricalFeaturesAloneWithoutVerification(String AnalysisName, String AnalysisDescription, String StudyIndex, String NoOfCategoricalValuesRequired, String NoOfNumericalValuesRequired) throws Throwable{
		try {
			createAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			this.selectItemFortheList(AnalysisName);
			this.clickView();

			BasePage.waitforAnElement(StudyNode);

			SelectingValuesForPlotNewWithEntityNames(Integer.parseInt(NoOfCategoricalValuesRequired), Integer.parseInt(NoOfNumericalValuesRequired));			

			try {
				mySelectionScreenClose.isDisplayed();
			}

			catch(Exception ex){
				System.out.println("My Selection Screen is open");	
			}

			finally {
				BasePage.click(mySelectionScreenOpen);
				BasePage.click(GetDataButton); //Click get button
				BasePage.click(mySelectionScreenClose); //Close my selection button

				BasePage.click(dataframeListViewButton);

				BasePage.click(dataframeNumericalFeaturestab);
				int TotalNumberOfEntriesNum = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntriesNum);

				//1st numerical value selection
				int RandomNumberNum1 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				System.out.println(RandomNumberNum1);

				WebElement NumericalFeatureSelected1 = valuesInDataframeInListview.get(RandomNumberNum1);
				String NameOfFeatureNum1 = valuesInDataframeInListview.get(RandomNumberNum1).getAttribute("id");
				System.out.println(NameOfFeatureNum1);


				int RandomNumberNum2;
				do {
					RandomNumberNum2 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				}
				while(RandomNumberNum2==RandomNumberNum1);
				System.out.println(RandomNumberNum2);

				//2nd numerical value selection
				WebElement NumericalFeatureSelected2 = valuesInDataframeInListview.get(RandomNumberNum2);
				String NameOfFeatureNum2 = valuesInDataframeInListview.get(RandomNumberNum2).getAttribute("id");
				System.out.println(NameOfFeatureNum2);

				int RandomNumberNum3;
				do {
					RandomNumberNum3 = RandomValueGenerator(0,(TotalNumberOfEntriesNum-1));
				}
				while(RandomNumberNum3==RandomNumberNum1 || RandomNumberNum3==RandomNumberNum2);
				System.out.println(RandomNumberNum3);

				//3rd numerical value selection
				WebElement NumericalFeatureSelected3 = valuesInDataframeInListview.get(RandomNumberNum3);
				String NameOfFeatureNum3 = valuesInDataframeInListview.get(RandomNumberNum3).getAttribute("id");
				System.out.println(NameOfFeatureNum3);

				//Categorical value selection
				BasePage.click(dataframeCategoricalFeaturestab);

				int TotalNumberOfEntriesCat = valuesInDataframeInListview.size();
				System.out.println(TotalNumberOfEntriesCat);

				int RandomNumberCat = RandomValueGenerator(0,(TotalNumberOfEntriesCat-1));
				System.out.println(RandomNumberCat);

				WebElement CategoricalFeatureSelected = valuesInDataframeInListview.get(RandomNumberCat);
				String NameOfFeatureCat = valuesInDataframeInListview.get(RandomNumberCat).getAttribute("id");
				System.out.println(NameOfFeatureCat);

				BasePage.click(Dataframe);

				createPlot();

				BasePage.click(Dataframe);

				BasePage.click(dataframeAllFeaturestab);

				WebElement CategoricalFeatureSelectedFromAll = driver.findElement(By.xpath("//span[@id='"+NameOfFeatureCat+"']"));
				WebElement NumericalFeatureSelectedFromAll1 = driver.findElement(By.xpath("//span[@id='"+NameOfFeatureNum1+"']"));
				WebElement NumericalFeatureSelectedFromAll2 = driver.findElement(By.xpath("//span[@id='"+NameOfFeatureNum2+"']"));
				WebElement NumericalFeatureSelectedFromAll3 = driver.findElement(By.xpath("//span[@id='"+NameOfFeatureNum3+"']"));

				DragAndDropBlankNew(NumericalFeatureSelectedFromAll1);
				DragAndDropValuePresentNew(NumericalFeatureSelectedFromAll2);
				DragAndDropValuePresentNew(NumericalFeatureSelectedFromAll3);
				DragAndDropValuePresentNew(CategoricalFeatureSelectedFromAll);

				BasePage.click(Dataframe);			

				String NameofNumFeatureCleansed1 = delimiterAndTitleCaseConversion(NameOfFeatureNum1);
				System.out.println(NameofNumFeatureCleansed1);

				String NameofNumFeatureCleansed2 = delimiterAndTitleCaseConversion(NameOfFeatureNum2);
				System.out.println(NameofNumFeatureCleansed2);

				String NameofNumFeatureCleansed3 = delimiterAndTitleCaseConversion(NameOfFeatureNum3);
				System.out.println(NameofNumFeatureCleansed3);

				String NameofCatFeatureCleansed = delimiterAndTitleCaseConversion(NameOfFeatureCat);
				System.out.println(NameofCatFeatureCleansed);

				Thread.sleep(2000);

				int total_match_count = 1;

				SelectPlotType("Coloured Marginal plot");
				Thread.sleep(2000);
				screenShotForPass(AnalysisName + " - Coloured Marginal plot", "Coloured Marginal plot");
				int c = GetHeaderX3andY3("Coloured Marginal Plot of "+NameofNumFeatureCleansed1+", "+NameofNumFeatureCleansed2+", "+NameofNumFeatureCleansed3+", "+NameofCatFeatureCleansed,NameofNumFeatureCleansed3,NameofNumFeatureCleansed2,NameofNumFeatureCleansed1,NameofNumFeatureCleansed3,NameofNumFeatureCleansed2,NameofNumFeatureCleansed1);
				ExtentTestManager.getTest().log(Status.PASS, "Labels in Coloured Marginal Plot are verified");

				assertEquals(c, total_match_count);
			}
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

	public static int getRandomNumberExcludingMax(int minValue, int maxValue) {
		int RandomE = (minValue) + (int)(Math.random()*(maxValue - minValue));
		System.out.println(RandomE);
		return RandomE;
	}



















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

	public void MyDragAndDropOffset(WebElement source, int offsetX, int offsetY)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(source, offsetX, offsetY).build().perform();
	}

	public static void dragAndDrop(WebElement from, WebElement to) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", from, to);
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
