package com.att.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.TasksPOM;
import com.att.util.TestUtil;

public class TasksTest extends BaseTest{
	
	LoginPOM loginPOM;
	HomePOM homePOM;
	TasksPOM tasksPOM;
	TestUtil testUtil;
	
	
	public TasksTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testUtil = new TestUtil();
		loginPOM = new LoginPOM();
		tasksPOM = new TasksPOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateTaskClick();
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyTaskPage() {
		Assert.assertEquals(tasksPOM.validateTasksPage(),"Open Tasks","Page name missmatch");
	}
	
	@Test
	public void verifyCreateNewTaskBtnClick() {
		tasksPOM.validateCreateNewTasksBtnClick();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
