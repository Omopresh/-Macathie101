package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{

	public ForgotPasswordPage(WebDriver driver)
	  {
		  super(driver);
	  }
	
	
	
	@FindBy(xpath="//a[normalize-space()='Forgot Password?']")
	WebElement lnkForgotPassword;
	
	@FindBy(xpath="//button[normalize-space()='Send OTP']")
	WebElement btnSendotp;
	
	@FindBy(xpath="//div[contains(@class, 'd-flex') and contains(@class, 'justify-content-between') and contains(@class, 'mb-2')]")
	WebElement  OTPPage;
	
	
	
	
	
	public void clickForgotPassword() 
	{
		lnkForgotPassword.click();
	}
	
	public void clickSendotp() 
	{
		btnSendotp.click();
	}
	
	
	public boolean isOtpBoxDisplayed() {
        return OTPPage.isDisplayed();
	
	}
}


