package com.eagle.TestCases;

import java.awt.AWTException;
import java.awt.List;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.pages.AnalysisPage;


public class AnalysisTest extends BaseTest{

	AnalysisPage objAnalysisPage; 

	Date dt = new Date();
	DateFormat dtFrmt = new SimpleDateFormat("_HHmmss");
	String dtText = dtFrmt.format(dt);

	@BeforeClass
	public void beforeClass() throws AWTException, InterruptedException  {	
		objAnalysisPage = new AnalysisPage();		
	}

//		@Test(priority = 0, description = "Create Analysis")
//		public void CreateAnalysis_Test() throws Throwable {
//			try {
//	
//				//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
//				//
//				//			System.out.println(functionName);
//				//			String value = this.getConfiguration().get(functionName);
//				//			String[] AnaParameters =value.split(",");
//				//			String AnalysisName = AnaParameters[0].trim()+dtText;
//				//			String AnalysisDescription = AnaParameters[1].trim();
//				////		String studyName = AnaParameters[2].trim();
//				//			String studyIndex = AnaParameters[2].trim();
//	
//				/* Creates an Analysis */	
//				//			objAnalysisPage.createAnalysis(AnalysisName,AnalysisDescription,studyName);
//				//			objAnalysisPage.createAnalysis("Analysis-1","Analysis Description","Eagle Study A");
//	
//				//			objAnalysisPage.createAnalysis2(AnalysisName,AnalysisDescription,studyIndex);
//				objAnalysisPage.createAnalysis2("Analysis-1","Analysis Description","2");
//	
//				onSuccessMeassage("AnalysisCreation");
//			}
//			catch(Throwable ex)
//			{
//				objAnalysisPage.captureScreenshot("createAnalysisFail");
//				onFailureMeassage(ex.getMessage(),"createAnalysisFail","createAnalysisFail");
//			}
//		}	
	//
	//
	//	@Test(priority = 1, description = "Check mandatory fields before create Analysis")
	//	public void CreateAnalysisMandatoryCheck_Test() throws Throwable {
	//		try {
	//
	//			//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//			//
	//			//			System.out.println(functionName);
	//			//			String value = this.getConfiguration().get(functionName);
	//			//			String[] AnaParameters =value.split(",");
	//			//			String AnalysisName = AnaParameters[0].trim()+dtText;
	//			//			String AnalysisDescription = AnaParameters[1].trim();
	//			////		String studyName = AnaParameters[2].trim();
	//			//			String StudyIndex = AnaParameters[2].trim();
	//
	//
	//			/* Creates an Analysis after performing mandatory check */	
	//			//			objAnalysisPage.checkMandatoryfieldsinAnalysis(AnalysisName,AnalysisDescription,studyName);
	//			//			objAnalysisPage.checkMandatoryfieldsinAnalysis("Analysis-2", "Test Description for Analysis Check", "Eagle Study A");
	//
	//			//			objAnalysisPage.checkMandatoryfieldsinAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
	//			objAnalysisPage.checkMandatoryfieldsinAnalysis2("Analysis-2", "Test Description for Analysis Check", "3");
	//			
	//			onSuccessMeassage("Create Analysis - after mandatory fields were verified");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("CreateAnalysisMandatoryCheckFail");
	//			onFailureMeassage(ex.getMessage(),"CreateAnalysisMandatoryCheckFail","CreateAnalysisMandatoryCheckFail");
	//		}
	//	}

	//	@Test(priority = 2, description = "Edit Analysis Name and Description from Analysis List")
	//	public void AnalysisNameAndDescEditInList_Test() throws Throwable {
	//		try {
	//
	//			//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//			//
	//			//			System.out.println(functionName);
	//			//			String value = this.getConfiguration().get(functionName);
	//			//			String[] AnaParameters = value.split(",");
	//			//			String AnalysisNameInital = AnaParameters[0].trim()+dtText;
	//			//			String AnalysisDescriptionInital = AnaParameters[1].trim();
	//			////		String StudyName = AnaParameters[2].trim();
	//			//			String StudyIndex = AnaParameters[2].trim();
	//			//			String AnalysisName = AnaParameters[3].trim()+dtText;
	//			//			String AnalysisDescription = AnaParameters[4].trim();
	//
	//
	//			/* Edit Analysis Name and Description in list page */	 
	//			//		objAnalysisPage.AnalysisNameAndDescEditInList(AnalysisNameInital, AnalysisDescriptionInital, StudyName, AnalysisName, AnalysisDescription);
	//			//		objAnalysisPage.AnalysisNameAndDescEditInList("Analysis-3","Analysis Description","Eagle Study A","Name of [Analysis>: is changed", "Description of [Analysis>: is changed");
	//
	//			//		objAnalysisPage.AnalysisNameAndDescEditInList2(AnalysisNameInital, AnalysisDescriptionInital, StudyIndex, AnalysisName, AnalysisDescription);
	//			objAnalysisPage.AnalysisNameAndDescEditInList2("Analysis-3","Analysis Description","1","Name of [Analysis>: is changed", "Description of [Analysis>: is changed");
	//
	//			onSuccessMeassage("An analysis is created and the name, description and study are edited successfully");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("AnalysisNameAndDescEditInListFail");
	//			onFailureMeassage(ex.getMessage(),"AnalysisNameAndDescEditInListFail","AnalysisNameAndDescEditInListFail");
	//		}
	//	}

	//
	//	@Test(priority = 3, description = "Edit Analysis Name and Description from Analysis Page")
	//	public void AnalysisNameAndDescEditInPage_Test() throws Throwable {
	//		try {
	//
	//			//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//			//
	//			//			System.out.println(functionName);
	//			//			String value = this.getConfiguration().get(functionName);
	//			//			String[] AnaParameters =value.split(",");
	//			//			String AnalysisNameInital = AnaParameters[0].trim()+dtText;
	//			//			String AnalysisDescriptionInital = AnaParameters[1].trim();
	//			//			String StudyName = AnaParameters[2].trim();
	//			//			String StudyIndex = AnaParameters[2].trim();
	//			//			String AnalysisName = AnaParameters[3].trim()+dtText;
	//			//			String AnalysisDescription = AnaParameters[4].trim();
	//
	//
	//			/* Edit Analysis Name and Description in list page */	 
	//			//			objAnalysisPage.AnalysisNameAndDescEditInPage(AnalysisNameInital, AnalysisDescriptionInital, StudyName, AnalysisName, AnalysisDescription);
	//			//			objAnalysisPage.AnalysisNameAndDescEditInPage("Analysis-4","Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far","Eagle Study A","Name of ()@#$Analysis{}: is changed", "Description small", "Description of ()@#$Analysis{}: is changed");
	//
	//			//			objAnalysisPage.AnalysisNameAndDescEditInPage2(AnalysisNameInital, AnalysisDescriptionInital, StudyIndex, AnalysisName, AnalysisDescription);
	//			objAnalysisPage.AnalysisNameAndDescEditInPage2("Analysis-4","Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far","3","Name of ()@#$Analysis{}: is changed", "Description small", "Description of ()@#$Analysis{}: is changed");
	//			onSuccessMeassage("An analysis is created and the name, description and study are editted successfully");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("AnalysisNameAndDescEditInPageFail");
	//			onFailureMeassage(ex.getMessage(),"AnalysisNameAndDescEditInPageFail","AnalysisNameAndDescEditInPageFail");
	//		}
	//	}


	//	@Test(priority = 4, description = "Create and Delete Analysis")
	//	public void CreateAndDeleteAnalysis_Test() throws Throwable {
	//		try {
	//
	//			//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//			//
	//			//			System.out.println(functionName);
	//			//			String value = this.getConfiguration().get(functionName);
	//			//			String[] AnaParameters =value.split(",");
	//			//			String AnalysisName = AnaParameters[0].trim()+dtText;
	//			//			String AnalysisDescription = AnaParameters[1].trim();
	//			////		String StudyName = AnaParameters[2].trim();
	//			//			String StudyIndex = AnaParameters[2].trim();
	//
	//			/* Edit Analysis Name and Description inside Analysis */	 
	//			//		objAnalysisPage.CreateAndDeleteAnalysis(AnalysisName,AnalysisDescription,StudyName);
	//			//		objAnalysisPage.CreateAndDeleteAnalysis("Analysis-5", "Analysis Delete Description with greater than 60 letter text", "Eagle Study A");
	//
	//			//		objAnalysisPage.CreateAndDeleteAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
	//			objAnalysisPage.CreateAndDeleteAnalysis2("Analysis-5", "Analysis Delete Description with greater than 60 letter text", "4");
	//			onSuccessMeassage("Analysis is Created and Deleted");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("AnalysisCreateandDeleteFail");
	//			onFailureMeassage(ex.getMessage(),"AnalysisCreateandDeleteFail","AnalysisCreateandDeleteFail");
	//		}
	//	}	

//			@Test(priority = 5, description = "Verifying the graph canvas")
//			public void VerifyGraphCanvas_Test() throws Throwable {
//				try {
//		
//					String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
//		
//					System.out.println(functionName);
//					String value = this.getConfiguration().get(functionName);
//					String[] AnaParameters =value.split(",");
//					String AnalysisName = AnaParameters[0].trim()+dtText;
//					String AnalysisDescription = AnaParameters[1].trim();
//	//				String StudyName = AnaParameters[2].trim();
//					String StudyIndex = AnaParameters[2].trim();
//	
//		
//					/* Verify the presence of Graph Canvas and its contents */	
//	//				objAnalysisPage.VerifyGraphCanvasInAnalysis(AnalysisName,AnalysisDescription,StudyName,NoOfEntities,EntityNames);
//	//				objAnalysisPage.VerifyGraphCanvasInAnalysis("Graph Canvas Analysis", "Graph Canvas Analysis", "Eagle Study A","5","The Study", "Trial", "Organism", "Subject", 'Measurement');
//					
//					objAnalysisPage.VerifyGraphCanvasInAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
//	//				objAnalysisPage.VerifyGraphCanvasInAnalysis2("Graph Canvas Analysis", "Graph Canvas Analysis", "2","5","The Study", "Trial", "Organism", "Subject", 'Measurement');
//					onSuccessMeassage("Graph Canvas is successfully verified");
//				}
//				catch(Throwable ex)
//				{
//					objAnalysisPage.captureScreenshot("GraphCanvasVerificationFail");
//					onFailureMeassage(ex.getMessage(),"GraphCanvasVerificationFail","GraphCanvasVerificationFail");
//				}
//			}

//	@Test(priority = 6, description = "Verifying resizing of graph canvas")
//	public void VerifyResizingOfGraph_Test() throws Throwable {
//		try {
//			//			
//			//						String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
//			//			
//			//						System.out.println(functionName);
//			//						String value = this.getConfiguration().get(functionName);
//			//						String[] AnaParameters =value.split(",");
//			//						String AnalysisName = AnaParameters[0].trim()+dtText;
//			//						String AnalysisDescription = AnaParameters[1].trim();
//			////					String StudyName = AnaParameters[2].trim();
//			//						String StudyIndex = AnaParameters[2].trim();
//
//
//			/* Verify the resizing of Graph canvas*/	
//			//			objAnalysisPage.VerifyNumericalValueAnalysis(AnalysisName,AnalysisDescription,StudyName);
//			//			objAnalysisPage.VerifyResizingOfGraphAnalysis("Resizing Graph Canvas Analysis", "Resizing Graph Canvas Analysis", "Eagle Study A");
//
//			//			objAnalysisPage.VerifyNumericalValueAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
//			objAnalysisPage.VerifyResizingOfGraphAnalysis2("Resizing Graph Canvas Analysis", "Resizing Graph Canvas Analysis", "3");
//			onSuccessMeassage("Resizing Graph Canvas is successfully verified");
//		}
//		catch(Throwable ex)
//		{
//			objAnalysisPage.captureScreenshot("ResizingGraphCanvasVerificationFail");
//			onFailureMeassage(ex.getMessage(),"ResizingGraphCanvasVerificationFail","ResizingGraphCanvasVerificationFail");
//		}
//	}

	@Test(priority = 7, description = "Verify selection of features in Analysis")
	public void VerifySelectingFeaturesInAnalysis_Test() throws Throwable {
		try {
			//
			//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
			//
			//			System.out.println(functionName);
			//			String value = this.getConfiguration().get(functionName);
			//			String[] AnaParameters =value.split(",");
			//			String AnalysisName = AnaParameters[0].trim()+dtText;
			//			String AnalysisDescription = AnaParameters[1].trim();
			//			String StudyName = AnaParameters[2].trim();
			//			String EntityName = AnaParameters[3].trim();
			//			String FeatureName = AnaParameters[4].trim();
			
			

			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
			//			objAnalysisPage.SelectFeatures(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
			objAnalysisPage.SelectFeatures("Numerical Value Analysis", "Numerical Value Analysis", "2","3");
			onSuccessMeassage("Numerical Value is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("FeatureSelectionFail");
			onFailureMeassage(ex.getMessage(),"FeatureSelectionFail","FeatureSelectionFail");
		}
	}	
	
	
//		@Test(priority = 7, description = "Verify a Numerical Value in Analysis")
//		public void VerifyNumericalValueAnalysis_Test() throws Throwable {
//			try {
//				//
//				//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
//				//
//				//			System.out.println(functionName);
//				//			String value = this.getConfiguration().get(functionName);
//				//			String[] AnaParameters =value.split(",");
//				//			String AnalysisName = AnaParameters[0].trim()+dtText;
//				//			String AnalysisDescription = AnaParameters[1].trim();
//				//			String StudyName = AnaParameters[2].trim();
//				//			String EntityName = AnaParameters[3].trim();
//				//			String FeatureName = AnaParameters[4].trim();
//				
//				
//	
//				/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
//				//			objAnalysisPage.VerifyNumericalValueAnalysis(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
//				objAnalysisPage.VerifyNumericalValueAnalysis("Numerical Value Analysis", "Numerical Value Analysis", "Eagle Study A","Subject","body_mass_index");
//				onSuccessMeassage("Numerical Value is successfully verified");
//			}
//			catch(Throwable ex)
//			{
//				objAnalysisPage.captureScreenshot("NumericalValueVerificationFail");
//				onFailureMeassage(ex.getMessage(),"NumericalValueVerificationFail","NumericalValueVerificationFail");
//			}
//		}	


//		@Test(priority = 8, description = "Verify a Categorical Value in Analysis")
//		public void VerifyCategoticalValueAnalysis_Test() throws Throwable {
//			try {
//				//
//				//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
//				//
//				//			System.out.println(functionName);
//				//			String value = this.getConfiguration().get(functionName);
//				//			String[] AnaParameters =value.split(",");
//				//			String AnalysisName = AnaParameters[0].trim()+dtText;
//				//			String AnalysisDescription = AnaParameters[1].trim();
//				//			String StudyName = AnaParameters[2].trim();
//				//			String EntityName = AnaParameters[3].trim();
//				//			String FeatureName = AnaParameters[4].trim();
//	
//				/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
//				//			objAnalysisPage.VerifyNumericalValueAnalysis(AnalysisName,AnalysisDescription,StudyName,EntityName, FeatureName);
//				objAnalysisPage.VerifyCategoricalValueAnalysis("Categorical Value Analysis", "Categorical Value Analysis", "Eagle Study A","Subject","disease");
//				onSuccessMeassage("Categorical Value is successfully verified");
//			}
//			catch(Throwable ex)
//			{
//				objAnalysisPage.captureScreenshot("CategoricalValueVerificationFail");
//				onFailureMeassage(ex.getMessage(),"CategoricalValueVerificationFail","CategoricalValueVerificationFail");
//			}
//		}	

	//	@Test(priority = 9, description = "Select Categorical and Numerical features")
	//	public void SelectCategoricalAndNumericalFeatures_Test() throws Throwable {
	//		try {
	//
	//			//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//			//
	//			//			System.out.println(functionName);
	//			//			String value = this.getConfiguration().get(functionName);
	//			//			String[] AnaParameters =value.split(",");
	//			//			String AnalysisName = AnaParameters[0].trim()+dtText;
	//			//			String AnalysisDescription = AnaParameters[1].trim();
	//			//			String StudyName = AnaParameters[2].trim();
	//			//			String NoOfEntityAndFeaturePairs = AnaParameters[3].trim();
	//			//
	//			//			int Size = AnaParameters.length;
	//			//			ArrayList<String> EntityNames = new ArrayList<String>();
	//			//			ArrayList<String> FeatureNames = new ArrayList<String>();
	//			//
	//			//			for (int i=4;i<=Size-2;i=i+2) {
	//			//				System.out.println(AnaParameters[i].trim());
	//			//				EntityNames.add(AnaParameters[i].trim());
	//			//			}
	//			//
	//			//			for (int i=5;i<=Size-1;i=i+2) {
	//			//				System.out.println(AnaParameters[i].trim());
	//			//				FeatureNames.add(AnaParameters[i].trim());
	//			//			}
	//
	//			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
	//			//			objAnalysisPage.SelectCategoricalAndNumericalFeatures(AnalysisName,AnalysisDescription,StudyName,EntityName, FeatureName);
	//			objAnalysisPage.SelectCategoricalAndNumericalFeatures("Feature Selection Analysis", "Feature Selection Analysis","Eagle Study A","2","Subject","disease","Subject","body_mass_index");
	//			onSuccessMeassage("Categorical Value is successfully verified");
	//		}
	//		catch(Throwable ex)
	//		{
	//			objAnalysisPage.captureScreenshot("CategoricalValueVerificationFail");
	//			onFailureMeassage(ex.getMessage(),"CategoricalValueVerificationFail","CategoricalValueVerificationFail");
	//		}
	//	}	


























	//	@Test(priority = 4, description = "Create Comparison with Control & Case and Run Comparison")
	//	public void createComparisonWithControlandCaseRunComparison_Test() throws Throwable {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String CaseSetName = AnaParameters[2].trim();
	//			String entity = AnaParameters[3].trim();
	//			String searchInControl = AnaParameters[4].trim();
	//			String searchInCase = AnaParameters[5].trim();
	//
	//			/* Creates an Comparison with Control & Case and Run Comparison */		 
	//			objAnalysisPage.createComparisonWithcontrolandCaseRunComparison(ComName,ControlSetName,CaseSetName,entity,searchInControl,searchInCase);
	//			//			objAnalysisPage.createComparisonWithcontrolandCaseRunComparison("Comparison Control and Case 2", "Control Set", "Case Set","Disease", "kera","buy");
	//			onSuccessMeassage("Comparison is Created Successfully with Control & Case Card - Comaparison Run is done");
	//		}
	//		catch(Throwable ex)
	//		{
	//			objAnalysisPage.captureScreenshot("createComparisonWithControlandCaseRunFail");
	//			onFailureMeassage(ex.getMessage(),"createComparisonWithControlandCaseRunFail","createComparisonWithControlandCaseRunFail");
	//		}
	//	}	
	//
	//	@Test(priority = 5, description = "Update an Existing Comparison with a case Card")
	//	public void updateComparisonWithCaseCard_Test() throws Throwable {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim();
	//			String entity = AnaParameters[1].trim();
	//			String CaseSetName = AnaParameters[2].trim();
	//			String searchTextInCase = AnaParameters[3].trim();
	//
	//			/* Updates an existing Comparison with a Case Card */	
	//			objAnalysisPage.updateComparisonWithCaseCard(ComName,entity,CaseSetName,searchTextInCase);
	//			//			objAnalysisPage.updateComparisonWithCaseCard("Comparison Control and Case 1", "Disease", "Case Set2","soy");
	//			onSuccessMeassage("Comparison is updated Successfully with a Case Card");
	//		}
	//		catch(Throwable ex)
	//		{
	//			objAnalysisPage.captureScreenshot("updateComparisonWithCaseCardFail");
	//			onFailureMeassage(ex.getMessage(),"updateComparisonWithCaseCardFail","updateComparisonWithCaseCardFail");
	//		}
	//	}	
	//
	//	@Test(priority = 6, description = "Search A Text In Comparison Expand")
	//	public void SearchInComparisonExpand_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//			String searchTextInExpand = AnaParameters[4].trim();
	//
	//			/* To Search a Text in Expanded Comparison */
	//			objAnalysisPage.searchInComparisonExpand(ComName, ControlSetName,entity,searchTextInControl,searchTextInExpand);
	//			//			objAnalysisPage.searchInComparisonExpand("search Comparison","Control Set" ,"Disease", "kera", "le");
	//			onSuccessMeassage("Search successful in Set Expand");
	//		}
	//		catch(Exception ex)
	//		{
	//			objAnalysisPage.captureScreenshot("SearchInSetExpandFail");
	//			onFailureMeassage(ex.getMessage(),"SearchInSetExpandFail","SearchInSetExpandFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("SearchInSetExpandFail");
	//			onFailureMeassage(ex.getMessage(),"SearchInSetExpandFail","SearchInSetExpandFail");
	//		}
	//	}
	//
	//	@Test(priority = 7, description = "Delete Card in Comparison Expand")
	//	public void DeleteCardInComparisonExpand_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//
	//			/* Delete Set from Expanded Set */
	//			objAnalysisPage.DeleteExploraionInExpand(ComName, ControlSetName,entity,searchTextInControl);
	//			//			objAnalysisPage.DeleteExploraionInExpand("DComparison2", "Control Set","Disease", "kera");
	//			onSuccessMeassage("Delete Card from Expanded Comparison");
	//		}
	//		catch(Exception ex)
	//		{
	//			objAnalysisPage.captureScreenshot("DeleteComparisonInExpandFail");
	//			onFailureMeassage(ex.getMessage(),"DeleteComparisonInExpandFail","DeleteComparisonInExpandFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("DeleteComparisonInExpandFail");
	//			onFailureMeassage(ex.getMessage(),"DeleteComparisonInExpandFail","DeleteComparisonInExpandFail");
	//		}		
	//	}
	//
	//	@Test(priority = 8, description = "Delete The first Card in Comparison")
	//	public void DeleteComparisonFirstCard_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//
	//			/* Delete The first Card (control) in Comparison */
	//			objAnalysisPage.deleteComparisonInFirstCard(ComName,ControlSetName,entity,searchTextInControl);
	//			//			objAnalysisPage.deleteComparisonInFirstCard("DComparison1Card", "Control Set", "Disease", "kera");
	//			onSuccessMeassage("Deleted The first Card in Comparison Successfully");
	//		}
	//		catch(Exception ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonFirstCardDeleteFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonFirstCardDeleteFail","ComparisonFirstCardDeleteFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonFirstCardDeleteFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonFirstCardDeleteFail","ComparisonFirstCardDeleteFail");
	//		}
	//	}
	//
	//	@Test(priority = 9, description = "Delete The Second Card in Comparison")
	//	public void DeleteComparisonSecondCard_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String CaseSetName = AnaParameters[2].trim();
	//			String entity = AnaParameters[3].trim();
	//			String searchTextInControl = AnaParameters[4].trim();
	//			String searchTextInCase = AnaParameters[5].trim();
	//
	//			/* Delete The Second Card (case) in Comparison */
	//			objAnalysisPage.deleteComparisonInLaterCard(ComName,ControlSetName,CaseSetName,entity,searchTextInControl,searchTextInCase);
	//			//			objAnalysisPage.deleteComparisonInLaterCard("DComparison2Card", "Control Card","Case Card" ,"Disease", "kera","lor");
	//			onSuccessMeassage("Deleted The first Card in Comparison Successfully");
	//		}
	//		catch(Exception ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonSecondCardDeleteFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonSecondCardDeleteFail","ComparisonSecondCardDeleteFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonSecondCardDeleteFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonSecondCardDeleteFail","ComparisonSecondCardDeleteFail");
	//		}
	//	}
	//
	//	@Test(priority = 10, description = "Comparison - Expand and add items from Catalog")
	//	public void ComparisonExpandAddFromCatalog_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//			String searchTextInCatalog = AnaParameters[4].trim();
	//
	//			/* Set - Expand and add items from Catalog */
	//			objAnalysisPage.ExpandAddFromCatalog(ComName,ControlSetName,entity,searchTextInControl,searchTextInCatalog);
	//			//			objAnalysisPage.ExpandAddFromCatalog("ComAddFromCatalog", "Control Card", "Disease", "aber", "worm");
	//			objAnalysisPage.saveChanges();
	//			onSuccessMeassage("Items Added from Catalog into Comparison successfully");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			BasePage.scrollToTop();
	//			objAnalysisPage.captureScreenshot("ComparisonExpandAddFromCatalogFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromCatalogFail","ComparisonExpandAddFromCatalogFail");
	//		}
	//	}
	//
	//	@Test(priority = 11, description = "Comparison - Expand and add items from Set")
	//	public void ComparisonExpandAddFromSet_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String BaseSetName = AnaParameters[0].trim()+dtText;
	//			String entity = AnaParameters[1].trim();
	//			String searchTextInSet = AnaParameters[2].trim();
	//			String ComName = AnaParameters[3].trim()+dtText;
	//			String ControlSetName = AnaParameters[4].trim();
	//			String searchTextInControl = AnaParameters[5].trim();
	//
	//			/* Comparison - Expand and add items from Set */
	//			objAnalysisPage.ExpandAddFromSet(BaseSetName,entity, searchTextInSet, ComName,ControlSetName,searchTextInControl); 
	//			//			objAnalysisPage.ExpandAddFromSet("SetAdd 1", "Disease", "aber", "ComAddFromSet",  "Control Card", "dol"); 
	//			objAnalysisPage.saveChanges();
	//			onSuccessMeassage("Items Added from Set into Comparison successfully");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonExpandAddFromSetFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromSetFail","ComparisonExpandAddFromSetFail");
	//		}
	//	}
	//
	//	@Test(priority = 12, description = "Comparison - Expand and add items from File")
	//	public void ComparisonExpandAddFromFile_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters = value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//			String fileUploadEntity = AnaParameters[4].trim();
	//			String fileLocation = AnaParameters[5].trim();
	//			String fileName = AnaParameters[6].trim();
	//
	//			/* Comparison - Expand and add items from File */
	//			objAnalysisPage.ExpandAddFromFile(ComName,ControlSetName,entity,searchTextInControl,fileUploadEntity, fileLocation,fileName);
	//			//			objAnalysisPage.ExpandAddFromFile("ComAddfromFile 1","Control Card", "Disease","kera","Disease", "C:\\Users\\MugunthRaman\\git\\EagleAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx", "Q4 - Upload file - 1 (2).xlsx");
	//			objAnalysisPage.saveChanges();
	//			onSuccessMeassage("Items Added from File into Comparison successfully");
	//		}
	//		catch(Exception ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonExpandAddFromFileFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromFileFail","ComparisonExpandAddFromFileFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonExpandAddFromFileFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonExpandAddFromFileFail","ComparisonExpandAddFromFileFail");
	//		}
	//	}
	//
	//	@Test(priority = 13, description = "Comparison - Create with multiple Case Cards")
	//	public void ComparisonCreateMultipleCaseCards_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters = value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//			String NoOfCaseCardstocreate = AnaParameters[4].trim();
	//
	//			/* Comparison - Create with multiple Cards */		
	//			objAnalysisPage.createComparisonWithControlandMultipleCase(ComName, ControlSetName,entity, searchTextInControl, Integer.parseInt(NoOfCaseCardstocreate));
	//			//			objAnalysisPage.createComparisonWithControlandMultipleCase("CompRela 2", "Control Set",  "Disease", "kera", 2);
	//			onSuccessMeassage("Comparison Created and added with multiple Case Cards Successfully");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonAdd2RelationFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonAdd2RelationFail","ComparisonAdd2RelationFail");
	//		}
	//	}
	//
	//	@Test(priority = 14, description = "Comparison - Create with multiple Case Cards and Run Comparison")
	//	public void ComparisonCreateMultipleCaseCardsRunComparison_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters = value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//			String NoOfCaseCardstocreate = AnaParameters[4].trim();
	//
	//			/* Comparison - Create with multiple Cards with Run Comparison */
	//			objAnalysisPage.createComparisonWithControlandMultipleCaseRunComparison(ComName, ControlSetName,entity,searchTextInControl,Integer.parseInt(NoOfCaseCardstocreate));
	//			//			objAnalysisPage.createComparisonWithControlandMultipleCaseRunComparison("CompRela 3", "Control Set",  "Disease", "kera", 3);
	//			onSuccessMeassage("Comparison Created and added with multiple Case Cards Run comparison Successfully");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonAdd2RelationFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonAdd2RelationFail","ComparisonAdd2RelationFail");
	//		}
	//	}
	//
	//	@Test(priority = 15, description = "Create And Delete An Comparison")
	//	public void CreateAndDeleteComparison_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//
	//			/* Create And Delete An Comparison */ 
	//			objAnalysisPage.createAndDeleteComparison(ComName,ControlSetName,entity,searchTextInControl);
	//			//			objAnalysisPage.createAndDeleteComparison("Delete Com1", "Control Set", "Disease","kera");
	//			onSuccessMeassage("Created And Deleted An Comparison Successfully");
	//		}
	//		catch(Exception ex)
	//		{
	//			objAnalysisPage.captureScreenshot("CreateAndDeleteComparisonFail");
	//			onFailureMeassage(ex.getMessage(),"CreateAndDeleteComparisonFail","CreateAndDeleteComparisonFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("CreateAndDeleteComparisonFail");
	//			onFailureMeassage(ex.getMessage(),"CreateAndDeleteComparisonFail","CreateAndDeleteComparisonFail");
	//		}
	//	}
	//
	//	@Test(priority = 16, description = "Create And Share An Comparison")
	//	public void CreateAndShareComparison_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//			String mailIDtoShareto = AnaParameters[4].trim();
	//
	//			/* Create And Share An Comparison */ 
	//			objAnalysisPage.createAndShareComparison(ComName, ControlSetName,entity,searchTextInControl,mailIDtoShareto);
	//			//			objAnalysisPage.createAndShareComparison("Share Com1", "Control Set","Disease","kera","mugunth.raman@eaglegenomics.com");
	//			onSuccessMeassage("Created And Shared An Comparison Successfully");
	//		}
	//		catch(Exception ex)
	//		{
	//			objAnalysisPage.captureScreenshot("CreateAndShareComparisonFail");
	//			onFailureMeassage(ex.getMessage(),"CreateAndShareComparisonFail","CreateAndShareComparisonFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("CreateAndShareComparisonFail");
	//			onFailureMeassage(ex.getMessage(),"CreateAndShareComparisonFail","CreateAndShareComparisonFail");
	//		}
	//	}
	//
	//	@Test(priority = 17, description = "Delete A Comparison")
	//	public void DeleteComparison_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim();
	//
	//			/* Delete A Comparison */
	//			objAnalysisPage.DeleteComparison(ComName);
	//			//			objAnalysisPage.DeleteComparison("search Comparison");
	//			onSuccessMeassage("Deleted A Comparison Successfully");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("DeleteComparisonFail");
	//			onFailureMeassage(ex.getMessage(),"DeleteComparisonFail","DeleteComparisonFail");
	//		}
	//	}
	//
	//	@Test(priority = 18, description = "Sharing A Comparison")
	//	public void ShareComparison_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim();
	//			String mailIDtoShareto = AnaParameters[1].trim();
	//
	//			/* Share A Comparison */
	//			objAnalysisPage.ShareComparison(ComName,mailIDtoShareto);
	//			//			objAnalysisPage.ShareComparison("ComAddfromFile 1","mugunth.raman@eaglegenomics.com");
	//			onSuccessMeassage("Shared A Comparison Successfully");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ShareComparisonFail");
	//			onFailureMeassage(ex.getMessage(),"ShareComparisonFail","ShareComparisonFail");
	//		}
	//	}
	//
	//	@Test(priority = 19, description = "Remove items from Comparison Expand")
	//	public void RemoveItemsfromComparison_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchTextInControl = AnaParameters[3].trim();
	//			String removeItem1 = AnaParameters[4].trim();
	//			String removeItem2 = AnaParameters[5].trim();
	//			String removeItem3 = AnaParameters[6].trim();
	//
	//			/* Remove items in Expanded Set */
	//			objAnalysisPage.RemoveItemsfromComparison(ComName,ControlSetName ,entity,searchTextInControl,removeItem1,removeItem2,removeItem3);
	//			//				objAnalysisPage.RemoveItemsfromComparison("Remove Item Comparison","Control Set" ,"Gene","asph", "72112780","20981360","147670524");
	//			onSuccessMeassage("Items removed successfully in Comparison Expand");
	//		}
	//		catch(Exception ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonItemsRemoveFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonItemsRemoveFail","ComparisonItemsRemoveFail");
	//		}
	//		catch(AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("ComparisonItemsRemoveFail");
	//			onFailureMeassage(ex.getMessage(),"ComparisonItemsRemoveFail","ComparisonItemsRemoveFail");
	//		}
	//	}
	//
	//	@Test(priority = 20, description = "Interchange Control and Case sets in the Comparison")
	//	public void ChangeControlAndCase_Test() throws Throwable {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String CaseSetName = AnaParameters[2].trim();
	//			String entity = AnaParameters[3].trim();
	//			String searchTextInControl = AnaParameters[4].trim();
	//			String searchTextInCase = AnaParameters[5].trim();
	//
	//			/* Changes the Control and Case in Comparison */	
	//			objAnalysisPage.ChangeControlAndCase(ComName, ControlSetName,CaseSetName ,entity,searchTextInControl,searchTextInCase);
	//			//			objAnalysisPage.ChangeControlAndCase("Control and Case Change", "Control Set ","Case Set" ,"Disease", "kera", "dol");
	//			onSuccessMeassage("Comparison is Created Successfully with Control Card");
	//		}
	//		catch(Throwable ex)
	//		{
	//			objAnalysisPage.captureScreenshot("changeControlAndCaseFail");
	//			onFailureMeassage(ex.getMessage(),"changeControlAndCaseFail","changeControlAndCaseFail");
	//		}
	//	}
	//
	//	@Test(priority = 21, description = "Sorting a column in a Comparison")
	//	public void SortColumnComparison_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchText = AnaParameters[3].trim();
	//			String sortColumn = AnaParameters[4].trim();
	//
	//			/* Sorting column in a Exploration */
	//			objAnalysisPage.SortColumnInComparison(ComName,ControlSetName ,entity,searchText,sortColumn);
	//			//			objAnalysisPage.SortColumnInComparison("SortComparison","ControlSet" , "Disease", "Kera", "EFO Name");
	//			onSuccessMeassage("Column in Comparison Sorted Successfully");
	//		}
	//		catch(Exception | AssertionError ex)
	//		{
	//			objAnalysisPage.captureScreenshot("SortColumnComparisonFail");
	//			onFailureMeassage(ex.getMessage(),"SortColumnComparisonFail","SortColumnComparisonFail");
	//		}
	//	}
	//
	//	@Test(priority = 22, description = "Filtering a Comparison with one filter")
	//	public void FilterComparison_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchText = AnaParameters[3].trim();
	//			String filterAttribute1 = AnaParameters[4].trim();
	//			String filterType1 = AnaParameters[5].trim();
	//			String filterValue1 = AnaParameters[6].trim();
	//
	//			/* Filtering in a Comparison */
	//			objAnalysisPage.FilterComparison(ComName, ControlSetName, entity,searchText,filterAttribute1,filterType1,filterValue1);
	//			//			objAnalysisPage.FilterComparison("Filter Comparison1", "Control Set", "Disease","kera", "EFO Name","contains","vul");
	//			onSuccessMeassage("Filtering done in Exploration Successfully for 1 filter");
	//		}
	//		catch(Throwable ex)
	//		{
	//			objAnalysisPage.captureScreenshot("FilterComaprisonFail");
	//			onFailureMeassage(ex.getMessage(),"FilterExplorationFail","FilterExplorationFail");
	//		}
	//	}
	//
	//	@Test(priority = 23, description = "Filtering a Comparison with 2 filters")
	//	public void FilterMultiComparison_Test() throws Throwable  {
	//		try {
	//
	//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//
	//			System.out.println(functionName);
	//			String value = this.getConfiguration().get(functionName);
	//			String[] AnaParameters =value.split(",");
	//			String ComName = AnaParameters[0].trim()+dtText;
	//			String ControlSetName = AnaParameters[1].trim();
	//			String entity = AnaParameters[2].trim();
	//			String searchText = AnaParameters[3].trim();
	//			String filterAttribute1 = AnaParameters[4].trim();
	//			String filterType1 = AnaParameters[5].trim();
	//			String filterValue1 = AnaParameters[6].trim();
	//			String filterAttribute2 = AnaParameters[7].trim();
	//			String filterType2 = AnaParameters[8].trim();
	//			String filterValue2 = AnaParameters[9].trim();
	//
	//			/* Filtering in a Comparison with multiple filter */
	//			objAnalysisPage.FilterComparisonMulti(ComName,ControlSetName,entity,searchText, filterAttribute1,filterType1,filterValue1,filterAttribute2,filterType2,filterValue2);
	//			//			objAnalysisPage.FilterComparisonMulti("Filter Comparison Multi 1","Control Set","Disease","kera", "EFO Name","contains","vul", "EFO ID", "equals","EFO_1000778");
	//			onSuccessMeassage("Filtering done in Exploration Successfully for multiple filters");
	//		}
	//		catch(Throwable ex)
	//		{
	//			objAnalysisPage.captureScreenshot("FilterComparisonMulltiFail");
	//			onFailureMeassage(ex.getMessage(),"FilterComparisonMulltiFail","FilterComparisonMulltiFail");
	//		}
	//	}

	public void onSuccessMeassage(String successMessage)
	{
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		ExtentTestManager.getTest().log(Status.PASS, successMessage);
	}

	public void onFailureMeassage(String ReasonForFail, String failureMessage,String screenShotName) throws IOException, InterruptedException
	{
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		ExtentTestManager.getTest().log(Status.FAIL, failureMessage+" : "+ReasonForFail);
		//		ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir") + "./Resources/ErrorScreenshots/"+screenShotName+".png");
		ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir")+"/Resources/ErrorScreenshots/"+screenShotName+".png");
	}

}	   

