package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC006_ProductPageTest extends BaseClass{

	 @Test(groups = {"Regression", "Master"})
	 public void verifyProductPageFunctionality() throws InterruptedException 
	 {
	 logger.info(" Starting TC006_ProductPageTest...");

	 HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		logger.info("***Handling pop-up on Home Page***");
	    Thread.sleep(5000);
	    
	    
	 // Click Branch Dropdown to Open Options
	    hp.clickDropdown();  
	    hp.clickBranch();
	    hp.clickProceed();
	    logger.info("Clicked on Branch Dropdown.");
	    

        ProductPage pp=new ProductPage(driver);
	    //  Scroll to product image
	    logger.info("Scrolling to Product Image...");
	    pp.scrollToElement(pp.getProductImage());

	    //  Click the product image
	    logger.info("Clicking on Product Image...");
	    pp.clickOnProductImage();
	
        
	 
        
     String productName = pp.getProductName();
     Assert.assertNotNull(productName, " Product name is NOT displayed!");
     logger.info(" Product name displayed: " + productName);
     
     // Verify product rating & review
     String productRating = pp.getProductStar();
     Assert.assertFalse(productRating.isEmpty(), " Product rating is NOT displayed!");
     logger.info(" Product Rating: " + productRating);

     String productReview = pp.getProductReview();
     Assert.assertFalse(productReview.isEmpty(), " Product review is NOT displayed!");
     logger.info(" Product Review: " + productReview);
     
     //  Verify product price is displayed
     String productAmount = pp.getProductAmount();
     Assert.assertFalse(productAmount.isEmpty(), " Product amount is NOT displayed!");
     logger.info(" Product Price: " + productAmount);
     Thread.sleep(5000);
     
  // Open Branch Dropdown and Select a Branch
     Thread.sleep(5000);
     pp.clickDropdown();
     logger.info("Clicked on Branch Dropdown.");

     Thread.sleep(5000);
     pp.clickBranch();
     logger.info("Selected Branch successfully.");

     
  
     //Select size
     pp.chooseSize();
     logger.info(" Size selected successfully.");
     
     Thread.sleep(7000);
     //  Add to cart
     pp.addToCart();
     logger.info(" Product added to cart.");

     //  Add to favorite
     pp.addToFavorites();
     logger.info(" Product added to favorites.");
     
     //  Verify Deal Section is visible
     boolean isDealDisplayed = pp.isDealSectionDisplayed();
     Assert.assertTrue(isDealDisplayed, " Deal section is NOT displayed!");
     logger.info(" Deal section is displayed.");

     logger.info(" TC006_ProductPageTest PASSED! ");
 }
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
