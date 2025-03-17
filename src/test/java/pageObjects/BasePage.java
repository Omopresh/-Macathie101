package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions; // Initialize Actions class

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Centralized wait method for all page objects
    protected void waitForElement(WebElement element, int timeout) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        customWait.until(ExpectedConditions.visibilityOf(element));
    }

    // Refresh Page with JavaScript ready-state check
    public void refreshPage() {
        driver.navigate().refresh();
        wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    //  Click an element when clickable
    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

 // Scrolls to an element to bring it into view
    public void scrollToElement(WebElement element) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    
    
    //  Enter text in a field after ensuring visibility
    public void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

 //Click dropdown and select option using Actions
    public void selectDropdownOption(WebElement dropdown, WebElement option) {
        waitForElement(dropdown, 5);
        
        //Fix: Ensure Actions is initialized before using it
        if (actions == null) {
            actions = new Actions(driver);
        }

        actions.moveToElement(dropdown).click().perform(); //Open dropdown
        waitForElement(option, 5);
        actions.moveToElement(option).click().perform();  //Click option
    }

    
    // Check if element is displayed with a safe try-catch
    public boolean isElementDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
