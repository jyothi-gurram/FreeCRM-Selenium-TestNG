package com.crm.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignupPage;
import com.crm.qa.utils.CaptureScreenshot;
import com.crm.qa.utils.ExcelDataConfig;

public class SignUpPageTest extends TestBase {
	

	SignupPage signuppage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpage=new LoginPage();
		loginpage.ClickOnIntercomDismissBtn();
		signuppage=loginpage.VerifySignUpLnk();
	}
	
	@Test(dataProvider="signup")
	public void SignupPageTest(String fname, String lname, String email, String emailc, String uname, String pwd, String cpwd) throws InterruptedException
	{
		WebElement edition=driver.findElement(By.id("payment_plan_id"));
		Select select =new Select(edition);
		select.selectByValue("1");
		driver.findElement(By.name("first_name")).sendKeys(fname);
		driver.findElement(By.name("surname")).sendKeys(lname);	
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("email_confirm")).sendKeys(emailc);
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("passwordconfirm")).sendKeys(cpwd);
		driver.findElement(By.name("agreeTerms")).click();
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(6000);
		signuppage.CreateCompanyDetails();
		driver.findElement(By.name("btnSubmit")).click();
		driver.findElement(By.xpath("//button[@name='finish']")).click();
		WebElement confirmationmsg=driver.findElement(By.xpath("//div[@class='text_orange']"));
		String msg=confirmationmsg.getText();
		Assert.assertEquals(msg, "Your account is now registered.");
	}
	
	@DataProvider(name="signup")
	public Object[][] passData() throws IOException
	{
		ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\Harshita\\eclipse-workspace\\FreeCRMopen\\src\\main\\java\\com\\crm\\qa\\utils\\TestData\\SignUpTestData.xlsx");
		int rows=config.getRowCount("SignUp");
		int cols=config.getColumnCount("SignUp");
		System.out.println(rows);
		Object[][] data=new Object[rows-1][cols];
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
			data[i-1][j]=config.getData("SignUp", i, j);
			}
		}
	return data;	
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
