package Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.eagle.ConfigUtils.ReadObject;
import com.eagle.pages.BasePage;
import com.eagle.pages.LoginPage;
import com.eagle.pages.SetPage;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;


public class M_Rough extends SetPage { 
	public M_Rough() throws InterruptedException, AWTException {
		super();
		// TODO Auto-generated constructor stub
	}

	static SetPage objSetPage; 

	public static void main(String[]args) throws InterruptedException,
	IOException, AWTException {



		System.setProperty("webdriver.chrome.driver","./Resources/chromedriver.exe");

		WebDriver webdriver;

		//		ChromeOptions option = new ChromeOptions();
		//		option.addArguments("--disable-extensions");
		//		option.setExperimentalOption("useAutomationExtension",false);
		//		option.addArguments("--start-maximized");

		webdriver = new ChromeDriver(); 

		WebDriverWait wait = new WebDriverWait(webdriver,60);

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

		myData.click();
		Thread.sleep(5000);

		WebElement opn = webdriver.findElement(By.xpath("//div[@class='ms-List']//div[@role='rowheader' and @aria-colindex='1']//div[@title='Share Set1']")); 
		opn.click();
		//		BasePage.click(opn);
		Thread.sleep(10000);
		WebElement expand = webdriver.findElement(By.xpath("//i[@data-icon-name='MiniExpand']")); 
		expand.click();
		Thread.sleep(120000);
		//		BasePage.click(expand);
		try {
			WebElement Forward = webdriver.findElement(By.xpath("//i[@data-icon-name='Forward']"));
		}
		catch (Exception ex) {}
		WebElement edit = webdriver.findElement(By.xpath("//span[contains(text(),'Edit')]")); 
		edit.click();
		//		BasePage.click(edit);  
		List<String>  myAlist = new ArrayList<String>();

		myAlist.add("EFO_1000779");
		myAlist.add("EFO_1000778");
		myAlist.add("seborrheic keratosis");
		myAlist.add("EFO_1000758");
		myAlist.add("EFO_1000745");

//		try {
			//			{ 
		//div[@class='TableRowDefault__td___39_xA']
			for(String item : myAlist)
			{
				for (WebElement element : webdriver.findElements(By.xpath("//div[@class='TableRowDefault__bodyRow___1_m1h']//div[@class='TableRowDefault__td___39_xA'][1]"))) {
//					JavascriptExecutor js = (JavascriptExecutor) driver;
//					js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
//					js.executeScript("arguments[0].scrollIntoView(true);", element);
					String textFromGrid = element.getText();

					if(item.equals(textFromGrid)) {
						WebElement checkBox = element.findElement(By.tagName("i"));
						checkBox.click();			    				
					}
				}
			}
			//			}
			//				BasePage.click(Forward); 
			//			}
			//			while(Forward.isEnabled());  
//		}	    	
//		catch(Exception ex) {}

		WebElement remove = webdriver.findElement(By.xpath("//span[contains(text(),'Remove Items')]"));
		remove.click();
		//		BasePage.click(remove);

		WebElement saveChanges = webdriver.findElement(By.xpath("//span[contains(text(),'Save Changes')]"));
		saveChanges.click();
		//		BasePage.click(saveChanges); 
		System.out.println("Items removed successfully");













		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='NAME']")));
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]"))));
		//
		//		String noOfPages = webdriver.findElement(By.xpath( ("(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]"))).getText();
		//
		//		if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size() != 0) {
		//			WebElement a = webdriver.findElement(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']"));
		//			((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", a);
		//
		//			WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']//parent::div//parent::div//child::button")));
		//			threeButton.click();
		//			WebElement clickDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
		//			clickDelete.click();
		//			WebElement cancelDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
		//			WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
		//			confirmDelete.click();
		//		}
		//
		//		else if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size()== 0) {
		//
		//			for (int i=0; i<Integer.valueOf(noOfPages);i++) {
		//
		//				if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size() != 0) {
		//
		//					WebElement a = webdriver.findElement(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']"));
		//					((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", a);
		//
		//					WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']//parent::div//parent::div//child::button")));
		//					threeButton.click();
		//					WebElement clickDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
		//					clickDelete.click();
		//					WebElement cancelDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
		//					WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
		//					confirmDelete.click();
		//					break;
		//				}
		//				else {
		//					webdriver.findElement(By.xpath("//*[@data-icon-name='Forward']")).click();
		//					Thread.sleep(2000);
		//				}
		//			}
		//		}
		//		else  {
		//
		//			System.out.print("The set to be deleted is not found");
		//		}

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
		//		//String entityName = configObject.getProperty("Entity"); 
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
		//		WebElement expand = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='MiniExpand']")));
		//		expand.click();
		//
		//		Thread.sleep(2000);
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
		//		WebElement clickUpload = webdriver.findElement(By.xpath("//*[text()='browse/upload']"));
		//		clickUpload.click();
		//
		//		StringSelection ss = new StringSelection("C:\\Users\\MugunthRaman\\git\\SeleniumAutomation (2021-03)\\SeleniumAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
		//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//
		//		//imitate mouse events like ENTER, CTRL+C, CTRL+V
		//		Robot robot = new Robot();
		//		robot.delay(250);
		//		robot.keyPress(KeyEvent.VK_ENTER);
		//		robot.keyRelease(KeyEvent.VK_ENTER);
		//		robot.keyPress(KeyEvent.VK_CONTROL);
		//		robot.keyPress(KeyEvent.VK_V);
		//		robot.keyRelease(KeyEvent.VK_V);
		//		robot.keyRelease(KeyEvent.VK_CONTROL);
		//		robot.keyPress(KeyEvent.VK_ENTER);
		//		robot.delay(90);
		//		robot.keyRelease(KeyEvent.VK_ENTER);
		//
		//		Thread.sleep(5000);
		//	    
		//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Searching in ']")));
		//		
		//	    String uploadedFileName = webdriver.findElement(By.xpath("//*[text()='Searching in ']//parent::div//child::b")).getText();
		//		
		//	    Assert.assertEquals(uploadedFileName, "Q4 - Upload file - 1 (2).xlsx");
		//	    
		////		option.addArguments("Zoom 67%");
		//	    
		//	    webdriver.findElement(By.xpath("//*[text()='Add Items from a File']")).click();
		//	    
		//	    Actions action = new Actions(webdriver);
		//	    

		webdriver.close();
	}
}






//Add from set

//WebElement Edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Edit')]")));
//Page.click(Edit);
//WebElement addItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items']")));
//Page.click(addItem);
//WebElement addFromSet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='From a Set']")));
//Page.click(addFromSet);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Select a Set']")));
//WebElement searchSettoAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search for a set']")));
//Page.click(searchSettoAdd);
//searchSettoAdd.sendKeys(configObject.getProperty("SetNameToAddFrom"));
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='"+configObject.getProperty("SetNameToAddFrom")+"']")));
//webdriver.findElement(By.xpath("//*[@title='"+configObject.getProperty("SetNameToAddFrom")+"']")).click();
//Thread.sleep(3000);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Today Sept 29']"))); //name of the primary set
//WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Close']")));
//WebElement SaveChanges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Save Changes']")));
//Page.click(SaveChanges);


//Add from Catalog

//WebElement Edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Edit')]")));
//Page.click(Edit);
//WebElement addItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items']")));
//Page.click(addItem);
//WebElement addFromCatalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='From the Catalog']")));
//Page.click(addFromCatalog);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items from the Catalog']")));
//WebElement searchSettoAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='SetCardSearch-SearchBox']")));
//Page.click(searchSettoAdd);
//searchSettoAdd.sendKeys(configObject.getProperty("textToAddFromCatalog"));
//Thread.sleep(3000);
//WebElement addAllItemsCatalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Add all items']")));
//Page.click(addAllItemsCatalog);
//WebElement cancelItemCatalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
//WebElement AddButtonCatalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add']")));
//Page.click(AddButtonCatalog);
//Thread.sleep(3000);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Today Sept 29']"))); //name of the primary set
//WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Close']")));
//WebElement SaveChanges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Save Changes']")));
//Page.click(SaveChanges);


//Grid settings   //verification to be covered

//WebElement gridSettings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-icon-name='Settings']")));
//Page.click(gridSettings);
//
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Grid Settings']")));
//
//WebElement rowsDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Rows Per Page']//parent::div//following-sibling::div//div[@role='listbox']")));
//Page.click(rowsDropdown);
//WebElement selectNoOfRows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='"+configObject.getProperty("gridValue") +"']")));
//Page.click(selectNoOfRows);
//
//WebElement PrimaryColumnDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Primary column']//parent::div//following-sibling::div//div[@role='listbox']")));
//Page.click(PrimaryColumnDropdown);
//WebElement selectPrimaryColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='option' and @title='"+configObject.getProperty("primaryColumn")+"']")));
//Page.click(selectPrimaryColumn);
//
//WebElement SecondaryColumnDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Secondary column']//parent::div//following-sibling::div//div[@role='listbox']")));
//Page.click(SecondaryColumnDropdown);
//WebElement selectSecondaryColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='option' and @title='"+configObject.getProperty("secondaryColumn")+"']")));
//Page.click(selectSecondaryColumn);
//
//WebElement cancelGrid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
//WebElement ApplyGrid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Apply']")));
//Page.click(ApplyGrid);
//Thread.sleep(5000);
//
//List Columns = webdriver.findElements(By.xpath("//*[@tabindex='0']"));
//int NoOfColumns = Columns.size();
//System.out.println(NoOfColumns);        //getting the number of columns



//Delete Card expanded view  //verification needs to be covered

//WebElement deleteCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete Card']")));
//deleteCard.click();
//Thread.sleep(2000);
//WebElement cancelDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
//WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
//confirmDelete.click();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='MY DATA']"))); //My Data page


//Search in Expanded view   //verification needs to be covered

//WebElement setSearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='searchbox']")));
//setSearchBox.click();
//Thread.sleep(2000);
//setSearchBox.sendKeys(configObject.getProperty("searchInSet"));
//Thread.sleep(2000);


//Upload from file

//WebElement Edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Edit')]")));
//Edit.click();
//WebElement addItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add Items']")));
//addItem.click();
//WebElement addFromFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='From a file']")));
//addFromFile.click();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Drag files here']")));
//WebElement FileSelectDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ms-Dropdown-container']")));
//FileSelectDropdown.click();
//Thread.sleep(5000);
//webdriver.findElement(By.xpath("//*[@title='Disease']")).click();
//WebElement clickUpload = webdriver.findElement(By.xpath("//*[text()='browse/upload']"));
//clickUpload.click();
//StringSelection ss = new StringSelection("C:\\Users\\MugunthRaman\\git\\SeleniumAutomation (2021-03)\\SeleniumAutomation\\Resources\\Q4 - Upload file - 1 (2).xlsx");
//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
////imitate mouse events like ENTER, CTRL+C, CTRL+V
//Robot robot = new Robot();
//robot.delay(250);
//robot.keyPress(KeyEvent.VK_ENTER);
//robot.keyRelease(KeyEvent.VK_ENTER);
//robot.keyPress(KeyEvent.VK_CONTROL);
//robot.keyPress(KeyEvent.VK_V);
//robot.keyRelease(KeyEvent.VK_V);
//robot.keyRelease(KeyEvent.VK_CONTROL);
//robot.keyPress(KeyEvent.VK_ENTER);
//robot.delay(90);
//robot.keyRelease(KeyEvent.VK_ENTER);
//Thread.sleep(5000);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Searching in ']")));
//String uploadedFileName = webdriver.findElement(By.xpath("//*[text()='Searching in ']//parent::div//child::b")).getText();
//Assert.assertEquals(uploadedFileName, "Q4 - Upload file - 1 (2).xlsx");
////option.addArguments("Zoom 67%");
//webdriver.findElement(By.xpath("//*[text()='Add Items from a File']")).click();
//Actions action = new Actions(webdriver);
//for (int i=0; i<4; i++) {
//action.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();
//}
//Thread.sleep(2000);
//WebElement addAllItemsUpload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add all items']")));
//addAllItemsUpload.click();
//WebElement cancelUpload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
//WebElement addToGrid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add To Grid']")));		
//addToGrid.click();
//for (int i=0; i<4; i++) {
//webdriver.findElement(By.xpath("//html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ADD));
//}
//Thread.sleep(5000);


//Delete a set My Data


//myData.click();
//
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='NAME']")));
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]"))));
//
//String noOfPages = webdriver.findElement(By.xpath( ("(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]"))).getText();
//
//if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size() != 0) {
//WebElement a = webdriver.findElement(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']"));
//((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", a);
//
//WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']//parent::div//parent::div//child::button")));
//threeButton.click();
//WebElement clickDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
//clickDelete.click();
//WebElement cancelDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
//WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
//confirmDelete.click();
//}
//
//else if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size()== 0) {
//
//for (int i=0; i<Integer.valueOf(noOfPages);i++) {
//
//if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size() != 0) {
//	
//	WebElement a = webdriver.findElement(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']"));
//	((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", a);
//	
//	WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']//parent::div//parent::div//child::button")));
//	threeButton.click();
//	WebElement clickDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
//	clickDelete.click();
//	WebElement cancelDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
//	WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
//	confirmDelete.click();
//	break;
//}
//else {
//	webdriver.findElement(By.xpath("//*[@data-icon-name='Forward']")).click();
//	Thread.sleep(2000);
//}
//}
//}
//else  {
//
//System.out.print("The set to be deleted is not found");
//}


//Share a set

//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]"))));
//
//String noOfPages = webdriver.findElement(By.xpath( ("(//*[@class='PaginationControls__message___Zodph'])[2]//b[2]"))).getText();
//
//if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size() != 0) {
//	WebElement a = webdriver.findElement(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']"));
//	((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", a);
//
//	WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']//parent::div//parent::div//child::button")));
//	threeButton.click();
//	WebElement clickShare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Share']")));
//	customclick(clickShare);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='heading' and text()='Share']")));
//	WebElement ShareWith = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Select one or more users']")));
//	String name = "functional";
//	ShareWith.sendKeys(name);
//	WebElement username2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+name+"')]")));
//	customclick(username2);
//	WebElement cancelDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
//	WebElement ConfirmShare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='button']//*[text()='Share']")));
//	customclick(ConfirmShare);
//}
//
//else if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size()== 0) {
//
//	for (int i=0; i<Integer.valueOf(noOfPages);i++) {
//
//		if (webdriver.findElements(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']")).size() != 0) {
//
//			WebElement a = webdriver.findElement(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']"));
//			((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", a);
//
//			WebElement threeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ configObject.getProperty("setToDelete")+"']//parent::div//parent::div//child::button")));
//			threeButton.click();
//			WebElement clickShare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Share']")));
//			customclick(clickShare);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='heading' and text()='Share']")));
//			WebElement ShareWith = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Select one or more users']")));
//			String name = "functional";
//			ShareWith.sendKeys(name);
//			WebElement username2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+name+"')]")));
//			customclick(username2);
//			WebElement cancelDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cancel']")));
//			WebElement ConfirmShare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='button']//*[text()='Share']")));
//			customclick(ConfirmShare);
//			break;
//		}
//		else {
//			webdriver.findElement(By.xpath("//*[@data-icon-name='Forward']")).click();
//			Thread.sleep(2000);
//		}
//	}
//}
//else if (!webdriver.findElement(By.xpath("//*[@data-icon-name='Forward']")).isEnabled()) {		
//	System.out.print("The set to be deleted is not found");
//}
//else  {
//
//	System.out.print("The set to be deleted is not found");

