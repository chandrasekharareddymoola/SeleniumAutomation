package Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.eagle.ConfigUtils.ReadObject;
import com.eagle.pages.BasePage;
import com.eagle.selenium.data_scientist.ReadObject111;

import io.github.bonigarcia.wdm.WebDriverManager;

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
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class analaysisTest { 

	public static WebDriver webdriver;

	public static WebDriverWait wait;

	public static void main(String[]args) throws InterruptedException,
	IOException, AWTException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
		webdriver = new ChromeDriver(options); 

		ReadObject object = new ReadObject(); 
		Properties configObject =  object.getObjectRepositoty();
		wait = new WebDriverWait(webdriver,60);

		webdriver.get("https://ediscover-typedb.edatascientist.com/ ");

		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))); 
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));


		String email = configObject.getProperty("Username"); 
		String emailPass =	configObject.getProperty("Password");

		username.sendKeys(email); 
		password.sendKeys(emailPass); 
		login.click();
		Thread.sleep(5000);

		WebElement AnalysisIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-icon-name='LineChart']")));
		customclick(AnalysisIcon);

		WebElement AddAnalysisButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@scraper-tag='newAnalysisButton']//span[text()='Analysis']")));
		customclick(AddAnalysisButton);

		WebElement AnalysisNameText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Name']//parent::div//*[@type='text']")));
		customclick(AnalysisNameText);
		AnalysisNameText.sendKeys("Analysis123");

		WebElement AnalysisDescText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Description']//parent::div//following-sibling::div//*[@class='ms-TextField-wrapper']//child::textarea")));
		customclick(AnalysisDescText);
		AnalysisDescText.sendKeys("AnalysisDesc123");

		WebElement studySelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='listbox']")));
		customclick(studySelection);
		WebElement studyselect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='listbox']//*[@data-automationid='splitbuttonprimary']//span[text()='Eagle Study A']")));
		customclick(studyselect);

		WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//span[contains(text(),'Save')]")));
		customclick(saveButton);

		WebElement clickCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-icon-name='CircleAdditionSolid']")));
		customclick(clickCircle);

		WebElement visualizeDataButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Visualise Data']")));
		customclick(visualizeDataButton);

		//		WebElement entityselect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Organism']")));
		//		customclick(entityselect);
		//		
		//		WebElement featureSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Broiler']//preceding-sibling::input")));
		//		customclick(featureSelect);

		WebElement entityselect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='subject']")));
		customclick(entityselect);

		Thread.sleep(5000);
		
		WebElement featureSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='disease']//preceding-sibling::input")));
		customclick(featureSelect);
		
		WebElement categoryListbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='disease']//parent::li//i[@data-icon-name='ChevronRight']")));
		customclick(categoryListbutton);
		
		WebElement CategoryAllButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'CategoricalSummary')]//li//span[text()='ALL']")));
		customclick(CategoryAllButton);
		
		WebElement Categorylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')])//span")));
		List <WebElement> CategoryListelements =  webdriver.findElements(By.xpath("(//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')])//span"));
		int sizeOfElements = CategoryListelements.size();
		for (int i=1; i<=sizeOfElements;i++) 
		{
			WebElement Listname = webdriver.findElement(By.xpath("(//div[contains(@class,'CategoricalSummary')]//li//div[contains(@class,'CategoricalSummary')]//span)["+i+"]"));
			String name = Listname.getText();
			System.out.println(name);
		}
		
//		customclick(Categorylist);
				
		WebElement CategoryCancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Cancel']")));
//		customclick(CategoryCancel);
		
		WebElement Categoryaddtoselection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add to my selection']")));
//		customclick(Categoryaddtoselection);
		
		WebElement Categoryback = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='ChevronLeft']")));
		customclick(Categoryback);
		
		
		
		
		
		WebElement featureSelect2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='body_mass_index']//preceding-sibling::input")));
		customclick(featureSelect2);
		
		WebElement summaryListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='body_mass_index']//parent::li//i[@data-icon-name='ChevronRight']")));
		customclick(summaryListButton);
		
		WebElement SummaryText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'NumericalSummary')]//div//span[text()='SUMMARY']")));
		customclick(SummaryText);
		
		List <WebElement> SummaryListelements =  webdriver.findElements(By.xpath("(//div[contains(@class,'NumericalSummary')]//li)//span[1]"));
		int sizeOfElements2 = SummaryListelements.size();
		for (int i=1; i<=sizeOfElements2;i++) 
		{
			WebElement Listname2 = webdriver.findElement(By.xpath("(//div[contains(@class,'NumericalSummary')]//li)["+i+"]//span[1]"));
			String name2 = Listname2.getText();
			System.out.println(name2);
		}
		
		WebElement RANGEtext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'NumericalSummary')])//span[text()='RANGE']")));
		customclick(RANGEtext);
		
		WebElement MinimumValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'NumericalSummary')])//span[contains(text(),'Minimun value')]")));
		customclick(MinimumValue);
		
		WebElement MaximumValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'NumericalSummary')])//span[contains(text(),'Maximum value')]")));
		customclick(MaximumValue);
		
		WebElement EditMin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='edit_min']")));
		customclick(EditMin);
		
		WebElement EditMax = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='edit_max']")));
		customclick(EditMax);
		
		WebElement CategoryCancel2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Cancel']")));
//		customclick(CategoryCancel2);
		
		WebElement Categoryaddtoselection2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add to my selection']")));
//		customclick(Categoryaddtoselection2);
		
		WebElement Categoryback2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='ChevronLeft']")));
		customclick(Categoryback2);
		
		WebElement featureminimizeclose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='disease']//preceding::button//i[@data-icon-name='BackToWindow']")));
		customclick(featureminimizeclose);
		
//		WebElement applyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Apply']")));
//		customclick(applyButton);
		
		WebElement mySelectionScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-icon-name='Back']")));
		customclick(mySelectionScreen);
		
		WebElement getDataButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Get Data']")));
		customclick(getDataButton);
		
		Thread.sleep(10000);
		
		Actions builder = new Actions(webdriver);
//		WebElement fromElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='common_name']")));
		WebElement fromElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='disease']")));
//		WebElement toElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='EmptyPlot']//i[@data-icon-name='ReceiptForward']")));
		WebElement toElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='dragArea'])[2]")));
		
		
//		//Building a drag and drop action
//		Action dragAndDrop = builder.clickAndHold(fromElement)
//		.moveToElement(toElement)
//		.release(toElement)
//		.build();
//		
//		dragAndDrop.perform();
		
//		builder.dragAndDrop(fromElement, toElement).build().perform();
//		System.out.println("End");
		
//		Actions builder = new Actions(_controls.getDriver());
//		Action dragAndDrop =
//		builder.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build();
//		Thread.sleep(2000);
//		dragAndDrop.perform();
		
//		Action dragAndDrop = builder.moveToElement(fromElement).clickAndHold(fromElement).moveByOffset(400,60).release().build();
//		dragAndDrop.perform();
		
//		builder.dragAndDrop(fromElement,toElement).perform();
		
		dragAndDrop(fromElement,toElement);
		Thread.sleep(10000);
		
		
		
		System.out.println("End");
		
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
	
	public static void dragAndDrop(WebElement from, WebElement to) {
        JavascriptExecutor js = (JavascriptExecutor)webdriver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                        + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                        + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                        + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                        + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);", from, to);
    }
	
}


//1 Cat
//*[@class='draglayer cursor-crosshair'] = bar chart
//*[@class='trace treemap']  = Tree map
//*[@class='draglayer cursor-crosshair'] = pareto chart

//2 cat
//*[@class='trace treemap']  = Tree map
//*[@class='draglayer cursor-crosshair'] = Stacked bar chart
//*[@class='table'] = contingency table

//1 numerical
//*[@class='draglayer cursor-crosshair'] = Histogram
//*[@class='draglayer cursor-crosshair'] = Box plot 
//*[@class='draglayer cursor-crosshair'] = KDE plot
//*[@class='draglayer cursor-crosshair'] = Violin plot

//2 numericals
//*[@class='draglayer cursor-crosshair'] = Scatter plot

//Multiple numerical plots
//*[@class='draglayer cursor-crosshair'] = Scatter plot matrix

//Multiple numerical plots and a Categorical plot
//*[@class='draglayer cursor-crosshair'] = Scatter plot matrix

//1 Categorical and 1 numerical plot
//*[@class='draglayer cursor-crosshair'] = Overlayed Histogram
//*[@class='draglayer cursor-crosshair'] = Side by Side Box plot
//*[@class='svg_kde_g'] = Overlayed KDE plot
//*[@class='draglayer cursor-crosshair'] = Side by Side Violin plot


