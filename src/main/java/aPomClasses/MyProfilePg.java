package aPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyProfilePg 
{
	//variable
		@FindBy(xpath = "//div[contains(@class,'textCapitalize')]") private WebElement userName;
		@FindBy(xpath = "//div[@title='Logout']") private WebElement logOutButton;
		
		//constructor
		public MyProfilePg(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//method
		public String getActualUN()
		{
			String actualUN = userName.getText();
			Reporter.log("Getting Actual UserName.", true);
			return actualUN;
			
		}
		public void clickOnLogOutButton()
		{
			logOutButton.click();
			Reporter.log("Logging Out of PolicyBazaar.", true);
		}
}
