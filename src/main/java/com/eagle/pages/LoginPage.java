package com.eagle.pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.eagle.ConfigUtils.ReadObject;
import com.eagle.Reports.ExtentTestManager;

public class LoginPage extends BasePage{

	//WebDriver driver;

	@FindBy(name = "email")
	public WebElement username;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(name = "submit")
	public WebElement submit;	

	@FindBy(xpath = "//*[@role='heading' and text()='Enter password']")
	public WebElement MicrosoftPassText;	

	@FindBy(xpath = "//*[@name='passwd']")
	public WebElement MicrosoftPass;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement SignIn;	

	@FindBy(xpath = "//div//label[contains(text(),'Copyright')]")
	public WebElement copyRightIdentifier;		

	@FindBy(name = "//div[@class='auth0-global-message auth0-global-message-error']")
	public WebElement loginErrorMessage;

	@FindBy(name = "//*[text()='Error while initializing catalog']")
	public WebElement catalogInitializeError;

	@FindBy(xpath = "//*[@class='logo' and @alt='Microsoft']")
	public WebElement microSoftLogo;

	@FindBy(xpath = "//*[text()='Use a verification code from my mobile app']")
	public WebElement verificationCode;

	@FindBy(xpath = "//input[@aria-label='Code']")
	public WebElement CodeTextBox;

	@FindBy(xpath = "//*[@value='Yes']")
	public WebElement yesButton;

	@FindBy(xpath = "//*[@value='Verify']")
	public WebElement verifyButton;

	@FindBy(xpath = "//*[@data-provider='windows' and @type='button']")
	public WebElement loginUserButton;
	
	@FindBy(xpath = "//input[@type='email']")
	public WebElement directEmail;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement directSubmit;
	
	@FindBy(xpath = "//input[@name='passwd' and @type='password']")
	public WebElement directPassWord;

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

	public void MicrosoftLogin() throws Throwable{
		try {
			ReadObject object = new ReadObject();
			Properties configObject = object.getObjectRepositoty();	     
			String emailPass = configObject.getProperty("Password");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			BasePage.CompareAttributeText("alt","Microsoft",microSoftLogo);
			wait.until(ExpectedConditions.visibilityOf(MicrosoftPassText));
			BasePage.click(MicrosoftPass);
			MicrosoftPass.sendKeys(emailPass);
			BasePage.click(SignIn);		
		}
		catch(Exception ex) {
			ExtentTestManager.getTest().log(Status.FAIL,"Some problem with Microsoft Login");
			throw ex;
		}
	}

	public void CodeVerification() throws Throwable{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.visibilityOf(verificationCode));
			BasePage.click(verificationCode);
			wait.until(ExpectedConditions.visibilityOf(CodeTextBox));
			Thread.sleep(10000);
			//					CodeTextBox.sendKeys("123123");
			//					BasePage.click(verifyButton);
			int i=0;
			while(i<15) {
				try {
					BasePage.waitforAnElement(yesButton);
					BasePage.click(yesButton);
					break;
				}
				catch(Throwable y) {
					Thread.sleep(10000);
					i++;
				}
			}	
		}
		catch(Exception ex) {
			ExtentTestManager.getTest().log(Status.FAIL,"Some problem with COde Verification");
			throw ex;
		}
	}

	public void directLogin() throws Throwable{
		try {
			ReadObject object = new ReadObject();
			Properties configObject = object.getObjectRepositoty();	     
			String email = configObject.getProperty("Username");	
			String emailPass = configObject.getProperty("Password");	
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.visibilityOf(loginUserButton));
			click(loginUserButton);
			wait.until(ExpectedConditions.visibilityOf(directEmail));
			directEmail.sendKeys(email);
			BasePage.click(directSubmit);
			wait.until(ExpectedConditions.visibilityOf(directPassWord));
			directPassWord.sendKeys(emailPass);
			BasePage.click(directSubmit);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	public void loginTo() throws Throwable{
		try {
			try {
				this.directLogin();
				this.CodeVerification();
			}
			catch(Exception sct) {
				this.setCredentials();
				this.clickLogin();
				Thread.sleep(10000);
				if(microSoftLogo.isDisplayed()) {			
					try {
						this.MicrosoftLogin();
						this.CodeVerification();
					}
					//					BasePage.CompareAttributeText("alt","Microsoft",microSoftLogo);
					//					BasePage.waitforAnElement(MicrosoftPassText);
					//					BasePage.click(MicrosoftPass);
					//					MicrosoftPass.sendKeys(emailPass);
					//					BasePage.click(SignIn);	
					//					BasePage.waitforAnElement(verificationCode);
					//					BasePage.click(verificationCode);
					//					BasePage.waitforAnElement(CodeTextBox);
					//					Thread.sleep(10000);
					//					//					CodeTextBox.sendKeys("123123");
					//					//					BasePage.click(verifyButton);
					//					int i=0;
					//					while(i<15) {
					//						try {
					//							BasePage.waitforAnElement(yesButton);
					//							BasePage.click(yesButton);
					//							break;
					//						}
					//						catch(Throwable y) {
					//							Thread.sleep(10000);
					//							i++;
					//						}
					//					}
					//				}
					catch(Exception o){
						ExtentTestManager.getTest().log(Status.FAIL,"Some problem with Microsoft Login");
						throw o;
					}
				}
				boolean iden = true;
				int i=0;
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
					}
					i++;
				}	
				while(i<20);
				//				while(iden);	
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
}