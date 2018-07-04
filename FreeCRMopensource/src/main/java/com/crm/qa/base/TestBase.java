package com.crm.qa.base;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.TestUtils;
import com.crm.qa.utils.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	//reading the properties file in the constructor
	public TestBase() 
	{
		try {
		File file=new File("C:\\Users\\Harshita\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		FileReader fr=new FileReader(file);
	    properties=new Properties();
	    properties.load(fr);
		}
		catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}
		catch(IOException ee)
		{
			ee.printStackTrace();
		}
	    
		
	}
  public static void initialization()
   {
	String browser=properties.getProperty("browser");
	if(browser.equals("chrome")||browser.equalsIgnoreCase("google"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshita\\eclipse-workspace\\FreeCRMTest\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	else if(browser.equals("firefox")||browser.equalsIgnoreCase("Mozilla"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harshita\\eclipse-workspace\\FreeCRMTest\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	else if(browser.equalsIgnoreCase("IE")||browser.equalsIgnoreCase("internetexplorer"))
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Harshita\\eclipse-workspace\\FreeCRMTest\\drivers\\IEDriverServer.exe");
		InternetExplorerOptions ieo=new InternetExplorerOptions();
		ieo.introduceFlakinessByIgnoringSecurityDomains();
	    driver=new InternetExplorerDriver();
			
	}
	//using EventFiringWebDriver class and implementing WebDriverEventListener interface to help with debugging
	e_driver=new EventFiringWebDriver(driver);
	eventlistener=new WebEventListener();
	e_driver.register(eventlistener);
	driver=e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtils.page_load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wait, TimeUnit.SECONDS);
	
	driver.get(properties.getProperty("url"));
	
	
}
}


