package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtils;

public class HomePage extends TestBase{
	@FindBy(xpath="//td[contains(text(),'User: siva jyothi')]")
	WebElement username;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactlink;
	
	@FindBy(xpath="//div[@class='noprint']//tr/td[3]/a")
	WebElement helplnk;
	
	@FindBy(xpath="//td[@class='headertext']/a[contains(text(),'Upgrade your account')]")
	WebElement upgradeAccountLnk;
	
	@FindBy(xpath="//a[@title='New Task']")
	WebElement newtasklink;
	
	public HomePage()//after you locate the webelements we are initializing them in the constructor using+
	//PageFactory
	{
		PageFactory.initElements(driver, this);
	}
	public boolean VerifyCorrectUserName()
	{
		WebDriverWait wait=new WebDriverWait(driver, 60l);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),'User: siva jyothi')]")));
	  return   username.isDisplayed();
	}
	public  String VerifyHomePageTitle()
	{
		return   driver.getTitle();
	}
	public ContactsPage ClickOnContactsLink()
	{
		TestUtils.switchtoframe();
		WebDriverWait wait=new WebDriverWait(driver, 60l);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Contacts')]")));
		contactslink.click();
		return new ContactsPage();
		
	}
	public TasksPage ClickOnTasksLink()
	{
		TestUtils.switchtoframe();
		taskslink.click();
		return new TasksPage();
	}
	public DealsPage ClickOnDealsLink()
	{
		TestUtils.switchtoframe();
		dealslink.click();
		return new DealsPage();	
	}
	public NewContactsPage ClickOnNewContacts()
	{
		TestUtils.switchtoframe();
		Actions action=new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		action.moveToElement(newcontactlink).click().build().perform();
		return new NewContactsPage();
		
	}
	public NewTasksPage ClickOnNewTasks()
	{
		TestUtils.switchtoframe();
		Actions action= new Actions(driver);
		action.moveToElement(taskslink).build().perform();
		action.moveToElement(newtasklink).click().build().perform();
		return new NewTasksPage();
		
	}
	public HelpPage ClickOnHelpLink() {
		TestUtils.switchtoframe();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='noprint']//tr/td[3]/a")));
	helplnk.click();
	return new HelpPage();
		
	}
	
	public UpgradeAccountPage ClickOnUpgradeAccountLink()
	{
		upgradeAccountLnk.click();
		return new UpgradeAccountPage();
	}
	
}




