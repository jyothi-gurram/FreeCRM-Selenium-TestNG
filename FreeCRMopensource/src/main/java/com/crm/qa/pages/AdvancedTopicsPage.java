package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AdvancedTopicsPage extends TestBase {
	@FindBy(xpath="//h2[contains(text(),'Advanced Topics')]")
	WebElement advancedtopicsHeading;

	public AdvancedTopicsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyAdvancedTopicsPageHeading()
	{
		boolean isDisplayed=advancedtopicsHeading.isDisplayed();
		return isDisplayed;
	}
	

}
