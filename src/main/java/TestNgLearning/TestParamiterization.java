package TestNgLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class TestParamiterization {
	
	public static WebDriver driver;
	
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	@AfterTest
	public void teardown() {
		driver.quit();
		}

	@DataProvider(name = "dp")
	public Object[][] getData() {
		String sheetName = "FirstSheet";
		ExcelReader excel = new ExcelReader(".\\exceldata.xlsx");
		
		//ExcelReader utility class reads Rows starting from 1 and columns starting from 0
		// we need to skip the first row as first row has just the Headings of the column and data is present from 2nd row 
		
		int rows = excel.getRowCount(sheetName);
		System.out.println("Row count is "+ rows);
		int cols = excel.getColumnCount(sheetName);
		
		Object data[][] =  new Object[rows-1][cols];
		
		for(int row = 2; row<=rows; row++) {
			for(int col =0;col<cols;col++) {
				data[row-2][col] = excel.getCellData(sheetName, col, row);
			}
		}
		
		return data;
		}
	
	
	@Test(dataProvider = "dp")
	public void doLogin(String username, String password) {
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}
}
