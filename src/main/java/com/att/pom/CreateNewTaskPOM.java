package com.att.pom;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.att.base.BaseTest;


public class CreateNewTaskPOM extends BaseTest {
	
	@FindBy(xpath="//td[@class='pagetitle']")
	WebElement AttNewTaskPageName;
	
	@FindBy(xpath="//select[@name='customerId']")
	WebElement AttSelectCustomerName;
	
	@FindBy(xpath="//select[@name='customerId']")
	WebElement AttSelectCustListBox;
	
	@FindBy(xpath="//select[@name='projectId']")
	WebElement AttSelectProjectListBox;
	
	@FindBy(xpath="//select[@name='customerId']/option")
	WebElement AttSelectCustListOption;
	
	
	@FindBy(xpath="//select/option[@value='-2']")
	WebElement AttSelectNewCustomerOptionFromListBox;
	
	@FindBy(xpath="//span[@class='errormsg']")
	WebElement AttTaskCreateErrorMsg;
	
	
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
	WebElement AttSelectBillableBillingType;
	
	@FindBy(xpath="//select[@name='task[0].billingType']/option[@value='2']")
	WebElement AttSelectNonBillableBillingType;
	
	@FindBy(xpath="//input[@id='task[0].markedToBeAddedToUserTasks']")
	WebElement AttSelectCheckBoxMarkToBeAdd;
	
	@FindBy(xpath="//input[@value='Create Tasks']")
	WebElement AttCreateTaskBtn;
	
	@FindBy(xpath="//select[@id='task[0].billingType']")
	WebElement AttSelectBillingType;
	
	@FindBy(xpath="(//label[contains(text(),'Show')])[1]")
	WebElement AttShowRadioBtn1;
	
	@FindBy(xpath="(//label[contains(text(),'Show')])[2]")
	WebElement AttShowRadioBtn2;
	
	@FindBy(xpath="(//label[contains(text(),'Show')])[3]")
	WebElement AttShowRadioBtn3;
	
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
		AttSelectBillableBillingType.click();
		AttSelectCheckBoxMarkToBeAdd.click();
		AttCreateTaskBtn.click();
	}
	
	//New Customer and New Project
	public void validate_Billable_Task_Using_New_Customer_And_New_Project(String custListOption,String custListName, String projectName,String taskName,String taskBudgetTime,String billingType) {
		selectSingleDropDownItem(driver, AttSelectCustListBox, custListOption);
		AttCustomerNameTextBox.sendKeys(custListName);
		AttProjectNameTextBox.sendKeys(projectName);
		AttTaskNameTextBox.sendKeys(taskName);
		AttBudgetTimeTextBox.sendKeys(taskBudgetTime);
		AttEnterDateInDateField.sendKeys(getTodaysDate());
		selectSingleDropDownItem(driver, AttSelectBillingType, billingType);
		AttSelectCheckBoxMarkToBeAdd.click();
		AttCreateTaskBtn.click();
		
	}
	//Existing Project and Existing Customer
	public void validate_Billable_Task_Using_Existing_Customer_And_Existing_Project(String custListOption,String projectName,String taskName,String taskBudgetTime,String billingType) {
		selectSingleDropDownItem(driver, AttSelectCustListBox, custListOption);
		selectSingleDropDownItem(driver, AttSelectProjectListBox, projectName);

		AttTaskNameTextBox.sendKeys(taskName);
		AttBudgetTimeTextBox.sendKeys(taskBudgetTime);
		AttEnterDateInDateField.sendKeys(getTodaysDate());
		selectSingleDropDownItem(driver, AttSelectBillingType, billingType);
		AttSelectCheckBoxMarkToBeAdd.click();
		AttCreateTaskBtn.click();
		
	}
	
	//Negative Test Create task with Nothing.
	public String validate_Task_Create_By_Nothing() throws InterruptedException {
		AttCreateTaskBtn.click();
		Thread.sleep(400);
		return AttTaskCreateErrorMsg.getText();
		
	}
	
	
	//All Project and All Customer
	public void validate_Billable_Task_Using_All_Customer_And_All_Project(String custListOption,String projectName,String taskName,String taskBudgetTime,String billingType) {
		selectSingleDropDownItem(driver, AttSelectCustListBox, custListOption);
		selectSingleDropDownItem(driver, AttSelectProjectListBox, projectName);
		AttTaskNameTextBox.sendKeys(taskName);
		AttBudgetTimeTextBox.sendKeys(taskBudgetTime);
		AttCreateTaskBtn.click();
		
	}
	
	//Validate default Radio button selection.??????NEED TO WORK ON...
	
	public boolean validateDefaultRadioButtonSelection() {

		boolean b = AttShowRadioBtn2.isSelected();
		if(b){
			return true;
		}else {
			System.out.println("Invalid Default redio button selection");
			return false;
		}
	}
		
		
}



