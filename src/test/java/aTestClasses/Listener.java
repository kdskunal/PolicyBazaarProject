package aTestClasses;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import aBase.Base;
import aUtility.UtilityMethods;

public class Listener extends Base implements ITestListener
{
	
	public void onTestSuccess(ITestResult result)
	{
		String tcName = result.getName();
		Reporter.log("This "+tcName+" method is completed successfully.", true);
	}
	public void onTestFailure(ITestResult result)
	{
		
		try {
			UtilityMethods.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("This "+result.getName()+" method is failed.", true);
	}
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("This "+result.getName()+" method is skipped.", true);
	}
	public void onTestStart(ITestResult result)
	{
		Reporter.log("This "+result.getName()+" TC execution started.", true);
	}
}
