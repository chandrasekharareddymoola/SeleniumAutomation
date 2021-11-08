package com.eagle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	WebDriver driver;
	
	@FindBy(xpath = "//i[@data-icon-name='Home']")
	public WebElement homeIcon;
	
	@FindBy(xpath = "//i[@data-icon-name='Search']")
	public WebElement searchIcon;
	
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String getHomePageDashboardUserName(){
    	return searchIcon.getText();
    }
	        
}
