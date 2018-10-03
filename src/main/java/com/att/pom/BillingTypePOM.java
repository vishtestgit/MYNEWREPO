package com.att.pom;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.att.base.BaseTest;

public class BillingTypePOM extends BaseTest{

		
		@FindBy(xpath="//td[contains(text(),'Billing Types')]")
		WebElement AttBillingTypePageName;
		
		//Initialization
		public BillingTypePOM() {
			PageFactory.initElements(driver, this);
		}
		
		public String validateBillingTypePageName() {
			String x = AttBillingTypePageName.getText();
			return x;
		}
}


