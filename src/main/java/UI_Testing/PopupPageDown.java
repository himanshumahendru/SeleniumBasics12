package UI_Testing;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupPageDown {
	
	public static WebDriver driver;
	public static String browser = "chrome";
	
	public static void main(String[] args) throws InterruptedException {

		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get("http://www.way2automation.com/");
		
		// print the window Id of the current opened window
		String window1 = driver.getWindowHandle();
		System.out.println("Window Id of first/ opened  window - " + window1);
		
		// Page Down can be done on a selected element as well
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div[2]/div/a[1]")).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(3000);
		// Page Down can also be done using Actions class 
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		
		Thread.sleep(3000);
		// page scroll up and down can also be done using JavascriptExecutor 
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
		
		
		//driver.close();

}
}
