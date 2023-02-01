package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utilityClasses.Utility;

public class GuruHomePagePOM 
{
	@FindBy(xpath = "//a[text()='Log out']")private WebElement logoutButton;
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")private WebElement managerId;
	
	public GuruHomePagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver	, this);
	}
	
	public void clickingOnLogoutButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		Utility.scrollIntoView(driver, logoutButton);
		logoutButton.click();
		Thread.sleep(500);
		String alerttext = driver.switchTo().alert().getText();
		Reporter.log("Alert pop text is "+alerttext,true);
		driver.switchTo().alert().accept();
		//Reporter.log("Clicking on logout button", true);
	}
	
	public String getManagerId()
	{
		String manID = managerId.getText();
		Reporter.log("Manager Id is "+manID, true);
		return manID;
	}

	


}
