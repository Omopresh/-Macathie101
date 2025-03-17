package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='drug-list-container']//app-drug-card[1]//img")
    private WebElement productImage;  // Private to enforce encapsulation
    
    @FindBy(xpath = "//h5[@class='nunito-sans product-name font-700 header-text-40 hala-black text-capitalize']")
    WebElement productName;

    @FindBy(xpath = "//span[@class='me-3 rating-stars']")
     WebElement productStar;

    @FindBy(xpath = "//p[@class='nunito-sans font-400 text-14 hala-black']")
    WebElement productReview;

    @FindBy(xpath = "//div[contains(@class, 'col-xl-6') and contains(@class, 'px-4')]//div[contains(@class, 'd-flex') and contains(@class, 'align-items-center')]")
    WebElement productAmount;

    @FindBy(xpath = "//button[@id='countryTypeDropdown']")
    WebElement selectDropdown;

    @FindBy(xpath = "//span[normalize-space()='second branch crut']")
    WebElement selectBranch;

    @FindBy(xpath = "//button[contains(normalize-space(), 'small')]")
    WebElement choseSize;

    @FindBy(xpath = "//div[contains(@class, 'dropdown-menu') and contains(@class, 'branch-dropdown')]//p[contains(@class, 'dropdown-item')]")
    WebElement selectSize;

    @FindBy(xpath = "//button[contains(@class, 'btn') and contains(text(), 'Add to Cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(@class, 'add-favourite')]//img")
    WebElement addToFavoriteButton;

    @FindBy(xpath = "//section[contains(@class, 'deals')]//div[contains(@class, 'container')]")
    WebElement dealSection;
    
    
    //  Getter Method for Product Image
    public WebElement getProductImage() {
        return productImage;
    }

    //  Click on Product Image
    public void clickOnProductImage() {
        waitForElement(productImage, 10);
        productImage.click();
    }


    //  Ensures visibility before getting text
    public String getProductName() {
        waitForElement(productName, 5);
        return productName.getText();
    }

    public String getProductStar() {
        waitForElement(productStar, 5);
        return productStar.getText();
    }

    public String getProductReview() {
        waitForElement(productReview, 5);
        return productReview.getText();
    }

    public String getProductAmount() {
        waitForElement(productAmount, 5);
        return productAmount.getText();
    }
    
    
 //Click the dropdown to open it
    public void clickDropdown() {
        waitForElement(selectDropdown, 10);
        selectDropdown.click();
    }

    public void clickBranch() {
        waitForElement(selectBranch, 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectBranch);
    }

    public void chooseSize() {
        waitForElement(choseSize, 5);
        choseSize.click();
        waitForElement(selectSize, 5);
        selectSize.click();
    }

    //  Adds wait before clicking Add to Cart
    public void addToCart() {
        waitForElement(addToCartButton, 5);
        addToCartButton.click();
    }

    //  Adds wait before clicking Add to Favorite
    public void addToFavorites() {
        waitForElement(addToFavoriteButton, 5);
        addToFavoriteButton.click();
    }

    //  Checks if the deal section is displayed
    public boolean isDealSectionDisplayed() {
        waitForElement(dealSection, 5);
        return dealSection.isDisplayed();
    }
}
