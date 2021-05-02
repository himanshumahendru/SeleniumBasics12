package extentReports;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Testcase1 {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setup() {
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setDocumentTitle("Himanshu's Automation Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("First Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Himanshu Mahendru");
		extent.setSystemInfo("Build Number", "12345");
		extent.setSystemInfo("organization", "Mahendry Automation");
		}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@Test
	public void doLogin() {
		test = extent.createTest("Login Test");
		//System.out.println("creating Login Test");
		test.log(Status.PASS, "Test log added as Pass");
	}

	
	@Test
	public void userReg() {
		test = extent.createTest("User Reg Test");
		//System.out.println("creating User Reg Test");
		test.log(Status.FAIL, "Test case failed intentionally");
		Assert.fail("Assert statement used for Failing");
	}

	@Test
	public void validateTitle() {
		test = extent.createTest("Validate Title  Test");
		//System.out.println("creating Validate Title Test - Skipped the test case ");
		test.log(Status.SKIP, "Test case skipped");
		throw new SkipException("Test case skipped - Skip Exception Line");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			/*//for recording lFailure in report 
			//exception message is required - pass it in Log 
			// Capture SS and pass it in log 
			// Create a label and pass it in log
			*/
			// exception message and pass it in test.fail
			String exception = Arrays.toString(result.getThrowable().getStackTrace());
			test.fail(exception);
			//capture SS and pass it in test.fail
			String screenshot = "C:\\Users\\HP\\IdeaProjects\\Selenium\\Screenshot\\Tue_Apr_27_17_09_29_IST_2021.jpg";
			test.fail("<b><font color = red>SS of the failed test case </font> </b> <br>", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			
			// create label - (text, color) - text - method name , color - extentColor.red 
			String methodName = result.getMethod().getMethodName();
			String text = "<b> Test case :- "+methodName + "Failed </b>";
			Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
			test.fail(m);
			
			//test.log(Status.FAIL, "test case has failed at last");
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			
			String methodName = result.getMethod().getMethodName();
			String text = "<b> Test case :- "+methodName + "  Passed </b>";
			Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
			test.pass(m);
			
			//test.pass("Test case passed - Inside Tear down method");
		}else if(result.getStatus() == ITestResult.SKIP) {
			
			String methodName = result.getMethod().getMethodName();
			String text = "<b> Test case :- "+methodName + "  Skipped </b>";
			Markup m = MarkupHelper.createLabel(text, ExtentColor.YELLOW);
			test.skip(m);
			
			//test.skip("Test case Skipped - Inside Tear down method");
			}

}

}
