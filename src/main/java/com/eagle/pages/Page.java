package com.eagle.pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page{

    public static WebDriver driver;
    public static String userName;
    public static String passWord;
   
    public void setWebDriver(WebDriver driver) {
		Page.driver = driver;		
	}
    public void setUserName(String email) {
		Page.userName = email;		
	}
    public void setPassword(String emailPass) {
		Page.passWord = emailPass;		
	}
	
    public static void enterUserPass(WebElement user, WebElement pass) {		
			click(user);	user.sendKeys(userName);	
			click(pass);	pass.sendKeys(passWord);	
	}
   
	public static void click(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			element.click();
		} catch (Exception e) {
			//scrollIntoView(element);
			element.click();
		}
	}	
	
	public static void verifyPage(WebElement field) {		
			String getheadertext = field.getText().trim();
			assertEquals("Uncategorized", getheadertext);
	}
	
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void enterText(WebElement field, String value) {
		if (!value.equalsIgnoreCase("nil")) {
			click(field);
			field.sendKeys(Keys.CONTROL + "a");		
			field.sendKeys(Keys.DELETE);
			field.sendKeys(value);
		}
	}

}
