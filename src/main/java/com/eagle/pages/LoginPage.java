package com.eagle.pages;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(name = "//*[text()='Error while initializing catalog']")
	public WebElement catalogInitializeError;


	public LoginPage(){ 		 
		PageFactory.initElements(driver, this); 
	}

	public void setCredentials() throws InterruptedException, AWTException{    	
		BasePage.enterUserPass(username,password);    
	}  

	public void clickLogin() throws InterruptedException, AWTException{
		BasePage.click(submit);
	}  

	public String captureScreenshot(String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = "./Resources/ErrorScreenshots/"+screenShotName+".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}     

		return dest;
	}

	public void loginTo() throws Throwable{
		try {
			this.setCredentials();
			this.clickLogin();	     
			boolean iden = true;
			outerloop:
			do
			{
				try {	    		  
					BasePage.click(copyRightIdentifier);
					iden = false;	  
				}
				catch(Exception ex) {
					Thread.sleep(5000);
					if(catalogInitializeError.isDisplayed()) {
						throw new InterruptedException ("Error while initializing catalog");
						}
					try {
						if (catalogInitializeError.isDisplayed()) {
							break outerloop;
						}
					}
					catch (Exception et){
						Thread.sleep(5000);}	 
				}
			}	 
			while(iden);	         
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
}