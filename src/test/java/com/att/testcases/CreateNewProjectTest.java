package com.att.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.base.BaseTest;
import com.att.pom.CreateNewProjectPOM;
import com.att.pom.HomePOM;
import com.att.pom.LoginPOM;
import com.att.pom.ProjectAndCustomerPOM;
import com.att.pom.TasksPOM;

public class CreateNewProjectTest extends BaseTest{
	
	LoginPOM loginPOM;
	HomePOM homePOM;
	TasksPOM tasksPOM;
	ProjectAndCustomerPOM projectAndCustomerPOM;
	CreateNewProjectPOM createNewProjectPOM;
		
	public  CreateNewProjectTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPOM = new LoginPOM();
		homePOM = new HomePOM();
		tasksPOM = new TasksPOM();
		projectAndCustomerPOM = new ProjectAndCustomerPOM();
		createNewProjectPOM = new CreateNewProjectPOM();
		homePOM = loginPOM.validateAttLogin(propv.getProperty("username"),propv.getProperty("password"));
		homePOM.validateTaskTab();
		tasksPOM.validateProjectAndCustomerTabClick();
		projectAndCustomerPOM.validateCreateProjectBtnClick();
	}
	
	@Test
	public void validateCreateNewProjectPageName() {
		String x = createNewProjectPOM.validateCreateNewProjectPageName();
		Assert.assertEquals(x, "Create New Project","Page Name Mismatch");
	}

	@Test
	public void validateCreateNewProject() {
		createNewProjectPOM.validateCreateNewProject("Vishnu", "ATTPrj4", "Att Project Desc text message");
		String x = projectAndCustomerPOM.validateDeleteProject("Vishnu","ATTPrj4");
		Assert.assertEquals(x, "Selected projects have been successfully deleted.","Delete Project Not Success");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
