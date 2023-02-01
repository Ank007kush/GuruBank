package listenerPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.Base;
import utilityClasses.Utility;


public class Listener extends Base implements ITestListener
{
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("Test case "+result.getName()+" is successfully passed", true);
		try {
			Utility.takesScreenshot(driver	, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result,WebDriver driver) 
	{	Reporter.log("Test case "+result.getName()+" is failed., try again", true);
		try {
			Utility.takesScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("Test case "+result.getName()+" is skipped, look it once", true);
	}
}
