package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws InterruptedException
	{
		
		//Extent report generate 
		ExtentTest test = extent.createTest("MyLogin_LogoutTest", "Login_Logout");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		// info(details)
		test.info("This step shows usage of info(details)");
		//Extent report generate 
		
		driver.get(baseURL);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		Thread.sleep(5000);
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) 
		{
			lp.clickLogout();
			log.info("Login and Logout test is done");
			Thread.sleep(5000);
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
			log.info("Login and Logout validation test is done");
		}
		
	}


	
}
