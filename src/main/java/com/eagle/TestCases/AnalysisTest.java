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

	@Test(priority = 0, description = "Create Analysis")
	public void CreateAnalysis_Test() throws Throwable {
		try {
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			//		String studyName = AnaParameters[2].trim();
			String studyIndex = AnaParameters[2].trim();

			/* Creates an Analysis */	
			//			objAnalysisPage.createAnalysis(AnalysisName,AnalysisDescription,studyName);
			//			objAnalysisPage.createAnalysis("Analysis-1","Analysis Description","Eagle Study A");

			objAnalysisPage.createAnalysis2(AnalysisName,AnalysisDescription,studyIndex);
			//			objAnalysisPage.createAnalysis2("Analysis-1","Analysis Description","2");

			onSuccessMeassage("AnalysisCreation");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("createAnalysisFail");
			onFailureMeassage(ex.getMessage(),"createAnalysisFail","createAnalysisFail");
		}
	}	


	@Test(priority = 1, description = "Check mandatory fields before create Analysis")
	public void CreateAnalysisMandatoryCheck_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			//		String studyName = AnaParameters[2].trim();
			String StudyIndex = AnaParameters[2].trim();


			/* Creates an Analysis after performing mandatory check */	
			//			objAnalysisPage.checkMandatoryfieldsinAnalysis(AnalysisName,AnalysisDescription,studyName);
			//			objAnalysisPage.checkMandatoryfieldsinAnalysis("Analysis-2", "Test Description for Analysis Check", "Eagle Study A");

			objAnalysisPage.checkMandatoryfieldsinAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			//			objAnalysisPage.checkMandatoryfieldsinAnalysis2("Analysis-2", "Test Description for Analysis Check", "3");

			onSuccessMeassage("Create Analysis - after mandatory fields were verified");
		}
		catch(Exception | AssertionError ex)
		{
			objAnalysisPage.captureScreenshot("CreateAnalysisMandatoryCheckFail");
			onFailureMeassage(ex.getMessage(),"CreateAnalysisMandatoryCheckFail","CreateAnalysisMandatoryCheckFail");
		}
	}

	@Test(priority = 2, description = "Edit Analysis Name and Description from Analysis List")
	public void AnalysisNameAndDescEditInList_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters = value.split(",");
			String AnalysisNameInital = AnaParameters[0].trim()+dtText;
			String AnalysisDescriptionInital = AnaParameters[1].trim();
			//		String StudyName = AnaParameters[2].trim();
			String StudyIndex = AnaParameters[2].trim();
			String AnalysisName = AnaParameters[3].trim()+dtText;
			String AnalysisDescription = AnaParameters[4].trim();


			/* Edit Analysis Name and Description in list page */	 
			//		objAnalysisPage.AnalysisNameAndDescEditInList(AnalysisNameInital, AnalysisDescriptionInital, StudyName, AnalysisName, AnalysisDescription);
			//		objAnalysisPage.AnalysisNameAndDescEditInList("Analysis-3","Analysis Description","Eagle Study A","Name of [Analysis>: is changed", "Description of [Analysis>: is changed");

			objAnalysisPage.AnalysisNameAndDescEditInList2(AnalysisNameInital, AnalysisDescriptionInital, StudyIndex, AnalysisName, AnalysisDescription);
			//			objAnalysisPage.AnalysisNameAndDescEditInList2("Analysis-3","Analysis Description","1","Name of [Analysis>: is changed", "Description of [Analysis>: is changed");

			onSuccessMeassage("An analysis is created and the name, description and study are edited successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objAnalysisPage.captureScreenshot("AnalysisNameAndDescEditInListFail");
			onFailureMeassage(ex.getMessage(),"AnalysisNameAndDescEditInListFail","AnalysisNameAndDescEditInListFail");
		}
	}


	@Test(priority = 3, description = "Edit Analysis Name and Description from Analysis Page")
	public void AnalysisNameAndDescEditInPage_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisNameInital = AnaParameters[0].trim()+dtText;
			String AnalysisDescriptionInital = AnaParameters[1].trim();
			//			String StudyName = AnaParameters[2].trim();
			String StudyIndex = AnaParameters[2].trim();
			String AnalysisName = AnaParameters[3].trim()+dtText;
			String AnalysisDescriptionSmall = AnaParameters[4].trim();
			String AnalysisDescription = AnaParameters[5].trim();


			/* Edit Analysis Name and Description in list page */	 
			//			objAnalysisPage.AnalysisNameAndDescEditInPage(AnalysisNameInital, AnalysisDescriptionInital, StudyName, AnalysisName, AnalysisDescription);
			//			objAnalysisPage.AnalysisNameAndDescEditInPage("Analysis-4","Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far","Eagle Study A","Name of ()@#$Analysis{}: is changed", "Description small", "Description of ()@#$Analysis{}: is changed");

			objAnalysisPage.AnalysisNameAndDescEditInPage2(AnalysisNameInital, AnalysisDescriptionInital, StudyIndex, AnalysisName,AnalysisDescriptionSmall, AnalysisDescription);
			//			objAnalysisPage.AnalysisNameAndDescEditInPage2("Analysis-4","Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far","3","Name of ()@#$Analysis{}: is changed", "Description small", "Description of ()@#$Analysis{}: is changed");
			onSuccessMeassage("An analysis is created and the name, description and study are editted successfully");
		}
		catch(Exception | AssertionError ex)
		{
			objAnalysisPage.captureScreenshot("AnalysisNameAndDescEditInPageFail");
			onFailureMeassage(ex.getMessage(),"AnalysisNameAndDescEditInPageFail","AnalysisNameAndDescEditInPageFail");
		}
	}


	@Test(priority = 4, description = "Create and Delete Analysis")
	public void CreateAndDeleteAnalysis_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			//		String StudyName = AnaParameters[2].trim();
			String StudyIndex = AnaParameters[2].trim();

			/* Edit Analysis Name and Description inside Analysis */	 
			//		objAnalysisPage.CreateAndDeleteAnalysis(AnalysisName,AnalysisDescription,StudyName);
			//		objAnalysisPage.CreateAndDeleteAnalysis("Analysis-5", "Analysis Delete Description with greater than 60 letter text", "Eagle Study A");

			objAnalysisPage.CreateAndDeleteAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			//		objAnalysisPage.CreateAndDeleteAnalysis2("Analysis-5", "Analysis Delete Description with greater than 60 letter text", "4");
			onSuccessMeassage("Analysis is Created and Deleted");
		}
		catch(Exception | AssertionError ex)
		{
			objAnalysisPage.captureScreenshot("AnalysisCreateandDeleteFail");
			onFailureMeassage(ex.getMessage(),"AnalysisCreateandDeleteFail","AnalysisCreateandDeleteFail");
		}
	}	

	@Test(priority = 5, description = "Verifying the graph canvas")
	public void VerifyGraphCanvas_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			//				String StudyName = AnaParameters[2].trim();
			String StudyIndex = AnaParameters[2].trim();


			/* Verify the presence of Graph Canvas and its contents */	
			//				objAnalysisPage.VerifyGraphCanvasInAnalysis(AnalysisName,AnalysisDescription,StudyName,NoOfEntities,EntityNames);
			//				objAnalysisPage.VerifyGraphCanvasInAnalysis("Graph Canvas Analysis", "Graph Canvas Analysis", "Eagle Study A","5","The Study", "Trial", "Organism", "Subject", 'Measurement');

			objAnalysisPage.VerifyGraphCanvasInAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			//				objAnalysisPage.VerifyGraphCanvasInAnalysis2("Graph Canvas Analysis", "Graph Canvas Analysis", "2","5","The Study", "Trial", "Organism", "Subject", 'Measurement');
			onSuccessMeassage("Graph Canvas is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("GraphCanvasVerificationFail");
			onFailureMeassage(ex.getMessage(),"GraphCanvasVerificationFail","GraphCanvasVerificationFail");
		}
	}

	@Test(priority = 6, description = "Verifying resizing of graph canvas")
	public void VerifyResizingOfGraph_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			//					String StudyName = AnaParameters[2].trim();
			String StudyIndex = AnaParameters[2].trim();


			/* Verify the resizing of Graph canvas*/	
			//			objAnalysisPage.VerifyNumericalValueAnalysis(AnalysisName,AnalysisDescription,StudyName);
			//			objAnalysisPage.VerifyResizingOfGraphAnalysis("Resizing Graph Canvas Analysis", "Resizing Graph Canvas Analysis", "Eagle Study A");

			objAnalysisPage.VerifyResizingOfGraphAnalysis2(AnalysisName,AnalysisDescription,StudyIndex);
			//			objAnalysisPage.VerifyResizingOfGraphAnalysis2("Resizing Graph Canvas Analysis", "Resizing Graph Canvas Analysis", "3");
			onSuccessMeassage("Resizing Graph Canvas is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("ResizingGraphCanvasVerificationFail");
			onFailureMeassage(ex.getMessage(),"ResizingGraphCanvasVerificationFail","ResizingGraphCanvasVerificationFail");
		}
	}


	//	//need some alteration in the code
	//	@Test(priority = 7, description = "Verify selection of features in Analysis")
	//	public void VerifySelectingFeaturesInAnalysis_Test() throws Throwable {
	//		try {
	//			//
	//			//			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
	//			//
	//			//			System.out.println(functionName);
	//			//			String value = this.getConfiguration().get(functionName);
	//			//			String[] AnaParameters =value.split(",");
	//			//			String AnalysisName = AnaParameters[0].trim()+dtText;
	//			//			String AnalysisDescription = AnaParameters[1].trim();
	//			//			String StudyName = AnaParameters[2].trim();
	//			//			String EntityName = AnaParameters[3].trim();
	//			//			String FeatureName = AnaParameters[4].trim();
	//
	//
	//			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
	//			//			objAnalysisPage.SelectFeatures(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
	//			objAnalysisPage.GetEntityAndFeatureNames("Numerical Value Analysis", "Numerical Value Analysis", "2","3");
	//			onSuccessMeassage("Numerical Value is successfully verified");
	//		}
	//		catch(Throwable ex)
	//		{
	//			objAnalysisPage.captureScreenshot("FeatureSelectionFail");
	//			onFailureMeassage(ex.getMessage(),"FeatureSelectionFail","FeatureSelectionFail");
	//		}
	//	}	

	@Test(priority = 7, description = "Verify Graph - entities and features selection and verifying the same in My Selection and Dataframe")
	public void EntitiesAndFeatureSelectionVerificationInGraph_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			String StudyIndex = AnaParameters[2].trim();
			String NoOfCategoricalValuesRequired = AnaParameters[3].trim();
			String NoOfNumericalValuesRequired = AnaParameters[4].trim();

			/* Verifying the values in Graph canvas and verifying the selections in My Selection and Dataframe */	
			objAnalysisPage.EntitiesAndFeatureSelectionVerificationInGraph(AnalysisName,AnalysisDescription,StudyIndex,NoOfCategoricalValuesRequired,NoOfNumericalValuesRequired);
			//			objAnalysisPage.EntitiesAndFeatureSelectionVerificationInGraph("SelectionVerification", "SelectionVerification","1","5","5");
			onSuccessMeassage("All the selection in verification is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("SelectionVerificationFail");
			onFailureMeassage(ex.getMessage(),"SelectionVerificationFail","SelectionVerificationFail");
		}
	}	


	@Test(priority = 8, description = "Verify Graph with one numeric value")
	public void PlotWithOneNumericalFeature_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			String StudyIndex = AnaParameters[2].trim();
			String NoOfCategoricalValuesRequired = AnaParameters[3].trim();
			String NoOfNumericalValuesRequired = AnaParameters[4].trim();

			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
			//			objAnalysisPage.VerifyNumericalValueAnalysis(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
			//			objAnalysisPage.PlotWithOneNumericalFeature("NumericalPlot1", "NumericalPlot1", "2");
			objAnalysisPage.PlotWithOneNumericalFeatureAloneWithoutVerification(AnalysisName,AnalysisDescription,StudyIndex,NoOfCategoricalValuesRequired,NoOfNumericalValuesRequired);
			//			objAnalysisPage.PlotWithOneNumericalFeatureAloneWithoutVerification("NumericalPlot1", "NumericalPlot1", "1","0","2");
			onSuccessMeassage("1 Numerical Plot is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("1NumericalPlotVerificationFail");
			onFailureMeassage(ex.getMessage(),"1NumericalPlotVerificationFail","1NumericalPlotVerificationFail");
		}
	}	

	@Test(priority = 9, description = "Verify Graph with one categorical value")
	public void PlotWithOneCategoricalFeature_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			String StudyIndex = AnaParameters[2].trim();
			String NoOfCategoricalValuesRequired = AnaParameters[3].trim();
			String NoOfNumericalValuesRequired = AnaParameters[4].trim();

			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
			//			objAnalysisPage.VerifyNumericalValueAnalysis(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
			//				objAnalysisPage.PlotWithOneCategoricalFeature("CategoricalPlot1", "CategoricalPlot1", "2");
			objAnalysisPage.PlotWithOneCategoricalFeatureAloneWithoutVerification(AnalysisName,AnalysisDescription,StudyIndex,NoOfCategoricalValuesRequired,NoOfNumericalValuesRequired);
			//			objAnalysisPage.PlotWithOneCategoricalFeatureAloneWithoutVerification("CategoricalPlot1", "CategoricalPlot1", "2","2","0");
			onSuccessMeassage("1 Categorical Plot is successfully verified");

		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("1CategoricalPlotVerificationFail");
			onFailureMeassage(ex.getMessage(),"1CategoricalPlotVerificationFail","1CategoricalPlotVerificationFail");
		}
	}	


	@Test(priority = 10, description = "Verify Graph with one categorical and one numerical value")
	public void PlotWithOneCategoricalandOneNumericalFeature_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			String StudyIndex = AnaParameters[2].trim();
			String NoOfCategoricalValuesRequired = AnaParameters[3].trim();
			String NoOfNumericalValuesRequired = AnaParameters[4].trim();

			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
			//			objAnalysisPage.VerifyNumericalValueAnalysis(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
			//			objAnalysisPage.PlotWithOneCategoricalandOneNumericalFeature("1Categorical1NumericalPlot", "1Categorical1NumericalPlot", "2");
			objAnalysisPage.PlotWithOneCategoricalandOneNumericalFeatureAloneWithoutVerification(AnalysisName,AnalysisDescription,StudyIndex,NoOfCategoricalValuesRequired,NoOfNumericalValuesRequired);
			//			objAnalysisPage.PlotWithOneCategoricalandOneNumericalFeatureAloneWithoutVerification("1Categorical1NumericalPlot", "1Categorical1NumericalPlot", "3","2","2");
			onSuccessMeassage("1 Categorical and 1 Numerical Plot is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("1Categorical1NumericalPlotVerificationFail");
			onFailureMeassage(ex.getMessage(),"1Categorical1NumericalPlotVerificationFail","1Categorical1NumericalPlotVerificationFail");
		}
	}	

	@Test(priority = 11, description = "Verify Graph with two numerical values")
	public void PlotWithTwoNumericalFeature_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			String StudyIndex = AnaParameters[2].trim();
			String NoOfCategoricalValuesRequired = AnaParameters[3].trim();
			String NoOfNumericalValuesRequired = AnaParameters[4].trim();

			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
			//			objAnalysisPage.PlotWithTwoNumericalFeatures(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
			//			objAnalysisPage.PlotWithTwoNumericalFeatures("2NumericalPlots", "2NumericalPlots", "2");
			objAnalysisPage.PlotWithTwoNumericalFeaturesAloneWithoutVerification(AnalysisName,AnalysisDescription,StudyIndex,NoOfCategoricalValuesRequired,NoOfNumericalValuesRequired);
			//			objAnalysisPage.PlotWithTwoNumericalFeaturesAloneWithoutVerification("2NumericalPlots", "2NumericalPlots", "1","0","4");
			onSuccessMeassage("2 Numerical Plots is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("2NumericalPlotsVerificationFail");
			onFailureMeassage(ex.getMessage(),"2NumericalPlotsVerificationFail","2NumericalPlotsVerificationFail");
		}
	}	

	@Test(priority = 12, description = "Verify Graph with two categorical values")
	public void PlotWithTwoCategoricalFeature_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			String StudyIndex = AnaParameters[2].trim();
			String NoOfCategoricalValuesRequired = AnaParameters[3].trim();
			String NoOfNumericalValuesRequired = AnaParameters[4].trim();

			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
			//			objAnalysisPage.PlotWithTwoCategoricalFeatures(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
			//				objAnalysisPage.PlotWithTwoCategoricalFeatures("2CategoricalPlots", "2CategoricalPlots", "2");
			objAnalysisPage.PlotWithTwoCategoricalFeaturesAloneWithoutVerification(AnalysisName,AnalysisDescription,StudyIndex,NoOfCategoricalValuesRequired,NoOfNumericalValuesRequired);
			//			objAnalysisPage.PlotWithTwoCategoricalFeaturesAloneWithoutVerification("2CategoricalPlots", "2CategoricalPlots", "2","3","0");
			onSuccessMeassage("2 Categorical Plots is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("2CategoricalPlotsVerificationFail");
			onFailureMeassage(ex.getMessage(),"2CategoricalPlotsVerificationFail","2CategoricalPlotsVerificationFail");
		}
	}	

	@Test(priority = 13, description = "Verify Graph with two categorical and one numerical values")
	public void PlotWithTwoNumericalandOneCategoricalFeatures_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			String StudyIndex = AnaParameters[2].trim();
			String NoOfCategoricalValuesRequired = AnaParameters[3].trim();
			String NoOfNumericalValuesRequired = AnaParameters[4].trim();

			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
			//			objAnalysisPage.PlotWithTwoNumericalandOneCategoricalFeatures(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
			//			objAnalysisPage.PlotWithTwoNumericalandOneCategoricalFeatures("2Numerical1CategoricalPlots", "2Numerical1CategoricalPlots", "2");
			objAnalysisPage.PlotWithTwoNumericalandOneCategoricalFeaturesAloneWithoutVerification(AnalysisName,AnalysisDescription,StudyIndex,NoOfCategoricalValuesRequired,NoOfNumericalValuesRequired);
			//			objAnalysisPage.PlotWithTwoNumericalandOneCategoricalFeaturesAloneWithoutVerification("2Numerical1CategoricalPlots", "2Numerical1CategoricalPlots", "2","2","3");
			onSuccessMeassage("2 Numerical 1 Categorical Plots is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("2Numerical1CategoricalPlotsVerificationFail");
			onFailureMeassage(ex.getMessage(),"2Numerical1CategoricalPlotsVerificationFail","2Numerical1CategoricalPlotsVerificationFail");
		}
	}	

	@Test(priority = 14, description = "Verify Graph with three numerical values")
	public void PlotWithThreeNumericalFeatures_Test() throws Throwable {
		try {

			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			String StudyIndex = AnaParameters[2].trim();
			String NoOfCategoricalValuesRequired = AnaParameters[3].trim();
			String NoOfNumericalValuesRequired = AnaParameters[4].trim();

			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
			//			objAnalysisPage.PlotWithThreeNumericalFeatures(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
			//				objAnalysisPage.PlotWithThreeNumericalFeatures("3NumericalPlots", "3NumericalPlots", "2");
			objAnalysisPage.PlotWithThreeNumericalFeaturesAloneWithoutVerification(AnalysisName,AnalysisDescription,StudyIndex,NoOfCategoricalValuesRequired,NoOfNumericalValuesRequired);
			//			objAnalysisPage.PlotWithThreeNumericalFeaturesAloneWithoutVerification("3NumericalPlots", "3NumericalPlots", "1","0","4");
			onSuccessMeassage("3 Numerical Plots is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("3NumericalPlotsVerificationFail");
			onFailureMeassage(ex.getMessage(),"3NumericalPlotsVerificationFail","3NumericalPlotsVerificationFail");
		}
	}	

	@Test(priority = 15, description = "Verify Graph with three numerical and one Categorical values")
	public void PlotWithThreeNumericalandOneCategoricalFeatures_Test() throws Throwable {
		try {
			//
			String functionName = new Object(){}.getClass().getEnclosingMethod().getName();

			System.out.println(functionName);
			String value = this.getConfiguration().get(functionName);
			String[] AnaParameters =value.split(",");
			String AnalysisName = AnaParameters[0].trim()+dtText;
			String AnalysisDescription = AnaParameters[1].trim();
			String StudyIndex = AnaParameters[2].trim();
			String NoOfCategoricalValuesRequired = AnaParameters[3].trim();
			String NoOfNumericalValuesRequired = AnaParameters[4].trim();

			/* Select a Numerical value in Analysis and Verify the summary statistics headers */	
			//			objAnalysisPage.PlotWithThreeNumericalandOneCategoricalFeatures(AnalysisName,AnalysisDescription,StudyName,EntityName,FeatureName);
			//			objAnalysisPage.PlotWithThreeNumericalandOneCategoricalFeatures("3Numerical1CategoricalPlots", "3Numerical1CategoricalPlots", "2");
			objAnalysisPage.PlotWithThreeNumericalandOneCategoricalFeaturesAloneWithoutVerification(AnalysisName,AnalysisDescription,StudyIndex,NoOfCategoricalValuesRequired,NoOfNumericalValuesRequired);
			//			objAnalysisPage.PlotWithThreeNumericalandOneCategoricalFeaturesAloneWithoutVerification("3Numerical1CategoricalPlots", "3Numerical1CategoricalPlots", "1","2","4");
			onSuccessMeassage("3 Numerical Plots 1 Categorical is successfully verified");
		}
		catch(Throwable ex)
		{
			objAnalysisPage.captureScreenshot("3Numerical1CategoricalPlotsVerificationFail");
			onFailureMeassage(ex.getMessage(),"3Numerical1CategoricalPlotsVerificationFail","3Numerical1CategoricalPlotsVerificationFail");
		}
	}	

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

