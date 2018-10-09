package com.att.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.att.util.TestUtil;
import com.att.util.WebEventListener;


public class BaseTest {
	public static WebDriver driver;
	public static Properties propv;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	
	public BaseTest() {
		try {
			propv = new Properties();
			FileInputStream fi = new FileInputStream("C:\\GCVSEL\\MYMAVEN\\src\\main\\java\\com\\att\\config\\config.properties");
			propv.load(fi);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}		
	public static void initialization() {
	String browserName = propv.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}else if(browserName.equals("FF")) {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitTimeOut, TimeUnit.SECONDS);
	//driver.manage().deleteAllCookies();
	driver.get(propv.getProperty("url"));
	
	//EvenListener declaration under initialization methods.
	e_driver = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener(); 
	e_driver.register(eventListener);
	driver = e_driver;
	
	}
	
	


	
	/*
	 * custom clickOn method: click on element on the basis of some ExpectedConditions to avoid StaleElementReferenceException
	 */
	public static void clickOn(WebDriver driver, WebElement locator, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
		//logger.info("element clicked:"+ locator);
	}
	
	/*
	 * custom sendKeyValue method: enter value in element on the basis of some ExpectedConditions to avoid StaleElementReferenceException
	 */
	public static void sendKeyValue(WebDriver driver, WebElement locator, int timeout, String value){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.sendKeys(value);
		//logger.info("value entered in:"+ locator + ": value is:"+ value);

	}
	
	/*
	 * custom getWebElement method: get the WebElement on the basis of some ExpectedConditions to avoid StaleElementReferenceException
	 */
	public static WebElement getWebElement(WebDriver driver, WebElement locator, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		return locator;
	}
	
	/*
	 * custom getWebElements method: get similar WebElements on the basis of some ExpectedConditions to avoid StaleElementReferenceException
	 */
	public static List<WebElement> getWebElements(WebDriver driver, WebElement locator, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElements((By) locator);
	}
	
	

	
	
	public static <T extends Comparable<? super T>> boolean isSorted(List<T> list) {
	    if (list.size() != 0) {
	        ListIterator<T> it = list.listIterator();
	        for (T item = it.next(); it.hasNext(); item = it.next()) {
	            if (it.hasPrevious() && it.previous().compareTo(it.next()) > 0) {
	                return false;
	            }
	        }

	    }
	    return true;
	}
	
	

	public void clickOnSubMenu(WebDriver driver, String mainMenuXpath, String subMenuXpath) {
		WebElement tu_mainMenu = driver.findElement(By.xpath(mainMenuXpath));
		WebElement tu_subMenu = driver.findElement(By.xpath(subMenuXpath));
		
		Actions act = new Actions(driver);
		act.moveToElement(tu_mainMenu).click().build().perform();
		act.click(tu_subMenu).build().perform();
		
	}
	
	public void selectSingleDropDownItem(WebDriver driver, WebElement attSelectCustListBox, String custListOption) {
		Select dropDownElement = new Select(attSelectCustListBox);
		dropDownElement.selectByVisibleText(custListOption);
	}
	
	public String getTodaysDate() {
		  Date myDate = new Date();
	      System.out.println(myDate);
	      SimpleDateFormat sm = new SimpleDateFormat("MMM dd,yyyy");
	      String strDate = sm.format(myDate);
	      return strDate;
	}
	
	
}
