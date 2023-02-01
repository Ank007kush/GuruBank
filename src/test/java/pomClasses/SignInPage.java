package pomClasses;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utilityClasses.Utility;



public class SignInPage 
{
	@FindBy(name = "uid")private WebElement userID;
	@FindBy(name = "password")private WebElement password;
	@FindBy(name = "btnLogin")private WebElement loginButton;
	
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enteringUserId(String key) throws IOException
	{
		userID.sendKeys(Utility.readingDataFromPropertyFile(key));
		Reporter.log("Entering user ID", true);
		Reporter.log("Entered value is "+Utility.readingDataFromPropertyFile(key), true);
	}
	
	public void enteringPassword(String key) throws IOException
	{
		password.sendKeys(Utility.readingDataFromPropertyFile(key));
		Reporter.log("Entering password", true);
		Reporter.log("Entering value is "+Utility.readingDataFromPropertyFile(key), true);
	}
	
	public void clickOnLoginButton() throws IOException
	{
	
		loginButton.click();
		Reporter.log("Clocking on login Button", true);
	}
	
	
	public String getTextFromAlert(WebDriver driver) throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		//String eText = driver.switchTo().alert().getText();
		Alert alt = driver.switchTo().alert();
		String eText = alt.getText();
		Reporter.log("Error message is --> "+eText, true);
		Thread.sleep(1000);

		//driver.switchTo().alert().accept();
		alt.accept();
		Reporter.log("Allert is handeled", true);
		return eText;
		
	}
	


	
}
