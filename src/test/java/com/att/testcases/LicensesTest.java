package com.att.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.HomePOM;
import com.att.pom.LicensesPOM;
import com.att.pom.LoginPOM;
import com.att.pom.ReportsPOM;
import com.att.pom.TasksPOM;
import com.att.util.TestUtil;

public class LicensesTest extends BaseTest{
	
	LoginPOM loginPOM;
	HomePOM homePOM;
	TestUtil testUtil;
	TasksPOM tasksPOM;
	ReportsPOM reportsPOM;
	LicensesPOM licensesPOM;
	
	public LicensesTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPOM = new LoginPOM();
		testUtil = new TestUtil();
		licensesPOM = new LicensesPOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateSelectSettingsMenuByValue("Licenses");
	}
	
	@Test
	public void verifyLicensesPageName() {
		String x = licensesPOM.validateLicensesPageName();
		Assert.assertEquals(x, "Licenses","License Page Name Mismatch");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
