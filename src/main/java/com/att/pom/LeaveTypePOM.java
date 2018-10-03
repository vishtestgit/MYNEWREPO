package com.att.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.att.base.BaseTest;

public class LeaveTypePOM extends BaseTest{
	
	@FindBy(xpath="//td[contains(text(),'Leave Types')]")
	WebElement AttLeaveTypePageName;
	
	//Initialization
	public LeaveTypePOM() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLeaveTypePageName() {
		String x = AttLeaveTypePageName.getText();
		return x;
	}
}
