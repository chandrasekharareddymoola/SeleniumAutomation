package com.eagle.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eagle.pages.HomePage;
import com.eagle.pages.InvestigationPage;
import com.eagle.pages.LoginPage;

public class InvestigationTest extends BaseTest{
	 	
	    LoginPage objLogin;
	    InvestigationPage objInvestigationPage; 
	   
	    @Test
	    public void test_CreateInvestigation_Correct() throws InterruptedException{
		    objLogin = new LoginPage();
		    objLogin.loginTo();	
		    
		    objInvestigationPage = new InvestigationPage();
		    objInvestigationPage.createInvestigation();	
	    }	    
}
