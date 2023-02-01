package testClasses;

import org.testng.annotations.Test;

import base.Base;
import pomClasses.GuruHomePagePOM;
import pomClasses.SignInPage;
import utilityClasses.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;


@Listeners(listenerPackage.Listener.class)
public class LoginFunctionality extends Base 
{

	SignInPage signIn;
	GuruHomePagePOM home;
	String myFile="loginDetails";
 @BeforeMethod 
 public void launchGuru99() throws InterruptedException, IOException 
 {
	launchBrowser("Firefox");
	signIn=new SignInPage(driver);
	home=new GuruHomePagePOM(driver);
  }
	
  @Test
  public void validateLoginWithCorrectUserIdAndCorrectPassword() throws IOException, InterruptedException 
  {	signIn.enteringUserId("userID");
	signIn.enteringPassword("password");
	Utility.takesScreenshot(driver, myFile);
	signIn.clickOnLoginButton();
	utilityClasses.Utility.implicitWait(driver, 2000);
	Assert.assertEquals(driver.getTitle(), Utility.readingDataFromPropertyFile("title"),"Actual and expected are not matching, so TC is failed");
	Reporter.log("Title of home page is "+driver.getTitle(), true);
	Thread.sleep(5000);
	home.clickingOnLogoutButton(driver);
	
  }

  
  @Test
  public void validateLoginWithInvalideUserIdValidPassword() throws IOException, InterruptedException
  {
	signIn.enteringUserId("InvalidUserID");
	signIn.enteringPassword("password");
	Utility.takesScreenshot(driver, myFile);
	signIn.clickOnLoginButton();
	Thread.sleep(1000);
	Assert.assertEquals(signIn.getTextFromAlert(driver), Utility.readingDataFromPropertyFile("errorMsg"),"Error message is not same so, Tc is failed");  
	
  }
  
  @Test
  public void validateLoginWithValidUserIdAndInvalidPassword() throws IOException, InterruptedException
  {
	  signIn.enteringUserId("userID");
	  signIn.enteringPassword("InvalidPass");
	  Utility.takesScreenshot(driver, myFile);
	  signIn.clickOnLoginButton();
	  Thread.sleep(1000);
	  Assert.assertEquals(signIn.getTextFromAlert(driver), Utility.readingDataFromPropertyFile("errorMsg"),"Error message is not same so, Tc is failed");
	  
	  
  }
  
  @Test
  public void validateLoginWithInvalidUserIdAndInvalidPassword() throws IOException, InterruptedException
  {
	  signIn.enteringUserId("InvalidUserID");
	  signIn.enteringPassword("InvalidPass");
	  Utility.takesScreenshot(driver, myFile);
	  signIn.clickOnLoginButton();
	  //Thread.sleep(1000);
	  Assert.assertEquals(signIn.getTextFromAlert(driver), Utility.readingDataFromPropertyFile("errorMsg"),"Error message is not same so, Tc is failed");
	
	  
  }
  
  

  @AfterMethod
  public void afterMethod() 
  {
	 

	driver.close();
	Reporter.log("Closing the browser", true);
	
  }

}
