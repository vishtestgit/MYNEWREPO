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
	

}
