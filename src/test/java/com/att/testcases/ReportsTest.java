package com.att.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.CreateNewTaskPOM;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.ReportsPOM;
import com.att.pom.TaskAndCustomerPOM;
import com.att.pom.TasksPOM;
import com.att.util.TestUtil;

public class ReportsTest extends BaseTest{
	
	LoginPOM loginPOM;
	HomePOM homePOM;
	TasksPOM tasksPOM;
	TestUtil testUtil;
	CreateNewTaskPOM createNewTasksPOM;
	TaskAndCustomerPOM taskAndCustomerPOM;
	ReportsPOM reportsPOM;
	
	public ReportsTest() {
		super();
	}	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPOM = new LoginPOM();
		tasksPOM = new TasksPOM();
		reportsPOM = new ReportsPOM();
		taskAndCustomerPOM = new TaskAndCustomerPOM();
		createNewTasksPOM = new CreateNewTaskPOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
	}
	
	@Test
	public void verifyReportsTabLinkClick() {
		reportsPOM.validateClickOnReportsTabLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
