package com.att.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.att.base.BaseTest;

public class TasksPOM extends BaseTest{
	
	@FindBy(xpath="//td[contains(text(),'Open Tasks')]")
	WebElement AttTaskPageName;
	
	@FindBy(xpath="//span[contains(text(),'Create Tasks')]")
	WebElement AttcreateTasksBtn;
	
	@FindBy(xpath="//input[@value='Delete Selected Tasks']")
	WebElement AttDeleteSelectedTasksBtn;
	
	@FindBy(xpath="//input[@id='deleteButton']")
	WebElement AttDeleteConfirmationBtn;
	
	//Initialization
	public TasksPOM() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTasksPage() {
		return AttTaskPageName.getText();

	}
	
	public CreateNewTaskPOM validateCreateNewTasksBtnClick() {
		AttcreateTasksBtn.click();
		return new CreateNewTaskPOM();
	}
	
	public void validateDeleteSelectedTask(String taskName) {
		String xpath= "//a[text()='"+taskName+"']/../../../../../..//input[@type='checkbox']";
		driver.findElement(By.xpath(xpath)).click();
		AttDeleteSelectedTasksBtn.click();
		AttDeleteConfirmationBtn.click();
	}

}
