package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

public class ItemPage {

	WebDriver driver;
	
    @FindBy(xpath = "//a[@id='atcBtn_btn_1' and contains(@class, 'ux-call-to-action')]")
    WebElement addToCartButton;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() throws InterruptedException {
    	   	
       	// Store the current window handle
    	String originalWindow = driver.getWindowHandle();
    	

    	// Wait for new tab to open
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(driver -> driver.getWindowHandles().size() > 1);

    	// Get all window handles
    	Set<String> allWindows = driver.getWindowHandles();
    	for (String window : allWindows) {
    	    if (!window.equals(originalWindow)) {
    	        // Switch to the new window
    	        driver.switchTo().window(window);
    	        JavascriptExecutor js = (JavascriptExecutor)driver;
    			js.executeScript("window.scrollBy(10, 300)");    			
    	        break;
    	    }
    	}

    	// Now we are in the new tab
    	// Interact with the Add to Cart button 
    	WebElement newAddToCartButton = driver.findElement(By.xpath("//a[@id='atcBtn_btn_1' and contains(@class, 'ux-call-to-action')]"));
    	newAddToCartButton.click();
    	
    	driver.findElement(By.cssSelector("button[aria-label='Close overlay']")).click();
    	
    	
    	
    }
}
