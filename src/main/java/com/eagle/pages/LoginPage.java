package com.eagle.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class LoginPage extends BasePage{
	
	//WebDriver driver;
	  
	@FindBy(name = "email")
	public WebElement username;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(name = "submit")
	public WebElement submit;		

	@FindBy(xpath = "//div//label[contains(text(),'Copyright')]")
	public WebElement copyRightIdentifier;		

	@FindBy(name = "//div[@class='auth0-global-message auth0-global-message-error']")
	public WebElement loginErrorMessage;
	
	 public LoginPage(){ 		 
		 PageFactory.initElements(driver, this); 
	 }

    public void setCredentials(){    	
    	BasePage.enterUserPass(username,password);    
    }  
    
    public void clickLogin(){
    	BasePage.click(submit);
    }  
    
    public String captureScreenshot(String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "./Resources/ErrorScreenshots/"+screenShotName+".jpeg";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }     
                     
        return dest;
    }
   
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
	    	   catch(Exception ex) {Thread.sleep(5000);}	 
	       }
	       while(iden);	         
    	}
        catch(Exception | AssertionError ex)
    	{
    		throw ex;
    	}
    }
}