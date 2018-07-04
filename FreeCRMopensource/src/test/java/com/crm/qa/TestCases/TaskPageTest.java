package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewTasksPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.utils.CaptureScreenshot;

public class TaskPageTest extends TestBase {
	HomePage homepage;
	TasksPage taskspage;
	NewTasksPage newtaskspage;
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		LoginPage loginpage=new LoginPage();
		homepage=loginpage.login(properties.getProperty("username"),properties.getProperty("password"));
	}
	@Test(priority=1)
	public void VerifyCreateNewTaskTest() throws InterruptedException
	{
		newtaskspage=homepage.ClickOnNewTasks();
		newtaskspage.CreateNewTask();	
	}
	@Test(enabled=true,priority=2)
	public void VerifyNewTaskPageAlertTxtTest()
	{
		newtaskspage=homepage.ClickOnNewTasks();
		String alertmessage=newtaskspage.VerifyNewTaskPageAlertTxt();
		Assert.assertTrue(alertmessage.contains("Please enter a title for this task"));
	}
	@Test(enabled=true,priority=3)
	public void VerifyNewTaskPageAlertAcceptTest()
	{
		newtaskspage=homepage.ClickOnNewTasks();
		newtaskspage.VerifyNewTaskPageAlertAccept();
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
