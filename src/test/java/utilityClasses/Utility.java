package utilityClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility 
{
	public static void implicitWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("Waiting for "+time+" ms", true);
	}
	
	public static void takesScreenshot(WebDriver driver, String myFile) throws IOException
	{	
		String rand = RandomString.make(3);
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		File dest=new File("C:\\Users\\91705\\New folder\\GuruBankMVN\\ScreenShots\\"+myFile+rand+".png");
	
		org.openqa.selenium.io.FileHandler.copy(scr, dest);
		Reporter.log("Taking screenShot", true);
		Reporter.log("ScreenShot is saved at "+dest, true);
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element );
		Reporter.log("Scrolling into view "+element.getText(), true);
	}
	
	public static String readingDataFromPropertyFile(String key) throws IOException
	{
		Properties obj=new Properties();
		
		FileInputStream prop=new FileInputStream("C:\\Users\\91705\\New folder\\GuruBankMVN\\guruBank.properties");
		
		obj.load(prop);
		
		String value = obj.getProperty(key);
		return value;
		
	}
	
}
