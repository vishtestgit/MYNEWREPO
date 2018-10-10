package com.att.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.ProjectAndCustomerPOM;

import com.att.pom.TasksPOM;

public class ProjectAndCustomerTest extends BaseTest{

	LoginPOM loginPOM;
	HomePOM homePOM;
	TasksPOM tasksPOM;
	ProjectAndCustomerPOM projectAndCustomerPOM;
	
	public ProjectAndCustomerTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPOM = new LoginPOM();
		tasksPOM = new TasksPOM();
		projectAndCustomerPOM = new ProjectAndCustomerPOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateTaskClick();
		tasksPOM.validateProjectAndCustomerTabClick();
	}
	
	@Test
	public void verifyProjectAndCustomerPageName() {
		String x = projectAndCustomerPOM.validateProjectAndCustomerPageName();
		Assert.assertEquals(x, "Active Customers and Projects","Page Name Mismatch");
	}
	
	@Test
	public void verifyCreateCustomerBtnClick() {
		projectAndCustomerPOM.validateCreateCustomerBtnClick();
	}
	
	@Test
	public void verifyCreateProjectBtnClick() {
		projectAndCustomerPOM.validateCreateProjectBtnClick();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
