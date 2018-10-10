package com.att.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.att.base.BaseTest;

public class ProjectAndCustomerPOM extends BaseTest{
	
	//Tab click
	@FindBy(xpath="//a[text()='Projects & Customers']")
	WebElement AttTaskAndCustomerBtn;
	

	//Select Customer name and show
	@FindBy(xpath="//select[@name='selectedCustomer']/option[contains(text(),'TestCust')]")
	WebElement AttSelectSpecifiedCustomerName;
	
	@FindBy(xpath="//input[@value='   Show   ']")
	WebElement AttClickShowBtn;

	//Porject and Customer Page title
	@FindBy(xpath="//td[contains(text(),'Active Customers and Projects')]")
	WebElement AttProjectAndCustomerPageName;
	
	//Select All
	@FindBy(xpath="//a[text()='All']")
	WebElement AttSelectAllLink;
	
	//Delete Selected
	@FindBy(xpath="//input[@value='Delete Selected']")
	WebElement AttDeleteSelectedBtn1;
	
	@FindBy(xpath="//input[@value='Delete This Customer']")
	WebElement AttDeleteCustomerBtn2;
	
	@FindBy(xpath="//input[@value='Delete This Project']")
	WebElement AttDeleteProjectBtn2;
	
	@FindBy(xpath="//span[@class='successmsg']")
	WebElement AttDeleteSuccessMsg;
	
	@FindBy(xpath="//span[text()='Create Customer']")
	WebElement AttCreateCustomerBtn;
	
	@FindBy(xpath="//span[text()='Create Project']")
	WebElement AttCreateProjectBtn;
	
	
	//Initialization
	public ProjectAndCustomerPOM() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateProjectAndCustomerPageName() {
		return AttProjectAndCustomerPageName.getText();
	}
	
	public CreateNewCustomerPOM validateCreateCustomerBtnClick() {
		AttCreateCustomerBtn.click();
		return new CreateNewCustomerPOM();
	}
	
	public CreateNewProjectPOM validateCreateProjectBtnClick() {
		AttCreateProjectBtn.click();
		return new CreateNewProjectPOM();
	}
	
	public void validateSelectCustomerAndShow() {
		AttTaskAndCustomerBtn.click();
		AttSelectSpecifiedCustomerName.click();
		AttClickShowBtn.click();
	}
	
	public void validateSelectCustomerByPrameterAndShow(String cName) {
		String xpath = "//select[@name='selectedCustomer']/option[contains(text(),'"+cName+"')]";
		AttTaskAndCustomerBtn.click();
		driver.findElement(By.xpath(xpath)).click();
		AttClickShowBtn.click();
	}
	
	public String validateSelectedAndDeleteCustomer() {
		validateSelectCustomerAndShow();
		AttSelectAllLink.click();
		AttDeleteSelectedBtn1.click();
		AttDeleteCustomerBtn2.click();
		String x = AttDeleteSuccessMsg.getText();
		return x;
	}
	
	public void validateDeleteCustomer(String cName) {
		validateSelectCustomerByPrameterAndShow(cName);
		AttSelectAllLink.click();
		AttDeleteSelectedBtn1.click();
		AttDeleteCustomerBtn2.click();
	}
	

	public String validateDeleteProject(String cName, String pName) {
		validateSelectCustomerByPrameterAndShow(cName);
		AttClickShowBtn.click();
		String xpath = 	"//a[text()='"+pName+"']/../../../../../..//input";
		driver.findElement(By.xpath(xpath)).click();		
		AttDeleteSelectedBtn1.click();
		AttDeleteProjectBtn2.click();
		String x = AttDeleteSuccessMsg.getText();
		return x;
	}
		
	
	
	
}
