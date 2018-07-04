package com.crm.qa.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.sun.media.sound.InvalidFormatException;

public class TestUtils extends TestBase {
	
	public static long page_load_timeout=60;
	public static long implicit_wait=60;
	
public static void switchtoframe()
{
	driver.switchTo().frame("mainpanel");
}

public static void switchToWindow()
{
	String parentwindow=driver.getWindowHandle();	
	Set<String>allwindows=driver.getWindowHandles();
	for(String window:allwindows)
	{
		if(!window.equals(parentwindow))
		{
			driver.switchTo().window(window);
	
		}
	}
}

public static void takeScreenShotAtTheEndOfTest(String Screenshotname)
{
	try 
	{
TakesScreenshot pic=(TakesScreenshot)driver;
File scr=pic.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(scr,new File("./Screenshots/"+Screenshotname+ ".png"));
}
catch(Exception e) {
	
}
	
}
}

