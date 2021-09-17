package com.eagle.selenium.data_scientist;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.*;


/**
 * Hello world!
 *
 *
 *
 *
 */	

  public class App { private static Logger logger =
  LoggerFactory.getLogger(App.class);
  
  public static void main( String[] args ) throws InterruptedException,
  IOException {
  
  //Multilevel inheritance program
  
  
  
  System.out.println( "Hello World!" );
  System.setProperty("webdriver.chrome.driver","./Resources/chromedriver.exe");
  
  WebDriver webdriver;
  
  ChromeOptions option = new ChromeOptions();
  option.addArguments("diable-extensions");
  option.setExperimentalOption("useAutomationExtension",false);
  option.addArguments("--start-maximized");
  
  webdriver = new ChromeDriver(option); webdriver.manage().window().maximize();
  
  ReadObject111 object = new ReadObject111(); Properties configObject =
  object.getObjectRepositoty();
  
  
  webdriver.get("https://ediscover-qa.edatascientist.com/");
  //Thread.sleep(1000000);
  
  
  WebDriverWait wait = new WebDriverWait(webdriver,Integer.parseInt("60") );
  WebElement username =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
  WebElement password =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))
  ); WebElement login =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
  
  String email = configObject.getProperty("Username"); String emailPass =
  configObject.getProperty("Password");
  
  username.sendKeys(email); password.sendKeys(emailPass); login.click();
  Thread.sleep(5000);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//i[@data-icon-name='Home']")));
  
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//i[@data-icon-name='DocumentSet']"))).click();
  
  WebElement setAdd =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//div//span[contains(text(),'Set')]"))); setAdd.click();
  
  WebElement setUncategorized =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//div//span[contains(text(),'Uncategorized')]")));
  
  
  WebElement setName =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//div//input[@type='text']")));
  
  setName.click(); Thread.sleep(2000); setName.sendKeys(Keys.CONTROL + "a");
  setName.sendKeys(Keys.DELETE); String createSet =
  configObject.getProperty("SetName"); setName.sendKeys(createSet);
  
  
  Thread.sleep(2000);
  
  setUncategorized.click(); String entityName =
  configObject.getProperty("Entity"); WebElement entitySelection =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//button//span[contains(text(),'"+ entityName +"')]")));
  entitySelection.click();
  
  String searchTextTobeEntered = configObject.getProperty("SearchText");
  WebElement searchBox =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//div//input[@role='searchbox']"))); searchBox.click();
  searchBox.sendKeys(searchTextTobeEntered);
  
  Thread.sleep(4000);
  
  WebElement addAll =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.
  xpath("//div//span[contains(text(),'Add all items')]"))); addAll.click();
  
  
  WebElement accept =
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//div//span[contains(text(),'Accept')]"))); accept.click();
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//i[@data-icon-name='MiniExpand']")));
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		  "//i[@data-icon-name='MiniExpand']"))).click();
  
  Thread.sleep(2000);
  

  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		  "//span[contains(text(),'Edit')]"))).click();
  
  List<WebElement> ccs = webdriver.findElements(By.
		  xpath("//div[@class='TableRowDefault__bodyRow___1_m1h']//div[@class='TableRowDefault__td___39_xA'][1]" ));
		  
		  for (WebElement element : ccs) {
		  
		  
		  WebElement titleOfLatestSet = element.findElement(By.tagName("i"));
		 
		  
			 
		 
		  titleOfLatestSet.click();
		  
		  System.out.println( "It is not there!!!!" + titleOfLatestSet);
		  
		  } 
		  
		  
  
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
  "//i[@data-icon-name='DocumentSet']"))).click();
  
  Thread.sleep(2000);
  
  List<WebElement> listOfElements = webdriver.findElements(By.
  xpath("//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']//div"
  ));
  
  for (WebElement element : listOfElements) {
  
  
  String titleOfLatestSet = element.getAttribute("title");
  
  
  if(titleOfLatestSet.equalsIgnoreCase(createSet)){
  
  System.out.println( "Created Set is found in Sets list!!!!" ); break;
  
  } else{ System.out.println( "It is not there!!!!" );
  
  } }
  
  
  webdriver.close();
  
  
  
  } }
 
