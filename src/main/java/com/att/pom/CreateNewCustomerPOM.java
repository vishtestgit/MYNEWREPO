package com.att.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.att.base.BaseTest;

public class CreateNewCustomerPOM extends BaseTest{

	//Create New Customer Page name
	@FindBy(xpath="//td[contains(text(),'Create New Customer')]")
	WebElement AttCreateNewCustomerPageName;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement AttProjectNameTxtBox;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement AttProjectDescriptionTxtAreaBox;
	
	@FindBy(xpath="//input[@name='createCustomerSubmit']")
	WebElement AttCreateCustomerBtn;
	
	//Initialization
	public CreateNewCustomerPOM() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateCreateNewCustomerPageName() {
		return AttCreateNewCustomerPageName.getText();
	}
	
	public void validateCreateNewCustomer(String cName, String cDesc) {
		AttProjectNameTxtBox.sendKeys(cName);
		AttProjectDescriptionTxtAreaBox.sendKeys(cDesc);
		AttCreateCustomerBtn.click();
	}
	
}
