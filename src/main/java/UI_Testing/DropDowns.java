package UI_Testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDowns {

	public static WebDriver driver;
	public static String browser = "chrome";

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

		driver.navigate().to("https://www.wikipedia.org/");
		System.out.println(driver.getTitle());

		WebElement dropdown = driver.findElement(By.xpath("//select[@id = \"searchLanguage\"]"));

		Select select = new Select(dropdown);
		select.selectByValue("bn");
		select.selectByIndex(5);
		select.selectByVisibleText("Latina");

		List<WebElement> options = driver.findElements(By.tagName("option"));
		System.out.println("Number of options " + options.size());
		System.out.println("9th Element - " + options.get(8).getText());
		System.out.println("9th Element - " + options.get(8).getAttribute("value"));
		System.out.println("..............................");
		System.out.println("total options are as below :- ");

		
		  for(WebElement i : options)
	      System.out.println(i.getAttribute("lang")+ "    " + i.getText());
		

		  System.out.println(".............................."); 
		  
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links in page are " + links.size());
		
		for(int i = 0; i<links.size();i++)
		System.out.println(links.get(i).getText() + " " +  links.get(i).getAttribute("href"));
		
		List<WebElement> blockLinks = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]")).findElements(By.tagName("a"));

		System.out.println("Total Links :- " + blockLinks.size());
		
		// Page contains 3 Web Element Blocks - having 12 elements each having same Id for all the Elements 
		//driver.findElement(By.xpath("// Block 3" )).findElements(By.id("same id of all elements")).get(3).click();
		
		driver.close();

	}

}
