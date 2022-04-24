package com.eagle.pages;

import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.eagle.Reports.ExtentTestManager;
import com.eagle.TestCases.BaseTest;


public class BasePage extends BaseTest{

	public static WebDriver driver;
	public static String userName;
	public static String passWord;

	public void setWebDriver(WebDriver driver) {
		BasePage.driver = driver;		
	}
	public void setUserName(String email) {
		BasePage.userName = email;		
	}
	public void setPassword(String emailPass) {
		BasePage.passWord = emailPass;		
	}

	//Enter User name and Password
	public static void enterUserPass(WebElement user, WebElement pass) throws InterruptedException, AWTException {		
		click(user);	
		user.sendKeys(userName);					//enters only user name - case where only mail ID is required
		Thread.sleep(1000);
		try {
			if(pass.isDisplayed()) {
				click(pass);	
				pass.sendKeys(passWord);			//enters password
			}
		}
		catch(Exception r){
			ExtentTestManager.getTest().log(Status.PASS,"Needs to authenticate through Microsoft page");
		}
	}
	
	//Click an element (incorporated internal wait and scroll if element not found)
	public static void click(WebElement element) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			element.click();
		} catch (Exception e) {
			scrollIntoView(element);
			element.click();
		}
	}	

	//Assert a particular field text with the given text
	public static void verifyPage(String ItemToVerify, WebElement field) throws InterruptedException, AWTException, AssertionError {		
		try {
			BasePage.waitforAnElement(field);
			String getheadertext = field.getText().trim();
			Assert.assertEquals(getheadertext, ItemToVerify);
		}
		catch (Exception | AssertionError ex) {
			throw ex;
		}
	}

	//Scroll an element into view
	public static void scrollIntoView(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//Scroll to top
	public static void scrollToTop() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	// Enter text into a field of choice
	public static void enterText(WebElement field, String value) throws InterruptedException, AWTException {
		if (!value.equalsIgnoreCase("nil")) {			
			BasePage.click(field);
			field.sendKeys(Keys.CONTROL + "a");		
			field.sendKeys(Keys.DELETE);
			field.sendKeys(value);
		}
	}	

	//Wait for an element to be visible
	public static void waitforAnElement(WebElement Element) throws InterruptedException, AWTException{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(Element));	
	}

	//Wait for an element to be Clickable
	public static void waitforAnElementtoBeClicked(WebElement Element) throws InterruptedException, AWTException{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(Element));	
	}
	
	//Method to capture screenshot
		public String screenshotOnPass(String screenShotName) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			//			String dest = "./Resources/PassedScreenshots/"+screenShotName+".png";
			//			String dest = "C:\\Users\\"+SharePointUserName+"\\Eagle Genomics\\Quality Assurance - Documents\\Test screenshots\\PassedScreenshots\\"+screenShotName+".png";
			//			String dest = "C:\\Users\\"+SharePointUserName+"\\Eagle Genomics\\Quality Assurance - Documents\\Test screenshots\\PassedScreenshots"+dtTime+"\\"+screenShotName+".png";
			String dest = "./Resources/TestReport"+dtTime+"/PassedScreenshots"+dtTime+"/"+screenShotName+".png";
			File destination = new File(dest);
			try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return dest;
		}
	
	//Compare a text and an attribute value of an element
	public static void CompareAttributeText(String attribute, String s, WebElement Element) throws InterruptedException, AWTException, AssertionError { 
		try {
			String t = Element.getAttribute(attribute);
			assertEquals(s, t);
		}		
		catch (AssertionError ex) {
			System.out.println("Assertion fail");
			throw ex;
		}
	}
}
