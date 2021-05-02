package UI_Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PresenceOfElement {

	public static WebDriver driver;
	public static String browser = "chrome";

	public static boolean isElementPresent(String xpath) {
		/*
		 * try { driver.findElement(By.xpath(xpath)); return true; }catch(Throwable t) {
		 * System.out.println(t); return false; }
		 */
		
		int size = driver.findElements(By.xpath(xpath)).size();
		if(size == 0)
			return false;
		else return true;
		
		
		
	}
	
	public static boolean isElementPresentUniversal(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}catch(Throwable t) {
			return false;
		}
		
		
	}
	
	public static void main(String[] args) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().to("https://gmail.com/");
		
		// checking presence of an element 
		System.out.println(isElementPresent("//*[@id=\"identifierId\"]"));
		System.out.println(isElementPresent("//*[@id=\"identifierId123\"]"));

		
		System.out.println(isElementPresentUniversal(By.xpath("//*[@id=\\\"identifierId\\")));
		System.out.println(isElementPresentUniversal(By.id("identifierii")));
		
		driver.close();
	}

}
