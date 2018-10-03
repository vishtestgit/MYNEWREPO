package com.att.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.att.util.TestUtil;


public class BaseTest {
	public static WebDriver driver;
	public static Properties propv;
	
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
		System.setProperty("webdriver.gecko.driver", "C:\\chromedriver_win32\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitTimeOut, TimeUnit.SECONDS);
	
	driver.get(propv.getProperty("url"));
	
	}
	

}
