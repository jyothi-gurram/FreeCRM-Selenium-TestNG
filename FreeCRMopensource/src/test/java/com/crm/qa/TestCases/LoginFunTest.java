package com.crm.qa.TestCases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.CaptureScreenshot;
import com.crm.qa.utils.ExcelDataConfig;
import com.crm.qa.utils.TestUtils;

public class LoginFunTest extends TestBase{
	LoginPage loginpage=new LoginPage();

	@BeforeMethod
	public void setup()
	{
		initialization();	
	}
	@Test(dataProvider="Logintestdata")
	public void VerifyLoginFunTest(String username,String password) throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		WebElement loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));
		Actions action=new Actions(driver);
		action.moveToElement(loginbtn).click().build().perform();
		TestUtils.switchtoframe();
		WebElement logoutbtn=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		boolean logout=logoutbtn.isDisplayed();
		Assert.assertTrue(logout);
	}
	
	@DataProvider(name="Logintestdata")
	public Object[][] loginTestData() throws IOException
	{
		ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\Harshita\\eclipse-workspace\\FreeCRMopen\\src\\main\\java\\com\\crm\\qa\\utils\\TestData\\logindata.xlsx");
		int cols=config.getColumnCount("Sheet1");
		int rows=config.getRowCount("Sheet1");
		
		Object[][] data=new Object[rows-1][cols];
		for(int i=1;i<rows;i++)		
		{
			for(int j=0;j<cols;j++)
			{
			data[i-1][j]=config.getData("Sheet1",i,j);	
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
