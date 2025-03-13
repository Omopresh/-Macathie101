package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage (WebDriver driver)
	  {
		  super(driver);
	  }
	
	
	@FindBy(xpath="//h6[normalize-space()='Products : pears']")
	WebElement searchResultHeading;

	
	
	
	
	public String getSearchResultText() {
	    try {
	        return searchResultHeading.getText();
	    } catch (Exception e) {
	        System.out.println("Error in getSearchResultText(): " + e.getMessage());
	        return "Element Not Found"; 
	    }
	}

	
}
