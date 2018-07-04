package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="//h3[text()='Call us:']")
	WebElement callustxt;
	
	public ContactPage()
	{
		PageFactory.initElements(driver,this);	
	}
	public boolean getcallusnumtxt() {
		
        return 	callustxt.isDisplayed();

	}

}
