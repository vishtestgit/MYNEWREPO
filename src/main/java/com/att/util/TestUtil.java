package com.att.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestUtil {
	public static long PageLoadTimeOut = 20;
	public static long ImplicitTimeOut = 20;
	
	public void clickOnSubMenu(WebDriver driver, String cMain, String cSub) {
		WebElement mainMenu = driver.findElement(By.xpath(cMain));
		WebElement subMenu = driver.findElement(By.xpath(cSub));
		
		Actions act = new Actions(driver);
		act.moveToElement(mainMenu).click().build().perform();
		act.click(subMenu).build().perform();
	}
	
	public void selectSingleDropDownItem(WebDriver driver, String listBox, String listItem) {
		Select dropDownElement = new Select(driver.findElement(By.xpath(listBox)));
		dropDownElement.selectByVisibleText(listItem);
	}
	
	
	
}
