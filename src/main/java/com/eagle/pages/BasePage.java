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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage{

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

	public static void enterUserPass(WebElement user, WebElement pass) throws InterruptedException, AWTException {		
		click(user);	user.sendKeys(userName);
//		Thread.sleep(1000);
//		if(pass.isDisplayed()) {
			click(pass);	pass.sendKeys(passWord);	
//		}
	}

	public static void click(WebElement element) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			element.click();
		} catch (Exception e) {
			scrollIntoView(element);
			element.click();
		}
	}	

	public static void verifyPage(String ItemToVerify, WebElement field) throws InterruptedException, AWTException, AssertionError {		
		try {
			BasePage.waitforAnElement(field);
			String getheadertext = field.getText().trim();
			Assert.assertEquals(ItemToVerify, getheadertext);
		}
		catch (Exception | AssertionError ex) {
			throw ex;
		}
	}

	public static void scrollIntoView(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scrollToTop() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public static void enterText(WebElement field, String value) throws InterruptedException, AWTException {
		if (!value.equalsIgnoreCase("nil")) {			
			BasePage.click(field);
			field.sendKeys(Keys.CONTROL + "a");		
			field.sendKeys(Keys.DELETE);
			field.sendKeys(value);
		}
	}	

	public static void waitforAnElement(WebElement Element) throws InterruptedException, AWTException{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(Element));	
	}

	public static void waitforAnElementtoBeClicked(WebElement Element) throws InterruptedException, AWTException{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(Element));	
	}

	public static void waitforAnElementClickable(WebElement Element) throws InterruptedException, AWTException{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Element));	
	}

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
