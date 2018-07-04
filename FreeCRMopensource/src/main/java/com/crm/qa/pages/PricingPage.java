package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class PricingPage extends TestBase {
	@FindBy(xpath="//h1[contains(text(),'Free for 1 Year!')]")
	WebElement pricingpageheading;
	
	public PricingPage()
	{
		PageFactory.initElements(driver,this);
	}
	public String getpricingpageheading()
	{
		String heading=pricingpageheading.getText();
		return heading;
	}

}
