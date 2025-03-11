package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
Data is valid  - login success - test pass - logout
Data is valid - login failed - test fail

data is in valid - login success - test fail - logout
Data is invalid - login failed - test pass

*/

public class TC003_LoginDDT extends BaseClass{

@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)  //getting data provider from different class/package
public void Verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
{
	logger.info("Starting TC003_LoginDDT***");
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
	lp.setEmail(email);
	lp.clickContinue();
	lp.setPassword(pwd);
	lp.clickLogin();
	
	Thread.sleep(5000);
	//MyAccountPage
	MyAccountPage map=new MyAccountPage(driver);
	boolean targetPage=map.isMyAccountPageExists();
	logger.info("***Confirmed Macathie is displayed***");
	
	Assert.assertEquals(targetPage, true,"Login failed");  //Assert.assertTrue(targetPage);
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("***Finished TC00_LoginTest");
}
	
	
/*
if(exp.equalsIgnoreCase("Valid"))
{
   if(targetPage==true)
   {
      mac.clickLogout();
      Assert.assertTrue(true);
   }
else
{
    Assert.assertTrue(false);
}

}

if
if(exp.equalsIgnoreCase("Invalid"))
{
   if(targetPage==true)
   {
      mac.clickLogout();
      Assert.assertTrue(false);
   }
else
{
    Assert.assertTrue(true);
}

}

*/



}
