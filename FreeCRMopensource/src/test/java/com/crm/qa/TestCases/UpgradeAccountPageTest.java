package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.UpgradeAccountPage;
import com.crm.qa.utils.CaptureScreenshot;
import com.crm.qa.utils.TestUtils;

public class UpgradeAccountPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	UpgradeAccountPage upgradeaccountpage;
	
	@BeforeMethod
	public void setup() throws InterruptedException 
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(properties.getProperty("username"),properties.getProperty("password"));
		TestUtils.switchtoframe();
		upgradeaccountpage=homepage.ClickOnUpgradeAccountLink();
		TestUtils.switchToWindow();
	}
	
	@Test
	public void VerifyUpgradeAccountPageHeadingtxtTest()
	{
		boolean isDisplayed=upgradeaccountpage.VerifyUpgradePageHeading();
		Assert.assertTrue(isDisplayed);
	}
	@Test(enabled=true)
	public void VerifyUpgradeAccountPageAlertTxtTest() throws InterruptedException
	{
		String alerttxt=upgradeaccountpage.VerifyUpgradeAccountPageAlertTxt();
		Assert.assertTrue(alerttxt.contains("Please enter the name on your cerdit card"));;
	}
	@Test(enabled=true)
	public void VerifyUpgradeAccountPageAlertAcceptTest() throws InterruptedException
	{
	upgradeaccountpage.VerifyUpgradeAccountPageAlertAccept();
	}
	@AfterMethod
	  public void teardown(ITestResult result)
	   {
		  if(ITestResult.FAILURE==result.getStatus())
		  {
			  CaptureScreenshot.Screenshot(driver,result.getName());
		  }
		driver.close();
	}

}
