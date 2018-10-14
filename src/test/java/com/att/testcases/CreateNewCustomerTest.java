package com.att.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.CreateNewCustomerPOM;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.ProjectAndCustomerPOM;
import com.att.pom.TasksPOM;

public class CreateNewCustomerTest extends BaseTest{
	
	private static final String validateCreateCustomer = null;
	LoginPOM loginPOM;
	HomePOM homePOM;
	TasksPOM tasksPOM;
	ProjectAndCustomerPOM projectAndCustomerPOM;
	CreateNewCustomerPOM createNewCustomerPOM;
	
	public  CreateNewCustomerTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPOM = new LoginPOM();
		homePOM = new HomePOM();
		tasksPOM = new TasksPOM();
		projectAndCustomerPOM = new ProjectAndCustomerPOM();
		createNewCustomerPOM = new CreateNewCustomerPOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateTaskTab();
		tasksPOM.validateProjectAndCustomerTabClick();
		projectAndCustomerPOM.validateCreateCustomerBtnClick();
	}
	
	@Test
	public void validateCreateNewCustomerPageName() {
		String x = createNewCustomerPOM.validateCreateNewCustomerPageName();
		Assert.assertEquals(x, "Create New Customer","Page Name Mismatch");
	}

	@Test
	public void validateCreateNewCustomer() {
		createNewCustomerPOM.validateCreateNewCustomer("ABC_Corp", "ABC Corporation Ltd");
		projectAndCustomerPOM.validateDeleteCustomer("ABC_Corp");
	}

	//////////////////////////////////////////////////////////////
	// Create and delete customer by using "dependsOnMethods"
	//////////////////////////////////////////////////////////////
	@Test
	public void validateCreateCustomer() {
		createNewCustomerPOM.validateCreateNewCustomer("XYZ_Corp", "XYZ Corporation Ltd");
	}

	
	@Test(dependsOnMethods={"validateCreateCustomer"})
	public void validateDeleteCustomer() {
		projectAndCustomerPOM.validateDeleteCustomer("XYZ_Corp");
	}
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
