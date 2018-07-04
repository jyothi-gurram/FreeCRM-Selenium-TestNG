package com.crm.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdvancedTopicsPage;
import com.crm.qa.pages.HelpPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.StartHerePage;
import com.crm.qa.utils.CaptureScreenshot;
import com.crm.qa.utils.TestUtils;

public class HelpPageTest extends TestBase {
	HomePage homepage;
	HelpPage helppage;
	StartHerePage startherepage;
	AdvancedTopicsPage advancedtopicspage;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		LoginPage loginpage=new LoginPage();
		homepage=loginpage.login(properties.getProperty("username"),properties.getProperty("password"));
		helppage=homepage.ClickOnHelpLink();
		TestUtils.switchToWindow();
	}
	@Test(enabled=true)
	public void VerifyStarthereLnkTest() throws IOException
	{
		startherepage=helppage.ClickOnStarthereLnk();
		boolean isDisplayed=startherepage.VerifyStartherePageHeading();
		Assert.assertTrue(isDisplayed);
	}
	@Test(enabled=true)
	public void verifyAdvancedTopicsLnkTest() throws IOException
	{
		advancedtopicspage=helppage.ClickOnAdvancedTopicsLnk();
		boolean isDisplayed=advancedtopicspage.VerifyAdvancedTopicsPageHeading();
		Assert.assertTrue(isDisplayed);
	}
	@Test
	public void verifyHelpPageHeadingTest()
	{
		String heading1=helppage.verifyHelpPageHeading();
		Assert.assertTrue(heading1.contains("CRMPRO Help Center"));
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			CaptureScreenshot.Screenshot(driver,result.getName());
		}
		driver.quit();
	}

}
