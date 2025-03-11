package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	@Test(groups= {"Sanity","Master"})
	public void verify_account_registration()
	{
	
		logger.info("***** starting TC001_AccountRegistrationtest  *****");
		
	try
	{
		
		logger.info("Clicked on HomePage Link..");
		
	HomePage hp=new HomePage(driver);
	Thread.sleep(5000);
	// Handle Pop-up on HomePage
	
    logger.info("Handling pop-up on Home Page...");
    Thread.sleep(3000);
 // Click Branch Dropdown to Open Options
    hp.clickDropdown();  
    hp.clickBranch();
    hp.clickProceed();
    logger.info("Clicked on Branch Dropdown.");

    Thread.sleep(3000);
	hp.clickCreateAccount();	
		
	logger.info("Clicked on AccountRegistrationPage Link..");
	
	AccountRegistrationPage arpage=new AccountRegistrationPage(driver);	
	Thread.sleep(5000);
	logger.info("Providing customer details...");
	arpage.setEmail(randomString()+"@gmail.com");
	arpage.setFirstName(randomString().toUpperCase());
	arpage.setLastName(randomString().toUpperCase());	
	arpage.setTelephone(RandomStringUtils.randomNumeric(10));
			
	String password=randomAlphaNumberic();
			
	arpage.setPassword(password);
	arpage.setConfirmPassword(password);
			
	Thread.sleep(5000);
	arpage.setPrivacyPolicy();
	logger.info("Clicked Privacy Policy Checkbox.");
	arpage.clickCreateAccount();
	
	Thread.sleep(3000);
	
	logger.info("Validating expected message..");
	String confmsg=arpage.getConfirmationMsg();
	Assert.assertEquals(confmsg, "Verify Account");
	
	if(confmsg.equals("Verify Account"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("Test failed..");
		logger.debug("Debug logs..");
		Assert.assertEquals(true, false);
	}
		
   }
   catch(Exception e)
   {
	   Assert.fail();
			
   }
	logger.info("***** Finished TC001_Accountregistrationtest *****");
  
	
	
	
	
	
	
	}
	
		
	
	
	
	
}
