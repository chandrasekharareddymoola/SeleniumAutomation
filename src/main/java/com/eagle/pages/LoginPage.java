package com.eagle.pages;


import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import com.eagle.ConfigUtils.ReadObject;
import com.eagle.Reports.ExtentTestManager;


public class LoginPage extends BasePage{

	//Web Elements in page

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

//	@FindBy(xpath = "//*[@class='logo' and @alt='Microsoft']")
//	public WebElement microSoftLogo;
	
	
	@FindBy(xpath = "//*[@class='banner-logo']")
	public WebElement eagleLogo;

//	@FindBy(xpath = "//*[text()='Use a verification code from my mobile app']")
//	public WebElement verificationCode;
	
	@FindBy(xpath = "//*[text()='Use a verification code']")
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
	
	
	//Methods

	public LoginPage(){ 		 
		PageFactory.initElements(driver, this); 
	}

	//Feeds in the user name and password to be entered
	public void setCredentials() throws InterruptedException, AWTException{    	
		BasePage.enterUserPass(username,password);    
	}  

	//Click in the login button (sometimes the buttons with name = submit --> Next, submit etc)
	public void clickLogin() throws InterruptedException, AWTException{
		BasePage.click(submit);
	}  

	//Login using Microsoft account login by giving in password alone (as we would have already given email id)
	public void MicrosoftLogin() throws Throwable{
		try {
			ReadObject object = new ReadObject();
			Properties configObject = object.getObjectRepositoty();	     
			String emailPass = configObject.getProperty("Password");

			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//			BasePage.CompareAttributeText("alt","Microsoft",microSoftLogo);
			wait.until(ExpectedConditions.visibilityOf(MicrosoftPassText));
			BasePage.click(MicrosoftPass);
			MicrosoftPass.sendKeys(emailPass);									//feed in only password as email ID has already been given
			BasePage.click(SignIn);		
		}
		catch(Exception ex) {
			ExtentTestManager.getTest().log(Status.FAIL,"Some problem with Microsoft Login");
			throw ex;
		}
	}

	//Case where direct single Login button is present
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
			directEmail.sendKeys(email);											//feed in email ID
			BasePage.click(directSubmit);
			wait.until(ExpectedConditions.visibilityOf(directPassWord));
			directPassWord.sendKeys(emailPass);										//feed in password
			BasePage.click(directSubmit);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	//To click on the code mode of entry and give in the code to login
	public void CodeVerification() throws Throwable{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			wait.until(ExpectedConditions.visibilityOf(verificationCode));
			BasePage.click(verificationCode);
			wait.until(ExpectedConditions.visibilityOf(CodeTextBox));
			Thread.sleep(10000);
			//					CodeTextBox.sendKeys("123123");						//uncomment both lines only if the code is pre-known, if not manual entry is required here
			//					BasePage.click(verifyButton);
			ExtentTestManager.getTest().log(Status.PASS,"The second factor authentication was given manually");
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
					if(i==14) {
						ExtentTestManager.getTest().log(Status.FAIL,"Either Code has not been entered or is wrong, hence the Yes button is not displayed"); 	
					}
				}
			}	
		}
		catch(Exception ex) {
			ExtentTestManager.getTest().log(Status.FAIL,"2nd factor authentication was unsuccessful hence the further cases would fail"); // termination report 
			throw ex;
		}
	}

	//Login function that lets the user login with valid credentials
	public void loginTo() throws Throwable{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			try {
				this.directLogin();
				this.CodeVerification();
			}
			catch(Exception sct) {
				this.setCredentials();
				this.clickLogin();
//				wait.until(ExpectedConditions.visibilityOf(microSoftLogo));
				wait.until(ExpectedConditions.visibilityOf(eagleLogo));
//				if(microSoftLogo.isDisplayed()) {	
				if(eagleLogo.isDisplayed()) {	
					try {
						this.MicrosoftLogin();
						this.CodeVerification();
					}
					catch(Exception o){
						ExtentTestManager.getTest().log(Status.FAIL,"User Login failed");
						throw o;
					}
				}
				int i=0;
				do
				{
					try {	    		  
						BasePage.click(copyRightIdentifier); 
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
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	//Method to capture screenshot
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

}