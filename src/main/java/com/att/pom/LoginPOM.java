package com.att.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.att.base.BaseTest;

public class LoginPOM extends BaseTest{

	@FindBy(id="licenseLink")
	WebElement AttLicLink;
	
	@FindBy(id="logoContainer")
	WebElement AttImageLogo;
		
	@FindBy(name="username")
	WebElement AttUserName;
	
	@FindBy(name="pwd")
	WebElement AttPassword;
	
	@FindBy(xpath="//a[@id='loginButton']")
	WebElement AttLoginBtn;
	
	@FindBy(xpath="//div[@id='keepMeLoggedInCaptionContainer']")
	WebElement AttKeepLoginChkBx;
	
	//Initialization
	public LoginPOM(){
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public boolean validateAttLicLink() {
		boolean l = AttLicLink.isDisplayed();
		return l;
	}
	
	public boolean validateAttImageLogo() {
		boolean i = AttImageLogo.isDisplayed();
		return i;
	}
	
	public boolean validateAttKeepLoginChkBx() {
		boolean c = AttKeepLoginChkBx.isSelected();
		return c;
	}
	
	public HomePOM validateAttLogin(String un,String pw) {
		AttUserName.sendKeys(un);
		AttPassword.sendKeys(pw);
		AttLoginBtn.click();
		return new HomePOM();
	}
	
	
	
}
