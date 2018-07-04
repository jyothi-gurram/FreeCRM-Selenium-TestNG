package com.crm.qa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class CaptureScreenshot extends TestBase {
	
	public static void Screenshot(WebDriver driver,String screenshotname) 
	{
		try{
			TakesScreenshot screenshot =(TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./Screenshots/" +screenshotname+ ".png"));
		}
		catch(Exception e)
		{
			System.out.println("not able to take the screenshot");
		}
		
	}

}
