package com.crm.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.utils.CaptureScreenshot;
import com.crm.qa.utils.ExcelDataConfig;
import com.crm.qa.utils.TestUtils;
import com.sun.media.sound.InvalidFormatException;

public class ContactsPageTest extends TestBase {
	HomePage homepage;
	ContactsPage contactspage;
	LoginPage loginpage;
	NewContactsPage newcontactspage;
	TestUtils testutils;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
	     loginpage=new LoginPage();
	     testutils=new TestUtils();
		homepage=loginpage.login(properties.getProperty("username"),properties.getProperty("password"));
		Thread.sleep(6000);
	}
	@Test(enabled=false)
	public void VerifyContactsPageTest()
	{
		contactspage=homepage.ClickOnContactsLink();
		boolean page=contactspage.VerifyContactsPage();
		Assert.assertTrue(page);
	}
	@Test(enabled=false)
	public void VerifySelectAllContactsTest() throws InterruptedException
	{
		contactspage=homepage.ClickOnContactsLink();
		contactspage.SelectAllContacts();
	    boolean checked=driver.findElement(By.xpath("//input[@name='contact_id']")).isSelected();
	    Assert.assertTrue(checked);
	}
	@Test(enabled=false)
	public void VerifySelectContactByNameTest() throws InterruptedException
	{

		contactspage=homepage.ClickOnContactsLink();
		contactspage.SelectContactByName();
		WebElement heading=driver.findElement(By.xpath("//td[@class='tabs_header' and @align='left']"));
		String contactdetails=heading.getText();
		System.out.println(contactdetails);
		Assert.assertEquals(contactdetails,"har che");
	}
	
	@DataProvider(name="Newcontactdata")
	public Object[][] getConTestData() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException
	{
		
		ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\Harshita\\eclipse-workspace\\FreeCRMopen\\src\\main\\java\\com\\crm\\qa\\utils\\TestData\\newcontactdata.xlsx");
	int rows=config.getRowCount("newcontactdata");
	int cols=config.getColumnCount("newcontactdata");
			Object[][] data=new Object[rows-1][cols];
	
	for(int i=1;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{
			
		data[i-1][j]=config.getData("newcontactdata",i,j);	
	}
	}
	return data;
	}
	
	@Test(dataProvider="Newcontactdata",enabled=true)
    public void ValidateCreateNewContactTest(String firstname,String lastname,String company) throws InterruptedException
		{
		homepage=new HomePage();
		newcontactspage=homepage.ClickOnNewContacts();
		newcontactspage.CreateNewContact( firstname, lastname, company);	  		
		}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(result.getStatus()==2)
		{
			CaptureScreenshot.Screenshot(driver, result.getName());
		}
		driver.close();
	}
	

}
