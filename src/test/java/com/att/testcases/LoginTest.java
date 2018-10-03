package com.att.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;

public class LoginTest extends BaseTest{
	LoginPOM loginPOM;
	HomePOM homePOM;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPOM = new LoginPOM();
	}
	
	@Test
	public void AttLicLinkTest() {
		boolean l = loginPOM.validateAttLicLink();
		Assert.assertTrue(l);
	}
	
	@Test
	public void AttKeepLoginTest() {
		boolean c = loginPOM.validateAttKeepLoginChkBx();
		Assert.assertFalse(c);
	}
	
	@Test
	public void AttImgeLogoTest() {
		boolean i = loginPOM.validateAttImageLogo();
		Assert.assertTrue(i);
	}
	
	@Test
	public void AttLoginTest() {
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
