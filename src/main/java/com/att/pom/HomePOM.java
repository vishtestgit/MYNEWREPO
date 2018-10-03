package com.att.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.att.base.BaseTest;
import com.att.util.TestUtil;

public class HomePOM extends BaseTest{
	
	TestUtil testUtil = new TestUtil();
	LeaveTypePOM leaveTypePOM = new LeaveTypePOM();
	BillingTypePOM billingTypePOM = new BillingTypePOM();
	
	@FindBy(xpath="//a[@id='profile-link']")
	WebElement AttProfileName;
	
	@FindBy(xpath="//a[@class='content tasks']")
	WebElement AttTasksTab;
	
	@FindBy(xpath="//a[@class='content reports']")
	WebElement AttReportsTab;
	
	String settingsMain ="//div[@class='popup_menu_icon settings_icon']";
	String settingsSubLeaveType ="//a[text()='Leave Types']";
	String settingsSubBillingType ="//a[text()='Billing Types']";
	
	
	String addOnMain="//div[@class='popup_menu_icon add_ons_icon']";
	String addOnSub="//a[@class='item_link has_icon mobile_icon']";
	
	
	String helpMain ="//div[@class='popup_menu_icon support_icon']";
	String helpSub="//a[text()='About actiTIME']";
	
	
	
	//Initialization
	public HomePOM() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateProfileName() {
		return AttProfileName.getText();
	}
	
	public TasksPOM validateTasksTab() {
		return new TasksPOM();
	}
	public ReportsPOM validateReportsTab() {
		return new ReportsPOM();
	}
	
	public TasksPOM validateTaskClick() {
		AttTasksTab.click();
		return new TasksPOM();
	}
	
	public String selectLeaveTypeMenu() {
		testUtil.clickOnSubMenu(driver,settingsMain,settingsSubLeaveType);
		String x = leaveTypePOM.validateLeaveTypePageName();
		return x;
	}
	
	public String selectBillingTypeMenu() {
		testUtil.clickOnSubMenu(driver,settingsMain,settingsSubBillingType);
		String x = billingTypePOM.validateBillingTypePageName();
		return x;
	}
	
}
