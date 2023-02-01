package revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownStudy 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\91705\\New folder\\GuruBankMVN\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		driver.findElement(By.xpath("//a[contains(@id,'u_0_0_')]")).click();
		Thread.sleep(1000);
		
		WebElement day = driver.findElement(By.id("day"));
		Select s1=new Select(day);
		s1.selectByVisibleText("6");
		Thread.sleep(2000);
		
		WebElement month = driver.findElement(By.name("birthday_month"));
		Select s2=new Select(month);
		s2.selectByIndex(10);
		Thread.sleep(3000);
		//s2.deselectByIndex(10);
		Thread.sleep(3000);
		s2.selectByIndex(9);
		
		
		
		WebElement year = driver.findElement(By.id("year"));
		Select s3=new Select(year);
		s3.selectByValue("1992");
		Thread.sleep(3000);
		
		driver.close();
		
		

	}

}
