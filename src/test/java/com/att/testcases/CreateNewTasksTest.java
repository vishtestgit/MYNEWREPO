package com.att.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.CreateNewTaskPOM;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.TaskAndCustomerPOM;
import com.att.pom.TasksPOM;
import com.att.util.TestUtil;

public class CreateNewTasksTest extends BaseTest {
	
	public CreateNewTasksTest() {
		super();
	}
	
	LoginPOM loginPOM;
	HomePOM homePOM;
	TasksPOM tasksPOM;
	TestUtil testUtil;
	CreateNewTaskPOM createNewTasksPOM;
	TaskAndCustomerPOM taskAndCustomerPOM;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testUtil = new TestUtil();
		loginPOM = new LoginPOM();
		tasksPOM = new TasksPOM();
		taskAndCustomerPOM = new TaskAndCustomerPOM();
		createNewTasksPOM = new CreateNewTaskPOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateTaskClick();
		tasksPOM.validateCreateNewTasksBtnClick();
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyCreateNewTasksPageName() {
		Assert.assertEquals(createNewTasksPOM.validateCreateNewTaskPageName(), " Create New Tasks", "Create New Tasks Page Name Mismatch");
		
	}
	
	@Test
	public void verifySelectCustomerName() {
		createNewTasksPOM.validateSelectCustomerName("Vishnu");
	}

	@Test
	public void verifyCustomerAndTaskCreateAndDelete() {
		createNewTasksPOM.validateCreateCustomerAndTask();
		String x = taskAndCustomerPOM.validateSelectedAndDeleteCustomer();
		Assert.assertEquals(x, "Selected customers and projects have been successfully deleted.", "Delete Unsuccessful");
	}
	
	//Select Customer list items validation
	//using Util class methods select list box items.
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
