package com.att.util;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



import org.openqa.selenium.WebDriver;

import com.att.base.BaseTest;

public class TestUtil extends BaseTest{
	public static long PageLoadTimeOut = 20;
	public static long ImplicitTimeOut = 20;
	public static WebDriver driver;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir +"\\screenshots\\"+ System.currentTimeMillis() + ".png"));
	}
	
}




