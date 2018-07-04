package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class FeaturesPage extends TestBase {
	@FindBy(xpath="//h1[contains(text(),'CRM Features')]")
	WebElement featurespageheading;
	
	public FeaturesPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getfeaturespageheading()
	{
		Actions action=new Actions(driver);
		action.moveToElement(featurespageheading).build().perform();
		String heading=featurespageheading.getText();
		return heading;
	}
	

}
