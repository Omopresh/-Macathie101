package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	 public HomePage(WebDriver driver)	
	  {
		  super(driver);
	  }	
	
	 @FindBy(xpath="//div[@class='dropdown']")
	     
		WebElement btnDropdown;
		
	 @FindBy(xpath="//div[@class='form-group mt-3']//p[1]")
	  WebElement btnBranch;

		@FindBy(xpath="//button[@class='submit border-0 bg-hala-pri rounded-100 nunito-sans text-white text-18 font-500 mt-4']")
		
		WebElement btnProceed;
	 
	 @FindBy(xpath="//button[@class='text-decoration-underline text-dark border-0 bg-transparent']")
	 WebElement lnkCreateAccount;
	 	
	
	 @FindBy(xpath="//button[@routerlink='/login' and contains(@class, 'get-started-btn') and normalize-space(text())='Login']")
	 WebElement lnkLogin;
	 

	  
	 
	// Using the common method from BasePage
	    public void clickDropdown() {
	        clickElement(btnDropdown);
	    }

	    public void clickBranch() {
	        clickElement(btnBranch);
	    }

	    public void clickProceed() {
	        clickElement(btnProceed);
	    }

	    public void clickCreateAccount() {
	        clickElement(lnkCreateAccount);
	    }

	    public void clickLogin() 
	    {
	    	refreshPage();
	        clickElement(lnkLogin);
	    }
	 
	 
	 
}
