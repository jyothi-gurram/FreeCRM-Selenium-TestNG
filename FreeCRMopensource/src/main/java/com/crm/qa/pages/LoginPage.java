package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class LoginPage extends TestBase {
	
	//pageFactory or object respository
	@FindBy(name="username")
	WebElement username;
	
   @FindBy(name="password")
	WebElement password;
	
   @FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
   @FindBy(xpath="//div[@id='navbar-collapse']/ul/li[2]")
   WebElement SignUpLnk;
   
   @FindBy(xpath="//a/small[contains(text(),'Forgot Password?')]")
   WebElement forgotpasswordLink;
   
   @FindBy(xpath="//img[@alt='free crm logo']")
   WebElement logo;
   
   @FindBy(xpath="//a[contains(text(),'Pricing')]")
   WebElement pricinglnk;
   
   @FindBy(xpath="//a[contains(text(),'Contact')]")
   WebElement contactlnk;
   
   @FindBy(xpath="//a[contains(text(),'Features')]")
   WebElement featureslnk; 
   
   @FindBy(xpath="//a[contains(text(),'Customers')]")
   WebElement customerslnk;
   
   @FindBy(xpath="//div[@class='intercom-launcher-close-icon']")
   WebElement messageimglnk;
   
  @FindBy(xpath="//span[contains(text(),'New conversation')]")
  WebElement newconversationbtn;
  
   @FindBy(xpath="//textarea[@placeholder='Send a message…']")
   WebElement sendmessagetxt;
   
   @FindBy(xpath="//button[@class='intercom-composer-send-button']")
   WebElement sendmessagebtn;
   
   //initializing all the webelements in the constructor using PageFactory class
   public LoginPage()
   {
	   PageFactory.initElements(driver,this);   
   }
   public void ClickOnIntercomDismissBtn() throws InterruptedException
   {
	   driver.switchTo().frame("intercom-borderless-frame");
		WebElement btn=driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']"));
	  WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='intercom-borderless-dismiss-button']")));
		Actions action=new Actions(driver);
		action.moveToElement(btn).click().build().perform();
   }
   public SignupPage VerifySignUpLnk()
   {
	   Actions action=new Actions(driver);
	   action.moveToElement(SignUpLnk).click().build().perform();
	   return new SignupPage();
   }
   public String validateLoginPageTitle()
   {
	   return driver.getTitle();
   }
   public boolean validatecrmImage()
   {
	  return logo.isDisplayed();
   }
   public PricingPage verifypricinglnk()
   {	  
	   Actions action=new Actions(driver);
	   action.moveToElement(pricinglnk).click().build().perform();
	   return new PricingPage();	
	   
   }
   public ContactPage verifycontactlnk()
   {	
	   Actions action=new Actions(driver);
	   action.moveToElement(contactlnk).click().build().perform();
	   return new ContactPage();	   
   }
   public FeaturesPage verifyfeatureslnk()
   {	Actions action=new Actions(driver);
        action.moveToElement(featureslnk).click().build().perform();  
	   return new FeaturesPage();	   
   }
   public HomePage login(String us,String pw) throws InterruptedException
   {
	   username.clear();
	   username.sendKeys(us);
	   password.clear();
	   password.sendKeys(pw);  
	   Actions action=new Actions(driver);
	   action.moveToElement(loginBtn).click().build().perform();   
	   return new HomePage();
   }
   public void verifyForgotPasswordLnk()
   {
	   Actions action=new Actions(driver);
	   action.moveToElement(forgotpasswordLink).click().build().perform();
	   driver.findElement(By.xpath("//div[2]/div/div/form/input[1]")).sendKeys(properties.getProperty("username"));
	   driver.findElement(By.xpath("//input[@value='Get Password']")).click();
   }
   public void sendmessage()
   {
	   driver.switchTo().frame("intercom-launcher-frame");
	   Actions action=new Actions(driver);
	   action.moveToElement(messageimglnk).click().build().perform();
	   driver.switchTo().defaultContent();
	   driver.switchTo().frame("intercom-messenger-frame");
	   Actions action1=new Actions(driver);
	   action1.moveToElement(newconversationbtn).click().build().perform();
	   newconversationbtn.click();
	   sendmessagetxt.sendKeys("Need some information");
	   sendmessagebtn.click();
   }
   public void VerifyPageScroll() throws InterruptedException
   {
	 JavascriptExecutor e=  (JavascriptExecutor)driver;
	 e.executeScript("window.scrollBy(0,1000)");
	 Thread.sleep(5000);
   }
}


