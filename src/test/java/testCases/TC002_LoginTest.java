package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"Regression","Master"})
	public void Verify_Login() throws InterruptedException
	{
		
		logger.info("*** Starting TC_002_LoginTest ***");
		try
		{
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		
		
	    logger.info("***Handling pop-up on Home Page***");
	    Thread.sleep(3000);
	 // Click Branch Dropdown to Open Options
	    hp.clickDropdown();  
	    hp.clickBranch();
	    hp.clickProceed();
	    hp.clickLogin();
	    logger.info("Clicked on Branch Dropdown.");

	    
	    Thread.sleep(5000);
	    logger.info("***Clicked on Login Details***");
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.clickContinue();
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		Thread.sleep(5000);
		logger.info("***Confirmed Macathie is displayed***");
		//MyAccountPage
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountPageExists();
				
		Assert.assertEquals(targetPage, true,"Login failed");  //Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished TC00_LoginTest");
	}
	
	
	
}
