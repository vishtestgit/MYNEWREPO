package com.att.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.att.base.BaseTest;

public class ReportsPOM extends BaseTest{

	@FindBy(xpath="//span[text()='Create Report']")
	WebElement AttCreateReportsBtn;
	
	
	public ReportsPOM() {
		PageFactory.initElements(driver, this);
	}
	
	public ChooseReportToCreatePOM validateClickOnCreateReportBtn() {
		AttCreateReportsBtn.click();
		return new ChooseReportToCreatePOM();
	}
	
	
}
