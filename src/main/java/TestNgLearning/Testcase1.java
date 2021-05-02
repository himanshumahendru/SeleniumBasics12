package TestNgLearning;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {

	@Test(priority = 2 , groups = "mid")
	public void userLogin() {
		System.out.println("User Login Test");
	}

	@Test(priority = 1 , groups = {"high", "mid"})
	public void userReg() {
		System.out.println("User registration done");
	}

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Browser has been launched");
	}

	@AfterMethod
	public void exitBrowser() {
		System.out.println("Browser has been closed");
	}

	@BeforeClass
	public void DBConn() {
		System.out.println("DB Connection - Before class");
	}

	@AfterClass
	public void closeDBConn() {
		System.out.println("DB Connection closed - After class");
	}
	
	@BeforeTest
	public void Properties() {
		System.out.println("Properties   - Before Test");
	}
	
	@AfterTest
	public void closeProperties() {
		System.out.println("Properties  closed   - After Test");
	}
	
	@BeforeSuite
	public void driverLaunch() {
		System.out.println("Driver  - Before Suite");
	}
	
	@AfterSuite
	public void closeDriver() {
		System.out.println("Driver  closed  - After Suite");
	}

}

