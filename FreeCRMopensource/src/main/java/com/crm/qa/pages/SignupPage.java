package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SignupPage extends TestBase{
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement surname;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="email_confirm")
	WebElement confirm_e;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="passwordconfirm")
	WebElement password_c;
	
	@FindBy(name="agreeTerms")
	WebElement checkbox;
	
	@FindBy(name="submitButton")
	WebElement submitbtn;
	
	@FindBy(id="company_name")
	WebElement comp;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="company_email")
	WebElement comp_email;
	
	public SignupPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void VerifySignUp(String fname,String sur,String em,String conf_e,String us,String pwd,String c_pwd)
	{
		firstname.sendKeys(fname);
		surname.sendKeys(sur);
		email.sendKeys(em);
		confirm_e.sendKeys(conf_e);
		username.sendKeys(us);
		password.sendKeys(pwd);
		password_c.sendKeys(c_pwd);
		checkbox.click();
		submitbtn.click();
	}
	public void CreateCompanyDetails()
	{
		comp.sendKeys("Informatica");
		phone.sendKeys("01214867890");
		comp_email.sendKeys("k@hotmail.com");		
	}
	
	
	
	
	
	
	
	
	
	
	

}
