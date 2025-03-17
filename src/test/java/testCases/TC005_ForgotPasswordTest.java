package testCases;

import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC005_ForgotPasswordTest extends BaseClass{

	
	@Test(groups= {"Sanity","Master"})
	public void Verify_ForgotPassword() throws InterruptedException
	{
		logger.info("**** Starting TC005_ForgotPasswordTest**** ");
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
		
		Thread.sleep(3000);
		ForgotPasswordPage fpp=new ForgotPasswordPage(driver);
		fpp.clickForgotPassword();
		fpp.clickSendotp();
		logger.info("Verify forgotpassword isdisplayed");
		
		 //  Call the method from ForgotPasswordPage
        if (fpp.isOtpBoxDisplayed()) 
        {
            System.out.println(" OTP text box is displayed!");
            logger.info(" OTP text box is displayed!");
        } else 
        {
            System.out.println(" OTP text box is NOT displayed!");
            logger.info(" OTP text box is NOT displayed!");
        }
    } catch (Exception e) 
		{
        System.out.println(" OTP text box is NOT displayed! Exception: " + e.getMessage());
        logger.error(" OTP text box is NOT displayed! Exception: " + e.getMessage());
    } finally {
        driver.quit();
    }

		
	}
	
	
	
	
	
	
	
	
	
	
}
