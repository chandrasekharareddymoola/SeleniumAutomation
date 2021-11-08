package com.eagle.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.eagle.Base.BasePage;

public class LoginPage extends Page{
	
	//WebDriver driver;
	  
	@FindBy(name = "email")
	public WebElement username;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(name = "submit")
	public WebElement submit;	
	
	@FindBy(xpath = "//div//label[contains(text(),'Copyright')]")
	public WebElement copyRightIdentifier;
		
	 public LoginPage(){ 		 
		 PageFactory.initElements(driver, this); 
	 }

    public void setCredentials(){    	
    	Page.enterUserPass(username,password);    
    }  
    
    public void clickLogin(){
    	Page.click(submit);
    }  
    
//    public void loginTo() throws InterruptedException{
//        this.setCredentials();       
//        this.clickLogin();   
//        Thread.sleep(15000);
//    }

    public void loginTo() throws InterruptedException, IOException{
    	try {
	        this.setCredentials();
	        this.clickLogin();
	     
	       boolean iden = true;
	       do
	       {
	    	   try {	    		  
	    		   copyRightIdentifier.click();
	    		   iden = false;	  
	    	   }
	    	   catch(Exception ex) {System.out.println("fail");}	    		
	    	  
	       }
	       while(iden);
	        //String error = loginErrorMessage.getText();
	       // Assert.assertEquals(error, ""); 	       
    	}
        catch(Exception | AssertionError ex)
    	{
//    		BasePage.capture();
    		throw ex;
    	}
    }
}