package extentlisteners;

import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListener implements ITestListener {

	static Date d = new Date();
	static String fileName = d.toString().replace(" ", "_").replace(":", "_")+".html";
    private static ExtentReports extent = ExtentManager.createInstance("./reports\\" + fileName);
    public  static ExtentTest test;
    
	
	
	@Override
	public void onTestStart(ITestResult result) {
	 test = extent.createTest(result.getTestClass().getName()+ "   @Test Name -  " + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>Test Case Passed - "+methodName+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String exception = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail(exception);
		
		String methodName = result.getMethod().getMethodName();
		String logText = "<b> Test Case Failed - "+methodName+ "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.fail(m);
		
		String SS = "C:\\Users\\HP\\IdeaProjects\\Selenium\\Screenshot\\Tue_Apr_27_17_09_29_IST_2021.jpg";
		test.fail("<b><font color = red>SS of the failed testcase</font> </b><br>",MediaEntityBuilder.createScreenCaptureFromPath(SS).build());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>Test Case Skipped - "+methodName+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {

		if(extent != null) {
			extent.flush();
		}
	}

}
