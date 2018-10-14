package com.att.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.CreateNewTaskPOM;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.ReportsPOM;
import com.att.pom.ProjectAndCustomerPOM;
import com.att.pom.TasksPOM;


public class ReportsTest extends BaseTest{
	
	LoginPOM loginPOM;
	HomePOM homePOM;
	TasksPOM tasksPOM;
	CreateNewTaskPOM createNewTasksPOM;
	ProjectAndCustomerPOM projectAndCustomerPOM;
	ReportsPOM reportsPOM;
	
	public ReportsTest() {
		super();
	}	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPOM = new LoginPOM();
		tasksPOM = new TasksPOM();
		reportsPOM = new ReportsPOM();
		projectAndCustomerPOM = new ProjectAndCustomerPOM();
		createNewTasksPOM = new CreateNewTaskPOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateReportsTab();
	}
	
	@Test
	public void verifyClickOnCreateReportBtn() {
		reportsPOM.validateClickOnCreateReportBtn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
