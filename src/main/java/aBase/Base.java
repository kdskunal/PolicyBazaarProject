package aBase;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import aUtility.UtilityMethods;

public class Base 
{
	static protected WebDriver driver; // to use browser out of package we use protected access specifier
	
	
	public void launchBrowser()
	{
		ChromeOptions op=new ChromeOptions();
		op.addArguments("disable-notifications");
		
		driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		Reporter.log("Launching the Browser.", true);
		driver.get("https://www.policybazaar.com/");
		Reporter.log("Logging In to PolicyBazaar.", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		
	}
	
	
	public void launchBrowserUsingPropertyFile() throws IOException 
	{ 
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get(UtilityMethods.readPropertyFile("url")); 
		Reporter.log("Launching browser", true);
	}
	
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Closing the Browser.", true);
	}
	
}
