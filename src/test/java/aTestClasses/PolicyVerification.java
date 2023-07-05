package aTestClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import aBase.Base;
import aPomClasses.LogInPg;
import aPomClasses.MyProfilePg;
import aUtility.UtilityMethods;

public class PolicyVerification extends Base
{
	LogInPg logIn;
	MyProfilePg profilePage;
  @BeforeClass
  public void browserLaunch() throws InterruptedException, IOException
  {
	  //launchBrowser();
	  launchBrowserUsingPropertyFile();
	  UtilityMethods.waitTime(1000);
	  logIn=new LogInPg(driver);
	  profilePage=new MyProfilePg(driver);
  }
	@BeforeMethod
	public void LoggingInToPolicyBazaar() throws InterruptedException, EncryptedDocumentException, IOException
	{
		logIn.clickOnHomeSignInButton();
		UtilityMethods.waitTime(1000);
		//logIn.enterMobileNumber(UtilityMethods.readExcelData(1, 3));
		logIn.enterMobileNumber(UtilityMethods.readPropertyFile("mobNo"));
		UtilityMethods.waitTime(1000);
		logIn.clickOnSignInWithPasswordButton();
		UtilityMethods.waitTime(1000);
		//logIn.enterPassword(UtilityMethods.readExcelData(1, 4));
		logIn.enterPassword(UtilityMethods.readPropertyFile("passWord"));
		UtilityMethods.waitTime(1000);
		logIn.clickOnSignInButton();
		UtilityMethods.waitTime(3000);
		logIn.clickOnMyAccButton();
		UtilityMethods.waitTime(2000);
		logIn.clickOnMyProfileButton();
		UtilityMethods.waitTime(1000);
		
		Set<String> allIDs = driver.getWindowHandles();
		List<String> al= new ArrayList<String>(allIDs);
		String logInID = al.get(0);
		String profileID = al.get(1);
		
		driver.switchTo().window(profileID);
		UtilityMethods.waitTime(2000);
		
		
	}
	
	@Test
  public void userNameVerification() throws InterruptedException, EncryptedDocumentException, IOException 
  {
		String actualUN = profilePage.getActualUN();
		UtilityMethods.waitTime(1000);
		//UtilityMethods.takeScreenShot(driver, (UtilityMethods.readExcelData(1, 5)+" PB_TC0001"));
		String expUN = UtilityMethods.readExcelData(1, 5);
		UtilityMethods.waitTime(1000);
		
		Assert.assertEquals(actualUN, expUN);
		UtilityMethods.waitTime(1000);
		
  }
	@AfterMethod
	public void loggingOut() throws InterruptedException
	{
		profilePage.clickOnLogOutButton();
		UtilityMethods.waitTime(1000);
	}
	@AfterClass
	public void closingBrowser()
	{
		closeBrowser();
	}
	
	
	
	
	
	
}
