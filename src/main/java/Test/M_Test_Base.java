package Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import com.eagle.pages.Page;
import com.eagle.selenium.data_scientist.ReadObject111;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.*;

public class M_Test_Base {

	public static void main(String[]args) throws InterruptedException,
	IOException, AWTException {

//		System.setProperty("webdriver.chrome.driver","./Resources/chromedriver.exe");
//
//		WebDriver webdriver;
//
//		webdriver = new ChromeDriver(); 
//		
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("diable-extensions");
//		option.setExperimentalOption("useAutomationExtension",false);
//		option.addArguments("--start-maximized");
//
//		WebDriverWait wait = new WebDriverWait(webdriver,60);
//
//		webdriver.manage().window().maximize();
//
//		ReadObject111 object = new ReadObject111(); 
//		Properties configObject =  object.getObjectRepositoty();
//
//
//		webdriver.get("https://ediscover-qa.edatascientist.com/");
//
//		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
//		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))); 
//		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
//
//
//		String email = configObject.getProperty("Username"); 
//		String emailPass =	configObject.getProperty("Password");
//
//		username.sendKeys(email); 
//		password.sendKeys(emailPass); 
//		login.click();
//		Thread.sleep(5000);
//
//		WebElement Home = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='Home']")));
//		WebElement myData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='DocumentSet']")));
//
//		myData.click();
//
//		WebElement setAdd =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(),'Set')]"))); setAdd.click();
//		WebElement setUncategorized = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(),'Uncategorized')]")));
//		WebElement setName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[@type='text']")));
//
//		setName.click(); 
//		Thread.sleep(2000); 
//		setName.sendKeys(Keys.CONTROL + "a");
//		setName.sendKeys(Keys.DELETE); 
//		String createSet =	configObject.getProperty("SetName"); 
//		setName.sendKeys(createSet);
//
//
//		Thread.sleep(2000);
//
//		setUncategorized.click(); 
//		//		String entityName = configObject.getProperty("Entity"); 
//		WebElement entitySelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//span[contains(text(),'Disease')]")));
//		entitySelection.click();
//
//		String searchTextTobeEntered = configObject.getProperty("SearchText");
//		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[@role='searchbox']"))); searchBox.click();
//		searchBox.sendKeys(searchTextTobeEntered);
//
//		Thread.sleep(4000);
//
//		WebElement addAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(),'Add all items')]"))); addAll.click();
//		WebElement accept =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(),'Accept')]"))); 
//		accept.click();
//
//		//		webdriver.findElement(By.xpath("//*[@title='Today Aug 12']")).click();
//
//		//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(emailPass)));
//
//		WebElement expand = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='MiniExpand']")));
//		expand.click();
//
//		Thread.sleep(2000);
//
//		WebElement SortColumnname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + configObject.getProperty("SortColumn") + "']")));
//		//		Thread.sleep(50000);
//
//		SortColumnname.click();
//		//		Thread.sleep(10000);
//
//		WebElement Edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Edit')]")));
//		Edit.click();
//
//		WebElement addItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items']")));
//		addItem.click();
//
//		WebElement addFromFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='From a file']")));
//		addFromFile.click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Drag files here']")));
//
//		WebElement FileSelectDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ms-Dropdown-container']")));
//		FileSelectDropdown.click();
//		Thread.sleep(5000);
//
//		webdriver.findElement(By.xpath("//*[@title='Disease']")).click();
//
//
//		WebElement clickUpload = webdriver.findElement(By.xpath("//*[text()='browse/upload']"));
////		clickUpload.click();
//		
//		
//		WebElement droparea = webdriver.findElement(By.xpath("//*[text()='browse/upload']"));
//
//		// drop the file
//		DropFile(new File(""+configObject.getProperty("uploadFileLocation")+""), droparea, 0, 0);
//		
//		Thread.sleep(5000);
//
//
//		//		WebElement addFromSet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='From a Set']")));
//		//		addFromSet.click();
//		//		
//		//		
//		//		
//		//		
//		//		WebElement addFromCatalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='From the Catalog']")));
//		//		addFromCatalog.click();
//
//		webdriver.close();
//
//	} 
//	
//	public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
//	    if(!filePath.exists())
//	        throw new WebDriverException("File not found: " + filePath.toString());
//
//	    WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
//	    JavascriptExecutor jse = (JavascriptExecutor)driver;
//	    WebDriverWait wait = new WebDriverWait(driver, 30);
//
//	    String JS_DROP_FILE =
//	        "var target = arguments[0]," +
//	        "    offsetX = arguments[1]," +
//	        "    offsetY = arguments[2]," +
//	        "    document = target.ownerDocument || document," +
//	        "    window = document.defaultView || window;" +
//	        "" +
//	        "var input = document.createElement('INPUT');" +
//	        "input.type = 'file';" +
//	        "input.style.display = 'none';" +
//	        "input.onchange = function () {" +
//	        "  var rect = target.getBoundingClientRect()," +
//	        "      x = rect.left + (offsetX || (rect.width >> 1))," +
//	        "      y = rect.top + (offsetY || (rect.height >> 1))," +
//	        "      dataTransfer = { files: this.files };" +
//	        "" +
//	        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
//	        "    var evt = document.createEvent('MouseEvent');" +
//	        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
//	        "    evt.dataTransfer = dataTransfer;" +
//	        "    target.dispatchEvent(evt);" +
//	        "  });" +
//	        "" +
//	        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
//	        "};" +
//	        "document.body.appendChild(input);" +
//	        "return input;";
//
//	    WebElement input =  (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
//	    input.sendKeys(filePath.getAbsoluteFile().toString());
//	    wait.until(ExpectedConditions.stalenessOf(input));
	}

}



