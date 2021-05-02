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

public class TestProperties {
	
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestProperties.class.getName());
	

	public static void main(String[] args) throws IOException {
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Log4j.properties");
		
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\Properties\\OR.properties");
		OR.load(fis);
		
		Properties config = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
		config.load(fis);
		
		if(config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome Browser launched");
		} else if(config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox Browser Launched");
		}
		
		//System.out.println(OR.getProperty("username_ID"));
		//driver.findElement(By.id(OR.getProperty("username_ID")));
		//System.out.println(config.getProperty("testsiteURL"));
		//driver.get(config.getProperty("testsiteURL"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		driver.get(config.getProperty("testsiteURL"));
		driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys("him.mahendru");
		driver.findElement(By.xpath(OR.getProperty("nextBtn_XPATH"))).click();
		driver.quit();
		
		
		
		

	}

}
