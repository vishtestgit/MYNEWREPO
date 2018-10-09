package com.att.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.HomePOM;
import com.att.pom.LeaveTypePOM;
import com.att.pom.LoginPOM;
import com.att.pom.ReportsPOM;
import com.att.pom.TasksPOM;
import com.att.util.TestUtil;

public class LeaveTypeTest extends BaseTest{

	LoginPOM loginPOM;
	HomePOM homePOM;
	TestUtil testUtil;
	TasksPOM tasksPOM;
	ReportsPOM reportsPOM;
	LeaveTypePOM leaveTypePOM;
	
	public LeaveTypeTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		loginPOM = new LoginPOM();
		testUtil = new TestUtil();
		leaveTypePOM = new LeaveTypePOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateSelectSettingsMenuByValue("Leave Types");
	}
	

	@Test
	public void verifyLeaveTypePageName() {
		String x = leaveTypePOM.validateLeaveTypePageName();
		Assert.assertEquals(x, "Leave Types","Page Name Mismatch");
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
