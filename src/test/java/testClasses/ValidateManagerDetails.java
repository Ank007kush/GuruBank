package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import pomClasses.GuruHomePagePOM;
import pomClasses.SignInPage;
import utilityClasses.Utility;

@Parameters("CrossBrowser")	
@Listeners(listenerPackage.Listener.class)
public class ValidateManagerDetails extends Base
{
	SignInPage signIn;
	GuruHomePagePOM home;
	
	
	@BeforeMethod
	public void launchGuru99App() throws IOException
	{
		launchBrowser("CrossBrowser");
		
		signIn=new SignInPage(driver);
		home=new GuruHomePagePOM(driver);
	}
	
  @Test
  public void validateManagerId() throws IOException, InterruptedException 
  {
	signIn.enteringUserId("userID");
	signIn.enteringPassword("password");
	
	signIn.clickOnLoginButton();
	Reporter.log("Actual manager Id is -->"+home.getManagerId(), true);
	Utility.takesScreenshot(driver, "Ankush");
	Assert.assertEquals(home.getManagerId(), Utility.readingDataFromPropertyFile("managerId"),"Actual Manager Id and expected user id are not matching so, TC is failed");
	Reporter.log("Tc is passed", true);
	Thread.sleep(1000);
	home.clickingOnLogoutButton(driver);
  }
  
  @AfterMethod
  public void closingBrowser()
  {
	  driver.close();
	  Reporter.log("Closing the browser", true);
  }
}
