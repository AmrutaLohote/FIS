package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	 private WebDriver driver;

	   private By cartCount = By.cssSelector("span[class='badge']");
	   private By cartIcon = By.cssSelector(".gh-cart__icon");
	  
	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	 // Method to get cart count
	    public int getCartCount() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement countElement = wait.until(ExpectedConditions.presenceOfElementLocated(cartCount));
	        return Integer.parseInt(countElement.getText());
	    }

}
