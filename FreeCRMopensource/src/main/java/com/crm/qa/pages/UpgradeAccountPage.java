package com.crm.qa.pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class UpgradeAccountPage extends TestBase {
	@FindBy(xpath="//h2[contains(text(),'CRMPRO : Upgrade to Pro Account')]")
	WebElement upgradepageheading;
	
	@FindBy(xpath="//input[@value=' Upgrade your account ']")
	WebElement upgradeAccountBtn;
	
	public UpgradeAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean VerifyUpgradePageHeading()
	{
		return upgradepageheading.isDisplayed();
	}
	public String VerifyUpgradeAccountPageAlertTxt() throws InterruptedException
	{
		upgradeAccountBtn.click();
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		String alerttxt=alert.getText();
		return alerttxt;
	
	}
	public void VerifyUpgradeAccountPageAlertAccept() throws InterruptedException
	{
		upgradeAccountBtn.click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
	}

}
