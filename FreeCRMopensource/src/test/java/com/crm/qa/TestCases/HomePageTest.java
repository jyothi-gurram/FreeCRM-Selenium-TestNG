package com.crm.qa.TestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HelpPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.UpgradeAccountPage;
import com.crm.qa.utils.CaptureScreenshot;
import com.crm.qa.utils.TestUtils;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	HelpPage helppage;
	UpgradeAccountPage upgradeAccountPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
	    loginpage=new LoginPage();
		homepage=loginpage.login(properties.getProperty("username"),properties.getProperty("password"));	
	}
	@Test
	public void VerifyCorrectUserTest()
	{
		Boolean correct=homepage.VerifyCorrectUserName();
		Assert.assertTrue(correct);
		
	}
	@Test
	public void VerifyHomepageTitleTest()
	{
		String homepagetitle=homepage.VerifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","homepage title is not correct");
	}
	
	@Test
	public void VerifyContactsLinkTest()
	{
		contactspage =homepage.ClickOnContactsLink();	
	}
	@Test(enabled=false)
	public void VerifyHelpLinkTest()
	{
		helppage=homepage.ClickOnHelpLink();
		Boolean isDisplayed=helppage.headingtxtisDisplayed();
		Assert.assertTrue(isDisplayed);	
	}
	@Test(enabled=false)
	public void VerifyUpgradeAccountLnkTest()
	{
		upgradeAccountPage=homepage.ClickOnUpgradeAccountLink();
		boolean isDisplayed=upgradeAccountPage.VerifyUpgradePageHeading();
		Assert.assertTrue(isDisplayed);
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
