package TestNgLearning;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		Reporter.log("Testcase Failed - Capturing SS as well");
		// Reporter.log("<a href
		// =\"C:\\Users\\HP\\IdeaProjects\\Selenium\\Screenshot\\Tue_Apr_27_17_09_29_IST_2021.jpg\">Screenshot
		// Link</a>");
		// open SS in a separate window = target = _blank
		Reporter.log(
				"<a href =\"C:\\Users\\HP\\IdeaProjects\\Selenium\\Screenshot\\Tue_Apr_27_17_09_29_IST_2021.jpg\" target = \"_blank\">Screenshot Link</a>");
		Reporter.log("<br>");
		// insert an image in the reporter itself <img src ="path of the ss" height =
		// 200 width = 200>
		Reporter.log(
				"<a href =\"C:\\Users\\HP\\IdeaProjects\\Selenium\\Screenshot\\Tue_Apr_27_17_09_29_IST_2021.jpg\" target = \"_blank\"><img src =\"C:\\Users\\HP\\IdeaProjects\\Selenium\\Screenshot\\Tue_Apr_27_17_09_29_IST_2021.jpg\" height = 200 width = 200 ></a>");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
