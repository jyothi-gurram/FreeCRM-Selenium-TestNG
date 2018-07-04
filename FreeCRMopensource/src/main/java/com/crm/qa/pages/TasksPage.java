package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtils;

public class TasksPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'New Task')]")
	WebElement newtasklink;
	
	public TasksPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void CreateNewTask()
	{
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("implementation");
		WebElement status=driver.findElement(By.xpath("//select[@name='status']"));
		Select select=new Select(status);
		select.selectByValue("Complete");
		driver.findElement(By.xpath("//*[@id=\"taskForm\"]/table/tbody/tr[1]/td/input")).click();
		
	}
}

