package com.att.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.att.base.BaseTest;

public class ReportsPOM extends BaseTest{

	@FindBy(xpath="//a[@class='content reports']")
	WebElement AttReportsTabLink;
	
	
	public ReportsPOM() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateClickOnReportsTabLink() {
		AttReportsTabLink.click();
	}
	
	
}
