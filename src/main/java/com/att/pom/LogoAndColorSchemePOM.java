package com.att.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.att.base.BaseTest;

public class LogoAndColorSchemePOM extends BaseTest{
	
	@FindBy(xpath="//td[contains(text(),'Logo & Color Scheme')]")
	WebElement AttLogoAndColorSchemePageName;
	
	//Initialization
	public LogoAndColorSchemePOM() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLogoAndColorSchemePageName() {
		String x = AttLogoAndColorSchemePageName.getText();
		return x;
	}
}
