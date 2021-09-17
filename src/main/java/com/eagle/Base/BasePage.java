package com.eagle.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.eagle.pages.LoginPage;
import com.eagle.pages.Page;

public class BasePage {

	// protected
	public static WebDriver driver;
	protected Object m = null;
	// public static Properties properties;

	// properties = new Properties();
	// FileInputStream stream = new FileInputStream(new
	// File(System.getProperty("user.dir") + "\\Resources\\config.properties"));
	// properties.load(stream);

	public BasePage() {
		//Utility.driver = BasePage.driver;
	}

	/*
	 * public BasePage() { Utility.driver = BasePage.driver; }
	 */
	/*
	 * public LoginPage goToUrl(String data) throws InterruptedException {
	 * System.setProperty("webdriver.chrome.driver",
	 * "./Resources/chromedriver.exe");
	 * 
	 * ChromeOptions options = new ChromeOptions();
	 * options.addArguments("headless");
	 * options.addArguments("window-size=1200x600"); driver = new
	 * ChromeDriver(options);
	 * 
	 * driver = new ChromeDriver(); String baseUrl = data; driver.get(baseUrl);
	 * driver.manage().window().maximize(); return new LoginPage();
	 * 
	 * }
	 */
}
