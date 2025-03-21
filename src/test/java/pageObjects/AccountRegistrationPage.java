package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	  {
		  super(driver);
	  }
			
	@FindBy(xpath="//input[@id='emailAddress']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='phoneNumber']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@id='isTermAndCondition']")
	WebElement chkbPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	WebElement btnCreateAccount;
	
	
	
	@FindBy(xpath="//h5[normalize-space()='Verify Account']")
	WebElement msgConfirmation;
	
	
	
	
	
	

	
	public void setEmail(String email) {
	    txtEmail.sendKeys(email);
	}



	public void setFirstName(String fname) {
	      txtFirstname.sendKeys(fname);
	}


	public void setLastName(String lname) {
	    txtLastname.sendKeys(lname);
	}

	public void setTelephone(String tel) {
	    txtTelephone.sendKeys(tel);
	}


	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		 txtConfirmPassword.sendKeys(pwd);
	}


	public void setPrivacyPolicy() {
		 chkbPolicy.click();
	}

	public void clickCreateAccount() {
		btnCreateAccount.click();
	}
		
	
	
	
	
		//solution1
		//btnContinue.click();
		
		//solution2
		//btnContinue.submit();
		
		//solution3
		//Actions act=new Actions(driver);
		//act.movToElement(btncontinue).click().perorm();
		
		//solution4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//solution5
		//btnContinue.sendKeys(keys.RETURN);
		
		//solution6
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.untill(ExpectedConditions.elementToBeClickable(btnContinue)).click();			
	


	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
