package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {

    @Test(groups= {"Sanity","Master"})
    public void Verify_ProductSearch() {
        logger.info("Starting TC004_SearchProductTest");

        try {
            HomePage hp = new HomePage(driver);
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
            logger.info("Searched for Product");	
        		
            hp.enterProductName("pears");
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", hp.getSearchIcon());
            logger.info("Clicked on Search Icon using JavaScript.");


            // Validate search results
            SearchPage sp = new SearchPage(driver);
            String actualPageTitle = sp.getSearchResultText(); // Correct method name

            logger.info("Validating search page title...");

            // Correct assertion with trimmed spaces (to avoid minor formatting mismatches)
            Assert.assertEquals(actualPageTitle.trim(), "Products : Pears", "Search page title did not match!");

            logger.info("***** TC004_SearchProductTest Finished *****");

        } catch (Exception e) {
            logger.error("Test case failed due to exception: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
}
