package com.att.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.att.base.BaseTest;

public class CreateNewProjectPOM extends BaseTest{

	//Create New Project Page name
	@FindBy(xpath="//td[contains(text(),'Create New Project')]")
	WebElement AttCreateNewProjectPageName;
	
	@FindBy(xpath="//select[@name='customerId']")
	WebElement AttCustomerNameListBox;
	
	
	@FindBy(xpath="//input[@name='name']")
	WebElement AttProjectNameTxtBox;
	
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement AttProjectDescTxtAreaBox;
	
	
	@FindBy(xpath="//input[@name='createProjectSubmit']")
	WebElement AttCreateProjectBtn;
	
		
	//Initialization
	public CreateNewProjectPOM() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateCreateNewProjectPageName() {
		String x = AttCreateNewProjectPageName.getText();
		return x.trim();
	}
	
	public void validateCreateNewProject(String cName, String pName, String pDesc) {
		selectSingleDropDownItem(driver, AttCustomerNameListBox, cName);
		AttProjectNameTxtBox.sendKeys(pName);
		AttProjectDescTxtAreaBox.sendKeys(pDesc);
		AttCreateProjectBtn.click();
	}
	
}
