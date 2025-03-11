package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
	  {
		  super(driver);
	  }	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//button[normalize-space()='Continue with Email']")
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit'][normalize-space()='Login']")
	WebElement btnLogin;
	
	
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
}
