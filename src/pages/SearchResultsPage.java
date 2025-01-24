package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	WebDriver driver;

    By firstItem = By.cssSelector("li.s-item:first-of-type .s-item__title");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstItem() {
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //WebElement item = wait.until(ExpectedConditions.elementToBeClickable(firstItem));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".s-item__title")));
        List<WebElement> titles = driver.findElements(By.cssSelector("li.s-item:first-of-type .s-item__title"));
        System.out.println(titles);
        //item.click();
        for (WebElement title : titles) {
            if (title.isDisplayed()) {
            	
                title.click();
                System.out.println("Clicked the first visible link successfully!");
                break; // Exit the loop after clicking the first visible link
            }
        }
    }

}
