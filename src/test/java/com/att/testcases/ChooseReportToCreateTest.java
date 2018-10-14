package com.att.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.ChooseReportToCreatePOM;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.ReportsPOM;
import com.att.pom.TasksPOM;

public class ChooseReportToCreateTest extends BaseTest{
	
	LoginPOM loginPOM;
	HomePOM homePOM;
	TasksPOM tasksPOM;
	ReportsPOM reportsPOM;
	ChooseReportToCreatePOM chooseReportToCreatePOM;

	
	public ChooseReportToCreateTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPOM = new LoginPOM();
		homePOM = new HomePOM();
		reportsPOM = new ReportsPOM();
		chooseReportToCreatePOM = new ChooseReportToCreatePOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateReportsTab();
		reportsPOM.validateClickOnCreateReportBtn();
	}
	
	@Test
	public void verifyChooseReportWindowTitle() {
		String x = chooseReportToCreatePOM.validateChooseReportWindowTitle();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "Choose Report to Create", "Window Title Mismatch");
	}
	
	@Test
	public void verifyStaffPerformanceExampleLinkWindows() {
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Staff Performance");
		String x = getTitleAndCloseChildWindow();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "actiTIME - Staff Performance Report - Examples","ChildWindow Title Mismatch");
	}
	
	@Test
	public void verifyOvertimeExampleLinkWindows() {
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Overtime");
		String x = getTitleAndCloseChildWindow();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "actiTIME - Overtime Report - Examples","ChildWindow Title Mismatch");
	}
	
	@Test
	public void verifyLeaveTimeExampleLinkWindows() {
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Leave Time");
		String x = getTitleAndCloseChildWindow();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "actiTIME - Leave Time Report - Examples","ChildWindow Title Mismatch");
	}
	
	@Test
	public void verifyTimeTrackInDetailExampleLinkWindows() {
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Time-Track In Detail");
		String x = getTitleAndCloseChildWindow();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "actiTIME - Time-Track in Detail Report - Examples","ChildWindow Title Mismatch");
	}
	
	@Test
	public void verifyEstimatedVSActualTimeExampleLinkWindows() {
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Estimated vs. Actual Time");
		String x = getTitleAndCloseChildWindow();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "actiTIME - Estimated vs. Actual Time Report - Examples","ChildWindow Title Mismatch");
	}
	
	@Test
	public void verifyBillingSummaryExampleLinkWindows() {
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Billing Summary");
		String x = getTitleAndCloseChildWindow();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "actiTIME - Billing Summary Report Report - Examples","ChildWindow Title Mismatch");
	}
	
	@Test
	public void verifyInvoiceExportExampleLinkWindows() {
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Invoice Export");
		String x = getTitleAndCloseChildWindow();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "actiTIME - Invoice Export Report - Examples","ChildWindow Title Mismatch");
	}
	
	@Test
	public void verifyCostOfWorkExampleLinkWindows() {
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Cost of Work");
		String x = getTitleAndCloseChildWindow();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "actiTIME - Cost of Work Report - Examples","ChildWindow Title Mismatch");
	}
	
	@Test
	public void verifyProfitLossExampleLinkWindows() {
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Profit / Loss");
		String x = getTitleAndCloseChildWindow();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "actiTIME - Profit / Loss Report - Examples","ChildWindow Title Mismatch");
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
