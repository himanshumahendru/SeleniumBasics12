package UI_Testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestProperties.class.getName());
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	
	public static void click(String key) {
		if(key.endsWith("_XPATH"))
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		else if(key.endsWith("_ID"))
			driver.findElement(By.id(OR.getProperty(key))).click();
		else if(key.endsWith("_CSS"))
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		
		log.info("Clicked on the Element - " + OR.getProperty(key));
	}
	
	public static void type(String key , String value) {
		if(key.endsWith("_XPATH"))
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		else if(key.endsWith("_ID"))
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		else if(key.endsWith("_CSS"))
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		
		log.info("Typed in the Element - "+ OR.getProperty(key) + "- Entered value as - "+ value );
		
	}
	
	public static void main(String[] args) throws IOException {

		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\log4j.properties");
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
		OR.load(fis);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
		Config.load(fis);
		
		if(Config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		log.info("Browser launched - " + Config.getProperty("browser"));
		
		driver.get(Config.getProperty("testsiteURL"));
		log.info("Opened Test site URL - "+ Config.getProperty("testsiteURL"));
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		type("username_ID", "him.mahendru");
		click("nextBtn_XPATH");
		
		
		
		

		
		
	}

}
