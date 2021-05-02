package UI_Testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

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
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		// switch to particular Frame
		driver.switchTo().frame("iframeResult");
		//driver.findElement(By.xpath("/html/body/button")).click();
		
		// If driver instance was of Chrome Driver / any other browser , then I could have directly used 
		//executeScript() of JavaScriptExecutor Interface , as all browsers are implementing classes of that interface
	    // ChromeDriver driver = new ChromeDriver();
	    //driver.executeScript("myfunction()");
       // for WebDriver driver instance , we need to add JavaScriptExecutor castType to driver instance 
	 ((JavascriptExecutor) driver).executeScript("myFunction()");
	 ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));
		
	 // return to the default content 
		driver.switchTo().defaultContent();
		
		List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
		System.out.println("the Total Number of Frames on the page are - " + frames.size());
		
		// display the IDs of the frames present 
		
		for(WebElement frame : frames)
			System.out.println(frame.getAttribute("id"));
		
		
		// If driver instance was of Chrome Driver / any other browser , then I could have directly used 
		//executeScript() of JavaScriptExecutor Interface , as all browsers are implementing classes of that interface
		// ChromeDriver driver = new ChromeDriver();
		//driver.executeScript("myfunction()");
		// for WebDriver driver instance , we need to add JavaScriptExecutor castType to driver instance 
		
		
		
		
		
	}

}
