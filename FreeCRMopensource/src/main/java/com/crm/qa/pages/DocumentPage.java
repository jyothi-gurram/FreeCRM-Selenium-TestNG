package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DocumentPage extends TestBase {
	@FindBy(id="title")
	WebElement title;
	
	public DocumentPage()
	{
		PageFactory.initElements(driver,this);
	}
	public EditDocPage CreateNewDoc() throws IOException
	{
		WebElement doctab=driver.findElement(By.xpath("//div[@id='navmenu']/ul/li[13]"));
		WebElement newdoctab=driver.findElement(By.xpath("//a[@title='New Document']"));
		Actions action=new Actions(driver);
		action.moveToElement(doctab).build().perform();
		Actions action1=new Actions(driver);
		action1.moveToElement(newdoctab).click().build().perform();
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("firstone");
		driver.findElement(By.xpath("//input[@type='file']")).click();
		Runtime.getRuntime().exec("C:\\Users\\Harshita\\Desktop\\uploadfilenew.exe");
		driver.findElement(By.xpath("//*[@id=\"docForm\"]/table/tbody/tr[14]/td[2]/input")).click();
		return new EditDocPage();
	}

}
