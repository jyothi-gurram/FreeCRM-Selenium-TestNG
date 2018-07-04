package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtils;

public class HelpPage extends TestBase{
	@FindBy(xpath="//h2[contains(text(),'Advanced Topics')]")
	WebElement advancedtopicslnk;

	@FindBy(xpath="//h2[contains(text(),'Start Here')]")
	WebElement startherelnk;
	
	@FindBy(xpath="//span[@class='header__name']")
	WebElement headingtxt;
	
	public HelpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHelpPageHeading() 
	{	
			return headingtxt.getText();
     }
	public StartHerePage ClickOnStarthereLnk()
	{
		startherelnk.click();
		return new StartHerePage();
	}
	public AdvancedTopicsPage ClickOnAdvancedTopicsLnk()
	{
		advancedtopicslnk.click();
		return new AdvancedTopicsPage();
		
	}
	public Boolean headingtxtisDisplayed() {
		boolean heading=headingtxt.isDisplayed();
		return heading;
	}
}

