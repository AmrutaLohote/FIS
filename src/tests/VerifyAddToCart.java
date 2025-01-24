package tests;

import pages.CartPage;
import pages.HomePage;
import pages.ItemPage;
import pages.SearchResultsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class VerifyAddToCart {
	 //WebDriver driver = new ChromeDriver();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // Set up the WebDriver        
        WebDriver driver = new ChromeDriver();

           try {
                // Initialize page objects
                HomePage homePage = new HomePage(driver);
                SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
                ItemPage itemListingPage = new ItemPage(driver);
                CartPage cartPage = new CartPage(driver);

                // Test steps
                driver.get("https://www.ebay.com");
                //Thread.sleep(3000);
                driver.manage().window().maximize();
                
                //To accept the cookies popup
               // WebElement acceptCookiesButton = driver.findElement(By.cssSelector("button#gdpr-banner-accept"));
               // acceptCookiesButton.click();
                
                //To search book
                homePage.searchForItem("book");
                searchResultsPage.clickFirstItem();
                Thread.sleep(3000);
                itemListingPage.addToCart();

                // Verify cart count
                int cartItemCount = cartPage.getCartCount();
                System.out.println("Items in cart: " + cartItemCount);

                if (cartItemCount > 0) {
                    System.out.println("Cart updated successfully!");
                } else {
                    System.out.println("Cart update failed.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Quit the browser
                driver.quit();
            }
        }
}