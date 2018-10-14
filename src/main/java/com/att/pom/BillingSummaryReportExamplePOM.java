package com.att.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.att.base.BaseTest;

public class BillingSummaryReportExamplePOM extends BaseTest{

	@FindBy(xpath="//h1[text()='Billing Summary Report Examples']")
	WebElement AttBillingSummaryReportHeading;
	
	@FindBy(xpath="//select[@name='selector']")
	WebElement AttSwitchToTheSectionListBox;
	
	
	//Initialization
	public BillingSummaryReportExamplePOM() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateBillingSummaryReportHeading() {
			return getTextAndCloseChildWindow(AttBillingSummaryReportHeading);
	}

	public boolean validateSwitchToSectionListItemsAndHeading(String listOption) {
		
		String listOptionStringForXpath = listOption.replace("--- ", "");
		
		switchToChildWindow();
		
		String windowHeadingXpath = "//h2[contains(text(),'"+listOptionStringForXpath+"')]";
		selectSingleDropDownItem(driver, AttSwitchToTheSectionListBox, listOption);
		String foundWindowHeading = driver.findElement(By.xpath(windowHeadingXpath)).getText();

		switchToMainWindow();
		
		boolean hFound;
		if(foundWindowHeading.contains(listOptionStringForXpath)){
			hFound = true;
		}else {
			hFound = false;
		}

		return hFound;
	}

}
