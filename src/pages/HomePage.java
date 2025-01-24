package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	By cookieAccept = By.id("button#gdpr-banner-accept");
    By searchBox = By.id("gh-ac");
    By searchButton = By.id("gh-search-btn");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForItem(String itemName) throws InterruptedException {
    	
        driver.findElement(searchBox).sendKeys(itemName);
        driver.findElement(searchButton).click();
       Thread.sleep(2000);
       
    }

}
