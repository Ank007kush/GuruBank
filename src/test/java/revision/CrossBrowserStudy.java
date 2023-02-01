package revision;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserStudy 
{
	WebDriver driver=null;
	@Parameters("CrossBrowser")
  @Test
  public void cbTesting(String cb) 
  {
	  if(cb.equals("Firefox"))
	  {
		    System.setProperty("webdriver.gecko.driver","C:\\Users\\91705\\New folder\\GuruBankMVN\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
	  }
	  else if(cb.equals("chrome"))
	  {
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\91705\\New folder\\GuruBankMVN\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();  
	  }
		
		driver.get("https://www.facebook.com/");
  }
}
