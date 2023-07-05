package aPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LogInPg
{
	//variable
		@FindBy(xpath="//a[@class='sign-in']") private WebElement signInButtonHomePage;
		@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobileNumber;
		@FindBy(xpath = "(//a[@id='central-loggin-with-pwd'])[2]") private WebElement SignInWithPWButton;
		@FindBy(xpath = "//input[@name='password']") private WebElement passwordField;
		@FindBy(xpath = "//a[@class='cl-btn sr-btn-primary']") private WebElement signInButtonPWPg;
		@FindBy(xpath = "//a[@class='signed signed-desk']") private WebElement myAccButton;
		@FindBy(xpath = "//a[@class='ico-1']") private WebElement myProfileButton;
		
		//constructor
		public  LogInPg(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//methods
		public void clickOnHomeSignInButton()
		{
			signInButtonHomePage.click();
			Reporter.log("Clicking on Home page SignInButton.", true);
		}
		public void enterMobileNumber(String mobNo)
		{
			mobileNumber.sendKeys(mobNo);
			Reporter.log("Entering Mobile No.", true);
		}
		public void clickOnSignInWithPasswordButton()
		{
			SignInWithPWButton.click();
			Reporter.log("Clicking on SignInWithPWButton.", true);
		}
		public void enterPassword(String passWord)
		{
			passwordField.sendKeys(passWord);
			Reporter.log("Entering Password.", true);
		}
		public void clickOnSignInButton()
		{
			signInButtonPWPg.click();
			Reporter.log("Clicking on signInButtonPWPg.", true);
		}
		public void clickOnMyAccButton()
		{
			myAccButton.click();
			Reporter.log("Clicking on myAccButton.", true);
		}
		public void clickOnMyProfileButton()
		{
			myProfileButton.click();
			Reporter.log("Clicking on myProfileButton.", true);
		}

	
}
