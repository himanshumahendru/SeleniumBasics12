package UI_Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sliders {

	public static WebDriver driver;
	public static String browser = "chrome";
	
	
	public static void main(String[] args) {
	
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// Drag and Drop by
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		new Actions(driver).dragAndDropBy(slider, 500, 0).perform();
		
		int width = driver.findElement(By.xpath("//*[@id=\"slider\"]")).getSize().width/2;
		new Actions(driver).dragAndDropBy(slider, width, 0).perform();
		
		
		// resize an element 
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
		WebElement resize = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		new Actions(driver).dragAndDropBy(resize, 400, 400).perform();
		
		// Drag and Drop on Element 
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		WebElement draggable = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement droppable = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		new Actions(driver).dragAndDrop(draggable, droppable).perform();
		
		
		
		// Right Click 
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		WebElement context = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
		
		new Actions(driver).contextClick(context).perform();

		
	}
	
	
	
}
