package com.crm.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DocumentPage;
import com.crm.qa.pages.EditDocPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.CaptureScreenshot;
import com.crm.qa.utils.TestUtils;

public class DocumentPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	DocumentPage documentpage;
	
	EditDocPage editdocpage;
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
	    loginpage=new LoginPage();
		homepage=loginpage.login(properties.getProperty("username"),properties.getProperty("password"));
		TestUtils.switchtoframe();
	}
	@Test
	public void VerifyCreateNewDocTest() throws IOException
	{
	    documentpage=new DocumentPage();
		editdocpage=documentpage.CreateNewDoc();
		WebElement docheading=driver.findElement(By.xpath("//input[@value='Edit document envelope']"));
		boolean isDisplayed=docheading.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==2)
		{
			CaptureScreenshot.Screenshot(driver, result.getName());
		}
		driver.close();	
	}

}
