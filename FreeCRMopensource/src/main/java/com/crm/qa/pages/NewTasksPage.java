package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewTasksPage extends TestBase{
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//select[@name='status']")
	WebElement status;
	
	@FindBy(xpath="//select[@name='auto_extend']")
	WebElement autoextend;
	
	@FindBy(xpath="//*[@id=\"taskForm\"]/table/tbody/tr[1]/td/input")
	WebElement savebtn;
	
	public NewTasksPage()
	{
		PageFactory.initElements(driver,this);
	}
	public void CreateNewTask() throws InterruptedException
	{
		title.sendKeys("functional testing");
		Select select=new Select(status);
		select.selectByValue("Complete");
		Select select1=new Select(autoextend);
		select1.selectByValue("3");
		savebtn.click();	
	}
	public String VerifyNewTaskPageAlertTxt()
	{
		savebtn.click();
		String alertmessage=driver.switchTo().alert().getText();
		return alertmessage;
	}
	public void VerifyNewTaskPageAlertAccept()
	{
		savebtn.click();
		driver.switchTo().alert().accept();
	}

}
