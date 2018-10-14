package com.att.pom;

import java.util.List;

import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.att.base.BaseTest;

public class ChooseReportToCreatePOM extends BaseTest{

	@FindBy(xpath="//td[@class='dialog-title']")
	WebElement AttChooseReportTitle;
	
	@FindBy(xpath="//img[@id='closeLightbox']")
	WebElement AttChooseReportClose;
	
	@FindBy(xpath="//a[text()='See examples']")
	WebElement AttChooseReportSeeExampleLink;


	@FindBy(xpath="//div[@class='category-items']/div//span")
	List<WebElement> AttAllReportTabNameList;


	@FindBy(xpath="//div/h1")
	WebElement AttChooseReportSeeExampleWindowHeading;
	
	//Initialization
	public ChooseReportToCreatePOM() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateChooseReportWindowClose() {
		AttChooseReportClose.click();
	}

	public String validateChooseReportWindowTitle() {
		return AttChooseReportTitle.getText();
	}

	public void validateClickSeeExampleLinkByValue(String tabName){
		BaseTest.selectElementByListByTextOfAnElement(AttAllReportTabNameList, tabName);
		String currentTabNameXpath = "//div[contains(text(),'"+tabName+"')]/../p/a[text()='See examples']";
		driver.findElement(By.xpath(currentTabNameXpath)).click();
		
	}
	

}
	
	

