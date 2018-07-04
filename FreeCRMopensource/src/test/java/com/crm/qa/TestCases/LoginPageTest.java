package com.crm.qa.TestCases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.FeaturesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PricingPage;
import com.crm.qa.utils.CaptureScreenshot;
import com.crm.qa.utils.TestUtils;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	PricingPage pricingpage;
	ContactPage contactpage;
	FeaturesPage featurespage;
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpage =new LoginPage();
		loginpage.ClickOnIntercomDismissBtn();
	}
	
	@Test(enabled=false)
	public void VerifyPageScrollTest() throws InterruptedException
	{
		loginpage.VerifyPageScroll();
	}
	@Test(enabled=false)
	public void loginPageTitleTest()
	{	
	String title=loginpage.validateLoginPageTitle();
	Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service","Title is different");
	
	}
	@Test(enabled=false) 
	public void crmlogoTest()
	{
		boolean isDisplayed=loginpage.validatecrmImage();
		Assert.assertTrue(isDisplayed);
	}
	@Test(enabled=false)
	public void loginTest() throws InterruptedException
	{
		homePage=loginpage.login(properties.getProperty("username"),properties.getProperty("password"));	
	}
	@Test(enabled=false)
	public void VerifyPricingLnkTest()
	{
	pricingpage=loginpage.verifypricinglnk();
	String heading=pricingpage.getpricingpageheading();
	Assert.assertTrue(heading.contains("Free for 1 Year!"));
	}
	@Test(enabled=true)
	public void VerifyContactLnkTest()
	{
	contactpage=loginpage.verifycontactlnk();
	boolean numtxt=contactpage.getcallusnumtxt();
	Assert.assertTrue(numtxt);
	TestUtils.takeScreenShotAtTheEndOfTest("verifycontactlnk");
	}
	@Test(enabled=false)
	public void VerifyFeaturesLnkTest()
	{
	featurespage=loginpage.verifyfeatureslnk();
	String heading=featurespage.getfeaturespageheading();
	Assert.assertTrue(heading.contains("CRM Features"));
	}
	@Test(enabled=false)
	public void VerifySendAMessageTest()
	{
		loginpage.sendmessage();
		boolean isDisplayed=driver.findElement(By.xpath("//img[@alt='Operator avatar']")).isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	@Test(enabled=false)
	public void VerifyForgotPasswordLnkTest()
	{
		loginpage.verifyForgotPasswordLnk();
		String message=driver.findElement(By.xpath("//div[@id='message']")).getText(); 
		Assert.assertTrue(message.contains("Your login detail have been sent to the email address on file."));		
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



	




