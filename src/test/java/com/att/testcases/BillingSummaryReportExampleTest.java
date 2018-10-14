package com.att.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.BillingSummaryReportExamplePOM;
import com.att.pom.ChooseReportToCreatePOM;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.ReportsPOM;
import com.att.pom.TasksPOM;

public class BillingSummaryReportExampleTest extends BaseTest{

	public BillingSummaryReportExampleTest() {
		super();
	}
	
	LoginPOM loginPOM;
	HomePOM homePOM;
	TasksPOM tasksPOM;
	ReportsPOM reportsPOM;
	ChooseReportToCreatePOM chooseReportToCreatePOM;
	BillingSummaryReportExamplePOM billingSummaryReportExamplePOM;
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPOM = new LoginPOM();
		homePOM = new HomePOM();
		reportsPOM = new ReportsPOM();
		chooseReportToCreatePOM = new ChooseReportToCreatePOM();
		billingSummaryReportExamplePOM = new BillingSummaryReportExamplePOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateReportsTab();
		reportsPOM.validateClickOnCreateReportBtn();
		chooseReportToCreatePOM.validateClickSeeExampleLinkByValue("Billing Summary");
	}
	
	@Test
	public void validateBillingSummaryReportHeading() {
		String x = billingSummaryReportExamplePOM.validateBillingSummaryReportHeading();
		chooseReportToCreatePOM.validateChooseReportWindowClose();
		Assert.assertEquals(x, "Billing Summary Report Examples","Window Heading Missmatch");
	}
	
	//switch to section validation (list items) 
	@Test
	public void validateSwitchToSectionListItemsAndHeading() {
		String listOption1 = "--- Configure General System Settings";
		String listOption2 = "--- Configure Customizable Features";
		String listOption3 = "--- Create Billing Types (optionally)";
		String listOption4 = "--- Create Leave Types (optionally)";
		String listOption5 = "--- Create Tasks";
		String listOption6 = "--- Create User Accounts";
		String listOption7 = "--- --- Browse Open Tasks";
		String listOption8 = "--- --- Leave Time Report Parameters";
		
		
		
		boolean a1 = billingSummaryReportExamplePOM.validateSwitchToSectionListItemsAndHeading(listOption1);
		boolean a2 = billingSummaryReportExamplePOM.validateSwitchToSectionListItemsAndHeading(listOption2);
		boolean a3 = billingSummaryReportExamplePOM.validateSwitchToSectionListItemsAndHeading(listOption3);
		boolean a4 = billingSummaryReportExamplePOM.validateSwitchToSectionListItemsAndHeading(listOption4);
		boolean a5 = billingSummaryReportExamplePOM.validateSwitchToSectionListItemsAndHeading(listOption5);
		boolean a6 = billingSummaryReportExamplePOM.validateSwitchToSectionListItemsAndHeading(listOption6);
		boolean a7 = billingSummaryReportExamplePOM.validateSwitchToSectionListItemsAndHeading(listOption7);
		boolean a8 = billingSummaryReportExamplePOM.validateSwitchToSectionListItemsAndHeading(listOption8);

		chooseReportToCreatePOM.validateChooseReportWindowClose();
		
		Assert.assertEquals(a1, true,"Window Heading mismatch");
		Assert.assertEquals(a2, true,"Window Heading mismatch");
		Assert.assertEquals(a3, true,"Window Heading mismatch");
		Assert.assertEquals(a4, true,"Window Heading mismatch");
		Assert.assertEquals(a5, true,"Window Heading mismatch");
		Assert.assertEquals(a6, true,"Window Heading mismatch");
		Assert.assertEquals(a7, true,"Window Heading mismatch");
		Assert.assertEquals(a8, true,"Window Heading mismatch");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
