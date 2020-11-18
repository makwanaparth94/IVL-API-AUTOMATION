package extentreports;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {

	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports getInstance() {
		if(extent == null) {
			extent = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\ExtentReporter.html",true,DisplayOrder.OLDEST_FIRST);
		}
		return extent;
	}
	
}
