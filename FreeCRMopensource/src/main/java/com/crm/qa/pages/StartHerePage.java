package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class StartHerePage extends TestBase {
@FindBy(xpath="//h2[contains(text(),'Start Here')]")
WebElement starthereHeading;

public StartHerePage()
{
	PageFactory.initElements(driver, this);
}

public boolean VerifyStartherePageHeading()
{
	boolean isDisplayed=starthereHeading.isDisplayed();
	return isDisplayed;
}
}
