package com.eagle.TestCases;

import org.testng.annotations.Test;

import com.eagle.pages.InvestigationPage;
import com.eagle.pages.LoginPage;
import com.eagle.pages.SetPage;

public class SetTest extends BaseTest{

	LoginPage objLogin;
	SetPage objSetPage; 
   
    @Test
    public void test_Set_Correct() throws InterruptedException{
	    objLogin = new LoginPage();
	    objLogin.loginTo();
	    
	    objSetPage = new SetPage();
	    //objSetPage.createSet();	    
	   // objSetPage.RemoveItemsfromSet();
	   // objSetPage.CreateSetFromFile();
	    
	    objSetPage.CreateSetFromSet();
    }	   
} 
