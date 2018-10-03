package com.att.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.att.base.BaseTest;

public class CreateNewTaskPOM extends BaseTest {
	
	@FindBy(xpath="//td[@class='pagetitle']")
	WebElement AttNewTaskPageName;
	
	@FindBy(xpath="//select[@name='customerId']")
	WebElement AttSelectCustomerName;
	
	@FindBy(xpath="//select[@name='customerId']")
	WebElement AttListBoxSelect;
	
	@FindBy(xpath="//select/option[@value='-2']")
	WebElement AttSelectNewCustomerOptionFromListBox;
	
	@FindBy(xpath="//input[@name='customerName']")
	WebElement AttCustomerNameTextBox;
	
	@FindBy(xpath="//input[@name='projectName']")
	WebElement AttProjectNameTextBox;
	
	@FindBy(xpath="//input[@id='task[0].name']")
	WebElement AttTaskNameTextBox;
	
	@FindBy(xpath="//input[@id='task[0].budgetedTimeStr']")
	WebElement AttBudgetTimeTextBox;
	
	@FindBy(xpath="//input[@id='task[0].deadline']")
	WebElement AttEnterDateInDateField;
	
	
	@FindBy(xpath="//select[@name='task[0].billingType']/option[@value='1']")
	WebElement AttSelectBillingType;
	
	@FindBy(xpath="//input[@id='task[0].markedToBeAddedToUserTasks']")
	WebElement AttSelectCheckBoxMarkToBeAdd;
	
	@FindBy(xpath="//input[@value='Create Tasks']")
	WebElement AttCreateTaskBtn;
	
	
	//Initialization
	public CreateNewTaskPOM() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateCreateNewTaskPageName() {
		String x = AttNewTaskPageName.getText();
		return x;
	}
	
	public void validateSelectCustomerName(String custName) {
		AttSelectCustomerName.sendKeys(custName);
	}
	
	//create customer and task
	public void validateCreateCustomerAndTask() {
		AttSelectNewCustomerOptionFromListBox.click();
		AttCustomerNameTextBox.sendKeys("TestCust");
		AttProjectNameTextBox.sendKeys("TestProject");
		AttTaskNameTextBox.sendKeys("Tast1WCNP");
		AttBudgetTimeTextBox.sendKeys("3:00");
		AttEnterDateInDateField.sendKeys(Keys.ENTER,"Jan 27, 2019");
		AttSelectBillingType.click();
		AttSelectCheckBoxMarkToBeAdd.click();
		AttCreateTaskBtn.click();
	}
	

}
