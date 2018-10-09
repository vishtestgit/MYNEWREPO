package com.att.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.att.base.BaseTest;

public class TaskAndCustomerPOM extends BaseTest{
	
	//Tab click
	@FindBy(xpath="//a[text()='Projects & Customers']")
	WebElement AttTaskAndCustomerBtn;
	
	//Select Customer name and show
	@FindBy(xpath="//select[@name='selectedCustomer']/option[contains(text(),'TestCust')]")
	WebElement AttSelectSpecifiedCustomerName;
	
	
	@FindBy(xpath="//input[@value='   Show   ']")
	WebElement AttClickShowBtn;

	//Select All
	@FindBy(xpath="//a[text()='All']")
	WebElement AttSelectAllLink;
	
	//Delete Selected
	@FindBy(xpath="//input[@value='Delete Selected']")
	WebElement AttDeleteSelectedBtn1;
	
	@FindBy(xpath="//input[@value='Delete This Customer']")
	WebElement AttDeleteSelectedBtn2;
	
	@FindBy(xpath="//span[@class='successmsg']")
	WebElement AttDeleteSuccessMsg;
	
	//Initialization
	public TaskAndCustomerPOM() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
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
		AttDeleteSelectedBtn2.click();
		String x = AttDeleteSuccessMsg.getText();
		return x;
	}
	
	public void validateDeleteCustomer(String cName) {
		validateSelectCustomerByPrameterAndShow(cName);
		AttSelectAllLink.click();
		AttDeleteSelectedBtn1.click();
		AttDeleteSelectedBtn2.click();

//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='All']"))).click();
	//	new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete Selected']"))).click();
		//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete This Customer']"))).click();

	}
	
	

	
	
	
	
	
	
	
}
