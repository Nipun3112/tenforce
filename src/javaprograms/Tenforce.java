package javaprograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Tenforce {

public static void main(String[] args) throws InterruptedException {

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Actions actions = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	driver.get("https://www.tenforce.com/");

	try {
	    WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[contains(text(),'I Agree')]")
	    ));
	    cookieBtn.click();
	} catch (Exception e) {
	    System.out.println("Cookie popup not displayed.");
	}

	Thread.sleep(10000);

	WebElement aboutUs = wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//ul[@class='tf-navbar__main-nav tf-navbar__main-nav--main']//span[text()='About Us']")));
			
	actions.moveToElement(aboutUs).perform();

	// Click Career
	WebElement career = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//ul[@class='tf-navbar__main-nav tf-navbar__main-nav--main']//a[text()='Career']")
	));
	career.click();

	// Wait for Career page
	wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//h1[contains(text(),'Career')]")
	));


	// Wait till Career page tabs are loaded
    WebElement lifeAtTenForce = wait.until(
            ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@data-type='people']")
            )
    );

    // Click Life at TenForce
    js.executeScript("arguments[0].click();", lifeAtTenForce);
    

	WebElement article = wait.until(
	        ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[normalize-space()='Life of two interns']/ancestor::a")
	        )
	);
	
	// Scroll into view
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", article);
	Thread.sleep(1000);
	
	
	js.executeScript("arguments[0].click();", article);


    // Scroll Down
    js.executeScript("window.scrollTo(0,2000)");
    Thread.sleep(2000);

    // Scroll Up (Top)
    js.executeScript("window.scrollTo(0,0)");
    Thread.sleep(2000);
    
    driver.navigate().back();
    
    // Click Job Openings
    WebElement jobOpenings = wait.until(
            ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@data-type='job']")
            )
    );
    
    js.executeScript("arguments[0].click();", jobOpenings);

    Thread.sleep(5000);
    WebElement verify = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//*[contains(text(),'Feel free to send your CV')]")
	));

	if (verify.isDisplayed()) {
	    System.out.println("Text found.");
	} else {
	    System.out.println("Text NOT found.");
	}
    
    Thread.sleep(3000);
    driver.quit();
}}