package UI_Testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {
	
	public static WebDriver driver;
	public static String browser = "chrome";


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

		driver.navigate().to("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		System.out.println(driver.getTitle());
		
		// first Way of doing it 
		
		/*
		 * for(int i =1; i<=4; i++) {
		 * driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		 * 
		 * }
		 */


		//second way of doing it 
		
		/*
		 * int i = 1;
		 * while(isElementPresentUniversal(By.xpath("//div[4]/input["+i+"]"))) {
		 * driver.findElement(By.xpath("//div[4]/input["+i+"]")).click(); i++; }
		 * System.out.println("Number of checkboxes is :- " + (i-1));
		 */
		
		// third way of doing it 
		
		WebElement section = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement>  boxes = section.findElements(By.name("sports"));
		for(WebElement i : boxes)
			i.click();
		
		
	}

}
