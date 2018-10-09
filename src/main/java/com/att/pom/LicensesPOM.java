package com.att.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.att.base.BaseTest;

public class LicensesPOM extends BaseTest{
	
	@FindBy(xpath="//div[@class='pagetitle' and text()='Licenses']")
	WebElement AttLicensesPageName;
	
	//Initialization
	public LicensesPOM() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLicensesPageName() {
		String x = AttLicensesPageName.getText();
		return x;
	}
}
