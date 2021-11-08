package Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.eagle.ConfigUtils.ReadObject;
import com.eagle.pages.BasePage;
import com.eagle.selenium.data_scientist.ReadObject111;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.AWTException;
import java.util.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;




public class M_Run { 

	public static WebDriver webdriver;

	public static WebDriverWait wait;

	public static void main(String[]args) throws InterruptedException,
	IOException, AWTException {

		System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
		webdriver = new ChromeDriver();
		wait = new WebDriverWait(webdriver,60);
		//		ChromeOptions option = new ChromeOptions();
		//        option.addArguments("diable-extensions");
		//        option.setExperimentalOption("useAutomationExtension",false);
		//        option.addArguments("--start-maximized");   


		webdriver.manage().window().maximize();

		ReadObject object = new ReadObject(); 
		Properties configObject =  object.getObjectRepositoty();


		webdriver.get("https://ediscover-qa.edatascientist.com/");

		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))); 
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));


		String email = configObject.getProperty("Username"); 
		String emailPass =	configObject.getProperty("Password");

		username.sendKeys(email); 
		password.sendKeys(emailPass); 
		login.click();
		Thread.sleep(5000);

		WebElement Home = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='Home']")));
		WebElement myData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='DocumentSet']")));

		//		myData.click();
		customclick(myData);

//		WebElement setAdd =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(),'Set')]"))); setAdd.click();
//		WebElement setUncategorized = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(),'Uncategorized')]")));
//		WebElement setName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[@type='text']")));
//
//		customclick(setName); 
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
//		//String entityName = configObject.getProperty("Entity"); 
//		WebElement entitySelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//span[contains(text(),'Disease')]")));
//		customclick(entitySelection);
//
//		String searchTextTobeEntered = configObject.getProperty("SearchText");
//		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[@role='searchbox']"))); searchBox.click();
//		searchBox.sendKeys(searchTextTobeEntered);
		

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='NAME']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]"))));

		String noOfPages = webdriver.findElement(By.xpath( ("(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]"))).getText();
		System.out.println(noOfPages);
		

		if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size() != 0) {
		WebElement a = webdriver.findElement(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']"));
		((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", a);
		System.out.println(noOfPages);
		WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']//parent::div//parent::div//child::button")));
		threeButton.click();
		System.out.println(noOfPages);
		WebElement clickDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
		clickDelete.click();
		System.out.println(noOfPages);
		WebElement cancelDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
		WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
		confirmDelete.click();
		}

		else if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size()== 0) {

		for (int i=0; i<Integer.valueOf(noOfPages);i++) {

		if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size() != 0) {
			
			WebElement a = webdriver.findElement(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']"));
			((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", a);
			
			WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']//parent::div//parent::div//child::button")));
			threeButton.click();
			WebElement clickDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
			clickDelete.click();
			WebElement cancelDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
			WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
			confirmDelete.click();
			break;
		}
		else {
			webdriver.findElement(By.xpath("//*[@data-icon-name='Forward']")).click();
			Thread.sleep(2000);
		}
		}
		}
		else  {

		System.out.print("The set to be deleted is not found");
		}


//		WebElement addAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(),'Add all items')]"))); 
//		//		addAll.click();
//		WebElement accept =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(),'Accept')]"))); 
//		//		customclick(accept);
//
////		WebElement addallgrey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ms-Button-label label-177' and text()='Add all items']")));
//		WebElement addallblack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ms-Button-label label-124' and text()='Add all items']")));
//		
////		while(addAll.isDisplayed()){		
////			do{   
////				Boolean s = addAll.isEnabled();
////				System.out.println(s);
////				customclick(addAll);	
////				Thread.sleep(2000);
////			}while(addallblack.isDisplayed());
////			customclick(accept);
////		}
////		
//
//
//
//
//		WebElement expand = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='MiniExpand']")));
//		customclick(expand);
//
//		//		Thread.sleep(2000);
//		//		
//		//		WebElement Settingsicon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-icon-name='Settings']")));
//		//		Thread.sleep(10000);
//		//
//		////		WebElement SortColumnname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+configObject.getProperty("SortColumn")+"']")));
//		////		Thread.sleep(5000);
//		//		
//		//		WebElement SortColumnname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+configObject.getProperty("SortColumn")+"']")));
//		//		Thread.sleep(5000);
//		//
//		//		WebElement NextColumnname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+configObject.getProperty("SortColumn")+"']//parent::div//parent::div/following-sibling::div")));
//		//		scrollIntoView(NextColumnname);
//		//		Thread.sleep(5000);
//		//
//		//		customclick(SortColumnname);
//		//		Thread.sleep(5000);
//		//		
//		//		customclick(SortColumnname);
//		//		Thread.sleep(5000);
//
//		//		List <WebElement> NoofRows = webdriver.findElements(By.xpath("//*[@class='TableRowDefault__bodyRow___1_m1h']"));
//		//        System.out.println(NoofRows.size());
//		//		webdriver.close();
//		//		
//		//		List <WebElement> ColumnNumber = webdriver.findElements(By.xpath("//*[text()='"+SortColumnname+"']//parent::div/parent::div/preceding-sibling::div"));
//		//		System.out.println(ColumnNumber.size());
	}

	public static void customclick(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			element.click();
		} catch (Exception e) {
			scrollIntoView(element);
			element.click();
		}
	}	

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) webdriver;
		//		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}




