package aUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityMethods
{
	//wait
	public static void waitTime(int time) throws InterruptedException
	{
		Thread.sleep(time);
		Reporter.log("Waiting for "+time+"mili seconds.", true);
	}
	
	//takeScreenshot
	public static void takeScreenShot(WebDriver driver, String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Reporter.log("Taking a Screenshot.", true);
		File dest=new File("C:\\Users\\Kunal\\eclipse-workspace\\PolicyBazaarProject\\PolicyBazaarProject\\ScreenShot\\"+fileName+".png");
		
		FileHandler.copy(src, dest);
		Reporter.log("ScreenShot is Stored at "+dest+".", true);
		
	}
	
	//ScrollIn
	public static void scrolling(WebDriver driver, WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Scrolling Into View.", true);
	}
	
	//readExcel
	
	public static String readExcelData(int row, int col) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Kunal\\eclipse-workspace\\PolicyBazaarProject\\PolicyBazaarProject\\InputDataExce\\Test1.xlsx");
		String value = WorkbookFactory.create(fis).getSheet("Sheet1").getRow(row).getCell(col).getStringCellValue();
		Reporter.log("Reading data from Excel sheel.", true);
		return value;
		
	}
	//read data from property file
	public static String readPropertyFile(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myFile=new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\OMproject1\\Omi_Sel\\PropertyFile.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("reading data "+key+" From property file.", true);
		return value;
		
	}
	
	
	
	
	
}
