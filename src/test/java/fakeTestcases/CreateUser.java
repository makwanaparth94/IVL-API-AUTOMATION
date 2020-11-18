package fakeTestcases;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import baseTest.TestBase;
import extentreports.ExtentMethods;
import extentreports.ExtentReport;
import extentreports.ExtentTestManager;
import io.restassured.response.Response;
import services.FakeAPIService.FakeAPISetService;
import testbase.EndPoint;
import testbase.TestConfiguraionProperties;
import utilities.Util;

public class CreateUser extends TestBase{
	
	TestConfiguraionProperties config = new TestConfiguraionProperties();
	FakeAPISetService fakeService = new FakeAPISetService();
	Util utility  = new Util();
	ExtentReports report;
	ExtentTest test;
	
	//public static String unique_name= config.getUserName()+new Date().getTime();
	/*
	 * Method to create a single User
	 */
	public Map<String, String> createUser_SetUserData(StringBuilder randomName){
	
		//Adding request body data
		Map<String, String> setData = new HashMap<String, String>();
		setData.put("name",config.getUserName()+randomName);
		setData.put("job", config.getUserJob());
		return setData;
	}

	
	@Test(description ="Verify Creation of an User with valid inputs")
	public void createUser_validInputs() throws InterruptedException{
		
		//Set up test case description
		utility.setUP_TC_Description("Verify Creation of an User with valid inputs");
		
		String userid; 
		Object obj = createUser_SetUserData(utility.getRandomAlphanumericString());
	
		//Create User
		Response response = fakeService.createUser((Map) obj);
		//Logging an extent
		ExtentMethods.Extentlogs_POST_Request(((Map) obj), response, EndPoint.CREATE_USER,"Adding an User with valid inputs");
		try {
			Assert.assertEquals(response.getStatusCode(), 201);
			Assert.assertEquals(response.jsonPath().get("name").toString(), config.getUserName());
			Assert.assertEquals(response.jsonPath().get("job").toString(), config.getUserJob());
			userid = response.jsonPath().getString("id");
		}catch(AssertionError e) {
			ExtentMethods.Extentlogs_Error(e.getMessage());
			throw new AssertionError();
		}
		
		//Validate it with GET API
		System.out.println("USER ID IS :"+userid);
		response = fakeService.getUser(userid);
		//Logging an extent
		ExtentMethods.Extentlogs_GET_WithoutParam(response, EndPoint.GET_USER+"?user="+userid, "Validate created data by calling GET API");
		
		try {
			Assert.assertEquals(response.getStatusCode(), 200);
			List total_data = response.jsonPath().get("data");
			Assert.assertEquals(total_data.size(), 1);
			Assert.assertEquals(response.jsonPath().get("data[0].first_name").toString(), config.getUserName());
			
		}catch(AssertionError e) {
			ExtentMethods.Extentlogs_Error(e.getMessage());
			throw new AssertionError();
		}
		
	}
}
