package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
 public boolean VerifyContactsPage()
 {
	 return contactslabel.isDisplayed();
 }
 public void SelectAllContacts()
 {
	 List<WebElement>list=driver.findElements(By.xpath("//input[@name='contact_id']"));
	 for(WebElement e:list)
	 {
		 e.click();
	 } 
 }
 public void SelectContactByName() throws InterruptedException
 {
	List<WebElement>list= driver.findElements(By.xpath("//a[@context='contact']"));
	for(WebElement c:list)
	{
		String name=c.getAttribute("innerHTML");
		System.out.println(name);
		if(name.equals("har che"))
		{
			c.click();
			
		}
		Thread.sleep(3000);
	}
		
 }
public String getcallusnumtxt() {
	
	return null;
}
 
 
}
