package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import utilityClasses.Utility;

public class Base 
{
	protected static WebDriver driver;
	
	
	public void launchBrowser(String CrossBrowser) throws IOException
	{
		
		if(CrossBrowser.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\91705\\New folder\\GuruBankMVN\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(CrossBrowser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\91705\\New folder\\GuruBankMVN\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		driver.get(Utility.readingDataFromPropertyFile("testUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Reporter.log("Launching browser", true);
		
	
	}
}
