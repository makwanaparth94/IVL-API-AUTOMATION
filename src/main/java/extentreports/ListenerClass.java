package extentreports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class ListenerClass implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getDescription();
		//return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Before starting all tests, below method runs.
	public void onStart(ITestContext iTestContext) {
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
				+ "\nStart method : " + iTestContext.getName());
	}

	// After ending all tests, below method runs.
	public void onFinish(ITestContext iTestContext) {
		System.out.println("Finish method : " + iTestContext.getName()
		+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		// Do tier down operations for extentreports reporting!
		ExtentTestManager.endTest();
		ExtentReport.getInstance().flush();
	}

	public void onTestStart(ITestResult iTestResult) {
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
				+ "\nTestStart method : " + getTestMethodName(iTestResult) + " Under execution");
		// Start operation for extentreports.
		//ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
		ExtentTestManager.startTest(iTestResult.getMethod().getDescription(), "");		
	}

	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("TestSuccess method : " + getTestMethodName(iTestResult) + " Executed Successfully"
				+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		// Extentreports log operation for passed tests.
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("TestFailure method : " + getTestMethodName(iTestResult) + " Execution Failed"
				+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("TestSkipped method : " + getTestMethodName(iTestResult) + " Skipped"
				+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		// Extentreports log operation for skipped tests.
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

}