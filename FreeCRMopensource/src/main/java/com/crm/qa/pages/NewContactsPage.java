package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactsPage extends TestBase{
	@FindBy(name="title")
	WebElement conttitle;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement savebtn;
	
	public NewContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void CreateNewContact(String ftname,String ltname,String comp)
	 {
		 firstname.sendKeys(ftname);
		 lastname.sendKeys(ltname);
		 company.sendKeys(comp);
		 savebtn.click();
	 }
}
