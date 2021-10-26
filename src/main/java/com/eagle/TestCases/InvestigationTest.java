package com.eagle.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eagle.pages.HomePage;
import com.eagle.pages.InvestigationPage;
import com.eagle.pages.LoginPage;

public class InvestigationTest extends BaseTest {

	LoginPage objLogin;
	InvestigationPage objInvestigationPage;

	@Test
	public void test_CreateInvestigation_Correct() throws InterruptedException {
		objLogin = new LoginPage();
		objLogin.loginTo();

		objInvestigationPage = new InvestigationPage();
		
		 /* To initiate the creation of Investigation */
		 objInvestigationPage.createInvestigation("Investigation 1","Investigation 1");
		 
		 Thread.sleep(5000); 
		 /* To view the Investigation */
		 objInvestigationPage.viewInvestigation("Investigation 1");
		  
		 Thread.sleep(5000); 
		 /* To edit the Investigation */
		 objInvestigationPage.editInvestigation("Investigation 1","Modified title","modified description");
		 
		  Thread.sleep(5000); 
		   /* To Link set to an Investigation */
		  objInvestigationPage.linkSettoInvestigation("Modified title" ,"UntitledSet-20 Oct 2021");
		 
		  /* To Link exploration to an Investigation */
		   //ERROR //		  
		  //objInvestigationPage.linkExplorationtoInvestigation("Modified title","");
		  
		  Thread.sleep(5000); 
		   /* To Link Comparison to an Investigation */
		  //objInvestigationPage.linkComparisontoInvestigation("Modified title","Unique");  

		//Thread.sleep(5000);
		/* To share the Investigation */
		objInvestigationPage.shareInvestigation("Investigation 2", "divya.devanathan@eaglegenomics.com");

		Thread.sleep(5000);
		/* To delete the Investigation */
		objInvestigationPage.deleteInvestigation("Investigation 2");

	}
}
