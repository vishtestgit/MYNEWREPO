package com.att.testcases;

import org.testng.Assert;
import org.testng.TestNGUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.ReportsPOM;
import com.att.pom.TasksPOM;
import com.att.util.TestUtil;


public class HomeTest extends BaseTest{
	
	LoginPOM loginPOM;
	HomePOM homePOM;
	TestUtil testUtil;
	TasksPOM tasksPOM;
	ReportsPOM reportsPOM;
	
	public HomeTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		loginPOM = new LoginPOM();
		testUtil = new TestUtil();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
	}
	
	@Test
	public void verifyProfileName() {
		String x = homePOM.validateProfileName();
		Assert.assertEquals(x, "user1 user1", "User name not found");
	}
	
	@Test
	public void verifyTasksTab() {
		homePOM.validateTasksTab();
	}
	
	@Test
	public void verifyReportTab() {
		homePOM.validateReportsTab();
	}
	
	@Test
	public void verifyTaskTabClick() {
		homePOM.validateTaskClick();
	}
	
	//Setting Menu Validation test cases:
	@Test
	public void verifyLeaveTypeTest() {
		String x = homePOM.selectLeaveTypeMenu();
		System.out.println(x);
		Assert.assertEquals(x, "Leave Types","LeaveType PageName mismatch");
	}
	@Test
	public void verifyBillingTypeTest() {
		String x = homePOM.selectBillingTypeMenu();
		System.out.println(x);
		Assert.assertEquals(x, "Billing Types","BillingType PageName mismatch");
	}

	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
