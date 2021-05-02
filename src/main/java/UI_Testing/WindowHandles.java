package UI_Testing;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

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
		
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div[2]/div/a[1]")).click();
		
		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> iterate = winIds.iterator();
		
		window1 = iterate.next();
		String window2 = iterate.next();
		
		// switch to second window
		driver.switchTo().window(window2);
		
		System.out.println("switched to second window - " + window2);
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("him@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("test123");
		//driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[4]/input")).click();
		//Thread.sleep(3000);
		// closed the second window
		driver.close();
		
		// Switch back to first window again
		
		driver.switchTo().window(window1);
		
		System.out.println("back to first window again");
		
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div[2]/div/a[2]")).click();
		
		winIds = driver.getWindowHandles();
		System.out.println("Total Number of window Handles now - " + winIds.size() );
		
		Iterator<String> it2 = winIds.iterator();
		
		while(it2.hasNext()) 
		System.out.println("Window Handle -" + it2.next());
		
		// returns focus to the main page / window 
		//driver.switchTo().defaultContent();
		
		driver.close();
		driver.quit();
	}

}
