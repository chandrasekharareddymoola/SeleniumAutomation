package com.eagle.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eagle.pages.HomePage;
import com.eagle.pages.LoginPage;

public class LoginTest extends BaseTest{	    
	   	   
		LoginPage objLogin;
	    HomePage objHomePage; 

    
	    @Test
	    public void test_Login_Correct() throws InterruptedException, IOException{	    	
	    	objLogin = new LoginPage();
		    objLogin.loginTo(); 		    
	    }

}
