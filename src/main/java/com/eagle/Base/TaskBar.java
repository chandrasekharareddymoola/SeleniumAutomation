package com.eagle.Base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.eagle.pages.Page;


public class TaskBar extends BasePage {
	public static Object task = new TaskBar();

	// home------------
	@FindBy(xpath = "//i[@data-icon-name='Home']")
	public WebElement home;
	  // investigations
	@FindBy(xpath = "//i[@data-icon-name='TestSuite']")
	public WebElement investigations;
	  // analysis
	@FindBy(xpath = "//i[@data-icon-name='LineChart']")
	public WebElement analysis;
	  // explorations
	@FindBy(xpath = "//i[@data-icon-name='Flow']")
	public WebElement explorations;
	  // comparisons
	@FindBy(xpath = "//i[@data-icon-name='BranchCompare']")
	public WebElement comparisons;
	  // Sets
	@FindBy(xpath = "//i[@data-icon-name='DocumentSet']") 
	public WebElement sets;
	
	

	public TaskBar() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
		super.m = TaskBar.task;
	}
	
	/*
	 * public void clickHome() { Utility.click(home); } public void
	 * clickInvestigation() { Utility.click(investigations); } public void
	 * clickAnalysis() { Utility.click(analysis); } public void clickExploration() {
	 * Utility.click(explorations); } public void clickComparison() {
	 * Utility.click(comparisons); } public void clickSets() { Utility.click(sets);
	 * }
	 * 
	 */

}

